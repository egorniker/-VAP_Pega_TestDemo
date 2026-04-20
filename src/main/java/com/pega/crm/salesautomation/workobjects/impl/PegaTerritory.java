package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Territories;

public class PegaTerritory extends PegaWorkObject implements Territories {

//	public PegaTerritory(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}

	public PegaTerritory(TestEnvironment testEnv) {
		super(testEnv);
	}
	@Override
	public void setTerritoryName(String terrName) {
		findElement((TRR_NAME_ID)).sendKeys(terrName);

	}

	@Override
	public void setOwner(String terrOwner) {
		findElement(By.id("crmSearchOwner")).click();
		findAutoComplete(By.id(TRR_OWNER_ID)).setValue(terrOwner);

	}

	@Override
	public void setDelegate(String delgName) {
		findAutoComplete(By.id(TRR_DELEGATE_ID)).setValue(delgName);

	}

	@Override
	public void setParentTerritory(String parentTerrName) {
		findAutoComplete(By.id(TRR_PARENT_TERRITORY_ID)).setValue(parentTerrName);
	}

	@Override
	public void clickSubmit() {
		submit();
	}

	@Override
	public void navigateToTerritoryModelbox() {

	}

	@Override
	public String getTerritoryModelboxName() {
		String title = pegaDriver.getTitle();
		return title;
	}

	@Override
	public void setReservedForPartner(String value) {
		//
		if (value.equals("Yes")) {

			findElement((TRR_RESERVED_FOR_PARTNER_ID)).click();
		}

	}

	@Override
	public String getTerritoryName() {
		pegaDriver.handleWaits().waitForElementPresence(TRR_NAME_ID);
		String name = findElement((TRR_NAME_ID)).getAttribute("Value");
		return name;
	}

	@Override
	public String getTerritoryOwner() {

		String Owner = findElement(By.id(TRR_OWNER_ID)).getAttribute("value").trim();
		return Owner;
	}

	@Override
	public String getParentTerritory() {
		String parent = findElement((TRR_PARENTTERRITORY_VALUE_XPATH)).getText().trim();
		return parent;
	}

	@Override
	public boolean isTerritoryNameDisplayed() {

		if (findElement((TRR_NAME_ID)).isDisplayed())
			return true;
		else
			return false;
	}

	@Override
	public boolean isSubmitDisplayed() {
		if (findElement(By.id(TRR_SUBMIT_ID)).isDisplayed())
			return true;
		else
			return false;
	}

	@Override
	public boolean isTerritoryNameEnabled() {

		return (findElement((TRR_NAME_ID)).isEnabled());

	}

	@Override
	public boolean isParentTerritoryEnabled() {

		return (findElement(By.id(TRR_OWNER_ID)).isEnabled());
	}

	@Override
	public boolean isDelegateEnabled() {

		return (findElement(By.id(TRR_DELEGATE_ID)).isEnabled());
	}

	@Override
	public boolean isReservedForPartnerEnabled() {

		return (elementPresent((TRR_RESERVED_FOR_PARTNER_ID)));
	}

	private boolean elementPresent(By by) {
		try {
			findElement(by);
			return true;
		} catch (Exception e) {
			System.out.println("Exception caught");
			return false;
		}
	}

	@Override
	public void modifyOwner(String terrOwner) {

		findElement((TRR_EDIT_OWNER_XPATH)).click();

		setOwner(terrOwner);
	}

	@Override
	public void modifyPerentTerritory(String parentTerrName) {

		findElement((TRR_EDIT_PARENT_TERRITORY_XPATH)).click();

		setParentTerritory(parentTerrName);

	}

	@Override
	public String getErrorMessageforName() {

		findElement((TRR_NAME_ID)).sendKeys(Keys.TAB);

		String error = findElement((TRR_ERROR_NAME_XPATH)).getText();
		return error;
	}

	@Override
	public String getErrorMessageforOwner()

	{
		findElement(By.id(TRR_OWNER_ID)).sendKeys(Keys.TAB);
		String error = findElement(By.xpath(TRR_ERROR_OWNER_XPATH)).getText();
		return error;
	}

	@Override
	public String getErrorMessageforParentTerritory() {
		clickSubmit();
		String error = findElement((TRR_ERROR_PARENTTERRITORY_XPATH)).getText();
		return error;
	}

	@Override
	public void clickOK() {

		By TerritorySubmitButton = By.xpath("//*[@data-test-id='20141009024905058525394']");
		findElement(TerritorySubmitButton).click();

	}

	public void confirmchange() {
		findElement(By.xpath("//label[@data-test-id='2015061908163100943143-Label']")).check();

	}

}
