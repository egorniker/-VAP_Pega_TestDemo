package com.pega.crm.pegamarketing.stepdefs;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.pages.Segments;
import com.pega.crm.pegamarketing.pages.Segments.ImageCatalog;
import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.crm.pegamarketing.utils.ObjectsBean;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class SegmentCheckPointsglue {
	private PegaWebDriver pegaDriver;
	private Segment editSegment;
	private ImageCatalog ic;
	private DesignerStudio designerStudio;

	@Inject
	public SegmentCheckPointsglue(CRMTestEnvironment testEnv, CRMBrowser browser) {
		pegaDriver = testEnv.getPegaDriver();
		designerStudio = browser.getDesignerStudio();
	}

	@When("^Verifies Create button$")
	public void verifies_Create_button() {
		Segments segments = ObjectsBean.getSegments();
		Assert.assertTrue(segments.verifyElement(Segments.CREATE_BTN),
				"Create button is not available in Audiences page..!!");
	}

	@Then("^Segment name, Issue, Group, Segment Subject, Type and Analysis Project fields should be present$")
	public void segment_name_Isse_Group_Segment_Subject_Type_and_Analysis_Project_fields_should_be_present() {
		Segment segment = ObjectsBean.getSegment();
		Assert.assertTrue(segment.verifyElement(Segment.RULE_NAME_TEXT_BOX), "Segment name textbox is not present..!!");

		Assert.assertTrue(segment.verifyElement(Segment.ISSUE_SELECT_BOX), "Issue dropdown is not present..!!");
		Assert.assertTrue(segment.verifyElement(Segment.GROUP_SELECT_BOX), "Group dropdown is not present..!!");

		Assert.assertTrue(segment.verifyElement(Segment.CUTOMER_RADIO_BUTTON),
				"Customer Segment subject is not present..!!");
		Assert.assertTrue(segment.verifyElement(Segment.PROSPECT_RADIO_BUTTON),
				"Prospect Segment subject is not present..!!");

		Assert.assertTrue(segment.verifyElement(Segment.CRITERIA_RADIO_BUTTON), "Criteria type is not present..!!");
		Assert.assertTrue(segment.verifyElement(Segment.LIST_RADIO_BUTTON), "List type is not present..!!");

	}

	@Then("^Analysis Project dropdown should disappear$")
	public void analysis_Project_dropdown_should_disappear() {
		Segment segment = ObjectsBean.getSegment();
		pegaDriver.waitForDocStateReady();
		Assert.assertFalse(segment.findElement(Segment.ANALYSIS_PROJECT_SELECT_BOX).isVisible(),
				"Analysis Project dropdown is not disappeared..!!");
	}

	@Then("^Analysis Project dropdown should appear again$")
	public void analysis_Project_dropdown_should_appear_again() {
		Segment segment = ObjectsBean.getSegment();
		pegaDriver.waitForDocStateReady();
		Assert.assertTrue(segment.findElement(Segment.ANALYSIS_PROJECT_SELECT_BOX).isVisible(),
				"Analysis Project dropdown is not appeared again..!!");
	}

	@Then("^Segment rule should have \"([^\"]*)\" and \"([^\"]*)\" tabs$")
	public void segment_rule_should_have_and_tabs() {
		editSegment = ObjectsBean.getSegment();
		Assert.assertTrue(editSegment.verifyElement(By.xpath(Segment.CUSTOMER_LIST_TAB_XPATH)),
				"Customer list tab is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(Segment.HISTORY_TAB), "History tab is not present..!!");
	}

	@Then("^Segment image, Total Customer Count and In this Segment fields should be present$")
	public void segment_image_Total_Customer_Count_and_In_this_Segment_fields_should_be_present() {
		Assert.assertTrue(editSegment.verifyElement(By.xpath(Segment.DEFAULT_SEGMENT_IMAGE_XPATH)),
				"Default segment image is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(By.xpath(Segment.TOTAL_CUTOMER_COUNT_LABEL_XPATH)),
				"Total customer count label is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(By.xpath(Segment.IN_THIS_SEGMENT_LABEL_XPATH)),
				"In this segment label is not present..!!");
	}

	@Then("^Customer list tab should have Import and Add links and they are clickable$")
	public void customer_list_tab_should_have_Import_and_Add_links_and_they_are_clickable() {
		Assert.assertTrue(editSegment.verifyElement(By.linkText(Segment.IMPORT_LINKTEXT)),
				"Import link is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(By.linkText(Segment.ADD_LINKTTEXT)), "Add link is not present..!!");
	}

	@Then("^CustomerID, Email and Name fields should be present along with filters in work area$")
	public void customerid_Email_and_Name_fields_should_be_present_along_with_filters_in_work_area() {
		Assert.assertTrue(editSegment.verifyElement(By.xpath(Segment.CUSTOMERID_HEADER_DIV_XPATH)),
				"Customer ID field is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(By.xpath(Segment.NAME_HEADER_DIV_XPATH)),
				"Name field is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(By.xpath(Segment.EMAIL_HEADER_DIV_XPATH)),
				"Email field is not present..!!");
	}

	@Then("^OK button should be enabled$")
	public void ok_button_should_be_enabled() {
		Assert.assertTrue(ic.findElement(By.id(ImageCatalog.OK_BUTTON_ID)).isEnabled(),
				"OK button is not enabled after selecting image from catalog..!!");
	}

	@Then("^Segment rule should have Design tab, Options and Schedule tab and History tab$")
	public void segment_rule_should_have_Design_tab_Options_and_Schedule_tab_and_History_tab() {
		editSegment = ObjectsBean.getSegment();
		Assert.assertTrue(editSegment.verifyElement(Segment.DESIGN_TAB), "Design tab is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(Segment.OPTIONS_AND_SCHEDULE_TAB),
				"Options and Schedule tab is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(Segment.HISTORY_TAB), "History tab is not present..!!");

	}

	@Then("^All fields headings such as Data Options, Sampled Segment Options and etc should be present$")
	public void all_fields_headings_such_as_Data_Options_Sampled_Segment_Options_and_etc_should_be_present() {
		Assert.assertTrue(editSegment.verifyElement(Segment.DATA_REFRESH_HEADER),
				"Data Options header is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(Segment.SAMPLED_SEGMENT_OPTIONS_HEADER),
				"Sampled Segment Options header is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(Segment.SCHEDULING_OPTIONS_HEADER),
				"Scheduling Options header is not present..!!");
	}

	@Then("^Visualization mode buttons should be present in Design tab$")
	public void visualization_mode_buttons_should_be_present_in_Design_tab() {
		editSegment = ObjectsBean.getSegment();
		Assert.assertTrue(editSegment.verifyElement(Segment.VISUALIZATION_MODE_TRUE_BUTTON),
				"Visualization mode true button is not present..!!");
		Assert.assertTrue(editSegment.verifyElement(Segment.VISUALIZATION_MODE_FALSE_BUTTON),
				"Visualization mode false button is not present..!!");
	}

	@Then("^Stop link should be available to stop the run$")
	public void stop_link_should_be_available_to_stop_the_run() {
		editSegment = ObjectsBean.getSegment();
		Assert.assertTrue(editSegment.verifyElement(Segment.STOP_LINK),
				"Stop link is not available to stop the run..!!");
	}

	@Then("^End of the run, Population count should become \"([^\"]*)\"$")
	public void end_of_the_run_Population_count_should_become(String populationCount) {
		editSegment = ObjectsBean.getSegment();
		editSegment.waitForRun();
		Assert.assertEquals(editSegment.findElement(Segment.POPULATION_COUNT_SPAN).getText(), populationCount);
	}

}
