package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;

public interface OpportunityList extends WorkObject {

	Opportunities createBusniessOpportunity();

	Opportunities createIndividualOpportunity();

	Opportunities navigateOpportunity(String opportunityName);

	boolean isCreateOpportunityButtonDisplayed();

	boolean isFilterTextBoxDisplayed();

	boolean isFilterButtonDisplayed();

	boolean isAllOpptyButtonDisplayed();

	boolean isIndividualButtonDisplayed();

	boolean isBusinessButtonDisplayed();

	boolean isExportButtonDisplayed();

	boolean isRefreshButtonDisplayed();

	String getFilterPlaceHolder();

	ArrayList<String> getTableHeaders();

	Opportunities openFirstOpportunity();

	boolean isOpportunityListEmpty();

	void searchOpportunity(String opptyName);

	void SwitchToBusinessTab();

	void dragAndDropToPropasal(String OppID);

	void switchToStageView();

}
