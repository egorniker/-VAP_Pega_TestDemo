package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;
import java.util.List;

public interface Opportunities extends WorkObject {

	void setAmount(String oppAmount);

	void setDate();

	void setName(String oppName);

	void setTerritory(String oppTerritory);

	void setContact(String oppContact);

	void setForecastCategory(String oppforecastcategory);

	String setStage(String oppStage);

	void setOwner(String changeOwner);

	void setReason(String reason);

	void setCloseReason(String closeReason);

	void setCloseComments(String closeComments);

	void setSubject(String subject);

	void setDueDate();

	void setType(String type);

	void setStatus(String status);

	void addRow();

	void enterContact(String contactName);

	void setPrimaryContact();

	void setDescrption(String Description);

	void setOpptyMustWinWhileMerge();

	void setDescrptionWhileMerge(String Description);

	public String getDefaultAccount();

	void clickOK();

	void clickEdit();

	void clickSubmit();

	void clickChangeOwner();

	void clickCloneOpportunity();

	void clickSubmitButton();

	void clickUpdateContacts();

	void clickCloseForBusiness();

	void clickUpdateStage();

	void clickCloseForIndividual();

	void clickContactSubtab();

	void clickMegeOpportunity();

	void selectOpportunuty();

	void selectOpportunitytoMerge(String opptyName);

	void clickNext();

	void clickFollow();

	void clickUnFollow();

	void setSource(String Source);

	void setShotName(String shortname);

	void setOpptyMustWin();

	String getName();

	String getOwner();

	String getSectionHeader();

	String getSectionCustomHeader();

	ArrayList<String> getSubTabs();

	String getAmount();

	String getForecast();

	String getStageForBusiness();

	String getStageForIndividual();

	String getContactNameInSubtab();

	String getUpdateContactsHeader();

	String getFollowedWOName();

	String getClosedate();
	
	String getSectionname();

	String getTerritory();

	String getShortName();

	String getSource();

	String getWin();

	boolean isStageEnabled();

	boolean isCloseDateEnabled();

	boolean isAmountEnabled();

	boolean isFollowingListEmpty();

	boolean isActionItemValuePresent(String dropDownValue);

	void clickCreate();

	void navigateToRecentOppty(String cloneopptyname);

	String getOpptyStatus();

	void getActivitiesSubTab();

	List<String> getTaskValues(String RowName);

	List<String> getActivityValues(String ActivityName);

	void clickUpdateStagefromSubtab();

	boolean isMovetoNextStageAvailable();

	boolean isWinProvavilityAvailable();

	boolean isCloseDateAvailable();

	boolean isNextBestActionAvailable();

	String getOppID();

	Organizations navigateToOrgFromBreadCrumb();

	void clearNameinMergeOppty();

	void clearAccountinMergeOppty();

	void clearOwnerinMergeOppty();

	void clickSearch();

	void clickCloseplanSubtab();

	void setCloseplanupdates();

	void clickSalesTeamSubtab();

	void addTeamMember(String opr);

	boolean isTeamMemberAdded(String opr, String Role);

}
