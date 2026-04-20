package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.WorkObject;
import com.pega.framework.PegaWebElement;
import com.pega.page.TopDocumentImpl;
import com.pega.ri.WizardImpl;

public class PegaWorkObject extends TopDocumentImpl implements WorkObject {

//	public PegaWorkObject(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
//	public PegaWorkObject(PegaWebElement element) {
//		super(element);
//	}
	public PegaWorkObject(TestEnvironment testEnv)
	{
		super(testEnv);
	}

	public void clickRefresh() {
		findElement(By.xpath(REFRESH_XPATH)).click();
	}

	public void clickRefresh(String tabName) {
		findElement(By.xpath("//i[@title='Refresh'][contains(@name,'" + tabName + "')]")).scrollIntoView();
		findElement(By.xpath("//i[@title='Refresh'][contains(@name,'" + tabName + "')]")).click();
	}

	public void navigateToRecentItem(String WOName) {
		findElement(By.xpath(RECENT_WO_XPATH + "//a[text()='" + WOName + "']")).click();
	}

	public boolean isRowValuePresent(String RowIdentifier, String ColumnIdentifier, String RowValue) {
		List<WebElement> wb = findElements(By.xpath(RowIdentifier));

		for (WebElement w : wb) {
			WebElement s = w.findElement(By.xpath("." + ColumnIdentifier));
			String name = s.getText();
			if (name.equals(RowValue)) {
				return true;
			}
		}
		return false;
	}

	public void openRowWithDoubleClick(String RowIdentifier, String ColumnIdentifier, String RowValue) {
		List<WebElement> wb = findElements(By.xpath(RowIdentifier));

		for (WebElement w : wb) {
			WebElement s = w.findElement(By.xpath("." + ColumnIdentifier));
			String name = s.getText();
			System.out.println("::::::::::::::::::::::::" + name);
			if (name.equals(RowValue)) {
				System.out.println("in final condition");
				actions.doubleClick(s).build().perform();
			}
		}

	}

	public List<String> getRowValues(String RowIdentifier, String rowName) {
		List<String> ColumnValues = new ArrayList<String>();
		findElement(By.xpath(RowIdentifier)).scrollIntoView();

		List<WebElement> wb = findElements(By.xpath(RowIdentifier));

		for (WebElement w : wb) {

			WebElement RowIdentifer = w.findElement(By.xpath("." + "//td[1]/div"));
			String name = RowIdentifer.getText();
			System.out.println("Row Values::::::" + name);
			if (name.equals(rowName)) {
				List<WebElement> columnIdentifiers = w.findElements(By.xpath("." + "//td/div"));
				for (WebElement s : columnIdentifiers) {
					String temp = s.getText();
					System.out.println("Column Values::::::::" + temp);
					ColumnValues.add(temp);
				}
				return ColumnValues;
			}
		}
		return null;
	}

	public List<String> getRowValues(String RowIdentifier, String columValue1, String columValue2) {
		List<String> ColumnValues = new ArrayList<String>();
		List<WebElement> wb = findElements(By.xpath(RowIdentifier));

		for (WebElement w : wb) {
			// WebElement RowIdentifer = w.findElement(By.xpath("."+
			// "//td[@data-importance='primary']/div"));
			WebElement RowIdentifer = w.findElement(By.xpath("." + "//td[1]/div"));
			String name = RowIdentifer.getText();
			System.out.println("Row Values::::::" + name);
			if (name.contains(columValue1)) {
				WebElement RowIdentifer1 = w.findElement(By.xpath("." + "//td[2]/div"));
				String name1 = RowIdentifer1.getText();
				if (name1.contains(columValue2)) {
					List<WebElement> columnIdentifiers = w.findElements(By.xpath("." + "//td/div"));
					for (WebElement s : columnIdentifiers) {
						String temp = s.getText();
						System.out.println("Column Values::::::::" + temp);
						ColumnValues.add(temp);
					}
					return ColumnValues;
				}

			}
		}
		return null;
	}

	public boolean isActionItemValuePresent(String Locator, String dropDownValue) {
		findElement(By.xpath(Locator)).click();
		List<WebElement> dropdownlist = findElements(By.xpath("//*[@role='menu']/li"));
		if (dropdownlist.size() == 0) {
			dropdownlist = findElements(By.xpath("//*[@role='menu']/tr"));
		}
		int j = 0;
		for (WebElement w : dropdownlist) {
			s[j] = w.getText();
			j++;
		}

		for (int i = 0; i < dropdownlist.size(); i++) {
			if (s[i].equals(dropDownValue)) {
				return true;
			}

		}
		return false;
	}

	public void submit() {

		findElement(By.xpath(SUBMIT_XPATH)).scrollIntoView();
		findElement(By.xpath(SUBMIT_XPATH)).click();

	}

	public void setAddress() {

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
			findElement(By.xpath("//*[text()='Addresses']")).scrollIntoView();
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

	public void setAddress(String AddressType) {
		try {
			findElement(By.id(CITY_ID)).sendKeys(CITY);
		} catch (Exception e) {
			System.out.println("Clicking on Add Address");
			findElement(By.xpath(NEWADDRESS_XPATH)).click();
			findSelectBox(By.xpath(ADDRESSTYPE_XPATH)).selectByVisibleText(AddressType);
			findElement(By.id(STREET_ID)).sendKeys(STREET);
			findElement(By.id(ADDRESSLINE2_ID)).sendKeys(ADDRESSLINE2);
			findElement(By.id(CITY_ID)).sendKeys(CITY);
			findElement(By.id(STATE_ID)).sendKeys(STATE);
			findElement(By.id(ZIPCODE_ID)).sendKeys(ZIPCODE);
			findSelectBox(By.id(COUNTRY_ID)).selectByVisibleText(COUNTRY);
		}

	}

	public String getAddressType() {
		String addressType = findSelectBox(By.xpath(ADDRESSTYPE_XPATH)).getFirstSelectedOption().getText();
		return addressType;
	}

	public void getSubTab(String subtabName) {

		findElement(By.xpath(SUBTAB_XPATH + "//*[text() = '" + subtabName + "']")).click();

	}

	public boolean isListEmpty() {
		testEnv.getBrowser().refresh();
		try {
			findElement(By.xpath(NO_ITEM_XPATH));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String getSectionHeader() {
		String ownerHeader = findElement(By.xpath(SECTION_VALUE_XPATH)).getText();
		return ownerHeader;
	}

	public void edit() {
		findElement(By.xpath(ACC_EDIT_XPATH)).click();
	}

	public void create() {
		findElement(By.xpath(CREATE_XPATH1)).scrollIntoView();
		findElement(By.xpath(CREATE_XPATH1)).click();
	}

	public void discard() {
		findElement(By.xpath(DISCARD_XPATH)).click();
	}

	public void OK() {
		findElement(By.xpath(OK_BUTTON_XPATH)).click();

	}

	public void refresh() {
		findElement(By.xpath("//div[@string_type='field']//button[text()='Actions']")).click();
		findElement(By.xpath("//span[text()='Refresh']")).click();
	}

	@Override
	public void close() {
		findElement(By.xpath(WorkObject.ACTION_BUTTON_XPATH)).click();
		findElement(By.xpath(PegaUtil.getMenuDropdownXpath("Close"))).click();
	}

}
