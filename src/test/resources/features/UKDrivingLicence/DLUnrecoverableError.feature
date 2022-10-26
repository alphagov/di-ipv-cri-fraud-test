Feature: Driving License Test

 Background: @happy_path @localhost8085
    Given I navigate to the IPV Core Stub localhost
    When I navigate to User for Driving Licence CRI dev Page
    Then I search for Driving Licence user number 5 in the Experian table
    And I click Go to Driving Licence CRI dev button

  Scenario: Check the Unrecoverable error/ Unknown error in Driving Licence CRI
    Given I can see the relevant error page with correct title
    And I can see the heading  Sorry, there is a error
    And The test is complete and I close the driver

