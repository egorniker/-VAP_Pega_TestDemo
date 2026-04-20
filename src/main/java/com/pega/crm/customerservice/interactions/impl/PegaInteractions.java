package com.pega.crm.customerservice.interactions.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;

public abstract class PegaInteractions extends WizardImpl implements Interactions {

	private WebDriver driver;

	public PegaInteractions(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
		driver = pegaDriver.getDriver();
	}

	public static String CaseID = null;
	public String frameId = null;
	public Wizard newWizard = null;
	boolean pop = false;

	public boolean isPop() {
		return pop;
	}

	public void setPop(boolean pop) {
		this.pop = pop;
	}

	@Override
	public void addTask() {
		PegaWebElement addTaskButton = findElement(By.xpath(ADD_TASK_XPATH));
		findElement(By.xpath(ADD_TASK_XPATH)).sendKeys(Keys.PAGE_UP);
		addTaskButton.click();
		//pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//button[@title='Add task']"));

	}

	@Override
	public void confirmDisputeDetails() {
		PegaWebElement confirmButton = findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);

	}

	@Override
	public void selectDisputeTransaction(String tranName) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		String TRANSACTION_ID_XPATH = "//input[@title='Select Dispute Transaction with ID #tranName#']";
		String finalXPath = new String(TRANSACTION_ID_XPATH).replace("#tranName#", tranName);

		PegaWebElement transLink = findElement(By.xpath(finalXPath));
		transLink.click();
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	@Override
	public void selectReasonForDispute(String reason) {
		DropDown distributionDropDown = findSelectBox(By.xpath("//select[@data-test-id='2015031611430403041178']"));
		distributionDropDown.selectByValue(reason);
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void searchByCustomerNameAndAccountNo(String lastName, String accountNum) {
		PegaWebElement pegaWebElement = findElement(By.xpath(LAST_NAME_XPATH));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(lastName);

		PegaWebElement searchButon = findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		searchButon.click();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'" + lastName + "')]"));

		pegaWebElement = findElement(By.xpath(ACCOUNT_NO_XPATH));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(accountNum);

		PegaWebElement search = findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}

	@Override
	public void selectCustomer() {

		List<WebElement> rows = findElements(By.xpath("//tr[contains(@id,'PD_Search_Customer$ppxResults')]"));
		rows.get(rows.size() - 1).click();

		PegaWebElement submit = findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();

	}

	@Override
	public void contactVerificationQuestions() {

		int pageexists = findElements(By.xpath("//span[contains(text(),'Verify contact')]")).size();
		if (pageexists > 0) {
			int noOfQstns = findElements(
					By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]"))
							.size();

			if (noOfQstns > 0) {
				for (int i = 1; i <= noOfQstns; i++) {

					findElements(By
							.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]"))
									.get(i - 1).click();

				}
			}

			PegaWebElement submit = findElement(By.xpath("//button[text()='Verified']"));
			submit.click();

		}
	}

	@Override
	public void contactVerificationQuesforServiceCases() {

		int pageexists = findElements(By.xpath("//*[contains(text(),'Verify contact')]")).size();

		if (pageexists > 0) {
			int noOfQstns = findElements(
					By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]"))
							.size();
			if (noOfQstns > 0) {
				for (int i = 1; i <= noOfQstns; i++) {

					findElements(By
							.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]"))
									.get(i - 1).click();

					try {
						PegaWebElement verification = findElement(By.xpath("//button[text()='Verified']"));

						if (verification.isEnabled()) {

							PegaWebElement submitButtons = findElement(By.xpath("//button[text()='Verified']"));
							submitButtons.click(false);
							break;
						}
					} catch (Exception e) {
						PegaWebElement verification = findElement(By.xpath("//button[text()='Verified']"));
						if (verification.isEnabled()) {
							PegaWebElement submitButtons = findElement(By.xpath("//button[text()='Verified']"));
							submitButtons.click(false);
							break;
						}
					}

				}
			}

		}

		else {
			Assert.assertFalse("No Verification validated successfully",
					verifyElement(By.xpath("//label[contains(text(),'Verify contact')]")));
		}

	}

	@Override
	public void clickOnOtherActionsButton() {

		try {
			PegaWebElement otherActions = findElement(By.xpath("//button[@title='Other actions']"));
			otherActions.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void changeAddress() {
		PegaWebElement changeAddress1 = findElement(By.xpath(ADDRESS_LINE1_XPATH));
		changeAddress1.clear();
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = findElement(By.xpath(ADDRESS_LINE2_XPATH));
		changeAddress.clear();
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = findSelectBox(By.xpath(COUNTRY_CODE_XPATH));
		CountryCode.selectByValue("AUS");
		PegaWebElement zipCode = findElement(By.xpath(POSTAL_CODE_XPATH));
		zipCode.clear();
		zipCode.sendKeys("11001 ");
		PegaWebElement city = findElement(By.xpath(CITY_XPATH));
		city.clear();
		city.sendKeys("Sydney ");
		PegaWebElement HomePhone = findElement(By.xpath(HOME_PHONE_XPATH));
		HomePhone.clear();
		HomePhone.sendKeys("12345659099 ");
		PegaWebElement CellPhone = findElement(By.xpath(CELL_PHONE_XPATH));
		CellPhone.clear();
		CellPhone.sendKeys("2288909023 ");
		PegaWebElement Fax = findElement(By.xpath(FAX_XPATH));
		Fax.clear();
		Fax.sendKeys("2288909023 ");
		PegaWebElement Email = findElement(By.xpath(EMAIL_ID_XPATH));
		Email.clear();
		Email.sendKeys("test@pega.com ");
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
	}

	@Override
	public void confirmAddressChange() {
		PegaWebElement confirmButton = findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
	}

	@Override
	public String verifyCompletedTask(String serviceProcess) {

		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and (@class='Standard_task' or @class='Standard_offer')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		return finalXPath;

	}

	@Override
	public void launchWrapup() {

		PegaWebElement wrapUp = findElement(By.xpath(WRAP_UP_XPATH));

		try {

			wrapUp.click();
		} catch (Exception e) {
			PegaWebElement wrapUp1 = findElement(By.xpath("//i[@title='Wrap Up']"));
			wrapUp1.click();
			e.printStackTrace();
		}
	}

	@Override
	public void completeWrapUp(String reason) {

		DropDown disposition = findSelectBox(By.xpath(REASON_FOR_INTERACTION_XPATH));
		disposition.selectByValue(reason);
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	@Override
	public void completeWrapUpWithoutReason() {
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	@Override
	public void changeAdditionalAddress() {

		PegaWebElement checkBox = findElement(By.xpath(SELECT_ADDITIONAL_ACCOUNTS_XPATH));
		checkBox.click();
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void confirmFlow() {

		PegaWebElement confirmButton = findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);

	}

	public void enterAccountDetails() {

		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void launchServiceProcess(String serviceProcess) {
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and @class='Add_task']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		PegaWebElement serviceCase = findElement(By.xpath(finalXPath));
		serviceCase.doubleClick();
	}

	@Override
	public void accountSelection(String acctNumber) {
		PegaWebElement accountSelection = findElement(
				By.xpath("//*[contains(text(),'" + acctNumber + "')]/ancestor::tr[1]"));
		accountSelection.click();
		PegaWebElement submit = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.click(false);

	}

	@Override
	public void userSwitchToTab(String tab) {

		String Tab_XPATH = "//*[text()='#sericecase#']";
		String final_Tab_XPath = new String(Tab_XPATH).replace("#sericecase#", tab);

		PegaWebElement overview = findElement(By.xpath(final_Tab_XPath));
		overview.click();
	}

	public String getTomorrowDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}

	@Override
	public void CaptureCallReasonAndPlaceCall(String reason, String status) {

		DropDown reasonDropdown = findSelectBox(By.xpath(OUTBOUND_REASON_XPATH));
		reasonDropdown.selectByValue(reason);

		String finalXpath = new String(OUTBOUND_STATUS_XPATH).replace("#status#", status);
		PegaWebElement rdbutton = findElement(By.xpath(finalXpath));
		rdbutton.click();

		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}
	
	@Override
	public void selectSearchByinPhoneCallSearch(String searchBy) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement searchByele = newWizard.findElement(By.xpath(NEWPHONECALL_SEARCHBY));
		Select searchBySelect = new Select(searchByele);
		searchBySelect.selectByVisibleText(searchBy);
	}
	
	@Override
	public void searchCustomerByAccNumPhoNum(String accnum,String phonum) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement emailElmt = newWizard.findElement(By.xpath(SECOND_ACCNUM_XPATH));
		emailElmt.sendKeys(accnum);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement phnum = newWizard.findElement(By.xpath(ACCNUM_PHONENUMBER_XPATH));
		phnum.sendKeys(phonum);
		PegaWebElement search = newWizard.findElement(By.xpath(NEWPHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}
	@Override
	public void selectFirstCustomerInPhoneCallSearch() {
		frameswitching(1);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//tr[contains(@data-test-id,'201808091526470952669')]"));
		List<WebElement> rows = pegaDriver.findElements(By.xpath("//tr[contains(@data-test-id,'201808091526470952669')]"));
		rows.get(rows.size() - 1).click();
		pegaDriver.waitForDocStateReady(3);
		frameswitching(1);
		PegaWebElement submit = pegaDriver.findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		pegaDriver.waitForDocStateReady();
		frameswitching(1);
		submit.click();
		pegaDriver.waitForDocStateReady();


	}
	@Override
	public void frameswitching(int framevalue) {
		frameId = pegaDriver.getActiveFrameId(false);
		if(frameId==null){
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame(Express_Frame);
			pegaDriver.switchTo().frame(Form_factor_Frame);
			pegaDriver.switchTo().frame("PegaGadget"+framevalue+"Ifr");

		}
		else{
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.switchToActiveFrame();frameId = pegaDriver.getActiveFrameId(false);
			newWizard = pegaDriver.findWizard(frameId);
		}
	}
	
	@Override
	public void searchCustomerByEmaillastname(String email,String lastname) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement emailElmt = newWizard.findElement(By.xpath(EMAIL_XPATH));
		emailElmt.sendKeys(email);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement DOBElmt = newWizard.findElement(By.xpath(SECOND_LASTNAME_XPATH));
		DOBElmt.sendKeys(lastname);
		PegaWebElement search = newWizard.findElement(By.xpath(NEWPHONECALL_RESULT_SEARCH_XPATH));
		search.click();

	}

}
