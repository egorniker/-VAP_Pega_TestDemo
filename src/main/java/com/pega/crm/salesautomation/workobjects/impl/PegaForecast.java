package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Forecast;

public class PegaForecast extends PegaWorkObject implements Forecast {

//	public PegaForecast(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaForecast(TestEnvironment testEnv) {
		super(testEnv);
	}


	String TERRITORY_ID = "crmForecastByTerritorySearchTerm";
	String OVERRIDE_ID = "ForecastLevelTerritory";
	String YEAR_XPATH = "//*[@data-test-id='2014120902580108421219']";
	String FILTERBUTTON_XPATH = PegaUtil.getButtonXpath("Filter");
	String ADVANCED_XPATH = "//a[contains(@name,'FilterAdvanced')]";
	String Q1_CLOSED_XPATH = "//div[@data-click='ForecastGadget.ForecastSummaryColumn(2).CategoryRow(2)']//div[@pyclassname='PegaCRM-Embed-SFA-ForecastGadget']//a";

	@Override
	public boolean isTerritoryDisplayed() {

		return findElement(By.id(TERRITORY_ID)).isVisible();
	}

	@Override
	public boolean isOverrideLevelDisplayed() {

		return findElement(By.id(OVERRIDE_ID)).isVisible();
	}

	@Override
	public boolean isYearDisplayed() {
		return findElement(By.xpath(YEAR_XPATH)).isVisible();
	}

	@Override
	public boolean isFilterDisplayed() {
		return findElement(By.xpath(FILTERBUTTON_XPATH)).isVisible();
	}

	@Override
	public boolean isAdvancedDisplayed() {
		return findElement(By.xpath(ADVANCED_XPATH)).isVisible();
	}

	@Override
	public void setTerritory(String Territory) {
		findElement(By.id(TERRITORY_ID)).sendKeys(SELECT_ALL);
		findAutoComplete(By.id(TERRITORY_ID)).setValue(Territory);
	}

	@Override
	public void clickFilter() {
		findElement(By.xpath(FILTERBUTTON_XPATH)).click();
	}

	@Override
	public void setYear(String year) {

		findSelectBox(By.xpath(YEAR_XPATH)).selectByVisibleText(year);

	}

	@Override
	public String getQ1ValueClosed() {

		return findElement(By.xpath(Q1_CLOSED_XPATH)).getText();
	}

}
