package gov.di_ipv_fraud.pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.di_ipv_fraud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class DrivingLicencePageObject extends UniversalSteps {

    private static final Logger LOGGER = Logger.getLogger(DrivingLicencePageObject.class.getName());

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a/button")
    public WebElement visitCredentialIssuers;

    @FindBy(xpath = "//*[@value=\"Driving Licence CRI Build\"]")
    public WebElement drivingLicenceCDRIBuild;

    @FindBy(xpath = "//*[@value=\"Driving Licence CRI Staging\"]")
    public WebElement drivingLicenceCDRIStaging;

    @FindBy(xpath = "//*[@value=\"Driving Licence CRI Integration\"]")
    public WebElement drivingLicenceCDRIIntegration;

    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement goToDLCRIButton;

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

    public void navigateToSelectDrivingLicenceCRI(String environment) {
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

    public void searchForUATUser(String number) {
        assertURLContains("credential-issuer?cri=driving-licence");
        selectRow.sendKeys(number);
    }

    public void navigateToDrivingLicenceCRI() {
        goToDLCRIButton.click();
    }

    public void drivingLicencePageURLValidation() {
        String expectedUrl = "https://review-d.build.account.gov.uk/licence-issuer";
        String actualUrl = Driver.get().getCurrentUrl();
        LOGGER.info("expectedUrl = " + expectedUrl);
        LOGGER.info("actualUrl = " + actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void validateDLPageTitle() {
        String actualTitle = Driver.get().getTitle();
        String expTitle = "Who was your UK driving licence issued by? – – GOV.UK";
        if (actualTitle.equals(expTitle)) {
            LOGGER.info("Pass : directed to Who was your UK driving license issued by?");
        } else {
            LOGGER.info("Fail : not directed to the Driving Licence Page");
        }
    }

    public void titleDVLAWithRadioBtn() {
        optionDVLA.isDisplayed();
        radioBtnDVLA.isDisplayed();
    }

    public void titleDVAWithRadioBtn() {
        optionDVA.isDisplayed();
        radioBtnDVA.isDisplayed();
    }

    public void noDrivingLicenceBtn() {
        noDLOption.isDisplayed();
        noDLRadioBtn.isDisplayed();
    }

    public void ContinueButton() {
        CTButton.isDisplayed();
        CTButton.isEnabled();
    }

    public void clickOnDVLARadioButton() {
        radioBtnDVLA.click();
        CTButton.click();
    }

    public void pageTitleDVLAValidation() {
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

    public void errorDetails(String validOrInvalid) {
        assertURLContains("callback");
        if ("Invalid".equalsIgnoreCase(validOrInvalid)) {
            new DrivingLicencePageObject().errorResponse.click();
        } else {
            new DrivingLicencePageObject().viewResponse.click();
        }
    }

    public void jsonErrorResponse(String testErrorDescription, String testStatusCode)
            throws JsonProcessingException {
        //  String testErrorDescription = "general error";
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
}
