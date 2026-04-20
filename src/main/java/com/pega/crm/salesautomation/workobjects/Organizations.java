package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;
import java.util.List;

public interface Organizations extends WorkObject {

	String ORG_OPPTY_ROW_IDENTIFIER_XPATH = "//tr[contains(@id, 'OpportunitiesInOrganizationList')]";

	Organizations navigateOrganization();

	Boolean verifyOrgNewHarness();

	Organizations editOrganization();

	Organizations OrgList();

	Organizations getOrganizationDetails();

	Organizations changeOwner();

	Organizations setNewOwner(String Owner);

	void setName(String name);

	void setWebsite(String name);

	void setTerritory(String territory);

	void setIndustry(String industry);

	void setPhoneNumber(String phoneNumber);

	void setShortName(String shortName);

	void setTickerSymbol(String ticker);

	void setEmployees(String employee);

	void setRevenue(String revenue);

	void setTarget(Boolean target);

	void setParentOrganization(String parentOrg);

	void setDescription(String description);

	void setDomains(String[] domains);

	void setAddress(String type, boolean primary);

	void setAddress();

	void changeTerritory(String newTerritory);

	void refresh();

	boolean checkMode(String str);

	String getName();

	String getTerritory();

	String getOwner();

	String getWebsite();

	String getIndustry();

	String getPhoneNumber();

	String getShortName();

	String getTickerSymbol();

	String getEmployees();

	String getRevenue();

	String getTarget();

	String getParentOrganization();

	String getDescription();

	String[] getAddress(String type);

	public ArrayList<String> verifySubTabs();

	boolean verifyOrgNews();

	boolean verifyTwitterIcon();

	boolean verifyFacebookIcon();

	boolean verifyGoogleMapIcon();

	Organizations changeHierarchy();

	Organizations setHierarchy(String newParentOrg);

	Accounts AddAccount();

	boolean validateOrgTask(String orgTaskSubject, String orgTaskStatus, String DueDate, String OrgTaskAssignedTo,
			String orgTaskPriority);

	boolean validateOrgActivities(String Subject, String CommunicationType, String actDate, String CompletedBy,
			String RelatedTo, String RelatedType);

	boolean validateOrgAccounts(String AccountName, String AccountOwner, String AccountIndustry,
			String AccOpportunities, String AccountTotAmount, String AccountStatus);

	boolean validateOrgContacts(String ContactName, String RelationshipType, String RelationshipDescription,
			String StartDate, String EndDate);

	void navigeToOrgTab(String tabName);

	void getOpptySubTab();

	List<String> getOpptyValues(String opptyName);

	void getContactSubTab();

	void getLeadSubTab();

	List<String> getLeadRowValues(String companyName);

	void ClickToggletoConList();

	void submit();

}
