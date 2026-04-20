package com.pega.crm.customerservice.interactions;

import com.pega.ri.Wizard;

public interface Interactions extends Wizard {
	String PHONECALL_RESULT_SEARCH_XPATH = "//button[@title='Search']";
	String ADD_TASK_XPATH = "//*[@data-test-id='2014111401004903823658']";
	String ADDRESS_CHANGE_XPATH = "//a[contains(@title,'Address change' )  and  @class='Add_task']";
	String STATEMENT_COPY_XPATH = "//a[contains(text(),'Statement copy') and @class='Add_task']";
	String SERVICECASE_SUBMIT_XPATH = "//button[contains(.,'Submit')]";// div[contains(text(),'Submit')]
	String SERVICECASE_CONFIRM_XPATH = "//button[text()='Confirm']";
	String WRAP_UP_XPATH = "//*[@data-test-id='2018080902461007071328']";
	String OUTBOUND_REASON_XPATH = "//select[@data-test-id='20180725055154001963']";
	String OUTBOUND_STATUS_XPATH = "//label[contains(text(),'#status#')]";
	String LAST_NAME_XPATH = "//input[@data-test-id='2015052601072500441291']";
	String ACCOUNT_NO_XPATH = "//input[@data-test-id='2015052601072500473750']";
	//String CONTACT_RESULT_SUBMIT_XPATH = "//button[@title='Complete this assignment']";
	String CONTACT_VERIFICATION_1_ID = "IsSecurityQuestionVerified1";
	String CONTACT_VERIFICATION_2_ID = "IsSecurityQuestionVerified2";
	String REASON_FOR_INTERACTION_XPATH = "//select[@data-test-id='2014111404305809923288']";

	String PRODUCTOWNER_XPATH = "//label[contains(., '#owner#')]";
	String PRODUCT_CATEGORY_XPATH = "//select[@data-test-id='2016050903195606153521']";
	String PRODUCT_ID_XPATH = "//select[@data-test-id='2016050903195606154325']";

	String WORKBASKET_LINK_XPATH = "//h3[@class ='layout-group-item-title'][text()='My workbaskets']";
	String WORKBASKET_XPATH = "//select[@data-test-id='2015021706395105541298']";
	String WB_CASE_XPATH = "//table[contains(@pl_prop_class,'Assign-WorkBasket')][contains(@pl_prop, 'CPMMyWorkBasketListBBB')]/descendant::tr[contains(@oaargs,'#id#')]/descendant::a[text()='#id#']";
	String CLOSE_INTERACTION_XPATH = "//*[contains(@class,'Wrap_up') and contains(@title,'Close')]";// xpath updated
																									// from
																									// //a[@class='Wrap_up'
																									// and
																									// text()='Close']-Prasanna
																									// Modugu
	String Btn_AddTasks_Xpath = "//button[text()='Add tasks']";

	String CLOSE_ACCOUNT_XPATH = "//a[contains(text(),'Close account' )and @class='Add_task']";
	String MODIFY_CONTACT_LINKS_XPATH = "//a[contains(text(),'Modify contact links') and @class='Add_task']";
	String DISPUTE_TRANSACTION_XPATH = "//a[contains(text(),'Dispute transaction' )and @class='Add_task']";
	String LOST_OR_STOLEN_XPATH = "//a[contains(text(),'Lost or stolen card') and @class='Add_task']";
	String MODIFY_ACCOUNT_LINKS_XPATH = "//a[contains(text(),'Modify account links') and @class='Add_task']";
	String MODIFY_CONTACT_TO_ORG_LINKS_XPATH = "//a[contains(text(),'Modify contact to organization links') and @class='Add_task']";
	String UPDATE_CONTACT_PROFILE_XPATH = "//a[contains(text(),'Update contact profile') and @class='Add_task']";
	String MODIFY_ORGANIZATION_LINKS_XPATH = "//a[contains(text(),'Modify organization links') and @class='Add_task']";
	String COMPLAINT_OR_COMPLIMENT_XPATH = "//a[contains(text(),'Complaint or Compliment' )and @class='Add_task']";
	String SEND_CORRESPONDENCE_XPATH = "//a[contains(text(),'Send correspondence') and @class='Add_task']";
	String GENERAL_SERVICE_REQUEST_XPATH = "//a[contains(text(),'General service request') and @class='Add_task']";
	String MAKE_OFFER_XPATH = "//a[text()='Make offer' and @class='Add_task']";
	String OFFER_NEGOTIATOR_XPATH = "//a[text()='Offer negotiator' and @class='Add_task']";
	String ADD_NEW_ORGANIZATION_XPATH = "//a[contains(text(),'Add New Organization') and @class='Add_task']";
	String LOG_SALES_OPPORTUNITY_XPATH = "//a[text()='Log sales opportunity' and @class='Add_task']";
	String SCHEDULE_ACTIVITY_XPATH = "//a[contains(text(),'Schedule activity') and @class='Add_task']";
	String OPEN_NEW_ACCOUNT_XPATH = "//a[contains(text(),'Open new account') and @class='Add_task']";
	String SEARCH_INPUT_BOX_XPATH = "//input[@data-test-id='2015052704442407161656']";
	String ADD_TASKS_HEADER_XPATH = "//span[text()='Add tasks']";
	String ACCOUNT_HEADER_XPATH = "//span[text()='Account']";
	String CONTACT_HEADER_XPATH = "//div[@class='layout layout-none']//span[text()='Contact']";
	String GENERAL_HEADER_XPATH = "//div[@class='layout layout-none']//span[text()='General']";
	String ADD_TASKS_BUTTON_XPATH = "//button[@title='Add tasks' and text()='Add tasks']";
	String CANCEL_BUTTON_XPATH = "//button[@title='Cancel']";

	String ADDRESS_LINE1_XPATH = "//input[@data-test-id='2015052602433300441401' or @title='Enter address line1']";
	String ADDRESS_LINE2_XPATH = "//input[@data-test-id='2015052602433300462870' or @title='Enter address line 2']";
	String COUNTRY_CODE_XPATH = "//select[@data-test-id='20151104070027020222217' or @title='Select country']";
	String POSTAL_CODE_XPATH = "//input[@data-test-id='2015052602510103723409' or @title='Enter Postal Code']";
	String CITY_XPATH = "//input[@data-test-id='2015052602510103701860' or @title='Enter City']";
	String HOME_PHONE_XPATH = "//input[@data-test-id='2015052602582605511213']";
	String CELL_PHONE_XPATH = "//input[@data-test-id='2015052602582605522350']";
	String FAX_XPATH = "//input[@data-test-id='2015052602582605533172']";
	String EMAIL_ID_XPATH = "//input[@data-test-id='2015052602582605554739']";
	String SELECT_ADDITIONAL_ACCOUNTS_XPATH = "//input[@title='Select All Additional Accounts']//parent::div[contains(@class,'cellIn')]";
	String SELECT_REASON_XPATH = "//select[@title='Select a Reason']";
	String TRANSACTION_CHEKBOX_XPATH = "//input[@title='Select statement']/following-sibling::label[1]";
	String NEWPHONECALL_SEARCHBY = "//select[@data-test-id='202101210519160672413']";
	String SECOND_ACCNUM_XPATH = "(//input[@data-test-id='202101190116140885593'])[2]";
	String ACCNUM_PHONENUMBER_XPATH = "//input[@data-test-id='202101190116140891363']";
	String NEWPHONECALL_RESULT_SEARCH_XPATH = "//button[@data-test-id='202101210648280255868']";
	String Express_Frame ="pxExpress";
	String Form_factor_Frame ="FormFactoriFrame";
	String CONTACT_RESULT_SUBMIT_XPATH = "//button[contains(@name,'pyCaseActionAreaButtons_pyWorkPage') or (@data-test-id='202011240022540149840')]";
	String EMAIL_XPATH = "(//input[@data-test-id='202101190119190100987'])[2]";
	String SECOND_LASTNAME_XPATH = "(//input[@data-test-id='202101190119190100987'])[3]";
	
	void addTask();

	void confirmDisputeDetails();

	void selectReasonForDispute(String reason);

	void selectDisputeTransaction(String tranName);

	void searchByCustomerNameAndAccountNo(String lastName, String accountNum);

	void selectCustomer();

	void confirmAddressChange();

	void clickOnOtherActionsButton();

	void changeAddress();

	String verifyCompletedTask(String serviceProcess);

	void launchWrapup();

	void completeWrapUp(String reason);

	void completeWrapUpWithoutReason();

	void changeAdditionalAddress();

	void confirmFlow();


	void launchServiceProcess(String serviceProcess);

	void accountSelection(String acctNumber);


	void userSwitchToTab(String tab);


	void CaptureCallReasonAndPlaceCall(String reason, String status);

	void contactVerificationQuestions();

	void contactVerificationQuesforServiceCases();

	void selectSearchByinPhoneCallSearch(String arg1);

	void searchCustomerByAccNumPhoNum(String accnum, String phonum);

	void selectFirstCustomerInPhoneCallSearch();
	void frameswitching(int framevalue);

	void searchCustomerByEmaillastname(String email, String lastname);


}
