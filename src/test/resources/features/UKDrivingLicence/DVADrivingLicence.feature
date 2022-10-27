Feature: DVA Driving Licence Test

  Background:
    Given I navigate to the IPV Core Stub
    And I click the Driving Licence CRI for the Build environment
    And I search for Driving Licence user number 5 in the Experian table
    And I should be on `Who was your UK driving licence issued by` page
    And I click on DVA radio button and Continue
    And I should be on `Enter your details exactly as they appear on your UK driving licence` page

  @DVLADrivingLicence_test @build
  Scenario Outline:  DVLA Driving Licence details page happy path
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain validity score 2 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject             |
      |DrivingLicenceSubjectHappyPeter   |

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectDrivingLicenceNumber
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject      |
      |IncorrectDrivingLicenceNumber |

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path when licence number date format does not match with User's Date Of Birth
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then proper error message for invalid Driving Licence should be displayed
    And proper error message for invalid Date of Birth should be displayed
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject      |
      |InvalidDrivingLicenceNumber |

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectDateOfBirth
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then proper error message for invalid Date of Birth should be displayed
    And proper error message for invalid Driving Licence should be displayed
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject |
      |IncorrectDateOfBirth |

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectFirstName
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject |
      |IncorrectFirstName|

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectLastName
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject      |
      |IncorrectLastName|

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectIssueDate
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject |
      |IncorrectIssueDate|

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectValidToDate
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject |
      |IncorrectValidToDate|

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectIssueNumber
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject |
      |IncorrectIssueNumber|

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence details page unhappy path with IncorrectPostcode
    Given User enters data as a <DrivingLicenceSubject>
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject |
      |IncorrectPostcode|

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence Retry Test Happy Path
    Given User enters invalid Driving Licence DVLA details
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User Re-enters data as a <DrivingLicenceSubject>
    And User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain validity score 2 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject             |
      |DrivingLicenceSubjectHappyPeter |

  @DVLADrivingLicence_test @build
  Scenario Outline: DVLA Driving Licence User failed second attempt
    Given User enters invalid Driving Licence DVLA details
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User Re-enters data as a <DrivingLicenceSubject>
    And User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject |
      |IncorrectDrivingLicenceNumber |

  @DVLADrivingLicence_test @build
  Scenario: DVLA Driving Licence User cancels after failed first attempt
    Given User enters invalid Driving Licence DVLA details
    When User clicks on continue
    Then Proper error message for Could not find DVLA details is displayed
    When User click on ‘prove your identity another way' Link
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain ci DO2, validity score 0 and strength score 3
    And The test is complete and I close the driver

  @DVLADrivingLicence_test @build
  Scenario: DVLA Driving Licence User cancels before first attempt via prove your identity another way route
    Given User click on ‘prove your identity another way' Link
    Then I navigate to the Driving Licence verifiable issuer to check for a Invalid response
    And JSON response should contain error description Authorization permission denied and status code as 302
    And The test is complete and I close the driver

  @DVLADrivingLicence_test @build
  Scenario: DVLA Driving Licence User cancels before first attempt via I do not have a UK driving licence route
    Given User click on ‘Back' Link
    When User click on I do not have a UK driving licence radio button
    Then I navigate to the Driving Licence verifiable issuer to check for a Invalid response
    And JSON response should contain error description Authorization permission denied and status code as 302
    And The test is complete and I close the driver