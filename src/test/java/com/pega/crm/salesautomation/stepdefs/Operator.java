package com.pega.crm.salesautomation.stepdefs;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.Operators;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Operator {

	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;
	OperatorList oprList;

	@Inject
	public Operator(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;

		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);

	}

	/*
	 * 
	 * Operator creation
	 * 
	 */

	private OperatorList oprResult;
	private Operators operator, oprDetails;

	String NewOperatorID = new String("Automation_Rep" + new Random().nextInt(1000));
	String operatorPassword = "install";
	String title = "Automation QA";
	String firstName = "Automation";
	String lastName = "QA";
	String fullName = "QA Automation";
	String position = "QA - Automation Lead";
	String phone = "9513578426";
	String email = "Automationuser" + new Random().nextInt(10000) + "@pega.com";
	String oprtimezone = "America/New_York";
	String reportTo = "SFASalesManager";
	String operatorType = "Sales manager";
	String territory = "Global";

	@When("^SalesRepOperatorCreation - navigates to Operators tab$")
	public void salesrepoperatorcreation_navigates_to_Operators_tab() throws Throwable {
		// oprResult = sfaPortal.getLeftNav().getOperatorsList();
		oprList = sfaPortal.getLeftNav().getOperatorsList();

	}

	@Then("^SalesRepOperatorCreation - Verify that user navigates to Operators tab$")
	public void salesrepoperatorcreation_Verify_that_user_navigates_to_Operators_tab() throws Throwable {
		// AssertJUnit.assertTrue(oprResult.verifyElement(By.xpath(oprResult.OPR_FILTER_PLACEHOLDER)));
		oprList = sfaPortal.getLeftNav().getOperatorsList();
		System.out.println("Object is:::" + oprList);
	}

	@When("^SalesRepOperatorCreation -  clicks on Create Operator button$")
	public void salesrepoperatorcreation_clicks_on_Create_Operator_button() throws Throwable {
//		System.out.println("Object is:::" + oprResult);
		operator = oprList.creasteOperator();

	}

	@Then("^SalesRepOperatorCreation - verify that Operator New harness is displayed$")
	public void salesrepoperatorcreation_verify_that_Operator_New_harness_is_displayed() throws Throwable {
		Assert.assertTrue(operator.verifyOprNewHarness());
	}

	@When("^SalesRepOperatorCreation - Sales Ops enters the data and navigates to Operator Access tab$")
	public void salesrepoperatorcreation_Sales_Ops_enters_the_data_and_navigates_to_Operator_Access_tab()
			throws Throwable {

		operator.setOperatorID(NewOperatorID);
		operator.setPassword(operatorPassword);
		operator.setFirstName(firstName);
		operator.setLastName(lastName);
		operator.setTitle(title);
		operator.setPostition(position);
		operator.setPhone(phone);
		operator.setEmail(email);
		operator.setTimeZone(oprtimezone);
		operator.clickNext();
//		Thread.sleep(10000);

	}

	@Then("^SalesRepOperatorCreation - verify that Operator navigates to Access tab$")
	public void salesrepoperatorcreation_verify_that_Operator_navigates_to_Access_tab() throws Throwable {

		Assert.assertTrue(operator.verifyOprAccessScreen());

	}

	@When("^SalesRepOperatorCreation - enters data in Operator Access tab and navigates to Sales Goals tab$")
	public void salesrepoperatorcreation_enters_data_in_Operator_Access_tab_and_navigates_to_Sales_Goals_tab()
			throws Throwable {
		operator.setOperatorType(operatorType);
		operator.setTerritory(territory);
		// pegaDriver.waitForDocStateReady(1);
		operator.clickFinish();
		pegaDriver.handleWaits().waitForNoThrobber();
	}

	@Then("^SalesRepOperatorCreation - Verify that Sales Goals tab is displayed$")
	public void salesrepoperatorcreation_Verify_that_Sales_Goals_tab_is_displayed() throws Throwable {

		operator.verifyOprSalesGoalsScreen();

	}

	@When("^SalesRepOperatorCreation - Enters Sales Goals information and submits$")
	public void salesrepoperatorcreation_Enters_Sales_Goals_information_and_submits() throws Throwable {
		operator.clickFinish();
	}

	@Then("^SalesRepOperatorCreation - Verify that operator record is created$")
	public void salesrepoperatorcreation_Verify_that_operator_record_is_created() throws Throwable {
		// oprDetails = oprResult.navigateOperator();
	}

	@When("^SalesRepOperatorCreation - Navigate to Operator list page to search the newly created Operator$")
	public void salesrepoperatorcreation_Navigate_to_Operator_list_page_to_search_the_newly_created_Operator()
			throws Throwable {
		pegaDriver.handleWaits().waitForElementNotPresence(By.xpath("//button[@title='Complete this assignment']"));
		pegaDriver.handleWaits().waitForNoThrobber();
		oprResult = sfaPortal.getLeftNav().getOperatorsList();
		operator.ClickRefresh();
		oprResult.searchOperator(NewOperatorID);
		try {
			Assert.assertTrue(oprResult.verifyElement(
					By.xpath("(//table[@id='gridLayoutTable']//tbody/tr/td/span//a[contains(text(),'" + firstName + " " + lastName + "')])[1]")));
			oprResult
					.findElement(By
							.xpath("(//table[@id='gridLayoutTable']//tbody/tr/td/span//a[contains(text(),'" + firstName + " " + lastName + "')])[1]"))
					.click();
		}catch (Exception e){
			Assert.assertTrue(oprResult.verifyElement(
					By.xpath("(//table[@id='gridLayoutTable']//tbody/tr/td/span//a[contains(text(),'" + firstName + " " + lastName + "')])[1]")));
			oprResult
					.findElement(By
							.xpath("(//table[@id='gridLayoutTable']//tbody/tr/td/span//a[contains(text(),'" + firstName + " " + lastName + "')])[1]"))
					.click();
		}
	}

	@Then("^SalesRepOperatorCreation - Validate the Sales operator profile Details information$")
	public void salesrepoperatorcreation_Validate_the_Sales_operator_record_information() throws Throwable {
		oprDetails = oprResult.navigateOperator();
		Assert.assertEquals(NewOperatorID, oprDetails.getOperatorId().trim());
		Assert.assertEquals(title, oprDetails.getTitle().trim());
		Assert.assertEquals(firstName, oprDetails.getFirstName().trim());
		Assert.assertEquals(lastName, oprDetails.getLastName().trim());
		Assert.assertEquals(firstName + " " + lastName, oprDetails.getFullName().trim());
		Assert.assertEquals(position, oprDetails.getPostition().trim());
		Assert.assertEquals(phone, oprDetails.getPhone().trim());
		Assert.assertEquals(email, oprDetails.getEmail().trim());
		Assert.assertEquals(oprtimezone, oprDetails.getTimeZone().trim());
		Assert.assertEquals(reportTo, oprDetails.getReportsTo().trim());

	}

	@When("^SalesRepOperatorCreation - Navigates to the Operator Access tab$")
	public void SalesRepOperatorCreation_Navigates_to_the_Operator_Access_tab() throws Throwable {
		oprDetails.navigateToAccessAndPermissionsTab();
		Assert.assertEquals(operatorType, oprDetails.getOperatorType().trim());
		Assert.assertEquals(territory, oprDetails.getTerritory().trim());
	}

	@Then("^SalesRepOperatorCreation - Verify the Default access details$")
	public void salesrepoperatorcreation_Verify_the_Default_access_details() throws Throwable {

		Assert.assertEquals(territory, oprDetails.findElement(By
				.xpath("//div[@id='PEGA_GRID1']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div"))
				.getAttribute("text").trim());
		Assert.assertEquals(territory, oprDetails.findElement(By
				.xpath("//div[@id='PEGA_GRID2']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div"))
				.getAttribute("text").trim());
		Assert.assertEquals(territory, oprDetails.findElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div"))
				.getAttribute("text").trim());
		Assert.assertEquals(territory, oprDetails.findElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div"))
				.getAttribute("text").trim());
		Assert.assertEquals(territory, oprDetails.findElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div"))
				.getAttribute("text").trim());
		Assert.assertEquals(territory, oprDetails.findElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div"))
				.getAttribute("text").trim());
		oprDetails.defaultSalesRepAccess();

	}

}
