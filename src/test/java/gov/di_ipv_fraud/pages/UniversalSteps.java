package gov.di_ipv_fraud.pages;

import gov.di_ipv_fraud.utilities.BrowserUtils;


public class UniversalSteps {

    public void waitForFiveSeconds() {
        BrowserUtils.waitForPageToLoad(5);
    }
}
