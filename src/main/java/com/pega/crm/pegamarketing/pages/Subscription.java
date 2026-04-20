package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.utils.PMXPathUtil;

public interface Subscription extends LandingPage {
	By UNSUBSCRIBE_LABEL = By.xpath("//div[text()='Unsubscribe']");
	By NOT_INTRESTED_RADIO_BUTTON = By
			.xpath("//input[@class='Radio rb_ ' and @value='Not Interested']/following-sibling::label");
	By UNSUBSCRIBE_BUTTON = By.xpath(PMXPathUtil.getButtonStrongPzhcPzBtnXPath("Unsubscribe"));
	By UNSUBSCRIPTION_SUCCESS_LABEL = By.xpath("//div[@string_type ='label'and text()='Unsubscription succeeded!']");

	void unsubscribe();

	void closeSubscription();
}
