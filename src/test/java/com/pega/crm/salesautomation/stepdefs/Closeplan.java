package com.pega.crm.salesautomation.stepdefs;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Closeplan {

	String OPP_SOURCE = "Customer Referral";
	String OPP_SHORTNAME = "Auto_oppty";
	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;
	public ClosePlans closeplans;
	String CLOSEPLANS_COMMENTS = "Entering closeplans";

	public static String Subject = null;

	@Inject
	public Closeplan(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);

		this.closeplans = browser.closeplans;
	}

	@When("^user enters clicks on oppty in closeplan$")
	public void user_enters_clicks_on_oppty_in_closeplan() {
		closeplans.clickOppty();

	}

	@Then("^user able to enter the closeplan for that oppty and enters it$")
	public void user_able_to_enter_the_closeplan_for_that_oppty_and_enters_it() {
		closeplans.enterClosePlans(CLOSEPLANS_COMMENTS);

	}
}
