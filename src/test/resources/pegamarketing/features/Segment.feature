@smoke-pega-marketing
Feature: Smoke Test cases
# author : PM

  Scenario: Create Basic Criteria Segment
    Given A User logs in with Analyst credentials
    When User expands Audiences
    When Opens Segments landing page
    When User creates segment by clicking on Create button
    Then Segment name, Issue, Group, Segment Subject, Type and Analysis Project fields should be present
    When User enters "TestSegment" as segment name and selects "DemoIssue" as Issue and "DemoGroup" as Group
    When Creates and opens the segment
    Then Segment rule should be created
    Then Segment rule should have Design tab, Options and Schedule tab and History tab
    When User switches to "Options and schedule" tab in segment
    Then All fields headings such as Data Options, Sampled Segment Options and etc should be present
    When User switches to "Design" tab in segment
    When Adds a group and criteria as "SegmentCriteria" and value as "Auto"
    When User saves the segment rule
    Then Segment rule should be saved succesfully
    When User runs the Segment
    Then End of the run, Population count should become "3"
