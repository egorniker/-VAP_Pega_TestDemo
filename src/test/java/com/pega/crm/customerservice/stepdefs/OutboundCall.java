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
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.tiles.impl.PegaTopNav;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped

public class OutboundCall {

	private PhoneCall phoneInteraction;
	private OutboundPhoneCall outboundPhoneCall;
	private Interactions interaction;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	public String caseID = null;
	private PegaTopNav topNav;
	public String intID = null;

	@Inject
	public OutboundCall(NewTopNav topNavFixture, CRMTestEnvironment testEnv) {
		outboundPhoneCall = topNavFixture.getOutboundPhoneCall();
		interaction = topNavFixture.getInteractions();
		pegaDriver = testEnv.getPegaDriver();
	}

	@Then("^Verify fields on search screen$")
	public void verify_fields_on_search_screen() {

		Assert.assertTrue("Unknown customer field is not present",
				interaction.verifyElement(By.xpath(PhoneCall.UNKNOWN_CUSTOMER_XPATH)));
		Assert.assertTrue("Contact information field is not present",
				interaction.verifyElement(By.xpath(PhoneCall.CONTACT_INFO_XPATH)));

		Assert.assertTrue("Relationship field is not present",
				interaction.verifyElement(By.xpath(PhoneCall.RELATIONSHIP_XPATH)));

		Assert.assertTrue("Add task button is not present",
				interaction.verifyElement(By.xpath(PhoneCall.ADDTASK_XPATH)));
		Assert.assertTrue("Wrap Up button is not present",
				interaction.verifyElement(By.xpath(PhoneCall.WRAP_UP_XPATH)));

		Assert.assertTrue("Search text is not present", interaction.verifyElement(By.xpath(PhoneCall.SEARCH_XPATH)));
		Assert.assertTrue("General assistance text is not present",
				interaction.verifyElement(By.xpath(PhoneCall.GENERAL_ASSISTANCE_XPATH)));
	}

	@Then("^Select reason \"([^\"]*)\" and Outbound call status \"([^\"]*)\" and Submit$")
	public void select_reason_and_Outbound_call_status_and_Submit(String reason, String status) {

		interaction.CaptureCallReasonAndPlaceCall(reason, status);

	}

	@Then("^Enter comments for Exit Interaction \"([^\"]*)\" and Submit$")
	public void enter_comments_for_Exit_Interaction_and_Submit(String exitComments) {

		outboundPhoneCall.exitInteraction(exitComments);

	}

	@When("^launch wrapup to complete outbound interaction$")
	public void launch_wrapup_to_complete_outbound_interaction() {

		outboundPhoneCall.launchOutboundWrapUp();

	}

	@Then("^select transaction \"([^\"]*)\" for dispute$")
	public void select_transaction_for_dispute(String transID) {
		interaction.selectDisputeTransaction(transID);
	}

	@When("^Select dispute reason \"([^\"]*)\" and submit$")
	public void select_dispute_reason_and_submit(String reason) {

		interaction.selectReasonForDispute(reason);
	}
	@When("^Select phone call search by \"([^\"]*)\"$")
	public void select_phone_call_search_by(String arg1) throws Throwable {
		interaction.selectSearchByinPhoneCallSearch(arg1);
	 
	}

	@When("^Search for the Customer with account number \"([^\"]*)\" and phone number \"([^\"]*)\"$")
	public void search_for_the_Customer_with_account_number_and_phone_number(String accnum, String phonum) throws Throwable {
		interaction.searchCustomerByAccNumPhoNum(accnum,phonum);
	}

	@When("^select result from the new phone call search result and proceed$")
	public void select_result_from_the_new_phone_call_search_result_and_proceed() throws Throwable {
		interaction.selectFirstCustomerInPhoneCallSearch();
	}
}