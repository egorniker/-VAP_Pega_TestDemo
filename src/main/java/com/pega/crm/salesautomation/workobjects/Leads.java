package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;
import java.util.List;

import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;

public interface Leads extends WorkObject {
	String LEAD_LASTNAME_ID = "LastName";
	String LEAD_INDUSTRY_XPATH = "//select[contains(@name,'Industry')]";
	String LEAD_COMPANY_ID = "LeadCompanyName";
	String LEAD_STAGE_ID = "LeadStage";
	String LEAD_CREATE_XPATH = PegaUtil.getStrongButtonXPath("Create");
	String LEAD_NAME_VALUE_XPATH = "//*[text()='Last name']/../../div/span";
	String LEAD_NAME_INDIVIDUAL_VALUE_XPATH = "//*[text()='Last name']/../div/span";
	String LEAD_COMPANY_VALUE_XPATH = "//*[text()='Company']/../../div/span";
	String LEAD_STAGE_VALUE_XPATH = "//*[text()='Stage']/..//div";
	String LEAD_INDUSTRY_VALUE_XPATH = "//*[text()='Industry']/../..//div/div";
	String LEAD_CLOSE_XPATH = "//*[@id='$PpyWorkPage$pCloseDateSpan']/span";
	String LEAD_CLOSE_DATE_XPATH = "//*[@data-day='1']";
	String LEAD_CLOSE_ASSERT_XPATH = "//*[text()='Stage']/..//div";
	String LEAD_WORK_PHONE_ID = "LeadPhone";
	String LEAD_EMAIL_ID = "LeadEmail";
	String LEAD_FIRSTNAME = "FirstName";
	String LEAD_MOBILE = "LeadMobile";
	String LEAD_DESC = "pyDescription";
	String XPATH_WORKPHONE = "//span[text()='Phone']/../div/span";
	String XPATH_EMAIL = "//span[text()='Email']/../div/span";
	String XPATH_EMAIL_BUSINESS = "//span[text()='Email']/../div//a";
	String XPATH_FIRSTNAME = "//span[text()='First name']/../div/span";
	String XPATH_Mobile = "//span[text()='Mobile']/../div/span";
	String XPATH_Description = "//span[text()='Description']/../div/div";
	String LEAD_TERRIOTRY_ID = "crmTerritorySearch";
	String CONTACT_VALUE_XPATH = "//span[text()='Contact']/../..//a |//span[text()='Primary contact']/..//a";
	String LEAD_SECTION_VALUE_XPATH = "//span[@class='assignment_title']|//div[contains(@class, 'dataLabelRead')]";
	String LEAD_SWITCH_TO_EDIT_MODE_XPATH = "//*[@title='Switch to edit mode']";
	String LEAD_CHANGEOWNER_ID = "crmSearchOwner";
	String LEAD_CHANGEREASON_ID = "ChangeReason";
	String LEAD_OWNER_VALUE_XPATH = "//*[text()='Owner']/../div";
	String LEAD_TASK_REFRESH_XPATH = "//i[@title='Refresh' and contains(@name,'tasks')]";
	String LEAD_TASK_ROW_IDENTIFIER_XPATH = "//tr[contains(@id, 'SubSectiontasks')]";
	String LEAD_ACTIVITY_REFRESH_XPATH = "//i[@title='Refresh' and contains(@name,'Tasks')]";
	String LEAD_ACTIVITY_ROW_IDENTIFIER_XPATH = "//tr[contains(@id, 'ActivitiesList')]";
	String LEAD_CONTACT_ID = "crmSearchRelatedAccount";
	// String TECHINICAL_INFORMATION="//div[@aria-label='Disclose Technical
	// information']";

	String TECHINICAL_INFORMATION = "//div [contains(@title,'Technical')]";

	void setStage(String StageName);

	void setLastName(String LastName);

	void setCompany(String Company);

	void setIndustry(String Industry);

	void setTerritory(String str);

	void setWorkPhone(String WorkPhone);

	void clickOK();

	void clickSubmit();

	void clickEdit();

	void clickClose();

	void closeLead();

	void closeCommentLead();

	String closeLeadAssert();

	void clickClone();

	void setEmail(String Email);

	void setEmailBusiness(String Email);

	void setLeadFirstName(String FirstName);

	void setLeadMobile(String Mobile);

	void setLeadDesc(String Desc);

	String getLastName();

	String getStage();

	String getCompany();

	String getIndustry();

	String getWorkPhone();

	String getEMail();

	String getEmailBusiness();

	String getFirstName();

	String getMobile();

	String getDescription();

	String getContact();

	void clickChangeOwner();

	String getSectionHeader();

	void setOwner(String oPP_UPDATEDOWNER);

	void setReason(String oPP_CHANGEREASON);

	void clickSubmitButton();

	String getOwner();

	void getActivitiesSubTab();

	List<String> getTaskValues(String LeadName);

	List<String> getActivityValues(String ActivityName);

	void setContact(String ContactName);

	String getCreatedDate();

	void navigateToLeadFromBreadCrumb();

	String getLastNameForIndividual();

	ArrayList<String> getSubTabs();

}
