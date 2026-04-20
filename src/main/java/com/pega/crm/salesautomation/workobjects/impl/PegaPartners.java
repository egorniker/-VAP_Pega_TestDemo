package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Partners;

public class PegaPartners extends PegaWorkObject implements Partners {

//	public PegaPartners(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}

	public PegaPartners(TestEnvironment testEnv) {
		super(testEnv);
	}
	String WEBSITE_ID = "Website";
	String PHONE_ID = "OfficePhone";
	String PATNER_NAME_ID = "Name";
	String EMAIL_ID = "//input[contains(@name,'pWorkEmail')]";
	String PARTNER_TYPE = "PartnerType";
	String PARTNER_ID = "crmPartnerID";
	String PARTNER_WORKFAX = "FaxNumber";
	String PARTNER_TAXID = "crmTaxID";
	String SFA_ACCESS_TYPE_XPATH = "//input[@type='checkbox'][contains(@name,'crmAccessRequired')]";
	By SFA_ACCESS_TYPE_ID = By.xpath("//*[@data-test-id='2014121209505008752769-Label']");
	String CREATE_BUTTON_XPATH = "//*[@data-test-id='201701061310310173111370']";
	String TERRITORY_FIELD_ID = "crmTerritorySearch";
	String CREATE_TERRITORY_XPATH = "//*[@data-test-id='2015061908592800982262']";
	String TERRITORYNAME_ID = "Name";
	String TERRITORYNAME_XPATH = "(//input[@id='Name'])[2]";
	String TERRITORY_OWNER_ID = "crmSearchOwner";
	String PARENT_TERRITORY_ID = "crmTerritorySearch";
	String TERRITORY_SUBMIT_ID = "ModalButtonSubmit";
	String WEBSITE_VALUE_XPATH = "//span[text()='Website']/..//div/span";

	String ID_VALUE_PATH = "//span[text()='ID']/..//div/span";
	String TAX_ID_VALUE_PATH = "//span[text()='Tax ID']/..//div/span";
	String WORK_FAX_VALUE_PATH = "//span[text()='Work fax']/..//div/span";

	String PHONE_VALUE_XPATH = "//span[text()='Phone']/..//div/span";
	String NAME_VALUE_XPATH = "//h1[@class='header-title']";
	String EMAIL_VALUE_XPATH = "//span[text()='Email']/..//div/span/a";
	//String PARTNERTYPE_VALUE_XPATH = "//*[@data-test-id='20151119034237023588315']";
	String PARTNERTYPE_VALUE_XPATH = "//span[text()='Partner type']/..//div/span";
	String SUBMIT_BUTTON_XPATH = "//button[text()='Submit']";
	String OPERATORS_VALUES_XPATH = "//tr[contains(@id, 'crmOperatorsInPartnerList')]//td[@data-importance='primary']//span";

	@Override
	public void setWebSite(String WebSite) {
		pegaDriver.waitForDocStateReady();
		pegaDriver.handleWaits().waitForElementVisibility(By.id(WEBSITE_ID));
		//findElement(By.id(WEBSITE_ID));
		try {
			findElement(By.id(WEBSITE_ID)).sendKeys(SELECT_ALL);
			findElement(By.id(WEBSITE_ID)).sendKeys(WebSite);
		}catch(Exception e) {
			findElement(By.id(WEBSITE_ID)).sendKeys(SELECT_ALL);
			findElement(By.id(WEBSITE_ID)).sendKeys(WebSite);
		}
		
	}

	@Override
	public void setPhone(String Phone) {

		findElement(By.id(PHONE_ID)).sendKeys(SELECT_ALL);

		findElement(By.id(PHONE_ID)).sendKeys(Phone);
	}

	@Override
	public void setPartnerName(String Partner) {

		findElement(By.id(PATNER_NAME_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(PATNER_NAME_ID)).sendKeys(Partner);

	}

	@Override
	public void setPartnerID(String PartnerID) {

		findElement(By.id(PARTNER_ID)).sendKeys(SELECT_ALL);

		findElement(By.id(PARTNER_ID)).sendKeys(PartnerID);
	}

	@Override
	public void setPartnerTaxID(String TaxID) {

		findElement(By.id(PARTNER_TAXID)).sendKeys(SELECT_ALL);

		findElement(By.id(PARTNER_TAXID)).sendKeys(SELECT_ALL);
		findElement(By.id(PARTNER_TAXID)).sendKeys(TaxID);
	}

	@Override
	public void setPartnerWorkFax(String WorkFax) {

		findElement(By.id(PARTNER_WORKFAX)).sendKeys(SELECT_ALL);
		findElement(By.id(PARTNER_WORKFAX)).sendKeys(WorkFax);
	}

	@Override
	public void setEmail(String Email) {
//		findElement(By.xpath(EMAIL_ID)).clear();
		try {
			waitHandler.waitForElementVisibility(By.xpath(EMAIL_ID));
			findElement(By.xpath(EMAIL_ID)).sendKeys(SELECT_ALL);
			findElement(By.xpath(EMAIL_ID)).sendKeys("partner.pega@gmail.com");
		}catch (Exception e){
			findElement(By.xpath(EMAIL_ID)).sendKeys(SELECT_ALL);
			findElement(By.xpath(EMAIL_ID)).sendKeys("partner.pega@gmail.com");
		}
	}

	@Override
	public void setPartnerType(String PartnerType) {
		try {
			pegaDriver.waitForDocStateReady();
			waitHandler.waitForElementVisibility(By.id(PARTNER_TYPE));
			findSelectBox(By.id(PARTNER_TYPE)).selectByVisibleText(PartnerType);
		}catch (Exception e){
			findSelectBox(By.id(PARTNER_TYPE)).selectByVisibleText(PartnerType);
		}
	}

	@Override
	public void setSFAAccess() {
       pegaDriver.waitForDocStateReady(5);
//       int counter = 0;
//
//       breakWhile: while (counter == 0) {
//
//    	   System.out.println("Entered while : " + counter);
//    	   try {
//    		   findElement(By.xpath(SFA_ACCESS_TYPE_XPATH)).click();
//    	   }catch (Exception e){
//    		   findElement(By.xpath(SFA_ACCESS_TYPE_XPATH)).click();
//    	   }
//    	   try{
//    		   Thread.sleep(10000);
//    	   }catch (Exception e){
//    		   e.printStackTrace();
//    	   }
//    	   if (pegaDriver.verifyElement(By.id(CREATE_TERRITORY_XPATH))) {
//    		   System.out.println("Entered If");
//    		   counter++;
//    		   break breakWhile;
//    	   }
//
//
//
//       }
       waitHandler.waitForElementClickable(By.xpath(SFA_ACCESS_TYPE_XPATH));
	   try {
		   findElement(By.xpath(SFA_ACCESS_TYPE_XPATH)).click();
		   findElement(By.xpath(SFA_ACCESS_TYPE_XPATH)).click();
		   findElement(By.xpath(SFA_ACCESS_TYPE_XPATH)).click();
	   }catch (Exception e){
		   findElement(By.xpath(SFA_ACCESS_TYPE_XPATH)).click();
	   }
	   pegaDriver.waitForDocStateReady();
       for(int i=0;i<5;i++) {
    	   try {
    		   Thread.sleep(10000);i++;
    	   } catch (InterruptedException e1) {}
    	   if(pegaDriver.verifyElement(By.xpath(CREATE_TERRITORY_XPATH))) {
    		   System.out.println("Create territory found");
    		   break;
    	   }
       }
       WebElement ownerElement = findElement(By.xpath("//input[@id='crmSearchOwner']"));
       String existingOwner = ownerElement.getAttribute("value");
       if(existingOwner!="SFA Sample SalesOps") {
    	   ownerElement.clear();
    	   ownerElement.sendKeys("SFA Sample SalesOps"); 
       }
	}

	@Override
	public void setTerritory(String TerritoryName) {
		try {
			findAutoComplete(By.id(TERRITORY_FIELD_ID)).setValue(TerritoryName);
		}catch (Exception e){
			findAutoComplete(By.id(TERRITORY_FIELD_ID)).setValue(TerritoryName);
		}
	}

	@Override
	public void clickcreateTerritory() {
		waitHandler.waitForElementPresence(By.xpath(CREATE_TERRITORY_XPATH));
		waitHandler.waitForElementClickable(By.xpath(CREATE_TERRITORY_XPATH));
		findElement(By.xpath(CREATE_TERRITORY_XPATH)).click();

	}

	@Override
	public void setTerritoryName(String TerritoryName) {
		try {
			waitHandler.waitForElementVisibility(By.xpath(TERRITORYNAME_XPATH));
			findElement(By.xpath(TERRITORYNAME_XPATH)).sendKeys(TerritoryName);
		}catch (Exception e){
			findElement(By.xpath(TERRITORYNAME_XPATH)).sendKeys(TerritoryName);
		}
	}

	@Override
	public void setOwner(String OwnerName) {
		try {
			findAutoComplete(By.xpath(TERRITORY_OWNER_XPATH)).setValue(OwnerName);
		}catch (Exception e){
			findAutoComplete(By.xpath(TERRITORY_OWNER_XPATH)).setValue(OwnerName);
		}
	}

	@Override
	public void setParentTerritory(String ParentTerritory) {
		try {
			findAutoComplete(By.xpath(PARENT_TERRITORY_XPATH)).setValue(ParentTerritory);
		}catch (Exception e){
			findAutoComplete(By.xpath(PARENT_TERRITORY_XPATH)).setValue(ParentTerritory);
		}
	}

	@Override
	public void clickSubmitTerritoryScreen() {

//		findElement(By.id(TERRITORY_SUBMIT_ID)).click();
		findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click();
		pegaDriver.waitForDocStateReady();
		waitHandler.waitForElementNotVisible(By.xpath("//button[@id='ModalButtonSubmit']"));
	}

	@Override
	public void SubmitPartner() {

		findElement(By.xpath(CREATE_BUTTON_XPATH)).click();

	}

	@Override
	public void setAddress() {
		setAddress();

	}

	@Override
	public String getWebSite() {

		String website = findElement(By.xpath(WEBSITE_VALUE_XPATH)).getText();
		return website;
	}

	@Override
	public String getPartnerID() {

		String partnerID = findElement(By.xpath(ID_VALUE_PATH)).getText();
		return partnerID;
	}

	@Override
	public String getPartnerWorkFax() {

		String partnerfax = findElement(By.xpath(WORK_FAX_VALUE_PATH)).getText();
		return partnerfax;
	}

	@Override
	public String getPartnerTaxID() {

		String partnertaxId = findElement(By.xpath(TAX_ID_VALUE_PATH)).getText();
		return partnertaxId;
	}

	@Override
	public String getPhone() {

		String phone = findElement(By.xpath(PHONE_VALUE_XPATH)).getText();
		return phone;
	}

	@Override
	public String getPartnerName() {

		String PartnerName = findElement(By.xpath(NAME_VALUE_XPATH)).getText();
		return PartnerName;
	}

	@Override
	public String getEmail() {

		String Email = findElement(By.xpath(EMAIL_VALUE_XPATH)).getText();
		return Email;
	}

	@Override
	public String getPartnerType() {
		String PartnerType = findElement(By.xpath(PARTNERTYPE_VALUE_XPATH)).getText();
		return PartnerType;
	}

	@Override
	public void updatePhone(String UpdatedPhone) {

		findElement(By.id(PHONE_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(PHONE_ID)).sendKeys(UpdatedPhone);

	}

	@Override
	public void updateEmail(String UpdatedEmail) {
		//
		findElement(By.id(EMAIL_ID)).sendKeys(SELECT_ALL);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// findElement(By.id(EMAIL_ID)).sendKeys(Keys.TAB);
		findElement(By.id(EMAIL_ID)).sendKeys(UpdatedEmail);

	}

	@Override
	public void clickEdit() {

		findElement(By.xpath("//button[text()='Edit']")).click();

	}

	@Override
	public void clickSubmitReviewScreen() {

		findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();

	}

	@Override
	public void clickOperatorsSubtab() {
		getSubTab("Operators");
		clickRefresh();

	}

	@Override
	public List<String> getOperators() {
		ArrayList<String> s = new ArrayList<String>();

		List<WebElement> wb = findElements(By.xpath(OPERATORS_VALUES_XPATH));
		for (WebElement w : wb) {
			String s1 = w.getText();
			System.out.println(s1);
			s.add(s1);
		}
		return s;
	}

	@Override
	public List<String> trimOperators(List<String> operators) {
		ArrayList<String> s = new ArrayList<String>();
		for (String op : operators) {
			String parts[] = op.split("for");
			s.add(parts[0].trim());
			System.out.println(s);
		}
		return s;
	}

	@Override
	public void clickOK() {
		// TODO Auto-generated method stub

	}

}
