package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;

public interface HouseholdList extends WorkObject {
	String CREATE_HH_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create household");
	String HH_SEARCH_FIELD_ID = "FilterTermForRelationshipGroup";
	String HH_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter households']";
	String HH_FILTERBUTTON_XPATH = PegaUtil.getButtonXpath("Filter");
	String HH_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//a[1]";
	String NO_HOUSEHOLDS_XPATH = "//tr[@id='Grid_NoResults']";
	By HH_EXPORT_BUTTON_XPATH = By.xpath("//*[@data-test-id='20141201005938049326913']");
	By HH_REFERSH_BUTTON_XPATH = By.xpath("//*[@data-test-id='20141201005938049427324']");
	String HH_TABLE_HEADER_XPATH = "//table[@id='bodyTbl_right']//th//div[@class='cellIn ']";

	Households createHousehold();

	Households navigateHouseholds(String householdsName);

	boolean isHouseholdListEmpty();

	Households openFirstHousehold();

	boolean isCreateButtonDisplayed();

	boolean isFilterTextBoxDisplayed();

	String getFilterPlaceHolder();

	boolean isFilterButtonDisplayed();

	boolean isExportButtonDisplayed();

	boolean isRefreshButtonDisplayed();

	ArrayList<String> getTableHeaders();

}