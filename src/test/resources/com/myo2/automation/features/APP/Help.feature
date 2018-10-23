@DONE
Feature: FAQ's
  As a user
  I want to view FAQ's
  so that i can get information related to PP

  Background:
    Given i launch the app

  @App @Account @IOS @ANDROID
  Scenario: Verify the "FAQ" page displays correctly (LoggedIn Mode)
    Given i am on HOME screen
    When i sign in with DMC user profile
    Then the login should succeed
    When i navigate to HELP tab
    Then FAQs should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: Verify the "FAQ" page displays correctly (LoggedOut Mode)
    Given i launch the app
    When i navigate to HELP tab
    Then FAQs should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: Verify the "ContactUs" page displays correctly (LoggedIn Mode)
    Given i am on HOME screen
    When i sign in with DMC user profile
    Then the login should succeed
    When i navigate to HELP tab
    And i switch to ContactUs
    Then ContactUs should be correctly displayed

  @App @Account @IOS @ANDROID 
  Scenario: Verify the "ContactUs" page displays correctly (LoggedOut Mode)
    Given i launch the app
    When i navigate to HELP tab
    And i switch to ContactUs
    Then ContactUs should be correctly displayed