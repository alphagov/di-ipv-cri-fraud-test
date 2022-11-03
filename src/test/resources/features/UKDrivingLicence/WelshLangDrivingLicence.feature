Feature: Driving License Test

  Background: @happy_path @build
    Given I navigate to the IPV Core Stub
    And I click the Driving Licence CRI for the Build environment
    Then I search for Driving Licence user number 5 in the Experian table
    And I add a cookie to change the language to Welsh
    Then I check the page title Pwy wnaeth gyhoeddi eich trwydded yrru y DU?
    And I assert the URL is valid in Welsh

  @DrivingLicenceTest
  Scenario:3 options and Radio button available in Driving Licence page
   Then I check the page title Pwy wnaeth gyhoeddi eich trwydded yrru y DU?
   And I assert the URL is valid in Welsh
   Then I can see a radio button titled “DVLA”
    Then I can see a radio button titled “DVA”
    And I can see a radio button titled “Nid oes gennyf drwydded yrru y DU”
    And I can see “neu”
    Then I can see CTA as Parhau
   And I see the sentence  I see the sentence starts with “Gallwch ddod o hyd i hwn yn adran"
   And The test is complete and I close the driver

  @DrivingLicenceTest
  Scenario:User Selects DVLA and landed in DVLA page and Validate the sentences
    Given I click on DVLA radio button and Parhau
    Then I should on the page DVLA and validate title
    And I see the heading Rhowch eich manylion yn union fel maent yn ymddangos ar eich trwydded yrru
    And I see the sentence starts with "Byddwn yn gwirio eich manylion gydar DVLA"
    And I see the sentence below Os nad oes gennych drwydded yrru y DU neu os na allwch gofio'ch manylion, gallwch brofi pwy ydych chi mewn ffordd arall yn lle.
    And The test is complete and I close the driver

  @DrivingLicenceTest
  Scenario:DVLA Name fields
    Given I click on DVLA radio button and Parhau
    When I can see the lastname as Enw olaf
    And I can see Given name as Enwau a roddwyd
    And I can see First name as Enw cyntaf
    And I can see the middle name as Enwau canol
    And I can see the sentence “Mae hwn yn adran 2 och trwydded. Nid oes angen i chi gynnwys eich teitl.”
    And I can see the sentence “Gadewch hyn yn wag os nad oes gennych unrhyw enwau canol”

  @DrivingLicenceTest
  Scenario: DVLA DoB   Field
    Given I click on DVLA radio button and Parhau
    When I can see the DoB fields titled “Dyddiad geni”
    When I can see example as Er enghraifft
    Then I can see date as “Diwrnod”
    And I can see month as “Mis”
    And I can see year as “Blwyddyn”

  @DrivingLicenceTest
  Scenario: DVLA Issue date field
    Given I click on DVLA radio button and Parhau
    Given I can see the Issue date field titled “Dyddiad cyhoeddi”
    Then Dyma r dyddiad yn adran 4a o ch trwydded, er enghraifft 27 5 2019
    Then I can see date as “Diwrnod”
    And I can see month as “Mis”
    And I can see year as “Blwyddyn”

  Scenario:DVLA Valid to date field
    Given I click on DVLA radio button and Parhau
    Then I can see the Valid to date field titled “Yn ddilys tan”
    And Dyma r dyddiad yn adran 4b o ch trwydded, er enghraifft 27 5 2019
    Then I can see date as “Diwrnod”
    And I can see month as “Mis”
    And I can see year as “Blwyddyn”

  Scenario: DVLA Licence number
    Given I click on DVLA radio button and Parhau
    When I can see the licence number field titled “Rhif trwydded”
    And I see the sentence “Dyma'r rhif hir yn adran  ar eich trwydded”

  Scenario:DVLA Issue number

    Given I click on DVLA radio button and Parhau
    Then I can see the issue number field titled “Dyddiad cyhoeddi”
    And I  can see “Dyma r rhif  ddigid ar ôl y gofod yn adran  o'ch trwydded”

  Scenario: DVLA Postcode

    Given I click on DVLA radio button and Parhau
    Then I can see the postcode field titled “Cod post”
    And “Rhowch y cod post yn y cyfeiriad yn adran  o ch trwydded”

  @DVLADrivingLicence_test @build
  Scenario Outline:  DVLA Driving Licence details page happy path
    Given I click on DVLA radio button and Parhau
    Then User enters data as a <DrivingLicenceSubject>
    When User clicks on Parhau
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain validity score 2 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DrivingLicenceSubject             |
      |DrivingLicenceSubjectHappyPeter   |

  @DrivingLicenceTest
  Scenario:User Selects DVA and landed in DVA page and Page title and sub-text
    Given I click on DVA radio button and Parhau
    Then I should on the page DVA and validate title
    When I see the heading Rhowch eich manylion yn union fel maent yn ymddangos ar eich trwydded yrru
    And I see the sentence starts with “Byddwn yn gwirio eich manylion gyda'r DVA”
    And I see the sentence below Os nad oes gennych drwydded yrru y DU neu os na allwch gofio'ch manylion, gallwch brofi pwy ydych chi mewn ffordd arall yn lle.
    And The test is complete and I close the driver

  Scenario: DVA Name fields

    Given I click on DVA radio button and Parhau
    When I can see the lastname as Enw olaf
    And I can see Given name as Enwau a roddwyd
    And I can see First name as Enw cyntaf
    And I can see the middle name as Enwau canol
    And I can see the sentence “Mae hwn yn adran 2 och trwydded. Nid oes angen i chi gynnwys eich teitl.”
    And I can see the sentence “Gadewch hyn yn wag os nad oes gennych unrhyw enwau canol”
    And The test is complete and I close the driver


  @DrivingLicenceTest
  Scenario: DVA DoB Field
    Given I click on DVA radio button and Parhau
    When I can see the DoB fields titled “Dyddiad geni”
    When I can see example as Er enghraifft
    Then I can see date as “Diwrnod”
    And I can see month as “Mis”
    And I can see year as “Blwyddyn”
    And The test is complete and I close the driver

  @DrivingLicenceTest
  Scenario: DVA Issue date field
    Given I click on DVA radio button and Parhau
    Given I can see the Issue date field titled “Dyddiad cyhoeddi”
    Then Dyma r dyddiad yn adran 4a o ch trwydded, er enghraifft 27 5 2019
    Then I can see date as “Diwrnod”
    And I can see month as “Mis”
    And I can see year as “Blwyddyn”
    And The test is complete and I close the driver

  Scenario:DVA Valid until field
    Given I click on DVA radio button and Parhau
    Then I can see the Valid to date field titled “Yn ddilys tan”
    And Dyma r dyddiad yn adran 4b o ch trwydded, er enghraifft 27 5 2019
    Then I can see date as “Diwrnod”
    And I can see month as “Mis”
    And I can see year as “Blwyddyn”
    And The test is complete and I close the driver

  Scenario: DVA Licence number
    Given I click on DVA radio button and Parhau
    When I can see the licence number field titled “Rhif trwydded”
    And I see the sentence “Dyma'r rhif hir yn adran  ar eich trwydded”
    And The test is complete and I close the driver

  Scenario: DVA Postcode

    Given I click on DVA radio button and Parhau
    Then I can see the postcode field titled “Cod post”
    And “Rhowch y cod post yn y cyfeiriad yn adran  o ch trwydded”

  @DVADrivingLicence_test @build
  Scenario Outline:  DVA Driving Licence details page happy path
    Given I click on DVA radio button and Parhau
    Given User enters DVA data as a <DVADrivingLicenceSubject>
    When User clicks on continue
    Then I navigate to the Driving Licence verifiable issuer to check for a Valid response
    And JSON payload should contain validity score 2 and strength score 3
    And The test is complete and I close the driver
    Examples:
      |DVADrivingLicenceSubject             |
      |DVADrivingLicenceSubjectHappyBilly   |

  @DrivingLicenceTest
  Scenario:User selects Nid oes gennyf drwydded yrru y DU and landed in IPV Core
    Given I click Nid oes gennyf drwydded yrru y DU and Parhau
    When I am directed to the IPV Core routing page
    And I validate the URL having access denied
    Then I navigate to the Driving Licence verifiable issuer to check for a Invalid response
    And JSON response should contain error description Authorization permission denied and status code as 302
    And The test is complete and I close the driver
























