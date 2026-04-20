package com.pega.crm.customerservice.interactions.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;

public class PegaResearchInteraction extends PegaInteractions implements ResearchInteraction {

	public PegaResearchInteraction(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public String frameId = null;
	public Wizard newWizard = null;

	private static final String CS_SOCIAL_OPERATORID_XPATH = "//span/a[contains(@data-click,'showMenu')]";
	private static final String CS_SOCIAL_IMPL_LOGOFF_XPATH = "//span[@class='menu-item-title' and text()='Log off' or @class='menu-item-title' and text()='Logout']";

	@Override
	public void socialportallogout() {
		int windowsCount = pegaDriver.getWindowHandles().size();

		while (windowsCount > 1) {
			testEnv.getBrowser().switchToWindow(windowsCount);
			testEnv.getBrowser().close();
			windowsCount--;

		}
		testEnv.getBrowser().switchToWindow(windowsCount);
		findElement(By.xpath(CS_SOCIAL_OPERATORID_XPATH)).click(false);
		findElement(By.xpath(CS_SOCIAL_IMPL_LOGOFF_XPATH)).click(false);
	}

	@Override
	public void selectLinkUnderShareandFeedback(String linkName) {
		String initialXPATH = "//a[text()='#sericecase#']";
		String finalXPath = new String(initialXPATH).replace("#sericecase#", linkName);
		PegaWebElement mailArticle = findElement(By.xpath(finalXPath));
		mailArticle.click();

	}

	@Override
	public void filterwithValues(String searchBox, String searchString) {

		if (searchBox.equalsIgnoreCase("first name") || searchBox.equalsIgnoreCase("organization name")) {

			PegaWebElement searchtype = findElement(By.xpath(NewInboundInteraction.FIRST_NAME_SEARCH_BOX_XPATH));
			searchtype.sendKeys(searchString);
		}

		else {
			String initialXPath = "//input[@title='Search #Issue#']";
			String finalXPath = new String(initialXPath).replace("#Issue#", searchBox);

			PegaWebElement searchtype = findElement(By.xpath(finalXPath));
			searchtype.sendKeys(searchString);
		}

		if (searchString.equalsIgnoreCase("123450000")) {
			PegaWebElement searchButton = findElement(By.xpath(NewInboundInteraction.RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Acme Software")) {
			PegaWebElement searchButton = findElement(By.xpath(NewInboundInteraction.RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Rebecca")) {
			List<WebElement> searchButton = findElements(By.xpath(NewInboundInteraction.RESEARCH_SEARCH_XPATH));
			searchButton.get(0).click();
		}
	}

	@Override
	public void searchDropDownresult(String result) {
		pegaDriver.waitForDocStateReady(3);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		if (verifyElement(By.xpath("//span[contains(text(),'" + result + "')]/../../../td[5]/div/span/button"))) {
			PegaWebElement selectAccount = findElement(
					By.xpath("//span[contains(text(),'" + result + "')]/../../../td[5]/div/span/button"));
			selectAccount.click();
			PegaWebElement startresearch = findElement(By.xpath("//span[contains(text(),'Start research')]"));
			startresearch.click();
		} else if (verifyElement(By.xpath("//span/a[contains(text(),'" + result + "')]"))) {
			PegaWebElement selectAccount = findElement(By.xpath("//span/a[contains(text(),'" + result + "')]"));
			selectAccount.click();
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PegaWebElement selectAccount = findElement(By.xpath("//span[contains(text(),'" + result
					+ "')]/../../../td[@class=' gridCell ']//*[@aria-haspopup='true' and contains(@data-click,'CPMSearchResultMenu')]"));
			selectAccount.click();
			PegaWebElement startresearch = findElement(By.xpath("//span[contains(text(),'Start research')]"));
			startresearch.click();
		}

	}

	@Override
	public void filterWithAllForAccount(String AcNo, String Type, String Status, String OwnerName) {
		PegaWebElement accountNumber = findElement(By.xpath("//input[@title='Search account number']"));
		accountNumber.sendKeys(AcNo);

		PegaWebElement accountType = findElement(By.xpath("//input[@title='Search account type']"));
		accountType.sendKeys(Type);

		PegaWebElement accountStatus = findElement(By.xpath("//input[@title='Search status']"));
		accountStatus.sendKeys(Status);

		PegaWebElement accountOwner = findElement(By.xpath("//input[@title='Search owner first name']"));
		accountOwner.sendKeys(OwnerName);

		PegaWebElement searchButton = findElement(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.click();

	}

}
