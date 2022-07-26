@fraud_CRI
Feature: Fraud CRI

  @happy_path
  Scenario Outline: User Journey Happy Path (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the <environment> environment
    Then I search for user number 12 in the Experian table
    And I navigate to the verifiable issuer to check for a Valid response from experian
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |
      | Staging     |
      | Integration |


  @unhappy_path
  Scenario: User Journey Unhappy Path (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the Integration environment
    Then I search for user number 14 in the Experian table
    And I navigate to the verifiable issuer to check for a Invalid response from experian
    And The test is complete and I close the driver

  @external_links
  Scenario Outline: User Navigates To Experian/Privacy Policy
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the Integration environment
    Then I search for user number 12 in the Experian table
    Then I navigate to <page> and assert I have been directed correctly
    And The test is complete and I close the driver

    Examples:
      | page           |
      | Experian       |
      | Privacy Policy |

  @userSearch_by_userName_happyPath
  Scenario Outline: User Search By UserName User Journey Happy Path (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the <environment> environment
    When I search for user name Linda Duff in the Experian table
    And I click on Go to Fraud CRI link
    Then I navigate to the verifiable issuer to check for a Valid response from experian
    And JSON payload should contain user's name
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |
      | Staging     |
      | Integration |

  @Spinner_icon_within_Fraud_CRI_screen
  Scenario Outline: User is presented with a spinner when clicking on the Continue button in the Fraud CRI screen (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the <environment> environment
    And I search for user number 12 in the Experian table
    And I navigate to the page We need to check your details
    When I check Continue button is enabled and click on the Continue button
    Then I navigate to Verifiable Credentials page
    And I check for a Valid response from experian
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |
      | Staging     |
      | Integration |

  @userSearch_by_invalid_userName
  Scenario Outline: User Search By Invalid UserName(STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the <environment> environment
    When I search for user name Debra Kiritharnathan in the Experian table
    And I click on Go to Fraud CRI link
    Then I navigate to the verifiable issuer to check for a Invalid response from experian
    And JSON response should contain error details and status code as 302
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |
      | Staging     |
      | Integration |

  @edituser_happyPath
  Scenario Outline: Edit User Happy Path (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the <environment> environment
    And I search for user name Linda Duff in the Experian table
    When I click on Edit User link
    And I am on Edit User page
    And I enter Test 45 in the House name field
    And I clear existing House number
    And I enter 455 in the House number field
    Then I navigate to the verifiable issuer to check for a Valid response from experian
    And JSON payload should contain user's address details and House name as Test 45
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |
      | Staging     |
      | Integration |