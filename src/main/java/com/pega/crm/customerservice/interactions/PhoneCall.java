package com.pega.crm.customerservice.interactions;

public interface PhoneCall extends Interactions {

	String SEARCH_EMAIL_ID = "SearchStringEmail";
	String UNKNOWN_CUSTOMER_XPATH = "//div[text()='Unknown customer']";
	String REASON_XPATH = "//span[text()='Reason']";
	String PHONE_XPATH = "//label[text()='Callback']";
	String NPS_XPATH = "//span[contains(text(),'NPS')]";
	String LAST_INTERACTION_XPATH = "//span[text()='Last interaction']";
	String ADDRESS_XPATH = "//span[text()='Address']";
	String CALL1_BACK_XPATH = "//span[text()='Callback']";
	String CONTACT_INFO_XPATH = "//div[text()='Contact information']";
	String DIALOG_ID = "//div[@id='DialogContent']";
	String ADDTASK_XPATH = "//button[@title='Add Task']";
	String CHURN_RISK_XPATH = "//span[text()='Churn risk']";
	String CUSTOMER_SINCE_XPATH = "//span[text()='Customer since']";
	String LIFETIME_XPATH = "//span[text()='Lifetime value']";
	String NPS_TREND_XPATH = "//span[text()='NPS trend']";
	String RELATIONSHIP_XPATH = "//div[text()='Relationship']";
	String CANCEL_WORK_XPATH = "//span[text()='Cancel this work']";
	String EXIT_INTE_XPATH = "//span[text()='Exit interaction']";

	String WHERE_AM_I_XPATH = "//span[text()='Where am I']";
	String REFRESH_XPATH = "//span[text()='Refresh']";
	String PULSE_XPATH = "//span[text()='Pulse']";
	String HISTORY_ATTACHMENTS_XPATH = "//span[text()='History and attachments']";

	String SEARCH_XPATH = "//h6[@class='layout-group-item-title' and contains(text(),'Search')]";
	String GENERAL_ASSISTANCE_XPATH = "//h6[@class='layout-group-item-title' and contains(text(),'General assistance')]";

	void searchByEmail(String email);

	void scheduleActivity(String type, String account, String topic, String assign, String operator);

}
