package com.pega.crm.pegamarketing.dialog;

import java.io.IOException;

import org.openqa.selenium.By;

public interface ImageCatalogDialog extends ModalDialog {
	By IMAGE_URL_MODAL = By.xpath("//*[text()='Image'][@class='header-title']");
	By SELECT_FIRST_IMAGE = By.xpath("//*[contains(@id,'CMSImage')][@pl_index=1]/td[2]");
	By SELECT_NEXT_BUTTON = By.xpath("//*[contains(@data-click,'SelectedImage')][@type='button']");
	By IMAGE_APPLY = By.xpath("//*[contains(@data-click,'MKTSetUrltoImageUrl')][@type='button']");
	By IMAGE_URL_PROPERTY = By.id("ImageURL");
	By CREATE_FOLDER = By.xpath("//*[text()='Create Folder']");
	By FOLDER_NAME_INPUT = By.xpath("//*[@id='FolderName'][@validationtype='required']");
	By CREATE_AND_ADD = By.xpath("//button[text()='Create'][contains(@data-click,'CreateFolder')]");
	By SEARCH_IMAGE = By.xpath("//*[@id='SearchKey']");
	By SEARCH_ICON = By.xpath("//*[contains(@placeholder,'Search...')]/../../..//button");
	By CLICK_FOLDER = By.xpath("//*[contains(text(),'OfferImageFolder')]");
	By UPLOAD_BUTTON = By.xpath("//button[contains(text(),'Upload')]");
	By TOP_FOLDER = By.xpath("//*[text()='Top']");
	By DELETE_DROPDOWN = By.xpath("//*[@class=' icons pi pi-dot-3-solid']");
	By DELETE_MENU = By.xpath("//*[@class='menu-item-title'][text()='Delete']");
	By DELETE_CONFIRMATION = By.xpath("//*[text()='Delete'][contains(@name,'DeleteFileConfirmation')]");
	By CANCEL_MODAL_POPUP = By.xpath("//*[text()='Cancel']");
	By CLICK_IMAGE_LIB_FOLDER = By.xpath("//*[text()='ImageLibraryFolder']");
	By DELETE_CHECKBOX = By.xpath("//*[@class='checkbox chkBxCtl']");
	By DELETE_BUTTON = By.xpath("//button[text()='Delete']");
	By DELETE_IMAGE_LIB_CONFIRM = By.xpath("//*[text()='Delete'][contains(@name,'DeleteConfirmation')]");

	void verifyImageModal();

	void selectImage();

	void verifyURL();

	void createFolder(String folderName);

	void searchFolder(String folderName);

	void openFolder();

	void uploadImage(String fileName);

	void uploadImageWithAutoIT(String fileName) throws IOException;

	void navigateTopFolder();

	void deleteFolder();

	void cancelModalPopUp();

	void createFolderInImageLibrary(String folderName);

	void openImageLibraryFolder();

	void deleteFolderImageLibrary();
}
