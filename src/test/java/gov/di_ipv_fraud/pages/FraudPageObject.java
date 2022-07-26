package gov.di_ipv_fraud.pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.di_ipv_fraud.service.ConfigurationService;
import gov.di_ipv_fraud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.logging.Logger;

import static gov.di_ipv_fraud.pages.Headers.CHECKING_YOUR_DETAILS;
import static gov.di_ipv_fraud.pages.Headers.IPV_CORE_STUB;

public class FraudPageObject extends UniversalSteps {

    private final ConfigurationService configurationService;
    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a/button")
    public WebElement visitCredentialIssuers;

    public static final String IPV_CORE_STUB_ENDPOINT = "ipvCoreStubEndpoint";

    @FindBy(xpath = "//*[@id=\"main-content\"]/p[7]/a/input")
    public WebElement fraudCRIBuild;

    @FindBy(xpath = "//*[@id=\"main-content\"]/p[8]/a/input")
    public WebElement fraudCRIStaging;

    @FindBy(id = "rowNumber")
    public WebElement selectRow;

    @FindBy(xpath = "//*[@id=\"main-content\"]/p[9]/a/input")
    public WebElement fraudCRIIntegration;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/button")
    public WebElement checkYourDetailsContinue;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/summary/span")
    public WebElement viewResponse;

    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/details/summary/span")
    public WebElement whoWeCheckLink;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/details/div/p[1]/a")
    public WebElement experianLink;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/details/div/p[2]/a")
    public WebElement privacyPolicyLink;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details")
    public WebElement errorResponse;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@class=\"govuk-heading-l\"]")
    public WebElement title;

    @FindBy(id = "name")
    public WebElement usersearchField;

    @FindBy(xpath = "//*[@class=\"govuk-button\"]")
    public WebElement usersearchButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/table/tbody/tr/td[1]/p[1]/a")
    public WebElement fraudCRILink;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/div/pre")
    public WebElement JSONPayload;

    @FindBy(xpath = "//*[@id=\"main-content\"]/table/tbody/tr/td[1]/p[2]/a")
    public WebElement editUserLink;

    @FindBy(id = "buildingName")
    public WebElement housenameField;

    @FindBy(xpath = "//*[@class=\"govuk-button button\"]")
    public WebElement fraudCRIButton;

    @FindBy(id = "buildingNumber")
    public WebElement housenumberField;

    @FindBy(xpath = "//*[@class=\"govuk-heading-xl\"]")
    public WebElement pagetTitle;

    public FraudPageObject() {
        this.configurationService = new ConfigurationService(System.getenv("ENVIRONMENT"));
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToIPVCoreStub() {
        String coreStubUsername = configurationService.getCoreStubUsername();
        String coreStubPassword = configurationService.getCoreStubPassword();
        String coreStubUrl = configurationService.getCoreStubUrl();
        Driver.get()
                .get("https://" + coreStubUsername + ":" + coreStubPassword + "@" + coreStubUrl);
        waitForTextToAppear(IPV_CORE_STUB);
    }

    public void navigateToFraudCRI(String environment) {
        visitCredentialIssuers.click();
        assertURLContains("credential-issuers");

        switch (environment) {
            case "Build":
                fraudCRIBuild.click();
                break;

            case "Staging":
                fraudCRIStaging.click();
                break;

            case "Integration":
                fraudCRIIntegration.click();
                break;

            default:
                break;
        }
    }

    public void searchForUATUser(String number) {
        assertURLContains("credential-issuer?cri=fraud-cri");
        selectRow.sendKeys(number);
        searchButton.click();
    }

    public void navigateToResponse(String validOrInvalid) {
        waitForTextToAppear(CHECKING_YOUR_DETAILS);
        checkYourDetailsContinue.click();
        assertURLContains("callback");
        if ("Invalid".equalsIgnoreCase(validOrInvalid)) {
            errorResponse.click();
        } else {
            viewResponse.click();
        }
    }

    public void whoWeCheckDetailsWith(String page) {
        waitForTextToAppear(CHECKING_YOUR_DETAILS);
        whoWeCheckLink.click();

        if ("Experian".equalsIgnoreCase(page)) {
            experianLink.click();
            ArrayList<String> newTb = new ArrayList<String>(Driver.get().getWindowHandles());
            Driver.get().switchTo().window(newTb.get(1));
            assertURLContains("https://www.experian.co.uk/");
            Driver.get().close();
            Driver.get().switchTo().window(newTb.get(0));

        } else {
            privacyPolicyLink.click();
            ArrayList<String> newTb = new ArrayList<String>(Driver.get().getWindowHandles());
            Driver.get().switchTo().window(newTb.get(1));
            assertURLContains("privacy-notice");
            Driver.get().close();
            Driver.get().switchTo().window(newTb.get(0));
        }
    }

    public void userSearchByName(String username) {
        assertURLContains("credential-issuer?cri=fraud-cri");
        usersearchField.sendKeys(username);
        usersearchButton.click();
    }

    public void goTofraudCRILink() {
        fraudCRILink.click();
    }

    public void userNameInJsonResponse() throws JsonProcessingException {
        String result = JSONPayload.getText();
        LOGGER.info("result = " + result);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        JsonNode vcNode = jsonNode.get("vc");
        JsonNode nameNode = vcNode.get("credentialSubject");
        JsonNode insideName = nameNode.get("name");
        JsonNode nameContent = insideName.get(0);
        LOGGER.info("nameContent = " + nameContent);
    }

    public void jsonErrorResponse(String testStatusCode) throws JsonProcessingException {
        String testErrorDescription = "general error";
        String result = JSONPayload.getText();
        LOGGER.info("result = " + result);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        JsonNode insideError = jsonNode.get("errorObject");
        LOGGER.info("insideError = " + insideError);
        JsonNode errorDescription = insideError.get("description");
        JsonNode statusCode = insideError.get("httpstatusCode");
        String ActualErrorDescription = insideError.get("description").asText();
        String ActualStatusCode = insideError.get("httpstatusCode").asText();
        LOGGER.info("errorDescription = " + errorDescription);
        LOGGER.info("statusCode = " + statusCode);
        LOGGER.info("testErrorDescription = " + testErrorDescription);
        LOGGER.info("testStatusCode = " + testStatusCode);
        Assert.assertEquals(testErrorDescription, ActualErrorDescription);
        Assert.assertEquals(testStatusCode, ActualStatusCode);
    }

    public void goToPage(String page) {
        waitForTextToAppear(page);
    }

    public void clickContinue() {
        continueButton.isEnabled();
        continueButton.click();
    }

    public void goToResponse(String validOrInvalid) {
        assertURLContains("callback");
        if ("Invalid".equalsIgnoreCase(validOrInvalid)) {
            errorResponse.click();
        } else {
            viewResponse.click();
        }
    }

    public void goToVerifiableCredentialsPage() {
        title.getText();
    }

    public void goToEditUserLink() {
        editUserLink.click();
    }

    public void addHouseName(String housename) {
        housenameField.sendKeys(housename);
    }

    public void clearHouseNumber() {
        housenumberField.clear();
    }

    public void addHouseNumber(String housenumber) {
        housenumberField.sendKeys(housenumber);
        fraudCRIButton.click();
    }

    public void userAddressInJsonResponse(String testHouseName) throws JsonProcessingException {
        String testHouseNumber = "455";
        String result = JSONPayload.getText();
        LOGGER.info("result = " + result);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        JsonNode vcNode = jsonNode.get("vc");
        JsonNode addressNode = vcNode.get("credentialSubject");
        JsonNode insideAddress = addressNode.get("address");
        JsonNode addressContent = insideAddress.get(0);
        LOGGER.info("addressContent = " + addressContent);
        JsonNode houseName = addressContent.get("buildingName");
        JsonNode houseNumber = addressContent.get("buildingNumber");
        String ActualHouseName = addressContent.get("buildingName").asText();
        String ActualHouseNumber = addressContent.get("buildingNumber").asText();
        LOGGER.info("houseName = " + houseName);
        LOGGER.info("houseNumber = " + houseNumber);
        LOGGER.info("testHouseName = " + testHouseName);
        LOGGER.info("testHouseNumber = " + testHouseNumber);
        Assert.assertEquals(testHouseName, ActualHouseName);
        Assert.assertEquals(testHouseNumber, ActualHouseNumber);
    }
    public void goToPageWithTitle(String title) {
        pagetTitle.getText();
    }

}