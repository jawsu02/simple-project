@XAPI-31 @DONE

Feature: User can view Visit information
  As an authenticated user browsing the new PP App,
  I want the App to download visit information,
  So that I can see it in the My Visits section under My Account

  Background:
    Given I create a NEW XAPI request

  @API @Visits
  Scenario: Valid request for VISIT_INFORMATION
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to USER_WITH_VISITS details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters loungeVisitDateFrom to 2016-10-20T07:48:05.060Z
    And I set query parameters loungeVisitDateTo to 2017-10-20T07:48:05.060Z
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 200
    And response body should be valid according to schema file visitInformation.json

  @API @Visits
  Scenario: Valid request for VISIT_INFORMATION with no params
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to USER_WITH_VISITS details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 200
    And response body should be valid according to schema file visitInformation.json

  @API @Visits
  Scenario: Valid request for VISIT_INFORMATION with only loungVisitDateFrom
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to USER_WITH_VISITS details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters loungeVisitDateFrom to 2016-10-20T07:48:05.060Z
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 200
    And response body should be valid according to schema file visitInformation.json

  @API @Visits
  Scenario: Valid request for VISIT_INFORMATION with only loungeVisitDateTo
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to USER_WITH_VISITS details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters loungeVisitDateTo to 2017-10-20T07:48:05.060Z
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 200
    And response body should be valid according to schema file visitInformation.json

  @API @Visits
  Scenario: request for VISIT_INFORMATION with invalid format for visitDateTo
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to USER_WITH_VISITS details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters loungeVisitDateFrom to INVALID
    And I set query parameters loungeVisitDateTo to 2017-10-20T07:48:05.060Z
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 400
    And response body should be valid according to schema file error_schema.json

  @API @Visits
  Scenario: request for VISIT_INFORMATION with invalid format for visitDateFrom
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to USER_WITH_VISITS details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters loungeVisitDateFrom to 2017-10-20T07:48:05.060Z
    And I set query parameters loungeVisitDateTo to INVALID
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 400
    And response body should be valid according to schema file error_schema.json

  @API @Visits
  Scenario: request for VISIT_INFORMATION with invalid date for visitDateFrom
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to USER_WITH_VISITS details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters loungeVisitDateFrom to 2017-10-32T07:48:05.060Z
    And I set query parameters loungeVisitDateTo to 2017-10-20T07:48:05.060Z
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 500
    And response body should be valid according to schema file error_schema.json

  @API @Visits
  Scenario: Request for VISIT_INFORMATION with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on VISIT_INFORMATION resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should be valid according to schema file error_schema.json

  @API @Visits
  Scenario Outline: Invalid HTTP VERB (non GET) on VISIT_INFORMATION endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on VISIT_INFORMATION resource
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

  @API @Visits
  Scenario: Get VISIT_INFORMATION Data using Missing Token
    When I perform GET on VISIT_INFORMATION resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @Visits
  Scenario: Get VISIT_INFORMATION Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on VISIT_INFORMATION resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json