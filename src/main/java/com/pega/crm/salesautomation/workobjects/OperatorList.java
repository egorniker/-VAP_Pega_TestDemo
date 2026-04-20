package com.pega.crm.salesautomation.workobjects;

public interface OperatorList extends WorkObject {

	Operators creasteOperator();

	OperatorList searchOperator(String orgName);

	Operators navigateOperator();

	boolean isOperatorListEmpty();

	Operators openFirstOperator();

	boolean verifyOperatorListPage();

	boolean validateListPage();

	boolean validateOprListPage();

}