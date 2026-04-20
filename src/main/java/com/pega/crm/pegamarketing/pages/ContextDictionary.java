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

import com.pega.framework.elmt.Frame;
import com.pega.util.XPathUtil;

public interface ContextDictionary extends Frame {
	By CLOSE_BUTTON = By.xpath(XPathUtil.getDataTestIDXpath("201801311359520282426"));

	/**
	 * saves the context dictionary
	 */
	void save();

	/**
	 * closes the context dictionary
	 */
	void close();

}
