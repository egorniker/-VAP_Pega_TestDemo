package com.pega.crm.pegamarketing.stepdefs;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.pega.crm.pegamarketing.pages.Segments;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Segmentsglue {

	private Segments segments;

	@When("^User creates segment by clicking on Create button$")
	public void user_creates_segment_by_clicking_on_Create_button() {
		segments = ObjectsBean.getSegments();
		Segment segment = segments.createSegment();
		ObjectsBean.setSegment(segment);
	}

	@Then("^Verifies the newly created segment rule \"([^\"]*)\" in Audiences landing page$")
	public void verifies_the_newly_created_segment_rule_in_Audiences_landing_page(String segmentName) throws Throwable {
		String actualSegName = ObjectsBean.getTimeStampedValue(segmentName);
		Assert.assertTrue(segments.verifyElement(By.linkText(actualSegName)),
				"Newly create segment could not be found in Segments landing page..!!");
	}

	@Then("^Open and verifies the newly created segment rule \"([^\"]*)\"$")
	public void open_and_verifies_the_newly_created_segment_rule(String segName) {
		Segment segment = segments.openSegmentRule(ObjectsBean.getTimeStampedValue(segName));
		Assert.assertTrue(segment.verifyElement(RuleInstance.SAVEAS_BTN),
				" Segment rule is not saved successfully..!!");
	}

}
