package com.pega.crm.customerservice.tiles;

import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.interactions.ResearchInteraction;

public interface TopNav {

	<T extends Interactions> T getDemoInteractionType(String value);

	<T extends Interactions> T getInteractionType(String value);

	<T extends Interactions> T returnInteractionType(String value);

	<T extends Interactions> T getDemoInteractionTypeAsManager(String value);

	// New Application
	String Link_AppType = "//span[text()='TextValue']";
	String Chk_NewAppWiz = "//label[text()='Close Account']/preceding-sibling::input[1]";
	String Link_AdvancedConfig = "//a[text()='Advanced configuration']";
	String RBN_AppStructure = "//label[text()='TextValue']";
	String Txt_AppId_Id = "pyApplicationName";
	String Btn_Save = "//button[text()='Save']";
	String Btn_Cancel = "//button[text()='Cancel']";
	String Btn_CreateApp = "//button[text()='Create application']";
	String CS_IMPL_OPERATOR_MENU_XPATH = "//*[@data-test-id='px-opr-image-ctrl' and @data-menuid='pyNavigation1531237118455']";
	String CS_IMPL_OPERATOR_XPATH = "//span[text()='Operator']";
	String CS_IMPL_LogOff_XPATH = "//span[text()='Log off']";
	String NewAppAccessGrp_Xpath = "//input[contains(@value,'Value')]";
	String RBN_NewAppAccessGrp_Xpath = "//input[contains(@value,'ReplaceValue')]/ancestor::td[2]/preceding-sibling::td[1]/descendant::input[@type='radio']";
	String RBN_CSAccessGrp_Xpath = "//a[contains(text(),'PegaCS')]/ancestor::td[2]/preceding-sibling::td[2]/descendant::input[@type='radio']";
	String Btn_RemoveNewAccessGrp_Xpath = "//input[contains(@value,'ReplaceValue')]/ancestor::td[2]/following-sibling::td/descendant::a[@data-test-id='20151125051921001622247']";
	String Btn_SwitchToNewApplication_Xpath = "//input[contains(@value,'ReplaceValue')]";
	String Link_DSMenuNav_Xpath = "//span[text()='TextValue']/ancestor::li[@role='presentation']";
	String Link_DesignerStudio_Xpath = "//a[contains(text(),'Designer Studio')]";
	String Tab_QuerySettings_Xpath = "//*[contains(text(),'Query settings')]/ancestor::div[contains(@class,'Collapsed')]";
	// String
	// Chk_Search_Xpath="//*[contains(text(),'TextValue')]/ancestor::td[1]/preceding-sibling::td/descendant::input[2]";
	String Chk_Search_Xpath = "//input[@id='pyEnable3']";
	String Btn_Reindex = "//*[contains(text(),'TextValue')]/ancestor::td[1]/following-sibling::td/descendant::button[contains(text(),'Re-index')]";
	String Btn_ReindexOk = "//*[contains(text(),'OK')]/ancestor::button[1]";
	String Btn_CancelReindex = "//button[text()='Cancel re-index']";
	String PHONE_ICON_XPATH = "//i[@name='PegaCallControlPanel_CTIPhone_1']";
	String LOGIN_BUTTON_XPATH = "//button[text()='Login']";
	String SEARCH_BOX_XPATH = "//input[@data-test-id='2015052504543705231680']";
	String SEARCH_ITEM_XPATH = "//*[@data-test-id='2015052504543705282660']";
	String SELECT_DATA_SOURCE_XPATH = "//select[@data-test-id='201610190747440120129777']";

	String CHAT_SERVER_XPATH = "//select[@data-test-id='2014121804320102541978']";
	String CHAT_SERVER_DISPLAY_NAME_XPATH = "//input[@data-test-id='2014121804320102584575']";

	String CTI_LINK_XPATH = "//select[@data-test-id='2014111308113202885473']";
	String EXTENSION_XPATH = "//input[@data-test-id='20141113081132029011795']";
	String CCTUSER_XPATH = "//input[@data-test-id='2015061000554601945820']";
	String CCTPASSWORD_XPATH = "//input[@data-test-id='2015061000554601968695']";
	String AGENT_XPATH = "//input[@data-test-id='20141113081132029320504']";
	String PASSWORD_XPATH = "//input[@data-test-id='20141113081132029523156']";
	String ERROR_MESSAGE_XPATH = "//span[@data-test-id='20141113081132029941929' and contains(text(),'The passive terminal cannot be updated while the Agent')]";

	PhoneCall createNewPhoneCall();

	OutboundPhoneCall createOutboundPhoneCall();

	ResearchInteraction search(String name);

	ResearchInteraction closeInteraction();

	ResearchInteraction initiateACall(String result);

	ResearchInteraction searchResult(String interactionType, String name);

	String getStatusOfCase();

	void searchPortal(String name);

	NewInboundInteraction startInboundCase();

	NewDemoInteraction createNewDemoPop();

	ResearchInteraction setResearchInteraction();

	ResearchInteraction selectandSearchResearchType(String searchType, String value);

	ResearchInteraction ClickFavourite();

	ResearchInteraction switchInteraction(String interactionItem);

}
