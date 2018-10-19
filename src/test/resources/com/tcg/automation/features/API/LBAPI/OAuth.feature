Feature: Auth

  Background:
    Given I create a NEW LB request

  @LB_API @Auth
  Scenario Outline: OAuth2 External Client
    Given I set header Content-Type to application/x-www-form-urlencoded
    And I set form parameter Username to <username>
    And I set form parameter Password to <password>
    And I set form parameter ProductCode to <productCode>
    And I set form parameter GrantType to <grantType>
    And I set form parameter ClientId to <clientId>
    And I set form parameter ClientSecret to <clientSecret>
    When I perform POST on LB_AUTH_TOKEN resource
    Then response status code should be 200
    And response body should contain key access_token

    Examples:
      | username         | password                                                         | productCode | grantType | clientId | clientSecret  |
      | webAppUat.ptgmis | jVOryfElv1-f710-mfGbxndriMfsLqixZ3fJRfdwTK5v9O0J2smi4ylQq7XFc4Y0 | PP          | password  | webApp   | websiteSecret |
