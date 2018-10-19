Feature: Countries
  As a API,
  I want to be able get list of all countries
  So that i can send these to consuming clients

  Background:
    Given I create a NEW LB request

  @LB_API @Countries
  Scenario: Get All Countries
    When I perform GET on LB_COUNTRIES resource
    Then response status code should be 200
    When I store the size of body path LBCountryCode as countryCount
    Then database count for GET_COUNTRIES_COUNT should be equal to countryCount
    And response body should be valid according to schema file lb_countries.json

  @LB_API @Countries
  Scenario: Get All US States
    When I perform GET on LB_US_STATES resource
    Then response status code should be 200
    When I store the size of body path Code as stateCount
    Then database count for GET_US_STATES_COUNT should be equal to stateCount
    And response body should be valid according to schema file lb_usStates.json
