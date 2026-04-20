package com.pega.crm.pegamarketing.explorer;

import com.pega.crm.pegamarketing.pages.LandingPage;

public interface RecordsExplorer {
	/**
	 * Opens the a particular Recor4d page from the records explorer
	 * 
	 * @param t
	 *            Class representing the page which is to be opened
	 * @param path
	 *            the menu items which needs to be expanded
	 * @return Intended Landing page
	 */
	<T extends LandingPage> T openRecord(Class<T> t, String... path);

}
