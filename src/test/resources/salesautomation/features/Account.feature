@account @smoke @smoke-sales-automation
Feature: Sales Automation Account feature
Test covering the creation of Account and editing flow actions

Background:
	Given User logs in to SA Application as salesmanager
 
 @TC-account-creation
  Scenario: Creating a Account
    Given navigates to "Accounts" List page
    When user clicks on CreateAccount button
    Then user should navigate to Account creation page
	  When user enters all the mandatory data and saves the changes
    Then Account should be created
    
@TC-editing-account
  Scenario Outline: Editing an account
   	Given navigates to "Accounts" List page
    When user opens the existing Account with "<AccName>"
    When clicks on edit button
    Then user should able to edit all the fields in Account page
    When user edits the input fields and save the changes
    Then Account should be reflected with the changes made in the account page
		Examples:
		|AccName|
		|Nexus Energy|
