package com.pega.crm.salesautomation.workobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface ClosePlans extends WorkObject {
	boolean isFilterMenuDisplayed();

	boolean isApplyButtonDisplayed();

	boolean isExportButtonDisplayed();

	void clickOppty();

	void enterClosePlans(String comments);

	void filterBy(String option);

	void searchForOrganization(String orgName);

	void apply();

	List<WebElement> getOrgsFromOpportunities();

}
