package gov.di_ipv_fraud.step_definitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.di_ipv_fraud.pages.FraudPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FraudStepDefs extends FraudPageObject {

    @Given("I navigate to the IPV Core Stub")
    public void navigateToStub() {
        navigateToIPVCoreStub();
    }

    @And("^I click the Fraud CRI for the (.*) environment$")
    public void navigateToFraud(String environment) {
        navigateToFraudCRI(environment);
    }

    @Then("^I search for user number (.*) in the Experian table$")
    public void userSearch(String number) {
        searchForUATUser(number);
    }

    @And("^I navigate to the verifiable issuer to check for a (.*) response from experian$")
    public void navigateToVerifiableIssuer(String validOrInvalid) {
        navigateToResponse(validOrInvalid);
    }

    @Then("^I navigate to (.*) and assert I have been directed correctly$")
    public void experianOrPrivacyPolicy(String page) {
        whoWeCheckDetailsWith(page);
    }

    @When("^I search for user name (.*) in the Experian table$")
    public void userSearchByUserName(String username) {
        userSearchByName(username);
    }

    @Then("^I click on Go to Fraud CRI link$")
    public void navigateToFraudCRILink() {
        goTofraudCRILink();
    }

    @And("JSON payload should contain user's name")
    public void userNameInJsonPayload() throws JsonProcessingException {
        userNameInJsonResponse();
    }

    @And("^JSON response should contain error details and status code as (.*)$")
    public void errorInJsonResponse(String testStatusCode) throws JsonProcessingException {
        jsonErrorResponse(testStatusCode);
    }

    @And("^I navigate to the page (.*)$")
    public void navigateToPage(String page) {
        goToPage(page);
    }

    @When("^I check Continue button is enabled and click on the Continue button$")
    public void clickOnContinueButton() {
        clickContinue();
    }

    @Then("^I navigate to Verifiable Credentials page$")
    public void navigateToVerifiableCredentialsPage() {
        goToVerifiableCredentialsPage();
    }

    @And("^I check for a (.*) response from experian")
    public void navigateToVerifiableCredentials(String validOrInvalid) {
        goToResponse(validOrInvalid);
    }

    @When("^I click on Edit User link$")
    public void navigateToEditUserLink() {
        goToEditUserLink();
    }

    @And("^I enter (.*) in the House name field$")
    public void enterHouseName(String housename) {
        addHouseName(housename);
    }

    @And("^JSON payload should contain user's address details and House name as (.*)$")
    public void userAddressInJsonPayload(String testHouseName) throws JsonProcessingException {
        userAddressInJsonResponse(testHouseName);
    }

    @And("^I clear existing House number$")
    public void clearExistingHouseNumber() {
        clearHouseNumber();
    }

    @And("^I enter (.*) in the House number field$")
    public void enterHouseNumber(String housenumber) {
        addHouseNumber(housenumber);
    }

    @And("^I am on (.*) page$")
    public void navigateToPageWithTitle(String title) {
        goToPageWithTitle(title);
    }

}