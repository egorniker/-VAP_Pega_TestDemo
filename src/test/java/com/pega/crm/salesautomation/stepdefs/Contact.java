package com.pega.crm.salesautomation.stepdefs;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Contacts;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Contact {

	String OPP_SOURCE = "Customer Referral";
	String OPP_SHORTNAME = "Auto_oppty";
	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	ContactList contList;
	Contacts cont;
	Accounts acc;
	public AccountList accList, accountsList;
	private PegaWebDriver pegaDriver;

	@Inject
	public Contact(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);
		this.contList = browser.conList;
		this.accList = browser.accList;
		CONT_FULLNAME = new StringBuffer("");
		CONT_FULLNAME = CONT_FULLNAME.append(CONT_FIRSTNAME);
		CONT_FULLNAME = CONT_FULLNAME.append(" ").append(CONT_LASTNAME);
		CONT_WORKEMAIL = CONT_FULLNAME + "@" + CONT_COMPANY + ".com";
	}

	String contactName;
	Scenario s1;
	StringBuffer CONT_FIRSTNAME = new StringBuffer("Siddarath");
	StringBuffer CONT_LASTNAME = new StringBuffer("Roy");
	String CONT_ORG = "Nexus Energy";
	String CONT_UPDATEDLASTNAME = "Automation_LastName";
	String CONT_SALUTATION = "Mr.";
	String CONT_COMPANY = "Pega";
	String CONT_DEPARTMENT = "Financial Services";
	String CONT_INFLUENCE = "1-High";
	String CONT_UPDATED_INFLUENCE = "1-High";
	String CONT_UPDATED_MARITALSTATUS = "Married";
	String CONT_FAVORABILITY = "2-Passive";
	String CONT_WORKPHONE = "654897562";
	StringBuffer CONT_FULLNAME = null;
	String CONT_WORKEMAIL = null;
	String CONT_TERRIOTRY = "Global";
	String STREET = "Raheja IT Park";
	String CITY = "Hyderabad";
	String STATE = "Telangana";
	String HOMEPHONE = "040-56984026";
	String HOMEEMAIL = "HomeEmail@pega.com";
	String MOBILE = "9874662315";
	String FAX = "040-5698745";

	@When("^User clicks on Create ContactButton and enters all the madatory data$")
	public void user_clicks_on_Create_ContactButton_and_enters_all_the_madatory_data() {
		cont = browser.conList.createContact();
		cont.setSalutation(CONT_SALUTATION);
		cont.setFirstName(CONT_FIRSTNAME);
		cont.setLastName(CONT_LASTNAME);
		cont.setOrganization(CONT_ORG);

		
		cont.setDepartment(CONT_DEPARTMENT);
		cont.setInfluence(CONT_INFLUENCE);
		cont.setFavorability(CONT_FAVORABILITY);
		cont.setAddress();
	}

	@When("^clicks on Save button$")
	public void clicks_on_Save_button() throws Throwable {
		cont.clickCreate();
	}

	@Then("^Contact should be created$")
	public void contact_should_be_created() throws Throwable {
		contactName = cont.getLastName();
		String name = CONT_FULLNAME.toString();
		Assert.assertEquals(contactName, name);

	}

	@Then("^verify contact subtabs$")
	public void verify_contact_subtabs() throws Throwable {
		// Verify contact Sub tabs
		cont.getSubTabs();
	}

	@Then("^C2A relationship should be created$")
	public void C2A_relationship_should_be_created() throws Throwable {

		cont.clickOnRelationshipsTab();
		String C2A_Name = cont.getC2ARelationShipName();
		String fullname = CONT_FULLNAME.toString();
		Assert.assertEquals(C2A_Name, fullname);

	}

	@Then("^Primary Individual account should be created automatically$")
	public void Primary_Individual_account_should_be_created_automatically() throws Throwable {
		accList = browser.sfaPortal.getLeftNav().getAccountList();
		acc = accList.navigateAccount(CONT_FULLNAME.toString());
		String fullname = CONT_FULLNAME.toString();
		Assert.assertEquals(acc.getPrimaryContactName(), fullname);
	}
	@When("^user opens the created contact$")
	public void user_opens_the_created_contact() throws InterruptedException {
		
		cont = contList.navigateContact(CONT_FULLNAME.toString());

	}
}
