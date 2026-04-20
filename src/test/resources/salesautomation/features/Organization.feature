@organization @smoke @smoke-sales-automation
Feature: Sales Automation Organization feature
Test covering the creation of Organization Work object in Sales Automation 

Background: 
	Given User logs in to SA Application as salesmanager
 
@TC-organization-creation
  Scenario: create Organization
    Given navigates to "Organizations" List page
    When SalesOps navigates to Organization tab to Create Org
    Then Verify that user navigates to Organization tab 
    When SalesOps clicks on Create Oranization button
    Then verify that Organization New harness is displayed
    When SalesOps enters the data and submits
    Then verify that Organization Wo is created
   	 
