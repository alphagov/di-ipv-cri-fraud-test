package gov.di_ipv_fraud.step_definitions;

import gov.di_ipv_fraud.pages.WelshLangDrivingLicencePageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WelshlandDrivingLicenceStepDefs extends WelshLangDrivingLicencePageObject {

    @And("I add a cookie to change the language to Welsh")
    public void iAddACookieToChangeTheLanguageToWelsh() {

        changeLanguageToWelsh();

    }

    @Then("I check the page title Pwy wnaeth gyhoeddi eich trwydded yrru y DU?")
    public void i_check_the_page_title_who_was_your_uk_driving_license_issued_by() {
        validateDLPageTitleWelsh();
    }

    @And("I assert the URL is valid in Welsh")
    public void iAssertTheURLIsValidInWelsh() {
        drivingLicencePageURLValidationWelsh();
    }

    @And("I can see a radio button titled “Nid oes gennyf drwydded yrru y DU”")
    public void iCanSeeARadioButtonTitledNidOesGennyfDrwyddedYrruYDU() {
        noDrivingLicenceBtnWelsh();
    }

    @And("I can see “neu”")
    public void iCanSeeNeu() {
        orDisplayWelsh();
    }


    @Then("I can see CTA as Parhau")
    public void iCanSeeCTAAsParhau() {
        continueButtonWelsh();
    }


    @And("I see the sentence  I see the sentence starts with “Gallwch ddod o hyd i hwn yn adran\"")
    public void iSeeTheSentenceISeeTheSentenceStartsWithGallwchDdodOHydIHwnYnAdran() throws Throwable
    {    licenceSelectionSentence();
    }


   /* @Then("^I should on the page DVLA $")
    public void i_should_be_on_the_DVLA_page() {
        pageTitleDVLAValidation();
    }*/

    @Then("I should on the page DVLA and validate title")
    public void iShouldOnThePageDVLAAndValidateTitle() {
        pageTitleDVLAValidationWelsh();
    }

    @Then("I should on the page DVA and validate title")
    public void iShouldOnThePageDVAAndValidateTitle() {
        pageTitleDVAValidationWelsh();
    }
    @And("I see the heading Rhowch eich manylion yn union fel maent yn ymddangos ar eich trwydded yrru")
    public void iSeeTheHeadingRhowchEichManylionYnUnionFelMaentYnYmddangosArEichTrwyddedYrru() {
        dvlaPageHeading();

    }

    @And("I see the sentence starts with \"Byddwn yn gwirio eich manylion gydar DVLA\"")
    public void iSeeTheSentenceByddwnYnGwirioEichManylionGydaRDVLA() {
        dvlaSentenceValidationWelsh();
    }
    @And("I see the sentence starts with “Byddwn yn gwirio eich manylion gyda'r DVA”")
    public void iSeeTheSentenceStartsWithByddwnYnGwirioEichManylionGydaRDVA() {
        dvaSentenceValidatioWelsh();
    }


    @Given("I can see the lastname as Enw olaf")
    public void iCanSeeTheLastnameAsEnwOlaf() {
        lastNameWelsh();
    }

    @And("I can see Given name as Enwau a roddwyd")
    public void iCanSeeGivenNameAsEnwauARoddwyd() {
        givenNameWelsh();
    }

    @And("I can see First name as Enw cyntaf")
    public void iCanSeeFirstNameAsEnwCyntaf() {
        firstNameWelsh();
    }

    @And("I can see the middle name as Enwau canol")
    public void iCanSeeTheMiddleNameAsEnwauCanol() {
        middleNameWelsh();
    }

    @And("I can see the sentence “Mae hwn yn adran 2 och trwydded. Nid oes angen i chi gynnwys eich teitl.”")
    public void iCanSeeTheSentenceMaeHwnYnAdranOChTrwyddedNidOesAngenIChiGynnwysEichTeitl() {
        firstNameSentence();
    }

    @And("I see the sentence below Os nad oes gennych drwydded yrru y DU neu os na allwch gofio'ch manylion, gallwch brofi pwy ydych chi mewn ffordd arall yn lle.")
    public void iSeeTheSentenceBelowOsNadOesGennychDrwyddedYrruYDUNeuOsNaAllwchGofioChManylionGallwchBrofiPwyYdychChiMewnFforddArallYnLle() {
        dvlaProveYourIdentitySentence();
    }

    @And("I can see the sentence “Gadewch hyn yn wag os nad oes gennych unrhyw enwau canol”")
    public void iCanSeeTheSentenceGadewchHynYnWagOsNadOesGennychUnrhywEnwauCanol() {
        middleNameSentence();
    }

    @Given("I can see the DoB fields titled “Dyddiad geni”")
    public void iCanSeeTheDoBFieldsTitledDyddiadGeni() {
        DateOfBirthField();
    }

    @And("I can see example as Er enghraifft")
    public void iCanSeeExampleAsErEnghraifft() {
        dobExample();
    }

    @And("I can see date as “Diwrnod”")
    public void iCanSeeDateAsDiwrnod() {
        dateField();
    }

    @And("I can see month as “Mis”")
    public void iCanSeeMonthAsMis() {
        monthField();
    }

    @And("I can see year as “Blwyddyn”")
    public void iCanSeeYearAsBlwyddyn() {
        yearField();
    }

    @Given("I can see the Issue date field titled “Dyddiad cyhoeddi”")
    public void iCanSeeTheIssueDateFieldTitledDyddiadCyhoeddi() {
        issueDateField();
    }


    @Then("Dyma r dyddiad yn adran 4a o ch trwydded, er enghraifft 27 5 2019")
    public void dymaRDyddiadYnAdranAOChTrwyddedErEnghraifft() {
        issueDateSentence();
    }



    @Then("Dyma r dyddiad yn adran 4b o ch trwydded, er enghraifft 27 5 2019")
    public void dymaRDyddiadYnAdranAOChTrwyddedErEnghraifftValidityDate() {
        validityDateSentence();

    }



    @Then("I can see the Valid to date field titled “Yn ddilys tan”")
    public void iCanSeeTheValidToDateFieldTitledYnDdilysTan() {
        dateFieldTitle();
    }


    @Given("I can see the licence number field titled “Rhif trwydded”")
    public void iSelectedDVLAOnThePreviousPage() {
        licenceNumberWelsh();
    }


    @And("I see the sentence “Dyma'r rhif hir yn adran  ar eich trwydded”")
    public void iSeeTheSentenceDymaRRhifHirYnAdranArEichTrwydded() {
        licenceSentence();
    }


    @Then("I can see the issue number field titled “Dyddiad cyhoeddi”")
    public void iCanSeeTheIssueNumberFieldTitledDyddiadCyhoeddi() {
        issueNumberWelsh();
    }


    @And("I  can see “Dyma r rhif  ddigid ar ôl y gofod yn adran  o'ch trwydded”")
    public void iCanSeeDymaRRhifDdigidArÔlYGofodYnAdranOChTrwydded() {
        issueNumberSentence();
    }

    @Then("I can see the postcode field titled “Cod post”")
    public void iCanSeeThePostcodeFieldTitledCodPost() {
        postcodeWelsh();
    }

    @And("“Rhowch y cod post yn y cyfeiriad yn adran  o ch trwydded”")
    public void rhowchYCodPostYnYCyfeiriadYnAdranOChTrwydded() {
        postcodeSentence();
    }

    @When("User clicks on Parhau")
    public void userClicksOnParhau() {
        Continue.click();
    }

    @Given("I click on DVLA radio button and Parhau")
    public void i_click_on_DVLA_radio_button_and_Continue() {
        clickOnDVLARadioButtonWelsh();
    }

    @Given("I click on DVA radio button and Parhau")
    public void i_select_dva_radio_button_and_Parhau() {
        clickOnDVARadioButtonWelsh();
    }

    @Given("I click Nid oes gennyf drwydded yrru y DU and Parhau")
    public void i_select_i_do_not_have_uk_driving_license() {
        noDrivingLicenceOptionWelsh();
    }




}











    /*@And("^I click the Driving Licence CRI for the (.*) environment$")
    public void navigateToDrivingLicence(String environment) {
        navigateToDrivingLicenceCRI(environment);
    }

    @Then("^I search for Driving Licence user number (.*) in the Experian table$")
    public void i_search_for_DL_user_number(String number) {
        searchForUATUser(number);
    }

    @Then("I check the page title who was your UK driving license issued by?")
    public void i_check_the_page_title_who_was_your_uk_driving_license_issued_by() {
        validateDLPageTitle();
    }

    @And("I assert the URL is valid")
    public void i_assert_the_url_is_valid() {
        drivingLicencePageURLValidation();
    }

    @Given("I check the page title {string}")
    public void i_check_the_page_titled() {
        validateDLPageTitle();
    }

    @Given("I can see a radio button titled “DVLA”")
    public void i_can_see_a_radio_button_titled_dvla() {
        titleDVLAWithRadioBtn();
    }

    @Then("I can see a radio button titled “DVA”")
    public void i_can_see_a_radio_button_titled_dva() {
        titleDVAWithRadioBtn();
    }

    @And("I can see a radio button titled “I do not have a UK driving licence”")
    public void i_can_see_a_radio_button_titled_i_do_not_have_a_uk_driving_licence() {
        noDrivingLicenceBtn();
    }

    @Then("I can see CTA {string}")
    public void i_can_see_cta(String string) {
        ContinueButton();
    }

    @Given("I click on DVLA radio button and Continue")
    public void i_click_on_DVLA_radio_button_and_Continue() {
        clickOnDVLARadioButton();
    }
    @Then("^I should on the page DVLA Enter your details exactly as they appear on your UK driving licence$")
    public void i_should_be_on_the_DVLA_page() {
        pageTitleDVLAValidation();
    }

    @Then("^I should be on the page DVA Enter your details exactly as they appear on your UK driving licence$")
    public void i_should_be_on_the_DVA_page() {
        pageTitleDVAValidation();
    }

    @Given("I click on DVA radio button and Continue")
    public void i_select_dva_radio_button_and_Continue() {
        clickOnDVARadioButton();
    }

    @Given("I click I do not have UK Driving License and continue")
    public void i_select_i_do_not_have_uk_driving_license() {
        noDrivingLicenceOption();
    }

    @When("I am directed to the IPV Core routing page")
    public void i_am_directed_to_the_ipv_core_routing_page() {
        ipvCoreRoutingPage();
    }

    @Given("I have not selected anything and Continue")
    public void i_have_not_selected_anything() {
        noSelectContinue();
    }

    @When("I can see an error box highlighted red")
    public void i_can_see_an_error_box_highlighted_red() {
        errormessage();
    }

    @And("An error heading copy “You must choose an option to continue”")
    public void an_error_heading_copy_you_must_choose_an_option_to_continue() {
        errorTitle();
    }

    @Then("I can select a link which directs to the problem field")
    public void i_can_select_a_link_which_directs_to_the_problem_field() {
        errorLink();
    }

    @And("The field error copy “You must choose an option to continue”")
    public void the_field_error_copy_you_must_choose_an_option_to_continue() {
        validateErrorText();
    }

    @And("I validate the URL having access denied")
    public void iValidateTheURLHavingAccessDenied() {
        ipvCoreRoutingPageURL();
    }

    @Then("^I navigate to the Driving Licence verifiable issuer to check for a (.*) response$")
    public void i_navigate_to_driving_licence_verifiable_issuer_for_valid_response(String validOrInvalid) {
        navigateToDrivingLicenceResponse(validOrInvalid);
    }

    @And("^JSON response should contain error description (.*) and status code as (.*)$")
    public void errorInJsonResponse(String testErrorDescription, String testStatusCode) throws JsonProcessingException {
        jsonErrorResponse(testErrorDescription, testStatusCode);
    }

    @And("I add a cookie to change the language to Welsh")
    public void iAddACookieToChangeTheLanguageToWelsh() {

        changeLanguageToWelsh();

    }*/









