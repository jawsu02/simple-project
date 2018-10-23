Feature: OfferInfo
  As a user
  I want to view / generate offers
  So that i can redeem them

  Background:
    Given i launch the app

  @App @OfferInfo @IOS @ANDROID
  Scenario: View Offer Information
    Given i am on HOME screen
    And i sign in with DEFAULT user profile
    And the login should succeed
    And i am on QUICK_SEARCH screen
    And i input CHANGI in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    When i choose to view all RETAIL_OFFERS
    And i select result 1 in offers
    Then i should see OFFER_INFORMATION

  @App @OfferInfo @IOS @ANDROID
  Scenario: Generate an offer
    Given i am on HOME screen
    And i sign in with DEFAULT user profile
    And the login should succeed
    And i am on QUICK_SEARCH screen
    And i input CHANGI in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    And i choose to view all RETAIL_OFFERS
    And i select result 1 in offers
    When i tap on REDEEM
    Then i should see QR_CODE

  @App @OfferInfo @IOS @ANDROID
  Scenario: View generated Offer
    Given i am on HOME screen
    And i sign in with DEFAULT user profile
    And the login should succeed
    And i am on QUICK_SEARCH screen
    And i input CHANGI in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    And i choose to view all RETAIL_OFFERS
    And i select result 1 in offers
    When i tap on REDEEM
    Then i should see GENERATED_OFFER_DETAILS