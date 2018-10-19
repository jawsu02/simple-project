@XAPI-36 @Done
Feature: User can create favourites
  As an authenticated user browsing the new PP App,
  I want to be able to add an item to my favourite lists,
  So that the particular Lounge or Offer is available for easy access later.

  Background:
    Given I create a NEW XAPI request

  @API @CreateFavourite
  Scenario: Valid request for CREATE_FAVOURITE
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
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to SESSION:favouriteId
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 204

  @API @CreateFavourite
  Scenario: Creating a favourite with OfferOutletId and offerId
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | OfferOutletId | 415 |
      | OfferId       | 205 |
    When I perform POST on FAVOURITE resource
    Then response status code should be 201
    And response body should contain key FavouriteId
    And I store the value of body path FavouriteId as favouriteId
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to SESSION:favouriteId
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 204

  @API @CreateFavourite
  Scenario: Creating a favourite with OfferOutletId
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | OfferOutletId | 415 |
    When I perform POST on FAVOURITE resource
    Then response status code should be 201
    And response body should contain key FavouriteId
    And I store the value of body path FavouriteId as favouriteId
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to SESSION:favouriteId
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 204

  @API @CreateFavourite
  Scenario: Creating a favourite with offerId
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | OfferId | 206 |
    When I perform POST on FAVOURITE resource
    Then response status code should be 201
    And response body should contain key FavouriteId
    And I store the value of body path FavouriteId as favouriteId
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to SESSION:favouriteId
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 204

  @API @CreateFavourite
  Scenario: Creating a favourite when already there is one
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
    And I store the value of body path FavouriteId as favouriteId
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | LoungeCode | AAL |
    When I perform POST on FAVOURITE resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of Bad Request for key description
    And response body should contain value of [{ErrorCode=favouriteAlreadyExists, ErrorMessage=Favourite already exists for this consumer}] for key error
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    And I set path parameters favouriteId to SESSION:favouriteId
    When I perform DELETE on DELETE_FAVOURITE resource
    Then response status code should be 204

  @API @CreateFavourite
  Scenario: Creating a favourite with LoungeCode and offerId
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | LoungeCode | AAL  |
      | OfferId    | 1234 |
    When I perform POST on FAVOURITE resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of Bad Request for key description
    And response body should contain value of [{ErrorCode=InvalidParameters, ErrorMessage=Please supply either an offerOutletId or a loungeCode}] for key error

  @API @CreateFavourite
  Scenario: Creating a favourite with LoungeCode and OfferOutletId
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | LoungeCode    | AAL  |
      | OfferOutletId | 1234 |
    When I perform POST on FAVOURITE resource
    Then response status code should be 400
    And response body should contain value of 400 for key code
    And response body should contain value of Bad Request for key description
    And response body should contain value of [{ErrorCode=InvalidParameters, ErrorMessage=Please supply either an offerOutletId or a loungeCode}] for key error

  @API @CreateFavourite
  Scenario: Creating a favourite with wrong content type
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/text
    When I perform POST on FAVOURITE resource
    Then response status code should be 415
    And response body should contain value of 415 for key code
    And response body should contain value of Unsupported Media Type for key description
    And response body should be valid according to schema file error_schema.json

  @API @CreateFavourite
  Scenario: Creating a favourite with no body
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    When I perform POST on FAVOURITE resource
    Then response status code should be 500
    And response body should contain value of 500 for key code
    And response body should be valid according to schema file error_schema.json

  @API @CreateFavourite
  Scenario: Request for CREATE_FAVOURITE with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set header content-type to application/json
    And I set request body to json with
      | LoungeCode | AAL |
    When I perform POST on FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this resource for key description
    And response body should be valid according to schema file error_schema.json

  @API @CreateFavourite
  Scenario Outline: Invalid HTTP VERB (non POST) on FAVOURITE endpoint
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

  @API @CreateFavourite
  Scenario: Get FAVOURITE Data using Missing Token
    When I perform POST on FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @CreateFavourite
  Scenario: Get FAVOURITE Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform POST on FAVOURITE resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json