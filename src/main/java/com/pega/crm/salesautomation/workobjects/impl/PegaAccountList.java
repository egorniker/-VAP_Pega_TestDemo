package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.framework.PegaWebElement;

public class PegaAccountList extends PegaWorkObject implements AccountList {
//	public PegaAccountList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaAccountList(TestEnvironment testEnv) {
		super(testEnv);
	}

	String CREATE_ACC_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create account");
	String BUSINESSTAB_XPATH = PegaUtil.getSegmentedButtonXPath("Business");
	String ACC_SEARCH_FIELD_ID = "FilterTermForAccount'";
	String ACC_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter accounts']";
	String ACC_FILTERBUTTON_XPATH = PegaUtil.getButtonXpath("Filter");
	String ACC_NAME_XPATH = "(//table[@id='gridLayoutTable']//tr[contains(@base_ref,'D_crmAccountsList_')]//span//a[1])[1]"; //"(//table[@id='gridLayoutTable']//tr[contains(@base_ref,'D_crmAccountsList_')]//a[1])[1]";
	StringBuffer ACC_NAME = new StringBuffer("Automation_Account");
	String NO_ACCOUNTS_XPATH = "//tr[@id='Grid_NoResults']";
	String ACC_ALL_BUTTON_XPATH = PegaUtil.getSegmentedButtonXPath("All");
	String ACC_INDIVIDUAL_BUTTON_XPATH = PegaUtil.getSegmentedButtonXPath("Individual");
	String ACC_EXPORT_BUTTON_XPATH = "//*[@data-test-id='20141201005938049326913']";
	String OPP_REFRESH_BUTTON_XPATH = "//*[@data-test-id='20141201005938049427324']";
	String ACC_TABLE_HEADER_XPATH = "//table[@id='bodyTbl_right']//th//div[@class='cellIn ']";

	public StringBuffer WOName;

	public Accounts createAccount() {
		findElement(By.xpath(CREATE_ACC_BTN_XPATH)).click();
//		Accounts acc = new PegaAccounts(getActiveFrameId(false), testEnv);
		Accounts acc = new PegaAccounts(testEnv);
		return acc;

	}

	public Accounts navigateAccount(StringBuffer acc_name) {
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(acc_name);
//		findElement(By.xpath(ACC_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(Keys.ENTER);
		pegaDriver.waitForDocStateReady(10);
		if (verifyElement(By.xpath(ACC_NAME_XPATH))) {
			pegaDriver.waitForDocStateReady(5);
			findElement(By.xpath(ACC_NAME_XPATH)).click();
			pegaDriver.waitForDocStateReady(5);
		} else {
			openFirstAccount();
		}
//		Accounts acc = new PegaAccounts(getActiveFrameId(false), testEnv);
		Accounts acc = new PegaAccounts(testEnv);
		return acc;
	}

	public Accounts navigateAccount(String acc_name){
        findElement(By.xpath("//button[text()='Refresh']")).click();
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(acc_name);
//		findElement(By.xpath(ACC_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(10000);
		}catch (Exception e){
			e.printStackTrace();
		}
		if (verifyElement(By.xpath(ACC_NAME_XPATH))) {
			findElement(By.xpath(ACC_NAME_XPATH)).click();
//			findElement(By.xpath(ACC_NAME_XPATH)).click();
		} else {
			openFirstAccount();
		}
//		Accounts acc = new PegaAccounts(getActiveFrameId(false), testEnv);
		Accounts acc = new PegaAccounts(testEnv);		
		return acc;
	}

	@Override
	public Accounts openFirstAccount() {
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(SELECT_ALL);
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(Keys.TAB);
		findElement(By.xpath(BUSINESSTAB_XPATH)).click();
		String name = findElement(By.xpath(ACC_NAME_XPATH)).getText();
		WOName = new StringBuffer(name);
		findElement(By.xpath(ACC_NAME_XPATH)).click();
//		Accounts acc = new PegaAccounts(getActiveFrameId(false), testEnv);
		Accounts acc = new PegaAccounts(testEnv);
		return acc;
	}

	@Override
	public Boolean isAccountListEmpty() {

		try {
			findElement(By.xpath(NO_ACCOUNTS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isCreateButtonDisplayed() {

		return findElement(By.xpath(CREATE_ACC_BTN_XPATH)).isVisible();

	}

	@Override
	public boolean isFilterTextBoxDisplayed() {

		return findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).isVisible();

	}

	@Override
	public String getFilterPlaceHolder() {

		return findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder");

	}

	@Override
	public boolean isFilterButtonDisplayed() {

		return findElement(By.xpath(ACC_FILTERBUTTON_XPATH)).isVisible();

	}

	@Override
	public boolean isAllButtonDisplayed() {
		return findElement(By.xpath(ACC_ALL_BUTTON_XPATH)).isVisible();

	}

	@Override
	public boolean isBusinessButtonDisplayed() {
		return findElement(By.xpath(BUSINESSTAB_XPATH)).isVisible();

	}

	@Override
	public boolean isIndividualButtonDisplayed() {
		return findElement(By.xpath(ACC_INDIVIDUAL_BUTTON_XPATH)).isVisible();

	}

	@Override
	public boolean isExportButtonDisplayed() {
		return findElement(By.xpath(ACC_EXPORT_BUTTON_XPATH)).isVisible();

	}

	@Override
	public boolean isRefreshButtonDisplayed() {

		return findElement(By.xpath(OPP_REFRESH_BUTTON_XPATH)).isVisible();
	}

	@Override
	public ArrayList<String> getTableHeaders() {

		ArrayList<String> s = new ArrayList<String>();

		List<WebElement> wb = findElements(By.xpath(ACC_TABLE_HEADER_XPATH));
		for (WebElement w : wb) {
			String s1 = w.getText();
			s.add(s1);
		}
		return s;
	}

}
