package gov.di_ipv_fraud.utilities;

import gov.di_ipv_fraud.service.ConfigurationService;
import software.amazon.lambda.powertools.parameters.ParamManager;

public class PassportAPIGlobals {

    public String redirectURI;
    public String passportAuthUrl;
    public String tokenPostUrl;
    public String credentialGetUrl;
    public String clientId;
    public String grant_type;

    public PassportAPIGlobals() {
        ConfigurationService configurationService = new ConfigurationService(
                ParamManager.getSecretsProvider(),
                ParamManager.getSsmProvider(),
                System.getenv("ENVIRONMENT"));

        redirectURI = configurationService.getRedirectUri();

        String passportCriUrl = configurationService.getPassportCriUrl();
        String redirectUri = configurationService.getRedirectUri();
        String clientId = configurationService.getClientId();

        passportAuthUrl = passportCriUrl + "/oauth2/authorize?redirect_uri=" + redirectUri + "&client_id=" + clientId + "&response_type=code&scope=openid";
        tokenPostUrl = configurationService.getPublicApiBaseUrl() + "/token";
        credentialGetUrl = configurationService.getPublicApiBaseUrl() + "/credential";
        clientId = configurationService.getClientId();
        grant_type = "authorization_code";
    }



}
