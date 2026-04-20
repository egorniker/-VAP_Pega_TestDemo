package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ImageCatalogDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaImageCatalogDialog;
import com.pega.crm.pegamarketing.pages.ImageLibrary;

public class PegaImageLibrary extends PegaLandingPage implements ImageLibrary {
	public PegaImageLibrary(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public void verifyImageLibraryHeader() {
		findElement(IMAGE_LIBRARY_HEADER).isDisplayed();
	}

	@Override
	public ImageCatalogDialog clickCreateFolder() {
		findElement(CREATE_FOLDER_BUTTON).click();
		ImageCatalogDialog imageCatalogDialog = new PegaImageCatalogDialog(this, testEnv);
		return imageCatalogDialog;
	}

}
