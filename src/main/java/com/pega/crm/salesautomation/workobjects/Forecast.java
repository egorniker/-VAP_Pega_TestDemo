package com.pega.crm.salesautomation.workobjects;

public interface Forecast extends WorkObject {

	boolean isTerritoryDisplayed();

	boolean isOverrideLevelDisplayed();

	boolean isYearDisplayed();

	boolean isFilterDisplayed();

	boolean isAdvancedDisplayed();

	void setTerritory(String Territory);

	void clickFilter();

	void setYear(String year);

	String getQ1ValueClosed();
}
