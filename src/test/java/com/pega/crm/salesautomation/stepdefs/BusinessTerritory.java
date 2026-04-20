package com.pega.crm.salesautomation.stepdefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.Territories;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class BusinessTerritory {

	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	TerritoriesList trrList;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;
	Organization organization, org;
	public static String Subject = null;
	String OPP_TableHeader[] = { "Name", "Account", "Stage", "Owner", "Amount", " ", "Close date", "Must win",
			"Territory", "Source", "" };
	List<String> OPP_LISTHEADER = new ArrayList<String>(Arrays.asList(OPP_TableHeader));
	String actual_name, actual_territory, actual_con, actual_amount, actual_closedate, actual_owner, actual_shortName,
			actual_source, actual_stage, actual_win, actual_Forecast, actual_description;

	@Inject
	public BusinessTerritory(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);

	}

	/*
	 * 
	 * Business Territoryies
	 * 
	 */

	String TRR_PLACEHOLDER = "Filter territories";
	Scenario sc;
	String TerritoryName = null;
	String ModifiedTerritoryOwner = null;
	String ModifiedTerritoryParent = null;

	Territories trr;
	String MODELBOXNAME = "Business Territory Details";
	String TERRITORYNAME = "AutoTerritory-1";
	String TERRITORYOWNER = "Terry Mason";
	String DELEGATE = "tmason";
	String PARENTTERRITORY = "Global";
	String TRR_TableHeader[] = { "Name", "Status", "Owner", "Delegate", "ID", "Parent", "Partner" };
	List<String> TRR_LISTHEADER = new ArrayList<String>(Arrays.asList(TRR_TableHeader));
	String TerryName;

	@When("^User Navigates to Territories tab$")
	public void user_Navigates_to_Territories_tab_to_Create_Territories() {
		trrList = sfaPortal.getLeftNav().getTerritoriesList();
	}

	@When("^User clicks on Create Territory button$")
	public void user_clicks_on_Create_Territory_button() {
		trr = trrList.createTerritory();

	}

	@Then("^verify that Business Territory New modal dialog is displayed$")
	public void verify_that_Business_Territory_New_modal_dialog_is_displayed() {
		Assert.assertTrue(trr.isTerritoryNameDisplayed());
		Assert.assertTrue(trr.isSubmitDisplayed());

	}

	@When("^User enters the data for \"(.+)\" \"(.+)\" \"(.+)\" \"(.+)\" and submits$")
	public void user_enters_the_data_and_submits(String TerritoryName, String ParentTerritory, String TerritoryOwner,
			String ReservedForPartner) {
		TerryName = TerritoryName + new Random().nextInt(1000);
		trr.setTerritoryName(TerryName);
		trr.setOwner(TerritoryOwner);
		trr.setReservedForPartner(ReservedForPartner);
		trr.clickSubmit();

	}

	@Then("^verify that Business Territory with name \"(.+)\" and \"(.+)\" is created$")
	public void verify_that_Business_Territory_is_created(String territoryName, String OwnerName) {
		trr = trrList.navigateTerritory(TerryName);
		String actualTerritoryName = trr.getTerritoryName();
		String actualOwner = trr.getTerritoryOwner();
		System.out.println("Print owner name"+ actualOwner);
		Assert.assertTrue(actualTerritoryName.equals(TerryName));
		Assert.assertEquals(actualOwner, OwnerName);

	}

}
