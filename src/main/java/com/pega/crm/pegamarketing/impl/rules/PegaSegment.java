package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.pages.Segments.ImageCatalog;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaSegment extends PegaRuleInstance implements Segment {

	public PegaSegment(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public class PegaUploadFileDialog extends PegaModalDialog implements UploadFileDialog {
		Frame frame;

		public PegaUploadFileDialog(Frame frame) {
			super(frame);
			this.frame = frame;
		}

		@Override
		public void chooseFile(String fileName) {
			String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Data"
					+ System.getProperty("file.separator") + fileName;
			frame.findElement(CHOOSE_FILE_TEXTBOX).sendKeys(filePath + Keys.TAB);
		}

		@Override
		public void setPurpose(String purpose) {
			frame.findSelectBox(PURPOSE_SELECTBOX).selectByVisibleText(purpose);
		}

		@Override
		public void next() {
			frame.findElement(NEXT_BUTTON).click();
		}

		@Override
		public void startValidation() {
			frame.findElement(START_VALIDATION_BUTTON).click();
		}

		@Override
		public void continueImport() {
			PegaWebElement button = frame.findElement(CONTINUE_IMPORT_BUTTON);
			pegaDriver.handleWaits().waitForElementClickable(CONTINUE_IMPORT_BUTTON);
			button.click();
		}

		@Override
		public void finish() {
			pegaDriver.handleWaits().waitForElementClickable(FINISH_BUTTON);
			frame.findElement(FINISH_BUTTON).click();
		}

		@Override
		public String getValidRows() {
			pegaDriver.handleWaits().waitForElementClickable(CONTINUE_IMPORT_BUTTON);
			return frame.findElement(VALID_ROWS_SPAN).getText();
		}
	}

	public class PegaAddCriteriaDialog extends PegaModalDialog implements AddCriteriaDialog {

		private Frame frameElmt;

		public PegaAddCriteriaDialog(Frame frameElmt) {
			super(frameElmt);
			this.frameElmt = frameElmt;
		}

		public void selectCriteria(String criteria) {
			if (!frameElmt.verifyElement(By.xpath("//tr[.//span[text()='" + criteria
					+ "'] and @pl_index]|//tr[.//span[contains(text(),'." + criteria + "')] and @pl_index]"))) {
				searchCriteria(criteria);
			}
			frameElmt
					.findElement(By.xpath("//tr[.//span[text()='" + criteria
							+ "'] and @pl_index]|//tr[.//span[contains(text(),'." + criteria + "')] and @pl_index]"))
					.click();
		}

		private void searchCriteria(String criteria) {
			frameElmt.findElement(SEARCH_INPUT_BOX).sendKeys(criteria + Keys.TAB);
			frameElmt.findElement(MAGNIFIER_ICON).click();
			frameElmt.findElement(MAGNIFIER_ICON).click();
		}

		public String selectDataFieldCriteria(String criteria) {
			frameElmt.findElement(By.xpath("//h3[contains(@id,'header') and text()='Data fields']")).click();
			selectCriteria(criteria);
			return frameElmt
					.findElement(By.xpath(
							"(//tr[.//span[text()='" + criteria + "'] and @pl_index]|//tr[.//span[contains(text(),'."
									+ criteria + "')] and @pl_index])//td[@data-attribute-name='Description']//span"))
					.getText();
		}

		public void selectSegmentCriteria(String criteria) {
			frameElmt.findElement(By.xpath("//h3[contains(@id,'header') and text()='Segments']")).click();
			selectCriteria(criteria);
		}
	}

	public class PegaSelectItemsDialog extends PegaModalDialog implements SelectItemsDialog {
		private Frame frameElmt;

		public PegaSelectItemsDialog(Frame frameElmt) {
			super(frameElmt);
			this.frameElmt = frameElmt;
		}

		public void selectItems(String... items) {
			for (int i = 0; i < items.length; i++) {
				findElement(By.xpath("//input[@data-title='" + items[i] + "']")).click();
			}
			pegaDriver.handleWaits().waitForElementNotVisible(By.xpath("//h2[text()='0 items selected ']"));

		}

	}

	public void changeImage(String picName) {
		findElement(By.partialLinkText(CHANGE_IMAGE_LINKTTEXT)).click();
		Frame frame = findFrame("pzDisplayModalDialog");
		frame.findElement(By.id(ImageCatalog.SEARCH_TXTFIELD_ID)).sendKeys(picName + Keys.TAB);
		frame.findElement(By.id(ImageCatalog.FIND_BUTTON_ID)).click();
		frame.findElement(By.xpath("//div[contains(@title,'" + picName + "')]")).click();
		Assert.assertTrue(frame.findElement(By.id(ImageCatalog.OK_BUTTON_ID)).isEnabled(),
				"OK button is not enabled after selecting image from catalog..!!");
		frame.findElement(By.id(ImageCatalog.OK_BUTTON_ID)).click(false);
		/*
		 * ImageCatalog ie = new ImageCatalogImpl(frame); ie._setEnvironment(testEnv,
		 * "pzDisplayModalDialog");
		 */
	}

	public void close() {
		findElement(RuleInstance.CLOSE_ICON).click(false);
	}

	public void addGroup() {
		findElement(ADD_GROUP_LINK).click();
	}

	public AddCriteriaDialog addCriteria() {
		findElement(ADD_CRITERIA_LINK).click();
		return new PegaAddCriteriaDialog(this);
	}

	public void enterCriteriaValue(String criteriaName, String criteriaValue) {
		findElement(By.xpath(CRITERIA_VALUE_TEXT_BOX2.replace("<Criteria_Name>", criteriaName)))
				.sendKeys(criteriaValue + Keys.TAB);
	}

	public void enterCriteriaType(String criteriaName, String criteriaType) {
		findSelectBox(By.xpath(CRITERIA_VALUE_TYPE_SELECT2.replace("<Criteria_Name>", criteriaName)))
				.selectByVisibleText(criteriaType);
	}

	public void enterCriteriaValue(String criteriaValue) {
		findElement(CRITERIA_VALUE_TEXT_BOX).sendKeys(criteriaValue + Keys.TAB);
	}

	public void enterCriteriaType(String criteriaType) {
		findSelectBox(CRITERIA_VALUE_TYPE_SELECT).selectByVisibleText(criteriaType);

	}

	public SelectItemsDialog selectItemsForInList() {
		findElement(SELECT_ITEM_INLIST_LINK).click();
		return new PegaSelectItemsDialog(this);

	}

	public void run() {
		findElement(RuleInstance.RUN_BUTTON).click();
	}

	public void waitForRun() {
		while (verifyElement(STOP_LINK)) {
			pegaDriver.handleWaits().sleep(10);

		}
		pegaDriver.handleWaits().waitForElementNotPresence(STOP_LINK);
		pegaDriver.waitForDocStateReady(4);
	}

	public void selectComparision(String type) {
		findSelectBox(COMPARE_TYPE_SELECT_BOX).selectByVisibleText(type);
	}

	public void selectListType() {
		pegaDriver.handleWaits().waitForElementVisibility(LIST_RADIO_BUTTON);
		PegaWebElement listBasedSegementRadio = findElement(LIST_RADIO_BUTTON);
		testEnv.getScriptExecutor().click(listBasedSegementRadio);
	}

	public void selectCriteriaType() {
		pegaDriver.handleWaits().waitForElementVisibility(CRITERIA_RADIO_BUTTON);
		findElement(CRITERIA_RADIO_BUTTON).click();
	}

	public void clickEnablePaidSync() {
		pegaDriver.handleWaits().waitForElementVisibility(ENABLE_PAID_SYNC);
		findElement(ENABLE_PAID_SYNC).click();
	}

	public void selectPaidDestination() {
		findElement(PAID_DESTINATION).click();
	}

	public UploadFileDialog importCustomerRecords() {
		findElement(IMPORT_LINK).click();
		return new PegaUploadFileDialog(this);
	}

	public void enableRefreshableSegment() {
		findElement(REFRESHABLE_SEGMENT_CHECKBOX).click();
	}

	public void enableRefreshChildSegments() {
		findElement(REFRESH_CHILD_SEGMENTS_CHECKBOX).click();
	}
}
