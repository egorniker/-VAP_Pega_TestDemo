package com.pega.crm.salesautomation.workobjects.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.framework.PegaWebElement;

public class PegaClosePlans extends PegaWorkObject implements ClosePlans {

    //	public PegaClosePlans(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//	}
    public PegaClosePlans(TestEnvironment testEnv) {
        super(testEnv);
    }

    String FILTERBY_ID = "BaseFilterForLP";
    String APPLYBUTTON_XPATH = PegaUtil.getButtonXpath("Apply");
    String EXPORTBUTTON_XPATH = PegaUtil.getButtonXpath("Export");
    String CLOSEPLAN_OPPTY = "//table[contains(@pl_prop_class,'Opportunity')]//tr[contains(@id,'1')]";
    String CLOSEPLAN_OPPORTUNITY_ORG = "//table[contains(@pl_prop_class,'Opportunity')]//tr//td//div[contains(@section_index, '2')]";
    String CLOSEPLAN_COMMETNS = "//body[contains(@title,'This is a rich text')]";
    String ADDNEW_XPATH = PegaUtil.getStrongButtonXPath("Add new");
    String ORGNAME_TITLE = "OrganizationName";

    @Override
    public boolean isFilterMenuDisplayed() {
        return findElement(By.id(FILTERBY_ID)).isVisible();
    }

    @Override
    public boolean isApplyButtonDisplayed() {
        return findElement(By.xpath(APPLYBUTTON_XPATH)).isVisible();
    }

    @Override
    public boolean isExportButtonDisplayed() {
        return findElement(By.xpath(EXPORTBUTTON_XPATH)).isVisible();
    }

    @Override
    public void clickOppty() {
        findElement(By.xpath(CLOSEPLAN_OPPTY)).click();
    }

    @Override
    public void enterClosePlans(String comments) {
        if (verifyElement(By.xpath(ADDNEW_XPATH)))
            findElement(By.xpath(ADDNEW_XPATH)).click();
        findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]")).getWebElement();
        findElement(By.xpath(CLOSEPLAN_COMMETNS)).sendKeys(comments);

    }

    @Override
    public void filterBy(String option) {
        Select filter = new Select(findElement(By.id(FILTERBY_ID)));
        filter.selectByVisibleText(option);
    }

    @Override
    public void searchForOrganization(String orgName) {
        findAutoComplete(By.id(ORGNAME_TITLE)).setValue(orgName);
    }

    @Override
    public void apply() {
        try {
            PegaWebElement applyButton = findElement(By.xpath(APPLYBUTTON_XPATH));
            applyButton.click();
        } catch (Exception e) {
            PegaWebElement applyButton = findElement(By.xpath(APPLYBUTTON_XPATH));
            applyButton.click();
        }

    }

    @Override
    public List<WebElement> getOrgsFromOpportunities() {
        List<WebElement> opportunities = findElements(By.xpath(CLOSEPLAN_OPPORTUNITY_ORG));
        return (opportunities);
    }

}
