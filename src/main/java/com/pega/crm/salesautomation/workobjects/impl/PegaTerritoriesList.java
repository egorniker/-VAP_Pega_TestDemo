package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Territories;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;

public class PegaTerritoriesList extends PegaWorkObject implements TerritoriesList {

//	public PegaTerritoriesList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//		// TODO Auto-generated constructor stub
//	}
	
	public PegaTerritoriesList(TestEnvironment testEnv) {
		super(testEnv);
		// TODO Auto-generated constructor stub
	}

	String TERR_PARENT_HANDLE;

	@Override
	public Territories createTerritory() {
		findElement((CREATE_TERR_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady();
		String frameId = getActiveFrameId(false);
//		Territories trr = new PegaTerritory(frameId, testEnv);
		Territories trr = new PegaTerritory(testEnv);
		return trr;

	}

	@Override
	public Territories navigateTerritory(String territoryName) {

		findElement((TRR_FILTER_PLACEHOLDER_XPATH)).sendKeys(SELECT_ALL);
		findElement((TRR_FILTER_PLACEHOLDER_XPATH)).sendKeys(territoryName);
//		findElement((TRR_FILTERBUTTON_XPATH)).click();
		findElement((TRR_FILTER_PLACEHOLDER_XPATH)).sendKeys(Keys.ENTER);
pegaDriver.waitForDocStateReady();
findElement(TRR_ROW_LEVEL_EDIT_ICON);
		findElement((TRR_ROW_LEVEL_EDIT_ICON)).click();
		String frameId = getActiveFrameId(false);
//		Territories trr = new PegaTerritory(frameId, testEnv);
		Territories trr = new PegaTerritory(testEnv);
		return trr;

	}

	public String getTerritoryID(String territoryName) {
		findElement((TRR_FILTER_PLACEHOLDER_XPATH)).sendKeys(territoryName);
		findElement((TRR_FILTERBUTTON_XPATH)).click();
		String territoryId = findElement(By.xpath(TRR_TERRIOTRYID_XPATH)).getText();
		return territoryId;

	}

	@Override
	public String getTerritoryPageHeader() {

		String trrHeader = findElement((TRR_TERRITORY_PAGE_HEADER_XPATH)).getText();
		return trrHeader;
	}

	@Override
	public boolean isCreateTerritoryButtonDisplayed() {

		return (findElement((CREATE_TERR_BTN_XPATH)).isVisible());
	}

	@Override
	public boolean isFilterTextBoxDisplayed() {

		return (findElement((TRR_SEARCH_FIELD_ID)).isVisible());
	}

	@Override
	public String getFilterPlaceHolder() {

		return (findElement((TRR_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder"));
	}

	@Override
	public boolean isRefreshIconDisplayed() {

		return (findElement((TRR_REFRESH_XPATH)).isVisible());
	}

	@Override
	public boolean isHistoryIconDisplayed() {

		return (findElement((TRR_HISTORY_XPATH)).isVisible());
	}

	@Override
	public boolean isTreeViewIconDisplayed() {

		return (findElement((TRR_TREEVIEW_XPATH)).isVisible());
	}

	@Override
	public ArrayList<String> getTableHeaders() {

		ArrayList<String> s = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(TRR_TABLE_HEADER_XPATH));
		for (WebElement w : wb) {
			String s1 = w.getText();
			System.out.println(s1);
			s.add(s1);
		}
		return s;
	}

}
