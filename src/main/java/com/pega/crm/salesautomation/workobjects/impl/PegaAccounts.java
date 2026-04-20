
package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.WorkObject;

public class PegaAccounts extends PegaWorkObject implements Accounts {

//	public PegaAccounts(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaAccounts(TestEnvironment testEnv) {
		super(testEnv);
	}

	String ACC_ADD_INDOPPTY = "//*[@data-test-id='2015061908563207831294']";
	String ACC_TERRITORY_VALUE_XPATH = "//span[text()='Territory']/..//div";
	String ACC_INDUSTRY_VALUE_XPATH = "//span[text()='Industry']/..//div";
	String ACC_EMPLOYEES_VALUE_XPATH = "//span[text()='Employees']/..//div";
	String ACC_TICKER_VALUE_XPATH = "//span[text()='Ticker symbol']/..//div";
	String ACC_REVENUE_VALUE_XPATH = "//*[@data-test-id='20141204045038028826931']";
	String ACC_DESCRIPTION_VALUE_XPATH = "//span[text()='Description']/..//div";
	String ACC_ACCOUNT_PAGE_HEADER_XPATH = "//h2[contains(text(),'New    Business Account   ')]";
	String ACC_NAME_ID = "//input[@data-test-id='20141204045038027511854']";
	String ACC_TERRIORTY_ID = "crmTerritorySearch";
	String ACC_ORG_ID = "crmSearchOrg";
	//String ACC_ORG_ID = "//*[@data-test-id='2015062201382406621763']"; // added this xpath
	String ACC_DESCRIPTION_ID = "pyDescription";
	String ACC_INDUSTRY_XPATH = "//select[contains(@id, 'Industry')]";
	String ACC_PHONENUMBER_ID = "PhoneNumber";
	String ACC_CREATE_XPATH = PegaUtil.getStrongButtonXPath("Create");
	String ACC_WEBSITE_ID = "Website";
	String ACC_TICKER_ID = "Ticker";
	String ACC_REVENUE_ID = "Revenue";
	String ACC_EMPLOYEES_ID = "EmployeeCount";

	String ACC_CLOSE_HEADER_XPATH = "//span[@class='assignment_title']";
	String ACC_CHANGEOWNER_HEADER_XPATH = "//span[@class='assignment_title']";
	String ACC_SECTION_HEADER_XPATH = "//span[@class = 'assignment_title']";
	String ACC_OWNER_ID = "crmSearchOwner";
	String ACC_CHANGEREASON_ID = "ChangeReason";
	String ACC_OWNER_VALUE_XPATH = "//label[text()='Owner']/..//div/div/div";
	// String ACC_CLOSE_HEADER_XPATH="//*[@class='dataValueRead']//label";
	String ACC_COMMENTS_ID = "CloseComments";
	// String
	// ACC_OK_BUTTON_XPATH="//button[contains(@data-click,'doFormSubmit')]//*[text()='OK']";
//	String ACC_NAME_VALUE_XPATH = "//span[text()='Name']/../../div/span";
	String ACC_NAME_VALUE_XPATH = "//h1[@class = 'header-title' and contains(text(),'Dwayne Johnson')]";
	String ACC_PHONENUMBER_VALUE_XPATH = "//*[text()='Phone number']/..//div/span";
	String ACC_ORGANIZATION_VALUE_XPATH = "//span[text()='Organization']//following-sibling::div//a";

	String ACC_FOLLOW_XPATH = PegaUtil.getButtonXpath("Follow");
	String ACC_FOLLOWSCROLLING_XPATH = "//div[contains(@param_name,'Favorites')]//a";
	String ACC_FOLLOWTESTING_XPATH = "//div[contains(@param_name,'Favorites')]//a";
	String ACC_UNFOLLOW_XPATH = PegaUtil.getButtonXpath("Unfollow");

	String defaultOrg = "//label[@for='Name']/following-sibling::div/span/a";
	String ACC_TASK_ROW_IDENTIFIER_XPATH = "//tr[contains(@oaargs, 'WORK-TASK')]";
	String LEAD_ROWS_XPATH = "//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-LEAD')]";
	String ACC_FOLLOWERS_XPATH = "//*[@data-layout-id='201803010631100623']";
	String ACC_FOLLOWER_ROW_IDENTIFIER_XPATH = "//*[@data-test-id = '201710100436480270133']";
	String ACC_CONTACT_ROW_IDENTIFIER_XPATH = "//tr[contains(@oaargs, 'UPLUS-SAPLUS-LINK-ENTITY-C2A')]";
	public String WO_NAME = null;
	String ACC_SUBTABS_XPATH = "//div[@role='tab']//h2";
	String ACC_PRIMARY_CONTACT_XPATH = "//*[text()='Primary contact']/..//div/span";
	String ACC_EDIT_XPATH = "(//button[contains(@class, 'pzhc pzbutton') and contains(text(),'Edit')])[2]";

	@Override
	public void setAccountName(StringBuffer accountName) {
		waitHandler.waitForElementVisibility(By.xpath(ACC_NAME_ID));
		findElement(By.xpath(ACC_NAME_ID)).sendKeys(accountName);
	}

	@Override
	public void setTerritory(String TerritoryName) {
		findAutoComplete(By.id(ACC_TERRIORTY_ID)).setValue(TerritoryName);
	}

	@Override
	public void setOrganization(String OrganizationName) {
		pegaDriver.waitForDocStateReady(5);
		
		findAutoComplete(By.id(ACC_ORG_ID)).setValue(OrganizationName);
		
		}

	@Override
	public void setIndustry(String IndustryName) {
		findSelectBox(By.xpath(ACC_INDUSTRY_XPATH)).selectByVisibleText(IndustryName);

	}

	public void setPhoneNumber(String PhoneNumber) {

		findElement(By.id(ACC_PHONENUMBER_ID)).clear();
		findElement(By.id(ACC_PHONENUMBER_ID)).sendKeys(PhoneNumber);
	}

	@Override
	public void setDescription(String Description) {
		findElement(By.id(ACC_DESCRIPTION_ID)).sendKeys(Description);

	}

	@Override
	public String getAccountPageHeader() {
         
		pegaDriver.waitForDocStateReady();
		waitHandler.waitForElementVisibility(By.xpath(ACC_ACCOUNT_PAGE_HEADER_XPATH));
		String accHeader = findElement(By.xpath(ACC_ACCOUNT_PAGE_HEADER_XPATH)).getText();
//		String accHeader = findElement(By.xpath(ACC_ACCOUNT_PAGE_HEADER_XPATH)).getAttribute("innerText");
		return accHeader;
	}

	public void clickEdit() {
		findElement(By.xpath(ACC_EDIT_XPATH)).click();
	}

	@Override
	public String getAccountName() {
		pegaDriver.waitForDocStateReady();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(ACC_NAME_VALUE_XPATH));
		String accName = findElement(By.xpath(ACC_NAME_VALUE_XPATH)).getText();
		return accName;

	}

	@Override
	public Boolean isNameEnabled() {

		Boolean bool = findElement(By.xpath(ACC_NAME_ID)).isEnabled();
		return bool;

	}

	@Override
	public Boolean isPhoneNumberEnabled() {
		Boolean bool = findElement(By.id(ACC_PHONENUMBER_ID)).isEnabled();
		return bool;
	}

	@Override
	public Boolean isCityEnabled() {
		Boolean bool = findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).isEnabled();
		return bool;

	}

	@Override
	public String getPhoneNumber() {

		String phone = findElement(By.xpath(ACC_PHONENUMBER_VALUE_XPATH)).getText();
		return phone;
	}

	@Override
	public String getChangeOwnerHeader() {

		String header = findElement(By.xpath(ACC_CHANGEOWNER_HEADER_XPATH)).getText();
		return header;
	}

	public void setOwner(String ownerName) {

		findElement(By.id(ACC_OWNER_ID)).clear();
		findAutoComplete(By.id(ACC_OWNER_ID)).setValue(ownerName);
	}

	public void setReason(String reason) {
		findElement(By.id(ACC_CHANGEREASON_ID)).sendKeys(reason);
	}

	@Override
	public String getOwner() {

		String owner = findElement(By.xpath(ACC_OWNER_VALUE_XPATH)).getText();
		return owner;
	}

	@Override
	public String getCloseOwnerHeader() {

		String close = findElement(By.xpath(ACC_CLOSE_HEADER_XPATH)).getText();
		return close;
	}

	public void setCloseComments(String comments) {

		findElement(By.id(ACC_COMMENTS_ID)).sendKeys(comments);
	}

	public void clickFollow() {
		findElement(By.xpath(ACC_FOLLOW_XPATH)).click();

	}

	public void clickUnFollow() {
		if (verifyElement(By.xpath(ACC_UNFOLLOW_XPATH)))
			findElement(By.xpath(ACC_UNFOLLOW_XPATH)).click();
		else {
			clickFollow();
			findElement(By.xpath(ACC_UNFOLLOW_XPATH)).click();
		}
	}

	@Override
	public String getFollowedWOName() {
		String followedItems = findElement(By.xpath(ACC_FOLLOWTESTING_XPATH)).getText();
		return followedItems;
	}

	@Override
	public Boolean isFollowingListEmpty() {
		return isListEmpty();
	}

	@Override
	public void setWebSite(String website) {

		findElement(By.id(ACC_WEBSITE_ID)).sendKeys(website);

	}

	@Override
	public void setEmployees(String employees) {

		findElement(By.id(ACC_EMPLOYEES_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(ACC_EMPLOYEES_ID)).sendKeys(employees);
	}

	@Override
	public void setTickerSymbol(String ticker) {

		findElement(By.id(ACC_TICKER_ID)).sendKeys(ticker);
	}

	@Override
	public void setRevenue(String revenue) {

		findElement(By.id(ACC_REVENUE_ID)).sendKeys(revenue);

	}

	@Override
	public String getOrganization() {

		String org = findElement(By.xpath(ACC_ORGANIZATION_VALUE_XPATH)).getText();
		return org;
	}

	@Override
	public String getTerritory() {

		String territory = findElement(By.xpath(ACC_TERRITORY_VALUE_XPATH)).getText();
		return territory;
	}

	@Override
	public String getIndustry() {

		String industry = findElement(By.xpath(ACC_INDUSTRY_VALUE_XPATH)).getText();
		return industry;
	}

	@Override
	public String getEmployees() {

		String industry = findElement(By.xpath(ACC_EMPLOYEES_VALUE_XPATH)).getText();
		return industry;
	}

	@Override
	public String getTicker() {

		String ticker = findElement(By.xpath(ACC_TICKER_VALUE_XPATH)).getText();
		return ticker;
	}

	@Override
	public String getRevenue() {
		String revenue = findElement(By.xpath(ACC_REVENUE_VALUE_XPATH)).getText();
		revenue = revenue.replaceAll("[^0-9.]", "");
		return revenue;
	}

	@Override
	public String getDescription() {
       findElement(By.xpath("//ul[contains(@data-menu-id,'WorkCaseNavigation')]//*[text() = 'Details']")).click();
		String desc = findElement(By.xpath(ACC_DESCRIPTION_VALUE_XPATH)).getText();
		return desc;
	}

	@Override
	public String getdefaultOrg() {

		String desc;
		desc = findElement(By.xpath(defaultOrg)).getText().trim();
		return desc;

	}

	@Override
	public void clickOrgLink() {

		findElement(By.xpath(
				"//span[@class='field-caption dataLabelForRead' and text()='Organization']/following-sibling::div/span/a"))
						.click();
	}

	@Override
	public void navigateToTab(String tabName) {
		findElement(By.xpath("//div[@class='header']//h2[contains(text(),'" + tabName + "')]")).click();
	}

	@Override
	public boolean validateAccOpportunities(String opptyName, String opptyStage, String opptyCloseReason,
			String opptyOwner, String opptyAmount, String oppCloseDate, String opptyMustWin, String opptyTerritory) {
		List<WebElement> AccOpptys;
		AccOpptys = findElements(By.xpath(
				"//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[contains(@oaargs,'UPLUS-SAPLUS-WORK-OPPORTUNITY')]"));
		int rows = AccOpptys.size();

		for (int i = 1; i <= rows; i++) {
			if (opptyName.equals(findElement(
					By.xpath("//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='" + (i)
							+ "']//a[contains(@data-test-id,'20150105032822096321935')]")).getAttribute("text")
									.trim())) {
				if (opptyOwner
						.contains(findElement(By.xpath(
								"//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='" + (i)
										+ "']//td[@data-attribute-name='Owner']//div")).getAttribute("text").trim())
						&& opptyAmount.contains((findElement(By.xpath(
								"//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='" + (i)
										+ "']//td[@data-attribute-name='Amount']//div")).getAttribute("text").trim())
												.replaceAll("[^0-9.]", ""))
						&& opptyTerritory.equals(findElement(By.xpath(
								"//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='" + (i)
										+ "']//td[@data-attribute-name='Territory']//div")).getAttribute("text")
												.trim()))

					return true;
			}
		}
		return false;
	}

	@Override
	public boolean validateAccActivities(String Subject, String CommunicationType, String actDate, String CompletedBy) {
		List<WebElement> OrgActivities;
		OrgActivities = findElements(
				By.xpath("//table[contains(@pl_prop,'crmActivities')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgActivities.size();

		for (int i = 0; i < rows; i++) {
			findElement(
					By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='" + (i + 1) + "']"));
			if (Subject.equals(findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"
					+ (i + 1) + "']//a[@title='Click to Open the Related Task']")).getAttribute("text").trim())) {
				if (findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='" + (i + 1)
						+ "']//td[@data-attribute-name='Communication type']//div")).getAttribute("text").trim()
								.contains(CommunicationType)
						&& actDate.equals(
								findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"
										+ (i + 1) + "']//td[@data-attribute-name='Date']//span")).getAttribute("text")
												.trim())
						&& CompletedBy.equals(
								findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"
										+ (i + 1) + "']//td[@data-attribute-name='Completed by']//span"))
												.getAttribute("text").trim()))
					return true;

			}
		}
		return false;

	}

	@Override
	public boolean isAccountFollowed() {

		return (verifyElement(By.xpath(ACC_FOLLOW_XPATH)));

	}

	@Override
	public List<String> getFollowers(String Follower) {

		List<String> ColumnValues = new ArrayList<String>();
		List<WebElement> followedItems = findElements(By.xpath(ACC_FOLLOWER_ROW_IDENTIFIER_XPATH));
		for (WebElement w : followedItems) {
			ColumnValues.add(w.getText());
		}
		return ColumnValues;
	}

	@Override
	public ArrayList<String> getSubTabs() {
		ArrayList<String> s = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(ACC_SUBTABS_XPATH));

		for (WebElement w : wb) {
			String s1 = w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}

	@Override
	public String getPrimaryContactName() {
		String primaryContact = findElement(By.xpath(ACC_PRIMARY_CONTACT_XPATH)).getText();
		return primaryContact;
	}

	@Override
	public void clickCreate() {
		create();
	}

	@Override
	public void clickSubmit() {
		submit();

	}

	@Override
	public void clickChangeOwner() {
		findElement(By.xpath(WorkObject.ACTION_BUTTON_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Change owner"))).click();
	}

	@Override
	public void clickClose() {
		close();
	}

	@Override
	public Opportunities addOpportunity() {
		if (verifyElement(By.xpath(WorkObject.ACTION_BUTTON_XPATH))) {
			findElement(By.xpath(WorkObject.ACTION_BUTTON_XPATH)).click();
			findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Add opportunity"))).click();
		} else {

			findElement(By.xpath("//div[@class='header']//h2[contains(text(),'Opportunities')]")).click();

			findElement(By.xpath(ACC_ADD_INDOPPTY)).click();

		}

		String frameId = getActiveFrameId(false);
//		Opportunities newOppty = new PegaOpportunity(frameId, testEnv);
		Opportunities newOppty = new PegaOpportunity(testEnv);
		return newOppty;
	}

	@Override
	public boolean isActionItemValuePresent(String dropDownValue) {
		return (isActionItemValuePresent(WorkObject.ACTION_BUTTON_XPATH, dropDownValue));
	}

	@Override
	public void getActivitiesSubTab() {
		getSubTab("Activities");
	}

	@Override
	public List<String> getTaskValues(String taskSubject) {
		findElement(By.xpath(TASK_REFRESH_XPATH)).scrollIntoView();
		findElement(By.xpath(TASK_REFRESH_XPATH)).click();
		return (getRowValues(ACC_TASK_ROW_IDENTIFIER_XPATH, taskSubject));

	}

	@Override
	public void getLeadSubTab() {
		getSubTab("Leads");
	}

	@Override
	public List<String> getLeadRowValues(String leadName) {
		return (getRowValues(LEAD_ROWS_XPATH, leadName));
	}

	@Override
	public void getSalesTeamSubTab() {
		findElement(By.xpath(ACC_FOLLOWERS_XPATH)).scrollIntoView();
	}

	@Override
	public void getContactSubTab() {
		getSubTab("Contacts");
	}

	@Override
	public List<String> getContactValues(String contactRelationship) {
		return (getRowValues(ACC_CONTACT_ROW_IDENTIFIER_XPATH, contactRelationship));
	}
}