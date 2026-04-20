package com.pega.crm.customerservice.interactions.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaPhoneCall extends PegaInteractions implements PhoneCall {

	public PegaPhoneCall(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public String frameId = null;
	public Wizard newWizard = null;
	public static String timeStamp = "";

	@Override
	public void searchByEmail(String emailId) {
		PegaWebElement collapseIcon = findElement(By.xpath("//div[@title='Disclose Advanced search']"));
		collapseIcon.click();
		PegaWebElement email = findElement(By.id(SEARCH_EMAIL_ID));
		email.sendKeys(emailId);
		PegaWebElement search = findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();

	}

	public String getTomorrowDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}

	@Override
	public void scheduleActivity(String type, String account, String topic, String assign, String operator) {

		PegaWebElement activity = findElement(By.xpath("//div[text()='Conference call']"));
		activity.click();
		PegaWebElement date = findElement(By.id("StartDate"));
		date.sendKeys(getTomorrowDate());
		DropDown linkAccount = findSelectBox(By.id("SelectedAccountNumber"));
		linkAccount.selectByValue(account);
		DropDown topicValue = findSelectBox(By.id("Topic"));
		topicValue.selectByValue(topic);
		DropDown schedule = findSelectBox(By.id("ScheduleFor"));
		schedule.selectByValue(assign);

		DropDown opName = findSelectBox(By.id("Operator"));
		opName.selectByValue(operator);
		DropDown otherPhone = findSelectBox(By.id("TelephoneNumber"));
		otherPhone.selectByValue("Other");

		PegaWebElement phnum = findElement(By.xpath("//input[@id='OtherPhone']"));
		phnum.sendKeys("987654321");

		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

}
