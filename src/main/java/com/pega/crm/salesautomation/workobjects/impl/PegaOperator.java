package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Operators;
import com.pega.framework.PegaWebElement;
import com.pega.util.XPathUtil;

public class PegaOperator extends PegaWorkObject implements Operators {

	By OPR_TEMPLATE_CHECKBOX = By.xpath("//*[@data-test-id='2015061908552707501789-Label']");
//	By OPR_DEFAULT_ACCESS_CHECKBOX = By.xpath("//*[@data-test-id='202012100624510148482']");
	By OPR_DEFAULT_ACCESS_CHECKBOX = By.xpath("//label[contains(text() ,'Use default operator access')]");
	public String OPR_NEXT_BUTTON = XPathUtil.getButtonPzBtnMidXPath("Next >>");
	public String OPR_NEXT_BUTTON_XPATH = "//button[@title='Complete this assignment']";
//	public String OPR_NEXT_BUTTON_XPATH = "//button[contains(text(),'Finish')]";
	public String OPR_FINISH_BUTTON = XPathUtil.getButtonPzBtnMidXPath("Finish");

	By OPERATORID_FIELD = By.xpath("//*[@data-test-id='20180322120437096655826']");
	By OPR_PWD_BUTTON = By.xpath("//*[@data-test-id='20180322120437096860419']");
	By OPR_PASSWORD = By.xpath("//*[@data-test-id='2016060907461503301103']");
	By OPR_CONFIRMPASSWORD = By.xpath("//*[@data-test-id='2016060907461503322518']");
	By OPR_FIRST_NAME = By.xpath("//*[@data-test-id='2014120204473509528937']");
	By OPR_LAST_NAME = By.xpath("//*[@data-test-id='2014120204473509549660']");
	// By OPR_FULL_NAME = By.xpath("//*[@
	By OPR_POSTITION = By.xpath("//*[@data-test-id='20141202044735095811669']");
	By OPR_TELEPHONE = By.xpath("//*[@data-test-id='20141202044735096012493']");
	By OPR_EMAILADDRESS = By.xpath("//*[@data-test-id='20141202044735096313573']");
	String OPR_TIMEZONE = "pyDefaultTimeZone";
	By OPR_REPORTSTO = By.xpath("//*[@data-test-id='2015061907453203301225']");
	String OPR_TITLE = "pyTitle";
	String OPR_TYPE = "pyAccessGroup";
	String OPR_TERRITORY = "TerritoryID";
	//

//	public PegaOperator(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
	public PegaOperator(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public void setOperatorID(String str) {

		String frameId = getActiveFrameId(false);
//		PegaOperator Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		waitHandler.waitForElementVisibility(OPERATORID_FIELD);
		Opr.findElement(OPERATORID_FIELD).click();
		Opr.findElement(OPERATORID_FIELD).sendKeys(str);

	}

	@Override
	public void setPassword(String str) {

		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findElement(OPR_PWD_BUTTON).click();

		frameId = getActiveFrameId(false);
		Opr = new PegaOperator(testEnv);

//		PegaWebElement pwe = Opr.findElement(By.xpath("//div[@id='modalContent']//input[@id='pyPwdNew']"));
		PegaWebElement pwe = Opr.findElement(OPR_PASSWORD);

		// pwe.findElement(By.id(OPR_PASSWORD)).click();
		// pwe.findElement(By.id(OPR_PASSWORD)).sendKeys(str);

		pwe.click();
		pwe.sendKeys(str);
//		pwe = Opr.findElement(By.xpath("//div[@id='modalContent']//input[@id='pyPwdConfirmText']"));
		pwe = Opr.findElement(OPR_CONFIRMPASSWORD);

		pwe.click();
		pwe.sendKeys(str);
		// pwe.findElement(By.id(OPR_CONFIRMPASSWORD)).click();
		// pwe.findElement(By.id(OPR_CONFIRMPASSWORD)).sendKeys(str);

		pwe = Opr.findElement(By.xpath("//button[@id='submit']"));
		pwe.click();
		// findElement(By.id("ModalButtonSubmit")).click();
	}

	@Override
	public void setTitle(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findElement(By.id(OPR_TITLE)).clear();
		//Opr.findElement(By.id(OPR_TITLE)).click();
		Opr.findElement(By.id(OPR_TITLE)).sendKeys(str);

	}

	@Override
	public void setFirstName(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		pegaDriver.handleWaits().waitForElementVisibility((OPR_FIRST_NAME));
		Opr.findElement(OPR_FIRST_NAME).click();
		Opr.findElement(OPR_FIRST_NAME).sendKeys(str);

	}

	@Override
	public void setLastName(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findElement(OPR_LAST_NAME).click();
		Opr.findElement(OPR_LAST_NAME).sendKeys(str);

	}

	@Override
	public void setPostition(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findElement(OPR_POSTITION).clear();
		Opr.findElement(OPR_POSTITION).sendKeys(str);

	}

	@Override
	public void setPhone(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findElement(OPR_TELEPHONE).clear();
		Opr.findElement(OPR_TELEPHONE).sendKeys(str);

	}

	@Override
	public void setEmail(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findElement(OPR_EMAILADDRESS).clear();
		Opr.findElement(OPR_EMAILADDRESS).sendKeys(str);

	}

	@Override
	public void setTimeZone(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findSelectBox(By.id(OPR_TIMEZONE)).selectByValue(str);

	}

	@Override
	public void setReportTo(String str) {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		Opr.findElement(OPR_REPORTSTO).clear();
		Opr.findElement(OPR_REPORTSTO).sendKeys(str);
		Opr.findElement(OPR_REPORTSTO).sendKeys(Keys.DOWN);
		Opr.findElement(OPR_REPORTSTO).sendKeys(Keys.DOWN);
		Opr.findElement(OPR_REPORTSTO).sendKeys(Keys.ENTER);

	}

	@Override
	public void setOperatorType(String str) {
		//findElement(By.id("pyAccessGroup")).clear();
		findSelectBox(By.id("pyAccessGroup")).selectByVisibleText(str);
	}

	@Override
	public void setTerritory(String str) {
		findAutoComplete(By.id("crmSearchTerm")).setValue(str);
	}

	@Override
	public Operators navigateOperator() {
		String frameId = getActiveFrameId(false);
//		Operators Opr = new PegaOperator(frameId, testEnv);
		Operators Opr = new PegaOperator(testEnv);
		return Opr;
	}

	@Override
	public String getOperatorId() {

		return findElement(By.xpath("//label[@for='pyUserIdentifier']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getTitle() {

		return findElement(By.xpath("//label[@for='pyTitle']/following-sibling::Div/span")).getAttribute("text");
	}

	@Override
	public String getFirstName() {

		return findElement(By.xpath("//label[@for='pyFirstName']/following-sibling::Div/span")).getAttribute("text");

	}

	@Override
	public String getLastName() {

		return findElement(By.xpath("//label[@for='pyLastName']/following-sibling::Div/span")).getAttribute("text");
	}

	@Override
	public String getFullName() {

		return findElement(By.xpath("//*[text()='Full Name']/../../div/span")).getAttribute("text");
	}

	@Override
	public String getPostition() {

		return findElement(By.xpath("//label[@for='pyPosition']/following-sibling::Div/span")).getAttribute("text");
	}

	@Override
	public String getPhone() {

		return findElement(By.xpath("//label[@for='pyTelephone']/following-sibling::Div/span")).getAttribute("text");
	}

	@Override
	public String getEmail() {

		return findElement(By.xpath("//label[@for='pyEmailAddress']/following-sibling::Div/span")).getAttribute("text");
	}

	@Override
	public String getTimeZone() {

		return findElement(By.xpath("//label[@for='pyDefaultTimeZone']/following-sibling::Div")).getAttribute("text");
	}

	@Override
	public String getReportsTo() {

		return findElement(By.xpath("//label[@for='pyReportTo']/following-sibling::Div")).getAttribute("text");
	}

	@Override
	public String getOperatorType() {

		return findElement(By.xpath("//label[@for='pyAccessGroup']/following-sibling::Div/span")).getAttribute("text");
	}

	@Override
	public String getTerritory() {

		return findElement(By.xpath("//label[contains(text(),'Territory')]/following-sibling::Div"))
				.getAttribute("text");

	}

	@Override
	public void defaultSalesRepAccess() {

		// Verify for Organization Read Permissions at Territory and Child level
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID1']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID1']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));

		// Verify for Account Read Permission at territory and Child level
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID2']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID2']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));

		// Verify for Contact Read, update and Create permissions at territory and child
		// levels
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

		// Verify for Lead Read, update and Create permissions at territory and child
		// levels
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

		// Verify for Opportunity Read, update and Create permissions at territory and
		// child levels
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

		// Verify for Task Read, update and Create permissions at territory and child
		// levels
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

	}

	@Override
	public void navigateToAccessAndPermissionsTab() {
		findElement(By.xpath("//div[@role='tab']/h3[contains(text(),'Access & Permissions')]")).click();
	}

	public boolean verifyOprNewHarness() {

		return verifyElement(OPR_TEMPLATE_CHECKBOX);
	}

	@Override
	public void clickNext() {
		findElement(By.xpath(OPR_NEXT_BUTTON_XPATH)).scrollIntoView();
		findElement(By.xpath(OPR_NEXT_BUTTON_XPATH)).click();
		pegaDriver.waitForDocStateReady();

	}

	@Override
	public boolean verifyOprAccessScreen() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verifyElement(OPR_DEFAULT_ACCESS_CHECKBOX);

	}

	@Override
	public boolean verifyOprSalesGoalsScreen() {

		return verifyElement(By.xpath("//table[@id='bodyTbl_right']"));

	}

	@Override
	public void clickFinish() {
//		findElement(By.xpath(OPR_NEXT_BUTTON_XPATH)).click();

		if (verifyElement(By.xpath("//button[text()='Finish']")))
			findElement(By.xpath("//button[text()='Finish']")).click();

	}
	
	@Override
	public void ClickRefresh()
	{
        findElement(By.xpath("//button[text()='Clear filters']")).click();
//		findElement(By.xpath("(//*[@data-test-id='२०१९०४१८०९२७३६०८०२489639'])[1]")).click();
	}

}
