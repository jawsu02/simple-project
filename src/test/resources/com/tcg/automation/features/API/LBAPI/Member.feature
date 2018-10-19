Feature: Members

  Background:
    Given I create a NEW LB request
    And I set header Content-Type to application/x-www-form-urlencoded
    And I set form parameter Username to mr_user129
    And I set form parameter Password to 65c21921ca10a8502757efc9aa552874d181c6206feb2845a921eb57f5e518d4
    And I set form parameter ProductCode to PP
    And I set form parameter GrantType to password
    And I set form parameter ClientId to mobileApp
    And I set form parameter ClientSecret to clientSecret
    When I perform POST on LB_AUTH_TOKEN resource
    Then response status code should be 200
    And response body should contain key access_token
    And I store the value of body path access_token as bearer_token

  @LB_API @Member
  Scenario: Get Consumer Titles
    Given I create a NEW LB request
    And I set bearer token to bearer_token
    When I perform GET on LB_MEMBER_TITLES resource
    Then response status code should be 200
    And response body should contain key Title[0]