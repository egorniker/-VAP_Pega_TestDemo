package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.rules.ProspectImport;

public class PegaProspectImport extends PegaRuleInstance implements ProspectImport {

	public PegaProspectImport(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public void setListName(String listName) {
		findElement(LIST_NAME_ID).sendKeys(listName);
	}

	@Override
	public void setTag(String tagName) {
		findElement(TAG_ID).sendKeys(tagName);
	}

	@Override
	public void uploadFile(String fileName) {
		String path = System.getProperty("user.dir") + "//Data//" + fileName;
		findElement(CHOOSE_FILE_BUTTON).sendKeys(path);
	}

	@Override
	public void refreshProspectImport() {
		findElement(OTHER_ACTIONS_BUTTON).click(false);
		findElement(REFRESH_OPTION).click();
		pegaDriver.waitForDocStateReady(4);
	}

	public void openProspectData() {
		findElement(PROSPECT_DATA_LINK).click();
	}

	@Override
	public boolean verifyIsProspectImportSuccessful() {
		boolean status = false;
		status = verifyIfFullNamePresent("KendraMertz");
		status = verifyIfFullNamePresent("LoganGagne");
		status = verifyIfFullNamePresent("SaleemAbdelsayed");
		return status;
	}

	public boolean verifyIfFullNamePresent(String FullName) {
		boolean IsFullNamePresent = false;
		if (verifyElement(By.xpath(
				"//table[@prim_page='pyReportContentPage']//tr//td[4]//div[contains(text(),'" + FullName + "')]"))) {
			IsFullNamePresent = true;
		}
		return IsFullNamePresent;
	}

}
