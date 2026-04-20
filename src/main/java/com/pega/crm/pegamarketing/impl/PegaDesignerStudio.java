package com.pega.crm.pegamarketing.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.explorer.RecordsExplorer;
import com.pega.crm.pegamarketing.impl.explorer.PegaRecordsExplorer;
import com.pega.framework.elmt.Frame;

public class PegaDesignerStudio extends PegaPMPortal implements DesignerStudio {
	private RecordsExplorer recordsExplorer = null;

	public PegaDesignerStudio(TestEnvironment testEnv) {
		super(testEnv);
	}

	public PMPortal launchPegaMarketingPortal() {
		Frame frame = findFrame("Developer");
		pegaDriver.handleWaits().waitForElementVisibility(LAUNCH_PORTAL_LINK);
		pegaDriver.handleWaits().waitForElementClickable(LAUNCH_PORTAL_LINK);
		frame.findElement(LAUNCH_PORTAL_LINK).click(false);
		frame.findElement(PEGA_MARKETING_PORTAL).click();
		pegaDriver.handleWaits().sleep(5);
		testEnv.getBrowser().switchToWindow(2);
		pegaDriver.handleWaits().sleep(30);
		pegaDriver.handleWaits().waitTillTitleContains("Pega Marketing");
		return new PegaPMPortal(testEnv);
	}

	public void search(String searchtext) {

	}

	public void switchTab(Tabs tab) {
		Frame frame = findFrame("Developer");
		frame.findElement(By.xpath("//div[@role='tab']//*[contains(text(),'" + tab.getId() + "')]")).click();
	}

	public void switchToDeveloperFrame() {
		findFrame("Developer");
	}

	public RecordsExplorer getRecordsExplorer() {
		switchTab(Tabs.Records);
		String frameId = pegaDriver.getActiveFrameId(true);
		if (recordsExplorer == null) {
			recordsExplorer = new PegaRecordsExplorer(frameId, testEnv);
		}
		return recordsExplorer;
	}
}
