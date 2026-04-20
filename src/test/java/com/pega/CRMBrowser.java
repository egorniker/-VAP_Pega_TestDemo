package com.pega;

import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.PegaBrowser;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.impl.PegaExpressPortal;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Forecast;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.crm.salesautomation.workobjects.PartnersList;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;
import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;
//import webDriverStepDef.CSPortal;

@ScenarioScoped
public class CRMBrowser extends PegaBrowser {

	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: MyBrowser.java 189580 2018-04-27 10:38:53Z SachinVellanki $";

	TestEnvironment testEnv;
	private CSPortal csPortal;
	public SFAPortal sfaPortal;
	private PegaWebDriver pegaDriver;
	public OrganizationsList orgList;
	public HouseholdList hhList;
	public AccountList accList;
	public LeadsList leadList;
	public OpportunityList oppList;
	public TerritoriesList terrList;
	public OperatorList oprList;
	public PartnersList parList;
	public ContactList conList;
	public Forecast forecast;
	public ClosePlans closeplans;
	public ResearchInteraction researchInteraction;
	public Interactions interactions;
	// variable to check whether campaign exists or not
	public boolean campaignExists;

	public static String EDIT_XPATH = PegaUtil.getButtonXpath("Edit");
	public static String WO_FOLLOW_XPATH = PegaUtil.getButtonXpath("Follow");
	String CS_SOCIAL_OPERATORID_XPATH = "//span/a[contains(@data-click,'showMenu')]";

	private PegaExpressPortal pegaExpressPortal;
	private PMPortal pegaMarketingPortal;
	private DesignerStudio designerStudio;
	private Configuration configuration;

	@Inject
	public CRMBrowser(CRMTestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		configuration = testEnv.getConfiguration();
	}

	public PMPortal getPMPortal() {
		return pegaMarketingPortal;
	}

	public DesignerStudio getDesignerStudio() {
		return designerStudio;
	}

	public PegaExpressPortal getExpressPortal() {
		return pegaExpressPortal;
	}

	@Given("^A User logs in with Analyst credentials$")
	public void a_User_logs_in_with_Analyst_credentials() {
		open();
		super.login(configuration.getCredential("ANALYST_USER_ID"), configuration.getCredential("ANALYST_PASSWORD"));
		pegaMarketingPortal = getPortal(PMPortal.class);
	}

	@Given("^a user is on login page of CS Portal$")
	public void open() {
		super.open();
	}

	@When("^User logs in to CS portal as bouser$")
	public void user_logs_in_to_CS_portal_as_bouser() throws Throwable {
		super.login(configuration.getCredential("BO_USER_ID"), configuration.getCredential("BO_USER_PASSWORD"));
		csPortal = getPortal(CSPortal.class);
		pegaDriver = testEnv.getPegaDriver();
		// researchInteraction = csPortal.getTopNav().setResearchInteraction();
		// interactions = researchInteraction;

	}

	@When("^User logs in to CS portal as CSR$")
	public void user_logs_in_to_CS_portal_as_CSR() throws Throwable {
		super.login(configuration.getCredential("CACSR_USER_ID"), configuration.getCredential("CACSR_USER_PASSWORD"));
		csPortal = getPortal(CSPortal.class);
		pegaDriver = testEnv.getPegaDriver();
	}

	@When("^User logs in to CS portal as mikejones$")
	public void user_logs_in_to_CS_portal_as_mikejones() throws Throwable {
		super.login(configuration.getCredential("MIKE_USER_ID"), configuration.getCredential("MIKE_USER_PASSWORD"));
		csPortal = getPortal(CSPortal.class);
		pegaDriver = testEnv.getPegaDriver();
	}

	// SA Methods

	@Given("^User logs in to SA Application as salesmanager$")
	public void user_logs_in_to_SA_Application_as_salesmanager() throws Throwable {
		open();
		login(configuration.getCredential("SALESMANAGER_ID"), configuration.getCredential("SALESMANAGER_PASSWORD"));
	}

	@Given("^User logs in to SA Application as salesops$")
	public void user_logs_in_to_SA_Application_as_salesops() throws Throwable {
		open();
		login(configuration.getCredential("SALESOPS_ID"), configuration.getCredential("SALESOPS_PASSWORD"));

	}

	@Given("^User logs in to SA Application as salesrep$")
	public void user_logs_in_to_SA_Application_as_salesrep() throws Throwable {
		open();
		login(configuration.getCredential("SALESREP_ID"), configuration.getCredential("SALESREP_PASSWORD"));

	}

	@Given("^navigates to \"([^\"]*)\" List page$")
	public void navigates_to_page(String LeftNavItem) {
		sfaPortal = getPortal(SFAPortal.class);

		switch (LeftNavItem) {
		case "Organizations": {
			orgList = sfaPortal.getLeftNav().getOrganizationList();
			break;
		}
		case "Households": {
			hhList = sfaPortal.getLeftNav().getHouseholdList();
			break;
		}
		case "Accounts": {
			accList = sfaPortal.getLeftNav().getAccountList();
			break;
		}
		case "Contacts": {
			conList = sfaPortal.getLeftNav().getContactList();
			break;
		}
		case "Leads": {
			leadList = sfaPortal.getLeftNav().getLeadsList();
			break;
		}
		case "Opportunities": {

			String CAMPAIGN_LIST_XPATH = "//span[text()='Campaign']";

			if (pegaDriver.verifyElement(By.xpath(CAMPAIGN_LIST_XPATH)))
				campaignExists = true;
			oppList = sfaPortal.getLeftNav().getOpportunityList();
			break;
		}
		case "Territories": {
			terrList = sfaPortal.getLeftNav().getTerritoriesList();
			break;
		}
		case "Operators": {
			oprList = sfaPortal.getLeftNav().getOperatorsList();
			break;
		}
		case "Partners": {
			parList = sfaPortal.getLeftNav().getPartnersList();
			break;
		}
		case "Forecast": {
			forecast = sfaPortal.getLeftNav().getForecast();
			break;
		}
		case "Close plans": {
			closeplans = sfaPortal.getLeftNav().getClosePlans();
			break;
		}

		}
	}

	@Then("^Goto \"([^\"]*)\" tab$")
	public void goto_tab(String tabName) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String XPath = "//h3[text()='#count#']";
		String finalXPath = new String(XPath).replace("#count#", tabName);
		PegaWebElement tabElement = pegaDriver.findElement(By.xpath(finalXPath));
		tabElement.click();
	}

	@Then("^Operator logs of the social portal$")
	public void operator_logs_of_the_social_portal() throws Throwable {
		socialportallogout();
	}

	@When("^Operator logs of the portal$")
	public void csr_logout_of_the_portal() {
		logout();
	}

}
