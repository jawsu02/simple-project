Feature: CMS

  Background:
    Given I create a NEW LB request

  @LB_API @CMS
  Scenario: Lounge data from CMS
    Given I set query parameters ProductCode to PP
    When I perform GET on LB_LATEST_LOUNGE_DATA resource
    Then response status code should be 200

  @LB_API @CMS
  Scenario: App translation data
    Given I set query parameters ProductCode to PP
    And I set query parameters languageCode to fr
    When I perform GET on LB_APP_TRANSLATION_DATA resource
    Then response status code should be 200
    And response body should contain key LanguageCode