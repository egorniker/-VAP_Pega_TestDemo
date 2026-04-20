package com.pega.crm.pegamarketing;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.explorer.RecordsExplorer;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;

public interface DesignerStudio extends PMPortal {
	
	By LAUNCH_PORTAL_LINK = By.xpath("//a[@title='Launch another portal']");
	By PEGA_MARKETING_PORTAL = By.xpath("//span[text()='Pega Marketing']");
	By APP_STUDIO_LABEL=By.xpath(PMXPathUtil.getMenuItemXPath("App Studio"));
	
	
	public enum Tabs
	{
		Recent("Recents"), Cases("Case types"), Data("Data types"), App("App"), Records("Records"), Favorite("Favorites");
		
		private String tabId;
		
		Tabs(String tabId){
			this.tabId = tabId;
		}
		
		public String getId()
		{
			return tabId;
		}
	}
	/**
	 * This method is used to open marketing portal from designer studio
	 * @return - It returns pmPortal
	 */
	PMPortal launchPegaMarketingPortal();

	/**
	 * searches any rule from the designer studio search bar
	 * @param searchedText
	 */
	void search(String searchedText);
	
	/**
	 * to navigate to Records explorer
	 * @return reference to an object of type RecordsExplorer
	 * @author Sachin
	 */
	RecordsExplorer getRecordsExplorer();
	/** 
	 * this method helps you to switch between tabs
	 * @param tab : tab name to which you want to switch
	 */
	void switchTab(Tabs tab);

	/**
	 * takes the control to the Deleopers frame
	 */
	void switchToDeveloperFrame();
}
