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
    public WebElement orOption;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/div")
    public WebElement proveIdentityTextWelsh;

    @FindBy(xpath = "//*[@id=\"header\"]")
    public WebElement dvlaPageHeadingWelsh;

    @FindBy(xpath = "/html/body/div[2]/div/p/strong")
    public WebElement betaBannerWelsh;

    @FindBy(className = "govuk-phase-banner__text")
    public WebElement betaBannerWelshSentence;

    @FindBy(xpath = "//*[@id=\"error-summary-title\"]")
    public WebElement thereIsaProblemText;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/ul/li[1]/a")
    public WebElement invlidDOBErrorText;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/ul/li[2]/a")
    public WebElement invlidDLErrorText;

    @FindBy(id = "licenceIssuerRadio")
    public WebElement radioBtnDVLA;

    @FindBy(id = "licenceIssuerRadio-DVA")
    public WebElement radioBtnDVA;

    @FindBy(id = "licenceIssuerRadio-noLicence-label")
    public WebElement noDLOption;

    @FindBy(id = "licenceIssuerRadio-noLicence")
    public WebElement noDLRadioBtn;

    @FindBy(id = "submitButton")
    public WebElement CTButton;


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
    }

    public void betaBannerSentenceWelsh() {
        betaBannerWelshSentence.isDisplayed();
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
        System.out.print("Actual Title:" + actualTitle);
        String expTitle = "Pwy wnaeth gyhoeddi eich trwydded yrru y DU? – – GOV.UK";
        if (actualTitle.contains(expTitle)) {
            LOGGER.info("Pass : directed to Pwy wnaeth gyhoeddi eich trwydded yrru y DU?");
        } else {
            LOGGER.info("Fail : not directed to the Driving Licence Page");
        }
    }

    public void pageTitleDVLAValidationWelsh() {
        String actualTitle = Driver.get().getTitle();
        System.out.print("Actual Title:" + actualTitle);
    }

    public void ErrorPageTitleDVLA() {

        String actualTitle = Driver.get().getTitle();
        System.out.print("Actual Title:" + actualTitle);
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
            LOGGER.info("DVA sentence is \"Byddwn yn gwirio eich manylion gyda'r DVA i sicrhau nad yw eich trwydded yrru wedi cael ei chanslo na'i hadrodd fel un sydd ar goll neu wedi ei dwyn.\" ");
        }

    }

    public void dvlaProveYourIdentitySentence() {
        String expectedText = "Os nad oes gennych drwydded yrru y DU neu os na allwch gofio'ch manylion, gallwch brofi pwy ydych chi mewn ffordd arall yn lle.";
        String actualText = proveIdentityTextWelsh.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    public void checkYourDetailsSentence() {
        if (Driver.get().getPageSource().contains("Gwiriwch bod eich manylion yn paru gyda beth sydd ar eich trwydded yrru y DU")) {
            LOGGER.info("Retry Sentence is \"Gwiriwch bod eich manylion yn paru gyda beth sydd ar eich trwydded yrru y DU\" ");
        }
    }

    public void erroeWord() {
        if (Driver.get().getPageSource().contains("Gwall")) {
            LOGGER.info("Retry Error is \"Gwall\" ");
        }
    }

    public void weCouldNotFindDetailsSentence() {
        if (Driver.get().getPageSource().contains("Nid oeddem yn gallu dod o hyd i'ch manylion")) {
            LOGGER.info("Retry We Could not find is \"Nid oeddem yn gallu dod o hyd i'ch manylion\" ");
        }
    }

    public void youWillBeAbleToFindSentence() {
        if (Driver.get().getPageSource().contains("Roedd yna broblem wrth i ni wirio eich manylion gyda'r DVLA")) {
            LOGGER.info("Retry You will be able to find  is \"Roedd yna broblem wrth i ni wirio eich manylion gyda'r DVLA\" ");
        }
    }

    public void youWillBeAbleToFindSentenceDVA() {
        if (Driver.get().getPageSource().contains("Roedd yna broblem wrth i ni wirio eich manylion gyda'r DVA")) {
            LOGGER.info("Retry You will be able to find  is \"Roedd yna broblem wrth i ni wirio eich manylion gyda'r DVA\" ");
        }
    }

    public void thereIsaProblemSentence() {
        if (Driver.get().getPageSource().contains("Ni fyddwch yn gallu newid eich manylion eto os byddwch yn gwneud camgymeriad")) {
            LOGGER.info("Retry Error is \"Ni fyddwch yn gallu newid eich manylion eto os byddwch yn gwneud camgymeriad\" ");
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
            LOGGER.info("Licence number field \"Rhif trwyddedn\" ");
        }
    }

    public void licenceSentence() {
        if (Driver.get().getPageSource().contains("Dyma'r rhif hir yn adran 5 ar eich trwydded er enghraifft HARRI559146MJ931")) {
            LOGGER.info("Licence sentence as Dyma'r rhif hir yn adran 5 ar eich trwydded er enghraifft HARRI559146MJ931 ");
        }
    }

    public void issueNumberWelsh() {
        if (Driver.get().getPageSource().contains("Rhif cyhoeddi")) {
            LOGGER.info("DOB year as \"Rhif cyhoeddi\" ");
        }
    }

    public void issueNumberSentence() {
        if (Driver.get().getPageSource().contains("Dyma'r rhif 2 ddigid ar ôl y gofod yn adran 5 o'ch trwydded")) {
            LOGGER.info("Issue number sentence as \"Dyma'r rhif 2 ddigid ar ôl y gofod yn adran 5 o'ch trwydded\" ");
        }
    }

    public void noDrivingLicenceBtnWelsh() {
        noDLOption.isDisplayed();
        noDLRadioBtn.isDisplayed();
    }

    public void orDisplayWelsh() {
        orOption.isDisplayed();
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
    }

    public void dateFieldTitle() {
        if (Driver.get().getPageSource().contains("Yn ddilys tan")) {
            LOGGER.info("date field title is Yn ddilys tan ");
        }
    }

    public void invalidlastAndFirstNameWelsh() {
        new DrivingLicencePageObject().LastName.sendKeys("Parker!");
        new DrivingLicencePageObject().FirstName.sendKeys("Peter@@!");
        new DrivingLicencePageObject().MiddleNames.sendKeys("@@@@@@@");
    }

    public void invalidDob() {

        new DrivingLicencePageObject().birthDay.click();
        new DrivingLicencePageObject().birthDay.sendKeys("23");
        new DrivingLicencePageObject().birthMonth.click();
        new DrivingLicencePageObject().birthMonth.sendKeys("03");
        new DrivingLicencePageObject().birthYear.click();
        new DrivingLicencePageObject().birthYear.sendKeys("1985");
    }


    public void clearDOBandReEnterWelsh() {
        new DrivingLicencePageObject().birthDay.clear();
        new DrivingLicencePageObject().birthDay.click();
        new DrivingLicencePageObject().birthDay.sendKeys("15");
        new DrivingLicencePageObject().birthMonth.clear();
        new DrivingLicencePageObject().birthMonth.click();
        new DrivingLicencePageObject().birthMonth.sendKeys("04");
        new DrivingLicencePageObject().birthYear.clear();
        new DrivingLicencePageObject().birthYear.click();
        new DrivingLicencePageObject().birthYear.sendKeys("1968");
    }

    public void clearDOBandReEnterWelshtofuture() {
        new DrivingLicencePageObject().birthDay.clear();
        new DrivingLicencePageObject().birthDay.click();
        new DrivingLicencePageObject().birthDay.sendKeys("15");
        new DrivingLicencePageObject().birthMonth.clear();
        new DrivingLicencePageObject().birthMonth.click();
        new DrivingLicencePageObject().birthMonth.sendKeys("04");
        new DrivingLicencePageObject().birthYear.clear();
        new DrivingLicencePageObject().birthYear.click();
        new DrivingLicencePageObject().birthYear.sendKeys("2028");

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
        new DrivingLicencePageObject().LicenceIssueDay.click();
        new DrivingLicencePageObject().LicenceIssueDay.sendKeys("23");
        new DrivingLicencePageObject().LicenceIssueMonth.click();
        new DrivingLicencePageObject().LicenceIssueMonth.sendKeys("03");
        new DrivingLicencePageObject().LicenceIssueYear.click();
        new DrivingLicencePageObject().LicenceIssueYear.sendKeys("1962");
    }

    public void enterInValidIssueDateWithFutureYear() {
        new DrivingLicencePageObject().LicenceIssueDay.clear();
        new DrivingLicencePageObject().LicenceIssueDay.click();
        new DrivingLicencePageObject().LicenceIssueDay.sendKeys("23");
        new DrivingLicencePageObject().LicenceIssueMonth.clear();
        new DrivingLicencePageObject().LicenceIssueMonth.click();
        new DrivingLicencePageObject().LicenceIssueMonth.sendKeys("03");
        new DrivingLicencePageObject().LicenceIssueYear.clear();
        new DrivingLicencePageObject().LicenceIssueYear.click();
        new DrivingLicencePageObject().LicenceIssueYear.sendKeys("2032");
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

    //public void InvalidDOBErrorText() {
    //    invlidDOBErrorText.isDisplayed();
    //}

    public void inValidDLText() {
        invlidDLErrorText.isDisplayed();
    }

    public void inValidIssueDateText() {
        if (Driver.get().getPageSource().contains("Rhowch y dyddiad fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch y dyddiad fel y mae'n ymddangos ar eich trwydded yrru");
        }

    }

    public void enterInValidUntilDate() {
        new DrivingLicencePageObject().LicenceValidToDay.click();
        new DrivingLicencePageObject().LicenceValidToDay.sendKeys("12");
        new DrivingLicencePageObject().LicenceValidToMonth.click();
        new DrivingLicencePageObject().LicenceValidToMonth.sendKeys("12");
        new DrivingLicencePageObject().LicenceValidToYear.click();
        new DrivingLicencePageObject().LicenceValidToYear.sendKeys("2030");
    }

    public void enterTheValidToExpiredYear() {
        new DrivingLicencePageObject().LicenceValidToDay.clear();
        new DrivingLicencePageObject().LicenceValidToDay.click();
        new DrivingLicencePageObject().LicenceValidToDay.sendKeys("12");
        new DrivingLicencePageObject().LicenceValidToMonth.clear();
        new DrivingLicencePageObject().LicenceValidToMonth.click();
        new DrivingLicencePageObject().LicenceValidToMonth.sendKeys("12");
        new DrivingLicencePageObject().LicenceValidToYear.clear();
        new DrivingLicencePageObject().LicenceValidToYear.click();
        new DrivingLicencePageObject().LicenceValidToYear.sendKeys("2012");
    }

    public void validToErrorWelsh() {
        if (Driver.get().getPageSource().contains("Ni allwch ddefnyddio trwydded yrru sydd wedi dod i ben")) {
            LOGGER.info("Ni allwch ddefnyddio trwydded yrru sydd wedi dod i ben");
        }

    }

    public void invalidDrivingLicenceempty() {
        new DrivingLicencePageObject().LicenceNumber.click();
        new DrivingLicencePageObject().LicenceNumber.sendKeys("");

    }

    public void invalidDrivingLicenceDVLA() {
        new DrivingLicencePageObject().LicenceNumber.click();
        new DrivingLicencePageObject().LicenceNumber.sendKeys("PARKE610@$112");

    }

    public void invalidDrivingLicenceWithSplCharDVLA() {
        new DrivingLicencePageObject().LicenceNumber.clear();
        new DrivingLicencePageObject().LicenceNumber.click();
        new DrivingLicencePageObject().LicenceNumber.sendKeys("@@@@@@@@@@@@@@@@");

    }

    public void inValidDrivingLicenceDVA() {
        new DVAEnterYourDetailsExactlyPage().dvaLicenceNumber.clear();
        new DVAEnterYourDetailsExactlyPage().dvaLicenceNumber.click();
        new DVAEnterYourDetailsExactlyPage().dvaLicenceNumber.sendKeys("1acd1113756456");
    }

    public void invalidDrivingLicenceWithlessCharDVA() {
        new DVAEnterYourDetailsExactlyPage().dvaLicenceNumber.click();
        new DVAEnterYourDetailsExactlyPage().dvaLicenceNumber.sendKeys("111106");

    }

    public void licenceNumberErrorWelshForDVA() {
        if (Driver.get().getPageSource().contains("Dylai rhif eich trwydded fod yn 8 nod o hyd")) {
            LOGGER.info("Dylai rhif eich trwydded fod yn 8 nod o hyd");
        }
    }

   public void licenceErrorWelshforExactonDL() {

        if (Driver.get().getPageSource().contains("Rhowch y rhif yn union fel mae’n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch y rhif yn union fel mae’n ymddangos ar eich trwydded yrru");
        }
    }

        public void licenceErrorWelshforSplChar() {

            if (Driver.get().getPageSource().contains("Ni ddylai rhif eich trwydded gynnwys unrhyw symbolau neu ofodau")) {
                LOGGER.info("Ni ddylai rhif eich trwydded gynnwys unrhyw symbolau neu ofodau");
            }
        }

        public void invalidIssueNumber() {
            new DrivingLicencePageObject().IssueNumber.click();
            new DrivingLicencePageObject().IssueNumber.sendKeys("7");
        }

        public void IssueNumberErrorWelsh() {
            if (Driver.get().getPageSource().contains("Dylai eich rhif cyhoeddi fod yn 2 rif o hyd")) {
                LOGGER.info("Dylai eich rhif cyhoeddi fod yn 2 rif o hyd");
            }
        }

        public void clearIssueNumber() {
            new DrivingLicencePageObject().IssueNumber.clear();
        }

        public void enterIssueNumberErrorWelsh() {
            if (Driver.get().getPageSource().contains("Rhowch y rhif cyhoeddi fel y mae'n ymddangos ar eich trwydded yrru")) {
                LOGGER.info("Rhowch y rhif cyhoeddi fel y mae'n ymddangos ar eich trwydded yrru");
            }
        }

        public void enterInValidPostCode() {
            new DrivingLicencePageObject().Postcode.clear();
            new DrivingLicencePageObject().Postcode.click();
            new DrivingLicencePageObject().Postcode.sendKeys("@@@$$$**");
        }

        public void invalidPostCode() {
            new DrivingLicencePageObject().Postcode.clear();
            new DrivingLicencePageObject().Postcode.click();
            new DrivingLicencePageObject().Postcode.sendKeys("BS98");
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
            new DVAEnterYourDetailsExactlyPage().DayOfBirth.click();
            new DVAEnterYourDetailsExactlyPage().DayOfBirth.sendKeys("ss");
            new DVAEnterYourDetailsExactlyPage().MonthOfBirth.click();
            new DVAEnterYourDetailsExactlyPage().MonthOfBirth.sendKeys("aa");
            new DVAEnterYourDetailsExactlyPage().YearOfBirth.click();
            new DVAEnterYourDetailsExactlyPage().YearOfBirth.sendKeys("aaaa");
        }
        public void EnterDobApperOnDLErrorWelsh() {
        if (Driver.get().getPageSource().contains("Rhowch eich dyddiad geni fel y mae'n ymddangos ar eich trwydded yrru")) {
            LOGGER.info("Rhowch eich dyddiad geni fel y mae'n ymddangos ar eich trwydded yrru");
        }
      }
        public void dvaclearDOBandReEnterWelshtofuture () {
            new DVAEnterYourDetailsExactlyPage().DayOfBirth.clear();
            new DVAEnterYourDetailsExactlyPage().DayOfBirth.click();
            new DVAEnterYourDetailsExactlyPage().DayOfBirth.sendKeys("15");
            new DVAEnterYourDetailsExactlyPage().MonthOfBirth.clear();
            new DVAEnterYourDetailsExactlyPage().MonthOfBirth.click();
            new DVAEnterYourDetailsExactlyPage().MonthOfBirth.sendKeys("04");
            new DVAEnterYourDetailsExactlyPage().YearOfBirth.clear();
            new DVAEnterYourDetailsExactlyPage().YearOfBirth.click();
            new DVAEnterYourDetailsExactlyPage().YearOfBirth.sendKeys("2028");

        }
        public void invalidIssueDayForDVA () {
            new DVAEnterYourDetailsExactlyPage().LicenceIssueDay.click();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueDay.sendKeys("15");
            new DVAEnterYourDetailsExactlyPage().LicenceIssueMonth.click();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueMonth.sendKeys("04");
            new DVAEnterYourDetailsExactlyPage().LicenceIssueYear.click();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueYear.sendKeys("1982");
        }

        public void enterInValidIssueDateWithFutureYearDVA () {
            new DVAEnterYourDetailsExactlyPage().LicenceIssueDay.clear();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueDay.click();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueDay.sendKeys("23");
            new DVAEnterYourDetailsExactlyPage().LicenceIssueMonth.clear();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueMonth.click();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueMonth.sendKeys("03");
            new DVAEnterYourDetailsExactlyPage().LicenceIssueYear.clear();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueYear.click();
            new DVAEnterYourDetailsExactlyPage().LicenceIssueYear.sendKeys("2062");
        }

      public void invalidValidUntilForDVA() {
        new DVAEnterYourDetailsExactlyPage().LicenceValidToDay.click();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToDay.sendKeys("");
        new DVAEnterYourDetailsExactlyPage().LicenceValidToMonth.click();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToMonth.sendKeys("");
        new DVAEnterYourDetailsExactlyPage().LicenceValidToYear.click();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToYear.sendKeys("");
    }

    public void enterTheValidToExpiredYearForDVA() {
        new DVAEnterYourDetailsExactlyPage().LicenceValidToDay.clear();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToDay.click();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToDay.sendKeys("23");
        new DVAEnterYourDetailsExactlyPage().LicenceValidToMonth.clear();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToMonth.click();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToMonth.sendKeys("03");
        new DVAEnterYourDetailsExactlyPage().LicenceValidToYear.clear();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToYear.click();
        new DVAEnterYourDetailsExactlyPage().LicenceValidToYear.sendKeys("2005");
    }
    public void licenceNumberErrorWelshForDVLA() {
        if (Driver.get().getPageSource().contains("Dylai rhif eich trwydded fod yn 16 nod o hyd")) {
            LOGGER.info("Dylai rhif eich trwydded fod yn 16 nod o hyd");
        }
    }

    public void licenceNumberErrorWelshforDVA() {
        if (Driver.get().getPageSource().contains("Dyma'r rhif hir yn adran 5 ar eich trwydded\n")) {
            LOGGER.info("Dyma'r rhif hir yn adran 5 ar eich trwydded\n");
        }
    }
}