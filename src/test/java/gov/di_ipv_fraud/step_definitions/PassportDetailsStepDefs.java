package gov.di_ipv_fraud.step_definitions;

import gov.di_ipv_fraud.pages.PassportDetailsPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;


public class PassportDetailsStepDefs extends PassportDetailsPageObject {

    @Given("A user is on Prove Your Identity page")
    public void navigateToProveIdentityPage() {
        proveIdentityPage();
    }

    /*(@Given("I navigate to the IPV Core Stub to add Passport")
    public void i_navigate_to_the_ipv_core_stub_to_add_passport() {

        navigateToIPVCoreStubToAddPassport();
    }*/

    @And(
            "A user fill in the passport details {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
    public void userEntersDetails(
            String passportNumber,
            String surname,
            String name,
            String birthDay,
            String birthMonth,
            String birthYear,
            String expiryDay,
            String expiryMonth,
            String expiryYear) {
        entersPassportDetails(
                passportNumber,
                surname,
                name,
                birthDay,
                birthMonth,
                birthYear,
                expiryDay,
                expiryMonth,
                expiryYear);
    }

    @Then("user sees DCS check is complete message")
    public void dcsCheckComplete() {
        dcsCompletionHeader();
    }

    @And("I navigate to User for Passport CRI dev Page")
    public void i_navigate_to_user_for_passport_cri_dev_page() {
        navigateToPassportCRIDev();
    }

    @And("^I enter number (.*) and click Go to Passport CRI Dev button$")
    public void i_enter_number_and_click_go_to_passport_cri_dev_button(String number) {
        GoToPassportCRIDevPage(number);
    }

}
