package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.rules.Campaign;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.elmt.Frame;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped

public class PegaCampaign extends PegaRuleInstance implements Campaign {

	public PegaCampaign(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void editCampaign() {
		findElement(RuleInstance.EDIT_BUTTON).click();
	}

	public ConfigureMarketingStrategyDialog configureMarketingStrategy() {
		findElement(CONFIGURE_MARKETING_STRATEGY_BUTTON).click();
		ConfigureMarketingStrategyDialog confgMarketingStrategy = new PegaConfigureMarketingStrategyDialog(this);
		return confgMarketingStrategy;
	}

	public ConfigureAudienceDialog configureAudience() {
		findElement(CONFIGURE_AUDIENCES_BUTTON).click();
		ConfigureAudienceDialog configureAudienceDialog = new PegaConfigureAudienceDialog(this);
		return configureAudienceDialog;
	}

	public ConfigureEngagementDialog configureEngagement() {
		findElement(CONFIGURE_ENGAGEMENT_BUTTON).click();
		ConfigureEngagementDialog configureEngagementDialog = new PegaConfigureEngagementDialog(this);
		return configureEngagementDialog;
	}

	public ConfigureEngagementCriteriaDialog configureEngagementCriteria() {
		findElement(CONFIGURE_ENGAGEMENTCRITERIA_LINK).click();
		return new PegaConfigureEngagementCriteriaDialog(this);
	}

	public CampaignConfigureDialog configureEngagementOffers() {
		findElement(SELECT_OFFERS_LINK).click();
		return new PegaCampaignConfigureDialog(this);
	}

	public CampaignConfigureDialog configureOutcomeOptimization() {
		findElement(CONFIGURE_OUTCOMEOPTIMIZATION_LINK).click();
		return new PegaCampaignConfigureDialog(this);
	}

	public ConfigureTimeframeDialog configureTimeframe() {
		findElement(CONFIGURE_TIMEFRAME_LINK).click();
		return new PegaConfigureTimeframeDialog(this);
	}

	public ConfigureDetailsDialog configureDetails() {
		findElement(CONFIGURE_CAMPAIGNDETAILS_LINK).click();
		return new PegaConfigureDetailsDialog(this);
	}

	public ConfigureCardDialog addOffer() {
		findElement(ADD_OFFER_LABEL).click();
		ConfigureCardDialog configureCardDialog = new PegaConfigureCardDialog(this);
		return configureCardDialog;
	}

	public void validateCampaign() {
		findElement(ACTIONS_BUTTON).click();
		findElement(VALIDATE_CAMPAIGN_BUTTON).click();
	}

	public void runCampaign() {
		if (verifyElement(RuleInstance.RUN_BUTTON)) {
			findElement(RuleInstance.RUN_BUTTON).click();
		} else {
			findElement(ACTIONS_BUTTON).click();
			findElement(SUBMIT_FOR_EXECUTION_BUTTON).click();
		}
	}

	public void refreshRunStatus() {
		findElement(ACTIONS_BUTTON).click();
		findElement(REFRESH_LINK).click();
		pegaDriver.waitForDocStateReady(30);
	}

	public void selectRunNow() {
		findElement(RUN_NOW_RADIO_BTN).click(false);
	}

	public boolean checkRunStatus(String aStatusToBeChecked) {
		boolean status = false;
		for (int i = 1; i <= 15; i++) {
			if (findElement(STATUS_LABEL).getText().equalsIgnoreCase(aStatusToBeChecked)) {
				status = true;
				break;
			}
			refreshRunStatus();
			pegaDriver.handleWaits().sleep(20);
		}
		return status;
	}

	public ConfigureAudienceDialog addSegment() {
		findElement(ADD_SEGMENT_LINK).click();
		ConfigureAudienceDialog configureAudienceDialog = new PegaConfigureAudienceDialog(this);
		return configureAudienceDialog;
	}

	public void confirmAction() {
		findElement(CONFIRM_BUTTON).click();
		pegaDriver.waitForDocStateReady(30);
		pegaDriver.handleWaits().sleep(30);
	}

	public class PegaCampaignConfigureDialog extends PegaModalDialog implements CampaignConfigureDialog {
		PegaWebDriver pegaDriver;
		TestEnvironment testEnv;
		protected Frame frame;

		public PegaCampaignConfigureDialog(Frame frameElmt) {
			super(frameElmt);
			this.frame = frameElmt;
			this.testEnv = frame.getTestEnvironment();
			pegaDriver = testEnv.getPegaDriver();
		}

		public void addRule(String ruleName) {
			frame.findElement(ADD_BUTTON).click();
		}

		public boolean isSegmentAdded() {
			boolean isRemoveFound = frame.verifyElement(REMOVE_BUTTON);
			boolean isDeleteButtonFound = frame.verifyElement(DELETE_ICON);
			return isRemoveFound && isDeleteButtonFound;
		}

		public void search(String ruleName) {
			frame.findElement(SEARCH_INPUT).sendKeys(ruleName);
			frame.findElement(SEARCH_ICON).click();
		}
	}

	public class PegaConfigureCardDialog extends PegaCampaignConfigureDialog implements ConfigureCardDialog {
		Frame frame;

		public PegaConfigureCardDialog(Frame aElmt) {
			super(aElmt);
			frame = aElmt;
		}

		public void selectFromFirstSearchResult() {
			frame.findElement(FIRST_SEARCH_RESULT_LABEL).click(false);
		}
	}

	public class PegaConfigureAudienceDialog extends PegaCampaignConfigureDialog implements ConfigureAudienceDialog {
		TestEnvironment testEnv;
		PegaWebDriver pegaDriver;
		Frame frame;

		public PegaConfigureAudienceDialog(Frame aElmt) {
			super(aElmt);
			frame = aElmt;
		}

		public void selectFirstSearchResult() {
			frame.findElement(FIRST_SEARCH_RESULT).click(false);
		}

		public void addFirstSegment() {
			frame.findElement(FIRST_ADD_BUTTON).click();
		}

		public void selectFromFirstSearchResult() {
			frame.findElement(FIRST_SEARCH_RESULT_LABEL).click(false);
		}

	}

	public class PegaConfigureMarketingStrategyDialog extends PegaCampaignConfigureDialog
			implements ConfigureMarketingStrategyDialog {

		TestEnvironment testEnv;
		PegaWebDriver pegaDriver;

		public PegaConfigureMarketingStrategyDialog(Frame frameElmt) {
			super(frameElmt);
		}

	}

	public class PegaConfigureEngagementDialog extends PegaCampaignConfigureDialog
			implements ConfigureEngagementDialog {
		PegaWebDriver pegaDriver;
		TestEnvironment testEnv;
		Frame frame;

		public PegaConfigureEngagementDialog(Frame aElmt) {
			super(aElmt);
			this.frame = aElmt;
		}

		public void checkCampaignSchedule() {
			frame.findElement(CAMAPIGN_SCHEDULE_CHECKBOX).check();
		}

		@Override
		public void clickonrefreshaudience() {

			frame.findElement(REFRESH_AUDIENCE_CHECKBOX).check();

		}

	}

	/**
	 * This class supports the modal dialog for configuring the Engagement Criteria
	 * on a Self-optimizing campaign.
	 */
	public class PegaConfigureEngagementCriteriaDialog extends PegaModalDialog
			implements ConfigureEngagementCriteriaDialog {

		public PegaConfigureEngagementCriteriaDialog(Frame aElmt) {
			super(aElmt);
		}

		/**
		 * Enters the audience size as an integer into the Engagement Criteria dialog
		 * for a Self-optimizing Campaign.
		 * 
		 * @param audienceSize
		 *            Size of the audience for the Campaign, as an integer.
		 */
		public void enterAudienceSize(Integer audienceSize) {
			pegaDriver.handleWaits().waitForElementVisibility(AUDIENCE_SIZE_INPUT);
			findElement(AUDIENCE_SIZE_INPUT).sendKeys(Integer.toString(audienceSize));
		}

		/**
		 * Enters the control group size as a decimal into the Engagement Criteria
		 * dialog for a Self-optimizing Campaign.
		 * 
		 * @param controlGroupSize
		 *            Size of the control group in decimal, as a percentage of the
		 *            Campaign audience.
		 */
		public void enterControlGroupSize(Double controlGroupSize) {
			pegaDriver.handleWaits().waitForElementVisibility(CONTROLGROUP_SIZE_INPUT);
			findElement(CONTROLGROUP_SIZE_INPUT).clear();
			findElement(CONTROLGROUP_SIZE_INPUT).sendKeys(Double.toString(controlGroupSize));
		}
	}

	/**
	 * This class supports the modal dialog for configuring the Timeframe on a
	 * Self-optimizing campaign.
	 */
	public class PegaConfigureTimeframeDialog extends PegaModalDialog implements ConfigureTimeframeDialog {

		public PegaConfigureTimeframeDialog(Frame aElmt) {
			super(aElmt);
		}

		/**
		 * Enters a date into the Timeframe dialog for a Self-optimizing Campaign. This
		 * date can be used as either the start or end date.
		 * 
		 * @param date
		 *            The start or end date for the Campaign. Defaulted to start date,
		 *            drop-down must be changed to make it an end date.
		 */
		public void enterTimeframeDate(String date) {
			pegaDriver.handleWaits().waitForElementVisibility(TIMEFRAME_DATE_INPUT);
			findElement(TIMEFRAME_DATE_INPUT).sendKeys(date + Keys.TAB);
			findElement(CONFIGURETIMEFRAME_HEADER).click();
		}
	}

	/**
	 * This class supports the modal dialog for configuring the details on a
	 * Self-optimizing campaign. This includes the required Name field as well as
	 * key code, financial information, and goals.
	 */
	public class PegaConfigureDetailsDialog extends PegaModalDialog implements ConfigureDetailsDialog {

		public PegaConfigureDetailsDialog(Frame aElmt) {
			super(aElmt);
		}

		/**
		 * Enters a name into the Campaign Details dialog for a Self-optimizing
		 * Campaign. This is a required field for Campaigns.
		 * 
		 * @param campaignName
		 *            The name, as a string, for the Campaign.
		 */
		public void enterCampaignName(String campaignName) {
			pegaDriver.handleWaits().waitForElementVisibility(CAMPAIGN_NAME_INPUT);
			findElement(CAMPAIGN_NAME_INPUT).sendKeys(campaignName + Keys.TAB);
		}

		/**
		 * Enters a key code into the Campaign Details dialog for a Self-optimizing
		 * Campaign. This field may return a warning for Campaigns if not set.
		 * 
		 * @param campaignKeycode
		 *            The key code, as a string, for the Campaign.
		 */
		public void enterCampaignKeycode(String campaignKeycode) {
			pegaDriver.handleWaits().waitForElementVisibility(CAMPAIGN_KEYCODE_INPUT);
			findElement(CAMPAIGN_KEYCODE_INPUT).sendKeys(campaignKeycode + Keys.TAB);
		}
	}

	@Override
	public String getthenameofcampaign() {
		String reqString = findElement(By.xpath("//*[@data-test-id='2015051516314605466788']")).getText();
		;
		return reqString;
	}

	public void selectcategoryLP() {
		findElement(ALLCATEGORIESLINK).click();
		pegaDriver.waitForDocStateReady();
		findElement(By.xpath("//*[@aria-label='Filter Categories']//*[text()='Sales']")).click();
	}

	@Override
	public void searchcampaigns(String campaignName, String campaignName1) {
		System.out.println("The campaign names are as below:");
		System.out.println(campaignName + campaignName1);
		pegaDriver.handleWaits().waitForElementPresence(SEARCHCAMPAIGN);
		selectcategoryLP();
		findElement(SEARCHCAMPAIGN).sendKeys(campaignName);
		findElement(VIEW_BTN).click();
		findElement(SEARCHCAMPAIGN).clear();
		findElement(SEARCHCAMPAIGN).sendKeys(campaignName1);
		findElement(VIEW_BTN).click();

	}

	@Override
	public void setCampaignRuleName(String campaignName) {
		pegaDriver.handleWaits().waitForElementVisibility(RULE_NAME_TEXT_BOX_CAMP);
		findElement(RULE_NAME_TEXT_BOX_CAMP).sendKeys(campaignName + Keys.TAB);

	}
}
