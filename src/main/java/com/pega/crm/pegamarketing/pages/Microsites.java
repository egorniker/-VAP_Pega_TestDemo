package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

public interface Microsites extends LandingPage {
	By SUBSCRIPTION_LABEL = By.xpath("//table//tr//td[@data-importance='secondary' and @data-attribute-name='Name']");
	By DESCRIPTION_TEXT = By
			.xpath("//table//tr//td[@data-importance='secondary' and @data-attribute-name='Description']");

	Subscription launchMicrositeURL(String micrositeURL);
}
