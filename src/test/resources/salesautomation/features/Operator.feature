@operator @smoke @smoke-sales-automation
Feature: Sales Automation Operator feature
Test covering the creation of Operator in Sales Automation 

Background: 
	Given User logs in to SA Application as salesops

@TC-operator-creation
  Scenario: create Sales Rep Operator by Sales Ops
    Given navigates to "Operators" List page
    Then SalesRepOperatorCreation - Verify that user navigates to Operators tab 
#    When SalesRepOperatorCreation -  clicks on Create Operator button
    When SalesRepOperatorCreation -  clicks on Create Operator button
#    Then SalesRepOperatorCreation - verify that Operator New harness is displayed
    When SalesRepOperatorCreation - Sales Ops enters the data and navigates to Operator Access tab
    Then SalesRepOperatorCreation - verify that Operator navigates to Access tab
    When SalesRepOperatorCreation - enters data in Operator Access tab and navigates to Sales Goals tab
#    Then SalesRepOperatorCreation - Verify that Sales Goals tab is displayed 
#    When SalesRepOperatorCreation - Enters Sales Goals information and submits
#    Then SalesRepOperatorCreation - Verify that operator record is created
    When SalesRepOperatorCreation - Navigate to Operator list page to search the newly created Operator
