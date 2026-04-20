package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Contacts;

public class PegaContactList extends PegaWorkObject implements ContactList {

//	public PegaContactList(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaContactList(TestEnvironment testEnv) {
		super(testEnv);
	}

	public Contacts createContact() {
		findElement(By.xpath(CREATE_CONT_BTN_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Contacts Cont = new PegaContact(frameId, testEnv);
		Contacts Cont = new PegaContact(testEnv);
		return Cont;
	}

	public Contacts navigateContact(StringBuffer contactName) {

		findElement(By.id(CONT_SEARCH_FIELD_ID)).sendKeys(contactName);
		findElement(By.xpath(CONT_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Contacts Cont = new PegaContact(frameId, testEnv);
		Contacts Cont = new PegaContact(testEnv);
		return Cont;
	}

	public Contacts navigateContact(String contactName) throws InterruptedException {
		
		pegaDriver.handleWaits().waitForNoThrobber();
		pegaDriver.handleWaits().waitForElementVisibility(By.id(CONT_SEARCH_FIELD_ID));
		findElement(By.id(CONT_SEARCH_FIELD_ID)).sendKeys(contactName);
		findElement(By.id(CONT_SEARCH_FIELD_ID)).sendKeys(Keys.ENTER);
		
		pegaDriver.handleWaits().waitForNoThrobber();
		findElement(By.xpath(CONT_NAME_XPATH));	
		findElement(By.xpath(CONT_NAME_XPATH)).click();		
		String frameId = getActiveFrameId(false);
		pegaDriver.handleWaits().waitForNoThrobber();
//		Contacts Cont = new PegaContact(frameId, testEnv);
		Contacts Cont = new PegaContact(testEnv);
		return Cont;
	}

	public Contacts openFirstContact() {
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		String frameId = getActiveFrameId(false);
//		Contacts Cont = new PegaContact(frameId, testEnv);
		Contacts Cont = new PegaContact(testEnv);
		return Cont;
	}

	@Override
	public boolean isContactListEmpty() {

		try {
			findElement(By.xpath(NO_CONTACTS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
