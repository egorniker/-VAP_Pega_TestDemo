package com.pega.crm.salesautomation.workobjects;

import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;

public interface ContactList extends WorkObject {

	String CREATE_CONT_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create contact");
	String CONT_SEARCH_FIELD_ID = "FilterTermForContact";
	String CONT_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter Contact']";
	String CONT_FILTERBUTTON_XPATH = PegaUtil.getButtonXpath("Filter");
//	String CONT_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//a[1]";
	String CONT_NAME_XPATH = "(//*[@data-attribute-name='First name']//a)[1]";
	String NO_CONTACTS_XPATH = "//tr[@id='Grid_NoResults']";

	Contacts createContact();

	Contacts navigateContact(StringBuffer contactName);

	Contacts navigateContact(String contactName) throws InterruptedException;

	Contacts openFirstContact();

	boolean isContactListEmpty();
}
