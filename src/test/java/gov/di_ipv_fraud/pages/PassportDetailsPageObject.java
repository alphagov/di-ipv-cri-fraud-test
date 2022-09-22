package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.service.ConfigurationService;
import gov.di_ipv_fraud.utilities.BrowserUtils;
import gov.di_ipv_fraud.utilities.Driver;
import gov.di_ipv_fraud.utilities.PassportAPIGlobals;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static gov.di_ipv_fraud.pages.Headers.IPV_CORE_STUB;

public class PassportDetailsPageObject extends UniversalSteps {

    private final PassportAPIGlobals passportAPIGlobals;

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a")
    public WebElement VisitCredentialIssuers;

    @FindBy(xpath = "//*[@id=\"main-content\"]/p[4]/a")
    public WebElement PassportCRIDevButton;

    @FindBy(id = "rowNumber")
    public WebElement selectRow;

    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement PassportCRIDevPageButton;

    @FindBy(id = "passportNumber")
    public WebElement passportNumberField;

    @FindBy(id = "surname")
    public WebElement surnameField;

    @FindBy(id = "givenNames")
    public WebElement firstName;

    @FindBy(id = "firstName")
    public WebElement givenNameField;

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

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/summary/span")
    public WebElement CRIDevResponseButton;

    private ConfigurationService configurationService;

    public PassportDetailsPageObject() {
        passportAPIGlobals = new PassportAPIGlobals();
        PageFactory.initElements(Driver.get(), this);
    }

    public void proveIdentityPage() {
        Driver.get().get(passportAPIGlobals.passportAuthUrl);
        waitForFiveSeconds();
    }

    public void navigateToPassportCRIDev() {
        VisitCredentialIssuers.click();
        PassportCRIDevButton.click();
    }

    public void GoToPassportCRIDevPage(String number) {
        selectRow.sendKeys(number);
        PassportCRIDevPageButton.click();
        BrowserUtils.waitForPageToLoad(100);
    }

    public void entersPassportDetails(
            String passportNumber,
            String surname,
            String name,
            String birthDay,
            String birthMonth,
            String birthYear,
            String expiryDay,
            String expiryMonth,
            String expiryYear) {
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

    public void userEntersThePassportDetails(
            String passportNumber,
            String surname,
            String givenName,
            String birthDay,
            String birthMonth,
            String birthYear,
            String expiryDay,
            String expiryMonth,
            String expiryYear) {
        passportNumberField.sendKeys(passportNumber);
        surnameField.sendKeys(surname);
        givenNameField.sendKeys(givenName);
        birthDayField.sendKeys(birthDay);
        birthMonthField.sendKeys(birthMonth);
        birthYearField.sendKeys(birthYear);
        passportExpiryDayField.sendKeys(expiryDay);
        passportExpiryMonthField.sendKeys(expiryMonth);
        passportExpiryYearField.sendKeys(expiryYear);
        continueButton.click();
    }
    public void PassportCRIDev() {
        CRIDevResponseButton.click();
    }
}


