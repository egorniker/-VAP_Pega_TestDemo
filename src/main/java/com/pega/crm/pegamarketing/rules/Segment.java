package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;

public interface Segment extends RuleInstance {

	static String CUSTOMER_LIST_TAB_XPATH = "//li[@role='tab' and @title='Customer list']";
	static By DESIGN_TAB = By.xpath("//li[@role='tab' and @title='Design']");
	static By OPTIONS_AND_SCHEDULE_TAB = By.xpath("//li[@role='tab' and @title='Options and schedule']");
	static String DEFAULT_SEGMENT_IMAGE_XPATH = "//div[@class='nbam-pi size-large nbam-pi-list-segment color-grey']";
	static String TOTAL_CUTOMER_COUNT_LABEL_XPATH = "//div[text()='Total customer count:']";
	static String IN_THIS_SEGMENT_LABEL_XPATH = "//div[text()='In this segment:']";
	static String IMPORT_LINKTEXT = "Import";
	static String ADD_LINKTTEXT = "Add";
	static String CHANGE_IMAGE_LINKTTEXT = "Change image";
	static String CUSTOMERID_HEADER_DIV_XPATH = "//th[@title='Click to sort']//div[text()='CustomerID']";
	static String NAME_HEADER_DIV_XPATH = "//th[@title='Click to sort']//div[text()='Name']";
	static String EMAIL_HEADER_DIV_XPATH = "//th[@title='Click to sort']//div[text()='Email']";
	static String IMAGE_XPATH = "//img[@class='segment-list-image']";
	static By HISTORY_TAB = By.xpath("//li[@role='tab' and @title='History']");
	static By ADD_GROUP_LINK = By.linkText("Add group");
	static By ADD_CRITERIA_LINK = By.xpath("(//a[text()='Add criteria'])[last()]");
	static By CRITERIA_VALUE_TEXT_BOX = By.xpath(
			"//input[@placeholder='Enter a value' and @value='']|//input[@placeholder='0' and @value='' and contains(@id,'Values') and @validationtype='double']");
	static By CRITERIA_VALUE_TYPE_SELECT = By.xpath("//select[contains(@name,'pSearchType')]");
	String CRITERIA_VALUE_TEXT_BOX2 = "//div[@node_name='Criteria' and contains(@pyclassname,'Criteria')][.//strong[contains(text(),'<Criteria_Name>')]]//input[contains(@name,'SearchString')]";
	String CRITERIA_VALUE_TYPE_SELECT2 = "//div[@node_name='Criteria' and contains(@pyclassname,'Criteria')][.//strong[contains(text(),'<Criteria_Name>')]]//select[contains(@name,'SearchType')]";
	static By VISUALIZATION_MODE_TRUE_BUTTON = By
			.xpath("//button[contains(@data-click,'SetSegmentVisualizationMode,')]");
	static By VISUALIZATION_MODE_FALSE_BUTTON = By
			.xpath("//button[contains(@data-click,'SetSegmentVisualizationModeFalse')]");
	static By STOP_LINK = By.linkText("Stop");
	static By POPULATION_COUNT_SPAN = By.xpath("//div[text()='Population count:']/following-sibling::div/span");
	static By DATA_REFRESH_HEADER = By.xpath("//div[text()='Data refresh']");
	static By SAMPLED_SEGMENT_OPTIONS_HEADER = By.xpath("//div[text()='Sampled segment']");
	static By SCHEDULING_OPTIONS_HEADER = By.xpath("//div[text()='Scheduling']");
	static By COMPARE_TYPE_SELECT_BOX = By.xpath("//*[@data-test-id='20170803151002054423322']");
	static By ENABLE_PAID_SYNC = By.xpath("//input[@data-test-id='201805160131080251334']");
	static By PAID_DESTINATION = By.xpath("//input[@type='checkbox'][contains(@name,'ppxResults$l1')]");
	static By SELECT_ITEM_INLIST_LINK = By.xpath("//a[text()='Select items']");
	static By IMPORT_LINK = By.linkText("Import");
	By REFRESHABLE_SEGMENT_CHECKBOX = By.xpath(PMXPathUtil.getCheckboxContainingNameXpath("RefreshableSegment"));
	By REFRESH_CHILD_SEGMENTS_CHECKBOX = By
			.xpath(PMXPathUtil.getCheckboxContainingNameXpath("ExecuteDependedentSegments"));

	/**
	 * this is a modal dialog pops up when you click on Add Criteria link in
	 * Segment.
	 * 
	 * @author berip
	 */
	public interface AddCriteriaDialog extends ModalDialog {

		By SEARCH_INPUT_BOX = By.xpath(
				"//div[@node_name='CriteriaSelector']//div[contains(@class,' active') and contains(@class,'layout')]//input[contains(@name,'SearchTerm')]");
		By MAGNIFIER_ICON = By.xpath("//*[@data-test-id='20170717083149055438610'][contains(@name,'DataFields')]");

		/**
		 * Chooses given criteria from Add Criteria modal dialog
		 * 
		 * @param criteria
		 *            Criteria to be choosen
		 */
		void selectCriteria(String criteria);

		/**
		 * Chooses criteria from Data field
		 * 
		 * @param criteria
		 */
		String selectDataFieldCriteria(String criteria);

		/**
		 * Chooses criteria from Segment
		 * 
		 * @param criteria
		 */
		void selectSegmentCriteria(String criteria);

	}

	public interface UploadFileDialog extends ModalDialog {
		static By CHOOSE_FILE_TEXTBOX = By.xpath("//input[contains(@name,'pyFilePath')]");
		static By PURPOSE_SELECTBOX = By.xpath("//select[contains(@name,'pyImportPurpose')]");
		static By NEXT_BUTTON = By.xpath(PMXPathUtil.getButtonTdBtnXpath("Next>>"));
		static By START_VALIDATION_BUTTON = By.xpath(PMXPathUtil.getButtonTdBtnXpath("Start validation"));
		static By CONTINUE_IMPORT_BUTTON = By.xpath(PMXPathUtil.getButtonTdBtnXpath("Continue import"));
		static By FINISH_BUTTON = By.xpath(PMXPathUtil.getButtonTdBtnXpath("Finish"));
		static By VALID_ROWS_SPAN = By.xpath("//div[./span[contains(text(),'Valid rows:')]]/div/span");

		/**
		 * this method will choose the file that we want to import
		 * 
		 * @param fileName
		 *            file name that we want to import
		 */
		void chooseFile(String fileName);

		/**
		 * this method will set the given purpose while importing the customer records
		 * in list based segment
		 * 
		 * @param purpose
		 */
		void setPurpose(String purpose);

		/**
		 * this method just clicks on next button in upload file dialog
		 */
		void next();

		/**
		 * this method just clicks on start validation button in upload file dialog
		 */
		void startValidation();

		/**
		 * this method just clicks on Continue import button in upload file dialog
		 */
		void continueImport();

		/**
		 * this method just clicks on Finish button in upload file dialog
		 */
		void finish();

		/**
		 * this will return the number of rows imported properly
		 * 
		 * @return number of valid rows
		 */
		String getValidRows();
	}

	public interface SelectItemsDialog extends ModalDialog {
		public void selectItems(String... items);
	}

	/**
	 * selects list type segment type
	 */
	void selectListType();

	/**
	 * selects criteria type segment type
	 */
	void selectCriteriaType();

	/**
	 * this method changes the image of a segment
	 * 
	 * @param picName
	 */
	void changeImage(String picName);

	/**
	 * This method will close the Edit Segment page
	 */
	void close();

	/**
	 * this method adds a new group in segment rule
	 */
	void addGroup();

	/**
	 * this method adds a new criteria in latest group
	 * 
	 * @return returns Add Criteria modal dialog
	 */
	AddCriteriaDialog addCriteria();

	/**
	 * this method enter the given criteria value for Criteria that already choosen
	 * 
	 * @param criteriaValue
	 *            value to be written
	 */
	void enterCriteriaValue(String criteriaValue);

	/**
	 * this method enters the given criteria value for specified Criteria
	 * 
	 * @param criteriaName
	 * @param criteriaValue
	 */
	void enterCriteriaValue(String criteriaName, String criteriaValue);

	/**
	 * this method enter the given criteria type for Criteria that already choosen
	 * 
	 * @param criteriaType
	 *            value to be written
	 */

	void enterCriteriaType(String criteriaType);

	/**
	 * this method enters the given criteria type for specified Criteria
	 * 
	 * @param criteriaName
	 * @param criteriaType
	 */
	void enterCriteriaType(String criteriaName, String criteriaType);

	/**
	 * this method runs the current segment
	 */
	void run();

	/**
	 * this method waits till the segment run completed
	 */
	void waitForRun();

	/**
	 * this method selects the given comparision in segment
	 * 
	 * @param comparisionType
	 *            type to be selected
	 */
	void selectComparision(String comparisionType);

	/**
	 * this method enables the sync for paid media
	 */
	void clickEnablePaidSync();

	/**
	 * this method selects the paid media destination
	 */
	void selectPaidDestination();

	/**
	 * this method clicks on SelectItems link for inlist segment
	 * 
	 * @return SelectItemsDialog modal dilogue
	 */
	public SelectItemsDialog selectItemsForInList();

	/**
	 * this method will import customer records for list based segment
	 * 
	 * @param fileName
	 */
	UploadFileDialog importCustomerRecords();

	void enableRefreshableSegment();

	void enableRefreshChildSegments();
}
