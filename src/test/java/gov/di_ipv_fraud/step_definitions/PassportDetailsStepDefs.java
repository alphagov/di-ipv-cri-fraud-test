package gov.di_ipv_fraud.step_definitions;

import gov.di_ipv_fraud.pages.PassportDetailsPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PassportDetailsStepDefs extends PassportDetailsPageObject {


    @Given("A user is on Prove Your Identity page")
    public void navigateToProveIdentityPage() {
        proveIdentityPage();
    }

    @When("A user enters {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
    public void userEntersDetails(String passportNumber, String surname, String name, String birthDay, String birthMonth, String birthYear, String expiryDay, String expiryMonth, String expiryYear) {
        entersPassportDetails(passportNumber, surname, name, birthDay, birthMonth, birthYear, expiryDay, expiryMonth, expiryYear);
    }

    @Then("user sees DCS check is complete message")
    public void dcsCheckComplete() {
        dcsCompletionHeader();
    }
}

