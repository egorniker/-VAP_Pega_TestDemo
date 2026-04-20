package com.pega.crm.salesautomation.workobjects;

public interface Operators extends WorkObject {

	void setOperatorID(String str);

	void setPassword(String str);

	void setTitle(String str);

	void setFirstName(String str);

	void setLastName(String str);

	void setPostition(String str);

	void setPhone(String str);

	void setEmail(String str);

	void setTimeZone(String str);

	void setReportTo(String str);

	void ClickRefresh();
	void setOperatorType(String str);

	void setTerritory(String str);

	String getOperatorId();

	String getTitle();

	String getFirstName();

	String getLastName();

	String getFullName();

	String getPostition();

	String getPhone();

	String getEmail();

	String getTimeZone();

	String getReportsTo();

	void navigateToAccessAndPermissionsTab();

	String getOperatorType();

	String getTerritory();

	void defaultSalesRepAccess();

	boolean verifyOprSalesGoalsScreen();

	boolean verifyOprAccessScreen();

	boolean verifyOprNewHarness();

	void clickNext();

	void clickFinish();

	Operators navigateOperator();

}
