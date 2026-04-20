package com.pega.crm.pegamarketing.impl.dialog;

import java.io.File;
import java.io.IOException;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ImageCatalogDialog;
import com.pega.framework.elmt.Frame;

public class PegaImageCatalogDialog extends PegaModalDialog implements ImageCatalogDialog {

	Frame frame;

	public PegaImageCatalogDialog(Frame frame, TestEnvironment testEnv) {
		super(frame);
		this.frame = frame;
	}

	@Override
	public void verifyImageModal() {
		frame.findElement(IMAGE_URL_MODAL).isDisplayed();
	}

	@Override
	public void selectImage() {
		frame.findElement(SELECT_FIRST_IMAGE).click();
		frame.findElement(SELECT_NEXT_BUTTON).click();
		frame.findElement(IMAGE_APPLY).click();
	}

	@Override
	public void verifyURL() {
		frame.findElement(IMAGE_URL_PROPERTY).getText().contains("http://");
	}

	@Override
	public void createFolder(String folderName) {
		frame.findElement(CREATE_FOLDER).click();
		frame.findElement(FOLDER_NAME_INPUT).sendKeys(folderName);
		pegaDriver.waitForDocStateReady();
		frame.findElement(CREATE_AND_ADD).click();
	}

	@Override
	public void searchFolder(String folderName) {
		frame.findElement(SEARCH_IMAGE).sendKeys(folderName);
		frame.findElement(SEARCH_ICON).click();
	}

	@Override
	public void openFolder() {
		frame.findElement(CLICK_FOLDER).doubleClick(true);
	}

	@Override
	public void uploadImage(String filename) {
		String path = System.getProperty("user.dir") + "//Data//" + filename;
		frame.findElement(UPLOAD_BUTTON).sendKeys(path);
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void uploadImageWithAutoIT(String fileName) throws IOException {
		frame.findElement(UPLOAD_BUTTON).doClickWithMouse();
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Data"
				+ System.getProperty("file.separator") + fileName;
		System.out.println(filePath);
		pegaDriver.handleWaits().sleep(4);
		File autoItFilePath = new File("scripts\\AutoITScripts\\inputAFilePath.exe");
		String[] dialog = new String[] { autoItFilePath.getAbsolutePath(), filePath };
		Runtime.getRuntime().exec(dialog);
		pegaDriver.handleWaits().sleep(4);
	}

	@Override
	public void navigateTopFolder() {
		frame.findElement(TOP_FOLDER).click();
	}

	@Override
	public void deleteFolder() {
		frame.findElement(DELETE_DROPDOWN).click();
		frame.findElement(DELETE_MENU).click();
		frame.findElement(DELETE_CONFIRMATION).click();
	}

	@Override
	public void cancelModalPopUp() {
		frame.findElement(CANCEL_MODAL_POPUP).click();
	}

	@Override
	public void createFolderInImageLibrary(String folderName) {
		frame.findElement(FOLDER_NAME_INPUT).sendKeys(folderName);
		pegaDriver.waitForDocStateReady();
		frame.findElement(CREATE_AND_ADD).click();
	}

	@Override
	public void openImageLibraryFolder() {
		pegaDriver.handleWaits().waitForElementPresence(CLICK_IMAGE_LIB_FOLDER);
		frame.findElement(CLICK_IMAGE_LIB_FOLDER).doubleClick(true);

	}

	@Override
	public void deleteFolderImageLibrary() {
		frame.findElement(DELETE_CHECKBOX).click();
		frame.findElement(DELETE_BUTTON).click();
		frame.findElement(DELETE_IMAGE_LIB_CONFIRM).click();
	}

}
