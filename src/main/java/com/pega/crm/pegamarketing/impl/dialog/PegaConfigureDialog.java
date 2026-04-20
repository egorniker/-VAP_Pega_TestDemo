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

import com.pega.crm.pegamarketing.dialog.ConfigureDialog;
import com.pega.framework.elmt.Frame;

public class PegaConfigureDialog extends PegaModalDialog implements ConfigureDialog {
	protected Frame frame;

	public PegaConfigureDialog(Frame aFrame) {
		super(aFrame);
		this.frame = aFrame;
	}

	public void addRule(String ruleName) {
		frame.findElement(ADD_BUTTON).click();
	}

	public void search(String searchText) {
		frame.findElement(SEARCH_INPUT).sendKeys(searchText);
		frame.findElement(SEARCH_ICON).click();
	}

	public boolean isSegmentAdded() {
		boolean isRemoveFound = frame.verifyElement(REMOVE_BUTTON);
		boolean isDeleteButtonFound = frame.verifyElement(DELETE_ICON);
		return isRemoveFound && isDeleteButtonFound;
	}
}
