@DONE
Feature: Find A Terminal
  As a user
  I want to find terminal
  so that i can find appropriate lounges

  Background:
    Given i launch the app

  @App @Terminal @IOS @ANDROID
  Scenario: Airport with Multiple Terminals
    Given i am on QUICK_SEARCH screen
    And i input LHR in quick search
    When i select result 1 in Airports
    Then 4 terminals should be displayed

  @App @Terminal @IOS @ANDROID
  Scenario: Airport with single Terminals and single lounge
    Given i am on QUICK_SEARCH screen
    And i input East London in quick search
    When i select result 1 in Airports
    Then LOUNGE_DETAILS screen should be displayed

  @App @Terminal @IOS @ANDROID
  Scenario: Terminal with Lounges and offers
    Given i am on HOME screen
    When i sign in with DEFAULT user profile
    Then the login should succeed
    When i am on QUICK_SEARCH screen
    And i input CHANGI in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    Then i should see LOUNGES_AND_OFFERS

  @App @Terminal @IOS @ANDROID
  Scenario: Terminal with multiple lounges and no offers
    Given i am on HOME screen
    When i sign in with DEFAULT user profile
    Then the login should succeed
    When i am on QUICK_SEARCH screen
    And i input LHR in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    Then i should see LOUNGES_ONLY

  @App @Terminal @IOS @ANDROID
  Scenario: Terminal with Single lounge and no offers
    Given i am on HOME screen
    When i sign in with DEFAULT user profile
    Then the login should succeed
    When i am on QUICK_SEARCH screen
    And i input LAX in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    Then LOUNGE_DETAILS screen should be displayed

  @App @Terminal @IOS @ANDROID @TODO
  Scenario: Verify Image Carousel
    Given i am on QUICK_SEARCH screen

  @App @Terminal @IOS @ANDROID @TODO
  Scenario: Terminal with no lounges and single offers
    Given i am on QUICK_SEARCH screen

  @App @Terminal @IOS @ANDROID @TODO
  Scenario: Terminal with no lounges and multiple offers
    Given i am on QUICK_SEARCH screen

