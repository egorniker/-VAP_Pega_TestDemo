@newphonecall @smoke @smoke-customer-service
Feature: Phone Interaction Test cases

  # author : Murali
  @TC-scheduleactivity
  Scenario: Phone Interaction with email search and Schedule Activity
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    When CSR launched the New Phone Interaction
    When Select phone call search by "Contact info"
    When Search for the Customer with email "jennifer.lake@hotmail123.net" and lastname "lake"
    When select result from the new phone call search result and proceed
    When select the verification questions and click on verified
    Then Verify the dialog, FA header, message displayed
    When select "223000018" account number and submit
    Then verifiy left nav, header, composites, dialogs and other sections
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Schedule activity" service process
    Then verify "Schedule activity" flow is launched
    Then verify dialog, FA header and other options for Schedule Activity
    When select "Conference call" and options as account "223000018" topic "Accounts" Assign to "Operator" and name "CASysAdmin"
    Then Confirm the case details
    When Confirm the flow
    When launch warpup to complete the interaction
    When complete the wrap up
    When Operator logs of the portal
