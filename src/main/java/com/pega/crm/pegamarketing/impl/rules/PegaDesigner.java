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

package com.pega.crm.pegamarketing.impl.rules;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.dialog.PegaConfigureDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.impl.pages.PegaLandingPage;
import com.pega.crm.pegamarketing.rules.Designer;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.elmt.Frame;

public class PegaDesigner extends PegaLandingPage implements Designer {

	public PegaDesigner(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public ConfigureBussinessIssuesDialog editBussinessIssue() {
		ConfigureBussinessIssuesDialog confgBussinessIssue = new PegaConfigureBussinessIssuesDialog(this);
		System.out.println("Config issue dialog is : " + confgBussinessIssue);
		return confgBussinessIssue;
	}

	public void verifyBussinessIssueCreated(String aBussinessIssue) {
		Assert.assertTrue("Bussiness Issue " + aBussinessIssue + "is not been created successfully",
				verifyElement(By.xpath("//span[text()='" + aBussinessIssue + "']")));

	}

	public void verifyGroupCreated(String aGroupNameCreated) {
		Assert.assertTrue("Bussiness Issue " + aGroupNameCreated + "is not been created successfully",
				verifyElement(By.xpath("//span[text()='" + aGroupNameCreated + "']")));

	}

	public ConfigureBussinessIssuesDialog editGroupConfiguration(String issueName) {
		findElement(By.xpath("//div[@data-node-id='NBAModelNode'][.//span[text()='" + issueName
				+ "']]//a[text()='Configure Groups']")).click();
		ConfigureBussinessIssuesDialog confgBussinessIssue = new PegaConfigureBussinessIssuesDialog(this);
		return confgBussinessIssue;
	}

	public ConfigureMetricsDialog configureMetrics() {
		findElement(CONFIGURE_METRICS_LINK).click();
		ConfigureMetricsDialog configureMetricsDialog = new PegaConfigureMetricsDialog(this);
		return configureMetricsDialog;
	}

	public ConfigureMethodDialog configureMethod() {
		findElement(CONFIGURE_METHOD_LINK).click();
		ConfigureMethodDialog configureMetricsDialog = new PegaConfigureMethodDialog(this);
		return configureMetricsDialog;
	}

	public ConfigureActionRelevanceDialog configureActionRelevance() {
		findElement(CONFIGURE_ACTION_RELEVANCE_LINK).click();
		ConfigureActionRelevanceDialog configureActionRelevanceDialog = new PegaConfigureActionRelevanceDialog(this);
		return configureActionRelevanceDialog;

	}

	public AddTargetingDialog addTargetingApproach() {
		findElement(TARGETING_APPROACH_LINK).click();
		AddTargetingDialog addTargetingDialog = new PegaAddTargetingDialog(this);
		return addTargetingDialog;
	}

	public ConfigureOffersDialog configureOffers() {
		findElement(CONFIGURE_OFFER_LINK).click();
		ConfigureOffersDialog configureOffersDialog = new PegaConfigureOffersDialog(this);
		return configureOffersDialog;
	}

	public ConfigureEligibilitiesDialog configureEligibilities() {
		findElement(CONFIGURE_ELIGIBILITIES_LINK).click();
		ConfigureEligibilitiesDialog configureEligibilitiesDialog = new PegaConfigureEligibilitiesDialog(this);
		return configureEligibilitiesDialog;
	}

	public ConfigurePrioritizationDialog configurePrioritization() {
		findElement(CONFIGURE_PRIORITIZATION_LINK).click();
		ConfigurePrioritizationDialog configurePrioritizationDialog = new PegaConfigurePrioritizationDialog(this);
		return configurePrioritizationDialog;
	}

	public ConfigureContainersDialog configureContainers() {
		findElement(CONFIGURE_CONTAINERS_LINK).click();
		ConfigureContainersDialog configureContainersDialog = new PegaConfigureContainersDialog(this);
		return configureContainersDialog;
	}

	public void selectTargetingApproach(String textTobeSelected) {
		findSelectBox(TARGETING_APPROACH_SELECTBOX).selectByVisibleText(textTobeSelected);

	}

	public ConfigureOutboundScheduleDialog configureOutboundScheduleDialog() {
		findElement(CONFIGURE_OUTBOUND_SCHEDULE_LINK).click();
		ConfigureOutboundScheduleDialog configureOutboundScheduleDialog = new PegaConfigureOutboundScheduleDialog(this);
		return configureOutboundScheduleDialog;
	}

	public ConfigureAudienceDialog configureAudience() {
		findElement(CONFIGURE_AUDIENCE_LINK).click();
		ConfigureAudienceDialog configureAudienceDialog = new PegaConfigureAudienceDialog(this);
		return configureAudienceDialog;
	}

	public void selectGroup(String groupName) {
		findElement(By.xpath("//div[@node_name='NBAModelNodeWithAction']//span[contains(text(),'" + groupName + "')]"))
				.click();
	}

	public class PegaConfigureMetricsDialog extends PegaConfigureDialog implements ConfigureMetricsDialog {

		public PegaConfigureMetricsDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaConfigureMethodDialog extends PegaConfigureDialog implements ConfigureMethodDialog {

		public PegaConfigureMethodDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaConfigureActionRelevanceDialog extends PegaConfigureDialog
			implements ConfigureActionRelevanceDialog {

		public PegaConfigureActionRelevanceDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaConfigureOffersDialog extends PegaConfigureDialog implements ConfigureOffersDialog {

		public PegaConfigureOffersDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaConfigureEligibilitiesDialog extends PegaConfigureDialog implements ConfigureEligibilitiesDialog {

		public PegaConfigureEligibilitiesDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaConfigurePrioritizationDialog extends PegaConfigureDialog
			implements ConfigurePrioritizationDialog {

		public PegaConfigurePrioritizationDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaAddTargetingDialog extends PegaModalDialog implements AddTargetingDialog {

		Frame frame;
		PegaWebDriver pegaDriver;

		public PegaAddTargetingDialog(Frame aElmt) {
			super(aElmt);
			this.frame = aElmt;
			pegaDriver = frame.getTestEnvironment().getPegaDriver();
		}

		public void checkAudienceDriven() {
			frame.findElement(AUDIENCE_DRIVEN_RADIO).click();
		}

		public void checkAnalystDriven() {
			frame.findElement(ANALYTICS_DRIVEN_RADIO).click();

		}
	}

	public class PegaConfigureContainersDialog extends PegaConfigureDialog implements ConfigureContainersDialog {

		public PegaConfigureContainersDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaConfigureAudienceDialog extends PegaConfigureDialog implements ConfigureAudienceDialog {

		public PegaConfigureAudienceDialog(Frame aElmt) {
			super(aElmt);

		}

	}

	public class PegaConfigureOutboundScheduleDialog extends PegaModalDialog
			implements ConfigureOutboundScheduleDialog {
		Frame frame;
		PegaWebDriver pegaDriver;

		public PegaConfigureOutboundScheduleDialog(Frame aElmt) {
			super(aElmt);
			this.frame = aElmt;
			pegaDriver = frame.getTestEnvironment().getPegaDriver();
		}

		public void selectOccurences(String occurence) {
			frame.findElement(By.xpath(PMXPathUtil.getRadioLabelXPath(occurence))).check();

		}

		public void selectEndOfSchedule(String end) {
			frame.findElement(By.xpath(PMXPathUtil.getRadioLabelXPath(end))).check();

		}

	}

	public class PegaConfigureBussinessIssuesDialog extends PegaModalDialog implements ConfigureBussinessIssuesDialog {
		protected Frame currentElementWizard;
		protected PegaWebDriver pegaDriver = null;
		private TestEnvironment testEnv;

		public PegaConfigureBussinessIssuesDialog(Frame aelmnt) {
			super(aelmnt);
			this.currentElementWizard = aelmnt;
			pegaDriver = aelmnt.getTestEnvironment().getPegaDriver();
		}

		public Designer createBussinessIssue(String aBussinessIssuename) {
			findElement(CREATE_LINK).click(false);
			findElement(CREATE_BUSSINESS_ISSUE_INPUT).sendKeys(aBussinessIssuename);
			findElement(CREATE_BUSSINESS_ISSUE_INPUT).sendKeys(Keys.TAB);
			findElement(APPLY_BUTTTON).click();
			String frameId = pegaDriver.getActiveFrameId(true);
			Designer designer = new PegaDesigner(frameId, testEnv);
			return designer;
		}

		public Designer createGroup(String aGroupName) {
			findElement(CREATE_LINK).click();
			findElement(CREATE_BUSSINESS_ISSUE_INPUT).clear();
			findElement(CREATE_BUSSINESS_ISSUE_INPUT).sendKeys(aGroupName);
			findElement(CREATE_BUSSINESS_ISSUE_INPUT).sendKeys(Keys.TAB);
			findElement(APPLY_BUTTTON).click();
			String frameId = pegaDriver.getActiveFrameId(true);
			Designer designer = new PegaDesigner(frameId, testEnv);
			return designer;
		}

	}

	@Override
	public void editBussinessHierarchy() {
		if (verifyElement(EDIT_BUTTON)) {
			findElement(RuleInstance.EDIT_BUTTON).click();
		}

		if (verifyElement(EDIT_BUTTON)) {
			findElement(RuleInstance.EDIT_BUTTON).click();
		}

	}

	// changes for paid media tests

	public void runOutboundScheduleNBADesigner() {
		findElement(OUTBOUND_ACTIONS_LINK).click();
		findElement(TRIGGER_RUN).click();
	}

	public class PegaConfigurePaidMediaDialog extends PegaConfigureDialog implements ConfigurePaidMediaDialog {

		public PegaConfigurePaidMediaDialog(Frame aElmt) {
			super(aElmt);
		}
	}

	public ConfigurePaidMediaDialog configurePaidMediaDialog() {
		findElement(CONFIGURE_PAIDMEDIA_DESTINATIONS_LINK).click();
		ConfigurePaidMediaDialog configurePaidMediaDialog = new PegaConfigurePaidMediaDialog(this);
		return configurePaidMediaDialog;
	}

}
