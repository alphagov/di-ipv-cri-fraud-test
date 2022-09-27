@fraud_CRI_API
Feature: Fraud CRI API

  @intialJWT_happy_path @dev
  Scenario: Acquire initial JWT (STUB)
    Given user has the user identity in the form of a signed JWT string for CRI Id fraud-cri-dev
    When user sends a POST request to session end point in dev environment
    Then user gets a session-id

  @intialJWT_happy_path @build
  Scenario: Acquire initial JWT (STUB)
    Given user has the user identity in the form of a signed JWT string for CRI Id fraud-cri-build
    When user sends a POST request to session end point in build environment
    Then user gets a session-id