package com.pega.crm.customerservice.tiles.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.tiles.LeftNav;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Forecast;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.crm.salesautomation.workobjects.PartnersList;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;
import com.pega.crm.salesautomation.workobjects.impl.PegaAccountList;
import com.pega.crm.salesautomation.workobjects.impl.PegaClosePlans;
import com.pega.crm.salesautomation.workobjects.impl.PegaContactList;
import com.pega.crm.salesautomation.workobjects.impl.PegaForecast;
import com.pega.crm.salesautomation.workobjects.impl.PegaHouseholdList;
import com.pega.crm.salesautomation.workobjects.impl.PegaLeadsList;
import com.pega.crm.salesautomation.workobjects.impl.PegaOperatorList;
import com.pega.crm.salesautomation.workobjects.impl.PegaOpportunityList;
import com.pega.crm.salesautomation.workobjects.impl.PegaOrganizationsList;
import com.pega.crm.salesautomation.workobjects.impl.PegaPartnersList;
import com.pega.crm.salesautomation.workobjects.impl.PegaTerritoriesList;
import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;
import com.pega.page.TopDocumentImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PegaLeftNav extends TopDocumentImpl implements LeftNav {

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: PegaLeftNav.java 117333 2018-10-01 09:12:21Z $";

	String ORG_LIST_XPATH = "//span[text()='Organizations']//ancestor::a";
	String OPR_DASHBOARD = "//span[text()='Dashboard']";
	String OPR_LIST_XPATH = "//span[text()='Operators']//ancestor::a";
	String CONT_LIST_XPATH = "//span[text()='Contacts']//ancestor::a";
	String ACC_LIST_XPATH = "//span[text()='Accounts']//ancestor::a";
	String OPP_LIST_XPATH = "//span[text()='Opportunities']//ancestor::a";
	String LISTVIEW_XPATH ="//select[contains(@class, 'transparent') and  contains(@data-test-id,'20190908150221009398164727-9af9-4090-ba1f-f642cf3a6b90289')]/option[2]";
	String STAGEVIEW_XPATH="//select[contains(@class, 'transparent') and  contains(@data-test-id,'20190908150221009398164727-9af9-4090-ba1f-f642cf3a6b90289')]";
//	String LISTVIEW_XPATH = PegaUtil.getStrongButtonXPath("List view");
	
	String PART_LIST_XPATH = "//span[text()='Partners']//ancestor::a";
	String HHD_LIST_XPATH = "//span[text()='Households']//ancestor::a";
	String LEAD_LIST_XPATH = "//span[text()='Leads']//ancestor::a";
	String APP_LIST_XPATH = "//span[text()='Appointments']";
	String TERR_LIST_XPATH = "//span[text()='Territories']//ancestor::a";
	String RECENTS_LATEST_XPATH = "//div[@node_name='RecentItem'][@index='1']//a";
	String OPP_ALL_BUTTON_XPATH = PegaUtil.getSegmentedButtonXPath("All");
	String TOOLS_LIST_XPATH = "//span[text()='Tools']";
	String QUICK_CREATE_XPATH = "//a[contains(@name,'SFAPortalLeftPanel')]";
	String PULSE_LIST_XPATH = "//span[text()='Pulse']";
	String EGMAP_LIST_XPATH = "//span[text()='Engagement Map']";
	String FORECAST_LIST_XPATH = "//span[text()='Forecast']//ancestor::a";
	String CLOSEPLANS_LIST_XPATH = "//div[@aria-label='Close plans']";

	public PegaLeftNav(TestEnvironment testEnv) {
		super(testEnv);

	}

	@Override
	public OperatorList getOperatorsList() {
		
		pegaDriver.findElement(By.xpath(OPR_LIST_XPATH)).scrollIntoView();
		findElement(By.xpath(OPR_LIST_XPATH)).isVisible();
		WebDriverWait wait = new WebDriverWait(pegaDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPR_LIST_XPATH))).click();
//		findElement(By.xpath(OPR_LIST_XPATH)).click();
        
		String frameId = getActiveFrameId(false);
//		OperatorList oprList = new PegaOperatorList(frameId, testEnv);
		OperatorList oprList = new PegaOperatorList(testEnv);
		return oprList;
	}

	@Override
	public OrganizationsList getOrganizationList() {
		pegaDriver.findElement(By.xpath(ORG_LIST_XPATH)).scrollIntoView();
		findElement(By.xpath(ORG_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		OrganizationsList list = new PegaOrganizationsList(frameId, testEnv);
		OrganizationsList list = new PegaOrganizationsList(testEnv);
		return list;
	}

	public ContactList getContactList() {
		pegaDriver.findElement(By.xpath(CONT_LIST_XPATH)).scrollIntoView();
		findElement(By.xpath(CONT_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		ContactList contList = new PegaContactList(frameId, testEnv);
		ContactList contList = new PegaContactList(testEnv);
		return contList;
	}

	@Override
	public AccountList getAccountList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ACC_LIST_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(ACC_LIST_XPATH)).isVisible();
		pegaDriver.findElement(By.xpath(ACC_LIST_XPATH)).click();
//		pegaDriver.findElement(By.xpath("//button[@name='pyTableToolbar_GridMetadata_1615366251693_12']//i")).click();
		
//		findElement(By.xpath(ACC_LIST_XPATH)).click();
		
//		String frameId = pegaDriver.getActiveFrameId(false);
//		System.out.println("FrameID" + frameId);
		AccountList accList = new PegaAccountList(testEnv);
		return accList;
	}

	@SuppressWarnings("finally")
	@Override
	public OpportunityList getOpportunityList() {
		pegaDriver.findElement(By.xpath(OPP_LIST_XPATH)).scrollIntoView();
		try {
			findElement(By.xpath(OPP_LIST_XPATH)).click();
		}catch (Exception e){
			findElement(By.xpath(OPP_LIST_XPATH)).click();
		}
		String frameId = getActiveFrameId(false);
//		OpportunityList oppList = new PegaOpportunityList(frameId, testEnv);
		OpportunityList oppList = new PegaOpportunityList(testEnv);
		try {

			oppList.findElement(By.xpath(STAGEVIEW_XPATH)).click();
			oppList.findElement(By.xpath(LISTVIEW_XPATH)).click();

//			oppList.findElement(By.xpath(OPP_ALL_BUTTON_XPATH)).click();
		} catch (Exception e) {
			System.out.println("Oppty page has only list view");
		}
		return oppList;

	}

	@Override
	public PartnersList getPartnersList() {

		pegaDriver.findElement(By.xpath(PART_LIST_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(PART_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		PartnersList ptrList = new PegaPartnersList(frameId, testEnv);
		PartnersList ptrList = new PegaPartnersList(testEnv);
		return ptrList;
	}

	public HouseholdList getHouseholdList() {
		pegaDriver.findElement(By.xpath(HHD_LIST_XPATH)).scrollIntoView();
		findElement(By.xpath(HHD_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		HouseholdList hhList = new PegaHouseholdList(frameId, testEnv);
		HouseholdList hhList = new PegaHouseholdList(testEnv);
		return hhList;
	}

	@Override
	public LeadsList getLeadsList() {
		pegaDriver.findElement(By.xpath(LEAD_LIST_XPATH)).scrollIntoView();
		findElement(By.xpath(LEAD_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		LeadsList leadList = new PegaLeadsList(frameId, testEnv);
		LeadsList leadList = new PegaLeadsList(testEnv);
		return leadList;
	}

	@Override
	public String getLatestRecent() {
		return findElement(By.xpath(RECENTS_LATEST_XPATH)).getText();
	}

	@Override
	public TerritoriesList getTerritoriesList() {
		pegaDriver.findElement(By.xpath(TERR_LIST_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(TERR_LIST_XPATH)).isVisible();
		pegaDriver.findElement(By.xpath(TERR_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		TerritoriesList terrList = new PegaTerritoriesList(frameId, testEnv);
		TerritoriesList terrList = new PegaTerritoriesList(testEnv);
		return terrList;
	}

	@Override
	public Forecast getForecast() {
		findElement(By.xpath(FORECAST_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Forecast forecast = new PegaForecast(frameId, testEnv);
		Forecast forecast = new PegaForecast(testEnv);
		return forecast;
	}

	@Override
	public ClosePlans getClosePlans() {
		findElement(By.xpath(FORECAST_LIST_XPATH)).scrollIntoView();
		findElement(By.xpath(FORECAST_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		ClosePlans closeplans = new PegaClosePlans(frameId, testEnv);
		ClosePlans closeplans = new PegaClosePlans(testEnv);
		waitHandler.waitForElementClickable(By.xpath("//label[text()='Individual']"));
		findElement(By.xpath("//label[text()='Individual']")).click();
		waitHandler.waitForElementClickable(By.xpath("//label[text()='Business']"));
		findElement(By.xpath("//label[text()='Business']")).click();
		waitHandler.waitForElementClickable(By.xpath("//label[text()='All']"));
		//findElement(By.xpath("//label[text()='All']")).click();
		
//		pegaDriver.findElement(By.cssSelector("button[title='Click to refresh forecast']")).click();
		closeplans.findElement(By.xpath(CLOSEPLANS_LIST_XPATH)).click();
		pegaDriver.waitForDocStateReady();
		
		
		return closeplans;

	}

}
