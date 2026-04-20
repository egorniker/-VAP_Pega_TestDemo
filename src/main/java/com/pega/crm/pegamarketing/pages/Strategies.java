package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.MarketingStrategy;

public interface Strategies extends LandingPage {

	By GUIDE_ME_THROUGH_IT = By.xpath("//span[text()='Guide me through it']");

	By START_WITH_NEW_CANVAS = By.xpath("//span[text()='Start with new canvas']");
	/**
	 * this is used for creating a strategy via Guide me through it
	 * 
	 * @return it will return Marketing strategy page
	 */
	MarketingStrategy createStrategyViaGuideMeThroughIt();

	/**
	 * this is used for creating a strategy via Start with New Canvas Option
	 * @return it will return Marketing Strategy page
	 */
	MarketingStrategy createStrategyViaStartWithNewCanvas();


}