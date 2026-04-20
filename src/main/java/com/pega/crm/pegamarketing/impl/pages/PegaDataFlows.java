package com.pega.crm.pegamarketing.impl.pages;

import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.DataFlows;

public class PegaDataFlows extends PegaLandingPage implements DataFlows {

	public PegaDataFlows(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public void checkIncludeSysDataFlows() {
		findElement(INCLUDE_DATA_FLOWS_CHECKBOX).check();
	}

	@Override
	public void clickView() {
		findElement(VIEW_BUTTON).click();
	}

	@Override
	public void searchDataFlows(String dataFlow) {
		findElement(SEARCH_TEXTBOX).sendKeys(dataFlow + Keys.ENTER);
		pegaDriver.waitForDocStateReady(4);
	}

}
