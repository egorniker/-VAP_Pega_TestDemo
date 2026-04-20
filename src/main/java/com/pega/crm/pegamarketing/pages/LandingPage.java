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

public interface LandingPage extends Frame {
	By CREATE_BUTTON = By.xpath("//button[contains(@class,'pzhc pzbutton') and contains(text(),'Create')]");
	//By CREATE_OFFER = By.xpath("//*[@data-test-id='201802050902450494528']");
	By CREATE_OFFER = By.xpath("//span[text()='Action' and @class='menu-item-title']");
	By HELP_BUTTON = By.xpath("//button[@class='Simple pzhc pzbutton' and contains(text(),'Help')]");
	By VIEW_BUTTON = By.xpath(XPathUtil.getButtonPzhcBtnXPath("View"));
	By LANDING_PAGE_HEADER = By.xpath("//span[@class='workarea_header_titles']");
	String TAB_XPATH = "//*[@class='textIn' and contains(text(),'%s')]";
	By REFRESH_BUTTON = By.xpath("//button[@title='Refresh']");

	/**
	 * this method switches to the given tab in any landing page
	 * 
	 * @param tabName
	 *            tab to which user wants to switch
	 */
	void switchTab(String tabName);

	/**
	 * this method refreshes the current landing page
	 */
	void refresh();

	/**
	 * clicks on edit button on current landing page
	 */
	void edit();

	/**
	 * clicks on save button on current landing page
	 */
	void save();

}
