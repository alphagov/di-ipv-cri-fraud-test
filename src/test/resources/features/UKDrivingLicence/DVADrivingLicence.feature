Feature: DVA Driving Licence Test

  Background:
    Given I navigate to the IPV Core Stub
    And I click the Driving Licence CRI for the Build environment
    And I search for Driving Licence user number 5 in the Experian table
    And I should be on `Who was your UK driving licence issued by` page
    And I click on DVA radio button and Continue
    And I should be on DVA `Enter your details exactly as they appear on your UK driving licence` page

  @DVADrivingLicence_test @build
  Scenario Outline:  DVA Driving Licence details page happy path
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain validity score 2 and strength score 3
    And JSON response should contain documentNumber 55667788 same as given Driving Licence
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject             |
      |DVADrivingLicenceSubjectHappyBilly   |

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with InvalidDVADrivingLicenceDetails
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Invalid response
    And JSON response should contain error description Authorization permission denied and status code as 302
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject      |
      |DVADrivingLicenceSubjectUnhappySelina |

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with IncorrectDVADrivingLicenceNumber
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And JSON response should contain documentNumber 88776655 same as given Driving Licence
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject      |
      |IncorrectDVADrivingLicenceNumber |


  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with IncorrectDVADateOfBirth
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |IncorrectDVADateOfBirth |

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with IncorrectDVAFirstName
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |IncorrectDVAFirstName|

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with IncorrectDVALastName
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |IncorrectDVALastName|

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with IncorrectDVAIssueDate
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |IncorrectDVAIssueDate|

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with IncorrectDVAValidToDate
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |IncorrectDVAValidToDate|

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence details page unhappy path with IncorrectDVAPostcode
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |IncorrectDVAPostcode|

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence Retry Test Happy Path
    Given User enters invalid Driving Licence DVA details
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User Re-enters DVA data as a <DVADrivingLicenceSubject>
    And User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain validity score 2 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |DVADrivingLicenceSubjectHappyBilly |

  @DVADrivingLicence_test @build
  Scenario Outline: DVA Driving Licence User failed second attempt
    Given User enters invalid Driving Licence DVA details
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User Re-enters DVA data as a <DVADrivingLicenceSubject>
    And User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject |
      |IncorrectDVADrivingLicenceNumber |

  @DVADrivingLicence_test @build
  Scenario: DVA Driving Licence User cancels after failed first attempt
    Given User enters invalid Driving Licence DVA details
    When User clicks on continue
    Then Proper error message for Could not find your details is displayed
    When User click on ‘prove your identity another way' Link
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver

  @DVADrivingLicence_test @build
  Scenario: DVA Driving Licence User cancels before first attempt via prove your identity another way route
    Given User click on ‘prove your identity another way' Link
    Then I navigate to the Driving Licence verifiable issuer to check for a Invalid response
    And JSON response should contain error description Authorization permission denied and status code as 302
    And The test is complete and I close the driver

  @DVADrivingLicence_test @build
  Scenario: DVA Driving Licence User cancels before first attempt via I do not have a UK driving licence route
    Given User click on ‘Back' Link
    When User click on I do not have a UK driving licence radio button
    Then I navigate to the Driving Licence verifiable issuer to check for a Invalid response
    And JSON response should contain error description Authorization permission denied and status code as 302
    And The test is complete and I close the driver

  @DVADrivingLicence_test @build
  Scenario Outline:  DVA Driving Licence Generate VC with invalid DL number and prove in another way unhappy path
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    When User click on ‘prove your identity another way' Link
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON response should contain documentNumber 88776655 same as given Driving Licence
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject           |
      | IncorrectDVADrivingLicenceNumber     |