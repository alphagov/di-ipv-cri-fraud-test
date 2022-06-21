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

    @And("I click the Fraud CRI Integration option")
    public void navigateToFraud() {
        navigateToFraudCRI();
    }

    @Then("^I search for user number (.*) in the Experian table$")
    public void userSearch(String number) {
        searchForUATUser(number);
    }


}
