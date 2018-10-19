@XAPI-24 @DONE

Feature: User can retrieve his information
  As an authenticated user browsing the new PP App,
  I want the App to download my profile and config,
  So that I can see the info in My Details section under My Account

  Background:
    Given I create a NEW XAPI request

  @API @UserInfo
  Scenario: Verify UserInfo using valid token
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform GET on USER_INFO resource
    Then response status code should be 200
    And response body should contain value of VS for key PaymentCards.LOUNGE_VISIT.CardType

  @API @UserInfo
  Scenario: UserInfo using client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to VALID details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform GET on USER_INFO resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @UserInfo
  Scenario Outline: Invalid HTTP VERB (non GET) on UserInfo endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on USER_INFO resource
    Then response status code should be 405
    And response body should contain value of 405 for key code
    And response body should contain value of Method Not Allowed for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @UserInfo
  Scenario: Get UserInfo Data using Missing Token
    When I perform GET on USER_INFO resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @UserInfo
  Scenario: Get UserInfo Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on USER_INFO resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json