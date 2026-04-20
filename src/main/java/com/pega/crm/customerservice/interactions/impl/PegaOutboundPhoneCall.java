package com.pega.crm.customerservice.interactions.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaOutboundPhoneCall extends PegaInteractions implements OutboundPhoneCall {

	public PegaOutboundPhoneCall(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public String frameId = null;
	public Wizard newWizard = null;

	@Override
	public void CaptureCallReasonAndPlaceCall(String reason, String status) {

		DropDown reasonDropdown = findSelectBox(By.xpath(OUTBOUND_REASON_XPATH));
		reasonDropdown.selectByValue(reason);

		String finalXpath = new String(OUTBOUND_STATUS_XPATH).replace("#status#", status);
		PegaWebElement rdbutton = findElement(By.xpath(finalXpath));
		rdbutton.click();

		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	public void exitInteraction(String exitComments) {

		findElement(By.xpath(EXITCOMMENT_TEXTAREA_XPATH)).sendKeys(exitComments);
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	public void launchOutboundWrapUp() {
		PegaWebElement wrapUp = findElement(By.xpath(OUTBOUND_WRAP_UP_XPATH));
		wrapUp.click();
	}

	public void launchOutboundInteractionforFirst(String contactName, String callStatus) {
		String custName;
		String phType;

		PegaWebElement outboundCallTable = findElement(By.xpath(OUTBOUND_SIMULATION_TABLE_XPATH));
		int outboundCallRows = outboundCallTable.findElements(By.tagName("tr")).size();

		for (int i = 2; i <= outboundCallRows; i++) {
			custName = findElement(
					By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr[" + i
							+ "]/td[1]/div/span")).getText();

			phType = findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["
					+ i + "]/td[4]/div/span")).getText();

			DropDown callStatusDropdown = findSelectBox(
					By.xpath("//select[contains(@name,'l" + (i - 1) + "$pOutboundCallStatus')]"));
			if (custName.equalsIgnoreCase(contactName) && phType.equalsIgnoreCase("Business Phone")) {
				callStatusDropdown.selectByValue(callStatus);
			}
			if (custName.equalsIgnoreCase(contactName)
					&& (phType.equalsIgnoreCase("Home Phone") || phType.equalsIgnoreCase("HOM"))) {
				callStatusDropdown.selectByValue(callStatus);
			}

			if (custName.equalsIgnoreCase(contactName)
					&& (phType.equalsIgnoreCase("Mobile Phone") || phType.equalsIgnoreCase("MOB"))) {
				callStatusDropdown.selectByValue(callStatus);
			}

		}

	}

	public void submitChanges() {

		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

}
