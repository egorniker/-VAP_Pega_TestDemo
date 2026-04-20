package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.Operators;

public class PegaOperatorList extends PegaWorkObject implements OperatorList {

	String OPERATORS_TAB = new String("//span[text()='Operators']");

	String OPR_FILTER_PLACEHOLDER = "//input[@placeholder='Filter operators']";

	String CREATE_OPR_BTN_XPATH = "//button[@class='Strong pzhc pzbutton' and text()='Create operator']";
	String OPR_SEARCH_FIELD = "FilterTerm";

	String refreshButton = "//button[@class='pzhc pzbutton' and text()='Refresh']";
	String filterButton = "//button[@class='pzhc pzbutton' and text()='Filter']";

	By OPR_NAMECOLUMN = By.xpath("//*[@data-test-id='201804100347110194172-th-0']//div[contains(text(),'Name')]");
	By OPR_TYPECOLUMN = By
			.xpath("//*[@data-test-id='201804100347110194172-th-1']//div[contains(text(),'Operator type')]");
	By OPR_PRIMARYTERRITORYCOLUMN = By
			.xpath("//*[@data-test-id='201804100347110194172-th-2']//div[contains(text(),'Primary territory')]");
	By OPR_REPORTSTOCOLUMN = By
			.xpath("//*[@data-test-id='201804100347110194172-th-3']//div[contains(text(),'Reports to')]");
	By OPR_ISACTIVECOLUMN = By
			.xpath("//*[@data-test-id='201804100347110194172-th-4']//div[contains(text(),'Is active')]");
	By OPR_JOBTITLECOLUMN = By
			.xpath("//*[@data-test-id='201804100347110194172-th-5']//div[contains(text(),'Job title')]");
	String NO_OPERATORS_XPATH = "//div[text()='No operators']";
	String OPERATOR_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//td[@data-attribute-name='Name']//span";

//	public PegaOperatorList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaOperatorList(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public Operators creasteOperator() {

		findElement(By.xpath(CREATE_OPR_BTN_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Operators org = new PegaOperator(frameId, testEnv);
		Operators org = new PegaOperator(testEnv);
		return org;
	}

	@Override
	public OperatorList searchOperator(String oprName) {

		findElement(By.id(OPR_SEARCH_FIELD)).sendKeys(oprName);
		findElement(By.id(OPR_SEARCH_FIELD)).sendKeys(Keys.ENTER);
		String frameId = getActiveFrameId(false);
//		OperatorList oprList = new PegaOperatorList(frameId, testEnv);
		OperatorList oprList = new PegaOperatorList(testEnv);
		return oprList;
	}

	@Override
	public Operators navigateOperator() {

		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		
		return Opr;
	}

	@Override
	public boolean isOperatorListEmpty() {

		try {
			findElement(By.xpath(NO_OPERATORS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public Operators openFirstOperator() {

		findElement(By.xpath(OPERATOR_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Operators operator = new PegaOperator(frameId, testEnv);
		Operators operator = new PegaOperator(testEnv);
		return operator;
	}

	@Override
	public boolean verifyOperatorListPage() {

		// Assert.assertTrue(verifyElement(By.xpath(CREATE_OPR_BTN_XPATH)));
		// Assert.assertTrue(verifyElement(By.id(OPR_SEARCH_FIELD)));

		// Assert.assertTrue(verifyElement(By.xpath(refreshButton)));
		// Assert.assertTrue(verifyElement(By.xpath(filterButton)));

		if (verifyElement(By.xpath(CREATE_OPR_BTN_XPATH)) && verifyElement(By.id(OPR_SEARCH_FIELD))
				&& verifyElement(By.xpath(refreshButton)) && verifyElement(By.xpath(filterButton))
				&& verifyElement(OPR_NAMECOLUMN) && verifyElement(OPR_TYPECOLUMN)
				&& verifyElement(OPR_PRIMARYTERRITORYCOLUMN) && verifyElement(OPR_REPORTSTOCOLUMN)
				&& verifyElement(OPR_JOBTITLECOLUMN) && verifyElement(OPR_JOBTITLECOLUMN)
				&& verifyElement(OPR_NAMECOLUMN))
			return true;
		else
			return false;

	}

	@Override
	public boolean validateListPage() {

		return verifyElement(By.xpath(OPR_FILTER_PLACEHOLDER));

	}

	@Override
	public boolean validateOprListPage() {

		if (!verifyElement(By.xpath(OPR_FILTER_PLACEHOLDER))) {
			System.out.println("*************1");
			return false;
		}

		else if (!verifyElement(By.xpath(CREATE_OPR_BTN_XPATH))) {
			System.out.println("*************2");
			return false;
		} else if (!verifyElement(By.xpath(refreshButton))) {
			System.out.println("*************3");
			return false;
		} else if (!verifyElement(By.xpath(filterButton))) {
			System.out.println("*************4");
			return false;
		}
		// operator List Columns
		else if (!verifyElement(OPR_NAMECOLUMN)) {
			System.out.println("*************5");
			return false;
		} else if (!verifyElement(OPR_PRIMARYTERRITORYCOLUMN)) {
			System.out.println("*************6");
			return false;
		} else if (!verifyElement(OPR_REPORTSTOCOLUMN)) {
			System.out.println("*************7");
			return false;
		} else if (!verifyElement(OPR_JOBTITLECOLUMN)) {
			System.out.println("*************8");
			return false;
		} else if (!verifyElement(OPR_JOBTITLECOLUMN))
			return false;
		else if (!verifyElement(OPR_NAMECOLUMN)) {
			System.out.println("*************9");
			return false;
		}

		else
			return true;

	}

}
