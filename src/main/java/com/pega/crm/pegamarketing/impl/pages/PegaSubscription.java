package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.Subscription;
import com.pega.framework.elmt.Frame;

public class PegaSubscription extends PegaLandingPage implements Subscription {

	public PegaSubscription(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public void unsubscribe() {
		Frame frame = pegaDriver.findFrame("MarketingMicrositeIfr");
		pegaDriver.handleWaits().sleep(10);
		frame.findElement(NOT_INTRESTED_RADIO_BUTTON).click();
		frame.findElement(UNSUBSCRIBE_BUTTON).click();
		pegaDriver.findFrame("MarketingMicrositeIfr");
	}

	@Override
	public void closeSubscription() {
		pegaDriver.close();
	}
}
