@DONE
Feature: SignIn
  As a user
  I want to Sign In to app
  so that i can access my DMC

  Background:
    Given i launch the app

  @App @SignIn @IOS @ANDROID @Web
  Scenario: SignIn with valid credentials
    Given i am on HOME screen
    When i sign in with DEFAULT user profile
    Then the login should succeed

  @App @SignIn @IOS @ANDROID @Web
  Scenario: SignIn with invalid credentials
    Given i am on HOME screen
    When i sign in with 'INVALID', 'INVALID'
    Then the login should fail

  @App @SignIn @IOS @ANDROID
  Scenario: Reveal password text
    Given i am on LOGIN screen
    When i input PASSWORD in password field
    Then the value in password field should be ••••••••
    When i tap on RevealPassword
    Then the value in password field should be PASSWORD

  @App @SignIn @IOS @ANDROID @Web
  Scenario: Forgot Details
    Given i am on LOGIN screen
    When i tap on ForgotDetails
    Then FORGOTDETAILS should be correctly displayed

  @App @SignIn @IOS @ANDROID @Web
  Scenario: Registration web view
    Given i am on LOGIN screen
    When i tap on Register
    Then PP_REGISTRATION should be correctly displayed

  @App @SignIn @IOS @ANDROID @Web
  Scenario: Verify Join PP redirects to Join web page
    Given i am on Login screen
    When i tap on JoinPriorityPass
    Then JOIN_PP should be correctly displayed
