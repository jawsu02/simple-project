Feature: Lounges

  Background:
    Given I create a NEW LB request

  @LB_API @Lounges
  Scenario Outline: Get Lounges for PP
    Given I set query parameters productCode to <product>
    And I set path parameters loungecode to <lounges>
    When I perform GET on LB_LOUNGES_BY_LOUNGE_CODE resource
    Then response status code should be 200
#    When I store the size of body path LoungeCode as loungeCount
#    And I store the database count for GET_LOUNGES_COUNT with params <product>, <lounges> as loungeDBCount
#    Then loungeCount should be equal to loungeDBCount
    Examples:
      | product | lounges |
      | PP      | AMS2    |
      | PP      | GUA2    |
      | PP      | ADB     |
      | PP      | AGP     |
      | PP      | AHB     |
      | PP      | AKL     |
      | PP      | AMM1    |
      | PP      | AMS     |
      | PP      | AMS2    |

  @LB_API @Lounges
  Scenario: Get lounges with Invalid Lounge code
    Given I set query parameters productCode to PP
    And I set path parameters loungecode to LGW1
    When I perform GET on LB_LOUNGES_BY_LOUNGE_CODE resource
    Then response status code should be 404

  @LB_API @Lounges
  Scenario: Get all lounges with filters for PP
    Given I set query parameters productCode to PP
    And I set query parameters searchText to gatwick
    And I set query parameters excludeDeleted to false
    When I perform GET on LB_ALL_LOUNGES resource
    Then response status code should be 200

  @LB_API @Lounges
  Scenario: Get all lounges without filters for PP
    Given I set query parameters productCode to PP
    When I perform GET on LB_ALL_LOUNGES resource
    Then response status code should be 200

  @LB_API @Lounges
  Scenario: Get all lounges without filters for LK
    Given I set query parameters productCode to LK
    When I perform GET on LB_ALL_LOUNGES resource
    Then response status code should be 200
    When I store the size of body path LoungeCode as loungeCount
#    Then database count for GET_LK_LOUNGES_COUNT should be equal to loungeCount
