@XAPI-68 @DONE

Feature: oAuth2 Client Credentials Flow
  As a LB API consumer registered with APIGEE
  I want to present my oauth 2 client credentials to Apigee
  So that I can obtain an access token

  Background:
    Given I create a NEW XAPI request

  @API @OAuthCCFlow
  Scenario: Sending valid client credentials grant
    Given I set VALID basic authentication credentials
    And I set client_credentials_flow form parameters to VALID details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And response body should contain key access_token
    And response body should contain key token_type
    And response body should contain key expires_in

  @API @OAuthCCFlow
  Scenario: Sending invalid client credentials grant
    Given I set INVALID_USER basic authentication credentials
    And I set client_credentials_flow form parameters to VALID details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 401
    And response body should be valid according to schema file error_schema.json
    And response body should contain value of 401 for key code
    And response body should contain value of unauthorized_client for key error
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description

  @API @OAuthCCFlow
  Scenario: Missing Authorisation header
    Given I set client_credentials_flow form parameters to VALID details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of invalid_request for key error
    And response body should be valid according to schema file error_schema.json

  @API @OAuthCCFlow
  Scenario Outline: Invalid HTTP VERB (non POST) to Auth Token endpoint
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

  @API @OAuthCCFlow
  Scenario: Sending invalid client credentials grant
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to <string> details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of unsupported_grant_type for key error
    And response body should contain value of The authorization grant type is not supported by the authorization server for key description
    And response body should be valid according to schema file error_schema.json

  @API @OAuthCCFlow
  Scenario: Sending not supported grant type - implicit
    Given I set valid basic authentication credentials
    And I set form parameter grant_type to implicit
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of unsupported_grant_type for key error
    And response body should contain value of The authorization grant type is not supported by the authorization server for key description
    And response body should be valid according to schema file error_schema.json

  @API @OAuthCCFlow
  Scenario: Sending not supported grant type - authorization_code
    Given I set valid basic authentication credentials
    And I set form parameter grant_type to authorization_code
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of unsupported_grant_type for key error
    And response body should contain value of The authorization grant type is not supported by the authorization server for key description
    And response body should be valid according to schema file error_schema.json