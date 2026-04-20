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

package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaCampaign;
import com.pega.crm.pegamarketing.pages.CampaignsFrame;
import com.pega.crm.pegamarketing.rules.Campaign;

public class PegaCampaignsFrame extends PegaLandingPage implements CampaignsFrame {

	public PegaCampaignsFrame(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public Campaign createMultiChannelCampaign() {
		findElement(CREATE_BUTTON).click();
		findElement(CREATE_MULTI_CHANNEL_CAMPAIGN).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Campaign campaign = new PegaCampaign(frameId, testEnv);
		return campaign;
	}

	public Campaign createOutBoundCampaign() {
		findElement(CREATE_BUTTON).click();
		findElement(CRATE_OUTBOUND_CHANNEL_CAMPAIGN).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Campaign campaign = new PegaCampaign(frameId, testEnv);
		return campaign;
	}

	public Campaign createSelfOptimizingCampaign() {
		findElement(CREATE_BUTTON).click();
		findElement(CREATE_SELF_OPTIMIZING_CAMPAIGN).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Campaign campaign = new PegaCampaign(frameId, testEnv);
		return campaign;
	}

}
