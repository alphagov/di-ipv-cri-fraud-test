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
    And JSON payload should contain user's House name as Test 45 and House number as 455
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |
      | Staging     |
      | Integration |

  @happy_path_with_ci_fraud
  Scenario Outline: User Journey Happy Path with A01 CI (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the <environment> environment
    Then I search for user number 34 in the Experian table
    And I navigate to the verifiable issuer to check for a Valid response from experian
    And JSON payload should contain ci A01
    And The test is complete and I close the driver

    Examples:
      | environment |
      | Build       |

  @pep_test_all_users
  Scenario Outline: Edit User Happy Path with pep CI (STUB)
    Given I navigate to the IPV Core Stub
    And I click the Fraud CRI for the Build environment
    And I search for user name LINDA DUFF in the Experian table
    When I click on Edit User link
    And I am on Edit User page
    And I clear existing Date of Birth
    And I enter Date of birth as <dob>
    And I clear existing first name
    And I clear existing surname
    And I enter name <name>
    And I submit user updates
    And I navigate to the verifiable issuer to check for a Valid response from experian
    And JSON payload should contain ci <ci>
    And The test is complete and I close the driver

    Examples:
      | name                    | dob            | ci |
      | ANTHONY ROBERTS         | 17/02/1963     | P01 |
      | ALAVEEN	MCOLIVER		| 12/07/1962     | P01 |
      | ANTHONY	ROBERTS			| 17/02/1963     | P01 |
      | SPIROS ALLANIS			| 23/02/1985     | P01 |
      | ALBERT ARKIL			| 30/05/1947     | P01 |
      | KATHERINE MILES			| 04/07/1963     | P01 |
      | AMANDA HUSSEIN			| 03/05/1981     | P01 |
      | LISA WHALEY				| 28/11/1974     | P01 |
      | CHRISTOPHER	LUKYAMUZI	| 03/10/1968     | P01 |
      | INDUMATHY OSHEA			| 19/12/1961     | P01 |
      | MICHELLE VORAPRAWAT		| 19/08/1978     | P01 |
      | DOUGLAS	BEASLEY			| 25/08/1980     | P01 |
      | SIMON LEPPIK			| 19/10/1971     | P01 |
      | PHILLIP CRIS			| 16/12/1988     | P01 |
      | JOYCE BASU				| 23/02/1943     | P01 |
      | MARY MURTAGH			| 22/02/1960     | P01 |
      | JOHN SAGGAN				| 23/07/1936     | P01 |
      | JEAN DUPHIE				| 30/10/1950     | P01 |
      | IAN	PADFIELD			| 24/05/1976     | P01 |
      | BARRY WYLIE				| 08/06/1958     | P01 |
      | LYNNE BROWNLIE			| 26/04/1968     | P01 |
      | RENEE JULIE				| 03/04/1973     | P01 |
      | CHRISTINE BRUTON		| 07/09/1961     | P01 |
      | DAVID ATTWATER			| 03/11/1959     | P01 |
      | VICTORIA WOOD			| 27/02/1985     | P01 |
      | CASSIE MORRIS			| 13/10/2000     | P01 |
      | SIMON HAMMOND			| 19/08/1980     | P01 |
      | DIPTI STUPPART			| 26/01/1989     | P01 |
      | JAMALA BROWER			| 27/10/1963     | P01 |