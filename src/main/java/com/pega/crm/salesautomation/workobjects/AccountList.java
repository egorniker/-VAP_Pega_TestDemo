package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;

public interface AccountList extends WorkObject {
	Accounts createAccount();

	Accounts navigateAccount(String accountName) throws InterruptedException;

	Accounts navigateAccount(StringBuffer accountName);

	Accounts openFirstAccount();

	Boolean isAccountListEmpty();

	boolean isCreateButtonDisplayed();

	boolean isFilterTextBoxDisplayed();

	String getFilterPlaceHolder();

	boolean isFilterButtonDisplayed();

	boolean isAllButtonDisplayed();

	boolean isBusinessButtonDisplayed();

	boolean isIndividualButtonDisplayed();

	boolean isExportButtonDisplayed();

	boolean isRefreshButtonDisplayed();

	ArrayList<String> getTableHeaders();

}
