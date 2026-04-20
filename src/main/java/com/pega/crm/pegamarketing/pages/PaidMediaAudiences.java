package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

public interface PaidMediaAudiences extends LandingPage {

	static By PAIDMEDIA_AUDIENCES_PATH = By
			.xpath("//*[text()='Paid Media Audiences'][@data-test-id='2015050411004109883501']");
	static By SEARCH_INPUT_BOX = By.xpath("//input[contains(@placeholder,'by name, description')]");
	static By VIEW_BUTTON_LINK = By.xpath("//button[contains(.,'View')]");

	/**
	 * this method searches for the audienceName
	 * 
	 * @param audienceName
	 *            audience name to be searched
	 */
	void searchAudienceByName(String audienceName);

	/**
	 * this method verifies that the paidmedia audience landing page loads
	 */
	String verifyPaidAudiencePg();
}
