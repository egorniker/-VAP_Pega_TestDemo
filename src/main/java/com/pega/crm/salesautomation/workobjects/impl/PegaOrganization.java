package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.WorkObject;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;
import org.openqa.selenium.JavascriptExecutor;

public class PegaOrganization extends PegaWorkObject implements Organizations {

	public String CreateOrganizationButton = new String("//button[@title='Create organization']");
	String ORG_SEARCH_FIELD = "//input[@placeholder='Filter Organizations']";
	public String EDIT_BUTTON = new String("//button[text()='Edit']");
	String ORGANIZATIONS_TAB = new String("//span[contains(text(),'Organizations')]");
	String NEW_ORG_TITLE_XPATH = "//a[@title='New Organization']";
	String ORG_TERRIORTY_ID = "crmTerritorySearch";
	String PARENT_ORG = "crmSearchOrg";
	String ActionsButton = "//button[text()='Actions']";
	String LEAD_ROWS_XPATH = "//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-LEAD')]";
	String ORG_ACTIONS_XPATH = XPathUtil.getButtonPzBtnMidXPath("Actions ");
	String listviewtoggle_xpath = "//i[contains(@title,'Toggle to list mode')]";
	String ORG_SUBTABS_XPATH = "//div[@role='tab']//h2";

	String selectAll = Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE);

//	public PegaOrganization(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaOrganization(TestEnvironment testEnv) {
		super(testEnv);
	}
	

	@Override
	public Organizations getOrganizationDetails() {
		String frameId = getActiveFrameId(false);
//		Organizations orgDetails = new PegaOrganization(frameId, testEnv);
		Organizations orgDetails = new PegaOrganization(testEnv);
		return orgDetails;
	}

	public Organizations editOrganization()

	{

		findElement(By.xpath(EDIT_BUTTON)).click();
		String frameId = getActiveFrameId(false);
//		Organizations editOrg = new PegaOrganization(frameId, testEnv);
		Organizations editOrg = new PegaOrganization(testEnv);
		return editOrg;
	}

	@Override
	public Organizations changeOwner() {

		findElement(By.xpath("//div[@string_type='field']//button[text()='Actions']")).click();

		findElement(By.xpath("//li[@title='Assign to a new owner']")).click();

		String frameId = getActiveFrameId(false);
//		Organizations Org = new PegaOrganization(frameId, testEnv);
		Organizations Org = new PegaOrganization(testEnv);
		return Org;
	}

	@Override
	public Organizations changeHierarchy() {
		findElement(By.xpath(WorkObject.ACTION_BUTTON_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Change hierarchy"))).click();
//		Organizations Org = new PegaOrganization(getActiveFrameId(false), testEnv);
		Organizations Org = new PegaOrganization(testEnv);
		return Org;
	}

	@Override
	public Organizations setNewOwner(String owner) {

		findElement(By.xpath("//a[@title='Switch to edit mode']")).click();

		String frameId = getActiveFrameId(false);
//		Organizations Org = new PegaOrganization(frameId, testEnv);
		Organizations Org = new PegaOrganization(testEnv);
		findAutoComplete(By.id("crmSearchOwner")).setValue(owner);
		findElement(By.id("ChangeReason")).sendKeys("Change Owner Flow");
		findElement(By.xpath("//button[text()='Submit']")).click();

		return Org;
	}

	@Override
	public Organizations setHierarchy(String newParentOrg) {
		String frameId = getActiveFrameId(false);
//		Organizations Org = new PegaOrganization(frameId, testEnv);
		Organizations Org = new PegaOrganization(testEnv);
		if (findElement(By.xpath("//a[@title='Switch to edit mode']")).isDisplayed()) {
			findElement(By.xpath("//a[@title='Switch to edit mode']")).click();
		}
		findAutoComplete(By.id("crmSearchTerm")).setValue(newParentOrg);
		findElement(By.xpath("//button[text()='Submit']")).click();
		return Org;
	}

	@Override
	public void setName(String name) {

		findElement(By.id("Name")).clear();
		findElement(By.id("Name")).sendKeys(name);

	}

	@Override
	public void setTerritory(String territory) {
		findAutoComplete(By.id(ORG_TERRIORTY_ID)).setValue(territory);
	}

	@Override
	public Organizations OrgList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organizations navigateOrganization() {
		return null;
	}

	@Override
	public Boolean verifyOrgNewHarness() {

		return verifyElement(By.xpath("//label[text()='Parent organization']"));
	}

	@Override
	public void setWebsite(String name) {
		try {
			PegaWebElement wb;
			wb = findElement(By.id("Website"));
			wb.clear();
			wb.sendKeys(name);
		}catch (Exception e){
			PegaWebElement wb;
			wb = findElement(By.id("Website"));
			wb.clear();
			wb.sendKeys(name);
		}
	}

	@Override
	public void setIndustry(String industry) {
		try {
			findSelectBox(By.id("Industry")).selectByValue(industry);
		}catch (Exception e){
			findSelectBox(By.id("Industry")).selectByValue(industry);
		}
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		try {
			PegaWebElement wb;

			wb = findElement(By.id("PhoneNumber"));
			wb.clear();
			wb.sendKeys(phoneNumber);
		}catch (Exception e){
			PegaWebElement wb;

			wb = findElement(By.id("PhoneNumber"));
			wb.clear();
			wb.sendKeys(phoneNumber);
		}
	}

	@Override
	public void setShortName(String shortName) {
		try {
			findElement(By.id("ShortName")).clear();
			PegaWebElement wb;
			wb = findElement(By.id("ShortName"));
			wb.sendKeys(shortName);
		}catch (Exception e){
			findElement(By.id("ShortName")).clear();
			PegaWebElement wb;
			wb = findElement(By.id("ShortName"));
			wb.sendKeys(shortName);
		}
	}

	@Override
	public void setTickerSymbol(String ticker) {
		try {
			findElement(By.id("Ticker")).clear();
			PegaWebElement wb;
			wb = findElement(By.id("Ticker"));
			wb.sendKeys(ticker);
		}catch (Exception e){
			findElement(By.id("Ticker")).clear();
			PegaWebElement wb;
			wb = findElement(By.id("Ticker"));
			wb.sendKeys(ticker);
		}
	}

	@Override
	public void setEmployees(String employee) {
		try {
			findElement(By.id("EmployeeCount")).clear();
			findElement(By.id("EmployeeCount")).sendKeys(employee);
		}catch (Exception e){
			findElement(By.id("EmployeeCount")).clear();
			findElement(By.id("EmployeeCount")).sendKeys(employee);
		}
	}

	@Override
	public void setRevenue(String revenue) {
		try {
			findElement(By.id("Revenue")).clear();
			findElement(By.id("Revenue")).sendKeys(revenue);
		}catch (Exception e){
			findElement(By.id("Revenue")).clear();
			findElement(By.id("Revenue")).sendKeys(revenue);
		}
	}

	@Override
	public void setTarget(Boolean target) {
		try {
			if (target)
				findElement(By.xpath("//*[@data-test-id='2014120404484200106347']")).click();
		}catch (Exception e){
			if (target) {
				findElement(By.xpath("//*[@data-test-id='2014120404484200106347']")).scrollIntoView();
				findElement(By.id(ORG_TERRIORTY_ID)).scrollIntoView();
				findElement(By.xpath("//*[@data-test-id='2014120404484200106347']")).click();
			}
		}
	}

	@Override
	public void setParentOrganization(String parentOrg) {
		try {
			findAutoComplete(By.id(PARENT_ORG)).setValue(parentOrg);
		}catch (Exception e){
			findAutoComplete(By.id(PARENT_ORG)).setValue(parentOrg);
		}
	}

	@Override
	public void setDescription(String description) {
		try {
			findElement(By.id("pyDescription")).clear();
			findElement(By.id("pyDescription")).sendKeys(description);
		}catch (Exception e){
			findElement(By.id("pyDescription")).clear();
			findElement(By.id("pyDescription")).sendKeys(description);
		}
	}

	@Override
	public void setDomains(String[] domains) {

		// findElement(By.xpath("//a[text()='Add domain']")).click();
		int domainCount;
		domainCount = domains.length;
		System.out.println("Domain Count is ---" + domainCount);
		// findElement(By.xpath("//a[text()='Add domain']")).click();

		for (int i = 1; i <= domainCount; i++) {

			Wizard wizard = findWizard(getActiveFrameId(false));

			wizard.findElement(By.xpath("//a[text()='Add domain']")).scrollIntoView();
			// findElement(By.xpath(SUBMIT_XPATH)).scrollIntoView();
			// wizard.findElement(By.xpath(CREATE_XPATH)).click();

			wizard.findElement(By.xpath("//a[text()='Add domain']")).click();

			findElement(By.id("Domain" + i)).clear();
			findElement(By.id("Domain" + i)).sendKeys(domains[i - 1]);
		}
	}

	public void submit() {
		if (verifyElement(By.xpath("//button[@title='Create this item']"))) {
			findElement(By.xpath("//button[@title='Create this item']")).scrollIntoView();
			findElement(By.xpath("//button[@title='Create this item']")).click();
		} else {
			findElement(By.xpath("//button[@title='Complete this assignment']")).scrollIntoView();
			findElement(By.xpath("//button[@title='Complete this assignment']")).click();
		}
	}

	public void setAddress() {
		try {
			if (verifyElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]"))) {
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).scrollIntoView();
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).sendKeys(CITY);
				findElement(By.xpath("//*[contains(@id,'" + STREET_ID + "')]")).sendKeys(STREET);
				findElement(By.xpath("//*[contains(@id,'" + ADDRESSLINE2_ID + "')]")).sendKeys(ADDRESSLINE2);
				findElement(By.xpath("//*[contains(@id,'" + STATE_ID + "')]")).sendKeys(STATE);
				findElement(By.xpath("//*[contains(@id,'" + ZIPCODE_ID + "')]")).sendKeys(ZIPCODE);
				findSelectBox(By.xpath("//*[contains(@id,'" + COUNTRY_ID + "')]")).selectByVisibleText(COUNTRY);
			} else if (verifyElement(By.xpath(NEWADDRESS_XPATH))) {
				findElement(By.xpath(NEWADDRESS_XPATH)).scrollIntoView();
				System.out.println("Clicking on Add Address");
				findElement(By.xpath(NEWADDRESS_XPATH)).click();
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).scrollIntoView();
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).sendKeys(CITY);
				findElement(By.xpath("//*[contains(@id,'" + STREET_ID + "')]")).sendKeys(STREET);
				findElement(By.xpath("//*[contains(@id,'" + ADDRESSLINE2_ID + "')]")).sendKeys(ADDRESSLINE2);
				findElement(By.xpath("//*[contains(@id,'" + STATE_ID + "')]")).sendKeys(STATE);
				findElement(By.xpath("//*[contains(@id,'" + ZIPCODE_ID + "')]")).sendKeys(ZIPCODE);
				findSelectBox(By.xpath("//*[contains(@id,'" + COUNTRY_ID + "')]")).selectByVisibleText(COUNTRY);
			}
		}catch (Exception e){
			if (verifyElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]"))) {
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).scrollIntoView();
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).sendKeys(CITY);
				findElement(By.xpath("//*[contains(@id,'" + STREET_ID + "')]")).sendKeys(STREET);
				findElement(By.xpath("//*[contains(@id,'" + ADDRESSLINE2_ID + "')]")).sendKeys(ADDRESSLINE2);
				findElement(By.xpath("//*[contains(@id,'" + STATE_ID + "')]")).sendKeys(STATE);
				findElement(By.xpath("//*[contains(@id,'" + ZIPCODE_ID + "')]")).sendKeys(ZIPCODE);
				findSelectBox(By.xpath("//*[contains(@id,'" + COUNTRY_ID + "')]")).selectByVisibleText(COUNTRY);
			} else if (verifyElement(By.xpath(NEWADDRESS_XPATH))) {
				findElement(By.xpath(NEWADDRESS_XPATH)).scrollIntoView();
				System.out.println("Clicking on Add Address");
				findElement(By.xpath(NEWADDRESS_XPATH)).click();
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).scrollIntoView();
				findElement(By.xpath("//*[contains(@id,'" + CITY_ID + "')]")).sendKeys(CITY);
				findElement(By.xpath("//*[contains(@id,'" + STREET_ID + "')]")).sendKeys(STREET);
				findElement(By.xpath("//*[contains(@id,'" + ADDRESSLINE2_ID + "')]")).sendKeys(ADDRESSLINE2);
				findElement(By.xpath("//*[contains(@id,'" + STATE_ID + "')]")).sendKeys(STATE);
				findElement(By.xpath("//*[contains(@id,'" + ZIPCODE_ID + "')]")).sendKeys(ZIPCODE);
				findSelectBox(By.xpath("//*[contains(@id,'" + COUNTRY_ID + "')]")).selectByVisibleText(COUNTRY);
			}
		}

	}

	@Override
	public void setAddress(String type, boolean primary) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {

//		return (findElement(
//				By.xpath("//span[@class='field-caption dataLabelForRead']/span[text()='Name']/following::div/span"))
//						.getAttribute("text")).trim();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//div[@node_type='HEADER']//h1[@class='header-title']"));
				return (new String (findElement(By.xpath("//div[@node_type='HEADER']//h1[@class='header-title']")).getAttribute("text"))).trim();
	}

	@Override
	public String getTerritory() {

		return (findElement(
				By.xpath("//span[text()='Territory']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();

	}

	@Override
	public String getWebsite() {
		findElement(By.xpath("//ul[contains(@data-menu-id,'WorkCaseNavigation')]//*[text() = 'Details']")).click();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[@data-node-id='pyWorkSummary']"));
		return (findElement(
				By.xpath("//span[text()='Website']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();
		
	}
	

	@Override
	public String getIndustry() {

		return (findElement(
				By.xpath("//span[text()='Industry']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();

	}

	@Override
	public String getPhoneNumber() {

		return (findElement(
				By.xpath("//span[text()='Phone number']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();

	}

	@Override
	public String getShortName() {

		return (findElement(
				By.xpath("//span[text()='Short name']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();

	}

	@Override
	public String getTickerSymbol() {

		return (findElement(
				By.xpath("//span[text()='Ticker symbol']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();

	}

	@Override
	public String getEmployees() {

		return (findElement(
				By.xpath("//span[text()='Employees']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();

	}

	@Override
	public String getRevenue() {
		return (findElement(
				By.xpath("//span[text()='Revenue']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim().replaceAll(",", "");
	}

	@Override
	public String getTarget() {
		return (findElement(
				By.xpath("//span[text()='Target']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim();

	}

	@Override
	public String getParentOrganization() {
		String ParentOrg_xpath = "//span[text()='Parent organization']/following-sibling::div[@class='field-item dataValueRead']//a"+"|//a[@data-test-id='20150622013402096797241']";
		verifyElement(By.xpath("//a[text()='Show Organization Hierarchy']"));

		return (findElement(By.xpath(ParentOrg_xpath))).getText();
		

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAddress(String type) {
		return null;
	}

	@Override
	public boolean verifyTwitterIcon() {

		return verifyElement(By.xpath("//i[@title='Twitter']"));
	}

	@Override
	public boolean verifyFacebookIcon() {

		return verifyElement(By.xpath("//i[@title='Facebook']"));

	}

	@Override
	public boolean verifyGoogleMapIcon() {

		return verifyElement(By.xpath("//i[@title='Google Map']"));
	}

	@Override
	public boolean verifyOrgNews() {
		try {
			waitHandler.waitForElementPresence(By.xpath("//div[@data-node-id='crmNewsFeeds']//*[text()='Org news']"));
		}catch (Exception e) {}
		return verifyElement(By.xpath("//div[@data-node-id='crmNewsFeeds']//*[text()='Org news']"));

	}

	@Override
	public ArrayList<String> verifySubTabs() {

		ArrayList<String> s = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(ORG_SUBTABS_XPATH));

		for (WebElement w : wb) {
			String s1 = w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}

	@Override
	public boolean checkMode(String str) {

		// findElement(By.xpath("//span[text()='Edit']")).getAttribute("text");
		return str.equals(findElement(By.xpath("//span[text()='" + str + "']")).getAttribute("text"));

	}

	@Override
	public void changeTerritory(String newTerritory) {

		findElement(By.xpath("//a[@title='Switch to edit mode']")).click();
		setTerritory(newTerritory);

	}

	@Override
	public String getOwner() {

		verifyElement(By.xpath("//a[text()='Show Organization Hierarchy']"));
		return (new String(findElement(
				By.xpath("//span[text()='Owner']/following-sibling::div[@class='field-item dataValueRead']"))
						.getAttribute("text")).trim());
	}

	@Override
	public boolean validateOrgTask(String orgTaskSubject, String orgTaskStatus, String DueDate,
			String OrgTaskAssignedTo, String orgTaskPriority) {

		Wizard wizard = findWizard(getActiveFrameId(false));
		wizard.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]/tbody/tr[contains(@class,'Row')]"))
				.scrollIntoView();

		List<WebElement> OrgTasks;
		OrgTasks = findElements(By.xpath("//table[contains(@pl_prop,'Tasks')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgTasks.size();
		System.out.println("Task List size is" + rows);

		// findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]")).scrollIntoView();

		for (int i = 1; i <= rows; i++) {
			findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i) + "']"));
			System.out.println("Expected  org Task Due date value is " + DueDate);
			System.out.println("Actual org Task  Due date value is "
					+ findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i)
							+ "']//td[@data-attribute-name='Due date']//span")).getAttribute("text").trim());

			if (orgTaskSubject.equals(findElement(By.xpath(
					"//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i) + "']//a[contains(@name,'Tasks')]"))
							.getAttribute("text").trim())) {
				String Taskname = findElement(By.xpath(
						"//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i) + "']//a[contains(@name,'Tasks')]"))
								.getAttribute("text");
				System.out.println("code passed upto tasks name");
				String ActualTaskStatus = findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"
						+ (i) + "']//td[@data-attribute-name='Progress']//div")).getAttribute("text");
				System.out.println("Actual status from screen scrapping should be empty" + ActualTaskStatus);
				System.out.println("Expected Task Status" + orgTaskStatus);
				String ActualDueDate = findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i)
						+ "']//td[@data-attribute-name='Due date']//span")).getAttribute("text");
				System.out.println("Actual value of  Due date" + ActualDueDate);
				System.out.println("Expected  value  of Due date" + DueDate);
				String ActualAssignedTo = findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"
						+ (i) + "']//td[@data-attribute-name='Assigned to']//span")).getAttribute("text");
				String ActualTaskPriority = findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"
						+ (i) + "']//td[@data-attribute-name='Priority']//span")).getAttribute("text");
				System.out.println("Actual value of AssignedTo" + ActualAssignedTo);
				System.out.println("Actual value of Priority" + ActualTaskPriority);
				System.out.println("Expected value of AssignedTo" + OrgTaskAssignedTo);
				System.out.println("Expected value of Priority" + orgTaskPriority);
				if ((findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i)
						+ "']//td[@data-attribute-name='Progress']//div")).getAttribute("text").trim()
								.contains(orgTaskStatus))
						&&
						// findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Due
						// date']//span")).getAttribute("text").trim().contains(DueDate) &&
						findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i)
								+ "']//td[@data-attribute-name='Assigned to']//span")).getAttribute("text").trim()
										.contains(OrgTaskAssignedTo)
						&& findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='" + (i)
								+ "']//td[@data-attribute-name='Priority']//span")).getAttribute("text").trim()
										.contains(orgTaskPriority)) {

					System.out.println(
							"**********conditions are met***************entered if and if and this retruns true");

					System.out.println(Taskname);
					return true;
				}

			}
		}
		return false;
	}

	@Override
	public void navigeToOrgTab(String tabName) {

		findElement(By.xpath("//div[@class='header']//h2[contains(text(),'" + tabName + "')]")).scrollIntoView();

		findElement(By.xpath("//div[@class='header']//h2[contains(text(),'" + tabName + "')]")).click();
	}

	@Override
	public Accounts AddAccount() {

		findElement(By.xpath("//div[@string_type='field']//button[text()='Actions']")).click();
		findElement(By.xpath("//li[@role='presentation']//span[text()='Add account']")).click();

		String frameId = getActiveFrameId(false);
//		Accounts AccountNewHarnessDetails = new PegaAccounts(frameId, testEnv);
		Accounts AccountNewHarnessDetails = new PegaAccounts(testEnv);
		return AccountNewHarnessDetails;

	}

	@Override
	public boolean validateOrgAccounts(String AccountName, String AccountOwner, String AccountIndustry,
			String AccOpportunities, String AccountTotAmount, String AccountStatus) {

		// validate the expected account values
		System.out.println("Expected Values are");
		System.out.println(AccountName + "****   " + AccountOwner + " ****" + AccountIndustry + "******"
				+ AccOpportunities + "******" + AccountTotAmount + "*******" + AccountStatus);

		List<WebElement> OrgAccounts;
		OrgAccounts = findElements(By.xpath("//table[contains(@pl_prop,'Accounts')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgAccounts.size();
		System.out.println("accounts list count is   " + rows);

		for (int i = 1; i <= rows; i++) {

			String ActualAccountname = findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"
					+ (i) + "']//a[contains(@name,'Accounts')]")).getAttribute("text");
			String Actualamount = findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + i
					+ "' and contains(@id,'InOrg')]//td[@data-attribute-name='Total amount']")).getAttribute("text");
			String Actualowner = findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + i
					+ "' and contains(@id,'InOrg')]//td[@data-attribute-name='Owner']")).getAttribute("text");
			String Actualindustry = findElement(By.xpath("//table[@id='bodyTbl_right']//tr[@pl_index='" + i
					+ "' and contains(@id,'InOrg')]//td[@headers='a3']")).getAttribute("text");
			String ActualOppno = findElement(By.xpath("//table[@id='bodyTbl_right']//tr[@pl_index='" + i
					+ "' and contains(@id,'InOrg')]//td[@data-attribute-name='Opportunities']")).getAttribute("text");
			String ActualStatus = findElement(By.xpath("//table[@id='bodyTbl_right']//tr[@pl_index='" + i
					+ "' and contains(@id,'InOrg')]//td[@headers='a6']")).getAttribute("text");

			System.out.println("Actual Values in row number " + i + "are");
			System.out.println(ActualAccountname + "****" + Actualowner + " ****" + Actualindustry + "******"
					+ ActualOppno + "******" + Actualamount + "*******" + ActualStatus);

			if (AccountName.equals(findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + (i)
					+ "']//a[contains(@name,'Accounts')]")).getAttribute("text").trim()))

			{
				if (findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + i
						+ "' and contains(@id,'InOrg')]//td[@data-attribute-name='Owner']")).getAttribute("text").trim()
								.contains(AccountOwner)
						&& findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + i
								+ "' and contains(@id,'InOrg')]//td[@headers='a3']")).getAttribute("text").trim()
										.contains(AccountIndustry)
						&& findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + i
								+ "' and contains(@id,'InOrg')]//td[@data-attribute-name='Opportunities']"))
										.getAttribute("text").trim().contains(AccOpportunities)
						&& findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + i
								+ "' and contains(@id,'InOrg')]//td[@data-attribute-name='Total amount']"))
										.getAttribute("text").trim().contains(AccountTotAmount)
						&& findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='" + i
								+ "' and contains(@id,'InOrg')]//td[@headers='a6']")).getAttribute("text").trim()
										.contains(AccountStatus)) {
					System.out.println("*************************entered if and if");
					return true;
				}

			}
		}
		return false;

	}

	@Override
	public boolean validateOrgActivities(String Subject, String CommunicationType, String actDate, String CompletedBy,
			String RelatedTo, String RelatedType) {

		List<WebElement> OrgActivities;
		Wizard wizard = findWizard(getActiveFrameId(false));
		wizard.findElement(By.xpath("//table[contains(@pl_prop,'ActivitiesList')]//tr[contains(@class,'Row')]"))
				.scrollIntoView();
		OrgActivities = findElements(
				By.xpath("//table[contains(@pl_prop,'ActivitiesList')]//tr[contains(@class,'Row')]"));
		int actrows = OrgActivities.size();
		System.out.println("Activity List count is " + actrows);

		for (int i = 1; i < actrows; i++) {

			System.out.println("Expected Values are " + Subject + CommunicationType + actDate + CompletedBy + RelatedTo
					+ RelatedType);
			findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='" + (i) + "']"));
			if (Subject.equals(findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"
					+ (i) + "']//a[@title='Click to Open the Related Task']")).getAttribute("text").trim())) {
				System.out.println("entered 1st IF");
				System.out.println("Actual Values are");
				System.out.println(
						findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='" + (i)
								+ "']//td[@data-attribute-name='Communication type']//div")).getAttribute("text"));
				System.out.println(
						findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='" + (i)
								+ "']//td[@data-attribute-name='Date']//span")).getAttribute("text"));
				System.out.println(
						findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='" + (i)
								+ "']//td[@data-attribute-name='Completed by']//span")).getAttribute("text"));
				System.out.println(
						findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='" + (i)
								+ "']//td[@headers='a5']//span//a")).getAttribute("text"));
				System.out.println(
						findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='" + (i)
								+ "']//td[@headers='a6']//span")).getAttribute("text"));

				if (findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='" + (i)
						+ "']//td[@data-attribute-name='Communication type']//div")).getAttribute("text").trim()
								.contains(CommunicationType)
						&& findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"
								+ (i) + "']//td[@data-attribute-name='Date']//span")).getAttribute("text").trim()
										.contains(actDate)
						&& findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"
								+ (i) + "']//td[@data-attribute-name='Completed by']//span")).getAttribute("text")
										.trim().contains(CompletedBy)
						&& findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"
								+ (i) + "']//td[@headers='a5']//span//a")).getAttribute("text").trim()
										.contains(RelatedTo)
						&& findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"
								+ (i) + "']//td[@headers='a5']//span")).getAttribute("text").trim()
										.contains(RelatedType))
					System.out.println("entered 2nd if");
				return true;

			}
		}
		return false;

	}

	@Override
	public boolean validateOrgContacts(String ContactName, String RelationshipType, String RelationshipDescription,
			String StartDate, String EndDate) {

		System.out.println(
				"Expected Values are" + ContactName + RelationshipType + RelationshipDescription + StartDate + EndDate);
		List<WebElement> OrgContacts;
		OrgContacts = findElements(
				By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgContacts.size();
		System.out.println("org contact row" + rows);

		System.out.println("Started for loop***********");

		for (int i = 0; i < rows; i++) {
			findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='" + (i + 1) + "']"));
			if (ContactName.equals(findElement(
					By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//a[contains(text(),'" + ContactName + "')]"))
							.getText()))

			{
				String acontactname = findElement(By.xpath(
						"//table[contains(@pl_prop,'ContactsInOrg')]//a[contains(text(),'" + ContactName + "')]"))
								.getText();

				System.out.println(" entered if " + i + "time");

				String ActualRelationshiptype = findElement(
						By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='" + (i + 1)
								+ "']//td[@headers='a2']//div")).getAttribute("text");
				String rdesc = findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"
						+ (i + 1) + "']//td[@headers='a3']//div")).getAttribute("text");
				String startdate = findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"
						+ (i + 1) + "']//td[@headers='a4']//div")).getAttribute("text");
				String Enddate = findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"
						+ (i + 1) + "']//td[@headers='a5']//div")).getAttribute("text");
				System.out.println("*********** print values**************");
				System.out.println(acontactname + ActualRelationshiptype + rdesc + startdate + Enddate);
				if (findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='" + (i + 1)
						+ "']//td[@headers='a2']//div")).getAttribute("text").trim().contains(RelationshipType)
						&& findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='" + (i + 1)
								+ "']//td[@headers='a3']//div")).getAttribute("text").trim()
										.contains(RelationshipDescription))
					// findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a4']//div")).getAttribute("text").trim().contains(StartDate)
					// &&
					// findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a5']//div")).getAttribute("text").trim().contains(EndDate))
					return true;

			}
		}
		return false;

	}

	@Override
	public void getOpptySubTab() {
		getSubTab("Opportunities");

	}

	@Override
	public List<String> getOpptyValues(String opptyName) {

		Wizard wizard = findWizard(getActiveFrameId(false));
		wizard.findElement(By.xpath(ORG_OPPTY_ROW_IDENTIFIER_XPATH)).scrollIntoView();

		return (getRowValues(ORG_OPPTY_ROW_IDENTIFIER_XPATH, opptyName));

	}

	@Override
	public void getContactSubTab() {
		getSubTab("Contacts");
	}

	@Override
	public void refresh() {
		refresh();
	}

	@Override
	public void ClickToggletoConList() {

		findElement(By.xpath(listviewtoggle_xpath)).click();

	}

	@Override
	public void getLeadSubTab() {

		getSubTab("Leads");
		clickRefresh("leads");

	}

	@Override
	public List<String> getLeadRowValues(String companyName) {
		clickRefresh("leads");

		return (getRowValues(LEAD_ROWS_XPATH, companyName));
	}

}