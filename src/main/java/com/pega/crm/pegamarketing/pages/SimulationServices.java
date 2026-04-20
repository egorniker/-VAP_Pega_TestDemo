package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

public interface SimulationServices {
	By OVERALL_RESULT_XPATH = By
			.xpath("//div[text()='Overall Result']/ancestor::tr[1]/following-sibling::tr[1]//table//td");
	By HTTP_STATUS_CODE = By.xpath("//tr//td[text()='HTTP Status code']/following-sibling::td");
	By DATA_TYPE_VALUE = By.xpath("//tr//td[text()='java.lang.String']/following-sibling::td");
}
