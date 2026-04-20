package com.pega.crm.customerservice.interactions.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;
import com.pega.framework.PegaWebElement;

public class PegaNewDemoInteraction extends PegaInteractions implements NewDemoInteraction {

	public PegaNewDemoInteraction(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
		pop = true;
	}

	@Override
	public void acceptCall() {
		findElement(By.xpath("//button[contains(.,'Accept')]")).click();

	}

	@Override
	public void switchToTab(String tabname) {
		String InitialXPATH = "//h2[@class='layout-group-item-title' and text()='#replaceString#']";
		String FinalXPATH = new String(InitialXPATH).replace("#replaceString#", tabname);
		PegaWebElement switchToTab = findElement(By.xpath(FinalXPATH));
		switchToTab.click();
	}

}
