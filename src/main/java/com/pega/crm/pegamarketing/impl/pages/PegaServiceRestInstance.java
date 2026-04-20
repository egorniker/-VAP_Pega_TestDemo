package com.pega.crm.pegamarketing.impl.pages;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaRuleInstance;
import com.pega.crm.pegamarketing.pages.ServiceRestInstance;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaServiceRestInstance extends PegaRuleInstance implements ServiceRestInstance {
	public PegaServiceRestInstance(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void selectHttpMethod(String httpMethod) {
		findElement(By.xpath("//input[@value='POST']")).click();
	}

	public void executeSimulation() {
		findElement(By.xpath("//span[@class='pzbtn-label' and contains(text(),'Execute')]")).click();
	}

	public void run() {
		Frame frame = pegaDriver.findFrame("Developer");
		Frame frame2 = frame.findFrame(frame.getActiveFrameIdWithInThisFrame());
		PegaWebElement actions = frame2.findElement(ACTION_BUTTON);
		pegaDriver.handleWaits().waitForElementVisibility(ACTION_BUTTON);
		pegaDriver.handleWaits().waitForElementClickable(ACTION_BUTTON);
		actions.click();
		PegaWebElement runLink = frame2.findElement(RUN_LINK);
		pegaDriver.handleWaits().waitForElementVisibility(runLink);
		pegaDriver.handleWaits().waitForElementClickable(RUN_LINK);
		runLink.click();
	}

}
