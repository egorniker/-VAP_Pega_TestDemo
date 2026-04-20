package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ImageCatalogDialog;
import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.elmt.Connector;
import com.pega.crm.pegamarketing.elmt.OfferShape;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.crm.pegamarketing.utils.PegaBy;

public interface Offer extends RuleInstance {

	By FLOW_TAB = PegaBy.ruleTab("Flow");
	By DETAILS_TAB = PegaBy.ruleTab("Details");
	//By TESTOFFER_TAB = PegaBy.ruleTab("Test Offer");
	By TESTOFFER_TAB = PegaBy.ruleTab("Test");
	By HISTORY_TAB = PegaBy.ruleTab("History");
	//By ELIGIBILITY_TAB = PegaBy.ruleTab("Eligibility");
	By ELIGIBILITY_TAB = PegaBy.ruleTab("Engagement policy");
	String DIV_PROCESS_FLOW_XPATH = "//div[@id='processFlow_g']";

	String MONAME_XPATH = "//div[@id='modalOverlay' and @style='display: block;']"
			+ "//input[contains(@name,'MOName') and not(@title='Select Ticket')]";
	String DECISIONTYPE_XPATH = "//div[@id='modalOverlay' and @style='display: block;']"
			+ "//select[@id='pyDecisionClass']";

	By SEED_LIST = By.name("$PpyNewResults$pSeedList");
	By STARTING_POINT = By.id("StartingPoint");
	By CHANNEL = By.id("Channel");
	By DIRECTION_INBOUND = By.xpath("//label[text()='Inbound']");
	By DIRECTION_OUTBOUND = By.xpath("//label[text()='Outbound']");
	By REFRESH_TRACK_RESULTS = By.xpath("//button[text()='Refresh']");
	By TEST_OFFER = By.xpath(PMXPathUtil.getButtonPzBtnMidXPath("Test Offer"));
	By OFFER_RESULT_SUCCESS = By.xpath(
			"//div[@node_name='OfferTestResultsGridSection']//tr[contains(@id,'OfferTestResults')]//label[text()='Success!']");
	By OFFER_RESULT_NON_SUCCESS = By.xpath(
			"//div[@node_name='OfferTestResultsGridSection']//tr[contains(@id,'OfferTestResults')]//label[not(contains(text(),'Success!'))]");
	By OFFER_STARTED_SUCCESSFULLY_MESSAGE = By
			.xpath("//div[@node_name='OfferTestRunStatus']//*[text()='Offer test started successfully']");
	By IMAGE_URL_COG = By.xpath("//*[@title='View folder contents']");
	By DELETE_MENU = By.xpath("//*[text()='Delete']");
	By SPECIFY_TREATMENT_OPTION = By.xpath("//label[text()='Specify Treatment']");
	

	public enum Shape {
		SEND_EMAIL("Send Email"), SEND_SMS("Send SMS"), SEND_GENERIC("Send Generic"), SEND_MULTI(
				"Send Multi"), SEND_PASSBOOK("Send Passbook"), END("End"), PUSH_NOTOFICATION(
						"Push Notification"), INBOUND("Inbound"), UPDATE_STATUS("Update Status"), HAND_OFF(
								"Hand Off"), DECISION("Decision"), WAIT("Wait"), SCHEDULE_APPOINTMENT(
										"Smart Shapes:Schedule Appointment"), START("Start");

		private String shapeName;

		Shape(String shapeName) {
			this.shapeName = shapeName;
		}

		public String getName() {
			return shapeName;
		}
	}

	/**
	 * To drag a shape into middle of the flow.
	 * 
	 * @author Bala
	 * @param shape
	 * @return
	 */
	public OfferShape dragShape(Shape shape);

	/**
	 * To drag a shape into middle of the flow.
	 * 
	 * @author Bala
	 * @param shape
	 * @param xEnd
	 * @param yEnd
	 * @return
	 */
	public OfferShape dragShape(Shape shape, int xEnd, int yEnd);

	/**
	 * To drag a shape into middle of the flow.
	 * 
	 * @author Bala
	 * @param shape
	 * @param shapeName
	 *            name of the shape
	 * @return
	 */
	OfferShape dragShape(Shape shape, String shapeName);

	/**
	 * To drag a shape into flow, drop point will be adjusted from middle of flow
	 * based on xEnd and yEnd.
	 * 
	 * @author Bala
	 * @param shape
	 * @param shapeName
	 *            name of the shape
	 * @param xEnd
	 * @param yEnd
	 * @return
	 */
	OfferShape dragShape(Shape shape, String shapeName, int xEnd, int yEnd);

	/**
	 * To find the existing shape in the flow
	 * 
	 * @param shapeName
	 *            name of the Shape
	 * @return
	 */
	OfferShape findShape(String shapeName);

	/**
	 * To find the start shape
	 * 
	 * @return
	 */
	OfferShape findStartShape();

	/**
	 * To find the end shape
	 * 
	 * @return
	 */
	OfferShape findEndShape();

	/**
	 * To set a name to connector
	 * 
	 * @param by
	 *            locator to find the connector
	 * @param connectorName
	 *            new name for the connector
	 */
	void setConnectorName(By by, String connectorName);

	/**
	 * To set names for Start connector. It has to be called before dragging any new
	 * shape into the flow.
	 * 
	 * @param startConnName
	 *            name of the start connector
	 */
	void setStartConnName(String startConnName);

	/**
	 * To find the connector in the flow
	 * 
	 * @param connName
	 *            name of the connector.
	 * @return
	 */
	Connector findConnector(String connName);

	/**
	 * To find the connector in a flow which do not have name assigned to it. For
	 * example, if a connector has only a flag image on it, you can use this method
	 * to find that connector
	 * 
	 * @param byShapeXpath
	 *            by logic to identify that image attached to the connector
	 * @return reference to Connector
	 * @author Bala
	 */
	Connector findConnector(By byShapeXpath);

	public interface ShapeProperties extends ModalDialog {
		By TREATMENT_NAME = By.id("Treatment_Name");
		By SPECIFY_TREATMENT_RADIO = By.xpath("//label[text()='Specify Treatment']");

		/**
		 * this method sets the given name to the current shape
		 * 
		 * @param shapeName
		 *            shape name to be given
		 */
		void setShapeName(String shapeName);

		/**
		 * this method sets the given treatment name in the shape properties
		 * 
		 * @param treatmentName
		 *            treatment name to given
		 */
		void specifyTreatment();
		void setTreatmentName(String treatmentName);
	}

	public interface SendEmailShapeProperties extends ShapeProperties {
		//By ICON_EXPAND_EMAIL_ACCOUNT = By.xpath("//div[@title='Disclose Email Account']/i");
		//By ICON_EXPAND_EMAIL_ACCOUNT = By.xpath("//div[@title='Disclose Email account']");
		By ICON_EXPAND_EMAIL_ACCOUNT = By.xpath("//div[@title='Email account']/i");
		By SPECIFY_EMAIL_ACCOUNT_RD_BTN = By.xpath("//label[text()='Specify Email Account']");
		By EMAIL_ACCOUNT_INPUT = By.id("EmailAccount");

		/**
		 * this method sets the given EmailAccount account in Send Email shape
		 * properties
		 * 
		 * @param emailAccount
		 *            email account to be added
		 */
		void setEmailAccount(String emailAccount);

	}

	public interface SendSMSShapeProperties extends ShapeProperties {

		By ICON_EXPAND_SMS_ACCOUNT = By.xpath("//div[@title='Disclose Email Account']/i");
		By SPECIFY_SMS_ACCOUNT_RD_BTN = By.xpath("//label[text()='Specify SMS Account']");
		By SMS_ACCOUNT_INPUT = By.id("SMSAccount");

		/**
		 * this method sets the given SMS account in SMS shape properties
		 * 
		 * @param SMSAccount
		 *            account to be added
		 */
		void setSMSAccount(String SMSAccount);
	}

	/**
	 * sets the seedlist text input on test offer tab
	 * 
	 * @param seedlist
	 */
	void setSeedList(String seedlist);

	/**
	 * selects the given starting point on test offer tab
	 * 
	 * @param startingPoint
	 */
	void selectStartingPoint(String startingPoint);

	/**
	 * selects the given channel on test offer tab
	 * 
	 * @param channel
	 */
	void selectChannel(String channel);

	/**
	 * sets the provided direction Inbound/Outbound
	 * 
	 * @param direction
	 */
	void setDirection(String direction);

	/**
	 * Refreshes the track results by hitting the refresh button
	 */
	void refreshTrackResults();

	/**
	 * Tests the offer by clicking Test Offer button
	 */
	void testOffer();

	void clickDetails();

	ImageCatalogDialog clickImageURLCog();

	public void DeleteMenuClick();
}
