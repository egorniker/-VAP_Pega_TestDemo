package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.framework.elmt.Frame;

public interface Segments extends LandingPage {

	static By SEARCH_INPUT_BOX = By.xpath(PMXPathUtil.getDataTestIdXPath("201411141635100877648"));
	static By VIEW_BTN = By.xpath("//button[text()='View']");
	static By CREATE_BTN = By.xpath("//button[text()='Create']");

	/**
	 * this method clicks on crate button and so opens segment rule configuration
	 * page
	 * 
	 * @return returns Segment configuration page
	 */
	Segment createSegment();

	/**
	 * this method will opens the given segment
	 * 
	 * @param segName
	 *            segment name to be opened
	 * @return
	 */
	Segment openSegmentRule(String segName);

	public interface ImageCatalog extends Frame {

		static String SEARCH_TXTFIELD_ID = "searchText";
		static String FIND_BUTTON_ID = "findButton";
		static String OK_BUTTON_ID = "btnOk";

		void search(String string);

		void chooseImage(String picName);

		void ok();
	}
}
