@backofficeportal @smoke @smoke-customer-service
Feature: BO user Test cases

  # author : GV
  @TC-favourites
  Scenario: Verify Favourites functionality
    Given a user is on login page of CS Portal
    When User logs in to CS portal as bouser
    When Select "contact" and serach for "Biggs"
    Then Verify the left nav header and search results for biggs
    When Filter the result with "first name" and "Rebecca"
    Then verify the result displayed for the "Rebecca" filter
    When Select the result "Rebecca" displayed
    When switch to Interaction of "Home"
    Then Operator logs of the social portal
