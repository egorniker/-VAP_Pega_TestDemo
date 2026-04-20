package com.pega.crm.pegamarketing.impl.dialog;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ConfigureOfferDialog;
import com.pega.framework.elmt.Frame;

public class PegaConfigureOfferDialog extends PegaConfigureDialog implements ConfigureOfferDialog {
	Frame frame;

	public PegaConfigureOfferDialog(Frame aFrame) {
		super(aFrame);
		this.frame = aFrame;
	}

	public void addFirstSegment() {
		frame.findElement(FIRST_ADD_BUTTON).click();
	}

	public void addOffer(String offerName) {
		frame.findElement(By.xpath("//div[@node_name='SimpleMultiselectorCardContent'][.//span[text()='" + offerName
				+ "']]//button[text()='Add']")).click();
	}
}