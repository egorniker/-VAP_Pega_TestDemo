package com.pega.crm.pegamarketing.utils;

public class PMXPathUtil {

	public static String getDataTestIdXPath(String dataTestID) {
		return "//*[@data-test-id='" + dataTestID + "']";
	}

	public static String getRuleTabXpath(String tabName) {
		return "//div[@role='tab' and @aria-label='" + tabName + "']";
	}

	public static String getMenuItemXPath(String menuItemText) {
		return "(//span[@class='menu-item-title' and text()='" + menuItemText + "'])[last()]";
	}

	public static String getTdMenuItemXPath(String menuItemText) {
		return "//td[@id='ItemMiddle' and text()='" + menuItemText + "']";
	}

	public static String getButtonPzBtnMidXPath(String buttonText) {
		return "//div[@class='pzbtn-mid' and contains(text(),'" + buttonText + "')]";
	}

	public static String getButtonStrongPzhcPzBtnXPath(String buttonText) {
		return "//button[@class='Strong pzhc pzbutton' and contains(text(),'" + buttonText + "')]";
	}

	public static String getButtonPzBtnMidXPathWithoutDisplayNone(String buttonText) {
		return "//div[@class='pzbtn-mid' and contains(text(),'" + buttonText
				+ "')][not(.//ancestor::div[contains(@style,'none')])]";
	}

	public static String getButtonPzBtnRndXPath(String buttonText) {
		return "//div[@class='pzbtn-rnd' and contains(text(),'" + buttonText + "')]";
	}

	public static String getButtonPzhcBtnXPath(String buttonText) {
		return "//button[@class='pzhc pzbutton' and contains(text(),'" + buttonText + "')]";
	}

	public static String getButtonTdBtnXpath(String buttonText) {
		return "//button[@class='buttonTdButton' and contains(text(),'" + buttonText + "')]";
	}

	public static String getTabHeaderXpath(String tabHeader) {
		return "//a[contains(@tabtitle,'" + tabHeader + "')]";
	}

	public static String getColHeaderXpath(String colHeader) {
		return "//div[text()='" + colHeader + "']";
	}

	public static String getButtonXpathByDataID(String dataID) {
		return "//button[@data-test-id='" + dataID + "']";
	}

	public static String getInputXpathByDataID(String dataID) {
		return "//input[@data-test-id='" + dataID + "']";
	}

	public static String getAnchorXpathByDataID(String dataID) {
		return "//a[@data-test-id='" + dataID + "']";
	}

	public static String getSpanXpathByDataID(String dataID) {
		return "//span[@data-test-id='" + dataID + "']";
	}

	public static String getCreateCaseMenuItemXpath(String caseName) {
		return "//ul[@role='menu' and contains(@style,'block') and contains(@id,'ppyElements')]//a[@role='menuitem' and contains(@data-click,'createNewWork')]//span[contains(text(),'"
				+ caseName + "')]";
	}

	public static String getAutoCompleteMenuItem(String itemText) {
		return "//div[contains(@class,'autocompleteAG')]//span[text()='" + itemText + "']";
	}

	public static String getLayoutXpath(String layoutNumber) {
		return "(//fieldset[.//span[text()='" + layoutNumber
				+ "']])[position()=last()]//div[@id='dragSimpleLayout-DIV']";
	}

	public static String getRepeatingGridLayoutXpath(String layoutNumber) {
		return "//fieldset[.//span[text()='" + layoutNumber + "']][@id='repeatingFieldSet']";
	}

	public static String getButtonpzButtonXpath(String buttonText) {
		return "//button[contains(@class,'pzbutton') and contains(text(),'" + buttonText + "')]";
	}

	public static String getButtonpzButtonXpathWithoutDisplayNone(String buttonText) {
		return "//button[contains(@class,'pzbutton') and contains(text(),'" + buttonText
				+ "')][not(.//ancestor::div[contains(@style,'none')])]";
	}

	public static String getSpanXpathByText(String text) {
		return "//span[text()='" + text + "']";
	}

	public static String getRadioLabelXPath(String label) {
		return "//label[contains(@class, 'radioLabel') and text()='" + label + "']";
	}

	public static String getRadioLabelOrSpanXpath(String text) {
		return "//label[contains(@class,'radioLabel') and text()='" + text + "']" + "|" + "//span[text()='" + text
				+ "']";
	}

	public static String getMatchHighlightSpanXpath(String text) {
		return "//span[@class='match-highlight'][text()='" + text + "']";
	}

	public static String getWorkObjectStepInstructionXpath(String text) {
		return "//*[contains(text(),'" + text + "')]";
	}

	public static String getCreateApplicationViewButtonXPath(String buttonText) {
		return "//*[@data-test-id='channel-type-tile' and text()='" + buttonText + "']";
	}

	public static String getCheckboxContainingNameXpath(String name) {
		return "//input[@type='checkbox' and contains(@name,'" + name + "')]";
	}

	public static String getInputContainingNameXpath(String name) {
		return "//input[contains(@name,'" + name + "')]";
	}

	public static String getSelectContainingNameXpath(String name) {
		return "//select[contains(@name,'" + name + "')]";
	}

	/*
	 * public static String getMenuItemXpath(String menuItemName) { return
	 * "//a[@role='menuitem']//span[text()='"+menuItemName+"']"; }
	 */
}
