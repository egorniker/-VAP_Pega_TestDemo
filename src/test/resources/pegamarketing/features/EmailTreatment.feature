@smoke-pega-marketing
Feature: Smoke Test cases
# author : PM

Scenario: Create an Email Treatment
    Given A User logs in with Analyst credentials
    When User expands Content from the Left Nav
    When Opens Treatment landing page
    Then Treatment landing Page should be displayed
    Then Issue/Group, Search, View, Create, Help, Email, SMS, Sections, Paragraphs fields should be available
    When User creates Email treatment
    When User enters "TestEmailTreatment" as Email Treatment Name
    When selects "DemoIssue" as Issue and "DemoGroup" as Group for Email Treatment
    When Creates and opens the Email Treatment
    Then Email Treatment Rule should be opened
    Then Content,Details, Test Email, Prompts, Pages and Classes, Security and History tabs should be available
    Then Subject field should be available
    Then Edit Mode, Pick email Template, Load Template from File, View, Desktop and Mobile buttons should be available
    When User enters "TestEmailTreatment" in the Subject field
    When Opens Email Editor
    When Enters "EmailTreatmentCriteria" in the Editor
    When User switches to "Details" tab
    When Enters "TestEmailKeyCode" in KeyCode field
    When Saves the Treatment
    Then Checkout button should appear