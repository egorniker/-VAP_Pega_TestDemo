package com.pega;
/**
 * 
 */

import java.util.LinkedHashMap;
import java.util.Map;

import com.pega.util.DataUtil;
//import com.pega.wizard.DecisioningServices;

/**
 * @author Sachin Vellanki
 * @since 03-Feb-2016
 *
 */
public class CRMObjectsBean {

	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: ObjectsBean.java 199996 2018-06-23 12:45:16Z AnilBattinapati $";

	private static Map<String, Object> objectsMap = new LinkedHashMap<String, Object>();
	private static Map<String, String> objectNames = new LinkedHashMap<String, String>();

	public static Map<String, String> getTimestampedName() {
		return objectNames;
	}

	public static String putTimeStampedValue(String name) {
		String existingValue = objectNames.get(name);
		if (existingValue == null) {
			String value = DataUtil.getRandomNumberString(name);
			objectNames.put(name, value);
			return value;
		} else {
			return existingValue;
		}
	}

	public static String getTimestampedValue(String name) {
		String value = objectNames.get(name);
		if (value != null) {
			return value;
		} else {
			return name;
		}
	}

	public static Map<String, String> getObjectNames() {
		return objectNames;
	}

	public static void putObjectNames(String objectName, String objectValue) {
		objectNames.put(objectName, objectValue);
	}

	public static Map<String, Object> getObjectsMap() {
		return objectsMap;
	}

}