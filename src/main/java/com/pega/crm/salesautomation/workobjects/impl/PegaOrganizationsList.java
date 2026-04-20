package com.pega.crm.salesautomation.workobjects.impl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;

public class PegaOrganizationsList extends PegaWorkObject implements OrganizationsList {

	String ORGANIZATIONS_TAB = new String("//span[text()='Organizations']");

	String CREATE_ORG_BTN_XPATH = new String("//button[text()='Create organization']");
	String ORG_SEARCH_FIELD = "FilterTermForOrganization";
	String exportButton = "//span[text()='Export']";
	String refreshButton = "//span[text()='Refresh']";
	String clearfilterButton = "//button[text()='Clear filters']";
	String ORGLIST_MENU = "//*[@data-test-id='20180807070707023921318']";
	String ORGANIZATION_NAME_XPATH = "//table[@data-test-id='201801031011410135512-layout']//tr[@aria-rowindex='1']//a[1]";
	String NO_ORGANIZATIONS_XPATH = "//div[text='No organizations']";

//	public PegaOrganizationsList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}

	public PegaOrganizationsList(TestEnvironment testEnv) {
		super(testEnv);
	}
	@Override
	public void search() {

	}

	public void verifyOrgListpage() {

		Assert.assertTrue(verifyElement(By.xpath(CREATE_ORG_BTN_XPATH)));
		Assert.assertTrue(verifyElement(By.id(ORG_SEARCH_FIELD)));
		Assert.assertTrue(verifyElement(By.xpath(clearfilterButton)));

	}

	public Organizations navigateOrganiztion() {
		String frameId = getActiveFrameId(false);
//		Organizations org = new PegaOrganization(frameId, testEnv);
		Organizations org = new PegaOrganization(testEnv);
		return org;

	}

	@Override
	public OrganizationsList searchOrganization(String orgName) {

		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(orgName);
		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(Keys.ENTER);

		String frameId = getActiveFrameId(false);
//		OrganizationsList org = new PegaOrganizationsList(frameId, testEnv);
		OrganizationsList org = new PegaOrganizationsList(testEnv);
		return org;

	}

	@Override
	public Organizations openOrganization(String OrgName) {

		findElement(By.id(ORG_SEARCH_FIELD)).clear();
		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(OrgName);
		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(Keys.ENTER);

		if (verifyElement(By.xpath("//a[contains(text(),'" + OrgName + "')]"))) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			findElement(By.xpath("//a[contains(text(),'" + OrgName + "')]")).click();

		}

		else {
			findElement(By.id(ORG_SEARCH_FIELD)).clear();
			findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(Keys.ENTER);
			openFirstOrganization();
		}

		String frameId = getActiveFrameId(false);
//		Organizations org = new PegaOrganization(frameId, testEnv);
		Organizations org = new PegaOrganization(testEnv);

		return org;
	}

	public void verifyOrgNewHarness() {

	}

	@Override
	public Organizations createOrganization() {
		findElement(By.xpath(CREATE_ORG_BTN_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Organizations org = new PegaOrganization(frameId, testEnv);
		Organizations org = new PegaOrganization(testEnv);
		return org;
	}

	@Override
	public Organizations openFirstOrganization() {

		findElement(By.xpath(ORGANIZATION_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
		Organizations organization = new PegaOrganization(testEnv);
//		Organizations organization = new PegaOrganization(frameId, testEnv);
		return organization;

	}

	@Override
	public boolean isOrganizationListEmpty() {
		if (verifyElement(By.xpath(NO_ORGANIZATIONS_XPATH))) {
			return true;
		} else {
			return false;
		}
	}

}
