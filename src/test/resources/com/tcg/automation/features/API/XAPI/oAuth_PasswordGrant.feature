@XAPI-23 @DONE

Feature: User can authenticate against Apigee and receive an Acesss Token
  As an unauthenticated user trying to login to the new PP App,
  I want the App to be able to confirm my credentials,
  So that I can complete authentication.

  Background:
    Given I create a NEW XAPI request

  @API @OAuthPasswordFlow
  Scenario: Sending valid username password grant
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to VALID details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And response body should contain key access_token
    And response body should contain key token_type
    And response body should contain key expires_in

  @API @OAuthPasswordFlow
  Scenario Outline: Invalid HTTP VERB (non POST) to Token endpoint
    When I perform <HTTP_METHOD> on AUTH_TOKEN resource
    Then response status code should be 405
    And response body should contain value of 405 for key code
    And response body should contain value of unsupported_response_type for key error
    And response body should contain value of The authorization server does not support obtaining an authorization code using this method for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @OAuthPasswordFlow
  Scenario: Invalid request with unsupported grant type
    Given I set password_flow form parameters to invalid_grant details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of unsupported_grant_type for key error
    And response body should contain value of The authorization grant type is not supported by the authorization server for key description
    And response body should be valid according to schema file error_schema.json

  @API @OAuthPasswordFlow
  Scenario: Sending password grant with invalid username
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to invalid_creds details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of invalid_request for key error
    And response body should be valid according to schema file error_schema.json

  @API @OAuthPasswordFlow
  Scenario: Sending invalid apikey and secret (invalid client)
    Given I set INVALID_USER basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of unauthorized_client for key error
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should be valid according to schema file error_schema.json