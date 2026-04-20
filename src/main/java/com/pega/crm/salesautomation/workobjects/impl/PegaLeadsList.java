package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.LeadsList;

public class PegaLeadsList extends PegaWorkObject implements LeadsList {

//	public PegaLeadsList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaLeadsList(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public Leads createBusinessLead() {
		findElement(By.xpath(CREATE_LEAD_BTN_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Business"))).click();
		String frameId = getActiveFrameId(false);
//		Leads lead = new PegaLeads(frameId, testEnv);
		Leads lead = new PegaLeads(testEnv);
		return lead;
	}

	@Override
	public Leads createIndividualLead() {
		findElement(By.xpath(CREATE_LEAD_BTN_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Individual"))).click();
		String frameId = getActiveFrameId(false);
//		Leads lead = new PegaLeads(frameId, testEnv);
		Leads lead = new PegaLeads(testEnv);
		return lead;
	}

	@Override
	public Leads navigateLead(String LeadName) {
		findElement(By.xpath("//button[text()='Refresh']")).click();
		findElement(LEAD_FILTER_PLACEHOLDER_XPATH).sendKeys(LeadName);
//		findElement(LEAD_FILTERBUTTON_XPATH).click();
		findElement(LEAD_FILTER_PLACEHOLDER_XPATH).sendKeys(Keys.ENTER);
		try{
			Thread.sleep(10000);
		}catch (Exception e){
			e.printStackTrace();
		}
        pegaDriver.waitForDocStateReady(10);
		findElement(By.xpath("//*[@data-test-id='201412160519150793380419' and contains(text(),'" + LeadName + "')]")).click();
//		findElement(By.xpath("//*[@data-test-id='201412160519150793380419' and contains(text(),'" + LeadName + "')]")).click();
//		String frameId = getActiveFrameId(false);
//		Leads lead = new PegaLeads(frameId, testEnv);
		Leads lead = new PegaLeads(testEnv);
		return lead;
	}

	@Override
	public boolean isleadsListEmpty() {

		try {
			findElement(By.xpath(NO_LEADS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public Leads openFirstLead() {

		findElement(By.xpath(LEAD_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Leads lead = new PegaLeads(frameId, testEnv);
		Leads lead = new PegaLeads(testEnv);
		return lead;
	}

	@Override
	public String getSectionHeader() {
		return (getSectionHeader().trim());
	}

	@Override
	public boolean isCreateLeadButtonDisplayed() {

		boolean b = findElement(By.xpath(CREATE_LEAD_BTN_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterTextBoxDisplayed() {

		boolean b = findElement(LEAD_FILTER_PLACEHOLDER_XPATH).isVisible();
		return b;
	}

	@Override
	public String getFilterPlaceHolder() {

		String b = findElement(LEAD_FILTER_PLACEHOLDER_XPATH).getAttribute("placeholder");
		return b;
	}

	@Override
	public boolean isFilterButtonDisplayed() {

		boolean b = findElement(LEAD_FILTERBUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public boolean isAllLeadButtonDisplayed() {
		boolean b = findElement(LEAD_ALL_BUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public boolean isBusinessButtonDisplayed() {
		boolean b = findElement(LEAD_BUSINESS_BUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public boolean isIndividualButtonDisplayed() {
		boolean b = findElement(LEAD_INDIVIDUAL_BUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public boolean isExportButtonDisplayed() {
		boolean b = findElement(LEAD_EXPORT_BUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public boolean isRefreshButtonDisplayed() {
		boolean b = findElement(LEAD_REFRESH_BUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public ArrayList<String> getTableHeaders() {

		ArrayList<String> s = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(LEAD_TABLE_HEADER_XPATH));
		for (WebElement w : wb) {
			String s1 = w.getText();
			System.out.println(s1);
			s.add(s1);
		}
		return s;
	}

}
