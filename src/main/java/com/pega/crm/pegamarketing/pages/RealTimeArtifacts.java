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

public interface RealTimeArtifacts extends LandingPage {
	By REALTIMEARTIFACTS_HEADER = By
			.xpath("//span[@class='workarea_header_titles' and contains(text(),'Real-Time Artifacts')]");
	By CONTAINER_TAB_CREATE_LINK = By.xpath("//button[text()='Create']");
	By CONTAINER_OPT_LINK = By.xpath("//span[contains(text(),'Create container')]");
	By GEOFENCE_IMPORT_BTN = By.xpath("//button[text()='Import']");
	By GEOFENCE_IMPORT_LBL = By.xpath("//h2[text()='Import']");

	/**
	 * creates a container
	 * 
	 * @return RealTimeContainer page
	 */
	RealTimeContainer createContainer();

	Geofence ClickImport();

	Geofence VerifyImport();

	void VerifyImportDisabled();

}
