package com.pega.crm.customerservice.stepdefs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.interactions.impl.PegaNewInboundInteraction;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped

public class StartResearchInteraction {

	private ResearchInteraction researchInteraction;
	private Interactions interaction;
	private PegaNewInboundInteraction inboundInteraction;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	public String[] caseStatus = new String[10];

	@Inject
	public StartResearchInteraction(NewTopNav topNavFixture, CRMTestEnvironment testEnv) {
		researchInteraction = topNavFixture.getResearchInteraction();
		interaction = topNavFixture.getInteractions();
		pegaDriver = testEnv.getPegaDriver();

	}

	@Then("^verify the result displayed for the \"([^\"]*)\" filter$")
	public void verify_the_result_displayed_for_the_filter(String filter) {

		if (filter.equalsIgnoreCase("12345000")) {
			Assert.assertTrue("12345000 is not present",
					researchInteraction.verifyElement(By.xpath("//span/a[contains(text(),'1234500078963456')]")));

		}

		if (filter.equalsIgnoreCase("Acme Software")) {
			Assert.assertTrue("Acme Software is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Acme Software')]")));
			Assert.assertTrue("Industry is not present", researchInteraction
					.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'MEDIA')]")));
			Assert.assertTrue("Country is not present", researchInteraction
					.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'USA')]")));
			Assert.assertTrue("City is not present", researchInteraction
					.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'Boston')]")));
			Assert.assertTrue("State is not present", researchInteraction
					.verifyElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'MA')]")));
		}

		if (filter.equalsIgnoreCase("Rebecca")) {
			Assert.assertTrue("Rebecca is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Rebecca')]")));

		}

		if (filter.equalsIgnoreCase("Credit Card Fees & Charges")) {
			Assert.assertTrue("Credit Card Fees & Charges title is not present", researchInteraction
					.verifyElement(By.xpath("//span/a[contains(text(),'Credit card fees & charges')]")));

		}

		if (filter.equalsIgnoreCase("Understanding Foreign Transaction Fees")) {
			Assert.assertTrue("Understanding Foreign Transaction Fees title is not present", researchInteraction
					.verifyElement(By.xpath("//span/a[contains(text(),'Understanding Foreign Transaction Fees')]")));
			Assert.assertTrue("Authored title is not present",
					researchInteraction.verifyElement(By.xpath("//span[contains(text(),'Authored')]")));

		}
	}

	@Then("^Verify the left nav header and search results for biggs$")
	public void verify_the_left_nav_header_and_search_results_for_biggs() {
		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Search']")));
		Assert.assertTrue("Search button is not present",
				researchInteraction.verifyElement(By.xpath("//button[@title='Clear']")));

		// check for the results displayed

		Assert.assertTrue("Rebecca is not present",
				researchInteraction.verifyElement(By.xpath("//span[text()='Rebecca']")));
		// Assert.assertTrue("Jo Anne is not
		// present",researchInteraction.verifyElement(By.xpath("//span[text()='Jo
		// Anne']")));

		// Verify the search types displayed

		Assert.assertTrue("First name header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='First name']")));
		Assert.assertTrue("Last name header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Last name']")));
		// Assert.assertTrue("Organization header is not
		// present",researchInteraction.verifyElement(By.xpath("//label[text()='Organization']")));
		Assert.assertTrue("SSN header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='SSN']")));
		// Assert.assertTrue("Phone header is not
		// present",researchInteraction.verifyElement(By.xpath("//label[text()='Phone
		// number']")));
		Assert.assertTrue("Email header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='Email']")));
		Assert.assertTrue("City header is not present",
				researchInteraction.verifyElement(By.xpath("//label[text()='City']")));

	}

	@When("^Filter the result with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void filter_the_result_with_and(String searchBox, String searchString) {
		researchInteraction.filterwithValues(searchBox, searchString);

	}

	@When("^Select the result \"([^\"]*)\" displayed$")
	public void select_the_result_displayed(String result) {

		researchInteraction.searchDropDownresult(result);
	}

}
