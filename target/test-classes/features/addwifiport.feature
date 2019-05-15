@addwifiport
Feature: User should be able to add new wifi port
  In order to add new wifi port
  As a user
  I want to use the add wifi port

  @test_case01
  Scenario: User should be able to add new wifi port
    Given user logged into the application
    When user navigate to addwifi screen
    And add new wifi port
    Then newly added wifi port should be displayed