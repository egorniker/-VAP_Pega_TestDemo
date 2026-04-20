package com.pega.crm.customerservice.interactions;

public interface ResearchInteraction extends Interactions {
	String UPDATE_CONTACT_PROFILE_XPATH = "//a[text()='Update Contact Profile' and @class='Add_task']";
	String OCCUPATION_XPATH = "//input[@id='Occupation']";
	String CLOSE_INTERACTION_XPATH = "//a[@class='Wrap_up' and text()='Close']";
	String RESEARCH_SEARCH_XPATH = "//button[@data-test-id='201610210121280330388569']";

	void socialportallogout();

	void selectLinkUnderShareandFeedback(String linkName);

	void filterwithValues(String searchBox, String searchString);

	void searchDropDownresult(String result);

	void filterWithAllForAccount(String AcNo, String Type, String Status, String OwnerName);

}
