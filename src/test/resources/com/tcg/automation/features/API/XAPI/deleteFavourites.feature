@XAPI-37
Feature: User can Delete favourites
  As an authenticated user browsing the new PP App,
  I want to be able to remove an item from my favourite lists,
  So that the particular Lounge or Offer is available doesn't appear in the Favourites section.

  Background:
    Given I create a NEW XAPI request

  @API @DeleteFavourite
  Scenario: Valid request for DELETE_FAVOURITE
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | LoungeCode | AAL |
    When I perform POST on FAVOURITE resource
    Then response status code should be 201
    And I store the value of body path FavouriteId as favouriteId
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to SESSION:favouriteId
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 204

  @API @DeleteFavourite
  Scenario: DELETE_FAVOURITE with a favourite that doesnt exist
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to 1234
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 400
    And response body should contain value of Bad Request for key description
    And response body should contain value of [{ErrorCode=noFavourite, ErrorMessage=The favourite selected does not exist for this consumer}] for key error

  @API @DeleteFavourite
  Scenario: Request for DELETE_FAVOURITE with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set path parameters favouriteId to 1234
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should be valid according to schema file error_schema.json

  @API @DeleteFavourite
  Scenario Outline: Invalid HTTP VERB (non POST) on DELETE_FAVOURITE endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set path parameters favouriteId to 1234
    When I perform <HTTP_METHOD> on DELETE_FAVOURITE resource
    Then response status code should be 405
    And response body should contain value of 405 for key code
    And response body should contain value of Method Not Allowed for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @DeleteFavourite
  Scenario: DELETE_FAVOURITE using Missing Token
    And I set path parameters favouriteId to 1234
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @DeleteFavourite
  Scenario: DELETE_FAVOURITE using Invalid Token
    Given I set bearer token to INVALID
    And I set path parameters favouriteId to 1234
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json