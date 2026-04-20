@demointeraction @smoke @smoke-customer-service
Feature: Demo Interaction Test cases

  # author : Murali
  @TC-accountswitching
  Scenario: Validation when Account is switched from Individual to Commercial
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    When CSR launches Demo Interaction for "Demo Pop - CONNOR" and accepts the call
    Then verifiy left nav, header, composites, dialogs and other sections
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Dispute transaction" service process
    When select the verification questions for service cases and click on verified
    Then verify "Dispute transaction" flow is launched
    Then select transaction "2089" for dispute
    When Select dispute reason "Merchandise not received" and submit
    When Confirm the flow
    Then check for completed or cancelled task "Dispute transaction"
    When launch warpup to complete the interaction
    When Operator logs of the portal

  # author : Prakash
  @TC-creatlead
  Scenario: Verify all the options present under account and Create Lead for user
    Given a user is on login page of CS Portal
    When User logs in to CS portal as mikejones
    When CSR launches Demo Interaction for "Demo Pop - CONNOR" and accepts the call
    Then verifiy left nav, header, composites, dialogs and other sections
    Then verify Connor name and Interaction title and dialog
    Then Verify all the details for "1234500078963456" Account number
    Then verify the tabs in "Transaction" widget
    Then verify the tabs in "Statements" widget
    When Click on Add Task to launch Service Process
    When Launch "Create lead" service process
    Then verify that "Create lead" flow is launched with dialog
    Then Select the Stage as "Assigned" and Rating as "1-Hot" and submit
    When confirm the changes made
    When user switches to "Overview" tab
    When launch warpup to complete the interaction
    When complete the wrap up
    When Operator logs of the portal
