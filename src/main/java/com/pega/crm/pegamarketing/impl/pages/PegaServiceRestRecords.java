package com.pega.crm.pegamarketing.impl.pages;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.ServiceRestInstance;
import com.pega.crm.pegamarketing.pages.ServiceRestRecords;
import com.pega.framework.elmt.Frame;

public class PegaServiceRestRecords extends PegaLandingPage implements ServiceRestRecords {

	public PegaServiceRestRecords(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);

	}

	public ServiceRestInstance OpenInstance(String uriTemplate) {
		Frame frame = pegaDriver.findFrame("Developer");
		Frame frame2 = frame.findFrame(frame.getActiveFrameIdWithInThisFrame());
		frame2.findElement(
				By.xpath("//table[@id='bodyTbl_right']//tr//td[3]//*[contains(text(),'" + uriTemplate + " ')]"))
				.click();
		ServiceRestInstance serviceRestInstance = new PegaServiceRestInstance(pegaDriver.getActiveFrameId(false),
				this.testEnv);
		return serviceRestInstance;
	}

}
