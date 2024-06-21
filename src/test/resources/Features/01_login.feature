# Login Feature
Feature: Valid Login

  Scenario: Valid Application Login
    Given Application is Launched
    When Existing User Authenticate
    Then Application Available For Use
