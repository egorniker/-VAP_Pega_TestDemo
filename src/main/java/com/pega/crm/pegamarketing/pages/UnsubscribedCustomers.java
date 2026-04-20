package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;

public interface UnsubscribedCustomers extends RuleInstance {
	By REFRESH_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Refresh"));
	By ALL_LABEL = By.xpath("//span[contains(text(),'ALL')]");
	By NOT_INTRESTED_LABEL = By.xpath("//div[@id='report_body']//span[contains(text(),'Not Interested')]");
	By ALL_COUNT = By
			.xpath("(//div[@id='report_body']//table//tr[@id='GrandTotal']//td/following-sibling::td//span)[2]");
	By NOT_INTRESTED_COUNT = By.xpath(
			"(//tr[@id='GrandTotal']/following-sibling::tr[.//span[contains(text(),'Not Interested')]]//td/following-sibling::td//span)[2]");

	void refreshReports();

	SubscriptionReportDrillDown drillDownNotIntrestedReport();

	public interface SubscriptionReportDrillDown {
		By CUSTOMER_VALUE_XPATH = By
				.xpath("//tr[contains(@id,'ppzDrillDownReport')]//td[@data-attribute-name='Customer']");
		By ISSUE_VALUE_XPATH = By.xpath("//tr[contains(@id,'ppzDrillDownReport')]//td[@data-attribute-name='Issue']");
		By GROUP_VALUE_XPATH = By.xpath("//tr[contains(@id,'ppzDrillDownReport')]//td[@data-attribute-name='Group']");
		By OFFER_VALUE_XPATH = By.xpath("//tr[contains(@id,'ppzDrillDownReport')]//td[@data-attribute-name='Offer']");
	}
}
