@XAPI-74

Feature: User can add DMC to digital wallet
  As an authenticated PP App user,
  I want the App to be able to issue a request to add my DMC to my smartphone's digital wallet,
  So that I can use my DMC from there.

  Background:
    Given I create a NEW XAPI request

  @API @DmcPassPackage
  Scenario: Valid request for DMC Pass Package with password flow
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on DMC_PASS_PACKAGE resource
    Then response status code should be 200

  @API @DmcPassPackage
  Scenario: Request for DMC Pass Package with password flow using without DMC account
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to NON_DMC details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on DMC_PASS_PACKAGE resource
    Then response status code should be 500

  @API @DmcPassPackage
  Scenario: Request for DMC Pass Package with password flow using expired account
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to EXPIRED_DMC details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on DMC_PASS_PACKAGE resource
    Then response status code should be 500

  @API @DmcPassPackage
  Scenario: Request for DMC Pass Package with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on DMC_PASS_PACKAGE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @DmcPassPackage
  Scenario Outline: Invalid HTTP VERB (non GET) on DMC_PASS_PACKAGE endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on DMC_PASS_PACKAGE resource
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

  @API @DmcPassPackage
  Scenario: Get DMC_PASS_PACKAGE Data using Missing Token
    When I perform GET on DMC_PASS_PACKAGE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @DmcPassPackage
  Scenario: Get DMC_PASS_PACKAGE Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on DMC_PASS_PACKAGE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json
