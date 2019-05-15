@togglefunc
Feature: User should be turn off the switch
  In order to use the setting
  As a user
  I want to turn off the switch

  @test_case02
  Scenario: User should be able to turn off/on the switch
    Given user logged into the application
    When user navigate to switch screen
    And toggles switch
    Then switch preference should turn off