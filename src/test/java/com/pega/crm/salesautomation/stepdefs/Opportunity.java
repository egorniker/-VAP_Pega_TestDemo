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
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Opportunity {

	String OPP_SOURCE = "Customer Referral";
	String OPP_SHORTNAME = "Auto_oppty";
	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;
	Opportunities opp;
	Organization organization, org;
	OpportunityList oppList;
	public static String Subject = null;
	String OPP_CLONE_BUSINESS_NAME = "Automation opp for business cloned";
	String OPP_CLONE_INDIVIDUAL_NAME = "Automation opp for individual cloned";
	String OPP_BUSINESS_NAME = "Automation opp for business";
	String OPP_INDIVIDUAL_NAME = "Automation opp for individual";
	String OPP_UPDATEDAMOUNT = "54123";
	String OPP_UPDATEDFORECAST = "Upside";
	String OPP_UPDATEDOWNER = "Anna Parker";
	String OPP_UPDATE_CONTACTS = "Annabelle Boord";
	String OPP_UPDATEDSOURCE = "Employee Referral";
	String OPP_CLONEAMOUNT = "58000";
	String OPP_PLACEHOLDER = "Filter opportunity";
	String OPP_FORECAST = "Stretch";
	String OPP_AMOUNT = "65400";
	String OPP_BUSINESS_CONTACT = "Acme Software";
	String OPP_INDIVIDUAL_CONTACT = "Kris Marrier";
	String OPP_TERRIORTY = "Global";
	String OPP_STAGE = "Qualification";
	String OPP_UPDATED_STAGE = "Decision";
	String OPP_UPDATED_STAGE_FROMSUBTAB = "Negotiation";
	String OPP_MERGE_DESCRIPTION = "Merged as part of automation";
	String OPP_NAME_FOR_FOLLOW = "Wireless Tri-Zone Sensors for John Smith";

	String NewStage;
	String OPP_SUBTABS[] = { "Pulse", "Details", "Contacts", "Activities", "Leads", "Close plans", "Attachments",
			"Partner contacts" };

	List<String> OPP_LISTTABS = new ArrayList<String>(Arrays.asList(OPP_SUBTABS));
	String OPP_CHANGEREASON = "Owner is changed as part of automation testing";
	String OPP_CLOSE_COMMENTS = "Closed as  we won the Opportunity";
	String OPP_CLOSE_REASON = "Lost";
	String OPP_DESCRIPTION = "Created as part of Automation scripts";
	String OPP_ACTIVITY_COMMUNICATIONTYPE = "Phone";
	String OPP_ACTIVITY_OUTCOME = "Outcome for the activity from Opportunity";

	String OPP_TASK_SUBJECT = "Adding task to oppty";
	String OPP_TASK_TASKTYPE = "Customer Communication";
	String OPP_TASK_PRIORITY = "2-Medium";
	String OPP_TASK_STATUS = "Not Started";
	String OPP_TASK_COMMENTS = "Comments from oppty";
	static String OPP_DUE_DATE = "4/30/2017";
	String TASKVALUES[] = { OPP_TASK_SUBJECT, OPP_TASK_STATUS, OPP_DUE_DATE, "tmason", OPP_TASK_PRIORITY };
	List<String> OPP_TASKROWVALUES = new ArrayList<String>(Arrays.asList(TASKVALUES));
	String ACTIVITYVALUES[] = { Subject, OPP_ACTIVITY_COMMUNICATIONTYPE, OPP_DUE_DATE, "Terry Mason", " " };
	List<String> OPP_ACTIVITYROWVALUES = new ArrayList<String>(Arrays.asList(ACTIVITYVALUES));
	String OPP_ID = "";

	String OPP_TableHeader[] = { "Name", "Account", "Stage", "Owner", "Amount", " ", "Close date", "Must win",
			"Territory", "Source", "" };
	List<String> OPP_LISTHEADER = new ArrayList<String>(Arrays.asList(OPP_TableHeader));
	String actual_name, actual_territory, actual_con, actual_amount, actual_closedate, actual_owner, actual_shortName,
			actual_source, actual_stage, actual_win, actual_Forecast, actual_description;

	@Inject
	public Opportunity(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);

		this.oppList = browser.oppList;

	}

	@When("^users clicks on Create OpprotunityButton and selects \"(.+)\"$")
	public void users_clicks_on_Create_OpprtunityButton(String opptype) throws InterruptedException {
		if (opptype.equals("Business")) {
			opp = oppList.createBusniessOpportunity();
		} else if (opptype.equals("Individual")) {
			opp = oppList.createIndividualOpportunity();
		}

	}

	@When("^Enters all the mandatory data for \"(.+)\"$")
	public void enters_all_the_mandatory_data(String opptype) throws InterruptedException {

		opp.setAmount(OPP_AMOUNT);
		opp.setDate();
		// opp.setTerritory(OPP_TERRIORTY);
		NewStage = opp.setStage(OPP_STAGE);
		opp.setForecastCategory(OPP_FORECAST);
		opp.setSource(OPP_SOURCE);
		opp.setShotName(OPP_SHORTNAME);
		opp.setDescrption(OPP_DESCRIPTION);
		opp.setOpptyMustWin();

		if (opptype.equals("Business")) {
			opp.setName(OPP_BUSINESS_NAME);
			opp.setContact(OPP_BUSINESS_CONTACT);
		} else {
			System.out.println("Opportunity type selection missing ");
		}
//		opp.clickCreate();
		opp.clickSubmitButton();

	}

	@Then("^\"(.+)\" Opportunity should be created$")
	public void Bussiness_opprtunity_should_be_created(String opptype) {

		actual_amount = opp.getAmount();
		actual_closedate = opp.getClosedate();
		actual_territory = opp.getTerritory();
		actual_shortName = opp.getShortName();
		actual_Forecast = opp.getForecast();
		actual_source = opp.getSource();
//		actual_stage = opp.getStageForBusiness();
		actual_win = opp.getWin();
		Assert.assertEquals(actual_amount, OPP_AMOUNT);
		Assert.assertEquals(actual_shortName, OPP_SHORTNAME);
		Assert.assertEquals(actual_Forecast, OPP_FORECAST);
		Assert.assertEquals(actual_source, OPP_SOURCE);
//		Assert.assertEquals(actual_stage, NewStage);
		Assert.assertEquals(actual_win, "Yes");
		if (opptype.equals("Business")) {
			actual_name = opp.getName();
			Assert.assertEquals(actual_name, OPP_BUSINESS_NAME);

		}

	}

	@When("^user updates the stage and submit the changes$")
	public void user_updates_the_stage_and_submit_the_changes() {
		NewStage = opp.setStage(OPP_UPDATED_STAGE);
		opp.clickSubmitButton();
	}

	@Then("^opportunity should have all the tabs$")
	public void opportunityTabs() {
		ArrayList<String> subTabs = opp.getSubTabs();
		Assert.assertEquals(subTabs, OPP_LISTTABS);

	}

	@Then("^user should navigate to change stage page$")
	public void user_should_navigate_to_change_stage_page() {
		String sectionname = opp.getSectionname();
		Assert.assertEquals(sectionname,"Change stage");
	}

	@Then("^stage of the \"(.*?)\" opportunity should be changed$")
	public void stage_of_the_opportunity_should_be_changed(String opptype) {

		String Stage = null;

		if (opptype.equals("Business")) {
			Stage = opp.getStageForBusiness();
		} else if (opptype.equals("Individual")) {
			Stage = opp.getStageForIndividual();
		}

		Assert.assertEquals(Stage.trim(), NewStage);
	}

	@When("^user opens the \"(.+)\" opportunity with \"(.+)\"$")
	public void user_opens_the_opportunity(String oppType, String OpptyName) {
		try{
			Thread.sleep(10000);
		}catch (Exception e){
			e.printStackTrace();
		}
		if (oppType.equals("Business")) {
			opp = oppList.navigateOpportunity(OpptyName);
		} else if (oppType.equals("Individual")) {
			opp = oppList.navigateOpportunity(OpptyName);
		}
	}

	@When("^clicks on Close button for \"(.*?)\" Opportunity$")
	public void clicks_on_Close_button_for_Opportunity(String opptype) {
		if (opptype.equals("Business")) {
			opp.clickCloseForBusiness();
		} else if (opptype.equals("Individual")) {
			opp.clickCloseForIndividual();
		}

	}

	@When("^user enters the reason for closing of opportunity and saves the changes$")
	public void user_enters_the_reason_for_closing_of_opportunity_and_saves_the_changes() {

		opp.setCloseReason(OPP_CLOSE_REASON);
		opp.setCloseComments(OPP_CLOSE_COMMENTS);
		opp.clickSubmitButton();
	}

	@Then("^\"(.*?)\" opportunity should be closed$")
	public void opportunity_should_be_closed(String arg1) {
		Assert.assertTrue(opp.isActionItemValuePresent("Reactivate"));

	}

	@When("^clicks on Update Stage button$")
	public void clicks_on_Update_Stage_button() {
		opp.clickUpdateStage();
	}

	@When("^clicks on Update Stage button from Subtab$")
	public void clicks_on_Update_Stage_button_from_Subtab() {
		opp.clickUpdateStagefromSubtab();

	}

	@When("^user updates the stage and submit the changes from subtab$")
	public void user_updates_the_stage_and_submit_the_changes_from() {

		NewStage = opp.setStage(OPP_UPDATED_STAGE_FROMSUBTAB);
		opp.clickSubmitButton();
	}

	@When("^user search for the \"([^\"]*)\" opportunity$")
	public void user_search_for_the_opportunity(String opptype) {
		oppList.switchToStageView();

		if (opptype.equals("Business")) {
			oppList.SwitchToBusinessTab();
			oppList.searchOpportunity(OPP_BUSINESS_NAME);
		} else if (opptype.equals("Individual")) {
			oppList.searchOpportunity(OPP_INDIVIDUAL_NAME);
		}

	}
}
