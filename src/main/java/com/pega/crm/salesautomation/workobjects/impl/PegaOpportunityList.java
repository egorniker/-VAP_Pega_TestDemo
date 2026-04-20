package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.framework.PegaWebElement;

public class PegaOpportunityList extends PegaWorkObject implements OpportunityList {

//	public PegaOpportunityList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaOpportunityList(TestEnvironment testEnv) {
		super(testEnv);
	}

	String OPP_BUSINESS_LIST_XPATH = PegaUtil.getSegmentedButtonXPath("Business");
	String CREATE_OPP_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create opportunity");
	String OPP_SEARCH_FIELD_ID = "FilterTermForOpportunity";
	String OPP_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter Opportunities']";
	String OPP_FILTERBUTTON_XPATH = PegaUtil.getButtonXpath("Filter");
	String OPP_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[contains(@base_ref,'D_crmOpportunitiesList_')]//a[1] | //tr//a[contains(text(),'%s')]";
	String OPP_ALL_BUTTON_XPATH = PegaUtil.getSegmentedButtonXPath("All");
	String OPP_INDIVIDUAL_BUTTON_XPATH = PegaUtil.getSegmentedButtonXPath("Individual");
	String OPP_BUSINESS_BUTTON_XPATH = PegaUtil.getSegmentedButtonXPath("Business");
	String OPP_EXPORT_BUTTON_XPATH = "//i[contains(@class,'upload')]";
	String OPP_REFRESH_BUTTON_XPATH = "//i[contains(@class,'refresh')]";
	String OPP_TABLE_HEADER_XPATH = "//table[@id='bodyTbl_right']//th//div[@class='cellIn ']";
	String NO_OPPORTUNITIES_XPATH = "//tr[@id='Grid_NoResults']";
	String STAGE_VIEW_XPATH = PegaUtil.getSegmentedButtonXPath("Stage view");

	@Override
	public Opportunities createBusniessOpportunity() {

		findElement(By.xpath(CREATE_OPP_BTN_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Business"))).click();

		String frameId = getActiveFrameId(false);
//		Opportunities opp = new PegaOpportunity(frameId, testEnv);
		Opportunities opp = new PegaOpportunity(testEnv);
		return opp;
	}

	@Override
	public Opportunities createIndividualOpportunity() {
		findElement(By.xpath(CREATE_OPP_BTN_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Individual"))).click();

		String frameId = getActiveFrameId(false);
//		Opportunities opp = new PegaOpportunity(frameId, testEnv);
		Opportunities opp = new PegaOpportunity(testEnv);
		return opp;
	}

	@Override
	public Opportunities navigateOpportunity(String opportunityName) {

		findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).sendKeys(opportunityName);
//		findElement(By.xpath(OPP_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).sendKeys(Keys.ENTER);

//		findElement(By.xpath(OPP_NAME_XPATH)).doubleClick();
//		OPP_NAME_XPATH = "(//a[contains(text(),'"+opportunityName+"')])[1]//ancestor::td";
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(OPP_NAME_XPATH));
		findElement(By.xpath(OPP_NAME_XPATH)).click();
		
		findElement(By.xpath(String.format(OPP_NAME_XPATH,opportunityName))).click();
		pegaDriver.handleWaits().waitForNoThrobber();
		
		String frameId = getActiveFrameId(false);
//		Opportunities opp = new PegaOpportunity(frameId, testEnv);
		Opportunities opp = new PegaOpportunity(testEnv);
		return opp;
	}

	@Override
	public boolean isCreateOpportunityButtonDisplayed() {

		boolean b = findElement(By.xpath(CREATE_OPP_BTN_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterTextBoxDisplayed() {

		boolean b = findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterButtonDisplayed() {

		boolean b = findElement(By.xpath(OPP_FILTERBUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isAllOpptyButtonDisplayed() {

		boolean b = findElement(By.xpath(OPP_ALL_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isIndividualButtonDisplayed() {

		boolean b = findElement(By.xpath(OPP_INDIVIDUAL_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isBusinessButtonDisplayed() {

		boolean b = findElement(By.xpath(OPP_BUSINESS_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isExportButtonDisplayed() {

		boolean b = findElement(By.xpath(OPP_EXPORT_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isRefreshButtonDisplayed() {

		boolean b = findElement(By.xpath(OPP_REFRESH_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public String getFilterPlaceHolder() {

		String b = findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder");
		return b;
	}

	public ArrayList<String> getTableHeaders() {

		// System.out.println("In Table Headers");
		ArrayList<String> s = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(OPP_TABLE_HEADER_XPATH));
		// System.out.println(wb.size());
		for (WebElement w : wb) {
			String s1 = w.getText();
			System.out.println(s1);
			s.add(s1);
			// System.out.println(s.size());
		}
		return s;
	}

	@Override
	public Opportunities openFirstOpportunity() {

		findElement(By.xpath(OPP_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Opportunities opp = new PegaOpportunity(frameId, testEnv);
		Opportunities opp = new PegaOpportunity(testEnv);
		return opp;
	}

	@Override
	public boolean isOpportunityListEmpty() {

		try {
			findElement(By.xpath(NO_OPPORTUNITIES_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public void SwitchToBusinessTab() {
		findElement(By.xpath(OPP_BUSINESS_LIST_XPATH)).click();

	}

	@Override
	public void dragAndDropToPropasal(String OppId) {
		PegaWebElement source = findElement(By.xpath("//div[contains(@data-inskey,'PEGACRM-WORK-SFA-OPPORTUNITY')]"));
		PegaWebElement target = findElement(By.xpath("//div[@id='Analysis']"));
		source.dragAndDrop(target);
	}

	@Override
	public void searchOpportunity(String opptyName) {

		findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).sendKeys(opptyName);
		findElement(By.xpath(OPP_FILTERBUTTON_XPATH)).click();

	}

	@Override
	public void switchToStageView() {
		// switchTo().defaultContent();
		findElement(By.xpath(STAGE_VIEW_XPATH)).click();

	}

}
