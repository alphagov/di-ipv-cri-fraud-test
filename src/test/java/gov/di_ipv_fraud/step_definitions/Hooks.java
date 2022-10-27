package gov.di_ipv_fraud.step_definitions;

import com.google.common.collect.ImmutableMap;
import gov.di_ipv_fraud.utilities.Driver;
import io.cucumber.java.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.qameta.allure.Allure;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Hooks {

    @Before("@happy_passport")
    public void setUp() {
        Capabilities capabilities = ((RemoteWebDriver) Driver.get()).getCapabilities();
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", capabilities.getBrowserName())
                        .put("Browser Version", capabilities.getBrowserVersion())
                        .put("Environment", System.getenv("ENV"))
                        .build());
    }

}
