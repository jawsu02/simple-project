@XAPI-90 @DONE
Feature: User can access a non existent url and receive a 404
  As a LB API Consumer
  I want to return a 404 Not Found if an incorrect base path is requested

  Background:
    Given I create a NEW XAPI request

  @API @FailSafe
  Scenario Outline: Requests to Default Path (/) with out Auth
    When I perform <HTTP_METHOD> on DEFAULT resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to Default Path (/) with client credentials
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on DEFAULT resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to Default Path (/) with password flow
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on DEFAULT resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path (/WHOAMI) with out Auth
    When I perform <HTTP_METHOD> on NON_EXISTENT resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path (/WHOAMI) with client credentials
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path (/WHOAMI) with password flow
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in Consumer proxy (/consumer/WHOAMI) with out Auth
    When I perform <HTTP_METHOD> on NON_EXISTENT_CONSUMER_PATH resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in consumer proxy (/consumer/WHOAMI) with client credentials
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT_CONSUMER_PATH resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in consumer proxy  (/consumer/WHOAMI) with password flow
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT_CONSUMER_PATH resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in Offers proxy (/offers/WHOAMI) with out Auth
    When I perform <HTTP_METHOD> on NON_EXISTENT_OFFERS_PATH resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in Offers proxy (/offers/WHOAMI) with client credentials
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT_OFFERS_PATH resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in Offers proxy  (/offers/WHOAMI) with password flow
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT_OFFERS_PATH resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in PP proxy with out Auth
    When I perform <HTTP_METHOD> on NON_EXISTENT_PP_PATH resource
    Then response status code should be 401
    And response body should contain value of 401 for key code
    And response body should contain value of The authenticated client is not authorized to use this authorization grant type for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in PP proxy with client credentials
    Given I set valid basic authentication credentials
    And I set client_credentials_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT_PP_PATH resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |

  @API @FailSafe
  Scenario Outline: Requests to NonExistent Path in PP proxy with password flow
    Given I set valid basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform POST on AUTH_TOKEN resource
    Then response status code should be 200
    And I store the value of body path access_token as bearer_token
    Given I create a NEW XAPI request
    And I set bearer token to bearer_token
    When I perform <HTTP_METHOD> on NON_EXISTENT_PP_PATH resource
    Then response status code should be 404
    And response body should contain value of 404 for key code
    And response body should contain value of Not Found for key description
    And response body should be valid according to schema file error_schema.json
    Examples:
      | HTTP_METHOD |
      | GET         |
      | POST        |
      | DELETE      |
      | PUT         |
      | PATCH       |
      | OPTIONS     |