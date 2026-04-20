package com.pega.crm.pegamarketing.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.ExpressPortal;
import com.pega.crm.pegamarketing.impl.pages.PegaChannels;
import com.pega.crm.pegamarketing.impl.pages.PegaContextDictionaryFrame;
import com.pega.crm.pegamarketing.pages.Channels;
import com.pega.crm.pegamarketing.pages.ContextDictionary;
import com.pega.framework.PegaWebDriver;

public class PegaExpressPortal extends PegaPMPortal implements ExpressPortal {
	private PegaWebDriver pegaDriver = null;
	private TestEnvironment testEnv;

	public PegaExpressPortal(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}

	public void openDataTypesExplorer() {
		findElement(DATATYPES_EXPLORER_BY).click();

	}

	public void openUsersExplorer() {
		findElement(USERS_EXPLORER_BY).click();

	}

	public void openSettingsExplorer() {
		findElement(SETTINGS_EXPLORER_BY).click();

	}

	public DesignerStudio switchToDesignerStudio() {
		findElement(SWITCH_TO_DESIGNER_STUDIO_MODE).click();
		pegaDriver.waitForDocStateReady(3);
		DesignerStudio designerStudio = new PegaDesignerStudio(testEnv);
		return designerStudio;
	}

	public void switchToDevStudio() {
		findElement(SWITCH_STUDIOS_ICON).click();
		findElement(DEV_STUDIO_LABEL).click();
	}

	public ContextDictionary openContextDictionary() {
		findElement(By.xpath(String.format(SETTINGS_SLIDER_MENU_ITEM_XPATH, "Context Dictionary"))).click();
		String activeFrameID = pegaDriver.getActiveFrameId(false);
		ContextDictionary contextDictionaryFrame = new PegaContextDictionaryFrame(activeFrameID, testEnv);
		return contextDictionaryFrame;

	}

	public Channels openChannels() {
		findElement(By.xpath(String.format(SETTINGS_SLIDER_MENU_ITEM_XPATH, "Channels"))).click();
		String activeFrameID = pegaDriver.getActiveFrameId(true);
		Channels channels = new PegaChannels(activeFrameID, testEnv);
		return channels;
	}

	public DesignerStudio switchToDesignerStudioPortal() {
		return null;
	}

}
