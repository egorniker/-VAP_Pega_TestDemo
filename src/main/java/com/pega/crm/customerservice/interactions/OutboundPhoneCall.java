package com.pega.crm.customerservice.interactions;

public interface OutboundPhoneCall extends Interactions {

	String EXITCOMMENT_TEXTAREA_XPATH = "//textarea[@data-test-id='2015070207425705881733']";
	String OUTBOUND_WRAP_UP_XPATH = "//button[@data-test-id='2018080902461007071328']";

	String OUTBOUND_SIMULATION_TABLE_XPATH = "//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/tbody";
	String OUTBOUND_CONTACT_NAME = "//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr['#iValue#']/td[1]/div/span";

	void CaptureCallReasonAndPlaceCall(String reason, String status);

	void exitInteraction(String exitComments);

	void launchOutboundWrapUp();

	void launchOutboundInteractionforFirst(String contactName, String callStatus);

	void submitChanges();

}
