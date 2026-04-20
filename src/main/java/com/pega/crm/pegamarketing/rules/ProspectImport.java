package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

public interface ProspectImport extends RuleInstance {
	By LIST_NAME_ID = By.id("ListName");
	By TAG_ID = By.id("ListTag");
	By CHOOSE_FILE_BUTTON = By.xpath("(//*[contains(@id,'FilePath') and @validationtype='required'])");
	By OTHER_ACTIONS_BUTTON = By
			.xpath("//button[contains(@class,'pzhc pzbutton') and contains(text(),'Other actions')]");
	By REFRESH_OPTION = By.xpath("(//*[contains(@class,'menu-item') and text()='Refresh'])");
	static By PROSPECT_IMPORT_ENTRIES_MESSAGE = By
			.xpath("(//td[@class='dataLabelRead']//nobr[contains(text(),'Prospect List entries have been created')])");
	By PROSPECT_IMPORT_ERRORS_MEASSAGE = By
			.xpath("(//td[@class='dataLabelRead']//nobr[contains(text(),'Errors skipped')])");
	By PROSPECT_DATA_LINK = By.xpath("//a[contains(@name,'ImportSummaryDetails')]");
	By ERROR_MESSGAE_VALIDATION = By.xpath("//span[contains(text(),'Validation failed')]");

	/**
	 * It will set given name for the Prospect List
	 * 
	 * @param listName
	 */
	void setListName(String listName);

	/**
	 * It will set given tag name for Prospect list
	 * 
	 * @param tagName
	 */
	void setTag(String tagName);

	/**
	 * It will upload given fileName for import Prospect List
	 * 
	 * @param fileName
	 */
	void uploadFile(String fileName);

	/**
	 * It will refresh the Prospect Import
	 */
	void refreshProspectImport();

	/**
	 * This is to validate if imported prospect list contains given Full names in
	 * verifyIfFullNamePresent method
	 * 
	 * @return status whether prospect import is successful
	 */
	boolean verifyIsProspectImportSuccessful();

	/**
	 * 
	 * @param FullName
	 * @return
	 */
	boolean verifyIfFullNamePresent(String FullName);

	void openProspectData();
}
