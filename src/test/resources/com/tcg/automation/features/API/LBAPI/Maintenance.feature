Feature: Maintenance

  Background:
    Given I create a NEW LB request

  @LB_API @Maintenance
  Scenario: Maintenance Ping
    When I perform GET on /api/v1/maintenance/ping resource
    Then response status code should be 200

  @LB_API @Maintenance
  Scenario: Maintenance Ping AuthAPi
    When I perform GET on /api/v1/maintenance/pingAuthApi resource
    Then response status code should be 200