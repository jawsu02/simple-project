@XAPI-75

Feature: User can download PDF Receipt for visit
  As an authenticated user browsing the new PP App,
  I want the App to display receipt for my visit,
  So that I can download the receipt of my visit

  Background:
    Given I create a NEW XAPI request

  @API @PDFReceipt
  Scenario: Valid request for PDF_VISIT_RECEIPT
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I set path parameters visitNumber to 1234
    When I perform GET on PDF_VISIT_RECEIPT resource
    Then response status code should be 200
    And response body should be valid according to schema file pdfReceipt.json

  @API @PDFReceipt
  Scenario: Invalid request for PDF_VISIT_RECEIPT
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform GET on /prioritypass/v1/consumer/visit/INVALID/receipt resource
    Then response status code should be 400
    And response body should contain value of receiptGenerationUnavailable for key error[0].ErrorCode
    And response body should contain value of Receipt could not be generated for key error[0].ErrorMessage

  @API @PDFReceipt
  Scenario: Request for PDF_VISIT_RECEIPT with client credentials flow
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    And I perform GET on PDF_VISIT_RECEIPT resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of Unauthorized for key description
    And response body should be valid according to schema file error_schema.json

  @API @PDFReceipt
  Scenario Outline: Invalid HTTP VERB (non GET) on PDF_VISIT_RECEIPT endpoint
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    When I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on PDF_VISIT_RECEIPT resource
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

  @API @PDFReceipt
  Scenario: Get PDF_VISIT_RECEIPT Data using Missing Token
    When I perform GET on PDF_VISIT_RECEIPT resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json

  @API @PDFReceipt
  Scenario: Get PDF_VISIT_RECEIPT Data using Invalid Token
    Given I set bearer token to INVALID
    When I perform GET on PDF_VISIT_RECEIPT resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The client is not authorized to request an authorization code using this method for key description
    And response body should contain value of unauthorized_client for key error
    And response body should be valid according to schema file error_schema.json