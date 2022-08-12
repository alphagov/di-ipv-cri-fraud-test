@proveYourIdentity_fullJourney
Feature: Prove Your Identity Full Journey

  @proveYourIdentity_happyPath
  Scenario: Prove Your Identity Full Journey Route (STUB)
    Given I navigate to the Orchestrator Stub
    And I click on Full journey route and Continue
    And I enter Passport Details
      | Passport number | Surname | First name |
      | 321654987       | DECERQUEIRA | KENNETH |
    And I enter Date of birth as 23/08/1959
    And I enter Passport Expiry date as 01/01/2030 and Continue
    And I enter BA2 5AA in the Postcode field and find address