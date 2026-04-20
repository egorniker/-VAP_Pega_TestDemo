package com.pega.crm.salesautomation.workobjects.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PegaUtil {
	public static String getSimpleButtonXPath(String buttonText) {
		return "//button[contains(@class, 'Simple pzhc pzbutton') and contains(text(), '" + buttonText + "')]";
	}

	public static String getButtonXpath(String buttonText) {

		return "//button[contains(@class, 'pzhc pzbutton') and contains(text(),'" + buttonText + "')]";
	}

	public static String getStrongButtonXPath(String buttonText) {
		return "//button[contains(@class, 'Strong pzhc pzbutton') and contains(text(), '" + buttonText + "')]";
	}

	public static String getSegmentedButtonXPath(String buttonText) {
		return "//button[contains(@class, 'Segmented pzhc pzbutton') and contains(text(), '" + buttonText + "')]";
	}

	public static String getButtonXpathWithIcon(String buttonText) {
		return "//i[contains(@title, '" + buttonText + "')]";
	}

	public static String getMenuDropdownXpath(String menuItem) {
		return "//*[contains(@class,'menu') and text()='" + menuItem + "']";
	}

	public static String getDateFormatter(String date, String Format) {
		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(Format);
		try {
			dt = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String strDate = formatter.format(dt);
		return strDate;
	}
}
