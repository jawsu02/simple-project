@XAPI-32 @DONE

Feature: User can view Visit Allocation
  As an authenticated user browsing the new PP App,
  I want the App to download info about my total visit allocation,
  So that I can see the info in My Visits section under My Account.


  Background:
    Given I create a NEW XAPI request

  @API @RealTimeAllocation
  Scenario: Valid request for REAL_TIME_ALLOCATION
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform GET on REAL_TIME_ALLOCATION resource
    Then response status code should be 200
    And response body should be valid according to schema file realTimeAllocation.json

  @API @RealTimeAllocation
  Scenario: Request for REAL_TIME_ALLOCATION with Client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform GET on REAL_TIME_ALLOCATION resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of Unauthorized for key description
    And response body should be valid according to schema file error_schema.json

  @API @RealTimeAllocation
  Scenario Outline: Invalid HTTP VERB (non GET) on REAL_TIME_ALLOCATION endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on REAL_TIME_ALLOCATION resource
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

  @API @RealTimeAllocation
  Scenario: Get REAL_TIME_ALLOCATION Data using Missing Token
    When I perform GET on REAL_TIME_ALLOCATION resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @RealTimeAllocation
  Scenario: Get REAL_TIME_ALLOCATION Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on REAL_TIME_ALLOCATION resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json