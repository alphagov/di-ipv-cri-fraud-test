package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.service.ConfigurationService;
import gov.di_ipv_fraud.utilities.BrowserUtils;
import gov.di_ipv_fraud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.logging.Logger;

import static gov.di_ipv_fraud.pages.Headers.IPV_CORE_STUB;

public class DLUnrecoverableErrorPageObject extends UniversalSteps {

    private final ConfigurationService configurationService;
    private static final Logger LOGGER = Logger.getLogger(DLUnrecoverableErrorPageObject.class.getName());

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a")
    public WebElement visitCredentialIssuers;

    @FindBy(xpath = "//*[@id=\"main-content\"]/p[5]/a/input")
    public WebElement drivingLicenceCRIDev;

    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement goToDLCRIButton;

    @FindBy(id = "header")
    public WebElement errorTitle;

    public void DrivingLicenceCRIDev() {
        visitCredentialIssuers.click();
        drivingLicenceCRIDev.click();
    }

    public DLUnrecoverableErrorPageObject() {
        this.configurationService = new ConfigurationService(System.getenv("ENVIRONMENT"));
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToLocalHost() {
        String coreStubUsername = configurationService.getCoreStubUsername();
        String coreStubPassword = configurationService.getCoreStubPassword();
        String coreStubUrl = configurationService.getCoreStubUrl();
        String httpsEnabled = configurationService.gethttpsEnabled();
        coreStubUrl = coreStubUrl.substring(8);
        if (httpsEnabled.equals("yes")) {
            Driver.get()
                    .get(
                            "https://"
                                    + coreStubUsername
                                    + ":"
                                    + coreStubPassword
                                    + "@"
                                    + coreStubUrl);
        } else {
            Driver.get().get("http://" + coreStubUrl);
        }
        waitForTextToAppear(IPV_CORE_STUB);
    }

    public void navigateToDrivingLicenceCRI() {
        goToDLCRIButton.click();
    }

    public void errorPageURLValidation() {
        String actualTitle = Driver.get().getTitle();
        String expTitle = "Sorry, there is a problem – – GOV.UK";
        if (expTitle.equals(actualTitle)) {
            LOGGER.info("Pass : Error page is displayed");
        } else {
            LOGGER.info("Fail : Who was your UK driving licence issued by? is displayed");
        }
    }

    public void validateErrorPageHeading() {
        String expectedHeading = "Sorry, there is a problem";
        String actualHeading = errorTitle.getText();
        if (expectedHeading.equals(actualHeading)) {
            LOGGER.info("Pass : Sorry, there is a problem page is displayed");
        } else {
            LOGGER.info("Fail : Who was your UK driving licence issued by? is displayed");
        }
    }
}