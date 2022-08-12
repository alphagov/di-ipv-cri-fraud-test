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
import java.util.List;
import java.util.Map;

import static gov.di_ipv_fraud.pages.Headers.CHECKING_YOUR_DETAILS;
import static gov.di_ipv_fraud.pages.Headers.ORCHESTRATOR_STUB;

public class ProveYourIdentityFullJourneyPageObject extends UniversalSteps {

    private final ConfigurationService configurationService;
    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

    @FindBy(xpath = "//*[@value=\"Full journey route\"]")
    public WebElement fullJourneyRouteButton;

    public static final String IPV_CORE_STUB_ENDPOINT = "ipvCoreStubEndpoint";
    @FindBy(id = "submitButton")
    public WebElement continueSubmitButton;
    @FindBy(id = "passportNumber")
    public WebElement passportNumberField;
    @FindBy(id = "surname")
    public WebElement surnameField;
    @FindBy(id = "firstName")
    public WebElement firstnameField;
    @FindBy(id = "dateOfBirth-day")
    public WebElement dayOfBirthField;
    @FindBy(id = "dateOfBirth-month")
    public WebElement monthOfBirthField;
    @FindBy(id = "dateOfBirth-year")
    public WebElement yearOfBirthField;
    @FindBy(id = "expiryDate-day")
    public WebElement dayOfExpiryField;
    @FindBy(id = "expiryDate-month")
    public WebElement monthOfExpiryField;
    @FindBy(id = "expiryDate-year")
    public WebElement yearOfExpiryField;
    @FindBy(id = "addressSearch")
    public WebElement postcodeField;
    @FindBy(id = "continue")
    public WebElement continueButton;

    public ProveYourIdentityFullJourneyPageObject() {
        this.configurationService = new ConfigurationService(System.getenv("ENVIRONMENT"));
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToOrchestratorStub() {

        String orchestratorStubUrl = configurationService.getOrchestratorStubUrl();
        Driver.get().get(orchestratorStubUrl);
        waitForTextToAppear(ORCHESTRATOR_STUB);
    }

    public void clickOnFullJourneyRouteButton() {
        fullJourneyRouteButton.click();
    }

    public void selectContinueButton() {
        continueSubmitButton.click();
    }

    public void addPassportDetails(List<Map<String, String>> passportDetails) {
        passportNumberField.sendKeys(passportDetails.get(0).get("Passport number"));
        surnameField.sendKeys(passportDetails.get(0).get("Surname"));
        firstnameField.sendKeys(passportDetails.get(0).get("First name"));
    }

    public void addDateOfBirth(String day, String month, String year) {
        dayOfBirthField.sendKeys(day);
        monthOfBirthField.sendKeys(month);
        yearOfBirthField.sendKeys(year);
    }

    public void addPassportExpiryDate(String day, String month, String year) {
        dayOfExpiryField.sendKeys(day);
        monthOfExpiryField.sendKeys(month);
        yearOfExpiryField.sendKeys(year);
        continueSubmitButton.click();
    }

    public void addPostcode(String housename) {
        postcodeField.sendKeys(housename);
        continueButton.click();
    }

}