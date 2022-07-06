package gov.di_ipv_fraud.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = "src/test/resources/features",
        glue = "gov/di_ipv_fraud/step_definitions",
        dryRun = false)
public class TestRunner {}
