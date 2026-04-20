package com.pega.crm.customerservice.stepdefs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.google.inject.Inject;
import com.pega.CRMObjectsBean;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped

public class NewPhoneCall {

	private PhoneCall phoneInteraction;
	private Interactions interaction;
	private ResearchInteraction researchInteraction;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	public static String CaseID = null;
	public String FOLLOW_CASE_ID = "//div[@id='CT']/span";
	//public String OK_BUTTON_XPATH = "(//*[text()='OK'])[2]";
	public String OK_BUTTON_XPATH ="//*[@data-test-id='2014121001163801314958']";
	public String caSysadminLogOff_XPATH = "//span[text()='Log off']";
	public String AddressLine1 = "//input[contains(@name,'AddressLine1')]";
	public String AddressLine2 = "//input[contains(@name,'AddressLine2')]";
	public String dropdownCountry = "//select[contains(@name,'CountryCode')]";
	public String City = "//input[contains(@name,'City')]";
	public String ZipCode = "//input[contains(@name,'ZipCode')]";
	private NewTopNav topNavFixture;

	@Inject
	public NewPhoneCall(NewTopNav topNavFixture, CRMTestEnvironment testEnv) {
		this.topNavFixture = topNavFixture;
		phoneInteraction = topNavFixture.getPhoneCall();
		interaction = topNavFixture.getInteractions();
		pegaDriver = testEnv.getPegaDriver();
		researchInteraction = topNavFixture.getResearchInteraction();
	}

	@When("^select the verification questions and click on verified$")
	public void select_the_verification_questions_and_click_on_verified() throws Throwable {
		interaction.contactVerificationQuestions();
	}

	@When("^select the verification questions for service cases and click on verified$")
	public void select_the_verification_questions_for_service_cases_and_click_on_verified() throws Throwable {
		interaction.contactVerificationQuesforServiceCases();
	}

	@When("^Click on Add Task to launch Service Process$")
	public void click_on_Add_Task_to_launch_Service_Process() {
		pegaDriver.waitForDocStateReady();
		interaction.addTask();
	}

	@Then("^Verify all the service process items and other fields$")
	public void verify_all_the_service_process_items_and_other_fields() {
		Assert.assertTrue("Add Task heading is not present",
				interaction.verifyElement(By.xpath(interaction.ADD_TASKS_HEADER_XPATH)));
		Assert.assertTrue("Add Task heading is not present",
				interaction.verifyElement(By.xpath(interaction.Btn_AddTasks_Xpath)));
		Assert.assertTrue("Search input box is not present",
				interaction.verifyElement(By.xpath(interaction.SEARCH_INPUT_BOX_XPATH)));

		Assert.assertTrue("Account Service process header is not present",
				interaction.verifyElement(By.xpath(interaction.ACCOUNT_HEADER_XPATH)));
		Assert.assertTrue("Contact Service process header is not present",
				interaction.verifyElement(By.xpath(interaction.CONTACT_HEADER_XPATH)));
		Assert.assertTrue("General Servive process header is not present",
				interaction.verifyElement(By.xpath(interaction.GENERAL_HEADER_XPATH)));
		Assert.assertTrue("Add Task button is not present",
				interaction.verifyElement(By.xpath(interaction.ADD_TASKS_BUTTON_XPATH)));
		Assert.assertTrue("Cancel button is not present",
				interaction.verifyElement(By.xpath(interaction.CANCEL_BUTTON_XPATH)));

		Assert.assertTrue("Address Change is not present",
				interaction.verifyElement(By.xpath(interaction.ADDRESS_CHANGE_XPATH)));
		Assert.assertTrue("Close Account is not present",
				interaction.verifyElement(By.xpath(interaction.CLOSE_ACCOUNT_XPATH)));
		Assert.assertTrue("Modify Contact Links is not present",
				interaction.verifyElement(By.xpath(interaction.MODIFY_CONTACT_LINKS_XPATH)));
		Assert.assertTrue("Dispute Transaction is not present",
				interaction.verifyElement(By.xpath(interaction.DISPUTE_TRANSACTION_XPATH)));
		Assert.assertTrue("Lost or stolen card is not present",
				interaction.verifyElement(By.xpath(interaction.LOST_OR_STOLEN_XPATH)));
		Assert.assertTrue("Statement copy is not present",
				interaction.verifyElement(By.xpath(interaction.STATEMENT_COPY_XPATH)));
		Assert.assertTrue("Modify account links is not present",
				interaction.verifyElement(By.xpath(interaction.MODIFY_ACCOUNT_LINKS_XPATH)));
		Assert.assertTrue("Modify Organizations links is not present",
				interaction.verifyElement(By.xpath(interaction.MODIFY_CONTACT_TO_ORG_LINKS_XPATH)));
		Assert.assertTrue("Update contact profile is not present",
				interaction.verifyElement(By.xpath(interaction.UPDATE_CONTACT_PROFILE_XPATH)));
		Assert.assertTrue("Modify account links is not present",
				interaction.verifyElement(By.xpath(interaction.MODIFY_ACCOUNT_LINKS_XPATH)));
		Assert.assertTrue("Modify organization links is not present",
				interaction.verifyElement(By.xpath(interaction.MODIFY_ORGANIZATION_LINKS_XPATH)));

		Assert.assertTrue("Send correspondence is not present",
				interaction.verifyElement(By.xpath(interaction.SEND_CORRESPONDENCE_XPATH)));
		Assert.assertTrue("General service request is not present",
				interaction.verifyElement(By.xpath(interaction.GENERAL_SERVICE_REQUEST_XPATH)));

		Assert.assertTrue("Schedule activity is not present",
				interaction.verifyElement(By.xpath(interaction.SCHEDULE_ACTIVITY_XPATH)));
		Assert.assertTrue("Open new account is not present",
				interaction.verifyElement(By.xpath(interaction.OPEN_NEW_ACCOUNT_XPATH)));

	}

	@When("^Launch \"([^\"]*)\" service process$")
	public void launch_service_process(String serviceProcess) {
		interaction.launchServiceProcess(serviceProcess);
	}

	@When("^change the address and other fields and submit$")
	public void change_the_address_and_other_fields_and_submit() {
		interaction.changeAddress();
	}

	@When("^check additional account for address change and submit$")
	public void check_additional_account_for_address_change_and_submit() {
		interaction.changeAdditionalAddress();
	}

	@When("^confirm the changes made$")
	public void confirm_the_changes_made() {
		interaction.confirmAddressChange();

	}

	@Then("^check for completed or cancelled task \"([^\"]*)\"$")
	public void check_for_completed_or_cancelled_task(String serviceProcess) {
		Assert.assertTrue("Completed process Label is not present",
				interaction.verifyElement(By.xpath(interaction.verifyCompletedTask(serviceProcess))));

	}

	@When("^launch warpup to complete the interaction$")
	public void launch_warpup_to_complete_the_interaction() {

		interaction.launchWrapup();

	}

	@When("^complete the wrap up$")
	public void complete_the_wrap_up() {

		interaction.completeWrapUpWithoutReason();

		CRMObjectsBean.getObjectsMap().put("caseids", caseId);
	}

	@When("^complete the wrap up and verify reason \"([^\"]*)\"$")
	public void complete_the_wrap_up_and_verify_reason(String reason) {
		pegaDriver.waitForDocStateReady();
		interaction.completeWrapUp(reason);
		CRMObjectsBean.getObjectsMap().put("caseids", caseId);
	}

	@Then("^verifiy left nav, header, composites, dialogs and other sections$")
	public void verifiy_left_nav_header_composites_dialogs_and_other_sections() {
		
		pegaDriver.waitForDocStateReady();
		Assert.assertTrue("phone field is not present", interaction.verifyElement(By.xpath(PhoneCall.PHONE_XPATH)));
		Assert.assertTrue("Email Field is not present", interaction.verifyElement(By.xpath("//span[text()='Email']")));
		
		Assert.assertTrue("Chrun risk is not present", interaction.verifyElement(By.xpath(PhoneCall.CHURN_RISK_XPATH)));
		Assert.assertTrue("Lifetime Value is not present",
				interaction.verifyElement(By.xpath(PhoneCall.LIFETIME_XPATH)));
		

		

		Assert.assertTrue("Add Task button is not present",
				interaction.verifyElement(By.xpath("//button[contains(@title,'Add')]")));
		Assert.assertTrue("Wrap up button is not present", interaction
				.verifyElement(By.xpath("//button[@data-test-id='2018080902461007071328']")));
		Assert.assertTrue("Summary tab is not present", interaction.verifyElement(By.xpath("//*[text()='Overview']")));
		Assert.assertTrue("Open service case section is not present",
				interaction.verifyElement(By.xpath("//*[text()='Recent tasks']")));
		Assert.assertTrue("Recent Interactions section is not present",
				interaction.verifyElement(By.xpath("//*[text()='Recent interactions']")));
		interaction.verifyElement(By.xpath("//*[text()='Authorized contacts']"));

	}

	@When("^select \"([^\"]*)\" account number and submit$")
	public void select_account_number_and_submit(String accountNumber) {
		interaction.accountSelection(accountNumber);
	}

	@Then("^verify \"([^\"]*)\" flow is launched$")
	public void verify_flow_is_launched(String serviceProcess) {

		String INPROGESS_LABEL_XPATH = "//a[contains(text(),'#serviceProcess#')]";
		String finalXPathInProgress = new String(INPROGESS_LABEL_XPATH).replace("#serviceProcess#", serviceProcess);
		Assert.assertTrue(serviceProcess + "In Progress Label is not present",
				interaction.verifyElement(By.xpath(finalXPathInProgress)));

		/* interaction.clickOnToolsMenuButton(); */

		interaction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.WHERE_AM_I_XPATH)));
		Assert.assertTrue("History and Attachment option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", interaction.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));

		Assert.assertTrue("Refresh menu option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.REFRESH_XPATH)));
		Assert.assertTrue("Cancel this work menu option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.CANCEL_WORK_XPATH)));
		Actions action = new Actions(pegaDriver.getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();

	}

	@When("^Confirm the flow$")
	public void confirm_the_flow() {
		interaction.confirmFlow();
	}

	@Then("^verify dialog, FA header and other options for Schedule Activity$")
	public void verify_dialog_FA_header_and_other_options_for_Schedule_Activity() {
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'schedule')]"))
				.getText();
		System.out.println(dialog);
		Assert.assertEquals("Schedule Activity initial dialog is not present or incorrect",
				"In order to schedule the activity, I'll need a few details from you. ", dialog);
		Assert.assertTrue("Schedule Activity FA header is not present",
				interaction.verifyElement(By.xpath("//label[contains(text(),'Schedule activity')]")));
		Assert.assertTrue("In Schedule Activity Conference call is not present",
				interaction.verifyElement(By.xpath("//div[text()='Conference call']")));
		Assert.assertTrue("In Schedule Activity Appointment is not present",
				interaction.verifyElement(By.xpath("//div[text()='Appointment']")));
		Assert.assertTrue("In Schedule Activity Task is not present",
				interaction.verifyElement(By.xpath("//div[text()='Task']")));
	}

	@Then("^verify that \"([^\"]*)\" flow is launched with dialog$")
	public void verify_that_flow_is_launched_with_dialog(String serviceProcess) throws Throwable {

		if (serviceProcess == "Address change") {
			Assert.assertTrue("Address change flow header is not present",
					interaction.verifyElement(By.xpath("//label[contains(text(),'Address Change')]")));
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Address Change flow dialog is not present or incorrect",
					"May I have the new address and phone number for your Individual account, please?", dialog);
		} else if (serviceProcess == "Statement Copy") {
			Assert.assertTrue("Address change flow header is not present",
					interaction.verifyElement(By.xpath("//label[contains(text(),'Recent Statements')]")));
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Address Change flow dialog is not present or incorrect",
					"Which statements would you like to receive copies of, Ms. Connor?", dialog);
			Assert.assertTrue("Flow action header message is not present", interaction
					.verifyElement(By.xpath("//div[text()='Select the statements requested by the customer:']")));
		}

		else if (serviceProcess == "Schedule appointment") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Appointment dialog is not present or incorrect",
					"         Please enter  details for the Appointment     ", dialog);

		}

		else if (serviceProcess == "Add New Organization") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Add new organization dialog is not present or incorrect",
					"Can you spell the name of your business for me? And, what is the company's primary address?",
					dialog);
		} else if (serviceProcess == "Create lead") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();

			Assert.assertEquals("Create Lead dialog is not present or incorrect",
					"Thank you for your interest in our products, Ms. Connor. Let me collect some details from you so that a sales person can contact you.",
					dialog);
		} else if (serviceProcess == "Modify account links") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();

			Assert.assertEquals("Modify Account links dialog is not present or incorrect",
					"I can add or delete an account link. Can you give me the account number of the account you'd like me to link or unlink to your profile?",
					dialog);
		}

		else if (serviceProcess == "Primary Communication") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();

			Assert.assertEquals("PrimaryCommunication dialog is not present or incorrect",
					"What is the primary phone number? Do you have a general email or fax number that I should record?",
					dialog);
		}

		else if (serviceProcess == "Schedule appointment") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();

			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Please enter details for the Appointment", dialog);
		}

		else if (serviceProcess == "Offer negotiator") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();

			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Hi Ms. Connor, before I close your account, can I ask you a few questions about your experience with us as your provider?",
					dialog);
		}

		else if (serviceProcess == "Make offer") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();

			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Would you be interested in learning more about our Cash Rewards promotion ?", dialog);
		}

		else if (serviceProcess == "Dispute Transaction") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();

			Assert.assertEquals("Dispute Transaction dialog is not present or incorrect",
					"Which transaction were you concerned about  Ms. Connor?", dialog);
		}
		// caseId.add(phoneInteraction.getCaseID());

	}

	@Then("^verify the contact displayed$")
	public void verify_the_contact_displayed() throws Throwable {
		Assert.assertTrue("search results are not present",
				interaction.verifyElement(By.xpath("//span[text()='Lake']")));
		Assert.assertTrue("search results are not present",
				interaction.verifyElement(By.xpath("//span[text()='Jennifer']")));
		Assert.assertTrue("search results are not present",
				interaction.verifyElement(By.xpath("//span[text()='Easton']")));
		Assert.assertTrue("search results are not present", interaction.verifyElement(By.xpath("//span[text()='MD']")));
	}

	@Then("^Verify the dialog, FA header, message displayed$")
	public void verify_the_dialog_FA_header_message_displayed() throws Throwable {
		String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
		System.out.println(dialog);
		Assert.assertEquals("Select Account dialog is not present or incorrect",
				"Is there an account you are calling about today?", dialog);
		Assert.assertTrue("Select an Account FA header is not present",
				interaction.verifyElement(By.xpath("//span[text()='Select an account']")));
		Assert.assertTrue("Select an account flow action dialog is not present",
				interaction.verifyElement(By.xpath("//div[contains(text(),'Select an account for')]")));
		Assert.assertTrue("Select an account flow action dialog is not present",
				interaction.verifyElement(By.xpath("//div[contains(text(),'or press Submit to continue')]")));

		phoneInteraction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.WHERE_AM_I_XPATH)));
		Assert.assertTrue("Refresh menu option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.REFRESH_XPATH)));
		Assert.assertTrue("Exit Interaction option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.EXIT_INTE_XPATH)));
		Assert.assertTrue("History and Attachment option is not present",
				interaction.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", interaction.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));
	}

	@When("^select \"([^\"]*)\" and options as account \"([^\"]*)\" topic \"([^\"]*)\" Assign to \"([^\"]*)\" and name \"([^\"]*)\"$")
	public void select_and_options_as_account_topic_Assign_to_and_name(String type, String account, String topic,
			String assign, String operator) throws Throwable {
		phoneInteraction.scheduleActivity(type, account, topic, assign, operator);
	}

	@Then("^Confirm the case details$")
	public void confirm_the_case_details() throws Throwable {
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'scheduled')]"))
				.getText();
		System.out.println(dialog);
		Assert.assertEquals("Schedule Activity confirm flow dialog is not present or incorrect",
				"I've scheduled your request, Mrs. Lake.", dialog);
		Assert.assertTrue("Schedule activity  is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Schedule Activity']")));
	}

	@Then("^verify Connor name and Interaction title and dialog$")
	public void verify_Connor_name_and_Interaction_title_and_dialog() throws Throwable {
		pegaDriver.handleWaits()
				.waitForElementVisibility(By.xpath("//span[contains(text(),'Sara') and contains(text(),'Connor')]"));
		Assert.assertTrue("Account Name is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Sara') and contains(text(),'Connor')]")));

	}

	@Then("^Verify all the details for \"([^\"]*)\" Account number$")
	public void verify_all_the_details_for_Account_number(String AccountNumber) throws Throwable {

		// span[regex:contains(text(),'^[A-Za-z]{1,}\s[0-9]{1,}[,]\s[0-9]{1,}$')]

		if (AccountNumber == "1234500078963456") {
			Assert.assertTrue("Credit Card header are not present",
					interaction.verifyElement(By.xpath("//span[contains(text(),'Credit Card')]")));
			Assert.assertTrue("Account Owner name header are not present",
					interaction.verifyElement(By.xpath("//p[contains(text(),'Sara Connor')]")));
		}

		if (AccountNumber == "111110000") {
			Assert.assertTrue("Credit Card header are not present",
					interaction.verifyElement(By.xpath("//span[contains(text(),'Commercial Checking')]")));
			Assert.assertTrue("Account Owner name header are not present",
					interaction.verifyElement(By.xpath("//p[contains(text(),'Acme Software ')]")));

		}

		// Account field
		Assert.assertTrue("Account header are not present",
				interaction.verifyElement(By.xpath("//div[label[contains(text(),'Account #')]]")));
		Assert.assertTrue("Account number header are not present",
				interaction.verifyElement(By.xpath("//a[contains(text(),'" + AccountNumber + "')]")));
		Assert.assertTrue("Account type header are not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Account type')]")));

		// Assert.assertTrue("Account Owner header are not
		// present",interaction.verifyElement(By.xpath("//span[contains(text(),'Account
		// owner')]")));

		Assert.assertTrue("Edit link is not present",
				interaction.verifyElement(By.xpath("//a[contains(text(),'Edit')]")));

		// Balance field
		Assert.assertTrue("Status header is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Status')]")));
		Assert.assertTrue("Active header is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Active')]")));
		Assert.assertTrue("Last statement date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Last statement date')]")));
		Assert.assertTrue("Next statement date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Next statement date')]")));

		// Payment date
		Assert.assertTrue("Payment date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Payment date')]")));
		Assert.assertTrue("Last payment amount is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Last payment amount')]")));
		Assert.assertTrue("Last payment posted is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Last payment posted')]")));
		Assert.assertTrue("YTD payments is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'YTD payments')]")));

		// Min payment
		//Assert.assertTrue("Min. payments is not present",
		//		interaction.verifyElement(By.xpath("//span[contains(text(),'Min. payment')]")));
		Assert.assertTrue("Min. payments is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Available balance')]")));
		Assert.assertTrue("Avg monthly balance is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Avg monthly balance')]")));
		Assert.assertTrue("Account open date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Account open date')]")));
	}

	@Then("^verify the tabs in \"([^\"]*)\" widget$")
	public void verify_the_tabs_in_widget(String widgetName) throws Throwable {

		if (widgetName.equalsIgnoreCase("Transaction")) {
			Assert.assertTrue("Date field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Date']")));
			Assert.assertTrue("Txn ID field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Transaction id']")));
			Assert.assertTrue("Merchant field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Merchant']")));
			// Assert.assertTrue("Txn amount field is not
			// present",interaction.verifyElement(By.xpath("//div[@class='cellIn ' and
			// text()='Transaction amount']")));
			Assert.assertTrue("Txn amount field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Amount']")));
		}

		if (widgetName.equalsIgnoreCase("Statements")) {
			Assert.assertTrue("Month field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Month']")));
			Assert.assertTrue("Start balance field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Start balance']")));
			Assert.assertTrue("End balance field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='End balance']")));
		}
	}

	@Then("^Select the Stage as \"([^\"]*)\" and Rating as \"([^\"]*)\" and submit$")
	public void select_the_Stage_as_and_Rating_as_and_submit(String Stage, String Rating) throws Throwable {
		DropDown leadStage = interaction.findSelectBox(By.xpath("//select[@id='LeadStage']"));
		leadStage.selectByValue(Stage);
		DropDown leadRating = interaction.findSelectBox(By.xpath("//select[@id='LeadRating']"));
		leadRating.selectByValue(Rating);

		PegaWebElement submitButton = interaction.findElement(By.xpath(OK_BUTTON_XPATH));
		submitButton.click();
	}

	@When("^user switches to \"([^\"]*)\" tab$")
	public void user_switches_to_tab(String tab) throws Throwable {
		interaction.userSwitchToTab(tab);
	}

	@When("^Select \"([^\"]*)\" statement  and submit$")
	public void select_statement_and_submit(String transaction) throws Throwable {
		interaction.selectDisputeTransaction(transaction);
	}

	@Then("^Verify Dialog, amount and In-progress task for \"([^\"]*)\" statement$")
	public void verify_Dialog_amount_and_In_progress_task_for_statement(String disputeId) throws Throwable {

		// String dialog =
		// interaction.findElement(By.xpath("//div[@id='DialogContent']")).getText();
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'charge')]"))
				.getText();

		if (disputeId.equalsIgnoreCase("1029")) {

			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					"I see the $ 29.74 charge for North Western Power Supply , Ms. Connor. Can you tell me the reason for this dispute?",
					dialog);
		}

		if (disputeId.equalsIgnoreCase("2083")) {

			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					// "I see the $ 349.87 charge for Torento Auto Finance , Ms. Connor. Can you
					// tell me the reason for this dispute?", dialog);
					"I see the $ 349.87 charge for Torento Auto Finance, Ms. Connor. Can you tell me the reason for this dispute?",
					dialog);
		}

		if (disputeId.equalsIgnoreCase("2089")) {

			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					"I see the $ 129.74 charge for Volvo Auto Parts, Ms. Connor. Can you tell me the reason for this dispute?",
					dialog);
		}

		if (disputeId.equalsIgnoreCase("8026")) {

			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					"I see the $ 1566.32 charge for Celebrity Travel Ms. Connor. Can you tell me the reason for this dispute?",
					dialog);
		}
		if (disputeId.equalsIgnoreCase("1578")) {

			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					"I see the $ 322.00 charge for Hyundai Finance Limited, Ms. Connor. Can you tell me the reason for this dispute?",
					dialog);
		}

		Assert.assertTrue("In progress Dispute Transaction field is not present",
				interaction.verifyElement(By.xpath("//a[contains(@title,'Dispute transaction')]")));

		Assert.assertTrue("Dispute Transaction flow action header is not present",
				interaction.verifyElement(By.xpath("//label[contains(text(),'Dispute transaction')]")));

	}

	@When("^Select a dispute \"([^\"]*)\" and submit$")
	public void select_a_dispute_and_submit(String reason) throws Throwable {
		interaction.selectReasonForDispute(reason);
	}

	@Then("^Verify the \"([^\"]*)\" status displayed$")
	public void verify_the_status_displayed(String status) throws Throwable {
		String Initial_Xpath = "//div[@class='field-item dataValueRead']/span[contains(text(),'#statustype#')]";
		String Final_XPath = new String(Initial_Xpath).replace("#statustype#", status);
		Assert.assertTrue("Status is not present", interaction.verifyElement(By.xpath(Final_XPath)));
	}

	@When("^Confirm the Dispute transaction flow$")
	public void confirm_the_Dispute_transaction_flow() throws Throwable {
		interaction.confirmDisputeDetails();
	}

	@Then("^Verify \"([^\"]*)\" count is for Dispute Transaction is displayed$")
	public void verify_count_is_for_Dispute_Transaction_is_displayed(String count) throws Throwable {
		String Initial_Xpath = "//span[text()='(#total#)']";
		String Final_XPath = new String(Initial_Xpath).replace("#total#", count);

		Assert.assertTrue("Count is not present", interaction.verifyElement(By.xpath(Final_XPath)));
	}
	
	@When("^Search for the Customer with email \"([^\"]*)\" and lastname \"([^\"]*)\"$")
	public void search_for_the_Customer_with_email_and_lastname(String email, String lastname) throws Throwable {
		interaction.searchCustomerByEmaillastname(email,lastname);
	}

}
