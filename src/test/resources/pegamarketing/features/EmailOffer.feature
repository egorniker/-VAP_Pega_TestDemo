@smoke-pega-marketing
Feature: Smoke Test cases
# author : PM
Scenario: Create an Email Offer Flow
    Given A User logs in with Analyst credentials
    When User expands Content from the Left Nav
    When Opens Offers landing page
    Then Offers landing Page should be displayed
    Then Issue/Group, Search, View, Create, Help fields should be available
    When User creates offer
    When User enters "TestOffer" as Offer Name
    When selects "DemoIssue" as Offer Issue and "DemoGroup" as Offer Group
    When Clicks on Create and Open button in Offer Page
    Then Offer Rule should be opened
    Then Diagram, Details, Test Offer and History tabs should be available
    When switches to Flow tab      
    When user deletes the existing start connector
    When adds a new send email shape to the offer at point "0","0" in the offer
    When opens the properties of send email shape with name "Send Email"
    When renames the send email shape as "SendEmail"
    When sets the treatment as "TestEmailTreatment124136"
    When sets the email account as "Default"
    When submits the properties
    When connects the start shape to the send email shape
    When connects the send email shape to the end shape
    When Saves the Offer
    Then the offer should be saved and checkout button should be visible