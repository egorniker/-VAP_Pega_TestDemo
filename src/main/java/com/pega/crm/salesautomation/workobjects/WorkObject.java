package com.pega.crm.salesautomation.workobjects;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;

import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;
import com.pega.page.TopDocument;
import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;

public interface WorkObject extends TopDocument {
	public static String STREET_ID = "pyStreet";
	public static String ADDRESSLINE2_ID = "AddressLine2";
	public static String CITY_ID = "pyCity";
	public static String STATE_ID = "pyState";
	public static String ZIPCODE_ID = "pyPostalCode";
	public static String COUNTRY_ID = "pyCountry";
	public static String HOMEPHONE_ID = "HomePhone";
	public static String HOMEEMAIL_ID = "HomeEmail";
	public static String MOBILE_ID = "MobilePhone";
	public static String FAX_ID = "FaxNumber";
	public static String SUBMIT_XPATH = "//button[@id='ModalButtonSubmit']" + "|"
			+ XPathUtil.getButtonPzBtnMidXPath("Submit") + "|" + PegaUtil.getStrongButtonXPath("Submit");
	public static String ADDRESSTYPE_XPATH = "//select[contains(@id,'AddressType')]";
	public static String SUBTABS_XPATH = "//div[@role='tablist']//div[contains(@class, 'count')]//h2";
	public static String SUBTAB_XPATH = "//div[@role='tablist']//div[contains(@class, 'count')]";
	public static String NO_ITEM_XPATH = "//tr[@id='Grid_NoResults']" + "|"
			+ "//div[text()='No cases are being followed']";
	public static String ACTION_BUTTON_XPATH = PegaUtil.getButtonXpath("Actions");
	public static String ACTION_BUTTON = "(//button[contains(@class, 'pzhc pzbutton') and contains(text(),'Actions')])[2]";
	public static String OK_BUTTON_XPATH = "//button[contains(@data-click,'doFormSubmit')]" + "|"
			+ XPathUtil.getButtonPzBtnMidXPath("OK") + "|" + "//button[@id='ModalButtonSubmit']";
	public static String SECTION_VALUE_XPATH = "//span[@class='assignment_title']|//div[contains(@class, 'dataLabelRead')]";
	public static String ACC_EDIT_XPATH = PegaUtil.getButtonXpath("Edit");
	public static String CREATE_XPATH = PegaUtil.getStrongButtonXPath("Submit");
	public static String CREATE_XPATH1= PegaUtil.getStrongButtonXPath("Create");
	public static String SUBMIT_XPATH_LEAD= "//button[contains(@class, 'Strong pzhc pzbutton') and (@title='Complete this assignment') and contains(text(),'Submit')]";
	public static String DISCARD_XPATH = PegaUtil.getSimpleButtonXPath("Discard");
	public static String STREET = "Build 12A";
	public static String ADDRESSLINE2 = "Raheja IT Park";
	public static String CITY = "Hyderabad";
	public static String STATE = "Telangana";
	public static String ZIPCODE = "500019";
	public static String COUNTRY = "India";
	public static String HOMEPHONE = "040-56984026";
	public static String HOMEEMAIL = "HomeEmail@pega.com";
	public static String MOBILE = "9874662315";
	public static String FAX = "040-5698745";
	public static String SELECT_ALL = Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE);
	public static String[] s = new String[25];
	public static int DATE = (new Date().getDate()) + 1;

	public static String DAY_XPATH = "//*[@data-day='" + DATE + "']";
	public static String NEWADDRESS_XPATH = "//a[contains(@name,'crmAddressList')]";
	public static String RECENT_WO_XPATH = "//div[@node_name='RecentItem']";
	public static String REFRESH_XPATH = PegaUtil.getButtonXpath("Refresh")
			+ "|//i[@alt='Refresh']|//i[@title='Refresh']";

	public static String ACTIVITY_REFRESH_XPATH = "//button[contains(@name, 'ctivities')][text()='Refresh'] | //i[contains(@name, 'ctivities')][@title='Refresh']|//i[contains(@name, 'ctivities')][contains(@class,'refresh')]";

	public static String TASK_REFRESH_XPATH = "//i[@title='Refresh'][contains(@name,'ask')]|//i[contains(@name, 'ask')][contains(@class,'refresh')]";

	public static String OPP_CONTACT_REFRESH_XPATH = "//button[contains(@name,'crmOpportunityContactsTab')][text()='Refresh']"
			+ "|" + PegaUtil.getButtonXpathWithIcon("Refresh") + "|"
			+ "//i[contains(@name, 'contacts')][contains(@class,'refresh')]";

	public static String CALANDER_XPATH = "//span[contains(@id, 'CloseDateSpan')]/span | //img[contains(@data-ctl,'DatePicker')]";
	public static String OPP_NEXTYEAR_XPATH = "//span[@id='yearSpinner']//button[@class='spin-button spin-up']";

	void clickRefresh();

	void clickRefresh(String tabName);

	void navigateToRecentItem(String WOName);

	boolean isRowValuePresent(String RowIdentifier, String ColumnIdentifier, String RowValue);

	void openRowWithDoubleClick(String RowIdentifier, String ColumnIdentifier, String RowValue);

	List<String> getRowValues(String RowIdentifier, String rowName);

	List<String> getRowValues(String RowIdentifier, String columValue1, String columValue2);

	boolean isActionItemValuePresent(String Locator, String dropDownValue);

	void submit();

	void setAddress();

	void setAddress(String AddressType);

	String getAddressType();

	void getSubTab(String subtabName);

	boolean isListEmpty();

	String getSectionHeader();

	void edit();

	void create();

	void discard();

	void OK();

	void refresh();

	void close();
}
