package com.pega.crm.customerservice.interactions.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;

public class PegaNewInboundInteraction extends PegaInteractions implements NewInboundInteraction {

	public PegaNewInboundInteraction(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public String frameId = null;
	public Wizard newWizard = null;

	public void filterwithInitialValues(String searchBox, String searchString) {

		if (searchBox.equalsIgnoreCase("first name") || searchBox.equalsIgnoreCase("organization name")) {

			PegaWebElement searchtype = findElement(By.xpath(FIRST_NAME_SEARCH_BOX_XPATH));
			searchtype.sendKeys(searchString);
		}

		else {
			String initialXPath = "//input[@title='Search #Issue#']";
			String finalXPath = new String(initialXPath).replace("#Issue#", searchBox);

			PegaWebElement searchtype = findElement(By.xpath(finalXPath));
			searchtype.sendKeys(searchString);
		}

		if (searchString.equalsIgnoreCase("123450000")) {
			PegaWebElement searchButton = findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Acme Software")) {
			PegaWebElement searchButton = findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Rebecca")) {
			List<WebElement> searchButton = findElements(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.get(0).click();
		} else if (searchString.equalsIgnoreCase("Credit Card Fees & Charges")) {
			PegaWebElement searchButton = findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("12457890")) {
			PegaWebElement searchButton = findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		}

	}

}
