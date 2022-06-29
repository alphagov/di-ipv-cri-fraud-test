package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.utilities.ConfigurationReader;
import gov.di_ipv_fraud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static gov.di_ipv_fraud.pages.Headers.CHECKING_YOUR_DETAILS;
import static gov.di_ipv_fraud.pages.Headers.IPV_CORE_STUB;


public class FraudPageObject extends UniversalSteps {

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a/button")
    public WebElement visitCredentialIssuers;
    public static final String IPV_CORE_STUB_ENDPOINT = "ipvCoreStubEndpoint";
    @FindBy(xpath = "//*[@id=\"main-content\"]/p[7]/a/input")
    public WebElement fraudCRIBuild;
    @FindBy(xpath = "//*[@id=\"main-content\"]/p[8]/a/input")
    public WebElement fraudCRIStaging;
    @FindBy(id = "rowNumber")
    public WebElement selectRow;
    @FindBy(xpath = "//*[@id=\"main-content\"]/p[9]/a/input")
    public WebElement fraudCRIIntegration;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/button")
    public WebElement checkYourDetailsContinue;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/summary/span")
    public WebElement viewResponse;
    @FindBy(xpath = "//*[@id=\"main-content\"]/form[2]/div/button")
    public WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/details/summary/span")
    public WebElement whoWeCheckLink;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/details/div/p[1]/a")
    public WebElement experianLink;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/details/div/p[2]/a")
    public WebElement privacyPolicyLink;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details")
    public WebElement errorResponse;


    public FraudPageObject() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToIPVCoreStub() {
        Driver.get().get(ConfigurationReader.get(IPV_CORE_STUB_ENDPOINT));
        waitForTextToAppear(IPV_CORE_STUB);

    }

    public void navigateToFraudCRI(String environment) {
        visitCredentialIssuers.click();
        assertURLContains("credential-issuers");

        switch (environment) {
            case "Build":
                fraudCRIBuild.click();
                break;

            case "Staging":
                fraudCRIStaging.click();
                break;

            case "Integration":
                fraudCRIIntegration.click();
                break;

            default:
                break;

        }

    }

    public void searchForUATUser(String number) {
        assertURLContains("credential-issuer?cri=fraud-cri");
        selectRow.sendKeys(number);
        searchButton.click();

    }

    public void navigateToResponse(String validOrInvalid) {
        waitForTextToAppear(CHECKING_YOUR_DETAILS);
        checkYourDetailsContinue.click();
        assertURLContains("callback");
        if ("Invalid".equalsIgnoreCase(validOrInvalid)) {
            errorResponse.click();
        } else {
            viewResponse.click();
        }
    }

    public void whoWeCheckDetailsWith(String page) {
        waitForTextToAppear(CHECKING_YOUR_DETAILS);
        whoWeCheckLink.click();


        if ("Experian".equalsIgnoreCase(page)) {
            experianLink.click();
            ArrayList<String> newTb = new ArrayList<String>(Driver.get().getWindowHandles());
            Driver.get().switchTo().window(newTb.get(1));
            assertURLContains("https://www.experian.co.uk/");
            Driver.get().close();
            Driver.get().switchTo().window(newTb.get(0));

        } else {
            privacyPolicyLink.click();
            ArrayList<String> newTb = new ArrayList<String>(Driver.get().getWindowHandles());
            Driver.get().switchTo().window(newTb.get(1));
            assertURLContains("privacy-notice");
            Driver.get().close();
            Driver.get().switchTo().window(newTb.get(0));
        }


    }

}
