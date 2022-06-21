package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.utilities.ConfigurationReader;
import gov.di_ipv_fraud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FraudPageObject extends UniversalSteps {

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a/button")
    public WebElement visitCredentialIssuers;
    @FindBy(xpath = "//*[@id=\"main-content\"]/p[20]/a/input")
    public WebElement fraudCRIStaging;
    @FindBy(id = "rowNumber")
    public WebElement selectRow;
    @FindBy(xpath = "//*[@id=\"main-content\"]/form[1]/div/button")
    public WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/form/button")
    public WebElement checkYourDetailsContinue;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/summary/span")
    public WebElement viewResponse;


    public FraudPageObject() {
        PageFactory.initElements(Driver.get(), this);
    }


    public void navigateToIPVCoreStub() {
        Driver.get().get(ConfigurationReader.get("ipvCoreStubEndpoint"));
        waitForFiveSeconds();

    }

    public void navigateToFraudCRI() {
        visitCredentialIssuers.click();
        waitForFiveSeconds();
        fraudCRIStaging.click();
    }

    public void searchForUATUser(String number) {
        waitForFiveSeconds();
        selectRow.sendKeys(number);
        searchButton.click();
        checkYourDetailsContinue.click();
        waitForFiveSeconds();
        viewResponse.click();

    }

}
