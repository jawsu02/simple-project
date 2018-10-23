@DONE
Feature: Bottom Nav
  As a user
  I want to view bottom nav
  so that i can easily access app features

  Background:
    Given i launch the app

  @App @Nav @IOS @ANDROID
  Scenario: Verify Bottom Navigation when logged out
    Given i launch the app
    Then the bottom nav should have HOME tab
    And the bottom nav should have HELP tab
    And the bottom nav should have ACCOUNT tab

  @App @Nav @IOS @ANDROID
  Scenario: Verify Bottom Navigation when logged in with DMC User
    Given i am on HOME screen
    When i sign in with DMC user profile
    Then the login should succeed
    And the bottom nav should have HOME tab
    And the bottom nav should have HELP tab
    And the bottom nav should have ACCOUNT tab
    And the bottom nav should have CARD tab

  @App @Nav @IOS @ANDROID
  Scenario: Verify Bottom Navigation when logged in with NON DMC User
    Given i am on HOME screen
    When i sign in with NON_DMC user profile
    Then the login should succeed
    And the bottom nav should have HOME tab
    And the bottom nav should have HELP tab
    And the bottom nav should have ACCOUNT tab