package gov.di_ipv_fraud.step_definitions;

import gov.di_ipv_fraud.pages.FraudPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

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

    @And("I navigate to the verifiable issuer to check the response from experian")
    public void navigateToVerifiableIssuer() {
        navigateToResponse();
    }

    @Then("^I navigate to (.*) and assert I have been directed correctly$")
    public void experianOrPrivacyPolicy(String page) {
        whoWeCheckDetailsWith(page);
    }


}
