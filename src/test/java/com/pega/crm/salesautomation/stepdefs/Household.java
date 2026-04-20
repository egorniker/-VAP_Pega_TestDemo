package com.pega.crm.salesautomation.stepdefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.Households;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Household {

	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;

	Households households;
	HouseholdList householdlist;
	String ZIPCODE = "500019";
	String COUNTRY = "India";
	String HH_NAME = "Household for Automation";
	String HH_NAME2 = "Smith Household";
	String HH_CITY = "Hyderabad";
	String HH_STATE = "Telangana";
	String HH_ZIPCODE = "05403";
	String HH_MOB = "8789878675";
	String HH_STREET = "Build 12A";
	String HH_COUNTRY = "India";
	String HH_DESCIPTION = "IT's House Hold New Entry";
	String HH_FILTER_CONTACT = "Minna Amigon";
	String HH_FILTER_CONTACT1 = "Minna";
	String HH_ROLE = "Head of household";
	String HH_UPDATED_PHONE_NUMBER = "9874561230";
	String HH_UPDATED_DESCRIPTION = "Updated description for Automation Household";
	String HH_NEW_MEMBER = "anne";
	String HH_NEW_MEMBER_ROLE = "Friend";
	String HH_CLOSE_COMMENTS = "Closing the HH as part of automation";
	String HH_PLACEHOLDER = "Filter households";
	String HH_TableHeader[] = { "Name", "Active members", "City", "State", "Zip code" };
	List<String> HH_LISTHEADER = new ArrayList<String>(Arrays.asList(HH_TableHeader));

	String HH_SubTabs[] = { "Pulse", "Members", "Opportunities", "Technical", "Attachments" };
	List<String> HH_WO_SUBTABS = new ArrayList<String>(Arrays.asList(HH_SubTabs));

	public static int HH_NOOFMEMBER = 1;

	@Inject
	public Household(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);

		this.householdlist = browser.hhList;

	}

	@When("^user clicks on CreateHousehold button$")
	public void user_clicks_on_CreateHousehold_button() throws Throwable {
		households = householdlist.createHousehold();
	}

	@Then("^user should navigate to Household creation page$")
	public void user_should_navigate_to_Household_creation_page() throws Throwable {
		String hhHeader = households.getHouseholdPageHeader();
		Assert.assertEquals(hhHeader, "New Household");
	}

	@When("^user enters all the HH mandatory data for households and saves the changes$")
	public void user_enters_all_HH_mandatory_data_and_saves_the_changes() {
		households.setHouseholdName(HH_NAME);
		households.setDescription(HH_DESCIPTION);
		households.setPhoneNumber(HH_MOB);
		households.setCity(HH_CITY);
		households.setState(HH_STATE);
		households.setStreet(HH_STREET);
		households.setPincode(HH_ZIPCODE);
		households.setCountry(HH_COUNTRY);
		households.clickAddMemberinCreate();
		households.searchContact(HH_FILTER_CONTACT);
		households.setHouseholdContact(HH_ROLE);
		households.clickCreate();
	}

	@Then("^Household should be created$")
	public void household_should_be_created() throws Throwable {
      
		String hhName = households.getHouseholdName();
		Assert.assertEquals(hhName, HH_NAME);
		String hhphonenumber = households.getPhoneNumber();
		Assert.assertEquals(hhphonenumber, HH_MOB);
		int hhActivemember = households.getActiveMember();
		Assert.assertEquals(hhActivemember, HH_NOOFMEMBER);
		String hhDescription = households.getDescription();
		Assert.assertEquals(hhDescription, HH_DESCIPTION);
		String hhMemberName = households.getMemberName();
		Assert.assertEquals(hhMemberName, HH_FILTER_CONTACT1);
		String hhMemberRole = households.getMemberRole();
		Assert.assertEquals(hhMemberRole, HH_ROLE);

	}

	@Then("^verify the Household WO subtabs$")
	public void verify_the_Household_WO_subtabs() throws Throwable {

		households.getSubTabs();

	}

	@When("^user enters all HH mandatory data for households and saves the changes$")
	public void user_enters_all_HH_mandatory_data_for_households_and_saves_the_changes() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		households.setHouseholdName(HH_NAME);
		households.setDescription(HH_DESCIPTION);
		households.setPhoneNumber(HH_MOB);
		households.setCity(HH_CITY);
		households.setState(HH_STATE);
		households.setStreet(HH_STREET);
		households.setPincode(HH_ZIPCODE);
		households.setCountry(HH_COUNTRY);
		households.clickAddMemberinCreate();
		households.searchContact(HH_FILTER_CONTACT);
		households.setHouseholdContact(HH_ROLE);
		households.submit();
	}
}
