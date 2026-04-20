package com.pega.crm.pegamarketing.dialog;

import org.openqa.selenium.By;

public interface CategoriesDialog extends ModalDialog {

	By ADDCATEGORIES_LINK = By.xpath("//a[contains(text(),'Add categories')]");
	By SELECTCATEGORYLIST = By.xpath("//*[@node_name='pzSelectCategory']");
	By CREATENEW_LINK = By.xpath("//*[@node_name='pzSelectCategory']//*[contains(text(),'Create new')]");
	By CREATENEW_INPUT = By.xpath("//*[@data-test-id='20180125153603083011973']");
	By SELECTCTGYOK_BTN = By.xpath("//*[@aria-label='Select Category']//button[text()!='  Cancel ']");
	By CLOSE_BTN = By.xpath("//button[contains(text(),'Close')]");

	/**
	 * This method will click on Add categories link and opens Select category modal
	 * dialog
	 */
	void Addcategories();

	boolean verifycategory(String arg1);

	void addreqcategory(String arg1);

	void clickreqCategory(String arg1);

}
