package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.WorkObject;
import com.pega.ri.Wizard;

public class PegaLeads extends PegaWorkObject implements Leads {

//	public PegaLeads(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaLeads(TestEnvironment testEnv) {
		super(testEnv);
	}

	String LEAD_SUBTABS_XPATH = "//div[@role='tab']//h2";

	@Override
	public void setStage(String StageName) {
		findSelectBox(By.id(LEAD_STAGE_ID)).selectByVisibleText(StageName);
	}

	@Override
	public void setLastName(String LastName) {

		findElement(By.id(LEAD_LASTNAME_ID)).sendKeys(LastName);
	}

	@Override
	public void setCompany(String Company) {
		findElement(By.id(LEAD_COMPANY_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(LEAD_COMPANY_ID)).sendKeys(Company);

	}

	@Override
	public void setIndustry(String Industry) {

		findSelectBox(By.xpath(LEAD_INDUSTRY_XPATH)).selectByVisibleText(Industry);

	}

	@Override
	public void setTerritory(String str) {
		findAutoComplete(By.id(LEAD_TERRIOTRY_ID)).setValue(str);
	}

	@Override
	public void clickOK() {

		findElement(By.xpath(SUBMIT_XPATH_LEAD)).click();

	}

	@Override
	public String getLastName() {

		String name = findElement(By.xpath(LEAD_NAME_VALUE_XPATH)).getText();
		return name;
	}

	@Override
	public String getLastNameForIndividual() {

		String name = findElement(By.xpath(LEAD_NAME_INDIVIDUAL_VALUE_XPATH)).getText();
		return name;
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
	public String getStage() {

		String stage = findElement(By.xpath(LEAD_STAGE_VALUE_XPATH)).getText();
		return stage;
	}

	@Override
	public String getCompany() {

		String company = findElement(By.xpath(LEAD_COMPANY_VALUE_XPATH)).getText();
		return company;
	}

	@Override
	public String getIndustry() {
		String industry = findElement(By.xpath(LEAD_INDUSTRY_VALUE_XPATH)).getText();
		return industry;
	}

	@Override
	public void closeLead() {
		findElement(By.xpath(LEAD_CLOSE_XPATH)).click();

		findElement(By.xpath(OPP_NEXTYEAR_XPATH)).click();

		findElement(By.xpath(LEAD_CLOSE_DATE_XPATH)).click();

	}

	@Override
	public void closeCommentLead() {

		findElement(By.id("CloseComments")).sendKeys("Closed as part of autoamtion");
		submit();

	}

	@Override
	public String closeLeadAssert() {

		String Stage = findElement(By.xpath(LEAD_CLOSE_ASSERT_XPATH)).getText();
		return Stage;

	}

	@Override
	public void clickClone() {

	}

	@Override
	public void setWorkPhone(String WorkPhone) {

		findElement(By.id(LEAD_WORK_PHONE_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(LEAD_WORK_PHONE_ID)).sendKeys(WorkPhone);

	}

	@Override
	public void setEmail(String Email) {

		findElement(By.id(LEAD_EMAIL_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(LEAD_EMAIL_ID)).sendKeys(Email);

	}

	@Override
	public void setLeadFirstName(String FirstName) {

		findElement(By.id(LEAD_FIRSTNAME)).sendKeys(SELECT_ALL);
		findElement(By.id(LEAD_FIRSTNAME)).sendKeys(FirstName);

	}

	@Override
	public void setLeadMobile(String Mobile) {

		findElement(By.id(LEAD_MOBILE)).sendKeys(SELECT_ALL);
		findElement(By.id(LEAD_MOBILE)).sendKeys(Mobile);

	}

	@Override
	public void setLeadDesc(String Desc) {

		findElement(By.id(LEAD_DESC)).sendKeys(SELECT_ALL);
		findElement(By.id(LEAD_DESC)).sendKeys(Desc);

	}

	@Override
	public String getWorkPhone() {

		String workPhone = findElement(By.xpath(XPATH_WORKPHONE)).getText();

		return workPhone;
	}

	@Override
	public String getEMail() {

		String email = findElement(By.xpath(XPATH_EMAIL)).getText();
		return email;
	}

	@Override
	public String getFirstName() {

		String firstName = findElement(By.xpath(XPATH_FIRSTNAME)).getText();
		return firstName;
	}

	@Override
	public String getMobile() {

		String mobile = findElement(By.xpath(XPATH_Mobile)).getText();
		return mobile;
	}

	@Override
	public String getDescription() {

		String desc = findElement(By.xpath(XPATH_Description)).getText();
		return desc;
	}

	@Override
	public void setEmailBusiness(String Email) {

		findElement(By.id(LEAD_EMAIL_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(LEAD_EMAIL_ID)).sendKeys(Email);

	}

	@Override
	public String getEmailBusiness() {

		String email = findElement(By.xpath(XPATH_EMAIL_BUSINESS)).getText();
		return email;
	}

	@Override
	public void clickClose() {
		findElement(By.xpath(WorkObject.ACTION_BUTTON_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Close"))).click();
	}

	@Override
	public String getContact() {
		String contact = findElement(By.xpath(CONTACT_VALUE_XPATH)).getText().trim();
		return contact;
	}

	@Override
	public void clickChangeOwner() {
		findElement(By.xpath(WorkObject.ACTION_BUTTON)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Change owner"))).click();

	}

	@Override
	public String getSectionHeader() {

		String ownerHeader = findElement(By.xpath(LEAD_SECTION_VALUE_XPATH)).getText();
		return ownerHeader;
	}

	@Override
	public void setOwner(String LEAD_UPDATEDOWNER) {
		findElement(By.id("crmSearchOwner")).click();
		findAutoComplete(By.id(LEAD_CHANGEOWNER_ID)).setValue(LEAD_UPDATEDOWNER);
		
	}

	@Override
	public void setReason(String CHANGEREASON) {
		findElement(By.id(LEAD_CHANGEREASON_ID)).sendKeys(CHANGEREASON);

	}

	@Override
	public void clickSubmitButton() {
		submit();

	}

	@Override
	public String getOwner() {
		try {
			Thread.sleep(10000);
		}catch (Exception e){
			e.printStackTrace();
		}
		String owner = findElement(By.xpath(LEAD_OWNER_VALUE_XPATH)).getText().trim();
		return owner;
	}

	@Override
	public void getActivitiesSubTab() {
		getSubTab("Activities");

	}

	@Override
	public List<String> getTaskValues(String LeadName) {
		// findElement(By.xpath(LEAD_TASK_REFRESH_XPATH)).scrollIntoView();
		findElement(By.xpath(LEAD_TASK_REFRESH_XPATH)).click();

		return (getRowValues(LEAD_TASK_ROW_IDENTIFIER_XPATH, LeadName));
	}

	@Override
	public List<String> getActivityValues(String ActivityName) {

		// findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).scrollIntoView();
		findElement(By.xpath(ACTIVITY_REFRESH_XPATH)).click();

		return (getRowValues(LEAD_ACTIVITY_ROW_IDENTIFIER_XPATH, ActivityName));
	}

	@Override
	public void setContact(String ContactName) {

		findAutoComplete(By.id(LEAD_CONTACT_ID)).setValue(ContactName);

	}

	@Override
	public String getCreatedDate() {

		Wizard wizard = findWizard(getActiveFrameId(false));
		String details_xpath = "//div[@aria-label='Details']";

		wizard.findElement(By.xpath(details_xpath)).scrollIntoView();

		findElement(By.xpath(details_xpath)).click();

		wizard.findElement(By.xpath(TECHINICAL_INFORMATION)).scrollIntoView();

		findElement(By.xpath(TECHINICAL_INFORMATION)).click();

		String LEAD_CREATED_DATE_XPATH = "//*[text()='Created on']/../div/span";
		return (findElement(By.xpath(LEAD_CREATED_DATE_XPATH)).getText());
	}

	@Override
	public void navigateToLeadFromBreadCrumb() {

		findElement(By.xpath("//a[@class='Breadcrumbs']")).click();

	}

	@Override
	public ArrayList<String> getSubTabs() {
		ArrayList<String> s = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(LEAD_SUBTABS_XPATH));

		for (WebElement w : wb) {
			String s1 = w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}

}
