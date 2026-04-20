package com.pega.crm.pegamarketing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.pega.exceptions.PegaWebDriverException;

public class TestDataReader {
	private static Properties prop = null;

	public static String getTestDataValue(String key) {

		if (prop == null) {
			prop = new Properties();
			try {
				File f = new File("testdata.properties");
				if (!f.exists()) {
					f = new File("Data" + System.getProperty("file.separator") + "testdata.properties");
				}
				prop.load(new FileInputStream(f));
			} catch (IOException e) {
				e.printStackTrace();
				throw new PegaWebDriverException(" Unable to read testdata.propertiess file");
			}
		}

		return prop.getProperty(key);
	}

}
