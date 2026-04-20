package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.CategoriesDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaCategoriesDialog;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.FrameImpl;

public class PegaRuleInstance extends FrameImpl implements RuleInstance {

	public PegaRuleInstance(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void save() {
		pegaDriver.handleWaits().waitForElementVisibility(SAVE_BUTTON);
		findElement(SAVE_BUTTON).click();

	}

	public void switchTab(String tab) {
		findElement(ruleTab(tab)).click();
	}

	public static By ruleTab(String tabName) {
		return By.xpath("//*[@role='tab' and @aria-label='" + tabName + "']");
	}

	public void checkout() {
		findElement(CHECKOUT_BUTTON).click();
	}

	public void createAndOpen() {
		findElement(CREATE_AND_OPEN_BUTTON).click();
	}

	public void submit() {
		findElement(SUBMIT_BUTTON).click();

	}

	public void setIssue(String issue) {
		pegaDriver.handleWaits().waitForElementVisibility(ISSUE_SELECT_BOX);
		findSelectBox(ISSUE_SELECT_BOX).selectByVisibleText(issue, true);
	}
	
	
	public void setCampIssue (String issue) {
		pegaDriver.handleWaits().waitForDocStateReady();
		pegaDriver.handleWaits().waitForElementVisibility(CAMP_ISSUE_SELECT_BOX);
		findSelectBox(CAMP_ISSUE_SELECT_BOX).selectByVisibleText(issue, true);
	}

	public void setGroup(String group) {
		pegaDriver.handleWaits().waitForElementVisibility(GROUP_SELECT_BOX);
		pegaDriver.handleWaits().sleep(5);
		findSelectBox(GROUP_SELECT_BOX).selectByVisibleText(group, true);
	}
	
	
	public void setCampGroup(String group) {
		pegaDriver.handleWaits().waitForElementVisibility(CAMP_GROUP_SELECT_BOX);
		findSelectBox(CAMP_GROUP_SELECT_BOX).selectByVisibleText(group, true);
	}

	public void setBudget(String aBudget) {
		pegaDriver.waitForDocStateReady();
		findElement(BUDGET_INPUT_BOX).sendKeys(aBudget);
	}

	public void setRuleName(String segName) {
		pegaDriver.handleWaits().waitForElementVisibility(RULE_NAME_TEXT_BOX);
		findElement(RULE_NAME_TEXT_BOX).sendKeys(segName + Keys.TAB);
	}

	public void selectDevBranch(String devBranch) {
		if (verifyElement(DEV_BRANCH_SELECT_BOX)) {
			findSelectBox(DEV_BRANCH_SELECT_BOX).selectByVisibleText(devBranch, true);
		}
	}

	public void verifyCheckoutButtonEnabled(){
		findElement(CHECKOUT_BUTTON).isVisible();
	}

	public void checkin(String comment) {
		findElement(By.xpath("//button[text()='Check in']")).click();
		findElement(By.id("pyMemo")).sendKeys(comment);
		findElement(By.id("submitButton")).click();
	}

	public void close() {
		findElement(CLOSE_ICON).click();
	}

	public void create() {
		findElement(CREATE_BUTTON).click();
	}

	public void run() {
		PegaWebElement actions = findElement(ACTION_BUTTON);
		pegaDriver.handleWaits().waitForElementVisibility(ACTION_BUTTON);
		pegaDriver.handleWaits().waitForElementClickable(ACTION_BUTTON);
		actions.click(false);
		PegaWebElement runLink = findElement(RUN_LINK);
		pegaDriver.handleWaits().waitForElementVisibility(runLink);
		pegaDriver.handleWaits().waitForElementClickable(RUN_LINK);
		runLink.click(false);
		pegaDriver.waitForDocStateReady(3);

	}

	public void edit() {
		pegaDriver.waitForDocStateReady();
		pegaDriver.handleWaits().waitForElementVisibility(EDIT_BUTTON);
		findElement(EDIT_BUTTON).click();

	}

	public CategoriesDialog clickoncategory() {
		pegaDriver.waitForDocStateReady();
		pegaDriver.handleWaits().waitForElementVisibility(CATEGORY_LINK);
		findElement(CATEGORY_LINK).click();
		return new PegaCategoriesDialog(this);

	}
}
