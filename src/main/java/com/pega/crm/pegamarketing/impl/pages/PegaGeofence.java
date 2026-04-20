package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaRuleInstance;
import com.pega.crm.pegamarketing.pages.Geofence;

public class PegaGeofence extends PegaRuleInstance implements Geofence {

	public PegaGeofence(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}
}
