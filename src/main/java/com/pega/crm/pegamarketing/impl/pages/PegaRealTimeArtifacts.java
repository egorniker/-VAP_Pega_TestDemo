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

import org.testng.Assert;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.Geofence;
import com.pega.crm.pegamarketing.pages.RealTimeArtifacts;
import com.pega.crm.pegamarketing.pages.RealTimeContainer;

public class PegaRealTimeArtifacts extends PegaLandingPage implements RealTimeArtifacts {

	public PegaRealTimeArtifacts(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public RealTimeContainer createContainer() {
		findElement(CONTAINER_TAB_CREATE_LINK).click();
		findElement(CONTAINER_OPT_LINK).click();
		String activeFrameID = pegaDriver.getActiveFrameId(true);
		RealTimeContainer realTimeContainer = new PegaRealTimeContainer(activeFrameID, testEnv);
		return realTimeContainer;

	}

	public Geofence ClickImport() {
		findElement(GEOFENCE_IMPORT_BTN).click();
		String activeFrameID = pegaDriver.getActiveFrameId(true);
		Geofence geofence = new PegaGeofence(activeFrameID, testEnv);
		return geofence;

	}

	public void VerifyImportDisabled() {
		boolean isimportenabled = findElement(GEOFENCE_IMPORT_BTN).isEnabled();
		Assert.assertFalse(isimportenabled, "The import is disabled");
	}

	public Geofence VerifyImport() {
		findElement(GEOFENCE_IMPORT_LBL).click();
		String activeFrameID = pegaDriver.getActiveFrameId(true);
		Geofence geofence = new PegaGeofence(activeFrameID, testEnv);
		return geofence;

	}
}
