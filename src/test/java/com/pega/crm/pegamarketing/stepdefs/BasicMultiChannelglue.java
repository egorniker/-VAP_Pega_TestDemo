package com.pega.crm.pegamarketing.stepdefs;

import java.util.List;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.dialog.ConfigureDialog;
import com.pega.crm.pegamarketing.impl.PegaExpressPortal;
import com.pega.crm.pegamarketing.pages.CampaignsFrame;
import com.pega.crm.pegamarketing.rules.Campaign;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureAudienceDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureEngagementDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureMarketingStrategyDialog;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.ObjectsBean;
import com.pega.crm.pegamarketing.utils.TestDataReader;
import com.pega.framework.PegaWebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class BasicMultiChannelglue {

	TestEnvironment testEnv;
	CRMBrowser browser;
	PegaExpressPortal pegaExpressPortal;
	PMPortal pmPortal;
	CampaignsFrame campaigns;
	Campaign campaign;
	PegaWebDriver pegaDriver;
	ConfigureMarketingStrategyDialog configureMarketingStrategyDialog;
	ConfigureAudienceDialog configureAudienceDialog;
	ConfigureEngagementDialog configureEngagementDialog;

	@Inject
	public BasicMultiChannelglue(CRMBrowser browser) {
		pmPortal = browser.getPMPortal();
	}

	@When("^User creates Multi-Channel Campaign$")
	public void user_creates_Multi_Channel_Campaign() {
		campaigns = ObjectsBean.getCampaigns();
		campaign = campaigns.createMultiChannelCampaign();
		ObjectsBean.setCampaign(campaign);
	}

	@Then("^Create a Campaign Page for MultiChannel Campaign should be displayed$")
	public void create_a_Campaign_Page_for_MultiChannel_Campaign_should_be_displayed() {
		campaign = ObjectsBean.getCampaign();
		Assert.assertTrue(campaign.verifyElement(Campaign.CREATE_CAMPAIGN_LANDING_PAGE_HEADER),
				"Create  a Campaign page is not displayed");
	}

	/*
	 * @When("^User edits Multi-Channel Campaign with following data$") public void
	 * user_edits_Multi_Channel_Campaign_with_following_data(DataTable table) {
	 * campaign = ObjectsBean.getCampaign(); List<String> dataList =
	 * table.raw().get(1); String campaignName =
	 * ObjectsBean.putTimeStampedValue(dataList.get(0));
	 * campaign.setRuleName(campaignName); campaign.setIssue(dataList.get(2));
	 * campaign.setGroup(dataList.get(3)); campaign.setBudget(dataList.get(1)); }
	 */

	@When("^User edits Multi-Channel Campaign with following data$")
	public void user_edits_Multi_Channel_Campaign_with_following_data(DataTable table) {
		campaign = ObjectsBean.getCampaign();
		List<String> dataList = table.cells().get(1);
		String campaignName = ObjectsBean.putTimeStampedValue(dataList.get(0));
		campaign.setCampaignRuleName(campaignName);
		String issueName = TestDataReader.getTestDataValue(dataList.get(2));
		//campaign.setIssue(issueName);
		campaign.setCampIssue(issueName);
		String groupName = TestDataReader.getTestDataValue(dataList.get(3));
		//campaign.setGroup(groupName);
		campaign.setCampGroup(groupName);
		campaign.setBudget(dataList.get(1));
	}

	@When("^User saves the Multi-Channel Campaign$")
	public void user_saves_the_Multi_Channel_Campaign() {
		campaign = ObjectsBean.getCampaign();
		campaign.save();
	}

	@Then("^Multi-Channel Campaign should be created and Saved$")
	public void multi_Channel_Campaign_should_be_created_and_Saved() {
		campaign = ObjectsBean.getCampaign();
		Assert.assertTrue(campaign.verifyElement(Campaign.DRAFT_LABEL), "Campaign is not in Draft mode");
		Assert.assertTrue(campaign.verifyElement(Campaign.CAMPAIGN_NAME_LABEL), "Campaign label is not dispalyed");
		Assert.assertTrue(campaign.verifyElement(RuleInstance.EDIT_BUTTON), "Edit button is not enabled");
	}

	@When("^User configures Marketing Strategy$")
	public void user_configures_Marketing_Strategy() {
		campaign = ObjectsBean.getCampaign();
		configureMarketingStrategyDialog = campaign.configureMarketingStrategy();
		ObjectsBean.setConfigureMarketingStrategyDiaolg(configureMarketingStrategyDialog);
	}

	@Then("^Configure Marketing Strategy PopUp should be displayed$")
	public void configure_Marketing_Strategy_PopUp_should_be_displayed() {
		configureMarketingStrategyDialog = ObjectsBean.getConfigureMarketingStrategyDialog();
		Assert.assertTrue(campaign.verifyElement(ConfigureMarketingStrategyDialog.DIALOG_HEADER),
				"Configure Marketing Strategy pop up did not open");
	}

	@When("^User searches for the Strategy \"([^\"]*)\" in the Search for Marketing Startegy$")
	public void user_searches_forthe_Strategy_in_the_Search_for_Marketing_Startegy(String strategyName) {
		configureMarketingStrategyDialog.search(ObjectsBean.getTimeStampedValue(strategyName));
	}

	@Then("^Strategy Search Results for \"([^\"]*)\" should be displayed$")
	public void strategy_Search_Results_for_should_be_displayed(String strategyName) {
		Assert.assertTrue(campaign.findElement(ConfigureDialog.STRATEGY_SEARCH_RESULT).getText()
				.equals(ObjectsBean.getTimeStampedValue(strategyName)), "Search Results not available");
	}

	@When("^User selects and adds strategy \"([^\"]*)\" from displayed search results$")
	public void user_selects_and_adds_strategy_from_displayed_search_results(String strategyName) {
		configureMarketingStrategyDialog.addRule(ObjectsBean.getTimeStampedValue(strategyName));
	}

	@Then("^Strategy Details for the strategy should be displayed$")
	public void strategy_Details_for_strategy_should_be_displayed() {
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.DELETE_ICON), "Delete icon is not displayed");
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.STRATEGY_LINK), "Strategy Link is not available");
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.APPLY_BUTTON), "Strategy Link is not available");
	}

	@When("^User applies Strategy for Campaign$")
	public void user_applies_Strategy_for_Campaign() {
		configureMarketingStrategyDialog.apply();
		ObjectsBean.setCampaign(campaign);
	}

	@Then("^Marketing Strategy Section should have the Strategy \"([^\"]*)\" Added$")
	public void marketing_Strategy_Section_should_have_the_Strategy_Added(String strategyName) {
		campaign = ObjectsBean.getCampaign();
		Assert.assertTrue(campaign.findElement(Campaign.STRATEGY_NAME_LABEL).getText()
				.equals(ObjectsBean.getTimeStampedValue(strategyName)), "Strategy is not applied correctly");
	}

	@When("^User configures Audience$")
	public void user_configures_Audience() {
		campaign = ObjectsBean.getCampaign();
		configureAudienceDialog = campaign.configureAudience();
		ObjectsBean.setConfigureAudienceDiaolg(configureAudienceDialog);
	}

	@Then("^Audience Search Results for segment \"([^\"]*)\" should be displayed$")
	public void audience_Search_Results_for_segment_should_be_displayed(String segmentName) {
		Assert.assertTrue(campaign.findElement(ConfigureDialog.STRATEGY_SEARCH_RESULT).getText().equals(segmentName),
				"Search Results not available");
	}

	@When("^User selects and adds Segment \"([^\"]*)\" from Audience Search Results$")
	public void user_selects_and_adds_Segment_from_Audience_Search_Results(String segmentNmae) {
		configureAudienceDialog.addRule(segmentNmae);
	}

	@Then("^Audience Details should be displayed$")
	public void audience_Details_should_be_displayed() {
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.DELETE_ICON), "Delete icon is not displayed");
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.STRATEGY_LINK), "Strategy Link is not available");
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.APPLY_BUTTON), "Strategy Link is not available");
	}

	@Then("^Audience Section should have the Segment \"([^\"]*)\" Added$")
	public void audience_Section_should_have_the_Segment_Added(String segmentNmae) {
		campaign = ObjectsBean.getCampaign();
		Assert.assertTrue(campaign.findElement(Campaign.SEGMENT_NAME_LABEL).getText().equals(segmentNmae),
				"Segment is not applied or displayed correctly");
	}

	@When("^User configures Engagement$")
	public void user_configures_Engagement() {
		campaign = ObjectsBean.getCampaign();
		configureEngagementDialog = campaign.configureEngagement();
		ObjectsBean.setConfigureEngagementDiaolg(configureEngagementDialog);
	}

	@Then("^Configure Engagement PopUp should be displayed$")
	public void configure_Engagement_PopUp_should_be_displayed() {
		configureEngagementDialog = ObjectsBean.getConfigureEngagementDialog();
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.DIALOG_HEADER),
				"Configure Engagement pop up did not open");
	}

	@When("^User checks Campaign Schedule$")
	public void user_checks_Campaign_Schedule() {
		configureEngagementDialog = ObjectsBean.getConfigureEngagementDialog();
		configureEngagementDialog.checkCampaignSchedule();
	}

	@Then("^Schedule Details should be displayed$")
	public void schedule_Details_should_be_displayed() {
		configureEngagementDialog = ObjectsBean.getConfigureEngagementDialog();
		Assert.assertTrue(campaign.verifyElement(ConfigureEngagementDialog.ONE_TIME_RADIO_BUTTON),
				"One Time Only radio button is not displayed");
		Assert.assertTrue(campaign.verifyElement(ConfigureEngagementDialog.RECURRING_RADIO_BUTTON),
				"Recurring radio button is not displayed");
		Assert.assertTrue(campaign.verifyElement(ConfigureEngagementDialog.START_ON_TIME_TEXT),
				"Start on time value is not displayed");
		Assert.assertTrue(campaign.verifyElement(ConfigureEngagementDialog.REFRESH_AUDIENCE_CHECKBOX),
				"Refresh the Audience for this Campaign checkbox is not displayed");
		Assert.assertTrue(campaign.verifyElement(ConfigureEngagementDialog.WRITE_CAMPAIGN_CHECKBOX),
				"Write Campaign results using a database template checkbox is not displayed");
	}

	@When("^User applies Engagement foe campaign$")
	public void user_applies_Engagement_foe_campaign() {
		configureEngagementDialog = ObjectsBean.getConfigureEngagementDialog();
		configureEngagementDialog.clickonrefreshaudience();
		configureEngagementDialog.apply();
	}

	@Then("^Engagement Section should have the Schedule details Added$")
	public void engagement_Section_should_have_the_Schedule_details_Added() {
		campaign = ObjectsBean.getCampaign();
		Assert.assertTrue(campaign.verifyElement(Campaign.ENGAGEMENT_CAMPAIGN_SCHEDULE_LABEL),
				"Campaign schedule label is not dispalyed");
		Assert.assertTrue(campaign.verifyElement(Campaign.ONE_TIME_ONLY_ENGAGEMENT),
				"One Time Only is not applied to Engagement");
	}

	@Then("^User saves Multi-Channel Campaign$")
	public void user_saves_Multi_Channel_Campaign() {
		campaign.save();
	}

	@Then("^Multi-Channel Campaign with Strategy should be Saved$")
	public void multi_Channel_Campaign_with_Strategy_should_be_Saved() {
		Assert.assertTrue(campaign.verifyElement(RuleInstance.EDIT_BUTTON),
				"multi channel campaign is not saved correctcly");
	}

	@When("^User runs Multi-Channel Campaign$")
	public void user_runs_Multi_Channel_Campaign() {
		campaign.runCampaign();
	}

	@Then("^Engagement details should be displayed$")
	public void engagement_details_should_be_displayed() {
		campaign = ObjectsBean.getCampaign();
		Assert.assertTrue(campaign.verifyElement(Campaign.ENGAGEMENT_CAMPAIGN_SCHEDULE_LABEL),
				"Campaign schedule label is not dispalyed");
		Assert.assertTrue(campaign.verifyElement(Campaign.ONE_TIME_ONLY_ENGAGEMENT),
				"One Time Only is not applied to Engagement");
	}

}
