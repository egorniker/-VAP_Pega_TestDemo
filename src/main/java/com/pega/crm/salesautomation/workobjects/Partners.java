package com.pega.crm.salesautomation.workobjects;

import java.util.List;

import com.pega.util.XPathUtil;

public interface Partners extends WorkObject {
	String WEBSITE_ID = "Website";
	String PHONE_ID = "OfficePhone";
	String PATNER_NAME_ID = "Name";
	String EMAIL_ID = "WorkEmail";
	String PARTNER_TYPE = "PartnerType";
	String SFA_ACCESS_TYPE_ID = "crmAccessRequired";
	String OK_BUTTON_XPATH = "//button[contains(@data-click,'doFormSubmit')]" + XPathUtil.getButtonPzBtnMidXPath("OK");
	String TERRITORY_FIELD_ID = "crmTerritorySearch";
	String CREATE_TERRITORY_XPATH = "//a[contains(@name, 'crmTerritoryID')]";
	String TERRITORYNAME_ID = "Name";
	String TERRITORY_OWNER_ID = "crmSearchOwner";
	String PARENT_TERRITORY_ID = "crmTerritorySearch";
	String TERRITORY_SUBMIT_ID = "ModalButtonSubmit";
	String WEBSITE_VALUE_XPATH = "//span[text()='Website']/..//div/span";
	String PHONE_VALUE_XPATH = "//span[text()='Phone']/..//div/span";
	String NAME_VALUE_XPATH = "//span[text()='Name']/../../div/span";
	String EMAIL_VALUE_XPATH = "//span[text()='Email']/..//div/span";
	String PARTNERTYPE_VALUE_XPATH = "//span[text()='Partner Type']/..//div/span";
	String PARENT_TERRITORY_XPATH = "(//input[@id='crmTerritorySearch'])[2]";
	String TERRITORY_OWNER_XPATH ="(//input[@id='crmSearchOwner'])[2]";
	String SUBMIT_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Submit");
	String OPERATORS_VALUES_XPATH = "//tr[contains(@id, 'crmOperatorsInPartnerList')]//td[@data-importance='primary']//span";

	void setWebSite(String WebSite);

	void setPhone(String Phone);

	void setPartnerName(String Partner);

	void setEmail(String Email);

	void setPartnerType(String PartnerType);

	void setSFAAccess();

	void setTerritory(String TerritoryName);

	void clickcreateTerritory();

	void setTerritoryName(String TerritoryName);

	void setOwner(String OwnerName);

	void setParentTerritory(String ParentTerritory);

	void clickSubmitTerritoryScreen();

	void clickOK();

	void setAddress();

	void clickEdit();

	void updatePhone(String UpdatedPhone);

	void updateEmail(String UpdatedEmail);

	void clickSubmitReviewScreen();

	void clickOperatorsSubtab();

	String getWebSite();

	String getPhone();

	String getPartnerName();

	String getEmail();

	String getPartnerType();

	List<String> getOperators();

	List<String> trimOperators(List<String> operators);

	void setPartnerID(String PartnerID);

	void setPartnerTaxID(String TaxID);

	void setPartnerWorkFax(String WorkFax);

	void SubmitPartner();

	String getPartnerID();

	String getPartnerWorkFax();

	String getPartnerTaxID();

}
