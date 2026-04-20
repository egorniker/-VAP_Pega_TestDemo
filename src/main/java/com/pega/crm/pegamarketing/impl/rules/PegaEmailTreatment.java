package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ButtonParametersDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaButtonParametersDialog;
import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.framework.PegaWebElement;

public class PegaEmailTreatment extends PegaTreatment implements EmailTreatment {

	public PegaEmailTreatment(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void setSubject(String subject) {
		findElement(SUBJECT_AUTOCOMPLETE).sendKeys(subject + Keys.TAB);
	}

	public void openEmailEditor() {
		PegaWebElement frameElement = findElement(EMAIL_TEMPLATE_IFRAME);
		//findFrame(frameElement);
		//Commented above line, added below line
		pegaDriver.switchTo().frame(frameElement.getWebElement());
		findElement(EMAIL_TEMPLATE_DIV).click();
		pegaDriver.switchTo().parentFrame();

	}

	public void addRecipient(String recipient) {
		findElement(ADD_RECIPIENT_LINK).click();
		findElement(TEST_RECIPIENT_TEXTBOX).sendKeys(recipient + Keys.TAB);
	}

	public void setTestEmailSubject(String testMessageSubject) {
		findElement(TEST_MESSAGE_SUBJECT_TEXTBOX).sendKeys(testMessageSubject + Keys.TAB);
	}

	public void chooseSpecifyEmailAccountRadio() {
		PegaWebElement radio = findElement(SPECIFY_EMAIL_ACCOUNT_RADIO_BUTTON);
		testEnv.getScriptExecutor().click(radio);
	}

	public void setTestEmailAccount(String emailAccount) {
		pegaDriver.handleWaits().waitForElementVisibility(TEST_EMAIL_ACCOUNT_TEXTBOX);
		findElement(TEST_EMAIL_ACCOUNT_TEXTBOX).clear();
		findElement(TEST_EMAIL_ACCOUNT_TEXTBOX).sendKeys(emailAccount + Keys.TAB);
	}

	public void sendTestMessage() {
		findElement(SEND_TEST_MESSAGE_BUTTON).click();
	}

	@Override
	public void clickEnterInEditor() {
		PegaWebElement frameElement = findElement(TREATMENT_CONTENT_IFRAME);
		findFrame((PegaWebElement) frameElement.getWebElement());
		findElement(TREATMENT_BODY).sendKeys(Keys.RETURN);

	}

	@Override
	public ButtonParametersDialog clickInsertButton() {
		findElement(EMAIL_INSERT_BUTTON).click();
		ButtonParametersDialog buttonParametersDialog = new PegaButtonParametersDialog(this, testEnv);
		return buttonParametersDialog;
	}

}
