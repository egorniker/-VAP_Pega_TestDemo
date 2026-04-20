package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.pega.crm.pegamarketing.pages.Offers;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Offersglue {

	@Then("^Offers landing Page should be displayed$")
	public void treatment_Landing_Page_should_be_displayed() {
		Offers offers = ObjectsBean.getOffers();
		Assert.assertTrue(offers.verifyElement(Offers.OFFERS_PAGE_HEADER), "Offers landing page is not opened..!!");
	}

	@When("^User creates offer$")
	public void user_creates_offer() {
		Offers offers = ObjectsBean.getOffers();
		Offer offer = offers.create();
		ObjectsBean.setOffer(offer);
	}

}
