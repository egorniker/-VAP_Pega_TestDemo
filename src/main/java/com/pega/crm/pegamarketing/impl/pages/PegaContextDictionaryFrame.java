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
import com.pega.crm.pegamarketing.pages.ContextDictionary;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.framework.elmt.FrameImpl;

public class PegaContextDictionaryFrame extends FrameImpl implements ContextDictionary {

	public PegaContextDictionaryFrame(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void save() {
		findElement(RuleInstance.SAVE_BUTTON).click();
	}

	public void close() {
		findElement(CLOSE_BUTTON).click(false);
	}

}
