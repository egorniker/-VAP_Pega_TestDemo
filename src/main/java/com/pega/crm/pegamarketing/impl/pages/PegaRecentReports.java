package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.RecentReports;
import com.pega.crm.pegamarketing.pages.UnsubscribedCustomers;

public class PegaRecentReports extends PegaLandingPage implements RecentReports {

	public PegaRecentReports(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public UnsubscribedCustomers openUnsubsribedCustomersReport() {
		findElement(UNSUBSCRIBED_CUSTOMERS_LINK).click();
		findElement(LAST30DAYSREPORTLINK).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		UnsubscribedCustomers unsubscribedCustomers = new PegaUnsubscribedCustomers(frameId, testEnv);
		return unsubscribedCustomers;
	}

}
