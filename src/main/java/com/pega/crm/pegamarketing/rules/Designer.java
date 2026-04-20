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

import com.pega.crm.pegamarketing.dialog.ConfigureDialog;
import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.pages.LandingPage;

public interface Designer extends LandingPage {
	public static final String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public static final String VERSION = "$Id:$";

	By NEXT_BEST_ACTION_DESIGNER_TITLE = By.xpath("//span[text()='Next-Best-Action Designer']");
	By EDIT_BUTTON = By.xpath("//button[text()='Edit']");
	By CONFIGURE_GROUPS_LINK = By.xpath("//a[text()='Configure Groups']");
	By CONFIGURE_METRICS_LINK = By.xpath("//*[contains(@name,'MonitorContainer') and contains(text(),'Configure')]");
	By CONFIGURE_METHOD_LINK = By.xpath("//*[contains(@name,'NBAGroupOverview') and contains(text(),'Configure')]");
	By CONFIGURE_ACTION_RELEVANCE_LINK = By
			.xpath("//*[contains(@name,'NBARelevanceWithNode') and contains(text(),'Configure')]");
	By CONFIGURE_OFFER_LINK = By
			.xpath("//*[contains(@name,'AnalyticsDrivenOfferGroups') and contains(text(),'Configure')]");
	By CONFIGURE_ELIGIBILITIES_LINK = By
			.xpath("//*[contains(@name,'AnalyticsDrivenEligibilities') and contains(text(),'Configure')]");
	By CONFIGURE_PRIORITIZATION_LINK = By
			.xpath("//*[contains(@name,'AnalyticsDrivenPrioritization') and contains(text(),'Configure')]");
	By CONFIGURE_CONTAINERS_LINK = By
			.xpath("//*[contains(@name,'ContainerConfiguration') and contains(text(),'Configure')]");
	By CONFIGURE_OUTBOUND_SCHEDULE_LINK = By
			.xpath("//*[contains(@name,'ScheduleConfiguration') and contains(text(),'Configure')]");
	By CONFIGURE_AUDIENCE_LINK = By
			.xpath("//*[contains(@name,'AudienceConfiguration') and contains(text(),'Configure')]");
	By TARGETING_APPROACH_SELECTBOX = By.xpath("//select[contains(@id,'OfferTargeting')]");
	By TARGETING_APPROACH_LINK = By
			.xpath("//a[contains(@name,'AudienceTargeting') and text()='Add targeting approach']");
	By CONFIGURE_BUSSINESS_HIERARCHY_ICON = By.xpath("//button[contains(@data-click,'ToggleDisplayHierarchyFlag')]");
	By CONFIGURE_BUSSINESS_ISSUES_LINK = By.xpath("//a[text()='Configure Business Issues']");
	By OUTBOUND_ACTIONS_LINK = By.xpath("//*[contains(@name,'ScheduleConfiguration') and contains(text(),'Actions')]");
	By TRIGGER_RUN = By.xpath("//span[text()='Run']");
	By CONFIGURE_PAIDMEDIA_DESTINATIONS_LINK = By
			.xpath("//*[contains(@name,'PaidMediaConfig') and contains(text(),'Configure')]");

	void editBussinessHierarchy();

	ConfigureBussinessIssuesDialog editBussinessIssue();

	void verifyBussinessIssueCreated(String bussinessIssue);

	void verifyGroupCreated(String groupNameCreated);

	ConfigureBussinessIssuesDialog editGroupConfiguration(String issueName);

	ConfigureMetricsDialog configureMetrics();

	ConfigureMethodDialog configureMethod();

	ConfigureActionRelevanceDialog configureActionRelevance();

	ConfigureContainersDialog configureContainers();

	AddTargetingDialog addTargetingApproach();

	ConfigureOffersDialog configureOffers();

	ConfigureEligibilitiesDialog configureEligibilities();

	ConfigurePrioritizationDialog configurePrioritization();

	ConfigureOutboundScheduleDialog configureOutboundScheduleDialog();

	ConfigureAudienceDialog configureAudience();

	ConfigurePaidMediaDialog configurePaidMediaDialog();

	void selectGroup(String groupName);

	void selectTargetingApproach(String textTobeSelected);

	void runOutboundScheduleNBADesigner();

	public interface ConfigureMetricsDialog extends ConfigureDialog {

	}

	public interface ConfigureMethodDialog extends ConfigureDialog {

	}

	public interface ConfigureActionRelevanceDialog extends ConfigureDialog {

	}

	public interface ConfigureOffersDialog extends ConfigureDialog {

	}

	public interface ConfigureEligibilitiesDialog extends ConfigureDialog {

	}

	public interface ConfigurePrioritizationDialog extends ConfigureDialog {

	}

	public interface AddTargetingDialog extends ModalDialog {
		By AUDIENCE_DRIVEN_RADIO = By.xpath("//label[@for='AudienceTargetingSEGMENTATION']");
		By ANALYTICS_DRIVEN_RADIO = By.xpath("//label[@for='AudienceTargetingADAPTIVE']");

		/**
		 * This will check Audience Driven option
		 */
		void checkAudienceDriven();

		/**
		 * checks Analytics Driven option
		 */
		void checkAnalystDriven();
	}

	public interface ConfigureContainersDialog extends ConfigureDialog {

	}

	public interface ConfigureOutboundScheduleDialog extends ModalDialog {
		/**
		 * selects the occurence from Configure outbound schedule
		 * 
		 * @param occurence
		 *            name of the occurence to be selected
		 */
		void selectOccurences(String occurence);

		/**
		 * chooses when to end the outbound schedule
		 * 
		 * @param end
		 *            the text which needs to ne checked
		 */
		void selectEndOfSchedule(String end);
	}

	public interface ConfigureAudienceDialog extends ConfigureDialog {

	}

	public interface ConfigureBussinessIssuesDialog extends ModalDialog {

		By CREATE_LINK = By.xpath("//a[text()='Create']");
		By CREATE_BUSSINESS_ISSUE_INPUT = By.xpath("//input[@id='pyLabel']");
		By APPLY_BUTTTON = By.xpath("//button[@id='ModalButtonSubmit']");

		Designer createBussinessIssue(String bussinessIssuename);

		Designer createGroup(String groupName);

	}

	public interface ConfigurePaidMediaDialog extends ConfigureDialog {

	}

}
