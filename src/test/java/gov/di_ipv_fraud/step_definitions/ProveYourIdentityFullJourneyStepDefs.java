package gov.di_ipv_fraud.step_definitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.di_ipv_fraud.pages.FraudPageObject;
import gov.di_ipv_fraud.pages.ProveYourIdentityFullJourneyPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ProveYourIdentityFullJourneyStepDefs extends ProveYourIdentityFullJourneyPageObject {

    FraudPageObject fraudPage;
    @Given("I navigate to the Orchestrator Stub")
    public void goToOrchestratorStub() {
        navigateToOrchestratorStub();
    }

    @And("^I click on Full journey route and Continue$")
    public void clickOnFullJourneyRoute() {
        clickOnFullJourneyRouteButton();
        selectContinueButton();
    }
    @And("^I enter Passport Details$")
    public void enterPassportDetails(List<Map<String, String>> passportDetails) {
        addPassportDetails(passportDetails);
    }
    @And("^I enter Date of birth as (.*)/(.*)/(.*)$")
    public void enterDateOfBirth(String day, String month, String year) {
        addDateOfBirth(day, month, year);
    }

    @And("^I enter Passport Expiry date as (.*)/(.*)/(.*) and Continue$")
    public void enterPassportExpiryDate(String day, String month, String year) {
        addPassportExpiryDate(day, month, year);
    }
    @And("^I enter (.*) in the Postcode field and find address$")
    public void enterPostcode(String postcode) {
        addPostcode(postcode);
    }
}