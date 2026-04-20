package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Contacts;
import com.pega.crm.salesautomation.workobjects.Households;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.WorkObject;
import com.pega.ri.Wizard;


public class PegaContact extends PegaWorkObject implements Contacts
{
//	public PegaContact(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaContact(TestEnvironment testEnv) {
		super(testEnv);
	}
	
	String CON_SUBTABS_XPATH = "//div[@role='tab']//h2"; 
	
	public void setFirstName(StringBuffer FirstName)
	{
		  try {
			  findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(FirstName);
			  findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(Keys.TAB);
		  }catch (Exception e){
			  findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(FirstName);
			  findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(Keys.TAB);
		  }
	}

	@Override
	public void setLastName(StringBuffer str) {
		try {
			findElement(By.xpath(CONT_LASTNAME_XPATH)).click();

			findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
			findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(Keys.TAB);
		}catch (Exception e){
			findElement(By.xpath(CONT_LASTNAME_XPATH)).click();

			findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
			findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(Keys.TAB);
		}
	}

	@Override
	public void setOrganization(String str) {
		try {
			pegaDriver.waitForDocStateReady();
			findElement(By.xpath(CONT_LASTNAME_XPATH)).scrollIntoView();
			findElement(By.id(CONT_ORG_ID)).click();
			findElement(By.id(CONT_ORG_ID)).sendKeys(str);
			findElement(By.id(CONT_ORG_ID)).sendKeys(Keys.DOWN);
			pegaDriver.findElement(By.xpath("//div[contains(@class,'autocompleteAG')]//span[text()='" + str + "']")).click();
			pegaDriver.findElement(By.id(CONT_ORG_ID)).click();
		}catch (Exception e){
			pegaDriver.waitForDocStateReady();
		}
	}

	@Override
	public void setSalutation(String str) {
		  try {
			  waitHandler.waitForElementVisibility(By.xpath(CONT_SALUTATION_XPATH));
			  findSelectBox(By.xpath(CONT_SALUTATION_XPATH)).selectByVisibleText(str);
		  }catch (Exception e){
			  findSelectBox(By.xpath(CONT_SALUTATION_XPATH)).selectByVisibleText(str);
		  }
	}

	public void setCompany(String str) {
		  try {
			  findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
		  }catch (Exception e){
			  findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
		  }
	}

	@Override
	public void setDepartment(String str) {
		  try {
			  findElement(By.id(CONT_DEPARTMENT_ID)).sendKeys(str);
		  }catch (Exception e){
			  findElement(By.id(CONT_DEPARTMENT_ID)).sendKeys(str);
		  }
	}

	@Override
	public void setInfluence(String str) {
		  try {
			  findSelectBox(By.xpath(CONT_INFLUENCE_XPATH)).selectByVisibleText(str);
		  }catch (Exception e){
			  findSelectBox(By.xpath(CONT_INFLUENCE_XPATH)).selectByVisibleText(str);
		  }
	}

	@Override
	public void setFavorability(String str) {
		  try {
			  findSelectBox(By.xpath(CONT_FAVORABILITY_XPATH)).selectByVisibleText(str);
		  }catch (Exception e){
			  findSelectBox(By.xpath(CONT_FAVORABILITY_XPATH)).selectByVisibleText(str);
		  }
	}
	
	@Override
	public void setWorkPhone(String str) {
		try {
			findElement(By.id(CONT_WORKPHONE_ID)).sendKeys(str);
		}catch (Exception e){
			findElement(By.id(CONT_WORKPHONE_ID)).sendKeys(str);
		}
	}

	@Override
	public void setWorkEmail(String str) {
		  try {
			  findElement(By.id(CONT_WORKEMAIL_ID)).sendKeys(str);
		  }catch (Exception e){
			  findElement(By.id(CONT_WORKEMAIL_ID)).sendKeys(str);
		  }
	}

	
	@Override
	public void setStreet(String str) {
		  try {
			  findElement(By.id(STREET_ID)).sendKeys(str);
		  }catch (Exception e){
			  findElement(By.id(STREET_ID)).sendKeys(str);
		  }
	}

	@Override
	public void setCity(String str) {
		  try {
			  findElement(By.id(CITY_ID)).sendKeys(str);
		  }catch (Exception e){
			  findElement(By.id(CITY_ID)).sendKeys(str);
		  }
	}

	@Override
	public void setState(String str) {
		 try {
			 findElement(By.id(STATE_ID)).sendKeys(str);
		 }catch (Exception e){
			 findElement(By.id(STATE_ID)).sendKeys(str);
		 }
	}

	@Override
	public void setPostalcode(String str) {
		  try {
			  findElement(By.id(ZIPCODE_ID)).sendKeys(str);
		  }catch (Exception e){
			  findElement(By.id(ZIPCODE_ID)).sendKeys(str);
		  }
	}

	@Override
	public void setCountry(String str) {
		  try {
			  findSelectBox(By.id(COUNTRY_ID)).selectByVisibleText(str);
		  }catch (Exception e){
			  findSelectBox(By.id(COUNTRY_ID)).selectByVisibleText(str);
		  }
	}

	@Override
	public void setTerritory(String str) {
		try {
			findAutoComplete(By.id(CONT_TERRIOTRY_ID)).setValue(str);
		}catch (Exception e){
			findAutoComplete(By.id(CONT_TERRIOTRY_ID)).setValue(str);
		}
	}
	public void setMaritalStatus(String str)
	{
		  try {
			  findSelectBox(By.xpath(CONT_MARITAL_XPATH)).selectByVisibleText(str);
		  }catch (Exception e){
			  findSelectBox(By.xpath(CONT_MARITAL_XPATH)).selectByVisibleText(str);
		  }
	}
	
	public void setCloseComments(String str)
	{
		  try {
			  findElement(By.id(CONT_CLOSECOMMENTS_ID)).sendKeys(str);
		  }catch (Exception e){
			  findElement(By.id(CONT_CLOSECOMMENTS_ID)).sendKeys(str);
		  }
	}
	@Override
	public Contacts createContact() {
		return null;
	}

	@Override
	public void clickCreate() {

		findElement(By.xpath(CREATE_XPATH)).click();
		pegaDriver.waitForDocStateReady();

	}
	public void clickEdit()
	{
		  
		findElement(By.xpath(ACC_EDIT_XPATH)).click();
	}
	
		public void clickSubmitButton()
	{
		  
			findElement(By.xpath(SUBMIT_XPATH)).click();
	}
		
	public String getFullname()
	{
		String fullname;
		  
		String firstname=getFirstName();
		String lastname=getLastName();
		if(firstname.length()==0)
		{
			 fullname =lastname;
		}
		else
		{
			fullname = firstname +" " + lastname;
			
		}
		
		return fullname;
	}
	public String getMaritalStatus()
	{
		  
		String marital= findElement(By.xpath(CONT_MARITALSTATUS_VALUE_XPATH)).getText();
		return marital;
		
	}
	public String getInfluenceRating()
	{
		
		  
		String influence= findElement(By.xpath(CONT_INFLUENCE_VALUE_XAPTH)).getText();
		return influence;
	}
	
	public String getClosePageHeader()
	{
		  
		String sectionname= findElement(By.xpath(CONT_CLOSEPAGE_HEADER_XPATH)).getText();
		return sectionname;
	}

	@Override
	public String getPrimaryContactName() {
		String primaryContact =  findElement(By.xpath(CONT_PRIMARY_CONTACT_XPATH)).getText();
		return primaryContact;
	}

	@Override
	public void clickOnRelationshipsTab() 
	{
		pegaDriver.handleWaits().waitForElementClickable(By.xpath("//ul[contains(@data-menu-id,'WorkCaseNavigation')]//*[text() ='Associations']"));
		findElement(By.xpath("//ul[contains(@data-menu-id,'WorkCaseNavigation')]//*[text() ='Associations']")).click();	
//		findElement(By.xpath(REFRESH_XPATH)).click();
	}

	@Override
	public String getC2ARelationShipName() {
		pegaDriver.handleWaits().waitForElementPresence(By.xpath(CONT_C2A_LIST_XPATH));
		List<WebElement> wb =  findElements(By.xpath(CONT_C2A_LIST_XPATH));
		System.out.println("Sizeee" + wb.size());
		for(int i=0;i<wb.size();i++)
		{
			String RelationType =  findElement(By.xpath(CONT_C2A_RELATIONSHIP_XPATH)).getText().trim();
			System.out.println("Relationship type is" + RelationType);
			if(RelationType.equals("Primary-Individual"))
			{
				String AccountName =  findElement(By.xpath(CONT_C2A_ACCOUNT_NAME_XPATH)).getText().trim();
				System.out.println("*******" +AccountName);
				return AccountName;
			}
		}
		return null;
	}
	
	public void clickFollow()
	{
		 findElement(By.xpath(CONT_FOLLOW_XPATH)).click();
		
	}
	public void clickUnFollow()
	{
		 findElement(By.xpath(CONT_UNFOLLOW_XPATH)).click();
	}
	
	@Override
	public List<String> getFollowedWOName() {
		List<String> ColumnValues= new ArrayList<String>();
		 //switchTo().defaultContent();
		 findElement(By.xpath(CONT_FOLLOWSCROLLING_XPATH)).scrollIntoView();
		List<WebElement> followedItems =  findElements(By.xpath(CONT_FOLLOWTESTING_XPATH));
		for(WebElement w : followedItems) {
			ColumnValues.add(w.getText());
		}
		return ColumnValues;	
	}

	@Override
	public boolean householdAssociated()
	{
		Wizard wizard =  findWizard( getActiveFrameId(false));
	    wizard.findElement(By.xpath(ADD_CONTACT_TO_HOUSEHOLD)).scrollIntoView();
		return  verifyElement(By.xpath("//*[@data-test-id = '20141217082112010923768']"));
	}

	@Override
	public String getFirstName() 
	{
		 
		String firstname=new String( findElement(By.xpath(CONT_FIRST_NAME_VALUE_XPATH)).getText());
		 return firstname;
		
	}

	@Override
	public String getLastName() 
	{
		waitHandler.waitForElementVisibility(By.xpath(CONT_LAST_NAME_VALUE_XPATH));
		String lastname=new String( findElement(By.xpath(CONT_LAST_NAME_VALUE_XPATH)).getText());
		 return lastname;
	}



	@Override
	public void navigateToTab(String tabName) {
		 findElement(By.xpath("//h2[contains(text(),'"+tabName+"')]")).click();
		 
	}

	@Override
	public void clickHousehold(String HouseholdName) {
		  
		 findElement(By.xpath("//button[contains(@name,'Households')]")).click();
		if( verifyElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a[contains(@text(),'"+HouseholdName+"')]")))
		{
			 findElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a[contains(@text(),'"+HouseholdName+"')]")).click();
		}	
	}
		
	@Override
	public ArrayList<String> getSubTabs() {
			ArrayList<String> s= new ArrayList<String>();
			List<WebElement> wb= findElements(By.xpath(CON_SUBTABS_XPATH));
			
			for(WebElement w:wb)
			{
				String s1=w.getText();
				s.add(s1);
			}
			System.out.println(s.size());
			return s;
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
	public boolean isFollowingListEmpty() {
		return isListEmpty();
	}

	
	
	@Override
	public Leads clickBusinessLead() {
		
		findElement(By.xpath(CONT_ADD_LEAD_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Business"))).click();
//		Leads lead = new PegaLeads(getActiveFrameId(false), testEnv);
		Leads lead = new PegaLeads(testEnv);
		return lead;
		
		
	}

	@Override
	public void getLeadSubTab() {
		getSubTab("Leads");
		  
		 findElement(By.xpath("//div[@role='tablist']//div[contains(@class, 'count')]//h2[text()='Leads']")).click();
		clickRefresh();
	}
	@Override
	public boolean getLeadNameFromSubtab(String LeadName) {
		return(isRowValuePresent(LEADS_ROWS_XPATH, LEAD_ROWS_NAME_XPATH, LeadName));
	}

	@Override
	public Leads clickIndividualLead() {
		findElement(By.xpath(CONT_ADD_LEAD_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Individual"))).click();
		String frameId =  getActiveFrameId(false);
//		Leads lead = new PegaLeads(frameId, testEnv);
		Leads lead = new PegaLeads(testEnv);
		return lead;
	}

	@Override
	public void getOpptySubTab() {
		getSubTab("Opportunities");
		
	}

	@Override
	public void NavigateToHouseholdMembers(){
		 
		getSubTab("Members");
		Wizard wizard =  findWizard( getActiveFrameId(false));
	    wizard.findElement(By.xpath(ADD_HOUSEHOLD_MEMBER_BTN)).scrollIntoView();
	}
	
	@Override
	public Opportunities clickOpptyFromSubtab(String opptype) {
		findElement(By.xpath(CONT_ADD_OPPTY_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath(opptype))).click(); 
		String frameId =  getActiveFrameId(false);
//		Opportunities opp = new PegaOpportunity(frameId, testEnv);
		Opportunities opp = new PegaOpportunity(testEnv);
		return opp;	
	}

	@Override
	public boolean getOpptyNameFromSubtab(String opptyname) {
		return(isRowValuePresent(OPP_ROWS_XPATH, OPP_ROWS_NAME_XPATH, opptyname));
	}
	
	@Override
	public boolean getOpptyNameFromSubtab(StringBuffer opptyname) {
		String opp= opptyname.toString();
		return(isRowValuePresent(OPP_ROWS_XPATH, OPP_ROWS_NAME_XPATH, opp));
	}
	


	
	@Override
	public Households selectExistingHousehold() {
		findElement(By.xpath(CONT_HOUSEHOLD_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Exisiting"))).click();
		String frameId =  getActiveFrameId(false);
//		Households HouseholdDetails = new PegaHouseholds(frameId, testEnv);
		Households HouseholdDetails = new PegaHouseholds(testEnv);
		return HouseholdDetails;
	}

	@Override
	public List<String> getLeadRowValues(String leadName) {
		clickRefresh();
		return (getRowValues(LEAD_ROWS_XPATH, leadName));
	}

	@Override
	public String houseHoldExists(String HouseholdName) {
		String HHName = HouseholdName;
		  
		List<String> houseHoldAttributes = getRowValues("//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-TASK')]", HouseholdName);
		System.out.println("before houseHoldAttributes");
		if(houseHoldAttributes.size()>0){
			System.out.println("In If");
			return HHName;
		}
		else return null;
	}	

	
		
	@Override
	public Households selectNewHousehold() {
		findElement(By.xpath(CONT_HOUSEHOLD_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("New"))).click();
		String frameId =  getActiveFrameId(false);
//		Households HouseholdDetails = new PegaHouseholds(frameId, testEnv);
		Households HouseholdDetails = new PegaHouseholds(testEnv);
		return HouseholdDetails;
		
	}
	@Override
	public void getActivitiesSubTab() {
		
		getSubTab("Activities");
	}
	@Override
	public List<String> getActivityValues(String ActivityName) {
		 findElement(By.xpath(WorkObject.ACTIVITY_REFRESH_XPATH)).click();
		
		return(getRowValues(CONT_ACTIVITY_ROW_IDENTIFIER_XPATH, ActivityName));
	}

	@Override
	public List<String> getTaskValues(String RowName) {
		 findElement(By.xpath(TASK_REFRESH_XPATH)).click();
		
		return(getRowValues(CONT_TASK_ROW_IDENTIFIER_XPATH, RowName));
		
	}
}