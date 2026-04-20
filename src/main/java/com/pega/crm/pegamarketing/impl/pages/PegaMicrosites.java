package com.pega.crm.pegamarketing.impl.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pega.TestEnvironment;
import com.pega.TestEnvironmentImpl;
import com.pega.crm.pegamarketing.pages.Microsites;
import com.pega.crm.pegamarketing.pages.Subscription;

public class PegaMicrosites extends PegaLandingPage implements Microsites {

	private static final Logger LOGGER = LoggerFactory.getLogger(PegaMicrosites.class.getName());

	private String uRLPort;

	public PegaMicrosites(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public Subscription launchMicrositeURL(String micrositeURL) {
		TestEnvironment t1 = new TestEnvironmentImpl();
		pegaDriver = t1.getPegaDriver();
		uRLPort = t1.getConfiguration().getSUTConfig().getURL();
		uRLPort = uRLPort.replace("/prweb", "");
		micrositeURL = micrositeURL.replace("*****", uRLPort);
		LOGGER.debug("*** URL Is: " + micrositeURL);
		pegaDriver.get(micrositeURL);
		pegaDriver.handleWaits().waitTillTitleContains("Subscription");
		pegaDriver.waitForDocStateReady(4);
		return new PegaSubscription(micrositeURL, t1);
	}

}
