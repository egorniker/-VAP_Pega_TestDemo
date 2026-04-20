package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Partners;
import com.pega.crm.salesautomation.workobjects.PartnersList;

public class PegaPartnersList extends PegaWorkObject implements PartnersList {

//	public PegaPartnersList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}

	public PegaPartnersList(TestEnvironment testEnv) {
		super(testEnv);
	}

	String CREATE_PTR_BTN_XPATH = "//button[text()='Create partner']";
	String PTR_SEARCH_FIELD_ID = "FilterTermForOrganization";
	String PTR_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter partners']";
	String PTR_FILTERBUTTON_XPATH = "//button[text()='Filter']";
	String PTR_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//a";
	String OPR_FILTER_ID = "FilterTerm";
	String OPR_NAME_XPATH = "//tr[contains(@id, 'OperatorAccessList')]/td[@data-attribute-name='Name']//span";
	String NO_PARTNERS_XPATH = "//div[text ='No partners']";

	@Override
	public Partners createPartner() {
		findElement(By.xpath(CREATE_PTR_BTN_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Partners par = new PegaPartners(frameId, testEnv);
		Partners par = new PegaPartners(testEnv);
		return par;
	}

	@Override
	public Partners navigatePartner(String partnerName) {
		findElement(By.xpath(PTR_FILTER_PLACEHOLDER_XPATH)).sendKeys(partnerName);
		findElement(By.xpath(PTR_FILTERBUTTON_XPATH)).click();

		if (verifyElement(By.xpath(PTR_NAME_XPATH)))
			findElement(By.xpath(PTR_NAME_XPATH)).click();
		else
			openFirstPartner();
		String frameId = getActiveFrameId(false);
//		Partners ptr = new PegaPartners(frameId, testEnv);
		Partners ptr = new PegaPartners(testEnv);
		return ptr;
	}

	@Override
	public boolean searchOperator(String OperatorName) {

		findElement(By.id(OPR_FILTER_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(OPR_FILTER_ID)).sendKeys(OperatorName);
		findElement(By.xpath(PTR_FILTERBUTTON_XPATH)).click();

		String name = findElement(By.xpath(OPR_NAME_XPATH)).getText();
		if (name.equals(OperatorName)) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean isPartnerListEmpty() {

		if (verifyElement(By.xpath(NO_PARTNERS_XPATH)))
			return true;
		else
			return false;
	}

	@Override
	public Partners openFirstPartner() {

		findElement(By.xpath(PTR_FILTER_PLACEHOLDER_XPATH)).clear();
		findElement(By.xpath(PTR_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(PTR_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Partners ptr = new PegaPartners(frameId, testEnv);
		Partners ptr = new PegaPartners(testEnv);
		return ptr;
	}

}
