package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.PropositionFilter;
import com.pega.crm.pegamarketing.rules.WhenRule;

public interface Eligibilities extends LandingPage {

	By CREATE_WHEN_CONDITION_OPTION = By.xpath("//span[(@class='menu-item-title')and text()='Create When Condition']");
	By CREATE_PROPOSTION_FILTER_OPTION = By
			.xpath("//span[(@class='menu-item-title')and text()='Create Proposition Filter']");

	public WhenRule createWhenRule();

	public PropositionFilter createPropositionFilter();
}
