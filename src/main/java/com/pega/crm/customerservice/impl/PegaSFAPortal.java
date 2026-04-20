package com.pega.crm.customerservice.impl;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.customerservice.tiles.LeftNav;
import com.pega.crm.customerservice.tiles.TopNav;
import com.pega.crm.customerservice.tiles.impl.PegaLeftNav;
import com.pega.crm.customerservice.tiles.impl.PegaTopNav;
import com.pega.page.PortalImpl;

public class PegaSFAPortal extends PortalImpl implements SFAPortal {

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: PegaSFAPortal.java 117333 2018-10-04 09:12:21Z ShivaNalla $";

	private TopNav topNav = null;
	private LeftNav leftNav = null;

	public PegaSFAPortal(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public TopNav getTopNav() {
		if (topNav == null) {
			topNav = new PegaTopNav(testEnv);
		}
		return topNav;
	}

	@Override
	public LeftNav getLeftNav() {
		if (leftNav == null) {
			leftNav = new PegaLeftNav(testEnv);
		}
		return leftNav;
	}
}
