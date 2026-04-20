package com.pega.crm.pegamarketing.stepdefs;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.explorer.RecordsExplorer;
import com.pega.crm.pegamarketing.pages.ServiceRestRecords;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class DesignerStudioglue {

	private CRMBrowser browser;
	private DesignerStudio designerStudio;
	private RecordsExplorer recordsExplorer;
	private ServiceRestRecords serviceRestRecords;
	private PMPortal pmPortal;

	@Inject
	DesignerStudioglue(CRMBrowser browser) {
		this.browser = browser;
		designerStudio = browser.getDesignerStudio();
	}

	@When("^Opens the Records Explorer$")
	public void opens_the_Records_Explorer() {
		recordsExplorer = designerStudio.getRecordsExplorer();
	}

	@When("^Opens \"([^\"]*)\" records page after expanding \"([^\"]*)\"$")
	public void opens_records_page_after_expanding(String pageTobeOpened, String navPage1) {
		serviceRestRecords = recordsExplorer.openRecord(ServiceRestRecords.class, navPage1, pageTobeOpened);
		ObjectsBean.setServiceRestRecords(serviceRestRecords);
	}

	@When("^User launches pega marketing portal$")
	public void user_launches_pega_marketing_portal() {
		pmPortal = designerStudio.launchPegaMarketingPortal();
		ObjectsBean.setPMPortal(pmPortal);
	}

}
