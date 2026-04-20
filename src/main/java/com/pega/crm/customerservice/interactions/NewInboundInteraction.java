package com.pega.crm.customerservice.interactions;

public interface NewInboundInteraction extends Interactions {

	String DATE_RECEIVED_XPATH = "//input[@id='RecDate']";
	String CHANNEL_TYPE_ID = "ChannelType";
	String ACCOUNT_NUMBER_ID = "SearchAccountNumber";
	String CONTACT_ID = "SearchContactId";
	String BROWSE_PATH_ID = "$PpyWorkPage$ppyTemplateInputBox";
	String DESC_ID = "pyNote";
	String INTERACTION_ID_XPATH = "//div[@class='field-item dataValueRead']/span[contains(text(), 'I-')]";
	String CLOSE_BUTTON_XPATH = "//div[@class='pzbtn-mid' and text()='Close']";
	// String WORKBASKET_LINK_XPATH = "//h3[text()='My workbaskets']";
	String WORKBASKET_INBOUND_ID = "PropertyForParameters";
	String INBOUND_CASE_XPATH = "//a[text()='#id#']";
	String CLOSE_THIS_BUTTON_XPATH = "//div[text()='Confirm']/ancestor::button[@title='Close this item']";
	String SEARCHCASE_SUBMIT_XPATH = "//button[@class='Strong pzhc' and @title='Complete this assignment']";
	String URL = "https://www.pega.com/system/files/docs/2016/Oct/Pega-Customer-Service-Application-Data-Sheet.pdf";
	String LINK_TEXT = "Pega Link";
	String RESEARCH_SEARCH_XPATH = "//button[@data-test-id='201610210121280330388569']";
	String FIRST_NAME_SEARCH_BOX_XPATH = "//input[@data-test-id='201610202344320051247936']";

	void filterwithInitialValues(String searchBox, String searchString);

}
