package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaProspectImport;
import com.pega.crm.pegamarketing.pages.ProspectLists;
import com.pega.crm.pegamarketing.rules.ProspectImport;

public class PegaProspectLists extends PegaLandingPage implements ProspectLists {

	public PegaProspectLists(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public ProspectImport createNewPrspectImport() {
		findElement(NEW_BUTTON_XPATH).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		ProspectImport prospectImport = new PegaProspectImport(frameId, testEnv);
		return prospectImport;
	}

}
