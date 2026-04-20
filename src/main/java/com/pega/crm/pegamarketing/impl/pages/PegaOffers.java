package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaOffer;
import com.pega.crm.pegamarketing.pages.Offers;
import com.pega.crm.pegamarketing.rules.Offer;

public class PegaOffers extends PegaLandingPage implements Offers {

	public PegaOffers(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public Offer create() {
		findElement(CREATE_BUTTON).click();
		pegaDriver.handleWaits().sleep(5);
      	findElement(CREATE_OFFER).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Offer offer = new PegaOffer(frameId, testEnv);
		return offer;
	}
}
