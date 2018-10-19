@XAPI-00 @DONE

Feature: User cannot make a HTTP Request
  As APIGEE
  I want to make sure that request with HTTP are not allowed
  So that I can make sure that all requests are secured

  Background:
    Given I create a NEW HTTP request

  @API @HTTP
  Scenario Outline: A request with HTTP for AIRPORT_DATA to APIGEE responds with 404
    When I perform <HTTP_METHOD> on AIRPORT_DATA resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for DMC_PASS_PACKAGE to APIGEE responds with 404
    When I perform <HTTP_METHOD> on DMC_PASS_PACKAGE resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for FAQs to APIGEE responds with 404
    When I perform <HTTP_METHOD> on FAQS resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for GENERATE_OFFER_TOKEN to APIGEE responds with 404
    When I perform <HTTP_METHOD> on GENERATE_OFFER_TOKEN resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for LOUNGES to APIGEE responds with 404
    When I perform <HTTP_METHOD> on LOUNGES resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for AIRPORTS to APIGEE responds with 404
    When I perform <HTTP_METHOD> on AIRPORTS resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for OFFER_SET to APIGEE responds with 404
    When I perform <HTTP_METHOD> on OFFER_SET resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for PDF_VISIT_RECEIPT to APIGEE responds with 404
    When I perform <HTTP_METHOD> on PDF_VISIT_RECEIPT resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for REAL_TIME_ALLOCATION to APIGEE responds with 404
    When I perform <HTTP_METHOD> on REAL_TIME_ALLOCATION resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for REGISTER_DEVICE_TRANSACTIONS to APIGEE responds with 404
    When I perform <HTTP_METHOD> on REGISTER_DEVICE_TRANSACTIONS resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for USER_INFO to APIGEE responds with 404
    When I perform <HTTP_METHOD> on USER_INFO resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for VISIT_INFORMATION to APIGEE responds with 404
    When I perform <HTTP_METHOD> on VISIT_INFORMATION resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for AUTHTOKEN client credentials to APIGEE responds with 404
    Given I set VALID basic authentication credentials
    And I set client_credentials_flow form parameters to VALID details
    When I perform <HTTP_METHOD> on AUTHTOKEN resource
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

  @API @HTTP
  Scenario Outline: A request with HTTP for AUTHTOKEN password flow to APIGEE responds with 404
    Given I set VALID basic authentication credentials
    And I set password_flow form parameters to valid details
    When I perform <HTTP_METHOD> on AUTHTOKEN resource
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