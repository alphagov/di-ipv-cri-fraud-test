package gov.di_ipv_fraud.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    public static String getBrowser() {
        return System.getenv("BROWSER") != null ? System.getenv("BROWSER") : "chrome";
    }

    public static String getOrchestratorUrl() {
        String orchestratorStubUrl = System.getenv("ORCHESTRATOR_STUB_URL");
        if (orchestratorStubUrl == null) {
            throw new IllegalArgumentException("Environment variable ORCHESTRATOR_STUB_URL is not set");
        }
        return orchestratorStubUrl;
    }

    public static String getCoreStubUrl() {
        String coreStubUrl = System.getenv("CORE_STUB_URL");
        if (coreStubUrl == null) {
            throw new IllegalArgumentException("Environment variable CORE_STUB_URL is not set");
        }
        return coreStubUrl;
    }

    public static boolean noChromeSandbox() {
        return "true".equalsIgnoreCase(System.getenv("NO_CHROME_SANDBOX"));
    }
}
