@contact @smoke @smoke-sales-automation
Feature: Contact Feature in Sales Automation
Test covering the creation of contact creation 

Background: 
Given User logs in to SA Application as salesmanager

@TC-contact-creation
  Scenario: Creating a contact
    Given navigates to "Contacts" List page
    When User clicks on Create ContactButton and enters all the madatory data
    When clicks on Save button
    And user opens the created contact
    Then verify contact subtabs
    Then C2A relationship should be created
    Then Primary Individual account should be created automatically
