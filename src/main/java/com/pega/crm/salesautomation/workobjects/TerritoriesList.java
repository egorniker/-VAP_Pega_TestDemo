package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;

public interface TerritoriesList extends WorkObject {
	By TRR_TERRITORY_PAGE_HEADER_XPATH = By.xpath("//*[@data-test-id='20141121165713062143523']");
	By CREATE_TERR_BTN_XPATH = By.xpath("//*[@data-test-id='201506190754350230614']");
//	By TRR_SEARCH_FIELD_ID = By.xpath("//*[@data-test-id='20150213024052054971000']");
	By TRR_SEARCH_FIELD_ID = By.xpath("//input[@id='FilterTermForTerritory']");
	By TRR_FILTER_PLACEHOLDER_XPATH = By.xpath("//*[@data-test-id='20141222052109006713340']");
	By TRR_FILTERBUTTON_XPATH = By.xpath("//*[@data-test-id='20150213024052055211248']");
	By TRR_NAME_XPATH = By.xpath("//*[@data-test-id='201710201403020629745-R1']");
	By TRR_ROW_LEVEL_EDIT_ICON = By.xpath("//*[@data-test-id='201710201403020629745-R1']//td//i[contains(@title,'Edit')]");
	By TRR_TREEVIEW_XPATH = By.xpath("//*[@data-test-id='20180110092149050733839']");
	By TRR_HISTORY_XPATH = By.xpath("//*[@data-test-id='20150213024052055417733']");
	By TRR_REFRESH_XPATH = By.xpath("//*[@data-test-id='201412220521090071145772']");
	String TRR_TABLE_HEADER_XPATH = "//table[@id='bodyTbl_right']//th//div[@class='cellIn ']";
	// No data test ID use for common generic but we using to get header value
	String TRR_TERRIOTRYID_XPATH = "//td[@data-attribute-name='ID']//span";
	// We are not using this element anywhere

	Territories createTerritory();

	Territories navigateTerritory(String territoryName);

	String getTerritoryPageHeader();

	boolean isCreateTerritoryButtonDisplayed();

	boolean isFilterTextBoxDisplayed();

	String getFilterPlaceHolder();

	boolean isRefreshIconDisplayed();

	boolean isHistoryIconDisplayed();

	boolean isTreeViewIconDisplayed();

	ArrayList<String> getTableHeaders();

	String getTerritoryID(String territoryName);

}
