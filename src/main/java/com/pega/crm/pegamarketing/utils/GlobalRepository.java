package com.pega.crm.pegamarketing.utils;

import com.pega.util.LocalizationUtil;
import com.pega.util.XPathUtil;

public class GlobalRepository {

	// Used in addNewPortal() method
	public static final String ACCESSGROUP_ADD_PORTAL_LINK_XPATH = "//a[contains(@title,'Add item')]";
	public static final String EMPTY_PORTAL_INPUT = "//input[contains(@name,'PortalLayout') and @value='']";

	// Used in delete() method
	public static final String RULE_INSTANCE_IMPL_DELETE_ID = "pyDeleteMemo";
	public static final String RULE_INSTANCE_IMPL_DELETE_ASSIGNMENT_XPATH = "//button[@alt='Complete this assignment' and text()='  Delete ']";

	public static final String SUBMIT_BUTTON_XPATH = "//button[@class='Strong pzhc pzbutton' and contains(text(),'"
			+ LocalizationUtil.getLocalizedWord("Submit") + "')]|//div[contains(text(),'"
			+ LocalizationUtil.getLocalizedWord("Submit") + "')]|//button[contains(text(),'"
			+ LocalizationUtil.getLocalizedWord("Submit") + "')]|//button[contains(text(),'"
			+ LocalizationUtil.getLocalizedWord("OK") + "')]";
	public static final String CREATE_BUTTON_XPATH = "//button[@class='buttonTdButton' and contains(text(),'Create')]";
	public static final String DUE_DATE_INPUT_XPATH = "//input[contains(@id,'PpyWorkPage$ppyDueByField')]";
	public static final String MODAL_BUTTON_SUBMIT_ID = "ModalButtonSubmit";
	public static final String OK_BUTTON_XPATH = "(//div[@class='pzbtn-mid' and contains(text(),'OK')])[position()=last()]";
	public static final String OVERLAY_SUBMIT_BUTTON_XPATH = "//button[contains(@onclick,'doOverlayAction') and contains(text(),'Submit')]";
	public static final String OK_BUTTON_IN_PROMPT_WINDOW_XPATH = "//button[@class='buttonTdButton'][contains(text(),'OK')]";
	public static final String MODAL_BUTTON_OK_ID = "ModalButtonOk";
	public static final String MODAL_BUTTON_CANCEL_ID = "ModalButtonCancel";
	public static final String CLOSE_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Close");
	public static final String SUBMIT_AND_CREATE_BTN_XPATH = XPathUtil.getButtonPzBtnMidXPath("Submit & create");
	public static final String MODAL_BUTTON_SUBMIT_XPATH = XPathUtil
			.getButtonStrongPzhcPzBtnXPath(LocalizationUtil.getLocalizedWord("Submit"));

	// Used in save() method in PreferencesImpl class
	public static final String MODAL_WINDOW_SAVE_BUTTON_XPATH = "//button[contains(text(),'Save')]";

	// Used in creating rule instance
	public static final String APPLY_TO_LOOKUP_ID = "pyClassName";

	public static final String ADD_TITLE_XPATH = "//div[contains(@datasource, 'pyPagesAndClasses')]//a[@title='Add item ']";

	public static String PEGA_PULSE_EXPAND_ICON_XPATH = "//div[contains(@title,'Click to expand P')]/i|//div[contains(@title,'Disclose Pega Pulse')]/i";
	public static String PEGA_PULSE_COLLAPSE_ICON_XPATH = "//div[contains(@title,'Click to collapse P')]/i";
	public static String PEGA_PULSE_SWITCH_TO_MESSAGE_TAB_XPATH = "//div[@role='tab'][h3[contains(text(),'Message')]]|//a[@tabtitle='Message']";
	public static String PEGA_PULSE_SWITCH_TO_FILE_TAB_XPATH = "//div[@role='tab'][h3[contains(text(),'File')]]|//a[@tabtitle='File']";
	public static String PEGA_PULSE_SWITCH_TO_LINK_TAB_XPATH = "//div[@role='tab'][h3[contains(text(),'Link')]]|//a[@tabtitle='Link']";
	public static String PEGA_PULSE_POST_MESSAGE_TEXTAREA_XPATH = "//textarea[contains(@id,'pyDescription')]";
	public static String PEGA_PULSE_POST_FILE_NAME_PATH_TEXTBOX_ID = "pyFileName";
	public static String PEGA_PULSE_POST_BROWSE_FILE_BUTTON_ID = "Top";
	public static String PEGA_PULSE_POST_FILE_MESSAGE_TEXTAREA_XPATH = "//textarea[contains(@id,'pyFileDescription')]";
	public static String PEGA_PULSE_POST_LINK_URL_TEXTBOX_ID = "pyLinkURL";
	public static String PEGA_PULSE_POST_LINK_NAME_TEXTBOX_ID = "pyLinkName";
	public static String PEGA_PULSE_POST_LINK_MESSAGE_TEXTAREA_XPATH = "//textarea[contains(@id,'pyLinkDescription')]";
	public static String PEGA_PULSE_SHARE_BUTTON_XPATH = "//div[@node_name='pzPostActions']//div[@role='tabpanel' and contains(@style,'block')]//button[@title='Share']";
	public static final String HOME_TAB_XPATH = "//span[text()='Home']";
	public static final String BUTTON_SYSTEM_INFORMATION_XPATH = XPathUtil.getButtonPzhcBtnXPath("System Information");
	public static final String REFRESH_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Refresh");
	public static final String EDIT_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Edit");
	public static final String SAVE_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Save");
	public static final String DISCARD_BUTTON_XPATH = XPathUtil.getButtonPzBtnMidXPath("Discard");
	public static final String MODAL_DIALOG_ID = "modalWrapper";
	public static final String Modal_BUTTON_CANCEL_ID = "ModalButtonCancel";
	public static final String MODAL_BUTTON_XPATH = "//div[@id='modalOverlay' and contains(@style,'block')]//button[@id='"
			+ MODAL_BUTTON_OK_ID + "']|//div[@id='modalOverlay' and contains(@style,'block')]//button[@id='"
			+ MODAL_BUTTON_SUBMIT_ID
			+ "']|//div[@class='pzbtn-mid' and text()='Submit']|//button[contains(@data-click,'submitModalDlgParam') and contains(text(),'Submit')]|//div[@class='pzbtn-mid' and text()='Done']";
	public static final String SELECT_IN_AUTO_COMPLETE_ID = "ISnsSelect";
	public static final String CLOSE_MODAL_BTN_XPATH = "//button[@title='close modal']";
	public static final String NEW_CLOSE_MODAL_BTN_XPATH = "//button[contains(@data-click,'Close')][./i[contains(@class,'close-circle')]]|//i[contains(@data-click,'Close')]";
	public static final String POPUP_CLOSE_MODAL_BTN_XPATH = "//button[@id='ModalButtonCancel']";
	public static final String PL_INDEX_ATTRIBUTE = "pl_index";
	public static final String ID_ATTRIBUTE = "id";
}
