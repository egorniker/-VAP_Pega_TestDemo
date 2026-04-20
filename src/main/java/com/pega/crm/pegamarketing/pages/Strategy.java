package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.rules.RuleInstance;

public interface Strategy extends RuleInstance {

	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: Strategy.java 174698 2018-02-08 08:24:26Z SachinVellanki $";

	By CUSTOM_FIELDS_ADD_FIELD = By.xpath("//div[@node_name='RuleFormHistory_CustomFields']//a[text()='Add field']");

	/**
	 * It is used to add a custom field in the history
	 * 
	 * @param name
	 * @param value
	 */
	void addCustomField(String name, String value);

	/**
	 * It is used to check if a custom field is added
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	boolean isCustomFieldAdded(String name, String value);

	/**
	 * It is used to check that strategy has been checked in
	 * 
	 * @return
	 */
	boolean isCheckedIn();

	public interface AddCustomFieldsDialog extends ModalDialog {
		/**
		 * It is used to set name and value in the custom field
		 * 
		 * @param name
		 * @param value
		 */
		void setNameAndValue(String name, String value);
	}

}
