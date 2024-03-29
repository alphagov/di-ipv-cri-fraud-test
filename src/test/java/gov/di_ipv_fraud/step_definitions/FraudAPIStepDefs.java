package gov.di_ipv_fraud.step_definitions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudAPIStepDefs {
    private static String SESSION_REQUEST_BODY;
    private static String SESSION_ID;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final int LindaDuffExperianRowNumber = 6;
    private static final Logger LOGGER = Logger.getLogger(FraudAPIStepDefs.class.getName());

    @Given("user has the user identity in the form of a signed JWT string for CRI Id (.*)$")
    public void user_has_the_user_identity_in_the_form_of_a_signed_jwt_string(String criId)
            throws URISyntaxException, IOException, InterruptedException {
        String coreStubUrl = System.getenv("coreStubUrl");
        LOGGER.info("STUB URL = " + coreStubUrl);
        if (coreStubUrl == null) {
            throw new IllegalArgumentException("Environment variable IPV_CORE_STUB_URL is not set");
        }

        String jsonString = getClaimsForUser(coreStubUrl, criId, LindaDuffExperianRowNumber);
        SESSION_REQUEST_BODY = createRequest(coreStubUrl, criId, jsonString);
        LOGGER.info("SESSION_REQUEST_BODY = " + SESSION_REQUEST_BODY);
    }

    @When("user sends a POST request to session end point in (.*) environment$")
    public void user_sends_a_post_request_to_session_end_point(String env)
            throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        LOGGER.info("getPrivateAPIEndpoint() ==> " + getPrivateAPIEndpoint(env));
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(getPrivateAPIEndpoint(env) + "/session"))
                        .setHeader("Accept", "application/json")
                        .setHeader("Content-Type", "application/json")
                        //                        .setHeader("X-Forwarded-For", "192.168.0.1")
                        .POST(HttpRequest.BodyPublishers.ofString(SESSION_REQUEST_BODY))
                        .build();
        String sessionResponse = sendHttpRequest(request).body();
        LOGGER.info("sessionResponse = " + sessionResponse);
        Map<String, String> deserialisedResponse =
                objectMapper.readValue(sessionResponse, new TypeReference<>() {});
        SESSION_ID = deserialisedResponse.get("session_id");
    }

    @Then("user gets a session-id")
    public void user_gets_a_session_id() {
        LOGGER.info("SESSION_ID = " + SESSION_ID);
        assertTrue(StringUtils.isNotBlank(SESSION_ID));
    }

    private String getPrivateAPIEndpoint(String env) {
        String privateAPIEndpoint = System.getenv("apiGatewayIdPrivate");
        if (privateAPIEndpoint == null) {
            throw new IllegalArgumentException(
                    "Environment variable PRIVATE API endpoint is not set");
        }
        LOGGER.info("privateAPIEndpoint =>" + privateAPIEndpoint);
        return "https://" + privateAPIEndpoint + ".execute-api.eu-west-2.amazonaws.com/" + env;
    }

    private String getClaimsForUser(String baseUrl, String criId, int userDataRowNumber)
            throws URISyntaxException, IOException, InterruptedException {
        var url =
                new URI(
                        baseUrl
                                + "backend/generateInitialClaimsSet?cri="
                                + criId
                                + "&rowNumber="
                                + userDataRowNumber);

        LOGGER.info("URL =>> " + url);

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(url)
                        .GET()
                        .setHeader(
                                "Authorization",
                                getBasicAuthenticationHeader(
                                        System.getenv("coreStubUsername"),
                                        System.getenv("coreStubPassword")))
                        .build();
        return sendHttpRequest(request).body();
    }

    private String createRequest(String baseUrl, String criId, String jsonString)
            throws URISyntaxException, IOException, InterruptedException {

        URI uri = new URI(baseUrl + "backend/createSessionRequest?cri=" + criId);
        LOGGER.info("jsonString = " + jsonString);
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(uri)
                        .setHeader("Accept", "application/json")
                        .setHeader("Content-Type", "application/json")
                        .setHeader(
                                "Authorization",
                                getBasicAuthenticationHeader(
                                        System.getenv("coreStubUsername"),
                                        System.getenv("coreStubPassword")))
                        .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                        .build();

        return sendHttpRequest(request).body();
    }

    private HttpResponse<String> sendHttpRequest(HttpRequest request)
            throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
