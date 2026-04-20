package com.pega.crm.customerservice.impl;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.tiles.TopNav;
import com.pega.crm.customerservice.tiles.impl.PegaTopNav;
import com.pega.page.PortalImpl;

public class PegaCSPortal extends PortalImpl implements CSPortal {

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: CSPortal.java 117333 2018-10-04 09:12:21Z JayaPrakash $";

	private TopNav topNav = null;

	public static String expectedText, actualText;
	// XPATHs for elements
	String NEWMESSAGE_XPATH = "//a[@title='Create New Alert Message']";
	String CREATEALERT_XPATH = "//button[text()='  Create Alert ']";
	String MANAGER_XPATH = "//li[text() = 'Manager']";
	String MOVETOSELECTEDWORKGROUPS_XPATH = "//div[@title='Move']";
	String STARTDATE_XPATH = "//input[@id='startDate']";
	String ENDDATE_XPATH = "//input[@id='endDate']";
	String TITLE_XPATH = "//input[@id='Title']";
	String MESSAGE_XPATH = "//textarea[@id='pyDescription']";
	String REFRESH_XPATH = "//i[@title = 'Refresh Messages &amp; Alerts Section ']";
	String MODIFYALERT_XPATH = "//button[@name= 'ModifyAlert_ModifyAlert_151']/div/div/div/div";
	String DELETEALERT_XPATH = "//button[@name= 'ModifyAlert_ModifyAlert_150']";
	String CANCEL_XPATH = ".//*[@id='RULE_KEY']/div[4]/div/div/div[1]/div/div/span/button";

	public PegaCSPortal(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public TopNav getTopNav() {
		if (topNav == null) {
			topNav = new PegaTopNav(testEnv);
		}
		return topNav;
	}
}
