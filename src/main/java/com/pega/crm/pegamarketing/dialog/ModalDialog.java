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

package com.pega.crm.pegamarketing.dialog;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.utils.GlobalRepository;

public interface ModalDialog {

	By APPLY_BUTTON = By.xpath("//button[text()='Apply' and @class='Strong pzhc pzbutton']");
	By CLOSE_BUTTON = By.xpath("//i[contains(@data-click,'closeContainer')]");
	By SUBMIT_BUTTON = By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH);
	By CANCEL_BUTTON = By.id("ModalButtonCancel");

	/**
	 * This method will apply the changes in the modal dialog
	 */
	void apply();

	/**
	 * This method will submit the changes in the modal dialog
	 */
	void submit();

	/**
	 * This method will cancel the changes in the modal dialog
	 */
	void cancel();

	/**
	 * This method closes the modal dialog
	 */
	void close();
}
