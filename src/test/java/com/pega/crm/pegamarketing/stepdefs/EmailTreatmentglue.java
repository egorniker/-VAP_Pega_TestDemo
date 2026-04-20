package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.ObjectsBean;
import com.pega.crm.pegamarketing.utils.TestDataReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EmailTreatmentglue {

	private EmailTreatment emailTreatment;

	@When("^User enters \"([^\"]*)\" as Email Treatment Name$")
	public void user_enters_as_Treatment_Name(String treatmentName) {
		emailTreatment = ObjectsBean.getEmailTreatment();
		emailTreatment.setRuleName(ObjectsBean.putTimeStampedValue(treatmentName));
	}

	@When("^selects \"([^\"]*)\" as Issue and \"([^\"]*)\" as Group for Email Treatment$")
	public void selects_as_Issue_and_as_Group(String issue, String group) {
		issue = TestDataReader.getTestDataValue(issue);
		emailTreatment.setIssue(issue);
		group = TestDataReader.getTestDataValue(group);
		emailTreatment.setGroup(group);
	}

	@When("^Creates and opens the Email Treatment$")
	public void clicks_on_Create_and_Open_button_in_Treatment_Page() {
		emailTreatment.createAndOpen();
	}

	@Then("^Email Treatment Rule should be opened$")
	public void email_Treatment_Rule_should_be_opened() {
		Assert.assertTrue(emailTreatment.verifyElement(RuleInstance.SAVE_BUTTON),
				"Email treatment creation is not successful..!!");
	}

	@When("^User enters \"([^\"]*)\" in the Subject field$")
	public void user_enters_in_the_Subject_field(String subject) {
		emailTreatment.setSubject(subject);
	}

	@When("^Enters \"([^\"]*)\" in KeyCode field$")
	public void enters_in_KeyCode_field(String keyCode) {
		emailTreatment.setKeyCode(keyCode);
	}

	@When("^Opens Email Editor$")
	public void opens_Email_Editor() {
		emailTreatment.openEmailEditor();
	}

	@When("^Enters \"([^\"]*)\" in the Editor$")
	public void enters_in_the_Editor(String content) {
		content = TestDataReader.getTestDataValue(content);
		emailTreatment.writeContent(content);
	}

	@When("^Saves the Treatment$")
	public void saves_the_Treatment() {
		emailTreatment.save();
	}

	@When("^User switches to \"([^\"]*)\" tab$")
	public void user_switches_to_tab(String tabName) {
		emailTreatment.switchTab(tabName);
	}

	@Then("^clicks on Enter in Email Editor$")
	public void clicks_on_Enter_in_Email_Editor() {
		emailTreatment.clickEnterInEditor();
	}

}
