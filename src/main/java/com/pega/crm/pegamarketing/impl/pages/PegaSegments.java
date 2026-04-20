package com.pega.crm.pegamarketing.impl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaSegment;
import com.pega.crm.pegamarketing.pages.Segments;
import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.FrameImpl;

public class PegaSegments extends PegaLandingPage implements Segments {

	public PegaSegments(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	PegaWebElement elmt = null;

	public class ImageCatalogImpl extends FrameImpl implements ImageCatalog {

		public ImageCatalogImpl(String frameID, TestEnvironment testEnv) {
			super(frameID, testEnv);
		}

		public void search(String picName) {
			elmt.findElement(By.id(SEARCH_TXTFIELD_ID)).sendKeys(picName + Keys.TAB);
			elmt.findElement(By.id(FIND_BUTTON_ID)).click();
		}

		public void chooseImage(String picName) {
			search(picName);
			elmt.findElement(By.xpath("//div[contains(@title,'" + picName + "')]")).click();
		}

		public void ok() {
			elmt.findElement(By.id(OK_BUTTON_ID)).click(false);
		}
	}

	public Segment createSegment() {
		findElement(CREATE_BTN).click();
		String frameId = getActiveFrameId(true);
		Segment segment = new PegaSegment(frameId, this.testEnv);
		return segment;
	}

	public Segment openSegmentRule(String segName) {
		findElement(Segments.SEARCH_INPUT_BOX).sendKeys(segName + Keys.TAB);
		findElement(Segments.VIEW_BTN).click();
		findElement(By.linkText(segName)).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Segment segment = new PegaSegment(frameId, this.testEnv);
		return segment;
	}
}
