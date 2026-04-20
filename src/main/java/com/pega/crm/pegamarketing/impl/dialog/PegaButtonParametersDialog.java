package com.pega.crm.pegamarketing.impl.dialog;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ButtonParametersDialog;
import com.pega.framework.elmt.Frame;

public class PegaButtonParametersDialog extends PegaImageCatalogDialog implements ButtonParametersDialog {

	Frame frame;
	String buttonImageURL;

	public PegaButtonParametersDialog(Frame frame, TestEnvironment testenv) {
		super(frame, testenv);
		this.frame = frame;
	}

	@Override
	public void verifyButtonPropertiesDialog() {
		frame.findElement(BUTTON_PARAMETER_MODAL).isDisplayed();
	}

	@Override
	public void clickButtonImageCog() {
		frame.findElement(BUTTON_IMAGE_COG).click();
	}

	@Override
	public void verifyImageDialog() {
		frame.findElement(HEADER_IMAGE).isDisplayed();
	}

	@Override
	public void verifyButtonImageURL() {
		buttonImageURL = frame.findElement(BUTTON_IMAGE_FIELD).getText();
		buttonImageURL.contains("http://");
	}

	@Override
	public void saveButtonParameters() {
		frame.findElement(SAVE_BUTTON_PARAMETERS).click();
	}

	@Override
	public void clickAndOpenFolder() {
		frame.findElement(CLICK_IMAGE_FOLDER).doubleClick(true);
	}

}
