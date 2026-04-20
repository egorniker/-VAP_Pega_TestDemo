package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

public interface Households extends WorkObject {

	void setHouseholdName(String householdName);

	void setPhoneNumber(String PhoneNumber);

	void setDescription(String Description);

	void setStreet(String Street);

	void setCity(String City);

	void setState(String State);

	void setPincode(String Pin);

	void setCountry(String Country);

	void clickAddMember();

	void clickAddMemberinCreate();

	void clickCreate();

	void clickEdit();

	void clickSubmit();

	void clickAddOrRemoveMember();

	void removeFriendMember();

	boolean checkContactInHousehold(String contactName);

	void clickMember(String contactName);

	void searchContact(String Contact);

	void setHouseholdContact(String Role);

	String getHouseholdPageHeader();

	String getHouseholdName();

	String getPhoneNumber();

	String getMemberName();

	String getMemberRole();

	int getActiveMember();

	String getDescription();

	java.util.List<WebElement> getListOfActiveMember();

	void selectHousehold(String HouseholdName);

	void clickClose();

	void setComments(String Comments);

	boolean isActionItemValuePresent(String dropDownValue);

	void getMembersSubtab();

	ArrayList<String> getSubTabs();
}