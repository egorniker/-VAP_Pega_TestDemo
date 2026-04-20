package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.crm.pegamarketing.rules.SMSTreatment;
import com.pega.util.XPathUtil;


public interface Treatments extends LandingPage {

	By TREATMENTS_PAGE_HEADER = By.xpath("//span[text()='Treatments' and @class='workarea_header_titles']");
	By ISSUE_GROUP_DIV = By.xpath("//a[contains(@data-click,'ShowIssueGroupOverlay')]");
	By SEARCH_INPUT_BOX = By.xpath(XPathUtil.getDataTestIDXpath("20160202134136053752179"));
	By EMAILS_TAB = By.xpath("//h3[text()='Email']");
	By SMS_TAB = By.xpath("//h3[text()='SMS']");
	By SECTIONS_TAB = By.xpath("//h3[text()='Sections']");
	By PARAGRAPHS_TAB = By.xpath("//h3[text()='Paragraphs']");
	By CREATE_EMAIL_SPAN = By.xpath("//span[text()='Create email']");
	By CREATE_SMS_SPAN = By.xpath("//span[text()='Create SMS']");
	
	//By CREATE_EMAIL = By.xpath(XPathUtil.getDataTestIDXpath("201802050902450494528"));
	By CREATE_EMAIL = By.xpath("//span[text()='Email' and @class='menu-item-title']");
	//By CREATE_INTERNAL_EMAIL = By.xpath(XPathUtil.getDataTestIDXpath("202003180151480433585"));
	By CREATE_INTERNAL_EMAIL = By.xpath("//span[text()='Internal' and @class='menu-item-title']");
	By OUTBOUND_ITEM= By.xpath("//span[text()='Outbound' and @class='menu-item-title']");
	
	/**
	 * this method just clicks on create method
	 */
	void create();

	/**
	 * this method clicks on Create email link
	 * 
	 * @return Create Email Treatment page
	 */
	EmailTreatment createEmailTreatment();

	SMSTreatment createSMSTreatment();
}
