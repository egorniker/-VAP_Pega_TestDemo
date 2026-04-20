/*
 * $Id$
 *
 * Copyright (c) 2018  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
*/

package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.crm.pegamarketing.utils.PegaBy;

public interface Campaign extends RuleInstance {

	//By CREATE_CAMPAIGN_LANDING_PAGE_HEADER = By.xpath("//span[text()='Create a campaign']");
	By CREATE_CAMPAIGN_LANDING_PAGE_HEADER = By.xpath("//span[text()='Create a campaign']");
	By NAME_INPUT_BOX = By.xpath("//input[@id='pyLabel']");

	By DRAFT_LABEL = By.xpath("//span[text()='Draft']");
	By CAMPAIGN_NAME_LABEL = By.xpath("//*[@class='case_title']");
	By CONFIGURE_MARKETING_STRATEGY_BUTTON = By
			.xpath("//button[contains(@name,'StrategyContainer')and text()='Configure']");
	By CONFIGURE_AUDIENCES_BUTTON = By.xpath("//button[contains(@name,'AudienceContainer')and text()='Configure']");
	By CONFIGURE_ENGAGEMENT_BUTTON = By.xpath("//button[contains(@name,'EngagementContainer')and text()='Configure']");
	By CONFIGURE_ENGAGEMENTCRITERIA_LINK = By.xpath("//a[@data-test-id='20180613150300055046627']");
	By CONFIGURE_OUTCOMEOPTIMIZATION_LINK = By.xpath("//a[@data-test-id='20180613150541022527360']");
	By CONFIGURE_TIMEFRAME_LINK = By.xpath("//a[@data-test-id='20180613150751025236810']");
	By CONFIGURE_CAMPAIGNDETAILS_LINK = By.xpath("//a[@data-test-id='20180613150937071239122']");
	By SELECT_OFFERS_LINK = By.xpath("//a[text()='Select offers']");
	By OFFERS_SELECTED_LINK = By
			.xpath("//a[@data-test-id='20180521145746073021783' and contains(text(), 'offers selected')]");
	By OPTIMIZED_CAMPAIGN_AUDIENCE_LABEL = By.xpath("//div[text()='Audience size']");
	By OPTIMIZED_CAMPAIGN_OUTCOME_LABEL = By.xpath("//span[@data-test-id='2018052210291800557701']");
	By OPTIMIZED_CAMPAIGN_STARTDATE_LABEL = By.xpath("//span[@data-test-id='20180521170600085927747']");
	By OPTIMIZED_CAMPAIGN_ENDDATE_LABEL = By.xpath("//span[@data-test-id='20180614150038045143445']");
	By OPTIMIZED_CAMPAIGN_WAVE_CHART = By.xpath("//span[@class='fusioncharts-container']");
	By STRATEGY_NAME_LABEL = By.xpath("//a[(@class='GuidedProgram_Card_name')]");
	static By SEGMENT_NAME_LABEL = By.xpath("//a[(@class='MKTCard_title_card')]");
	static By ONE_TIME_ONLY_ENGAGEMENT = By.xpath("//span[text()='One-time only']");
	static By ENGAGEMENT_CAMPAIGN_SCHEDULE_LABEL = By.xpath("//span[text()='Campaign schedule']");
	By CONFIRM_BUTTON = By.xpath("//button[text()='Confirm']");
	By RUNNING_LABEL = By.xpath("//span[text()='Running']");
	By ACTIONS_BUTTON = By.xpath("//button[text()='Actions']");
	By REFRESH_LINK = By.xpath("//span[text()='Refresh']");
	By STATUS_LABEL = By.xpath("//div[contains(@class,'badge-bg-good')]//span[@class='badge_text']");
	By RUN_ERROR_MESSAGE = By.xpath("//div[contains(text(),'A campaign run has failed')]");
	By RUN_BUTTON = By.xpath("//span[text()='Run']");
	By ADD_SEGMENT_LINK = By.xpath("//img[contains(@name,'AudienceContainer')]");
	By ADD_OFFER_LABEL = By.xpath("//*[text()='Add Offer']");
	By ADD_FLOW_LABEL = By.xpath("//*[text()='Add Flow']");
	By RUN_NOW_RADIO_BTN = By.xpath("//label[contains(@class,'radioLabel') and text()='Run now']");
	By STATUS_HEADER_RUNNING = By.xpath("//div[@node_name='CampaignStatusIndicator'][.//*[text()='Running']]");
	By SUBMIT_FOR_EXECUTION_BUTTON = By.xpath(PMXPathUtil.getMenuItemXPath("Submit for Execution"));
	By VALIDATE_CAMPAIGN_BUTTON = By.xpath(PMXPathUtil.getMenuItemXPath("Validate"));
	By VALIDATION_NO_ERRORS_EXECUTION_LINK = By.xpath("//a[@data-test-id='2017121117230206955829']");
	By SEARCHCAMPAIGN = By.xpath("//input[@data-test-id='201411141635100877648']");
	By VIEW_BTN = By.xpath("//*[@type='button'][contains(text(),'View')]");
	By ALLCATEGORIESLINK = By.xpath("//a[contains(text(),'All categories')]");
	By CONFIGURETIMEFRAME_HEADER = By.xpath("//span[@id='modaldialog_hd_title'][contains(.,'Configure Time')]");

	/**
	 * it is used to edit campaign
	 */

	void editCampaign();

	/**
	 * this will open configure Audience Dialog
	 * 
	 * @return returns Configure Audience Dialog
	 */
	ConfigureAudienceDialog configureAudience();

	/**
	 * this will open configure Engagement Dialog
	 * 
	 * @return returns Configure Engagement Dialog
	 */
	ConfigureEngagementDialog configureEngagement();

	/**
	 * this will open Configure Engagement Criteria Dialog
	 * 
	 * @return returns Configure Engagement Criteria Dialog
	 */
	ConfigureEngagementCriteriaDialog configureEngagementCriteria();

	/**
	 * this will open Configure Offers Dialog for Engagement Criteria
	 * 
	 * @return returns Configure Offers Dialog
	 */
	CampaignConfigureDialog configureEngagementOffers();

	/**
	 * this will open Configure Outcome Optimization Dialog
	 * 
	 * @return returns Configure Outcome Optimization Dialog
	 */
	CampaignConfigureDialog configureOutcomeOptimization();

	/**
	 * this will open Configure Timeframe Dialog
	 * 
	 * @return returns Configure Timeframe Dialog
	 */
	ConfigureTimeframeDialog configureTimeframe();

	/**
	 * this will open Configure Details Dialog
	 * 
	 * @return returns Configure Details Dialog
	 */
	ConfigureDetailsDialog configureDetails();

	/**
	 * This will validate campaign
	 */
	void validateCampaign();

	/**
	 * This will run campaign
	 */
	void runCampaign();

	/**
	 * This will refresh the campaign run
	 */
	void refreshRunStatus();

	/**
	 * this is used to check given status
	 * 
	 * @param statusToBeChecked
	 * @return returns true if given status is achieved
	 */
	boolean checkRunStatus(String statusToBeChecked);

	/**
	 * this will confirm the action taken for the campaign
	 */
	void confirmAction();

	/**
	 * this will open configure Marketing Strategy Dialog
	 * 
	 * @return returns Configure Marketing Strategy Dialog
	 */
	ConfigureMarketingStrategyDialog configureMarketingStrategy();

	/**
	 * Opens ConfigureAudienceDialog from EmailOutbound campaign after clicking on
	 * add Segment link
	 * 
	 * @return ConfigureAudience modal dialog
	 */
	ConfigureAudienceDialog addSegment();

	/**
	 * Opens ConfigureCardDialog from EmailOutbound campaign after clicking on add
	 * Offer link
	 * 
	 * @return ConfigureCard modal Dialog
	 */
	ConfigureCardDialog addOffer();

	public interface CampaignConfigureDialog extends ModalDialog {

		//By SEARCH_INPUT = PegaBy.testId("201411141635100877648");
		By SEARCH_INPUT = By.xpath("//span[(@data-control-mode='input')]//*[contains(@name,'$PD_MKTMultiSelectCardSelector')]"); 
		By SEARCH_ICON = By.xpath("//*[contains(@class,'pi-search')]");
		By DIALOG_HEADER = By.xpath("//span[@id='modaldialog_hd_title']");
		By ADD_BUTTON = By.xpath("//button[text()='Add']");
		By FIRST_ADD_BUTTON = By
				.xpath("(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]");
		By STRATEGY_SEARCH_RESULT = By.xpath("//span[contains(@class,'primary_info')]");
		By REMOVE_BUTTON = By.xpath("//button[text()='Remove']");
		By STRATEGY_LINK = By.xpath("//a[@data-ctl = 'Link' and contains(@name,'ListCardGroup')]");
		By DELETE_ICON = By.xpath("//a[(@class='iconDelete')]");
		By ISSUE_GROUP_DETAILS_TEXT = By.xpath("//span[(@class='strong')]");

		/**
		 * this method adds given rule (like segment,strategy,etc) from search results
		 * 
		 * @param ruleName(like
		 *            segment,strategy,etc)
		 */

		void addRule(String ruleName);

		/**
		 * this method searches for the rule that contains given search text
		 * 
		 * @param searchText
		 *            is a char sequence used to search
		 */
		void search(String strategyName);

		/**
		 * this will verify whether segment is added successfully
		 * 
		 * @return it will return true if remove button and delete button is present
		 */
		boolean isSegmentAdded();
	}

	public interface ConfigureCardDialog extends CampaignConfigureDialog {

		By FIRST_SEARCH_RESULT_LABEL = By.xpath("//span[@class='guidedprogram_card_header_description']");

		/**
		 * This selects first item from available search results for Outbound campaign
		 */
		void selectFromFirstSearchResult();

	}

	public interface ConfigureAudienceDialog extends CampaignConfigureDialog {
		By FIRST_SEARCH_RESULT_LABEL = By.xpath("//span[@class='guidedprogram_card_header_description']");
		By FIRST_SEARCH_RESULT = By.xpath("//*[@class='mktcard_secondary_info']");

		/**
		 * This will add first segment from search results available
		 */
		void addFirstSegment();

		/**
		 * This will select first search result from listed search results for
		 * multichannel campaign
		 */
		void selectFirstSearchResult();

		/**
		 * This will select first search result from listed search results for outbound
		 * campaign
		 */
		void selectFromFirstSearchResult();
	}

	/**
	 * This will select run now radio button
	 */
	void selectRunNow();

	public interface ConfigureMarketingStrategyDialog extends CampaignConfigureDialog {

	}

	public interface ConfigureEngagementDialog extends CampaignConfigureDialog {
		static By CAMAPIGN_SCHEDULE_CHECKBOX = By
				.xpath("//input[contains(@name,'EnableScheduling')][@type='checkbox']");
		static By CAMPAIGN_SCHEDULE_LABEL = By.xpath("//label[@for='EnableScheduling']");
		static By REAL_TIME_EVENTS_CHECKBOX = By.xpath("//input[@id='EnableEvents']");
		static By REAL_TIME_EVENTS_LABEL = By.xpath("//label[@for='EnableEvents']");
		static By REAL_TIME_CONTAINERS_CHECKBOX = By.xpath("//input[@id='EnableContainers']");
		static By REAL_TIME_CONTAINERS_LABEL = By.xpath("//label[@for='EnableContainers']");
		//static By START_ON_TIME_TEXT = PegaBy.testId("201508141643030248152902-Label");
		static By START_ON_TIME_TEXT = By.xpath("//input[@id='979f6eb1']");
		static By ONE_TIME_RADIO_BUTTON = By.xpath("//input[contains(@name,'MAFrequency')][@value='O']");
		static By RECURRING_RADIO_BUTTON = By.xpath("//input[contains(@name,'MAFrequency')][@value='R']");
		static By REFRESH_AUDIENCE_CHECKBOX = By
				.xpath("//input[contains(@name,'RefreshStartingPopulation')][@type='checkbox']");
		static By WRITE_CAMPAIGN_CHECKBOX = By.xpath("//input[contains(@name,'DirectDBTemplate')][@type='checkbox']");

		/**
		 * to check Campaign schedule checkbox
		 */
		void checkCampaignSchedule();

		void clickonrefreshaudience();
	}

	/**
	 * This class supports the modal dialog for configuring the Engagement Criteria
	 * on a Self-optimizing campaign.
	 */
	public interface ConfigureEngagementCriteriaDialog extends ModalDialog {
		static By AUDIENCE_SIZE_INPUT = By.xpath("//input[@id='AudienceSize']");
		static By CONTROLGROUP_SIZE_INPUT = By.xpath("//input[@id='ControlGroupSize']");

		/**
		 * Enters the audience size as an integer into the Engagement Criteria dialog
		 * for a Self-optimizing Campaign.
		 * 
		 * @param audienceSize
		 *            Size of the audience for the Campaign, as an integer.
		 */
		void enterAudienceSize(Integer audienceSize);

		/**
		 * Enters the control group size as a decimal into the Engagement Criteria
		 * dialog for a Self-optimizing Campaign.
		 * 
		 * @param controlGroupSize
		 *            Size of the control group in decimal, as a percentage of the
		 *            Campaign audience.
		 */
		void enterControlGroupSize(Double controlGroupSize);
	}

	/**
	 * This class supports the modal dialog for configuring the Timeframe on a
	 * Self-optimizing campaign.
	 */
	public interface ConfigureTimeframeDialog extends ModalDialog {
		static By TIMEFRAME_DATE_INPUT = By.xpath("//input[@data-test-id='20180521142116010439637']");

		/**
		 * Enters a date into the Timeframe dialog for a Self-optimizing Campaign. This
		 * date can be used as either the start or end date.
		 * 
		 * @param date
		 *            The start or end date for the Campaign. Defaulted to start date,
		 *            drop-down must be changed to make it an end date.
		 */
		void enterTimeframeDate(String date);
	}

	/**
	 * This class supports the modal dialog for configuring the details on a
	 * Self-optimizing campaign. This includes the required Name field as well as
	 * key code, financial information, and goals.
	 */
	public interface ConfigureDetailsDialog extends ModalDialog {
		static By CAMPAIGN_NAME_INPUT = By.xpath("//input[@data-test-id='201505151039200042663255']");
		static By CAMPAIGN_KEYCODE_INPUT = By.xpath("//input[@data-test-id='201505151039200050677743']");

		/**
		 * Enters a name into the Campaign Details dialog for a Self-optimizing
		 * Campaign. This is a required field for Campaigns.
		 * 
		 * @param campaignName
		 *            The name, as a string, for the Campaign.
		 */
		void enterCampaignName(String campaignName);

		/**
		 * Enters a key code into the Campaign Details dialog for a Self-optimizing
		 * Campaign. This field may return a warning for Campaigns if not set.
		 * 
		 * @param campaignKeycode
		 *            The key code, as a string, for the Campaign.
		 */
		void enterCampaignKeycode(String campaignKeycode);
	}

	String getthenameofcampaign();

	void searchcampaigns(String campaignName, String campaignName1);

	void setCampaignRuleName(String campaignName);

}
