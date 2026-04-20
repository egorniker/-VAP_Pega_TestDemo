package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.pega.crm.pegamarketing.pages.Treatments;
import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.Then;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class TreatmentCheckPointsglue {

	private EmailTreatment emailTreatment;

	@Then("^Issue/Group, Search, View, Create, Help, Email, SMS, Sections, Paragraphs fields should be available$")
	public void issue_Group_Search_View_Create_Help_Email_SMS_Sections_Paragraphs_fields_should_be_available() {
		Treatments treatments = ObjectsBean.getTreatments();
		Assert.assertTrue(treatments.verifyElement(Treatments.ISSUE_GROUP_DIV),
				"Issue / Group field is not available..!!");
		Assert.assertTrue(treatments.verifyElement(Treatments.VIEW_BUTTON), "View button is not available..!!");
		Assert.assertTrue(treatments.verifyElement(Treatments.CREATE_BUTTON), "Create button is not available..!!");
		Assert.assertTrue(treatments.verifyElement(Treatments.HELP_BUTTON), "Help button is not available..!!");
		Assert.assertTrue(treatments.verifyElement(Treatments.EMAILS_TAB), "Emails tab field is not available..!!");
		Assert.assertTrue(treatments.verifyElement(Treatments.SMS_TAB), "SMS tab field is not available..!!");
		Assert.assertTrue(treatments.verifyElement(Treatments.SECTIONS_TAB), "Sections tab field is not available..!!");
		Assert.assertTrue(treatments.verifyElement(Treatments.PARAGRAPHS_TAB),
				"Paragraphs tab field is not available..!!");
	}
	@Then("^Content,Details, Test Email, Prompts, Pages and Classes, Security and History tabs should be available$")
	public void contentdetails_test_email_prompts_pages_and_classes_security_and_history_tabs_should_be_available() {
		emailTreatment = ObjectsBean.getEmailTreatment();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { e.printStackTrace(); }
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.CONTENT_TAB),
				"Content tab is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.DETAILS_TAB),
				"Details tab is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.TEST_EMAIL_TAB),
				"Test Message tab is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.PAGES_AND_CLASSES_TAB),
				"Pages & Classes tab is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.SECURITY_TAB),
				"Security tab is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.HISTORY_TAB), "History tab is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.PROMPTS_TAB), "Prompts tab is not available..!!");
	}

	@Then("^Subject field should be available$")
	@Then("^Subject and Key Code fields should be available$")
	public void subject_field_should_be_available() {
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.SUBJECT_AUTOCOMPLETE),
				"Subject autocomplete field is not available..!!");

	}

	@Then("^Edit Mode, Pick email Template, Load Template from File, View, Desktop and Mobile buttons should be available$")
	public void edit_Mode_Pick_email_Template_Load_Template_from_File_View_Desktop_and_Mobile_buttons_should_be_available() {
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.EDIT_MODE_BUTTON),
				"Edit mode button is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.PICK_EMAIL_TEMPLATE_BUTTON),
				"Pick Email button is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.LOAD_TEMPLATE_FROM_FILE_BUTTON),
				"Load Template From File button is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.DESKTOP_VIEW_BUTTON),
				"Desktop view button is not available..!!");
		Assert.assertTrue(emailTreatment.verifyElement(EmailTreatment.MOBILE_VIEW_BUTTON),
				"Mobile view button is not available..!!");
	}

	@Then("^Checkout button should appear$")
	public void checkout_button_should_appear() {
		Assert.assertTrue(emailTreatment.verifyElement(RuleInstance.CHECKOUT_BUTTON),
				"Checkout button did not appear after saving Treatment rule..!!");
	}

}
