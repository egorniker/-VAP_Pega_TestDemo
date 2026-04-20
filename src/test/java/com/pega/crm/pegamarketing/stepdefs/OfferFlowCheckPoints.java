package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.pega.crm.pegamarketing.pages.Offers;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.Then;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class OfferFlowCheckPoints {

	@Then("^Issue/Group, Search, View, Create, Help fields should be available$")
	public void issue_Group_Search_View_Create_Help_fields_should_be_available() {
		Offers offers = ObjectsBean.getOffers();
		Assert.assertTrue(offers.verifyElement(Offers.ISSUE_GROUP_DIV), "Issue / Group field is not available..!!");
		Assert.assertTrue(offers.verifyElement(Offers.SEARCH_INPUT_BOX), "Search field is not available..!!");
		Assert.assertTrue(offers.verifyElement(Offers.VIEW_BUTTON), "View button is not available..!!");
		Assert.assertTrue(offers.verifyElement(Offers.CREATE_BUTTON), "Create button is not available..!!");
		Assert.assertTrue(offers.verifyElement(Offers.HELP_BUTTON), "Help button is not available..!!");
	}

	@Then("^Diagram, Details, Test Offer and History tabs should be available$")
	public void diagram_details_test_offer_and_History_tabs_should_be_available() {
		Offer offer = ObjectsBean.getOffer();
		Assert.assertTrue(offer.verifyElement(Offer.FLOW_TAB), "Flow tab is not available..!!");
		Assert.assertTrue(offer.verifyElement(Offer.DETAILS_TAB), "Details tab is not available..!!");
		Assert.assertTrue(offer.verifyElement(Offer.TESTOFFER_TAB), "Test Offer tab is not available..!!");
		Assert.assertTrue(offer.verifyElement(Offer.HISTORY_TAB), "History tab is not available..!!");
		Assert.assertTrue(offer.verifyElement(Offer.ELIGIBILITY_TAB), "Eligibility tab is not available..!!");
	}

	@Then("^the offer should be saved and checkout button should be visible$")
	public void the_offer_should_be_saved_and_checkout_button_should_be_visible() throws Throwable {
		Offer offer = ObjectsBean.getOffer();
		Assert.assertTrue(offer.verifyElement(RuleInstance.CHECKOUT_BUTTON), "Check out button not visible");
	}
}
