package com.pega.crm.pegamarketing.dialog;

import org.openqa.selenium.By;

public interface ButtonParametersDialog extends ImageCatalogDialog {
	By BUTTON_PARAMETER_MODAL = By.id("modaldialog_hd_title");
	By BUTTON_IMAGE_COG = By.xpath("//*[@title='View folder contents ']");
	By HEADER_IMAGE = By.xpath("//*[text()='Image'][@class='header-title']");
	By BUTTON_IMAGE_FIELD = By.id("MKTBackgroundImage");
	By SAVE_BUTTON_PARAMETERS = By.id("saveElem");
	By TREATMENT_BODY = By.xpath("//body[contains(@title,'This is a rich text editor control')]");
	By CLICK_IMAGE_FOLDER = By.xpath("//*[text()='EmailImageFolder']");

	/**
	 * this verifies button parameters modal pop up
	 */
	void verifyButtonPropertiesDialog();

	/**
	 * clicks button image cog wheel
	 */
	void clickButtonImageCog();

	/**
	 * this verifies Image catalog header
	 */
	void verifyImageDialog();

	/**
	 * this verifies url set for
	 */
	void verifyButtonImageURL();

	/**
	 * clicks Save button for Button Parameters dialog
	 */
	void saveButtonParameters();

	void clickAndOpenFolder();
}
