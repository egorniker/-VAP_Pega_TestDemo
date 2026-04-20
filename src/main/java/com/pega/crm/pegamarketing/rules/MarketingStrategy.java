
package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ConfigureAudienceDialog;
import com.pega.crm.pegamarketing.dialog.ConfigureDialog;
import com.pega.crm.pegamarketing.dialog.ConfigureOfferDialog;
import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.pages.Strategy;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;

public interface MarketingStrategy extends RuleInstance {
	By STRATEGY_NAME_INPUT = By.xpath("//*[@name='$PpyDisplayHarness$pComponent$pComponents$l1$ppyLabel']");
	By CONFIGUE_OBJECTIVE_BUTTON = By.xpath("//a[contains(@data-click,'ConfigureStrategyBuilderObjective')]");
	By CONFIGUE_AUDIENCE_DRIVER_BUTTON = By.xpath("//a[contains(@data-click,'LaunchAudienceCardSelector')]");
	By ERROR_MESSAGE = By.xpath("//span[@id='ERRORMESSAGES_ALL']");
	By DESCRIPTION_INPUT = By.xpath("//*[@name='$PpyDisplayHarness$pComponent$pComponents$l1$ppyDescription']");
	By BUSINESS_ISSUE_DROPDOWN = By.xpath("//*[@name='$PpyDisplayHarness$pComponent$pComponents$l1$pIssueClass']");// id("IssueClass");
	By CONFIGURE_PRIORITY_BUTTON = By.xpath("//a[contains(@data-click,'ConfigurePriorityCalculation')]");
	By PRIORITIZATION_DROPDOWN = By.xpath("//select[contains(@name,'PrioritizationType')]");
	By PROPERTY_NAME_INPUT = By.xpath("//input[contains(@name,'PropertyName')]");
	By ADD_TARGETING_APPROACH_LINK = By.xpath("//a[contains(@data-click,'LaunchConfigureTargetingModal')]");
	By ASSIGN_OFFERS_BUTTON = By.xpath("//a[contains(@data-click,'LaunchOfferCardSelector')]");
	By ACTIONS_BUTTON = By.xpath("//button[text()='Actions']");
	By OPEN_CANVAS_BUTTON = By.xpath(PMXPathUtil.getMenuItemXPath("Open canvas"));
	By SEARCHSTRATEGY = By.xpath("//*[@data-test-id='20160202134136053752179']");
	By VIEW_BTN = By.xpath("//*[@type='button'][contains(text(),'View')]");
	By ALLCATEGORIESLINK = By.xpath("//a[contains(text(),'All categories')]");

	By NEW_CANVAS_STRATEGY_DESCRIPTION = By.xpath("//input[@id='5b93b09c']");
	By NEW_CANVAS_STRATEGY_ISSUE_DROPDOWN = By.xpath("//select[contains(@name,'pyIssue')]");
	By NEW_CANVAS_STRATEGY_GROUP_DROPDOWN = By.xpath("//select[contains(@name,'pyGroup')]");
	By NEW_CANVAS_STRATEGY_CRATE_AND_OPEN_BUTTON = By.xpath("//div[contains(text(),'Create and open')]");
	By CONTEXT_DROPDOWN = By.id("31bd4460");
	By CUSTOMER_CONTAINER_IN_CANVAS= By.xpath("(//*[@data-menuid='GFW_Navigation'])[1]");
	By IMPORT_MENU = By.xpath("//span[contains(text(),'Import')]");
	By PROPOSITIONDATA = By.xpath("//span[contains(text(),'Proposition data')]");
	By PROPOSITIONSHAPE = By.xpath("//*[contains(@id,'Proposition1')]");
	By PROP_NAME_TXT = By.xpath("//*[contains(@type,'text') and contains(@name,'pyMOName')]");
	By OFFER_DRPDOWN = By.xpath("//*[contains(@data-ctl,'Dropdown') and contains(@name,'pyPropositionIdentifier')]");
	By SUBMIT_BTN = By.xpath("//*[@class='pzbtn-mid'][contains(text(),'Submit')]");
	By CUSTOMER_SECTION = By.xpath("//*[@id='ForeachCustomerinCustomer']//*[@class='body']");
	By TARGET_SHAPE = By.xpath("//*[@class='label']//*[contains(text(),'Customer')]");
	By Prop1Connector = By.xpath("//*[contains(@id,'Transition1')]//*[@ns='shape'][2]");


	/**
	 * It will open configure priority dialog
	 * 
	 * @return It will return Configure Priority Dialog
	 */
	ConfigurePriorityDialog configurePriority();

	/**
	 * This will edit prioritization with given prioritization name and
	 * prioritization value
	 * 
	 * @param prioritizationName
	 * @param prioritizationValue
	 */
	void editPrioritization(String prioritizationName, String prioritizationValue);

	/**
	 * It is used for getting reference of CofigureObjectiveDialog
	 * 
	 * @return It will return Configure Objective Dialog
	 */
	ConfigureObjectiveDialog configureObjective();

	/**
	 * This method is for entering strategy name
	 * 
	 * @param strategyName
	 */
	void setStrategyName(String strategyName);

	/**
	 * This method is for entering description
	 * 
	 * @param description
	 */
	void setDescription(String description);

	/**
	 * It is used to check the group checkbox with the name specifiedr
	 * 
	 * @param issueName
	 */
	void setIssue(String issueName);

	/**
	 * It is used to check the group checkbox with the name specifiedr
	 * 
	 * @param groupName
	 */
	void setGroup(String groupName);

	/**
	 *
	 * @param decisionContext - This context will create Customer Strategy in canvas
	 */
	void selectContext(String decisionContext);

	/**
	 * this method will add proposition for customer context
	 */
	void addPropositionShapetoCanvas();

	void connectPropShapeToOutput();

	void rightclickonsubsection();

	void updatepropositinshape(String arg1, String arg2) throws InterruptedException;

	/**
	 * This method is used to open Configure Audience dialog
	 * 
	 * @return
	 */
	ConfigureAudienceDialog configureAudience();

	/**
	 * This methods is used to select Audience Driven as Targeting approach
	 */
	void addAudianceDrivenTargetingApproach();

	/**
	 * This method is used to open Configure Offer dialog
	 * 
	 * @return
	 */
	ConfigureOfferDialog assignOffers();

	/**
	 * This method is used to open canvas view for the strategy
	 * 
	 * @return
	 */
	Strategy openCanvas();

	public interface ConfigureObjectiveDialog extends ConfigureDialog {
		By PRIORITIZATION_ADD_BUTTON = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='PRIORITIZATION']]//button[text()='Add']");
		By RANKED_ADD_BUTTON = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='RANKED']]//button[text()='Add']");
		By RANKED_REMOVE_BUTTON = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='RANKED']]//button[text()='Remove']");
		//By RANKED_ADDED_LABEL = By.xpath("//tr[contains(@id,'ComponentOverview_RANKED')]//a[text()='Offer targeting using Audiences and AI']");
		
		By RANKED_ADDED_LABEL = By.xpath("//tr[contains(@id,'ComponentOverview_RANKED')]//a[text()='Action targeting using Audiences and AI']");
		By PRIORITIZATION_DIVISON = By
				.xpath("//span[contains(text(),'PRIORITIZATION') and @class='mktcard_secondary_info']");

		MarketingStrategy applyPrioritizationOffer();

		void addPrioritizationOffer();

		/**
		 * It is used to add a ranked objective
		 */
		void addRankedObjective();

		/**
		 * it is used to verify if ranked is added in the modal dialog
		 * 
		 * @return
		 */
		boolean isRankedAdded();
	}

	public interface ConfigurePriorityDialog extends ConfigureDialog {
		static By RAWPROPPENSITY_DIV = By
				.xpath("//span[contains(text(),'RawPropensity') and @class='mktcard_secondary_info']");
		static By RAWPROPPENSITY_ADD = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='RawPropensity']]//button[text()='Add']");

		/**
		 * This will apply priority to strategy
		 * 
		 * @return It will return Marketing Strategy page
		 */
		MarketingStrategy applyPriority();

		/**
		 * This will add priority
		 */
		void addPriority();

	}

	public interface AddTargetingDialog extends ModalDialog {
		By AUDIENCE_DRIVEN_RADIO = By.xpath("//label[@for='AudienceTargetingSEGMENTATION']");

		/**
		 * This will check Audience Driven option
		 */
		void checkAudienceDriven();
	}

	String getthenameofstrategy();

	void searchstrategies(String strategy1, String strategy2);

}
