@XAPI-73 @DONE

Feature: User can register offer with Device
  As the new PP App developer,
  I want the App to register an offer transaction with my device ID,
  So that I can notify LB API of offer codes that have been redeemed.

  Background:
    Given I create a NEW XAPI request

  @API @RegisterDeviceTransaction
  Scenario: Valid request for REGISTER_DEVICE_TRANSACTIONS
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | DeviceId       | 1234567890 |
      | OfferCode      | OFFERCODE1 |
      | Latitude       | 0          |
      | Longitude      | 0          |
      | LocalTimestamp | 0          |
      | offsetFromUtc  | 0          |
    And I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 200

  @API @RegisterDeviceTransaction
  Scenario: request for REGISTER_DEVICE_TRANSACTIONS with Minimum needed params
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | DeviceId  | 1234567890 |
      | OfferCode | OFFERCODE1 |
    And I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 200

  @API @RegisterDeviceTransaction
  Scenario: request for REGISTER_DEVICE_TRANSACTIONS with Missing DeviceId
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | OfferCode | OFFERCODE1 |
    And I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of Bad Request for key description
    And response body should be valid according to schema file error_schema.json

  @API @RegisterDeviceTransaction
  Scenario: request for REGISTER_DEVICE_TRANSACTIONS with Missing OfferCode
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | DeviceId | 1234567890 |
    And I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of Bad Request for key description
    And response body should be valid according to schema file error_schema.json

  @API @RegisterDeviceTransaction
  Scenario: request for REGISTER_DEVICE_TRANSACTIONS with Invalid content type
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header Content-Type to text/xml
    And I set request body to json with
      | DeviceId       | 1234567890 |
      | OfferCode      | OFFERCODE1 |
      | Latitude       | 0          |
      | Longitude      | 0          |
      | LocalTimestamp | 0          |
      | offsetFromUtc  | 0          |
    And I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 415
    And response body should contain value of 415 for key code
    And response body should contain value of Unsupported Media Type for key description
    And response body should be valid according to schema file error_schema.json

  @API @RegisterDeviceTransaction
  Scenario: request for REGISTER_DEVICE_TRANSACTIONS with missing content type
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set request body to json with
      | DeviceId       | 1234567890 |
      | OfferCode      | OFFERCODE1 |
      | Latitude       | 0          |
      | Longitude      | 0          |
      | LocalTimestamp | 0          |
      | offsetFromUtc  | 0          |
    And I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 415
    And response body should contain value of 415 for key code
    And response body should contain value of Unsupported Media Type for key description
    And response body should be valid according to schema file error_schema.json

  @API @RegisterDeviceTransaction
  Scenario: Request for REGISTER_DEVICE_TRANSACTIONS with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | DeviceId       | 1234567890 |
      | OfferCode      | OFFERCODE1 |
      | Latitude       | 0          |
      | Longitude      | 0          |
      | LocalTimestamp | 0          |
      | offsetFromUtc  | 0          |
    And I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should be valid according to schema file error_schema.json

  @API @RegisterDeviceTransaction
  Scenario Outline: Invalid HTTP VERB (non POST) on REGISTER_DEVICE_TRANSACTIONS endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 405
    And response body should contain value of 405 for key code
    And response body should contain value of Method Not Allowed for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @RegisterDeviceTransaction
  Scenario: Get REGISTER_DEVICE_TRANSACTIONS Data using Missing Token
    When I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @RegisterDeviceTransaction
  Scenario: Get REGISTER_DEVICE_TRANSACTIONS Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform POST on REGISTER_DEVICE_TRANSACTIONS resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json