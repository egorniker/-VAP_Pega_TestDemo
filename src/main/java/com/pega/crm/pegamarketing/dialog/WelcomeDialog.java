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

public interface WelcomeDialog extends ModalDialog {

	By SHOW_THIS_DIALOG_ON_STARTUP_CHKBOX = By
			.xpath("//label[text()='Show this dialog on startup']/preceding-sibling::input[1]");
}
