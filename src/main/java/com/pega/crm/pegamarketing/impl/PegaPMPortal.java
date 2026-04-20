package com.pega.crm.pegamarketing.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.impl.pages.PegaCampaignsFrame;
import com.pega.crm.pegamarketing.impl.pages.PegaDataFlows;
import com.pega.crm.pegamarketing.impl.pages.PegaDataManagement;
import com.pega.crm.pegamarketing.impl.pages.PegaEligibilities;
import com.pega.crm.pegamarketing.impl.pages.PegaImageLibrary;
import com.pega.crm.pegamarketing.impl.pages.PegaLandingPage;
import com.pega.crm.pegamarketing.impl.pages.PegaMicrosites;
import com.pega.crm.pegamarketing.impl.pages.PegaOffers;
import com.pega.crm.pegamarketing.impl.pages.PegaPaidMediaAudiences;
import com.pega.crm.pegamarketing.impl.pages.PegaProspectLists;
import com.pega.crm.pegamarketing.impl.pages.PegaRealTimeArtifacts;
import com.pega.crm.pegamarketing.impl.pages.PegaRecentReports;
import com.pega.crm.pegamarketing.impl.pages.PegaSegments;
import com.pega.crm.pegamarketing.impl.pages.PegaStrategies;
import com.pega.crm.pegamarketing.impl.pages.PegaSummaries;
import com.pega.crm.pegamarketing.impl.pages.PegaTreatments;
import com.pega.crm.pegamarketing.impl.rules.PegaDesigner;
import com.pega.crm.pegamarketing.pages.LandingPage;
import com.pega.crm.pegamarketing.pages.ProspectLists;
import com.pega.crm.pegamarketing.pages.RealTimeArtifacts;
import com.pega.crm.pegamarketing.pages.RecentReports;
import com.pega.crm.pegamarketing.pages.Segments;
import com.pega.crm.pegamarketing.pages.Strategies;
import com.pega.crm.pegamarketing.rules.Designer;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.framework.PegaWebDriver;
import com.pega.page.PortalImpl;

public class PegaPMPortal extends PortalImpl implements PMPortal {

	protected PegaWebDriver pegaDriver = null;
	protected TestEnvironment testEnv = null;

	public PegaPMPortal(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}

	public void expandAudiences() {
		findElement(AUDIENCES_MENU).click();
	}

	public Segments openSegments() {
		findElement(SEGMENTS_MENU).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Segments segments = new PegaSegments(frameId, testEnv);
		return segments;
	}

	public void expandMenuItems(String menuName) {
//     	pegaDriver.waitForDocStateReady(10);
		try{
			Thread.sleep(10000);
		}catch (Exception e){
			e.printStackTrace();
		}
		pegaDriver.handleWaits().waitForElementVisibility(NEW_ICON);
     	findElement(NEW_ICON).mouseOver();
		findElement(By.xpath(PMXPathUtil.getMenuItemXPath(menuName))).click();
	}

	public Designer openDesigner() {
		findElement(DESIGNER_MENU_ITEM).click();
		String frameId1 = pegaDriver.getActiveFrameId(true);
		Designer designer = new PegaDesigner(frameId1, testEnv);
		return designer;
	}

	public void expandContent() {
		findElement(CONTENT_MENU).click();

	}

	public RealTimeArtifacts OpenRealTimeArtifacts() {

		findElement(REALTIME_ARTIFACTS).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		RealTimeArtifacts realTimeArtifacts = new PegaRealTimeArtifacts(frameId, testEnv);
		return realTimeArtifacts;

	}

	public Strategies openStrategies() {
		findElement(INTELLIGENCE_MENU).click();
		findElement(STRATEGIES_MENU).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Strategies strategies = new PegaStrategies(frameId, testEnv);
		return strategies;
	}
//old
	/*public LandingPage openLandingPage(LandingPageType landingPage) {
		pegaDriver.switchTo().defaultContent();
		findElement(NEW_ICON).mouseOver();
		//findElement(HOME_ICON).mouseOver();
		findElement(By.xpath(PMXPathUtil.getMenuItemXPath(landingPage.getLandingPageName()))).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		return CreateCorrectLandingPageObj(landingPage, frameId);
	}*/
	
//NEW CODE BELOW Changed for Actions
	public LandingPage openLandingPage(LandingPageType landingPage) {
		pegaDriver.switchTo().defaultContent();
		findElement(NEW_ICON).mouseOver();
		findElement(By.xpath(PMXPathUtil.getMenuItemXPath(landingPage.getLandingPageName()))).click();
		//pegaDriver.waitForDocStateReady(5);
		String frameId = pegaDriver.getActiveFrameId(true);

		//Segment segment = new PegaSegment(frameId, this.testEnv);
		//ObjectsBean.setSegment(segment);

		return CreateCorrectLandingPageObj(landingPage, frameId);
	}
	

	private LandingPage CreateCorrectLandingPageObj(LandingPageType landingPage, String activeFrameID) {
		LandingPage landingPageObj = null;
		switch (landingPage) {
		case SEGMENTS:
			landingPageObj = new PegaSegments(activeFrameID, testEnv);
			break;
		case ACTIONS:
			landingPageObj = new PegaOffers(activeFrameID, testEnv);
			break;
		case TREATMENTS:
			landingPageObj = new PegaTreatments(activeFrameID, testEnv);
			break;
		case STRATEGIES:
			landingPageObj = new PegaStrategies(activeFrameID, testEnv);
			break;
		case CAMPAIGNS:
			landingPageObj = new PegaCampaignsFrame(activeFrameID, testEnv);
			break;
		case DESIGNER:
			landingPageObj = new PegaDesigner(activeFrameID, testEnv);
			break;
		case ELIGIBILITIES:
			landingPageObj = new PegaEligibilities(activeFrameID, testEnv);
			break;
		case REALTIMEARTIFACTS:
			landingPageObj = new PegaRealTimeArtifacts(activeFrameID, testEnv);
			break;
		case DATAFLOWS:
			landingPageObj = new PegaDataFlows(activeFrameID, testEnv);
			break;
		case SUMMARIES:
			landingPageObj = new PegaSummaries(activeFrameID, testEnv);
			break;
		case DATA_MANAGEMENT:
			landingPageObj = new PegaDataManagement(activeFrameID, testEnv);
			break;
		case MICROSITES:
			landingPageObj = new PegaMicrosites(activeFrameID, testEnv);
			break;
		case PAIDMEDIAAUDIENCES:
			landingPageObj = new PegaPaidMediaAudiences(activeFrameID, testEnv);
			break;
		case IMAGELIBRARY:
			landingPageObj = new PegaImageLibrary(activeFrameID, testEnv);
			break;
		default:
			landingPageObj = new PegaLandingPage(activeFrameID, testEnv);
		}
		return landingPageObj;
	}

	public void selectConfigurationMenu(String menuName) {
		findElement(CONFIGURATION_MENU_XPATH).click(false);
		findElement(By.xpath("//span[@class='menu-item-title' and text()='" + menuName + "']")).mouseOver();
	}

	public ProspectLists selectProspectLists() {
		findElement(PROSPECT_LISTS_SUBMENU).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		ProspectLists prospectLists = new PegaProspectLists(frameId, testEnv);
		return prospectLists;
	}

	public RecentReports selectReportBrowser() {
		findElement(REPORT_BROWSER_SUBMENU).click();
		String frameId1 = pegaDriver.getActiveFrameId(true);
		RecentReports recentReports = new PegaRecentReports(frameId1, testEnv);
		return recentReports;
	}

	public void selectReports() {
		findElement(REPORTS_ICON).click(false);

	}

	public void closeWelcomeDialog() {
		findElement(ModalDialog.CLOSE_BUTTON).click();
	}
	@Override
	public void expandCampaigns() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(CAMPAIGNS_MENU).click();
	}
}
