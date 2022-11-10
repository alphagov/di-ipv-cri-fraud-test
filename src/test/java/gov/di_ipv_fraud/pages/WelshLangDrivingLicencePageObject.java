package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.di_ipv_fraud.utilities.DrivingLicenceSubject;

import java.util.logging.Logger;

public class WelshLangDrivingLicencePageObject extends UniversalSteps {

    private static final Logger LOGGER = Logger.getLogger(WelshLangDrivingLicencePageObject.class.getName());

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a/button")
    public WebElement visitCredentialIssuers;

    @FindBy(xpath = "//*[@value=\"Driving Licence CRI Build\"]")
    public WebElement drivingLicenceCDRIBuild;

    @FindBy(xpath = "//*[@value=\"Driving Licence CRI Staging\"]")
    public WebElement drivingLicenceCDRIStaging;

    @FindBy(xpath = "//*[@value=\"Driving Licence CRI Integration\"]")
    public WebElement drivingLicenceCDRIIntegration;

    @FindBy(xpath = "//*[@id=\"licenceIssuerRadio-fieldset\"]/div/div[3]")
    public WebElement orAsNeu;

    @FindBy(xpath = "//*[@id=\"header\"]")
    public WebElement dvlaPageHeadingWelsh;

    @FindBy(xpath = "/html/body/div[2]/div/p/strong")
    public WebElement betaBannerWelsh;

    @FindBy(xpath = "//*[@id=\"error-summary-title\"]")
    public WebElement thereIsaProblemText;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/ul/li[1]/a")
    public WebElement invlidDOBErrorText;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/ul/li[2]/a")
    public WebElement invlidDLErrorText;

    @FindBy(xpath = "//*[@id=\"surname\"]")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id=\"middleNames\"]")
    public WebElement middleName;

    @FindBy(xpath = " //*[@id=\"issueNumber\"]")
    public WebElement issueNumber;

    @FindBy(id = "licenceIssuerRadio")
    public WebElement radioBtnDVLA;

    @FindBy(xpath = "//*[@id=\"licenceIssuerRadio-DVA-label\"]")
    public WebElement optionDVA;

    @FindBy(id = "licenceIssuerRadio-DVA")
    public WebElement radioBtnDVA;

    @FindBy(id = "licenceIssuerRadio-noLicence-label")
    public WebElement noDLOption;

    @FindBy(id = "licenceIssuerRadio-noLicence")
    public WebElement noDLRadioBtn;

    @FindBy(id = "submitButton")
    public WebElement CTButton;

    @FindBy(xpath = "//*[@id=\"dateOfBirth-day\"]")
    public WebElement birthDay;

    @FindBy(xpath = "//*[@id=\"dateOfBirth-month\"]")
    public WebElement birthMonth;

    @FindBy(xpath = "//*[@id=\"dateOfBirth-year\"]")
    public WebElement birthYear;

    @FindBy(id = "expiryDate-day")
    public WebElement LicenceValidToDay;

    @FindBy(id = "expiryDate-month")
    public WebElement LicenceValidToMonth;

    @FindBy(id = "expiryDate-year")
    public WebElement LicenceValidToYear;

    @FindBy(id = "issueDate-day")
    public WebElement LicenceIssueDay;

    @FindBy(id = "issueDate-month")
    public WebElement LicenceIssueMonth;

    @FindBy(id = "issueDate-year")
    public WebElement LicenceIssueYear;

    @FindBy(xpath = "//*[@id=\"drivingLicenceNumber\"]")
    public WebElement licenceNumber;

    @FindBy(id = "postcode")
    public WebElement Postcode;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement Continue;

    @FindBy(id = "dvaDateOfBirth-day")
    public WebElement DayOfBirth;

    @FindBy(id = "dvaDateOfBirth-month")
    public WebElement MonthOfBirth;

    @FindBy(id = "dvaDateOfBirth-year")
    public WebElement YearOfBirth;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/p/font/font/text()")
    public WebElement dvlaSentence;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/div[2]/fieldset/legend")
    public WebElement givenName;

    @FindBy(id = "licenceIssuerRadio-DVLA-label")
    public WebElement optionDVLA;

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#dateOfBirth-day')]")
    public WebElement InvalidDOBError;


    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#drivingLicenceNumber')]")
    public WebElement InvalidDrivingLicenceError;

    @FindBy(id = "rowNumber")
    public WebElement selectRow;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/ul")
    public WebElement errorSummary;

    @FindBy(xpath = "//*[@id=\"licenceIssuerRadio-error\"]")
    public WebElement errorText;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/div/pre")
    public WebElement JSONPayload;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details")
    public WebElement errorResponse;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/summary/span")
    public WebElement viewResponse;

    @FindBy(xpath = "//*[@class='govuk-notification-banner__content']")
    public WebElement InvalidLicenceDetailsError;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/div/a")
    public WebElement proveanotherway;

    @FindBy(id = "licenceIssuerRadio-noLicence")
    public WebElement nodrivinglicenceradio;

    @FindBy(id = "drivingLicenceNumber")
    public WebElement LicenceNumber;

    @FindBy(id = "surname")
    public WebElement LastName;

    @FindBy(id = "firstName")
    public WebElement FirstName;

    @FindBy(id = "middleNames")
    public WebElement MiddleNames;

    @FindBy(id = "issueNumber")
    public WebElement IssueNumber;

    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement searchButton;

    public WelshLangDrivingLicencePageObject() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToDrivingLicenceCRI(String environment) {
        visitCredentialIssuers.click();
        assertURLContains("credential-issuers");
        switch (environment) {
            case "Build":
                drivingLicenceCDRIBuild.click();
                break;

            case "Staging":
                drivingLicenceCDRIStaging.click();
                break;

            case "Integration":
                drivingLicenceCDRIIntegration.click();
                break;

            default:
                break;
        }
    }

    public void betaBanner() {
        betaBannerWelsh.isDisplayed();
        if (Driver.get().getPageSource().contains("Beta")) {
            LOGGER.info("Beta");
        }
    }

    public void betaBannerSentenceWelsh() {
        if (Driver.get().getPageSource().contains("Mae hwn yn wasanaeth newydd – bydd eich adborth (agor mewn tab newydd) yn ein helpu i'w wella.”")) {
            LOGGER.info("Beta sentence in Welsh \"RMae hwn yn wasanaeth newydd – bydd eich adborth (agor mewn tab newydd) yn ein helpu i'w wella.”\"");
        }
    }

    public void changeLanguageToWelsh() {
        String currentURL = Driver.get().getCurrentUrl();
        String newURL = currentURL + "/?lang=cy";
        Driver.get().get(newURL);
    }

    public void drivingLicencePageURLValidationWelsh() {
        String expectedUrl = "https://review-d.build.account.gov.uk/licence-issuer/?lang=cy";
        String actualUrl = Driver.get().getCurrentUrl();
        LOGGER.info("expectedUrl = " + expectedUrl);
        LOGGER.info("actualUrl = " + actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void validateDLPageTitleWelsh() {
        String actualTitle = Driver.get().getTitle();
        System.out.print("Actual Title" + actualTitle);
        String expTitle = "Pwy wnaeth gyhoeddi eich trwydded yrru y DU? – – GOV.UK";
        if (actualTitle.contains(expTitle)) {
            LOGGER.info("Pass : directed to Pwy wnaeth gyhoeddi eich trwydded yrru y DU?");
        } else {
            LOGGER.info("Fail : not directed to the Driving Licence Page");
        }
    }

    public void pageTitleDVLAValidationWelsh() {
        String actualTitle = Driver.get().getTitle();
        System.out.print("Actual Title" + actualTitle);
        String expTitle = "Enw olaf – – GOV.UK";
        if (actualTitle.contains(expTitle)) {
            LOGGER.info("Pass : directed to Enw olaf – – GOV.UK ");
        } else {
            LOGGER.info("Fail : not directed to the Driving Licence Page");
        }
    }

    public void pageTitleDVAValidationWelsh() {
        String actualTitle = Driver.get().getTitle();
        System.out.print("Actual Title" + actualTitle);
        String expTitle = "Enw olaf – – GOV.UK";
        if (actualTitle.contains(expTitle)) {
            LOGGER.info("Pass : directed to Enw olaf – – GOV.UK ");
        } else {
            LOGGER.info("Fail : not directed to the Driving Licence Page");
        }
    }

    public void dvlaPageHeading() {
        String expectedText = "Rhowch eich manylion yn union fel maent yn ymddangos ar eich trwydded yrru";
        String actualText = dvlaPageHeadingWelsh.getText();
        Assert.assertEquals(expectedText, actualText);

        if (Driver.get().getPageSource().contains("Rhowch eich manylion yn union fel maent yn ymddangos ar eich trwydded yrru")) {
            LOGGER.info("DVLA sentence is \"Rhowch eich manylion yn union fel maent yn ymddangos ar eich trwydded yrru.\"");
        }

    }

    public void dvlaSentenceValidationWelsh() {
        if (Driver.get().getPageSource().contains("Byddwn yn gwirio eich manylion gyda'r DVLA i sicrhau nad yw eich trwydded yrru wedi cael ei chanslo na'i hadrodd fel un sydd ar goll neu wedi ei dwyn.")) {
            LOGGER.info("DVLA sentence is \"Byddwn yn gwirio eich manylion gyda'r DVLA i sicrhau nad yw eich trwydded yrru wedi cael ei chanslo na'i hadrodd fel un sydd ar goll neu wedi ei dwyn.\" ");
        }
    }

    public void dvaSentenceValidatioWelsh() {
        if (Driver.get().getPageSource().contains("Byddwn yn gwirio eich manylion gyda'r DVA i sicrhau nad yw eich trwydded yrru wedi cael ei chanslo na'i hadrodd fel un sydd ar goll neu wedi ei dwyn.")) {
            LOGGER.info("DVLA sentence is \"Byddwn yn gwirio eich manylion gyda'r DVA i sicrhau nad yw eich trwydded yrru wedi cael ei chanslo na'i hadrodd fel un sydd ar goll neu wedi ei dwyn.\" ");
        }

    }

    public void dvlaProveYourIdentitySentence() {
        if (Driver.get().getPageSource().contains("Os nad oes gennych drwydded yrru y DU neu os na allwch gofio'ch manylion, gallwch brofi pwy ydych chi mewn ffordd arall yn lle.")) {
            LOGGER.info("Prove your Identity is \"Os nad oes gennych drwydded yrru y DU neu os na allwch gofio'ch manylion, gallwch brofi pwy ydych chi mewn ffordd arall yn lle.\" ");
        }
    }

    public void lastNameWelsh() {
        if (Driver.get().getPageSource().contains("Enw olaf")) {
            LOGGER.info("lastname is \"Enw olaf\" ");
        }
    }

    public void givenNameWelsh() {
        if (Driver.get().getPageSource().contains("Enwau a roddwyd")) {
            LOGGER.info("nameGiven is \"Enwau a roddwyd\" ");
        }
    }

    public void firstNameWelsh() {
        if (Driver.get().getPageSource().contains("Enw cyntaf")) {
            LOGGER.info("firstName is \"Enw cyntaf\" ");
        }
    }

    public void middleNameWelsh() {
        if (Driver.get().getPageSource().contains("Enwau canol")) {
            LOGGER.info("firstName is \"Enwau canol\" ");
        }

    }

    public void firstNameSentence() {
        if (Driver.get().getPageSource().contains("Mae hwn yn adran 2 o'ch trwydded. Nid oes angen i chi gynnwys eich teitl.")) {
            LOGGER.info("firstName sentence is \"Mae hwn yn adran 2 o'ch trwydded. Nid oes angen i chi gynnwys eich teitl.\" ");
        }
    }

    public void middleNameSentence() {
        if (Driver.get().getPageSource().contains("Gadewch hyn yn wag os nad oes gennych unrhyw enwau canol")) {
            LOGGER.info("firstName is \"Gadewch hyn yn wag os nad oes gennych unrhyw enwau canol\" ");
        }
    }

    public void DateOfBirthField() {
        if (Driver.get().getPageSource().contains("Dyddiad geni")) {
            LOGGER.info("DOB is \"Dyddiad geni\" ");
        }
    }

    public void dobExample() {
        if (Driver.get().getPageSource().contains("Er enghraifft")) {
            LOGGER.info("DOB Example as \"Er enghraiffti\" ");
        }
    }

    public void dateField() {
        if (Driver.get().getPageSource().contains("Diwrnod")) {
            LOGGER.info("DOB date as \"Diwrnod\" ");
        }
    }

    public void monthField() {
        if (Driver.get().getPageSource().contains("Mis")) {
            LOGGER.info("DOB month as \"Mis\" ");
        }

    }

    public void yearField() {
        if (Driver.get().getPageSource().contains("Blwyddyn")) {
            LOGGER.info("DOB year as \"Blwyddyn\" ");
        }
    }

    public void issueDateField() {
        if (Driver.get().getPageSource().contains("Dyddiad cyhoeddi")) {
            LOGGER.info("IssueDateField as \"Dyddiad cyhoeddi\" ");
        }
    }

    public void issueDateSentence() {
        if (Driver.get().getPageSource().contains("Dyma'r dyddiad yn adran 4a o'ch trwydded, er enghraifft 27 5 2019")) {
            LOGGER.info("Issue date example year as \"Dyma'r dyddiad yn adran 4a o'ch trwydded, er enghraifft 27 5 2019\" ");
        }
    }

    public void validityDateSentence() {
        if (Driver.get().getPageSource().contains("Dyma'r dyddiad yn adran 4b o'ch trwydded, er enghraifft 27 5 2019")) {
            LOGGER.info("Issue date example year as \"Dyma'r dyddiad yn adran 4b o'ch trwydded, er enghraifft 27 5 2019\" ");
        }

    }

    public void licenceNumberWelsh() {
        if (Driver.get().getPageSource().contains("Rhif trwydded")) {
            LOGGER.info("DOB year as \"Rhif trwyddedn\" ");
        }
    }

    public void licenceSentence() {
        if (Driver.get().getPageSource().contains("This is the long number in section 5 of your licence")) {
            LOGGER.info("DOB year as \"This is the long number in section 5 of your licence\" ");
        }
    }

    public void issueNumberWelsh() {
        if (Driver.get().getPageSource().contains("Rhif cyhoeddi")) {
            LOGGER.info("DOB year as \"Rhif cyhoeddi\" ");
        }
    }

    public void issueNumberSentence() {
        if (Driver.get().getPageSource().contains("Dyma'r rhif 2 ddigid ar ôl y gofod yn adran 5 o'ch trwydded")) {
            LOGGER.info("DOB year as \"Dyma'r rhif 2 ddigid ar ôl y gofod yn adran 5 o'ch trwydded\" ");
        }
    }

    public void noDrivingLicenceBtnWelsh() {
        noDLOption.isDisplayed();
        noDLRadioBtn.isDisplayed();
    }

    public void orDisplayWelsh() {
        if (Driver.get().getPageSource().contains("Neu")) {
            LOGGER.info("lastname is \"Neu\" ");
        }
        //orAsNeu.isDisplayed();
    }

    public void postcodeWelsh() {
        if (Driver.get().getPageSource().contains("Cod post")) {
            LOGGER.info("DOB year as \"Cod post\" ");
        }

    }

    public void postcodeSentence() {
        if (Driver.get().getPageSource().contains("Rhowch y cod post yn y cyfeiriad yn adran 8 o'ch trwydded\n")) {
            LOGGER.info("DOB year as \"Rhowch y cod post yn y cyfeiriad yn adran 8 o'ch trwydded\n\" ");
        }
    }

    public void continueButtonWelsh() {

        CTButton.isDisplayed();
        CTButton.isEnabled();

    }

    public void licenceSelectionSentence() {
        if (Driver.get().getPageSource().contains("Gallwch ddod o hyd i hwn yn adran 4c o'ch trwydded yrru. Bydd naill ai'n dweud DVLA (Asiantaeth Trwyddedu Gyrru a Cherbydau) neu DVA (Asiantaeth Gyrrwyr a Cherbydau).")) {
            LOGGER.info("lastname is \"Gallwch ddod o hyd i hwn yn adran 4c o'ch trwydded yrru. Bydd naill ai'n dweud DVLA (Asiantaeth Trwyddedu Gyrru a Cherbydau) neu DVA (Asiantaeth Gyrrwyr a Cherbydau).\" ");
        }

        //LicenceText.isDisplayed();
    }

    public void dateFieldTitle() {
        if (Driver.get().getPageSource().contains("Gallwch ddod o hyd i hwn yn adran 4c o'ch trwydded yrru. Bydd naill ai'n dweud DVLA (Asiantaeth Trwyddedu Gyrru a Cherbydau) neu DVA (Asiantaeth Gyrrwyr a Cherbydau).")) {
            LOGGER.info("lastname is \"Gallwch ddod o hyd i hwn yn adran 4c o'ch trwydded yrru. Bydd naill ai'n dweud DVLA (Asiantaeth Trwyddedu Gyrru a Cherbydau) neu DVA (Asiantaeth Gyrrwyr a Cherbydau).\" ");
        }

    }

    public void invalidlastAndFirstNameWelsh() {
        lastName.sendKeys("Parker!");
        firstName.sendKeys("Peter@@!");
        middleName.sendKeys("@@@@@@@");
    }

    public void invalidDob() {

        birthDay.click();
        birthDay.sendKeys("23");
        birthMonth.click();
        birthMonth.sendKeys("03");
        birthYear.click();
        birthYear.sendKeys("1985");
    }


    public void clearDOBandReEnterWelsh() {
        birthDay.clear();
        birthDay.click();
        birthDay.sendKeys("15");
        birthMonth.clear();
        birthMonth.click();
        birthMonth.sendKeys("04");
        birthYear.clear();
        birthYear.click();
        birthYear.sendKeys("1968");
    }

    public void clearDOBandReEnterWelshtofuture() {
        birthDay.clear();
        birthDay.click();
        birthDay.sendKeys("15");
        birthMonth.clear();
        birthMonth.click();
        birthMonth.sendKeys("04");
        birthYear.clear();
        birthYear.click();
        birthYear.sendKeys("2028");

    }

    public void thereIsaProblemText() {
        thereIsaProblemText.isDisplayed();

        if (Driver.get().getPageSource().contains("Mae problem")) {
            LOGGER.info("Mae problem");
        }
    }

    public void lastNameErrorSentenceWelsh() {
        if (Driver.get().getPageSource().contains("Rhowch eich enw olaf fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch eich enw olaf fel y mae'n ymddangos ar eich trwydded yrru");
        }
    }

    public void firstNameErrorSentenceWelsh() {
        if (Driver.get().getPageSource().contains("Rhowch eich enw cyntaf fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch eich enw cyntaf fel y mae'n ymddangos ar eich trwydded yrru");
        }
    }

    public void middleNameErrorSentence() {
        if (Driver.get().getPageSource().contains("Rhowch unrhyw enwau canol fel y maent yn ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch unrhyw enwau canol fel y maent yn ymddangos ar eich trwydded yrru");
        }
    }

    public void enterDOBErrorTextWelsh() {
        if (Driver.get().getPageSource().contains("Rhowch y dyddiad fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch y dyddiad fel y mae'n ymddangos ar eich trwydded yrru");
        }
    }

    public void enterValidDOBErrorTextWelsh() {

        if (Driver.get().getPageSource().contains("Gwiriwch eich bod wedi rhoi eich dyddiad geni yn gywir")) {
            LOGGER.info("Gwiriwch eich bod wedi rhoi eich dyddiad geni yn gywir");
        }
    }

    public void errorMessageFutureDOBWelsh() {
        if (Driver.get().getPageSource().contains("Rhaid i'ch dyddiad geni fod yn y gorffennol")) {
            LOGGER.info("Rhaid i'ch dyddiad geni fod yn y gorffennol");
        }

    }

    public void enterInValidIssueDate() {
        LicenceIssueDay.click();
        LicenceIssueDay.sendKeys("23");
        LicenceIssueMonth.click();
        LicenceIssueMonth.sendKeys("03");
        LicenceIssueYear.click();
        LicenceIssueYear.sendKeys("1962");
    }

    public void enterInValidIssueDateWithFutureYear() {
        LicenceIssueDay.clear();
        LicenceIssueDay.click();
        LicenceIssueDay.sendKeys("23");
        LicenceIssueMonth.clear();
        LicenceIssueMonth.click();
        LicenceIssueMonth.sendKeys("03");
        LicenceIssueYear.clear();
        LicenceIssueYear.click();
        LicenceIssueYear.sendKeys("2062");
    }

    public void issueDateErrorWelsh() {
        if (Driver.get().getPageSource().contains("Rhaid i ddyddiad cyhoeddi fod yn y gorffennol")) {
            LOGGER.info("Rhaid i ddyddiad cyhoeddi fod yn y gorffennol");
        }
    }

    public void clickOnDVLARadioButtonWelsh() {
        radioBtnDVLA.click();
        CTButton.click();
    }

    public void clickOnDVARadioButtonWelsh() {
        radioBtnDVA.click();
        CTButton.click();
    }

    public void noDrivingLicenceOptionWelsh() {
        noDLOption.click();
        CTButton.click();
    }


    private void InvalidDOBErrorText() {
        invlidDOBErrorText.isDisplayed();
    }

    public void inValidDLText() {
        invlidDLErrorText.isDisplayed();
    }

    public void inValidIssueDateText() {
        if (Driver.get().getPageSource().contains("Rhowch y dyddiad fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch y dyddiad fel y mae'n ymddangos ar eich trwydded yrru");
        }

    }

    public void enterIvValidValidUntilDate() {
        LicenceValidToDay.click();
        LicenceValidToDay.sendKeys("12");
        LicenceValidToMonth.click();
        LicenceValidToMonth.sendKeys("12");
        LicenceValidToYear.click();
        LicenceValidToYear.sendKeys("2030");
    }

    public void enterTheValidToExpiredYear() {
        LicenceValidToDay.clear();
        LicenceValidToDay.click();
        LicenceValidToDay.sendKeys("12");
        LicenceValidToMonth.clear();
        LicenceValidToMonth.click();
        LicenceValidToMonth.sendKeys("12");
        LicenceValidToYear.clear();
        LicenceValidToYear.click();
        LicenceValidToYear.sendKeys("2012");
    }

    public void validToErrorWelsh() {
        if (Driver.get().getPageSource().contains("Ni allwch ddefnyddio trwydded yrru sydd wedi dod i ben")) {
            LOGGER.info("Ni allwch ddefnyddio trwydded yrru sydd wedi dod i ben");
        }

    }

    public void invalidDrivingLicenceWithlessChar() {
        licenceNumber.click();
        licenceNumber.sendKeys("PARKE610112");

    }

    public void licenceNumberErrorWelsh() {

        if (Driver.get().getPageSource().contains("Dylai rhif eich trwydded fod yn 16 nod o hyd")) {
            LOGGER.info("Dylai rhif eich trwydded fod yn 16 nod o hyd");
        }

    }

    public void inValidDrivingLicence() {
        licenceNumber.clear();
        licenceNumber.click();
        licenceNumber.sendKeys("PARKE610112PBFGH");
    }

    public void licenceErrorWelsh() {
        if (Driver.get().getPageSource().contains("Rhowch y rhif yn union fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch y rhif yn union fel mae'n ymddangos ar eich trwydded yrru");
        }
    }

    public void invalidIssueNumber() {
        issueNumber.click();
        issueNumber.sendKeys("7");
    }


    public void IssueNumberErrorWelsh() {
        if (Driver.get().getPageSource().contains("Dylai eich rhif cyhoeddi fod yn 2 rif o hyd")) {
            LOGGER.info("Dylai eich rhif cyhoeddi fod yn 2 rif o hyd");
        }
    }

    public void clearIssueNumber() {
        issueNumber.clear();
    }

    public void enterIssueNumberErrorWelsh() {
        if (Driver.get().getPageSource().contains("Rhowch y rhif cyhoeddi fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch y rhif cyhoeddi fel y mae'n ymddangos ar eich trwydded yrru");
        }
    }

    public void enterInValidPostCode() {
        Postcode.click();
        Postcode.sendKeys("BS981T$L@");
    }

    public void enterPostcodeErrorWelsh() {
        if (Driver.get().getPageSource().contains("Dylai eich rhowch eich cod post fod rhwng 5 a 7 nod")) {
            LOGGER.info("Dylai eich rhowch eich cod post fod rhwng 5 a 7 nod");
        }
    }

    public void clearPostcode() {
        Postcode.clear();
    }

    public void invalidPostCode() {
        Postcode.clear();
        Postcode.click();
        Postcode.sendKeys("BS98");
    }
    public void postCodeErrorWelsh() {
        if (Driver.get().getPageSource().contains("Dylai eich rhowch eich cod post fod rhwng 5 a 7 nod")) {
            LOGGER.info("Dylai eich rhowch eich cod post fod rhwng 5 a 7 nod");
        }
    }

    public void postCodeErrorInvalidWelsh() {
        if (Driver.get().getPageSource().contains("Dylai eich rhowch eich cod post ond cynnwys rhifau a llythrennau yn unig")) {
            LOGGER.info("Dylai eich rhowch eich cod post ond cynnwys rhifau a llythrennau yn unig");
        }
    }

    public void enterYourPostCodeErrorWelsh() {
        if (Driver.get().getPageSource().contains("Rhowch eich cod post")) {
            LOGGER.info("Rhowch eich cod post");
        }

    }

    public void invalidDobForDVAWelsh() {
        DayOfBirth.click();
        DayOfBirth.sendKeys("23");
        MonthOfBirth.click();
        MonthOfBirth.sendKeys("3");
        YearOfBirth.click();
        YearOfBirth.sendKeys("1985");
    }

    public void clearinValiddateForDVAWelsh() {
        DayOfBirth.clear();
        DayOfBirth.click();
        DayOfBirth.sendKeys("15");
        MonthOfBirth.clear();
        MonthOfBirth.click();
        MonthOfBirth.sendKeys("04");
        YearOfBirth.clear();
        YearOfBirth.click();
        YearOfBirth.sendKeys("1968");
    }
    public void dvaclearDOBandReEnterWelshtofuture() {
        DayOfBirth.clear();
        DayOfBirth.click();
        DayOfBirth.sendKeys("15");
        MonthOfBirth.clear();
        MonthOfBirth.click();
        MonthOfBirth.sendKeys("04");
        YearOfBirth.clear();
        YearOfBirth.click();
        YearOfBirth.sendKeys("2028");

    }
    public void invalidIssueNumberForDVA() {
        LicenceIssueDay.click();
        LicenceIssueDay.sendKeys("");
        LicenceIssueMonth.click();
        LicenceIssueYear.click();
    }
}