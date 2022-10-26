package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.service.ConfigurationService;
import gov.di_ipv_fraud.utilities.BrowserUtils;
import gov.di_ipv_fraud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.logging.Logger;

import static gov.di_ipv_fraud.pages.Headers.IPV_CORE_STUB;

public class DLUnrecoverableErrorPageObject extends UniversalSteps {

    private static final Logger LOGGER = Logger.getLogger(DLUnrecoverableErrorPageObject.class.getName());

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a")
    public WebElement visitCredentialIssuers;

   @FindBy(xpath = "//*[@id=\"main-content\"]/p[5]/a/input")
    public WebElement drivingLicenceCRIDev;

    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement goToDLCRIButton;

    @FindBy(id = "rowNumber")
    public WebElement selectRow;

    @FindBy(id = "header")
    public WebElement errorTitle;

   public void navigateToDrivingLicenceCRIDev()
    {
        visitCredentialIssuers.click();
        BrowserUtils.waitForPageToLoad(100);
        drivingLicenceCRIDev.click();
        BrowserUtils.waitForPageToLoad(100);
    }

    public void searchForUATUser(String number) {
        assertURLContains("credential-issuer?cri=driving-licence");
        selectRow.sendKeys(number);
    }

    public void navigateToDrivingLicenceCRI() {
        goToDLCRIButton.click();
    }

   public void errorPageURLValidation() {

       String actualTitle = Driver.get().getTitle();
       String expTitle = "Sorry, there is a problem – – GOV.UK";
       if (actualTitle.equals(expTitle)) {

           System.out.println(actualTitle + " is same");
       } else {

           System.out.println(actualTitle + " is not same");
       }
   }

   public void validateErrorPageHeading() {
       String expectedText = "Sorry, there is a problem";
       String actualText = errorTitle.getText();
       if (actualText.equals(expectedText)) {
           System.out.println(actualText + " is same");
       } else {
           System.out.println(actualText + " is not same");
       }
   }
}
