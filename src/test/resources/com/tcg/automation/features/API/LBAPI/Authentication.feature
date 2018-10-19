Feature: Authentication

  Background:
    Given I create a NEW LB request

  @LB_API @Authentication
  Scenario Outline: Verify username availability for PP
    Given I set query parameters productCode to PP
    And I set query parameters username to <UserNames>
    When I perform GET on LB_USER_NAME_AVAILABLE resource
    Then response status code should be 200
    And response body should contain key IsAvailableUsername
    Examples:
      | UserNames |
      | paas500   |
      | ppas3300  |

  @LB_API @Authentication
  Scenario: Get Security Questions
    When I perform GET on LB_SECURITY_QUESTIONS resource
    Then response status code should be 200
    And response body should contain key QuestionCode
    And response body should contain key QuestionText
