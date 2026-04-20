package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

public interface Treatment extends RuleInstance {

	By KEY_CODE_TEXT_BOX = By.xpath("//*[@name='$PpyNewResults$pKeyCode']");
	By TREATMENT_CONTENT_IFRAME = By.xpath("//iframe[contains(@title,'Rich Text Editor')]");
	//By TREATMENT_BODY = By.xpath("//body[contains(@title,'This is a rich text editor control')]");
	//By TREATMENT_BODY = By.xpath("//*[contains(text(),'This is a rich text editor control.')]");
	By TREATMENT_BODY = By.xpath("//body[contains(@aria-label,'This is a rich text editor control')]");
	
	 
	//*[text()='This is a rich text editor control.' and @class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']
	//span[text()='Internal' and @class='menu-item-title']
	//span[text()='This is a rich text editor control.']

	/**
	 * this method writes the given text into the Email/SMS body
	 * 
	 * @param content
	 *            text to be written
	 */
	void writeContent(String content);

	/**
	 * this method writes the given Keycode into Key Code field in Email treatment
	 * 
	 * @param keyCode
	 *            Key Code to be written
	 */
	void setKeyCode(String keyCode);

}
