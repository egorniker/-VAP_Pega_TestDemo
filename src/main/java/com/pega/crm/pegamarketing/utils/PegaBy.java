package com.pega.crm.pegamarketing.utils;

import org.openqa.selenium.By;

/**
 * This class creates Selenium selectors for Pega concepts like sections and
 * test IDs. It is used similarly to the standard By:
 * 
 * By saveBtn = PegaBy.testId("1234567890"); By performanceChart =
 * PegaBy.sectionName("PerformanceChart");
 * 
 * @author oflad
 *
 */
public class PegaBy {

	/**
	 * Retrieves a Pega control by test ID
	 * 
	 * @param testId
	 * @return
	 */
	public static By testId(String testId) {
		return By.xpath("//*[@data-test-id='" + testId + "']");
	}

	/**
	 * Retrieves a Pega control by test ID if it has specified text
	 * 
	 * @param testId
	 * @return
	 */
	public static By testIdWithText(String testId, String text) {
		return By.xpath("//*[@data-test-id='" + testId + "'][text()='" + text + "']");
	}

	/**
	 * Gets the DOM element for a Pega section
	 * 
	 * @param sectionName
	 * @return
	 */
	public static By sectionName(String sectionName) {
		return By.xpath("//*[@data-node-id='" + sectionName + "']");
	}

	/**
	 * Works for both legacy tabs and layout group tabs (div and li)
	 * 
	 * @param tabName
	 * @return
	 */
	public static By ruleTab(String tabName) {
		return By.xpath("//*[@role='tab' and @aria-label='" + tabName + "']");
	}

	/**
	 * Retrieves a menu item on the page with the specified text
	 * 
	 * @param menuItemText
	 *            label for the menu item
	 * @return selector for the element
	 */
	public static By menuItem(String menuItemText) {
		return By.xpath("(//span[@class='menu-item-title' and text()='" + menuItemText + "'])[last()]");
	}
}
