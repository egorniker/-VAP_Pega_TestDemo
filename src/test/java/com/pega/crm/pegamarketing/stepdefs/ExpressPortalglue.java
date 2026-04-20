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

package com.pega.crm.pegamarketing.stepdefs;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.impl.PegaExpressPortal;
import com.pega.crm.pegamarketing.pages.ContextDictionary;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ExpressPortalglue {
	private PegaExpressPortal pegaExpressPortal;
	private ContextDictionary contextDictionaryFrame;
	private DesignerStudio designerStudio;

	@Inject
	public ExpressPortalglue(CRMBrowser browser) {
		pegaExpressPortal = browser.getExpressPortal();
	}

	@When("^User opens setting from Express Portal$")
	public void user_opens_setting_from_Express_Portal() {
		pegaExpressPortal.openSettingsExplorer();
	}

	@When("^Opens Context Dictionary from Settings in Express Portal$")
	public void opens_Context_Dictionary_from_Settings_in_Express_Portal() {
		contextDictionaryFrame = pegaExpressPortal.openContextDictionary();
		ObjectsBean.setContextDictionaryFrame(contextDictionaryFrame);
	}

	@When("^User closes express welcome dialog$")
	public void user_closes_express_welcome_dialog() {
		pegaExpressPortal.closeWelcomeDialog();
	}

	@When("^User switches to designer studio portal$")
	public void user_switches_to_designer_studio_portal() {
		designerStudio = pegaExpressPortal.switchToDesignerStudio();
		ObjectsBean.setDesignerStudio(designerStudio);
	}
}
