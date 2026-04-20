package com.pega.crm.pegamarketing;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.pages.ContextDictionary;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.util.XPathUtil;

public interface ExpressPortal extends PMPortal {
	By DATATYPES_EXPLORER_BY = By.xpath(XPathUtil.getDataTestIDXpath("express-explorer-data"));
	By USERS_EXPLORER_BY = By.xpath(XPathUtil.getDataTestIDXpath("express-explorer-user"));
	By SETTINGS_EXPLORER_BY = By.xpath(XPathUtil.getDataTestIDXpath("express-explorer-settings"));
	By PEGA_MARKETING_PORTAL_CLOSE_ICON = By.xpath("//*[contains(@name,'pzHelpTilesModalTemplate')]");

	By SWITCH_TO_DESIGNER_STUDIO_MODE = By.xpath("//a[text()='Switch to Designer Studio mode']");
	By SWITCH_STUDIOS_ICON = By.xpath(PMXPathUtil.getDataTestIdXPath("switch-wks"));
	By DEV_STUDIO_LABEL = By.xpath(PMXPathUtil.getMenuItemXPath("Dev Studio"));
	String SETTINGS_SLIDER_MENU_ITEM_XPATH = "//*[@data-test-id='settings-slider-label' and contains(text(),'%s')]";

	/**
	 * this method is used to open Data types explorer
	 */

	void openDataTypesExplorer();

	/**
	 * this method opens Users explorer
	 */
	void openUsersExplorer();

	/**
	 * this method opens Settings explorer
	 */

	void openSettingsExplorer();

	/**
	 * This method navigates user from express portal to Designer studio
	 * 
	 * @return Designer Studio page
	 */
	DesignerStudio switchToDesignerStudioPortal();

	/**
	 * this method opens the ContextDictionary page
	 * 
	 * @return ContextDictionary page
	 */
	ContextDictionary openContextDictionary();

	/**
	 * switches to Dev studio from App studio
	 */
	void switchToDevStudio();

}
