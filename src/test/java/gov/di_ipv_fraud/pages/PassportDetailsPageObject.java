package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.service.ConfigurationService;
import gov.di_ipv_fraud.utilities.ConfigurationReader;
import gov.di_ipv_fraud.utilities.Driver;
import gov.di_ipv_fraud.utilities.PassportAPIGlobals;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import software.amazon.lambda.powertools.parameters.ParamManager;


public class PassportDetailsPageObject extends UniversalSteps {

    private final PassportAPIGlobals passportAPIGlobals;

    @FindBy(id = "passportNumber")
    public WebElement passportNumberField;
    @FindBy(id = "surname")
    public WebElement surnameField;
    @FindBy(id = "givenNames")
    public WebElement firstName;
    @FindBy(id = "dateOfBirth-day")
    public WebElement birthDayField;
    @FindBy(id = "dateOfBirth-month")
    public WebElement birthMonthField;
    @FindBy(id = "dateOfBirth-year")
    public WebElement birthYearField;
    @FindBy(id = "expiryDate-day")
    public WebElement passportExpiryDayField;
    @FindBy(id = "expiryDate-month")
    public WebElement passportExpiryMonthField;
    @FindBy(id = "expiryDate-year")
    public WebElement passportExpiryYearField;
    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement continueButton;
    @FindBy(id = "header")
    public WebElement dcsCheckIsComplete;

    public PassportDetailsPageObject() {
        passportAPIGlobals = new PassportAPIGlobals();
        PageFactory.initElements(Driver.get(), this);
    }

    public void proveIdentityPage() {
        Driver.get().get(passportAPIGlobals.passportAuthUrl);
        waitForFiveSeconds();
    }

    public void entersPassportDetails(String passportNumber, String surname, String name, String birthDay, String birthMonth, String birthYear, String expiryDay, String expiryMonth, String expiryYear) {
        passportNumberField.sendKeys(passportNumber);
        surnameField.sendKeys(surname);
        firstName.sendKeys(name);
        birthDayField.sendKeys(birthDay);
        birthMonthField.sendKeys(birthMonth);
        birthYearField.sendKeys(birthYear);
        passportExpiryDayField.sendKeys(expiryDay);
        passportExpiryMonthField.sendKeys(expiryMonth);
        passportExpiryYearField.sendKeys(expiryYear);
        continueButton.click();

    }

    public void dcsCompletionHeader() {
        Assert.assertTrue(dcsCheckIsComplete.isDisplayed());
    }


}
