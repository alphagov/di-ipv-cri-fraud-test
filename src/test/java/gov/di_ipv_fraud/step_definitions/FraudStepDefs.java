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


    @And("^I click on Edit User link$")
    public void i_click_on_go_to_edit_user_link() {
        goToEditUserLink();
    }

    @And("^I remove the postcode$")
    public void i_remove_the_postcode() {
        clearPostcode();
    }

    @And("^I remove the house number$")
    public void i_remove_the_house_number() {
        clearHouseNumber();
    }

    @And("^I click on Go to Fraud CRI link after Edit$")
    public void iClickOnGoToFraudCRILinkAfterEdit() {
        goTofraudCRILinkAfterEdit();
    }

    @And("^I Navigate to page There is a problem$")
    public void i_check_there_is_a_problem_page() {
        goToPageThereIsAProblemHeader();
    }


    @And("^I see message No Matches message$")
    public void i_see_no_matches_message() {
        NoMatchesMessageText();
    }
    @Then("^I click GOV.UK in the menu$")
    public void i_click_gov_uk_in_the_top_menu() {
        GotoGOVUKHeader();

    }

    @And("^I check it navigate to Core$")
    public void i_check_it_navigate_to_core() {
        IPVCoreSTUB();

    }



}