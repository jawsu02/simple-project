Feature: Real Time Allocation
  As a user
  I want to view my RTA
  so that i can find the entitlements

  Background:
    Given i launch the app

  @App @RTA @IOS @ANDROID
  Scenario: RTA is enabled
    Given i navigate to ACCOUNT tab
    And i sign in with RTA_ENABLED user profile from Account
    Then RTA should be correctly displayed

  @App @RTA @IOS @ANDROID
  Scenario: RTA is disabled
    Given i navigate to ACCOUNT tab
    And i sign in with RTA_DISABLED user profile from Account
    Then RTA should not be displayed

  @App @RTA @IOS @ANDROID
  Scenario: Customer with allocations for members only
    Given i navigate to ACCOUNT tab
    And i sign in with MEMBER_ALLOCATIONS_ONLY user profile from Account
    Then RTA_BOTH entitlements should be displayed

  @App @RTA @IOS @ANDROID
  Scenario: Customer with shared allocations for members and guests
    Given i navigate to ACCOUNT tab
    And i sign in with SHARED_ALLOCATIONS user profile from Account
    Then RTA_MEMBER_ONLY entitlements should be displayed

  @App @RTA @IOS @ANDROID
  Scenario: Customer with infinite allocations
    Given i navigate to ACCOUNT tab
    And i sign in with INFINITE_ALLOCATIONS user profile from Account
    Then RTA_INFINITE_MEMBER entitlements should be displayed

  @App @RTA @IOS @ANDROID
  Scenario: Customer with limited allocations
    Given i navigate to ACCOUNT tab
    And i sign in with LIMITED_ALLOCATIONS user profile from Account
    Then RTA should be correctly displayed

  @App @RTA @IOS @ANDROID
  Scenario: RTA is enabled for B2C user
    Given i navigate to ACCOUNT tab
    And i sign in with B2C_USER user profile from Account
    Then RTA should not be displayed

  @App @RTA @IOS @ANDROID
  Scenario: RTA is enabled for a B2B Wholesale user
    Given i navigate to ACCOUNT tab
    And i sign in with B2B_WHOLESALE_USER user profile from Account
    Then RTA should not be displayed
