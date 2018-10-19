@XAPI-35
Feature: User can get favourites
  As an authenticated user browsing the new PP App,
  I want the App to download my favourite lists,
  So that they can be display under the Favourites section.

  Background:
    Given I create a NEW XAPI request

  @API @GetFavourites
  Scenario: Valid request for GET_FAVOURITES
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | LoungeCode | AAL |
    When I perform POST on FAVOURITE resource
    Then response status code should be 201
    And response body should contain key FavouriteId
    And I store the value of body path FavouriteId as favouriteId
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on FAVOURITE resource
    Then response status code should be 200
    And response body should contain key FavouriteId
    And response body should contain key Type
    And response body should contain key Id
    And response body should contain key CreationDate
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to SESSION:favouriteId
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 204

  @API @GetFavourites
  Scenario: GET_FAVOURITES using client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to VALID details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform GET on FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @GetFavourites
  Scenario Outline: Invalid HTTP VERB (non GET) on GET_FAVOURITES endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on FAVOURITE resource
    Then response status code should be 405
    And response body should contain value of 405 for key code
    And response body should contain value of Method Not Allowed for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @GetFavourites
  Scenario: Get GET_FAVOURITES Data using Missing Token
    When I perform GET on FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @GetFavourites
  Scenario: Get GET_FAVOURITES Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json