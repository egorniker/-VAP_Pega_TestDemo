package com.pega.crm.salesautomation.stepdefs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Contacts;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Account {

	String OPP_SOURCE = "Customer Referral";
	String OPP_SHORTNAME = "Auto_oppty";
	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;
	Opportunities opp;
	Organizations organization, org;
	OpportunityList oppList;
	OrganizationsList orgList, organizationList, orgResult;
	LeadsList leadlist;
	public ClosePlans closeplans;
	String CLOSEPLANS_COMMENTS = "Entering closeplans";
	public static String Subject = null;
	String OPP_TableHeader[] = { "Name", "Account", "Stage", "Owner", "Amount", " ", "Close date", "Must win",
			"Territory", "Source", "" };
	List<String> OPP_LISTHEADER = new ArrayList<String>(Arrays.asList(OPP_TableHeader));
	String actual_name, actual_territory, actual_con, actual_amount, actual_closedate, actual_owner, actual_shortName,
			actual_source, actual_stage, actual_win, actual_Forecast, actual_description;

	@Inject
	public Account(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);
		this.leadlist = browser.leadList;
		this.organizationList = browser.orgList;
		this.closeplans = browser.closeplans;

		this.accList = browser.accList;
		if (browser.campaignExists)
			OPP_LISTHEADER.set(10, "Campaign");
	}

	/*
	 * 
	 * Account Creation and Edit
	 * 
	 */

	static String Owner;
	Accounts acc, accResult;
	LeadsList leadList;
	Leads leads;
	ContactList contList;
	Contacts cont;
	public AccountList accList, accountsList;
	public Opportunities opportunity;
	SimpleDateFormat format = new SimpleDateFormat("MM/DD/YYYY");
	SimpleDateFormat format1 = new SimpleDateFormat("M/DD/YYYY");
	StringBuffer ACC_NAME = new StringBuffer("Dwayne Johnson");
	StringBuffer ACC_NAME_INDIVIDUAL = new StringBuffer("Adam Collins");
	String ACC_TERRIORTY = "Global";
	String ACC_ORG = "Acme Software";
	String ACC_INDUSTRY = "Mining";
	String ACC_PHONENUMBER = "12895647";
	String ACC_UPDATED_PHONENUMBER = "987645321";
	String ACC_UPDATED_INDUSTRY = "Services";
	String ACC_UPDATED_EMPLOYEES = "750";
	String ACC_CHANGEOWNER = "Anna Parker";
	String ACC_CHANGEREASON = "Owner is changed as part of automation";
	String ACC_CLOSECOMMENTS = "Closed as part of automation";
	String ACC_WEBSITE = "www.automationaccount.com";
	String ACC_EMPLOYEES = "500";
	String ACC_TICKER = "Pega_Account";
	String ACC_REVENUE = "78945300.00";
	String ACC_DESCRIPTION = "This is the account created by automation script";
	String ACC_PLACEHOLDER = "Filter accounts";
	String ACC_TableHeader[] = { "Name", "Organization", "Industry", "Opportunities", "Total amount", "Target", "Owner",
			"Territory" };
	List<String> ACC_LISTHEADER = new ArrayList<String>(Arrays.asList(ACC_TableHeader));
	String ACC_SubTabs[] = { "Pulse", "Details", "Opportunities", "Contacts", "Leads", "Activities", "Attachments" };
	List<String> ACC_WO_SUBTABS = new ArrayList<String>(Arrays.asList(ACC_SubTabs));

	@When("^user clicks on CreateAccount button$")
	public void user_clicks_on_CreateAccount_button() {
		acc = accList.createAccount();

	}

	@Then("^user should navigate to Account creation page$")
	public void user_should_navigate_to_Account_creation_page() {
		String accHeader = acc.getAccountPageHeader();
		System.out.println(accHeader);
		Assert.assertEquals(accHeader, "New Business Account");
	}

	@When("^user enters all the mandatory data and saves the changes$")
	public void user_enters_all_the_mandatory_data_and_saves_the_changes() throws InterruptedException {
		acc.setAccountName(ACC_NAME);
		acc.setOrganization(ACC_ORG);
		acc.setWebSite(ACC_WEBSITE);
		acc.setPhoneNumber(ACC_PHONENUMBER);
		acc.setEmployees(ACC_EMPLOYEES);
//		acc.setTickerSymbol(ACC_TICKER);
		acc.setRevenue(ACC_REVENUE);
		acc.setDescription(ACC_DESCRIPTION);
		//acc.setOrganization(ACC_ORG);
		acc.setIndustry(ACC_INDUSTRY);
		acc.setAddress();	
		acc.clickCreate();

//		reviewAccount = createAccount.clickAccountCreate();
	}

	@Then("^Account should be created$")
	public void account_should_be_created() {
		
		pegaDriver.handleWaits().waitForNoThrobber();
		pegaDriver.handleWaits().waitForPageLoaded();
		actual_name = acc.getAccountName();
		String ExpaccName = ACC_NAME.toString();
		Assert.assertEquals(actual_name, ExpaccName);
		String actual_org = acc.getOrganization();
		actual_territory = acc.getTerritory();
		actual_owner = acc.getOwner();
		String actual_phoneNumber = acc.getPhoneNumber();
		String actual_industry = acc.getIndustry();
		String actual_employees = acc.getEmployees();
//		String actual_ticker = acc.getTicker();
		String actual_revenue = acc.getRevenue();
		actual_description = acc.getDescription();

		Assert.assertEquals(actual_org, ACC_ORG);
		Assert.assertEquals(actual_phoneNumber, ACC_PHONENUMBER);
		Assert.assertEquals(actual_industry, ACC_INDUSTRY);
		Assert.assertEquals(actual_employees, ACC_EMPLOYEES);
//		Assert.assertEquals(actual_ticker, ACC_TICKER);
		Assert.assertEquals(actual_revenue, ACC_REVENUE);
		Assert.assertEquals(actual_description, ACC_DESCRIPTION);

	}

	@When("^user opens the existing Account with \"([^\"]*)\"$")
	public void user_opens_the_existing_Account(String AccName) throws InterruptedException {

		acc = accList.navigateAccount(AccName);

	}

	@When("^clicks on edit button$")
	public void clickedit() {
		acc.clickEdit();
	}

	@Then("^user should able to edit all the fields in Account page$")
	public void user_should_able_to_edit_all_the_fields_in_Account_page() {

		Assert.assertTrue(acc.isNameEnabled());
		Assert.assertTrue(acc.isPhoneNumberEnabled());
		Assert.assertTrue(acc.isCityEnabled());

	}

	@When("^user edits the input fields and save the changes$")
	public void user_edits_the_input_fields_and_save_the_changes() {
		acc.setPhoneNumber(ACC_UPDATED_PHONENUMBER);
		acc.setIndustry(ACC_UPDATED_INDUSTRY);
		acc.setEmployees(ACC_UPDATED_EMPLOYEES);
		acc.clickSubmit();
	}

	@Then("^Account should be reflected with the changes made in the account page$")
	public void account_should_be_reflected_with_the_changes_made_in_the_account_page() {
		pegaDriver.handleWaits().waitForNoThrobber();
		String actual_phoneNumber = acc.getPhoneNumber();
		Assert.assertEquals(actual_phoneNumber, ACC_UPDATED_PHONENUMBER);
		String actual_industry = acc.getIndustry();
		Assert.assertEquals(actual_industry, ACC_UPDATED_INDUSTRY);
		String actual_employees = acc.getEmployees();
		Assert.assertEquals(actual_employees, ACC_UPDATED_EMPLOYEES);
	}
}