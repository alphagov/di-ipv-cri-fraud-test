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

  @Unhappy_path_MissingDetails_to_Throw_Error
  Scenario Outline: User Search with missing details UnHappy Path (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the <environment> environment
    When I search for user name Richard Gillis in the Experian table
    And I click on Edit User link
    And I remove the postcode
    And I remove the house number
    And I click on Go to Fraud CRI link after Edit
    Then I navigate to the verifiable issuer to check for a Invalid response from experian
    And JSON response should contain error details and status code as 302
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |
      | Staging     |
      | Integration |
