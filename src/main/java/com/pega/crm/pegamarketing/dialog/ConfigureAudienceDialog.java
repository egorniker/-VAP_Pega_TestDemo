
package com.pega.crm.pegamarketing.dialog;

import org.openqa.selenium.By;

public interface ConfigureAudienceDialog extends ConfigureDialog {
	By FIRST_SEARCH_RESULT = By.xpath("(//*[@class='mktcard_secondary_info'])[1]");
	By FIRST_SEARCH_RESULT_LABEL = By.xpath("(//span[@class='guidedprogram_audience'])[1]");

	/**
	 * This is used to add first segment from the dialog
	 */
	void addFirstSegment();

	/**
	 * selects the first item from the search result
	 */
	void selectFirstSearchResult();

	/**
	 * selects the first item from the search result
	 */
	void selectFromFirstSearchResult();

	/**
	 * to add the segment with the below name
	 * 
	 * @param segmentName
	 */
	void addSegment(String segmentName);

}
