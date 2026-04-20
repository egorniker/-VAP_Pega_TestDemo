@forecast @smoke @smoke-sales-automation

Feature: Forecast Close Plans
  Close Plans provide updates summarizing accomplishments for the current week and upcoming plans

Background:
	Given User logs in to SA Application as salesmanager
	
Scenario: Search by organization
	Given navigates to "Close plans" List page
  When the rep searches for "APW Technologies Corp" organization
  Then opportunities related only to "APW Technologies" are shown
	