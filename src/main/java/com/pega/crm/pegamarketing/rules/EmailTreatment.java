package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ButtonParametersDialog;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;

public interface EmailTreatment extends Treatment {

	By EMAIL_TEMPLATE_IFRAME = By
			.xpath("//iframe[@class='email-editor-preview-area email-editor-preview-area-transition']");
	By EMAIL_CONTENT_IFRAME = By.xpath("//iframe[contains(@title,'Rich Text Editor')]");
	By EMAIL_BODY = By.xpath("//body[contains(@title,'This is a rich text editor control')]");
	By EMAIL_TEMPLATE_DIV = By.xpath("//div[@data-pega-region='A']");
	By CONTENT_TAB = By.xpath(PMXPathUtil.getRuleTabXpath("Content"));
	By TEST_EMAIL_TAB = By.xpath(PMXPathUtil.getRuleTabXpath("Test email"));
	By DETAILS_TAB = By.xpath(PMXPathUtil.getRuleTabXpath("Details"));
	By PROMPTS_TAB = By.xpath(PMXPathUtil.getRuleTabXpath("Prompts"));
	By PAGES_AND_CLASSES_TAB = By.xpath(PMXPathUtil.getRuleTabXpath("Pages & Classes"));
	By SECURITY_TAB = By.xpath(PMXPathUtil.getRuleTabXpath("Security"));
	By HISTORY_TAB = By.xpath(PMXPathUtil.getRuleTabXpath("History"));
	By SUBJECT_AUTOCOMPLETE = By.xpath("//*[contains(@name,'Subject')]");
	By EDIT_MODE_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Edit mode"));
	By PICK_EMAIL_TEMPLATE_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Pick email template"));
	By LOAD_TEMPLATE_FROM_FILE_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Load template from file"));
	By DESKTOP_VIEW_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Desktop"));
	By MOBILE_VIEW_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Mobile"));
	By ADD_RECIPIENT_LINK = By.xpath("//a[@title='Add a row ']");
	By TEST_RECIPIENT_TEXTBOX = By.xpath("//input[contains(@pn,'TestRecipients') and @value='']");
	By TEST_MESSAGE_SUBJECT_TEXTBOX = By.id("TestEmailSubject");
	By SPECIFY_EMAIL_ACCOUNT_RADIO_BUTTON = By.xpath("//*[text()='Specify Email Account']/..//*[@type='radio']");
	By TEST_EMAIL_ACCOUNT_TEXTBOX = By.id("TestEmailAccount");
	By SEND_TEST_MESSAGE_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Send Test Message"));
	By EMAIL_INSERT_BUTTON = By.xpath("//*[contains(@class,'insertbutton')]");

	/**
	 * this method writes the given subject into Subject field in Email treatment
	 * 
	 * @param subject
	 *            subject to be written
	 */
	void setSubject(String subject);

	/**
	 * This method will click on Email template and so opens the Email editor
	 */
	void openEmailEditor();

	/**
	 * this method adds the given recipient
	 * 
	 * @param recipient
	 *            to be added
	 */
	void addRecipient(String recipient);

	/**
	 * this method writes the given text into the Test Message subject
	 * 
	 * @param testMessageSubject
	 *            subject to be written
	 */
	void setTestEmailSubject(String testMessageSubject);

	/**
	 * this method selects the Specify Email Account radio button
	 */
	void chooseSpecifyEmailAccountRadio();

	/**
	 * this method sets the given email account in Test Message email account field
	 * 
	 * @param emailAccount
	 */
	void setTestEmailAccount(String emailAccount);

	/**
	 * this method clicks on Send Test Message button
	 */
	void sendTestMessage();

	/**
	 * this clicks on enter in email editor
	 */
	void clickEnterInEditor();

	/**
	 * this clicks on insert button property
	 * 
	 * @return
	 */
	ButtonParametersDialog clickInsertButton();

}
