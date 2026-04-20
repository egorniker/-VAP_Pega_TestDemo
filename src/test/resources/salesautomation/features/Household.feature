@household @smoke @smoke-sales-automation
Feature: Sales Automation Household feature
Test covering the creation of Household creation 

Background: 
	Given User logs in to SA Application as salesmanager

@TC-house-hold-creation 
Scenario: Creating a Households
	Given navigates to "Households" List page
	When user clicks on CreateHousehold button
	Then user should navigate to Household creation page
	When user enters all HH mandatory data for households and saves the changes
	Then Household should be created
	Then verify the Household WO subtabs
