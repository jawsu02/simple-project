@XAPI-43 @DONE

Feature: User can download, browse full set of Airport and Terminal Data
  As a user browsing the new PP App,
  I want to be able to download the full set of Airport and Terminal Data,
  So that I can look at this data in the app

  Background:
    Given I create a NEW XAPI request

  @API @AIRPORTS
  Scenario: Valid request for Airport Data (password flow)
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform GET on AIRPORTS resource
    Then response status code should be 200
    And response body should be valid according to schema file airportDataSchema.json

  @API @AIRPORTS
  Scenario: Valid request for Airport Data with query parameters (password flow)
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set query parameters excludeDeleted to true
    And I set query parameters hasLBBenefits to true
    When I perform GET on AIRPORTS resource
    Then response status code should be 200
    And response body should be valid according to schema file airportDataSchema.json

  @API @AIRPORTS
  Scenario Outline: Invalid HTTP VERB (non GET) on Airport Data endpoint (password flow)
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on AIRPORTS resource
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

  @API @AIRPORTS
  Scenario: Valid request for Airport Data (client cred flow)
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform GET on AIRPORTS resource
    Then response status code should be 200
    And response body should be valid according to schema file airportDataSchema.json

  @API @AIRPORTS
  Scenario: Valid request for Airport Data with query parameters (client cred flow)
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set query parameters excludeDeleted to true
    And I set query parameters hasLBBenefits to true
    When I perform GET on AIRPORTS resource
    Then response status code should be 200
    And response body should be valid according to schema file airportDataSchema.json

  @API @AIRPORTS
  Scenario Outline: Invalid HTTP VERB (non GET) on Airport Data endpoint (client cred flow)
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on AIRPORTS resource
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

  @API @AIRPORTS
  Scenario: Get Airport Data using Missing Token
    When I perform GET on AIRPORTS resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @AIRPORTS
  Scenario: Get Airport Data using Invalid Token
    And I set bearer token to INVALID
    When I perform GET on AIRPORTS resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json