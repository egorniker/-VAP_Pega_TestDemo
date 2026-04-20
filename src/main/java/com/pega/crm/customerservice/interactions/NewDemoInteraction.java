package com.pega.crm.customerservice.interactions;

public interface NewDemoInteraction extends Interactions {

	String ACCEPT_CALL_XPATH = "//div[@class='pzbtn-mid' and text()='Accept']";

	void acceptCall();

	void switchToTab(String tabname);

}
