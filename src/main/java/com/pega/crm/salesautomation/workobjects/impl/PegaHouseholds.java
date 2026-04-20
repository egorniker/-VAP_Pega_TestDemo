package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Households;
import com.pega.crm.salesautomation.workobjects.WorkObject;
import com.pega.util.XPathUtil;

public class PegaHouseholds extends PegaWorkObject implements Households {

//	public PegaHouseholds(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaHouseholds(TestEnvironment testEnv) {
		super(testEnv);
	}

//	String HH_HOUSEHOLD_PAGE_HEADER_XPATH = "//*[text()='Household']";
	String HH_HOUSEHOLD_PAGE_HEADER_XPATH = "//h2[text()='New    Household   ']";
	String HH_NAME_ID = "Name";
	String HH_DESCRIPTION_ID = "pyDescription";
	String HH_OK_BUTTON_XPATH = "//button[contains(@data-click,'doFormSubmit')]//*[text()='OK']";
	String HH_NAME_VALUE_XPATH = "//span[text()='Name']/../div/span";
	String HH_PHONENUMBER_ID = "PhoneNumber";
	String HH_PHONENUMBER_VALUE_XPATH = "//span[text()='Phone number']/../div/span";
//	String HH_ACTIVE_MEMBER_XPATH = "//*[contains(text(), 'Active member')]/../div//span";
	String HH_ACTIVE_MEMBER_XPATH = "//span[contains(text(), 'Members')]/../span[2]";
//	String HH_ADDMEMBER_BUTTON_XPATH = PegaUtil.getButtonXpath("Add/Remove members");
	String HH_ADDMEMBER_BUTTON_XPATH = "//a[@title='Add Row']";
	String HH_STREET_ID = "pyStreet";
	String HH_CITY_ID = "pyCity";
	String HH_STATE_ID = "pyState";
	String HH_ZIPCODE_ID = "pyPostalCode";
	String HH_COUNTRY_ID = "pyCountry";
	String HH_FILTERCONTACT_ID = "//div//span//input[@id='SelectHHMember1']";
	String HH_FILTER_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Filter");
//	String HH_FILTER_RESULT_XPATH = "//td[@data-attribute-name='First name']//span";
	String HH_FILTER_RESULT_XPATH = "//select[@id='FromRole1']";
//	String HH_ROLE_ID = "//tr[contains(@oaargs,'openWorkItem')]/td[@data-attribute-name='RoleInfo']//select";
	String HH_ROLE_ID = "//select[@data-test-id='20150305160022097730477']";
	String HH_SUBMIT_BUTTON_ID = "ModalButtonSubmit";
	String HH_SUBMIT_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Submit");
	String HH_MEMBERS_LIST_XPATH = "//tr[contains(@id, 'Members')]";
	String HH_DESCRIPTION_XPATH = "//span[text()='Description']/../div/span";
	String HH_LISTOFMEMBERS_NAME_XPATH = "//div[@data-node-id='FirstNameAccess']//a";
	String HH_LISTOFMEMBERS_ROLE_XPATH = "//td[@data-attribute-name='Role']/span";
	String HH_CLOSE_COMMENTS_ID = "CloseComments";

	String HH_SUBTABS_XPATH = "//div[@role='tab']//h2";

	@Override
	public void setHouseholdName(String householdName) {
		try {
			findElement(By.id(HH_NAME_ID)).sendKeys(householdName);
			findElement(By.id(HH_NAME_ID)).sendKeys(Keys.TAB);
		}catch(Exception e){
			findElement(By.id(HH_NAME_ID)).sendKeys(householdName);
			findElement(By.id(HH_NAME_ID)).sendKeys(Keys.TAB);
		}
	}

	@Override
	public void setPhoneNumber(String PhoneNumber) {
		try {
			findElement(By.id(HH_PHONENUMBER_ID)).sendKeys(SELECT_ALL);
			findElement(By.id(HH_PHONENUMBER_ID)).sendKeys(PhoneNumber);
		}catch (Exception e){
			findElement(By.id(HH_PHONENUMBER_ID)).sendKeys(SELECT_ALL);
			findElement(By.id(HH_PHONENUMBER_ID)).sendKeys(PhoneNumber);
		}
	}

	@Override
	public void setDescription(String Description) {
		try {
			findElement(By.id(HH_DESCRIPTION_ID)).click();
			findElement(By.id(HH_DESCRIPTION_ID)).sendKeys(SELECT_ALL);
			findElement(By.id(HH_DESCRIPTION_ID)).sendKeys(Description);
		}catch (Exception e){
			findElement(By.id(HH_DESCRIPTION_ID)).click();
			findElement(By.id(HH_DESCRIPTION_ID)).sendKeys(SELECT_ALL);
			findElement(By.id(HH_DESCRIPTION_ID)).sendKeys(Description);
		}
	}

	@Override
	public void setStreet(String Street) {
		try {
			findElement(By.id(HH_STREET_ID)).sendKeys(Street);
		}catch (Exception e){
			findElement(By.id(HH_STREET_ID)).sendKeys(Street);
		}
	}

	@Override
	public void setCity(String City) {
		try {
			findElement(By.id(HH_CITY_ID)).sendKeys(City);
		}catch (Exception e){
			findElement(By.id(HH_CITY_ID)).sendKeys(City);
		}
	}

	@Override
	public void setState(String State) {
		try {
			findElement(By.id(HH_STATE_ID)).sendKeys(State);
		}catch (Exception e){
			findElement(By.id(HH_STATE_ID)).sendKeys(State);
		}

	}

	@Override
	public void setPincode(String Pin) {
		try {
			findElement(By.id(HH_ZIPCODE_ID)).sendKeys(Pin);
		}catch (Exception e){
			findElement(By.id(HH_ZIPCODE_ID)).sendKeys(Pin);
		}
	}

	@Override
	public void setCountry(String Country) {
		try {
			findSelectBox(By.id(HH_COUNTRY_ID)).selectByVisibleText("India");
			// findElement(By.id(HH_COUNTRY_ID)).sendKeys(Country);
		}catch (Exception e){
			findSelectBox(By.id(HH_COUNTRY_ID)).selectByVisibleText("India");
		}

	}

	@Override
	public String getHouseholdPageHeader() {
		waitHandler.waitForElementVisibility(By.xpath(HH_HOUSEHOLD_PAGE_HEADER_XPATH));
		String hhHeader = findElement(By.xpath(HH_HOUSEHOLD_PAGE_HEADER_XPATH)).getText();
		return hhHeader;

	}

	@Override
	public void clickAddMember() {
		getMembersSubtab();
		findElement(By.xpath(HH_ADDMEMBER_BUTTON_XPATH)).click();

	}

	@Override
	public void clickAddMemberinCreate() {
		findElement(By.xpath(HH_ADDMEMBER_BUTTON_XPATH)).scrollIntoView();
		findElement(By.xpath(HH_ADDMEMBER_BUTTON_XPATH)).click();

	}

	@Override
	public void searchContact(String Contact) {

//		findElement(By.xpath(HH_FILTERCONTACT_ID)).sendKeys(Contact);
//		findElement(By.xpath(HH_FILTER_BUTTON_XPATH)).click();
		try {
			findAutoComplete(By.xpath(HH_FILTERCONTACT_ID)).setValue(Contact);
		}catch (Exception e){
			findAutoComplete(By.xpath(HH_FILTERCONTACT_ID)).setValue(Contact);
		}
	}

	@Override
	public String getHouseholdName() {
		String hhName = findElement(By.xpath(HH_NAME_VALUE_XPATH)).getText();
		return hhName;
	}

	@Override
	public String getPhoneNumber() {

		String hhPhoneNumber = findElement(By.xpath(HH_PHONENUMBER_VALUE_XPATH)).getText();
		return hhPhoneNumber;
	}

	@Override
	public int getActiveMember() {

		int hhActiveMember = Integer.parseInt(findElement(By.xpath(HH_ACTIVE_MEMBER_XPATH)).getText());
		return hhActiveMember;

	}

	@Override
	public java.util.List<WebElement> getListOfActiveMember() {
		getMembersSubtab();
		java.util.List<WebElement> listofmember = findElements(By.xpath(HH_MEMBERS_LIST_XPATH));
		System.out.println("Size of the members list:" + listofmember.size());
		return listofmember;
	}

	@Override
	public String getDescription() {
        findElement(By.xpath("//ul[contains(@data-menu-id,'WorkCaseNavigation')]//*[text() ='Details']")).click();
        pegaDriver.handleWaits().waitForElementVisibility(By.xpath(HH_DESCRIPTION_XPATH));
		String hhDescription = findElement(By.xpath(HH_DESCRIPTION_XPATH)).getText();
		return hhDescription;
	}

	@Override
	public String getMemberName() {
//		getMembersSubtab();
		findElement(By.xpath("//ul[contains(@data-menu-id,'WorkCaseNavigation')]//*[text() ='Members']")).click();
		String hhMemberName = findElement(By.xpath(HH_LISTOFMEMBERS_NAME_XPATH)).getText();
		return hhMemberName;
	}

	@Override
	public String getMemberRole() {

		String hhMemberRole = findElement(By.xpath(HH_LISTOFMEMBERS_ROLE_XPATH)).getText();
		return hhMemberRole;
	}

	@Override
	public void clickAddOrRemoveMember() {

	}

	@Override
	public void removeFriendMember() {

		// findElement(By.xpath("//td[@data-attribute-name='RoleInfo']//select")).scrollIntoView();
		List<WebElement> wb = findElements(By.xpath("//td[@data-attribute-name='RoleInfo']//select"));
		System.out.println("Size of the List:" + wb.size());
		for (WebElement wb1 : wb) {
			System.out.println("Iterating for each webElement");
			Select sc = new Select(wb1);
			WebElement SelectedRole = sc.getFirstSelectedOption();
			String s = SelectedRole.getText();
			if (s.equalsIgnoreCase("Friend")) {
				System.out.println("Selecting the required Member");
				SelectedRole.findElement(By.xpath("../ancestor::tr[1]//td[@headers='a6']//a")).click();
				break;
			}
		}
	}

	@Override
	public boolean checkContactInHousehold(String contactName) {

		List<WebElement> Householdcontacts;
		Householdcontacts = findElements(
				By.xpath("//table[contains(@pl_prop_class,'HouseholdMember')]/tbody/tr[contains(@class,'Row')]"));
		int rows = Householdcontacts.size();

		for (int i = 1; i <= rows; i++) {
			WebElement wb = findElement(By.xpath(
					"//table[contains(@pl_prop_class,'HouseholdMember')]//tr[contains(@id,'SelectedMembers') and @pl_index='"
							+ i + "']//div[contains(@node_name,'FirstName')]//span//a"));
			WebElement wb1 = findElement(By.xpath(
					"//table[contains(@pl_prop_class,'HouseholdMember')]//tr[contains(@id,'SelectedMembers') and @pl_index='"
							+ i + "']//div[contains(@node_name,'LastName')]//span//a"));
			if (contactName.contains(wb.getAttribute("text")) && contactName.contains(wb1.getAttribute("text")))
				;
			return true;
		}
		return false;

	}

	@Override
	public void clickMember(String contactName) {

		List<WebElement> Householdcontacts;
		Householdcontacts = findElements(
				By.xpath("//table[contains(@pl_prop_class,'HouseholdMember')]/tbody/tr[contains(@class,'Row')]"));
		int rows = Householdcontacts.size();

		for (int i = 1; i <= rows; i++) {
			WebElement wb = findElement(By.xpath(
					"//table[contains(@pl_prop_class,'HouseholdMember')]//tr[contains(@id,'Members') and @pl_index='"
							+ i + "']//div[contains(@node_name,'FirstName')]//span//a"));
			if (contactName.contains(wb.getAttribute("text")))
				wb.click();
		}
	}

	@Override
	public void setComments(String Comments) {

		findElement(By.id(HH_CLOSE_COMMENTS_ID)).sendKeys(Comments);

	}

	@Override
	public ArrayList<String> getSubTabs() {
		ArrayList<String> s = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(HH_SUBTABS_XPATH));

		for (WebElement w : wb) {
			String s1 = w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}

	@Override
	public void clickCreate() {
		create();

	}

	@Override
	public void clickEdit() {
		edit();
	}

	@Override
	public void clickSubmit() {
		submit();
	}

	@Override
	public void setHouseholdContact(String Role) {
		for(int i=0;i<10;i++) {
			try {
				waitHandler.waitForElementClickable(By.xpath(HH_FILTER_RESULT_XPATH));
				findElement(By.xpath(HH_FILTER_RESULT_XPATH)).click();
				break;
			}catch (Exception e){
				try {
					Thread.sleep(5000);i++;
					} catch (InterruptedException e1) {}
			}
		}
		findSelectBox(By.xpath(HH_ROLE_ID)).selectByVisibleText(Role);
//		submit();
	}

	@Override
	public void selectHousehold(String HouseholdName) {
		findAutoComplete(By.id("HouseholdToJoinID")).setValue(HouseholdName);
		clickSubmit();
		clickSubmit();
	}

	@Override
	public void clickClose() {
		close();
	}

	@Override
	public boolean isActionItemValuePresent(String dropDownValue) {
		return (isActionItemValuePresent(WorkObject.ACTION_BUTTON_XPATH, dropDownValue));
	}

	@Override
	public void getMembersSubtab() {
		getSubTab("Members");
		findElement(By.xpath(HH_ADDMEMBER_BUTTON_XPATH)).scrollIntoView();

	}

}