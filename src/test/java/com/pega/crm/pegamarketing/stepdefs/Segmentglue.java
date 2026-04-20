package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.crm.pegamarketing.rules.Segment.AddCriteriaDialog;
import com.pega.crm.pegamarketing.utils.ObjectsBean;
import com.pega.crm.pegamarketing.utils.TestDataReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Segmentglue {

	private Segment segment;

	@Then("^Segment rule should be created$")
	public void segment_rule_should_be_created() {
		segment = ObjectsBean.getSegment();
		Assert.assertTrue(segment.verifyElement(RuleInstance.SAVE_BUTTON), "Edit Segment rule is not created..!!");
	}

	@When("^User saves the segment rule$")
	public void user_Saves_the_segment_rule() {
		segment.save();
	}

	@Then("^Segment rule should be saved succesfully$")
	public void segment_rule_should_be_saved_succesfully() {
		Assert.assertTrue(segment.verifyElement(RuleInstance.SAVEAS_BTN),
				" Segment rule is not saved successfully..!!");
	}

	@When("^User closes the segment rule$")
	public void user_closes_the_segment_rule() {
		segment.close();
	}

	@When("^User switches to \"([^\"]*)\" tab in segment$")
	public void user_switches_to_tab_in_segment(String tabName) {
		segment.switchTab(tabName);
	}

	@When("^Adds a group and criteria as \"([^\"]*)\" and value as \"([^\"]*)\"$")
	public void adds_a_group_and_criteria_as_and_value_as(String criteria, String criteriaValue) {
		segment.addGroup();
		AddCriteriaDialog addCriteriaDialog = segment.addCriteria();
		criteria = TestDataReader.getTestDataValue(criteria);
		addCriteriaDialog.selectCriteria(criteria);
		addCriteriaDialog.apply();
		segment.enterCriteriaValue(criteriaValue);
	}

	@When("^Adds a criteria as \"([^\"]*)\" and value as \"([^\"]*)\" to existing criteria$")
	public void adds_a_criteria_as_and_value_as_to_existing_criteria(String criteria, String criteriaValue) {
		AddCriteriaDialog addCriteriaDialog = segment.addCriteria();
		addCriteriaDialog.selectCriteria(criteria);
		addCriteriaDialog.apply();
		segment.enterCriteriaValue(criteriaValue);
	}

	@When("^Adds a group and criteria as \"([^\"]*)\" and value as greater than \"([^\"]*)\"$")
	public void adds_a_group_and_criteria_as_and_value_as_greater_than(String criteria, String criteriaValue) {
		segment.addGroup();
		AddCriteriaDialog addCriteriaDialog = segment.addCriteria();
		addCriteriaDialog.selectCriteria(criteria);
		addCriteriaDialog.apply();
		segment.selectComparision("Greater than");
		segment.enterCriteriaValue(criteriaValue);
	}

	@When("^User runs the Segment$")
	public void user_runs_the_Segment() {
		segment.run();
	}

	@When("^User enters \"([^\"]*)\" as segment name and selects \"([^\"]*)\" as Issue and \"([^\"]*)\" as Group$")
	public void user_enters_as_segment_name_and_selects_as_Issue_and_as_Group(String segName, String issue,
			String group) {
		segment = ObjectsBean.getSegment();
		segName = ObjectsBean.putTimeStampedValue(segName);
		segment.setRuleName(segName);
		issue = TestDataReader.getTestDataValue(issue);
		segment.setIssue(issue);
		group = TestDataReader.getTestDataValue(group);
		segment.setGroup(group);
	}

	@When("^Creates and opens the segment$")
	public void clicks_on_Create_and_Open_button() {
		segment.createAndOpen();
	}

}
