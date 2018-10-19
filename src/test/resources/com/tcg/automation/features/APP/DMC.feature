@DONE
Feature: DMC
  As a user
  I want to view my DMC
  so that i can access lounge faster

  Background:
    Given i launch the app

  @App @DMC @IOS @ANDROID
  Scenario: View DMC
    Given i am on HOME screen
    When i sign in with DMC user profile
    Then the login should succeed
    When i navigate to DMC tab
    Then i can view my DMC

  @App @DMC @IOS @ANDROID
  Scenario: DMC not displayed for Non DMC user
    Given i am on HOME screen
    When i sign in with NON_DMC user profile
    Then the login should succeed
    And DMC tab should not be displayed

