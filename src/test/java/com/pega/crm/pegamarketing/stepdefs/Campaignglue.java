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

package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ConfigureDialog;
import com.pega.crm.pegamarketing.rules.Campaign;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureAudienceDialog;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Campaignglue {
	TestEnvironment testEnv;
	CRMBrowser browser;
	Campaign campaign;
	String Campaign1, Campaign2;
	private ConfigureAudienceDialog configureAudienceDialog;

	@Inject
	Campaignglue(CRMTestEnvironment testEnv) {
		this.testEnv = testEnv;
		browser = (CRMBrowser) testEnv.getBrowser();
	}

	@Then("^Campaign should be created and Saved$")
	public void Campaign_should_be_created_and_Saved() {
		Assert.assertTrue(campaign.verifyElement(Campaign.DRAFT_LABEL), "Campaign is not in Draft mode");
		Assert.assertTrue(campaign.verifyElement(Campaign.CAMPAIGN_NAME_LABEL), "Campaign label is not dispalyed");
		Assert.assertTrue(campaign.verifyElement(RuleInstance.EDIT_BUTTON), "Edit button is not enabled");
	}

	@When("^User edits the Campaign$")
	public void user_edits_the_Campaign() {
		campaign = ObjectsBean.getCampaign();
		campaign.editCampaign();
	}

	@Then("^User saves the name of the Campaign$")
	public void user_saves_the_name_of_the_Campaign() {
		if (this.Campaign1 == null) {

			this.Campaign1 = campaign.getthenameofcampaign();
			ObjectsBean.setCampaignName(Campaign1);
		} else {
			this.Campaign2 = campaign.getthenameofcampaign();
			ObjectsBean.setCampaignName1(Campaign2);
		}
	}

	@Then("^user clicks on close button in Campaign$")
	public void user_clicks_on_close_button_in_Campaign() {
		campaign.close();
	}

	@Then("^Save button should be Enabled for the Campaign$")
	public void save_button_should_be_Enabled_for_theCampaign() {
		Assert.assertTrue(campaign.findElement(Campaign.SAVE_BUTTON).isEnabled(), "save button is not enabled");
	}

	@When("^User saves the Campaign$")
	public void user_saves_the_Campaign() {
		campaign = ObjectsBean.getCampaign();
		campaign.save();
	}

	@Then("^Configure Audience PopUp should be displayed$")
	public void configure_Audience_PopUp_should_be_displayed() throws Throwable {
		Assert.assertTrue(campaign.verifyElement(ConfigureDialog.DIALOG_HEADER),
				"Configure Audience pop up did not open");
	}

	@Then("^Campaign should move to \"([^\"]*)\" Status$")
	public void campaign_should_move_to_Status(String statusTobeChecked) {
		Assert.assertTrue(!(campaign.verifyElement(Campaign.RUN_ERROR_MESSAGE)), "Run did not start");
		Assert.assertTrue(campaign.checkRunStatus(statusTobeChecked), "Status is not updated to" + statusTobeChecked);
	}

	@When("^User searches for the Segment \"([^\"]*)\" in the Search for Audience$")
	public void user_searches_for_the_Segment_in_the_Search_for_Audience(String segmentName) {
		configureAudienceDialog = ObjectsBean.getConfigureAudienceDialog();
		configureAudienceDialog.search(segmentName);
		ObjectsBean.setConfigureAudienceDiaolg(configureAudienceDialog);
	}

	@When("^User searches and adds the Segment \"([^\"]*)\" in the Search for Audience$")
	public void user_searches_and_adds_the_Segment_in_the_Search_for_Audience(String segmentName) {
		configureAudienceDialog = ObjectsBean.getConfigureAudienceDialog();
		configureAudienceDialog.search(segmentName);
	}

	@When("^User applies the Segment for campaign$")
	public void user_applies_the_Segment_for_campaign() {
		configureAudienceDialog.apply();
		ObjectsBean.setConfigureAudienceDiaolg(configureAudienceDialog);
	}

	@Then("^Campaign should be Saved$")
	public void campaign_should_be_Saved() {
		campaign = ObjectsBean.getCampaign();
		Assert.assertTrue(campaign.verifyElement(Campaign.CAMPAIGN_NAME_LABEL), "Campaign label is not dispalyed");
		Assert.assertTrue(campaign.verifyElement(RuleInstance.EDIT_BUTTON), "Edit button is not enabled");
	}

	@When("^User runs the campaign$")
	public void user_runs_the_campaign() {
		campaign.runCampaign();
	}

	@When("^User confirms the Run Schedule and Submits the campaign$")
	public void user_confirms_the_Run_Schedule_and_Submits_the_campaign() {
		campaign.selectRunNow();
		campaign.submit();
	}

	@When("^User confirms the Run Schedule$")
	public void user_confirms_the_Run_Schedule() {
		campaign.confirmAction();
		campaign.refreshRunStatus();
	}

	@When("^User logs out of the application$")
	public void user_logs_out_of_the_application() throws Throwable {
		testEnv.getBrowser().logout();
	}

}
