package com.pega.crm.pegamarketing.impl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.impl.rules.PegaRuleInstance;
import com.pega.crm.pegamarketing.pages.Strategy;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.elmt.Frame;

public class PegaStrategy extends PegaRuleInstance implements Strategy {

	public PegaStrategy(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void addCustomField(String name, String value) {
		findElement(CUSTOM_FIELDS_ADD_FIELD).click();
		AddCustomFieldsDialog addCustomFieldsDialog = new PegaAddCustomFieldsDialog(this);
		addCustomFieldsDialog.setNameAndValue(name, value);
		addCustomFieldsDialog.submit();
	}

	public boolean isCustomFieldAdded(String name, String value) {
		boolean isNamePresent = verifyElement(
				By.xpath("//table[@summary='pyCustomFields']//span[text()='" + name + "']"));
		boolean isValuePresent = value.equals(findElement(By.xpath("//table[@summary='pyCustomFields']//span[text()='"
				+ name + "']/ancestor::td[1]/following-sibling::td[1]/div[@class='oflowDivM ']")).getText());
		return isNamePresent && isValuePresent;
	}

	public boolean isCheckedIn() {
		return verifyElement(CHECKOUT_BUTTON);
	}

	public class PegaAddCustomFieldsDialog extends PegaModalDialog implements AddCustomFieldsDialog {
		Frame frame;
		PegaWebDriver pegaDriver;

		public PegaAddCustomFieldsDialog(Frame frame) {
			super(frame);
			this.frame = frame;
			pegaDriver = frame.getTestEnvironment().getPegaDriver();
		}

		public void setNameAndValue(String name, String value) {
			frame.findElement(By.id("pyCustomFieldName")).sendKeys(name + Keys.TAB);
			pegaDriver.waitForDocStateReady();
			frame.findElement(By.id("pyCustomFieldValue")).sendKeys(value + Keys.TAB);
		}

	}

}
