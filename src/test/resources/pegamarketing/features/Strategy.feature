@smoke-pega-marketing
Feature: Smoke Test cases
# author : PM

    Scenario: Creation of Strategy from Strategy Designer page
        Given A User logs in with Analyst credentials
        When User expands Intelligence and navigates to Strategies
        When User opens Strategies from PMPortal
        When User creates a strategy using start with new canvas
        When User enters strategy name and description as "DemoStrategy"
        When User selects Business Issue as "DemoIssue"
        When User selects Group as "DemoGroup"
        Then User selects the context as "Customers"
        When User creates and open canvas strategy
        Then User performs a right click on subscriber section
        And User adds a proposition shape to subscriber section
        Then update the proposition shape name as "StrategyOffer" and select offer as "TestOffer124559"
        And User drags connector from proposition shape to anchor output
        And User saves the strategy
        Then checkout button should be visible

