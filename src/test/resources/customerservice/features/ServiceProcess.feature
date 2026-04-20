@serviceprocess @smoke @smoke-customer-service
Feature: Service Process Test cases

  # author : Prakash
  @TC-disputetransaction
  Scenario: Dispute transaction with amount low amount
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    When CSR launches Demo Interaction for "Demo Pop - CONNOR" and accepts the call
    When Click on Add Task to launch Service Process
    When Launch "Dispute transaction" service process
    When Select "1029" statement  and submit
    Then Verify Dialog, amount and In-progress task for "1029" statement
    When Select a dispute "Incorrect Charge" and submit
    Then Verify the "Resolved-Completed" status displayed
    When Confirm the Dispute transaction flow
    Then check for completed or cancelled task "Dispute transaction"
    Then Verify "1" count is for Dispute Transaction is displayed
    When launch warpup to complete the interaction
    When complete the wrap up
    When Operator logs of the portal
