package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.ProspectImport;
import com.pega.util.XPathUtil;

public interface ProspectLists extends LandingPage {
	By NEW_BUTTON_XPATH = By.xpath(XPathUtil.getButtonPzhcBtnXPath("New"));

	/**
	 * It will open new prospect Import page
	 * 
	 * @return Prospect Import page
	 */
	ProspectImport createNewPrspectImport();
}
