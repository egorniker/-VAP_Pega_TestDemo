package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.Households;

public class PegaHouseholdList extends PegaWorkObject implements HouseholdList {

//	public PegaHouseholdList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//		// TODO Auto-generated constructor stub
//	}
	public PegaHouseholdList( TestEnvironment testEnv) {
		super(testEnv);
		// TODO Auto-generated constructor stub
	}

	
	public Households createHousehold() {
		findElement(By.xpath(CREATE_HH_BTN_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Households hh = new PegaHouseholds(frameId, testEnv);
		Households hh = new PegaHouseholds(testEnv);
		return hh;

	}

	public Households navigateHouseholds(String householdsName) {
		findElement(By.id(HH_SEARCH_FIELD_ID)).sendKeys(householdsName);
		findElement(By.xpath(HH_FILTERBUTTON_XPATH)).click();

		findElement(By.xpath(HH_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Households hh = new PegaHouseholds(frameId, testEnv);
		Households hh = new PegaHouseholds(testEnv);
		return hh;
	}

	@Override
	public boolean isHouseholdListEmpty() {

		try {
			findElement(By.xpath(NO_HOUSEHOLDS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public Households openFirstHousehold() {

		findElement(By.xpath(HH_NAME_XPATH)).click();

		String frameId = getActiveFrameId(false);
//		Households household = new PegaHouseholds(frameId, testEnv);
		Households hh = new PegaHouseholds(testEnv);
		return hh;
	}

	@Override
	public boolean isCreateButtonDisplayed() {

		boolean b = findElement(By.xpath(CREATE_HH_BTN_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterTextBoxDisplayed() {

		boolean b = findElement(By.xpath(HH_FILTER_PLACEHOLDER_XPATH)).isVisible();
		return b;
	}

	@Override
	public String getFilterPlaceHolder() {

		String b = findElement(By.xpath(HH_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder");
		return b;
	}

	@Override
	public boolean isFilterButtonDisplayed() {

		boolean b = findElement(By.xpath(HH_FILTERBUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isExportButtonDisplayed() {

		boolean b = findElement(HH_EXPORT_BUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public boolean isRefreshButtonDisplayed() {
		boolean b = findElement(HH_REFERSH_BUTTON_XPATH).isVisible();
		return b;
	}

	@Override
	public ArrayList<String> getTableHeaders() {

		ArrayList<String> s = new ArrayList<String>();

		List<WebElement> wb = findElements(By.xpath(HH_TABLE_HEADER_XPATH));
		for (WebElement w : wb) {
			String s1 = w.getText();
			s.add(s1);
		}
		return s;
	}

}