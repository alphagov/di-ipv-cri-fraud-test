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

  //  @FindBy(xpath = "//*[@id=\"submitButton\"]/text()")
  //  public WebElement continueAsParhau;

    //@FindBy(xpath = "//*[@id=\"main-content\"]/div/div/p/text()")
   // public WebElement LicenceText;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/p/font/font/text()")
    public WebElement dvlaSentence;

    @FindBy(xpath = "//*[@id=\"surname-label\"]")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/div[2]/fieldset/legend")
    public WebElement givenName;


    @FindBy(id = "licenceIssuerRadio-DVLA-label")
    public WebElement optionDVLA;

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

    @FindBy(id = "dateOfBirth-day")
    public WebElement birthDay;

    @FindBy(id = "dateOfBirth-month")
    public WebElement birthMonth;

    @FindBy(id = "dateOfBirth-year")
    public WebElement birthYear;

    @FindBy(id = "expiryDate-day")
    public WebElement LicenceValidToDay;

    @FindBy(id = "expiryDate-month")
    public WebElement LicenceValidToMonth;

    @FindBy(id = "expiryDate-year")
    public WebElement LicenceValidToYear;

    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement searchButton;

    @FindBy(id = "issueDate-day")
    public WebElement LicenceIssueDay;

    @FindBy(id = "issueDate-month")
    public WebElement LicenceIssueMonth;

    @FindBy(id = "issueDate-year")
    public WebElement LicenceIssueYear;

    @FindBy(id = "issueNumber")
    public WebElement IssueNumber;

    @FindBy(id = "postcode")
    public WebElement Postcode;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement Continue;

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#dateOfBirth-day')]")
    public WebElement InvalidDOBError;

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#drivingLicenceNumber')]")
    public WebElement InvalidDrivingLicenceError;
    private WebDriver driver;


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
        System.out.print("Actual Title"+ actualTitle );
        String expTitle = "Pwy wnaeth gyhoeddi eich trwydded yrru y DU? – – GOV.UK";
        if (actualTitle.contains(expTitle)) {
            LOGGER.info("Pass : directed to Pwy wnaeth gyhoeddi eich trwydded yrru y DU?");
        } else {
            LOGGER.info("Fail : not directed to the Driving Licence Page");
        }
    }

    public void pageTitleDVLAValidationWelsh() {
           String actualTitle = Driver.get().getTitle();
            System.out.print("Actual Title"+ actualTitle );
            String expTitle = "Enw olaf – – GOV.UK";
            if (actualTitle.contains(expTitle)) {
                LOGGER.info("Pass : directed to Enw olaf – – GOV.UK ");
            } else {
                LOGGER.info("Fail : not directed to the Driving Licence Page");
            }
        }
    public void pageTitleDVAValidationWelsh() {
        String actualTitle = Driver.get().getTitle();
        System.out.print("Actual Title"+ actualTitle );
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


    /*public void titleDVLAWithRadioBtn() {
        optionDVLA.isDisplayed();
        radioBtnDVLA.isDisplayed();
    }

    public void titleDVAWithRadioBtn() {
        optionDVA.isDisplayed();
        radioBtnDVA.isDisplayed();
    }*/


    /*public void clickOnDVLARadioButton() {
        radioBtnDVLA.click();
        CTButton.click();
    }*/



    /*public void pageTitleDVLAValidation() {
        if (Driver.get().getTitle().contains("We’ll check your details with DVLA ")) {
            LOGGER.info("Page title contains \"We’ll check your details with DVLA \" ");
        }
    }

    public void pageTitleDVAValidation() {
        if (Driver.get().getTitle().contains("We’ll check your details with DVA ")) {
            LOGGER.info("Page title contains \"We’ll check your details with DVA \" ");
        }
    }

    public void clickOnDVARadioButton() {
        radioBtnDVA.click();
        CTButton.click();
    }

    public void noDrivingLicenceOption() {
        noDLOption.click();
        CTButton.click();
    }

    public void ipvCoreRoutingPage() {
        String actualTitle = Driver.get().getTitle();
        String expTitle = "IPV Core Stub - GOV.UK";
        Assert.assertEquals(expTitle, actualTitle);
    }

    public void ipvCoreRoutingPageURL() {
        String expUrl =
                "https://di-ipv-core-stub.london.cloudapps.digital/callback?error=access_denied&error_description=Authorization+permission+denied";
        String actUrl = Driver.get().getCurrentUrl();
        LOGGER.info("expectedUrl = " + expUrl);
        LOGGER.info("actualUrl = " + actUrl);
        Assert.assertEquals(actUrl, expUrl);
    }

    public void noSelectContinue() {
        CTButton.click();
    }

    public void errormessage() {
        errorSummary.isDisplayed();
    }

    public void errorTitle() {
        if (Driver.get().getTitle().contains("You must choose an option to continue")) {
            LOGGER.info("Page title contains \"You must choose an option to continue \" ");
        }
    }

    public void errorLink() {
        errorSummary.click();
        radioBtnDVLA.isEnabled();
    }

    public void validateErrorText() {
        String expectedText = "Error:\n" + "You must choose an option to continue";
        String actualText = errorText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    public void jsonErrorResponse(String testErrorDescription, String testStatusCode) throws JsonProcessingException {
        String result = JSONPayload.getText();
        LOGGER.info("result = " + result);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        JsonNode insideError = jsonNode.get("errorObject");
        LOGGER.info("insideError = " + insideError);
        JsonNode errorDescription = insideError.get("description");
        JsonNode statusCode = insideError.get("httpstatusCode");
        String ActualErrorDescription = insideError.get("description").asText();
        String ActualStatusCode = insideError.get("httpstatusCode").asText();
        LOGGER.info("errorDescription = " + errorDescription);
        LOGGER.info("statusCode = " + statusCode);
        LOGGER.info("testErrorDescription = " + testErrorDescription);
        LOGGER.info("testStatusCode = " + testStatusCode);
        Assert.assertEquals(testErrorDescription, ActualErrorDescription);
        Assert.assertEquals(testStatusCode, ActualStatusCode);
    }

    public void scoreIs(String validityScore, String strengthScore) throws IOException {
        String result = JSONPayload.getText();
        LOGGER.info("result = " + result);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        JsonNode vcNode = jsonNode.get("vc");
        JsonNode evidenceNode = vcNode.get("evidence");

        ObjectReader objectReader =
                new ObjectMapper().readerFor(new TypeReference<List<JsonNode>>() {});
        List<JsonNode> evidence = objectReader.readValue(evidenceNode);

        String ValidityScore = evidence.get(0).get("validityScore").asText();
        assertEquals(ValidityScore, validityScore);

        String StrengthScore = evidence.get(0).get("strengthScore").asText();
        assertEquals(StrengthScore, strengthScore);
    }

    public void couldNotFindDetailsDVLAErrorDisplayed() {
        Assert.assertTrue(InvalidLicenceDetailsError.isDisplayed());
        LOGGER.info(InvalidLicenceDetailsError.getText());
    }

    public void userEntersData(DrivingLicenceSubject drivingLicenceSubject) {
        LicenceNumber.sendKeys(drivingLicenceSubject.getlicenceNumber());
        LastName.sendKeys(drivingLicenceSubject.getlastName());
        FirstName.sendKeys(drivingLicenceSubject.getfirstName());
        MiddleNames.sendKeys(drivingLicenceSubject.getmiddleNames());
        birthDay.sendKeys(drivingLicenceSubject.getbirthDay());
        birthMonth.sendKeys(drivingLicenceSubject.getbirthMonth());
        birthYear.sendKeys(drivingLicenceSubject.getbirthYear());
        LicenceValidToDay.sendKeys(drivingLicenceSubject.getvalidtoDay());
        LicenceValidToMonth.sendKeys(drivingLicenceSubject.getvalidtoMonth());
        LicenceValidToYear.sendKeys(drivingLicenceSubject.getvalidtoYear());
        LicenceIssueDay.sendKeys(drivingLicenceSubject.getlicenceIssueDay());
        LicenceIssueMonth.sendKeys(drivingLicenceSubject.getlicenceIssueMonth());
        LicenceIssueYear.sendKeys(drivingLicenceSubject.getlicenceIssueYear());
        IssueNumber.sendKeys(drivingLicenceSubject.getlicenceIssueNumber());
        Postcode.sendKeys(drivingLicenceSubject.getpostcode());
    }

    public void userEntersInvalidDrivingDetails() {
        new EnterYourDetailsExactlyDVLAPage().drivingLicenceNumber.sendKeys("PARKE610112PBFGI");
        new EnterYourDetailsExactlyDVLAPage().Lastname.sendKeys("Testlastname");
        new EnterYourDetailsExactlyDVLAPage().Firstname.sendKeys("Testfirstname");
        new EnterYourDetailsExactlyDVLAPage().DayOfBirth.sendKeys("11");
        new EnterYourDetailsExactlyDVLAPage().MonthOfBirth.sendKeys("10");
        new EnterYourDetailsExactlyDVLAPage().YearOfBirth.sendKeys("1962");
        new EnterYourDetailsExactlyDVLAPage().LicenceValidToDay.sendKeys("01");
        new EnterYourDetailsExactlyDVLAPage().LicenceValidToMonth.sendKeys("01");
        new EnterYourDetailsExactlyDVLAPage().LicenceValidToYear.sendKeys("2030");
        new EnterYourDetailsExactlyDVLAPage().LicenceIssueDay.sendKeys("10");
        new EnterYourDetailsExactlyDVLAPage().LicenceIssueMonth.sendKeys("12");
        new EnterYourDetailsExactlyDVLAPage().LicenceIssueYear.sendKeys("1970");
        new EnterYourDetailsExactlyDVLAPage().IssueNumber.sendKeys("01");
        new EnterYourDetailsExactlyDVLAPage().Postcode.sendKeys("BS98 1AA");
        BrowserUtils.waitFor(3);
        BrowserUtils.waitForPageToLoad(10);
    }

    public void userReEntersDataAsADrivingLicenceSubject(DrivingLicenceSubject drivingLicenceSubject) {
        LicenceNumber.clear();
        LastName.clear();
        FirstName.clear();
        MiddleNames.clear();
        birthDay.clear();
        birthMonth.clear();
        birthYear.clear();
        LicenceValidToDay.clear();
        LicenceValidToMonth.clear();
        LicenceValidToYear.clear();
        LicenceIssueDay.clear();
        LicenceIssueMonth.clear();
        LicenceIssueYear.clear();
        IssueNumber.clear();
        Postcode.clear();
        LicenceNumber.sendKeys(drivingLicenceSubject.getlicenceNumber());
        LastName.sendKeys(drivingLicenceSubject.getlastName());
        FirstName.sendKeys(drivingLicenceSubject.getfirstName());
        MiddleNames.sendKeys(drivingLicenceSubject.getmiddleNames());
        birthDay.sendKeys(drivingLicenceSubject.getbirthDay());
        birthMonth.sendKeys(drivingLicenceSubject.getbirthMonth());
        birthYear.sendKeys(drivingLicenceSubject.getbirthYear());
        LicenceValidToDay.sendKeys(drivingLicenceSubject.getvalidtoDay());
        LicenceValidToMonth.sendKeys(drivingLicenceSubject.getvalidtoMonth());
        LicenceValidToYear.sendKeys(drivingLicenceSubject.getvalidtoYear());
        LicenceIssueDay.sendKeys(drivingLicenceSubject.getlicenceIssueDay());
        LicenceIssueMonth.sendKeys(drivingLicenceSubject.getlicenceIssueMonth());
        LicenceIssueYear.sendKeys(drivingLicenceSubject.getlicenceIssueYear());
        IssueNumber.sendKeys(drivingLicenceSubject.getlicenceIssueNumber());
        Postcode.sendKeys(drivingLicenceSubject.getpostcode());
    }

    public void clickOnIDoNotHaveAUKDrivingLicenceRadioButton() {
        nodrivinglicenceradio.click();
        Continue.click();
    }

    public void selectDVLARadioButton() {
        new EnterYourDetailsExactlyDVLAPage().DVLA.click();
        Continue.click();
    }

    public void searchForUATUser(String number) {
        assertURLContains("credential-issuer?cri=driving-licence");
        selectRow.sendKeys(number);
        searchButton.click();
    }

    public void navigateToDrivingLicenceResponse(String validOrInvalid) {
        assertURLContains("callback");
        if ("Invalid".equalsIgnoreCase(validOrInvalid)) {
            errorResponse.click();
        } else {
            viewResponse.click();
        }
    }

    public void invalidDOBErrorDisplayed() {
        Assert.assertTrue(InvalidDOBError.isDisplayed());
        LOGGER.info(InvalidDOBError.getText());
    }

    public void invalidDrivingLicenceErrorDisplayed() {
        Assert.assertTrue(InvalidDrivingLicenceError.isDisplayed());
        LOGGER.info(InvalidDrivingLicenceError.getText());
    }*/
}