# di-ipv-cri-fraud-test

This repo has be created as a central repository for any work related to Fraud CRI.

## Build

Build with `./gradlew`

### Run tests
When running locally the following environment variables must be set


ENVIRONMENT \
AWS_STACK_NAME \
 contraindicationMappings \
 FraudTableName \
 redirectUri \
 clientId \
 apiBaseUrl \
 coreStubUrl \
 coreStubUsername \
 coreStubPassword \
 passportCriUrl 

Speak to a member of the test team for these values
When running in the pipeline these will be taken from AWS

Run tests with `./gradlew cucumber -P tags=@fraud_CRI`
