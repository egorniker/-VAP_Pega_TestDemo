package com.pega.crm.customerservice;

import com.pega.crm.customerservice.tiles.TopNav;
import com.pega.page.Portal;

public interface CSPortal extends Portal {

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: CSPortal.java 117333 2018-10-01 09:12:21Z JayaPrakash $";

	TopNav getTopNav();

}
