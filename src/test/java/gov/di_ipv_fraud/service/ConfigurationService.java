package gov.di_ipv_fraud.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class ConfigurationService {

    private static final Logger LOGGER = LogManager.getLogger();

    // For shared secret values
    private static final String KEY_FORMAT = "/%s/credentialIssuers/fraud/%s";

    private final String fraudResultTableName;
    private final String contraindicationMappings;
    private final String parameterPrefix;
    private final String redirectUri;
    private final String clientId;
    private final String publicApiBaseUrl;
    private final String coreStubUrl;
    private final String coreStubUsername;
    private final String coreStubPassword;
    private final String passportCriUrl;

    public ConfigurationService(String env) {

        if (StringUtils.isBlank(env)) {
            throw new IllegalArgumentException("env must be specified");
        }

        this.parameterPrefix = getParameter("STACK_NAME");
        this.contraindicationMappings = getParameter("contraindicationMappings");
        this.fraudResultTableName = getParameter("FraudTableName");
        this.redirectUri = getParameter("redirectUri");
        this.clientId = getParameter("clientId");
        this.publicApiBaseUrl = getParameter("apiBaseUrl");
        this.coreStubUrl = getParameter("coreStubUrl");
        this.coreStubUsername = getParameter("coreStubUsername");
        this.coreStubPassword = getParameter("coreStubPassword");
        this.passportCriUrl = getParameter("passportCriUrl");
    }

    private String getParameter(String paramName) {
        String parameterValue = System.getenv(paramName);
        Objects.requireNonNull(parameterValue);
        return parameterValue;
    }

    public String getFraudResultTableName() {
        return fraudResultTableName;
    }

    public String getContraindicationMappings() {
        return contraindicationMappings;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getClientId() {
        return clientId;
    }

    public String getPublicApiBaseUrl() {
        return publicApiBaseUrl;
    }

    public String getCoreStubUrl() {
        return coreStubUrl;
    }

    public String getCoreStubUsername() {
        return coreStubUsername;
    }

    public String getCoreStubPassword() {
        return coreStubPassword;
    }

    public String getPassportCriUrl() {
        return passportCriUrl;
    }
}
