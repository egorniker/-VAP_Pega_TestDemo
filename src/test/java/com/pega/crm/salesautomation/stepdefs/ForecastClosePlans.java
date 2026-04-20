package com.pega.crm.salesautomation.stepdefs;

import java.util.Iterator;
import java.util.List;

// General utilities
import org.openqa.selenium.WebElement;
import org.testng.Assert;

// Dependency Injection
import com.google.inject.Inject;
// Browser & Portal
import com.pega.CRMBrowser;
import com.pega.Configuration;
import com.pega.crm.customerservice.SFAPortal;
// Sales Automation Page Objects
import com.pega.crm.salesautomation.workobjects.ClosePlans;

// Cucumber step keywords
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ForecastClosePlans {

	// Environment
	private CRMBrowser browser;

	// Portals and Page Objects
	public SFAPortal salesPortal;
	public ClosePlans closeplans;
	private Configuration configuration;

	@Inject
	public ForecastClosePlans(CRMBrowser browser) {
		this.browser = browser;
		salesPortal = browser.getPortal(SFAPortal.class);
		this.closeplans = browser.closeplans;
	}

	@Given("^a sales rep is at the Close Plans page$")
	public void a_sales_rep_is_at_the_Close_Plans_page() throws Throwable {
		// Sales representative logs in
		browser.open();
		browser.login(configuration.getCredential("SALESREP_ID"), configuration.getCredential("SALESREP_PASSWORD"));

		// Navigate to Close Plans page
		closeplans = salesPortal.getLeftNav().getClosePlans();
	}

	@When("^the rep searches for \"([^\"]*)\" organization$")
	public void the_rep_searches_for_organization(String orgName) throws Throwable {
		closeplans.filterBy("Search By Organization");
		closeplans.searchForOrganization(orgName);
		closeplans.apply();
	}

	@Then("^opportunities related only to \"([^\"]*)\" are shown$")
	public void relevant_opportunities_are_shown(String expectedOrg) throws Throwable {
		List<WebElement> orgs = closeplans.getOrgsFromOpportunities();

		Iterator<WebElement> itr = orgs.iterator();
		while (itr.hasNext()) {
			Assert.assertTrue(itr.next().getText().contains(expectedOrg),
					String.format("Expected organization '%s' not found.", expectedOrg));
		}
	}
}
