package com.pega.crm.pegamarketing;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.pages.LandingPage;
import com.pega.crm.pegamarketing.pages.ProspectLists;
import com.pega.crm.pegamarketing.pages.RecentReports;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.page.Portal;

public interface PMPortal extends Portal {

	By AUDIENCES_MENU = By.xpath(PMXPathUtil.getMenuItemXPath("Audiences"));
	By SEGMENTS_MENU = By.xpath(PMXPathUtil.getMenuItemXPath("Segments"));
	By CONTENT_MENU = By.xpath(PMXPathUtil.getMenuItemXPath("Content"));
	By PEGA_MARKETING_TITLE_TEXT = By.xpath("//div[text()='Marketing']");
	By DESIGNER_MENU_ITEM = By.xpath(PMXPathUtil.getMenuItemXPath("Designer"));
	By CONFIGURATION_MENU_XPATH = By.xpath("//*[contains(@class,'configuration') and @title='Configuration']");
	//By CAMPAIGNS_MENU = By.xpath(PMXPathUtil.getMenuItemXPath("Campaigns"));
	By CAMPAIGNS_MENU = By.xpath("//*[@title='Campaigns']");
	By REALTIME_ARTIFACTS = By.xpath(PMXPathUtil.getMenuItemXPath("Real-Time Artifacts"));
	By INTELLIGENCE_MENU = By.xpath(PMXPathUtil.getMenuItemXPath("Intelligence"));
	By STRATEGIES_MENU = By.xpath(PMXPathUtil.getMenuItemXPath("Strategies"));
	By PROSPECT_LISTS_SUBMENU = By.xpath(PMXPathUtil.getMenuItemXPath("Prospect Lists"));
	By HOME_ICON = By.xpath("//*[@class='menu-item-icon-imageclass nbam-pi nbam-pi-home'][@role='presentation']");
	By NEW_ICON = By.xpath("//span[@class='menu-item-icon-imageclass pi pi-plus']");
	By REPORTS_ICON = By.xpath("//*[contains(@class,'report') and @title='Reports']");
	By REPORT_BROWSER_SUBMENU = By.xpath(PMXPathUtil.getMenuItemXPath("Report Browser"));

	public enum LandingPageType {
		SEGMENTS("Segments"), TREATMENTS("Treatments"), STRATEGIES("Strategies"), OFFERS("Offers"), CAMPAIGNS(
				"Campaigns"), DESIGNER("Designer"), ELIGIBILITIES("Eligibilities"), REALTIMEARTIFACTS(
						"Real-Time Artifacts"), DATAFLOWS("Data Flows"), SUMMARIES("Summaries"), DATA_MANAGEMENT(
								"Data Management"), MICROSITES("Microsites"), PAIDMEDIAAUDIENCES(
										"Paid Media Audiences"), IMAGELIBRARY("Image Library"), ACTIONS("Actions");
		private String pageName;

		LandingPageType(String pageName) {
			this.pageName = pageName;
		}

		public String getLandingPageName() {
			return pageName;
		}
	}

	/**
	 * this method opens the given landing page from left nav
	 * 
	 * @param landingPage
	 *            landing page type to be opened. eg. Segments, Treatments
	 * @return landingPage
	 */
	LandingPage openLandingPage(LandingPageType landingPage);

	/**
	 * this is for expanding menuItem before clicking on the respective landing page
	 * 
	 * @param menuName
	 */
	void expandMenuItems(String menuName);

	/**
	 * This is for selecting Menu from Configuration from top right of the PM portal
	 * page
	 * 
	 * @param menuName
	 *            e.g. Segmentation,Analytics
	 */
	void selectConfigurationMenu(String menuName);

	/**
	 * This will select Prspect lists from Segmentation menu
	 * 
	 * @return Prospect Lists page
	 */
	ProspectLists selectProspectLists();

	/**
	 * This will select Report Browser from Reports Menu
	 * 
	 * @return Recent reports page
	 */
	RecentReports selectReportBrowser();

	/**
	 * This will select Reports menu from left panel
	 */
	void selectReports();

	/**
	 * closes the Welcome Dialog
	 */
	public void closeWelcomeDialog();

	void expandCampaigns();

}
