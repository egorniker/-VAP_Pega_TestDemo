package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

public interface DataFlows extends LandingPage {
	By INCLUDE_DATA_FLOWS_CHECKBOX = By.xpath("//input[contains(@name,'ShowGeneratedDataFlows') and @type='checkbox']");
	By SEARCH_TEXTBOX = By.id("pyName");

	/**
	 * checks Include System Data Flows checkbox
	 */
	void checkIncludeSysDataFlows();

	/**
	 * click View button
	 */
	void clickView();

	/**
	 * Searches for the given dataFlow name
	 * 
	 * @param dataFlow
	 *            name
	 */
	void searchDataFlows(String dataFlow);
}
