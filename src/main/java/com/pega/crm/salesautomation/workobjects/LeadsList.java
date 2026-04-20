package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;

public interface LeadsList extends WorkObject {
	String CREATE_LEAD_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create lead");
	String LEAD_SEARCH_FIELD_ID = "FilterTermForAccount'";
	By LEAD_FILTER_PLACEHOLDER_XPATH = By.xpath("//*[@data-test-id='20141222052109006713340' and @placeholder='Filter lead']");
	By LEAD_FILTERBUTTON_XPATH = By.xpath("//*[@data-test-id='201412160519150778339647']");
	String LEAD_NAME_XPATH = "//a[contains(@name,'LeadsList')]";
	String NO_LEADS_XPATH = "//tr[@id='Grid_NoResults']";
	By LEAD_ALL_BUTTON_XPATH = By.xpath("//*[@data-test-id='20141208053121076617163']");
	By LEAD_INDIVIDUAL_BUTTON_XPATH = By.xpath("//*[@data-test-id='20141208053121076819504']");
	By LEAD_BUSINESS_BUTTON_XPATH = By.xpath("//*[@data-test-id='20141208053121077021517']");
	By LEAD_EXPORT_BUTTON_XPATH = By.xpath("//*[@data-test-id='201412160519150784481805']");
	By LEAD_REFRESH_BUTTON_XPATH = By.xpath("//*[@data-test-id='201412160519150784482432']");
	String LEAD_TABLE_HEADER_XPATH = "//table[@id='bodyTbl_right']//th//div[@class='cellIn ']";

	Leads createBusinessLead();

	Leads createIndividualLead();

	Leads navigateLead(String LeadName);

	boolean isleadsListEmpty();

	Leads openFirstLead();

	String getSectionHeader();

	boolean isCreateLeadButtonDisplayed();

	boolean isFilterTextBoxDisplayed();

	String getFilterPlaceHolder();

	boolean isFilterButtonDisplayed();

	boolean isAllLeadButtonDisplayed();

	boolean isBusinessButtonDisplayed();

	boolean isIndividualButtonDisplayed();

	boolean isExportButtonDisplayed();

	boolean isRefreshButtonDisplayed();

	ArrayList<String> getTableHeaders();

}
