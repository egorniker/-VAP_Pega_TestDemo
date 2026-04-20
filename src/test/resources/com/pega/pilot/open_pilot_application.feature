Feature: Open pilot Pega application

@pilot @smoke-customer-service

  Scenario: Open the Pega application login page
    Given the user opens the Pega application
    Then the Pega application login page should be displayed