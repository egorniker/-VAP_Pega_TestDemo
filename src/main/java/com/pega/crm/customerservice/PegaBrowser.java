package com.pega.crm.customerservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.impl.PegaCSPortal;
import com.pega.crm.customerservice.impl.PegaSFAPortal;
import com.pega.crm.pegamarketing.impl.PegaDesignerStudio;
import com.pega.crm.pegamarketing.impl.PegaExpressPortal;
import com.pega.crm.pegamarketing.impl.PegaPMPortal;
import com.pega.page.Portal;
import com.pega.ri.Wizard;

/**
 * @author Chanu
 * @since 11 Dec 2013
 */
public class PegaBrowser extends com.pega.BrowserImpl {

	@SuppressWarnings("unused")
	public String frameId = null;
	public Wizard newWizard = null;
	private static final String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public static final String VERSION = "$Id: PegaBrowser.java 117333 2018-10-01 09:12:21Z SachinVellanki $";
	String CS_SOCIAL_IMPL_LOGOFF_XPATH = "//span[@class='menu-item-title' and text()='Log off' or @class='menu-item-title' and text()='Logout']";
	String CS_SOCIAL_OPERATORID_XPATH = "//span/a[contains(@data-click,'showMenu')]";
	String CS_IMPL_OPERATOR_MENU_XPATH = "//button[contains(@title,'CS') or contains(@title,'CA') or contains(@title,'Mike Jones') or contains(@title,'socialqa') or contains(@title,'SocialQAAdmin') or contains(@title,'Chat') and contains(@class,'icons avatar name')]";
	String CS_IMPL_LOG_OFF_XPATH = "//*[@data-test-id='201712070919420129806']";
	public static String CaseID = null;

	private TestEnvironment testEnv = null;
	String Txt_KMSearch_Id = "KMSearchText";
	String Btn_KMSearch_Xpath = "//i[@title='Search for Articles']";

	public PegaBrowser(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();

	}

	@Override
	public <T extends Portal> T getPortal(Class<T> type) {
		T portal = null;
		String className = type.getName();
		if (className.contains("CSPortal")) {
			portal = type.cast(new PegaCSPortal(testEnv));
		}
		/*
		 * if (className.contains("DesignerStudio")) { portal = type.cast(new
		 * DesignerStudioImpl(testEnv)); }
		 */
		if (className.contains("SFAPortal")) {
			portal = type.cast(new PegaSFAPortal(testEnv));
		}
		if (className.contains("PMPortal")) {
			portal = type.cast(new PegaPMPortal(testEnv));
		} else if (className.contains("PegaExpressPortal")) {
			portal = type.cast(new PegaExpressPortal(testEnv));
		} else if (className.contains("DesignerStudio")) {
			portal = type.cast(new PegaDesignerStudio(testEnv));
		}
		return portal;
	}

	public void socialportallogout() {
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		int windowsCount = pegaDriver.getWindowHandles().size();
		System.out.println(windowsCount);
		while (windowsCount > 1) {
			testEnv.getBrowser().switchToWindow(windowsCount);
			testEnv.getBrowser().close();
			windowsCount--;
			System.out.println(windowsCount);
		}
		testEnv.getBrowser().switchToWindow(windowsCount);
		pegaDriver.findElement(By.xpath(CS_SOCIAL_OPERATORID_XPATH)).click(false);
		pegaDriver.findElement(By.xpath(CS_SOCIAL_IMPL_LOGOFF_XPATH)).click(false);
	}

	@Override
	public void logout() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click(false);
		// pegaDriver.findElement(By.xpath(CS_IP_OPERATOR_MENU_XPATH)).click(false);
		pegaDriver.switchTo().defaultContent();
		// List<WebElement> list =
		// pegaDriver.findElements(By.xpath(CS_IMPL_LOG_OFF_XPATH));
		pegaDriver.findElement(By.xpath(CS_IMPL_LOG_OFF_XPATH)).click(false);
		// list.get(list.size() - 1).click();
		try {
			// pegaDriver.waitForDocStateReady(1);

			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			pegaDriver.waitForDocStateReady();
			pegaDriver.navigate().refresh();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		// pegaDriver.handleWaits().waitForElementVisibility(By.id(CS_IMPL_LOGIN_ID));

	}

}
