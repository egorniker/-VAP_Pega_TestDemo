package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.Offer;

public interface Offers extends LandingPage {

	By OFFERS_PAGE_HEADER = By.xpath("//span[text()='Actions' and @class='workarea_header_titles']");
	By ISSUE_GROUP_DIV = By.xpath("//a[contains(@data-click,'ShowIssueGroupOverlay')]");
	By SEARCH_INPUT_BOX = By.xpath("//input[@placeholder='by name or description']");

	/**
	 * this method just clicks on create method
	 * 
	 * @return
	 */
	Offer create();
}
