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

package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.Campaign;

public interface CampaignsFrame extends LandingPage {

	By LANDING_PAGE_HEADER = By.xpath("//span[@class='workarea_header_titles']");
	//By CREATE_MULTI_CHANNEL_CAMPAIGN = By.xpath("//span[text()='Create Multi-Channel Campaign']");
	By CREATE_MULTI_CHANNEL_CAMPAIGN = By.xpath("//span[text()='Multi-Channel Campaign']");
	By CRATE_OUTBOUND_CHANNEL_CAMPAIGN = By.xpath("//span[text()='Create Outbound Campaign']");
	By CREATE_SELF_OPTIMIZING_CAMPAIGN = By.xpath("//span[text()='Create Self-Optimizing Campaign']");

	/**
	 * opens Campaign page while creating a MultiChannelCampaign
	 * 
	 * @return Campaign page
	 */
	Campaign createMultiChannelCampaign();

	/**
	 * opens Campaign page while creating a OutBoundCampaign
	 * 
	 * @return Campaign page
	 */
	Campaign createOutBoundCampaign();

	/**
	 * opens Campaign page while creating a Self-Optimizing Campaign
	 * 
	 * @return Campaign page
	 */
	Campaign createSelfOptimizingCampaign();

}
