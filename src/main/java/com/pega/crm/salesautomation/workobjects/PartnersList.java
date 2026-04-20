package com.pega.crm.salesautomation.workobjects;

import com.pega.util.XPathUtil;

public interface PartnersList extends WorkObject {

	String CREATE_PTR_BTN_XPATH = XPathUtil.getButtonPzBtnMidXPath("Create Partner");
	String PTR_SEARCH_FIELD_ID = "FilterTermForOrganization";
	String PTR_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter Partners']";
	String PTR_FILTERBUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Filter");
	String PTR_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[@pl_index='1']//a[1]";
	String OPR_FILTER_ID = "FilterTerm";
	String OPR_NAME_XPATH = "//tr[contains(@id, 'OperatorAccessList')]/td[@data-attribute-name='Name']//span";
	String NO_PARTNERS_XPATH = "//tr[@id='Grid_NoResults']";

	Partners createPartner();

	Partners navigatePartner(String partnerName);

	boolean searchOperator(String OperatorName);

	boolean isPartnerListEmpty();

	Partners openFirstPartner();
}
