package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.rules.WhenRule;
import com.pega.framework.elmt.Frame;

public class PegaWhenRule extends PegaRuleInstance implements WhenRule {

	public PegaWhenRule(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void setBranch(String branchName) {
		findSelectBox(DEV_BRANCH_SELECT_BOX).selectByVisibleText(branchName);
	}

	public ConditionDialog editWhenCondition() {
		findElement(ADD_WHEN_CONDITION_LINK).doubleClick();
		ConditionDialog conditionDialog = new PegaConditionDialog(this);
		return conditionDialog;
	}

	public class PegaConditionDialog extends PegaModalDialog implements ConditionDialog {

		public PegaConditionDialog(Frame elmt) {
			super(elmt);
		}

		public void editCondition(String paramValue1, String condition, String paramValue2) {
			findElements(CONDITION_PARAMETER_INPUT).get(0).sendKeys(paramValue1 + Keys.TAB);
			findSelectBox(CONDITION_SELECT_BOX).selectByVisibleText(condition);
			findElements(CONDITION_PARAMETER_INPUT).get(1).sendKeys(paramValue2 + Keys.TAB);
			pegaDriver.waitForDocStateReady();
		}

	}

}
