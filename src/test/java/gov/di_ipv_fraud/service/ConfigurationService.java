package gov.di_ipv_fraud.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.lambda.powertools.parameters.ParamProvider;
import software.amazon.lambda.powertools.parameters.SecretsProvider;

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

    public ConfigurationService(
            SecretsProvider secretsProvider, ParamProvider paramProvider, String env) {

        if (StringUtils.isBlank(env)) {
            throw new IllegalArgumentException("env must be specified");
        }

        this.parameterPrefix = System.getenv("AWS_STACK_NAME");
        this.contraindicationMappings = getParameter(paramProvider, "contraindicationMappings");
        this.fraudResultTableName = getParameter(paramProvider, "FraudTableName");
        this.redirectUri = getParameter(paramProvider, "redirectUri");
        this.clientId = getParameter(paramProvider, "clientId");
        this.publicApiBaseUrl = getParameter(paramProvider, "apiBaseUrl");
        this.coreStubUrl = getParameter(paramProvider, "coreStubUrl");
        this.coreStubUsername = getParameter(paramProvider, "coreStubUsername");
        this.coreStubPassword = getParameter(paramProvider, "coreStubPassword");
        this.passportCriUrl = getParameter(paramProvider, "passportCriUrl");
    }

    private String getParameter(ParamProvider paramProvider, String paramName) {
        if (null != paramProvider) {
            return paramProvider.get(getParameterName(paramName));
        } else {
            String parameterValue = System.getenv(paramName);
            Objects.requireNonNull(parameterValue);
            return parameterValue;
        }
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

    public String getParameterName(String parameterName) {
        return String.format("/%s/%s", parameterPrefix, parameterName);
    }
}
