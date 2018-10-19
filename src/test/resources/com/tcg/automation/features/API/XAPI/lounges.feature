@XAPI-26

Feature: User can download, browse full set of lounges Data
  As a user browsing the new PP App,
  I want to be able to download the full set of Lounge Data,
  So that I can look at this data in the app.

  Background:
    Given I create a NEW XAPI request

  @API @LOUNGES
  Scenario: Valid request for Lounges  Data (password flow)
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on LOUNGES resource
    Then response status code should be 200

  @API @LOUNGES
  Scenario Outline: Valid request for Lounges  Data with language code (password flow)
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters languagecode to <language>
    And I perform GET on LOUNGES resource
    Then response status code should be 200
    Examples:
      | language |
      | de       |
      | fr       |

  @API @LOUNGES
  Scenario Outline: Invalid HTTP VERB (non GET) on Lounges Data endpoint (password flow)
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on LOUNGES resource
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

  @API @LOUNGES
  Scenario: Valid request for Lounges  Data (client credentials flow)
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on LOUNGES resource
    Then response status code should be 200

  @API @LOUNGES
  Scenario Outline: Valid request for Lounges  Data with language code (client credentials flow)
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters languagecode to <language>
    And I perform GET on LOUNGES resource
    Then response status code should be 200
    Examples:
      | language |
      | de       |
      | fr       |

  @API @LOUNGES
  Scenario Outline: Invalid HTTP VERB (non GET) on Lounges Data endpoint (client credentials flow)
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on LOUNGES resource
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

  @API @LOUNGES
  Scenario: Get Lounges Data using Missing Token
    When I perform GET on LOUNGES resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @LOUNGES
  Scenario: Get Lounges Data using Invalid Token
    And I set bearer token to INVALID
    When I perform GET on LOUNGES resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json
