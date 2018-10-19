Feature: Deal

  Background:
    Given I create a NEW LB request
    And I set header Content-Type to application/x-www-form-urlencoded
    And I set form parameter Username to mr_user129
    And I set form parameter Password to 65c21921ca10a8502757efc9aa552874d181c6206feb2845a921eb57f5e518d4
    And I set form parameter ProductCode to PP
    And I set form parameter GrantType to password
    And I set form parameter ClientId to mobileApp
    And I set form parameter ClientSecret to clientSecret
    When I perform POST on LB_AUTH_TOKEN resource
    Then response status code should be 200
    And response body should contain key access_token
    And I store the value of body path access_token as bearer_token

  @LB_API @Deal
  Scenario: Return deal information for source code
    Given I create a NEW LB request
    And I set bearer token to bearer_token
    And I set path parameters sourceCode to CANON11
    And I set query parameters ProductCode to PP
    When I perform GET on LB_DEAL_INFORMATION resource
    Then response status code should be 200
    And response body should contain key SourceCode

  @LB_API @Deal
  Scenario: Validate UIC
    Given I create a NEW LB request
    And I set bearer token to bearer_token
    And I set header Content-Type to application/x-www-form-urlencoded
    And I set form parameter ValidationCode to STA6708580
    And I set form parameter SourceCodeList to ABRSM10
    When I perform POST on LB_VALIDATE_UIC resource
    Then response status code should be 200

  @LB_API @Deal
  Scenario: Get Membership plans
    Given I create a NEW LB request
    And I set bearer token to bearer_token
    And I set query parameters ProductCode to PP
    And I set path parameters sourceCode to ABTRAV
    When I perform GET on LB_MEMBERSHIP_PLANS resource
    Then response status code should be 200

  @LB_API @Deal
  Scenario: Postage handling fee for deal
    Given I create a NEW LB request
    And I set bearer token to bearer_token
    And I set query parameters ProductCode to PP
    And I set query parameters sourceCode to WPUN
    And I set query parameters countryOfResidence to GBR
    And I set query parameters deliveryCountry to BRA
    When I perform GET on LB_HANDLING_CHARGES resource
    Then response status code should be 200
    And response body should contain key GBP
    And response body should contain key USD
    And response body should contain key EUR

  @LB_API @Deal
  Scenario: Validate UIC can be used for supplier source code
    Given I create a NEW LB request
    And I set bearer token to bearer_token
    And I set header Content-Type to application/json
    And I set request body to json with
      | ProductCode    | PP         |
      | ValidationCode | DIR2107912 |
      | SourceCode     | DIRECT12   |
    When I perform POST on LB_UIC_VALIDATOR resource
    Then response status code should be 200
    And response body should contain key SourceCode
    And response body should contain key SubscriptionLevelIds
    And response body should contain key DefaultISOCurrencyCode
    And response body should contain key UserInvitationCode

  @LB_API @Deal
  Scenario: Validate Bank Number validity for a deal
    Given I create a NEW LB request
    And I set bearer token to bearer_token
    And I set header Content-Type to application/json
    And I set request body to json with
      | ProductCode | PP              |
      | CardNumber  | 374720016413035 |
      | SourceCode  | 97BUPA          |
    When I perform POST on LB_BANK_CARD_VALIDATOR resource
    Then response status code should be 200
    And response body should contain key SourceCode
    And response body should contain key SubscriptionLevelIds
    And response body should contain key DefaultISOCurrencyCode
    And response body should contain key UserInvitationCode