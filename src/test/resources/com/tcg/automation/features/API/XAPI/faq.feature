@XAPI-33 @DONE

Feature: User can view FAQ's for a deal
  As an authenticated user browsing the new PP App,
  I want the App to download FAQs specific to my deal,
  So that I can see them in the FAQ section in the App.

  Background:
    Given I create a NEW XAPI request

  @API @FAQ
  Scenario: Valid request for FAQS with password flow
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on FAQS resource
    Then response status code should be 200

  @API @FAQ
  Scenario: Valid request for FAQS with CC flow
    Given I set VALID basic authentication credentials
    And I set client_credentials_flow form parameters to VALID details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on FAQS resource
    Then response status code should be 200

  @API @FAQ
  Scenario: Valid request for FAQS with valid query param
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters languageCode to FR
    And I set query parameters topFaqId to %7BEFF2395C-A2B3-4A15-B0E4-39AAB6F040FC%7D
    And I perform GET on FAQS resource
    Then response status code should be 200

  @API @FAQ
  Scenario: Valid request for FAQS with invalid value for query param
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters languageCode to ZZ
    And I perform GET on FAQS resource
    Then response status code should be 200

  @API @FAQ
  Scenario: Valid request for FAQS with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on FAQS resource
    Then response status code should be 200

  @API @FAQ
  Scenario Outline: Invalid HTTP VERB (non GET) on FAQ endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on FAQS resource
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

  @API @FAQ
  Scenario: Get FAQ Data using Missing Token
    When I perform GET on FAQS resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @FAQ
  Scenario: Get FAQ Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on FAQS resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json