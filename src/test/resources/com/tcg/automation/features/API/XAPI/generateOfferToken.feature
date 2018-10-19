@XAPI-72

Feature: User can download tokens
  As the new PP App developer,
  I want the App to be able to download more offer tokens,
  So that I can download more tokens for further offline usage.

  Background:
    Given I create a NEW XAPI request

  @API @GenerateOfferToken
  Scenario: valid generate offer token  request
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters deviceId to f07a13984f6d116a
    And I perform GET on GENERATE_OFFER_TOKEN resource
    Then response status code should be 200
    And response body should be valid according to schema file generateTokens.json

  @API @GenerateOfferToken
  Scenario: generate offer token request with client credentials
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters deviceId to f07a13984f6d116a
    And I perform GET on GENERATE_OFFER_TOKEN resource
    Then response status code should be 401
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should be valid according to schema file error_schema.json

  @API @GenerateOfferToken
  Scenario: Generate offer token request without device id
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on GENERATE_OFFER_TOKEN resource
    Then response status code should be 400
    And response body should contain value of The request is missing a required parameter, has invalid payload or is otherwise malformed for key description
    And response body should be valid according to schema file error_schema.json

  @API @GenerateOfferToken
  Scenario Outline: Invalid HTTP VERB (non GET) on Generate Offer Token
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on GENERATE_OFFER_TOKEN resource
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

  @API @GenerateOfferToken
  Scenario: Generate Offer token using Missing Token
    When I perform GET on GENERATE_OFFER_TOKEN resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @GenerateOfferToken
  Scenario: Generate Offer token using Invalid Token
    And I set bearer token to INVALID
    When I perform GET on GENERATE_OFFER_TOKEN resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json
