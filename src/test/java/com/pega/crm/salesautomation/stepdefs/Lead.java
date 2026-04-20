package com.pega.crm.salesautomation.stepdefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Lead {

	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;
	Leads lead;
	String LEAD_INDUSTRY = "Services";
	String LEAD_COMPANYNAME = "VKgroup";
	String teritory = "Global";
	String LEAD_LASTNAME_INDIVIDUAL = "Automation Lead Individual";
	String LEAD_LASTNAME_BUSINESS = "Automation lead Business";
	String LEAD_STAGE = "Assigned";
	String LEAD_UPDATEDINDUSTRY = "Mining";
	String LEAD_UPDATEDSTAGE = "Sales Qualified";
	String LEAD_UPDATEDCOMPANY = "CompanyUpdated";
	String LEAD_WORKHONE = "895462103";
	String LEAD_EMAIL = "abc@test.com";
	String LEAD_MOBILE = "123456";
	String LEAD_DESCRIPTION = "This is test data";
	String LEAD_TERRITORY = "Global";
	String LEAD_UPDATEDOWNER = "Anna Parker";
	String LEAD_CHANGEREASON = "Changed as part of automation script";
	String LEAD_TASK_SUBJECT = "Adding task to Lead";
	String LEAD_TASK_TASKTYPE = "Customer Communication";
	String LEAD_PLACEHOLDER = "Filter lead";
	String LEAD_TableHeader[] = { "Score", "Name", "Company name", "Stage", "Create date", "Owner", "Territory",
			"Source", "Days inactive", " ", " ", " " };
	List<String> LEAD_LISTHEADER = new ArrayList<String>(Arrays.asList(LEAD_TableHeader));

	String LEAD_SubTabs[] = { "Pulse", "Details", "Activities", "Attachments" };
	List<String> LEAD_WO_SUBTABS = new ArrayList<String>(Arrays.asList(LEAD_SubTabs));

	LeadsList leadlist;

	@Inject
	public Lead(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);
		this.leadlist = browser.leadList;
	}

	@When("^user opens the \"([^\"]*)\" Lead with \"([^\"]*)\"$")
	public void user_opens_the_Lead_with(String LeadType, String LeadName) throws Throwable {

		if (LeadType.equals("Business")) {

			lead = leadlist.navigateLead(LeadName);

		}

		else if (LeadType.equals("Individual")) {

			lead = leadlist.navigateLead(LeadName);
		}
	}
	/*
	 * 
	 * Lead Functions
	 * 
	 */

	@When("^users clicks on Create LeadButton and selects \"(.*?)\"$")
	public void users_clicks_on_Create_LeadButton_and_selects(String LeadType) {
		if (LeadType.equals("Business")) {
			lead = leadlist.createBusinessLead();
		} else if (LeadType.equals("Individual")) {
			lead = leadlist.createIndividualLead();
		}

	}

	@When("^Enters all the mandatory Lead data for \"(.*?)\"$")
	public void Enters_all_the_mandatory_data(String LeadType) {

		if (LeadType.equals("Business")) {
			lead.setLastName(LEAD_LASTNAME_BUSINESS);
			lead.setCompany(LEAD_COMPANYNAME);
			lead.setIndustry(LEAD_INDUSTRY);
		}

		else if (LeadType.equals("Individual")) {
			lead.setLastName(LEAD_LASTNAME_INDIVIDUAL);

		}

		lead.setStage(LEAD_STAGE);
		lead.clickOK();

	}

	@Then("^\"([^\"]*)\" Lead should be created with \"([^\"]*)\"$")
	public void lead_should_be_created_with_with(String LeadType, String LeadName) throws Throwable {

		if (LeadType.equals("Business")) {
			String lastname = lead.getLastName();
			Assert.assertEquals(lastname, LeadName);
		}

		else if (LeadType.equals("Individual"))

		{
			String lastname = lead.getLastNameForIndividual();
			Assert.assertEquals(lastname, LeadName);
		}

	}

	@Then("^verify the lead WO subtabs$")
	public void verify_the_lead_WO_subtabs() throws Throwable {

		ArrayList<String> subTabs = lead.getSubTabs();
		Assert.assertEquals(subTabs, LEAD_WO_SUBTABS);

	}

	@When("^clicks on change owner button$")
	public void clicks_on_change_owner_button() {
		// Write code here that turns the phrase above into concrete actions
		lead.clickChangeOwner();
	}

	@Then("^user should navigate to change Owner page$")
	public void user_should_navigate_to_change_Owner_page() {
		String sectionname = lead.getSectionHeader();
		Assert.assertEquals(sectionname.trim(), "Change owner");
	}

	@When("^user changes the Owner, enters the reason and submit the changes$")
	public void user_changes_the_Owner_enters_the_reason_and_submit_the_changes() {

		lead.setOwner(LEAD_UPDATEDOWNER);
		lead.setReason(LEAD_CHANGEREASON);
		lead.clickSubmitButton();
	}

	@Then("^ownership of the \"([^\"]*)\" lead should be changed$")
	public void ownership_of_the_lead_should_be_changed(String LeadType) {
		String owner = lead.getOwner();
		Assert.assertEquals(owner, LEAD_UPDATEDOWNER);
	}

}
