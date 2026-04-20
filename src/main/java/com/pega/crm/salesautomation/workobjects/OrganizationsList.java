package com.pega.crm.salesautomation.workobjects;

public interface OrganizationsList extends WorkObject {

	void search();

	Organizations createOrganization();

	public void verifyOrgListpage();

	OrganizationsList searchOrganization(String orgName);

	Organizations openOrganization(String orgName);

	Organizations navigateOrganiztion();

	Organizations openFirstOrganization();

	boolean isOrganizationListEmpty();
}
