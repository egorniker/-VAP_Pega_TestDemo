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

package com.pega.crm.pegamarketing.impl.dialog;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.elmt.Frame;

public class PegaModalDialog implements ModalDialog {
	protected PegaWebDriver pegaDriver;
	protected TestEnvironment testEnv;
	protected Frame frame;

	public PegaModalDialog(Frame frame) {
		this.frame = frame;
		this.testEnv = frame.getTestEnvironment();
		this.pegaDriver = testEnv.getPegaDriver();
	}

	public void apply() {
		frame.findElement(APPLY_BUTTON).click();
	}

	public void close() {
		frame.findElement(CLOSE_BUTTON).click();

	}

	public void submit() {
		frame.findElement(SUBMIT_BUTTON).click();

	}

	public void cancel() {
		frame.findElement(CANCEL_BUTTON);

	}

}
