package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;
import java.util.List;

public interface Accounts extends WorkObject {

	void setAccountName(StringBuffer accountName);

	void setTerritory(String TerritoryName);

	void setOrganization(String OrganizationName);

	void setIndustry(String IndustryName);

	void setDescription(String Description);

	void setPhoneNumber(String PhoneNumber);

	void setAddress();

	void setOwner(String ownerName);

	void setReason(String reason);

	void setCloseComments(String comments);

	void setWebSite(String website);

	void setEmployees(String employees);

	void setTickerSymbol(String ticker);

	void setRevenue(String revenue);

	String getPrimaryContactName();

	void clickCreate();

	void clickEdit();

	void clickSubmit();

	void clickChangeOwner();

	void clickClose();

	void clickFollow();

	void clickUnFollow();

	void clickOrgLink();

	boolean validateAccActivities(String Subject, String CommunicationType, String actDate, String CompletedBy);

	Opportunities addOpportunity();

	void navigateToTab(String tabName);

	Boolean isNameEnabled();

	Boolean isPhoneNumberEnabled();

	Boolean isCityEnabled();

	Boolean isFollowingListEmpty();

	String getAccountPageHeader();

	String getAccountName();

	String getPhoneNumber();

	String getChangeOwnerHeader();

	String getOwner();

	String getCloseOwnerHeader();

	String getOrganization();

	String getTerritory();

	String getIndustry();

	String getEmployees();

	String getTicker();

	String getRevenue();

	String getDescription();

	String getdefaultOrg();

	boolean isActionItemValuePresent(String dropDownValue);

	boolean validateAccOpportunities(String opptyName, String opptyStage, String opptyCloseReason, String opptyOwner,
			String opptyAmount, String oppCloseDate, String opptyMustWin, String opptyTerritory);

	String getFollowedWOName();

	void getActivitiesSubTab();

	List<String> getTaskValues(String taskSubject);

	void getLeadSubTab();

	List<String> getLeadRowValues(String leadName);

	void getSalesTeamSubTab();

	void refresh();

	boolean isAccountFollowed();

	List<String> getFollowers(String Follower);

	void getContactSubTab();

	ArrayList<String> getSubTabs();

	List<String> getContactValues(String contactRelationship);

}
