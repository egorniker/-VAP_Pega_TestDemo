package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaRuleInstance;
import com.pega.crm.pegamarketing.pages.RealTimeContainer;

public class PegaRealTimeContainer extends PegaRuleInstance implements RealTimeContainer {

	public PegaRealTimeContainer(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

}
