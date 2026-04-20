@partner @smoke @smoke-sales-automation
Feature: Sales Automation Partner feature
Test covering the creation of Partner in Sales Automation 

Background: 
	Given User logs in to SA Application as salesops

@TC-partner-creation
Scenario: Creating a Partner with Salesrep
	Given navigates to "Partners" List page
	When User clicks on Create Partner and enters all the madatory data
	When clicks on OK button
	Then Partner should be created
