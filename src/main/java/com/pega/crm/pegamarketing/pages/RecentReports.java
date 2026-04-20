package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

public interface RecentReports extends LandingPage {
	By UNSUBSCRIBED_CUSTOMERS_LINK = By.xpath("//a[@title='Subscription']");
	By LAST30DAYSREPORTLINK = By
			.xpath("//a[contains(.,'Customers who have unsubscribed from emails during the last 30 days')]");
	By RECENT_REPORT_HEADER = By.xpath("//label[contains(text(),' Showing recent reports')]");

	/**
	 * This will open report for unsubsribed customers
	 */
	UnsubscribedCustomers openUnsubsribedCustomersReport();
}
