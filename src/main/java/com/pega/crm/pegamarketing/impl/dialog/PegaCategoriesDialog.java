package com.pega.crm.pegamarketing.impl.dialog;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.CategoriesDialog;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.elmt.Frame;

public class PegaCategoriesDialog extends PegaConfigureDialog implements CategoriesDialog {
	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	Frame frame;

	public PegaCategoriesDialog(Frame aFrame) {
		super(aFrame);
		frame = aFrame;
	}

	public void Addcategories() {

		frame.findElement(ADDCATEGORIES_LINK).click();

	}

	@Override
	public boolean verifycategory(String arg1) {
		boolean result = frame.findElement(SELECTCATEGORYLIST).verifyElement(By.xpath("//*[text()='" + arg1 + "']"));
		return result;
	}

	@Override
	public void addreqcategory(String arg1) {
		frame.findElement(CREATENEW_LINK).click();
		frame.findElement(CREATENEW_INPUT).sendKeys(arg1);
		frame.findElement(By.xpath("//*[@aria-label='pzCreateCategory']//*[contains(text(),'OK')]")).click();
		frame.findElement(SELECTCTGYOK_BTN).click();
		frame.findElement(CLOSE_BTN).click();

	}

	@Override
	public void clickreqCategory(String arg1) {
		frame.findElement(SELECTCATEGORYLIST).findElement(By.xpath("//*[text()='" + arg1 + "']")).click();
		frame.findElement(SELECTCTGYOK_BTN).click();
		frame.findElement(CLOSE_BTN).click();
	}

}
