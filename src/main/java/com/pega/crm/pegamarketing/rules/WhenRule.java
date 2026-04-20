package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ModalDialog;

public interface WhenRule extends RuleInstance {
	By ADD_WHEN_CONDITION_LINK = By.xpath("//nobr[contains(text(),'Double click to add')]");

	ConditionDialog editWhenCondition();

	void setBranch(String branchName);

	public interface ConditionDialog extends ModalDialog {
		By CONDITION_PARAMETER_INPUT = By.id("pyParametersParamValue");
		By CONDITION_SELECT_BOX = By.id("pySymbolComparators");

		void editCondition(String paramValue1, String condition, String paramValue2);
	}
}
