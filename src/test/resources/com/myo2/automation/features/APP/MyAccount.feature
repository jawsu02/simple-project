@DONE
Feature: My Account
  As a user
  I want to view my account information
  so that i can easily view my information

  Background:
    Given i launch the app

  @App @Account @IOS @ANDROID
  Scenario: Validate My Account Page loads correctly (LoggedOut Mode)
    Given i navigate to ACCOUNT tab
    Then ACCOUNT should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: TermsAndConditions load correctly (LoggedOut Mode)
    Given i navigate to ACCOUNT tab
    When i tap on TermsAndConditions
    Then TermsAndConditions should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: PrivacyPolicy load correctly (LoggedOut Mode)
    Given i navigate to ACCOUNT tab
    When i tap on PrivacyPolicy
    Then PrivacyPolicy should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: LanguageSettings load correctly (LoggedOut Mode)
    Given i navigate to ACCOUNT tab
    When i tap on LanguageSettings
    Then LanguageSettings should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: TermsAndConditions load correctly (LoggedIn Mode)
    Given i navigate to ACCOUNT tab
    And i sign in with DEFAULT user profile from Account
    When i tap on TermsAndConditions
    Then TermsAndConditions should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: PrivacyPolicy load correctly (LoggedIn Mode)
    Given i navigate to ACCOUNT tab
    And i sign in with DEFAULT user profile from Account
    When i tap on PrivacyPolicy
    Then PrivacyPolicy should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: LanguageSettings load correctly (LoggedIn Mode)
    Given i navigate to ACCOUNT tab
    And i sign in with DEFAULT user profile from Account
    When i tap on LanguageSettings
    Then LanguageSettings should be correctly displayed

  @App @Account @IOS @ANDROID
  Scenario: User able to Logout
    Given i navigate to ACCOUNT tab
    And i sign in with DEFAULT user profile from Account
    When i tap on Logout
    Then i should be logged out

  @App @Account @IOS @ANDROID
  Scenario: VisitHistory load correctly
    Given i mock all login dependant endpoints to default response
    Given i navigate to ACCOUNT tab
    And i sign in with B2B_WHOLESALE_USER user profile from Account
    When i tap on VisitHistory
    Then VisitHistory should be correctly displayed
