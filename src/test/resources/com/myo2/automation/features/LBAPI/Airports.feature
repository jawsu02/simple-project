Feature: Airports

  Background:
    Given I create a NEW LB request

  @LB_API @Airports
  Scenario: Get Airports for PP
    Given I set query parameters productCode to PP
    When I perform GET on LB_AIRPORTS resource
    Then response status code should be 200
    And response body should be valid according to schema file lb_airports.json