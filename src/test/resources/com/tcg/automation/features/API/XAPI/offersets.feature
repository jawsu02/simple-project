@XAPI-65

Feature: User can get offersets
  As the new PP App developer,
  I want the App to be able to get my offersets,
  So that I can redeem them

  Background:
    Given I create a NEW XAPI request

  @API @Offersets
  Scenario: valid get offerset request with parameters
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header Accept-Encoding to gzip,deflate
    And I set query parameters languageCode to nl
    And I set query parameters mappedOnly to true
    And I perform GET on OFFER_SET resource
    Then response status code should be 200

  @API @Offersets
  Scenario: user with No offers
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to EXPIRED_DMC details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set query parameters languageCode to nl
    And I set query parameters mappedOnly to true
    And I perform GET on OFFER_SET resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description

  @API @Offersets
  Scenario: Request for OFFER_SET with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on OFFER_SET resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @Offersets
  Scenario Outline: Invalid HTTP VERB (non GET) on OFFER_SET endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on OFFER_SET resource
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

  @API @Offersets
  Scenario: Get OFFER_SET Data using Missing Token
    When I perform GET on OFFER_SET resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @Offersets
  Scenario: Get OFFER_SET Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on OFFER_SET resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json