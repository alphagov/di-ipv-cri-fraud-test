package gov.di_ipv_fraud.step_definitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.di_ipv_fraud.pages.*;
import gov.di_ipv_fraud.utilities.BrowserUtils;
import gov.di_ipv_fraud.utilities.DrivingLicenceSubject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class DVLADrivingLicenceSteps extends DrivingLicencePageObject  {

    @When("User enters data as a {}")
    public void user_enters_and(DrivingLicenceSubject drivingLicenceSubject) {
        userEntersData(drivingLicenceSubject);
    }

    @When("User clicks on continue")
    public void user_clicks_on_continue() {
        Continue.click();
    }

    @Then("Proper error message for Could not find DVLA details is displayed")
    public void properErrorMessageForCouldNotFindDVLADetailsIsDisplayed() {
        couldNotFindDetailsDVLAErrorDisplayed();
    }

    @Then("proper error message for invalid Date of Birth should be displayed")
    public void properErrorMessageForInvalidDOBIsDisplayed() {
        invalidDOBErrorDisplayed();
    }

    @Then("proper error message for invalid Driving Licence should be displayed")
    public void properErrorMessageForInvalidDrivingLicenceIsDisplayed() {
        invalidDrivingLicenceErrorDisplayed();
    }

    @Given("User enters invalid Driving Licence DVLA details")
    public void userInputsInvalidDrivingDetails() {
        userEntersInvalidDrivingDetails();
    }

    @When("User Re-enters data as a {}")
    public void userReInputsDataAsADrivingLicenceSubject(DrivingLicenceSubject drivingLicenceSubject) {
        userReEntersDataAsADrivingLicenceSubject(drivingLicenceSubject);
    }

    @Given("User click on ‘prove your identity another way' Link")
    public void userClickOnProveYourIdentityAnotherWayLink() {
        proveanotherway.click();
    }

    @When("User click on I do not have a UK driving licence radio button")
    public void selectIDoNotHaveAUKDrivingLicenceRadioButton() {
        clickOnIDoNotHaveAUKDrivingLicenceRadioButton();
    }

    @Then("I should be on `Enter your details exactly as they appear on your UK driving licence` page")
    public void i_should_be_on_enter_your_details_exactly_as_they_appear_on_your_uk_driving_licence_page() {
        Assert.assertTrue(new EnterYourDetailsExactlyDVLAPage().drivingLicenceNumber.isDisplayed());
    }

    @Then("I should be on `Who was your UK driving licence issued by` page")
    public void i_should_be_on_who_was_your_uk_driving_licence_issued_by_page() {
        Assert.assertTrue(new EnterYourDetailsExactlyDVLAPage().DVLALabel.isDisplayed());
    }

    @And("^JSON payload should contain ci (.*), validity score (.*) and strength score (.*)$")
    public void contraIndicatorInVerifiableCredential(String ci, String validityScore, String strengthScore) throws IOException {
        new FraudPageObject().ciInVC(ci);
        scoreIs(validityScore, strengthScore);
    }

    @And("^JSON payload should contain validity score (.*) and strength score (.*)$")
    public void scoresInVerifiableCredential(String validityScore, String strengthScore) throws IOException {
        scoreIs(validityScore, strengthScore);
    }

}