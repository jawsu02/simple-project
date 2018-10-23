Feature: Find A Lounge
  As a user
  I want to find a lounges
  so that i can find information about lounge

  Background:
    Given i launch the app

  @App @FindALounge @IOS @ANDROID
  Scenario: Find A Lounge by City Name
    Given i am on QUICK_SEARCH screen
    And i input LONDON in quick search
    And i select result 1 in Airports
    Then LOUNGE_DETAILS screen should be displayed

  @App @FindALounge @IOS @ANDROID
  Scenario: Find A Lounge by Airport Name
    Given i am on QUICK_SEARCH screen
    And i input HEATHROW in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    Then i should see LOUNGES_ONLY

  @App @FindALounge @IOS @ANDROID
  Scenario: Find A Lounge by Airport Code
    Given i am on QUICK_SEARCH screen
    And i input LHR in quick search
    And i select result 1 in Airports
    And i select result 1 in Terminals
    Then i should see LOUNGES_ONLY

  @App @FindALounge @IOS @ANDROID
  Scenario: Find A Lounge by Location
    Given i am on QUICK_SEARCH screen
    And i input UNITED KINGDOM in quick search
    And i select result 1 in Airports
    Then LOUNGE_DETAILS screen should be displayed

  @App @FindALounge @IOS @ANDROID
  Scenario: Search with no results
    Given i am on QUICK_SEARCH screen
    And i input NO RESULTS in quick search
    Then i should see 'NO_MATCHING_AIRPORTS'

  @App @FindALounge @IOS @ANDROID
  Scenario: Verify Lounge Information is correctly displayed
    Given i am on QUICK_SEARCH screen
    And i input East London in quick search
    When i select result 1 in Airports
    Then LOUNGE_DETAILS screen should be displayed
    And LOUNGE_INFORMATION should be correctly displayed
