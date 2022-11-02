package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.utilities.BrowserUtils;
import gov.di_ipv_fraud.utilities.DVADrivingLicenceSubject;
import gov.di_ipv_fraud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DVAEnterYourDetailsExactlyPage {
    public DVAEnterYourDetailsExactlyPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "surname")
    public WebElement Lastname;

    @FindBy(id = "firstName")
    public WebElement Firstname;

    @FindBy(id = "dvaDateOfBirth-day")
    public WebElement DayOfBirth;

    @FindBy(id = "dvaDateOfBirth-month")
    public WebElement MonthOfBirth;

    @FindBy(id = "dvaDateOfBirth-year")
    public WebElement YearOfBirth;

    @FindBy(id = "expiryDate-day")
    public WebElement LicenceValidToDay;

    @FindBy(id = "expiryDate-month")
    public WebElement LicenceValidToMonth;

    @FindBy(id = "expiryDate-year")
    public WebElement LicenceValidToYear;

    @FindBy(id = "dateOfIssue-day")
    public WebElement LicenceIssueDay;

    @FindBy(id = "dateOfIssue-month")
    public WebElement LicenceIssueMonth;

    @FindBy(id = "dateOfIssue-year")
    public WebElement LicenceIssueYear;

    @FindBy(id = "postcode")
    public WebElement Postcode;

    @FindBy(id = "dvaLicenceNumber")
    public WebElement dvaLicenceNumber;

    public void userEntersDVAData(DVADrivingLicenceSubject dvaDrivingLicenceSubject) {
        dvaLicenceNumber.sendKeys(dvaDrivingLicenceSubject.getDVAlicenceNumber());
        Lastname.sendKeys(dvaDrivingLicenceSubject.getlastName());
        Firstname.sendKeys(dvaDrivingLicenceSubject.getfirstName());
        DayOfBirth.sendKeys(dvaDrivingLicenceSubject.getbirthDay());
        MonthOfBirth.sendKeys(dvaDrivingLicenceSubject.getbirthMonth());
        YearOfBirth.sendKeys(dvaDrivingLicenceSubject.getbirthYear());
        LicenceValidToDay.sendKeys(dvaDrivingLicenceSubject.getvalidtoDay());
        LicenceValidToMonth.sendKeys(dvaDrivingLicenceSubject.getvalidtoMonth());
        LicenceValidToYear.sendKeys(dvaDrivingLicenceSubject.getvalidtoYear());
        LicenceIssueDay.sendKeys(dvaDrivingLicenceSubject.getlicenceIssueDay());
        LicenceIssueMonth.sendKeys(dvaDrivingLicenceSubject.getlicenceIssueMonth());
        LicenceIssueYear.sendKeys(dvaDrivingLicenceSubject.getlicenceIssueYear());
        Postcode.sendKeys(dvaDrivingLicenceSubject.getpostcode());
    }

    public void userEntersInvalidDVADrivingDetails() {
        dvaLicenceNumber.sendKeys("11110610");
        Lastname.sendKeys("Testlastname");
        Firstname.sendKeys("Testfirstname");
        DayOfBirth.sendKeys("11");
        MonthOfBirth.sendKeys("10");
        YearOfBirth.sendKeys("1962");
        LicenceValidToDay.sendKeys("01");
        LicenceValidToMonth.sendKeys("01");
        LicenceValidToYear.sendKeys("2030");
        LicenceIssueDay.sendKeys("10");
        LicenceIssueMonth.sendKeys("12");
        LicenceIssueYear.sendKeys("1970");
        Postcode.sendKeys("BS98 1AA");
        BrowserUtils.waitFor(3);
        BrowserUtils.waitForPageToLoad(10);
    }

    public void userReEntersDataAsDVADrivingLicenceSubject(DVADrivingLicenceSubject dvaDrivingLicenceSubject) {
        dvaLicenceNumber.clear();
        Lastname.clear();
        Firstname.clear();
        DayOfBirth.clear();
        MonthOfBirth.clear();
        YearOfBirth.clear();
        LicenceValidToDay.clear();
        LicenceValidToMonth.clear();
        LicenceValidToYear.clear();
        LicenceIssueDay.clear();
        LicenceIssueMonth.clear();
        LicenceIssueYear.clear();
        Postcode.clear();
        dvaLicenceNumber.sendKeys(dvaDrivingLicenceSubject.getDVAlicenceNumber());
        Lastname.sendKeys(dvaDrivingLicenceSubject.getlastName());
        Firstname.sendKeys(dvaDrivingLicenceSubject.getfirstName());
        DayOfBirth.sendKeys(dvaDrivingLicenceSubject.getbirthDay());
        MonthOfBirth.sendKeys(dvaDrivingLicenceSubject.getbirthMonth());
        YearOfBirth.sendKeys(dvaDrivingLicenceSubject.getbirthYear());
        LicenceValidToDay.sendKeys(dvaDrivingLicenceSubject.getvalidtoDay());
        LicenceValidToMonth.sendKeys(dvaDrivingLicenceSubject.getvalidtoMonth());
        LicenceValidToYear.sendKeys(dvaDrivingLicenceSubject.getvalidtoYear());
        LicenceIssueDay.sendKeys(dvaDrivingLicenceSubject.getlicenceIssueDay());
        LicenceIssueMonth.sendKeys(dvaDrivingLicenceSubject.getlicenceIssueMonth());
        LicenceIssueYear.sendKeys(dvaDrivingLicenceSubject.getlicenceIssueYear());
        Postcode.sendKeys(dvaDrivingLicenceSubject.getpostcode());
    }

}