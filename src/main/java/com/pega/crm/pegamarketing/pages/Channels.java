package com.pega.crm.pegamarketing.pages;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;
import com.pega.framework.Window;
import com.pega.framework.elmt.Frame;

public interface Channels extends Frame {
	By ADD_CONNECTION_BTN = By.xpath(PMXPathUtil.getDataTestIdXPath("2014110508473501265753"));
	By lnkPaidMedia = By.xpath("//*[@data-repeat-id='LGLayoutGroupChannelSettingsS1']//h3[text()='Paid Media']");

	/**
	 * It opens the Add Outbound SMS Connection dialog
	 * 
	 * @return
	 */
	AddOutboundSMSConnection addConnection();

	public interface AddOutboundSMSConnection extends ModalDialog {
		By ACCOUNT_NAME_TXTBOX = By.id("AccountName");
		By HOST_ADDRESS_TXTBOX = By.id("Host");
		By HOST_PORT_TXTBOX = By.id("Port");
		By USER_ID_TXTBOX = By.id("UID");
		By PASSWORD_TXTBOX = By.id("PWD");
		By TEST_NUMBER_TXTBOX = By.id("TestNumber");
		By SENDERS_NUMBER_TXTBOX = By.id("SendersNumber");
		By MAXIMUM_CONNECTIONS_TXTBOX = By.id("MaxConnections");

		/**
		 * It fills the connections details in the Add Outbound SMS Connection dialog
		 * 
		 * @param accountName
		 * @param hostAddress
		 * @param port
		 * @param userId
		 * @param password
		 * @param testNumber
		 * @param senderNumber
		 */
		public void addConnectionSetup(String accountName, String hostAddress, String port, String userId,
				String password, String testNumber, String senderNumber);
	}

	public interface PaidMediaSetting {
		/** The lnk channel. */
		By lnkChannel = By.xpath("//span/a[text()='Channels']");

		/** The lnk paid media. */

		/** The btn linked in tab. */
		By btnLinkedInTab = By.xpath("(//*[@id='RULE_KEY']/div[2]//span[text()='LinkedIn Ads'])[3]");

		/** The btn linked in destination. */
		By btnLinkedInDestination = By.xpath("(//span/button[text()='Add destination'])[4]");

		/** The txt linked in setting pop up header. */
		By txtLinkedInSettingPopUpHeader = By.xpath("//*[@id='modaldialog_hd_title']");

		/** The txt destination name. */
		By txtDestinationName = By.id("pyLabel");

		/** The txt decsription. */
		By txtDecsription = By.id("pyDescription");

		/** The btn apply. */
		By btnApply = By.id("ModalButtonSubmit");

		/** The lnk linked in submitted setting. */
		By lnkLinkedInSubmittedSetting = By.xpath("//*[@id='$PLinkedInSettings$ppxResults$l1']/td[1]/div");

		/** The txtbox account id. */
		By txtboxAccountId = By.id("AccountID");

		/** The txtbox access token. */
		By txtboxAccessToken = By.id("AccessToken");

		/** The txtbox source platform. */
		By txtboxSourcePlatform = By.xpath("//*[@id='SourcePlatform']");

		/** The txtbox email. */
		By txtboxEmail = By.xpath("//*[contains(@name,'pEmailList')]");

		/** The txt google refresh token. */
		By txtGoogleRefreshToken = By.xpath("//*[@id='RefreshToken']");

		/** The txt google client customer ID. */
		By txtGoogleClientCustomerID = By.xpath("//*[@id='ClientCustomerID']");

		/** The app id add icon for adwords. */
		By lnkAddAppID = By.xpath("//a[contains(text(),'Add app ID')]");

		/** The device id add icon for adwords. */
		By lnkAddDeviceID = By.xpath("//a[contains(text(),'Add device')]");

		/** The textbox for adwords app id. */
		By txtAppID = By.xpath("//*[contains(@name,'pAppIDList')]");

		/** The textbox for adwords device id. */
		By txtDeviceID = By.xpath("//*[contains(@name,'pDeviceIDList')]");

		/** The btn facebook ads tab. */
		By btnFacebookAdsTab = By
				.xpath("(//span[@data-test-id='20180210004443074811317' and text()='Facebook Ads'])[3]");

		/** The btn facebook ads destination. */
		By btnAdsDestination = By.xpath("(//button[text()='Add destination'])[4]");

		/** The txt facebook setting pop up header. */
		By txtFacebookSettingPopUpHeader = By.xpath("//*[@id='modaldialog_hd_title']");

		/** The txtbox app token. */
		By txtboxAppToken = By.xpath("//*[@id='AppToken']");

		/** The txtbox phone. */
		By txtboxPhone = By.xpath("//*[contains(@name,'pPhoneList')]");

		/** The chkbox campiagn generation. */
		By chkboxCampiagnGeneration = By.xpath("//*[contains(@name,'pEnableCampaignCreation')][2]");

		/** The lnk submitted setting. */
		By lnkSubmittedSetting = By.xpath("//*[@id='$PFacebookSettings$ppxResults$l1']/td[1]/div/span/a");

		/** The txtbox gender. */
		By txtboxGender = By.xpath("//*[@id='Gender']");

		/** The txtbox DOB. */
		By txtboxDOB = By.xpath("//*[@id='DateOfBirth']");

		/** The txtbox first name. */
		By txtboxFirstName = By.xpath("//*[@id='FirstName']");

		/** The txtbox last name. */
		By txtboxLastName = By.xpath("//*[@id='LastName']");

		/** The txtbox first name initial. */
		By txtboxFirstNameInitial = By.xpath("//*[@id='FirstNameInitial']");

		/** The txtbox state. */
		By txtboxState = By.xpath("//*[@id='State']");

		/** The txt zip. */
		By txtZip = By.xpath("//*[@id='Zip']");

		/** The txt country. */
		By txtCountry = By.xpath("//*[@id='Country']");

		/** The txt external ID. */
		By txtExternalID = By.xpath("//*[@id='ExternalId']");

		/** The chkbox all customer audience. */
		By chkboxAllCustomerAudience = By.xpath("//*[@id='AllCustomersAudienceName']");

		/** The ckhbox enable offline conversion push. */
		By ckhboxEnableOfflineConversionPush = By.xpath("//*[text()='Enable offline conversion push']");

		/** The btn destination. */
		// Paid Settings tab
		By btnDestination = By
				.xpath("//div[text()='Destination']//ancestor::*[@pl_prop_class='Data-PaidMedia-Facebook']");

		/** The btn account ID. */
		By btnAccountID = By.xpath("//div[text()='Account ID']//ancestor::*[@pl_prop_class='Data-PaidMedia-Facebook']");

		/** The btn destination key. */
		By btnDestinationKey = By
				.xpath("//div[text()='Destination key']//ancestor::*[@pl_prop_class='Data-PaidMedia-Facebook']");

		/** The btn last updated. */
		By btnLastUpdated = By
				.xpath("//div[text()='Last updated']//ancestor::*[@pl_prop_class='Data-PaidMedia-Facebook']");

		/** The btn updated by. */
		By btnUpdatedBy = By
				.xpath("//div[text()='Updated  By']//ancestor::*[@pl_prop_class='Data-PaidMedia-Facebook']");

		/** The btn google ads tab. */
		// Google settings tab
		By btnGoogleAdsTab = By.xpath("(//*[@id='RULE_KEY']/div[1]//span[text()='Google AdWords'])[6]");

		/** The txt google setting pop up header. */
		By txtGoogleSettingPopUpHeader = By.xpath("//*[@id='modaldialog_hd_title']");

		/** The txt google client ID. */
		By txtGoogleClientID = By.xpath("//*[@id='ClientID']");

		/** The txt google client secret. */
		By txtGoogleClientSecret = By.xpath("//*[@id='ClientSecret']");

		/** The txt google developer token. */
		By txtGoogleDeveloperToken = By.xpath("//*[@id='DeveloperToken']");

		/** The txt googlebox email. */
		By txtGoogleboxEmail = By.xpath("//*[@id='pyValue']");

		// adobe settings tab
		By btnAdobeAdsTab = By.xpath("(//*[@id='RULE_KEY']/div[2]//span[text()='Adobe Audience Manager'])[3]");

		/** The txt adobe setting pop up header. */
		By txtAdobeSettingPopUpHeader = By.xpath("//*[@id='modaldialog_hd_title']");

		/** The txt adobe DP id. */
		By txtAdobeDPId = By.xpath("//*[@id='DataPartnerID']");

		/** The txt data source id. */
		By txtDataSourceId = By.xpath("//*[@id='DatasourceID']");

		/** The txt API user name. */
		By txtAPIUserName = By.xpath("//*[@id='APIUsername']");

		/** The txt API password. */
		By txtAPIPassword = By.xpath("//*[@id='APIPassword']");

		/** The txt API client id. */
		By txtAPIClientId = By.xpath("//*[@id='APIClientID']");

		/** The txt API secret key. */
		By txtAPISecretKey = By.xpath("//*[@id='APISecretKey']");

		/** The txt sync id. */
		By txtSyncId = By.xpath("//*[@id='SyncID']");

		/** The txt bucket name. */
		By txtBucketName = By.xpath("//*[@id='BucketName']");

		/** The txt access key. */
		By txtAccessKey = By.xpath("//*[@id='AccessKey']");

		/** The txt secret key. */
		By txtSecretKey = By.xpath("//*[@data-test-id='20170801055645088911996']");

		/** The txt region. */
		By txtRegion = By.xpath("//*[@id='Region']");

		/** The txt folder. */
		By txtFolder = By.xpath("//*[@id='Key']");

		/** The chkbox FTP. */
		// FTP settings
		By chkboxFTP = By.xpath("//*[@id='RULE_KEY']//span[1]/label[text()='FTP']");

		/** The btn web tab. */
		By btnWebTab = By.xpath("(//*[@id='RULE_KEY']/div[2]//span[text()='Web'])[3]");

		/**
		 * Click on linked in tab.
		 */
		public void clickOnLinkedInTab();

		/**
		 * Click on linked in destination.
		 */
		public void clickOnLinkedInDestination();

		/**
		 * Verify popup header text.
		 *
		 * @return the string
		 */
		public String verifyPopupHeaderText();

		/**
		 * Click on apply button.
		 */
		public void clickOnApplyButton();

		/**
		 * Verify submitted paid linked in settings in landing page.
		 *
		 * @return the string
		 */
		public String verifySubmittedPaidLinkedInSettingsInLandingPage();

		/**
		 * Click on facebook ads tab.
		 */
		public void clickOnFacebookAdsTab();

		/**
		 * Click on new facebook ads.
		 */
		public void clickOnNewFacebookAds();

		/**
		 * Click on enable campaign generation.
		 */
		public void clickOnEnableCampaignGeneration();

		/**
		 * Verify submitted paid settings in landing page.
		 *
		 * @return the string
		 */
		public String verifySubmittedPaidSettingsInLandingPage();

		/**
		 * Click on google ad words tab.
		 */
		public void clickOnGoogleAdWordsTab();

		/**
		 * Click on google ad words add destination.
		 */
		public void clickOnGoogleAdWordsAddDestination();

		/**
		 * Click on adobe tab.
		 */
		public void clickOnAdobeTab();

		/**
		 * Click on adobe destination.
		 */
		public void clickOnAdobeDestination();

		/**
		 * Click on FTP.
		 */
		public void clickOnFTP();

		/**
		 * Click on web tab.
		 */
		public void clickOnWebTab();

		/**
		 * Click on web destination.
		 */
		public void clickOnWebDestination();

		/**
		 * Verify linked in paid setting popup header text.
		 *
		 * @return the string
		 */
		public String verifyLinkedInPaidSettingPopupHeaderText();

		/**
		 * Enter connection details on linked in paid settings.
		 *
		 */
		public void enterConnectionDetailsOnLinkedInPaidSettings(String linkedInDestinationName,
				String linkedInDescription, String accountIdLinkedIn, String accessToken, String sourcePlatform,
				String emailLinkedIn);

		/**
		 * Verify FB paid setting popup header text.
		 *
		 * @return the string
		 */
		public String verifyFBPaidSettingPopupHeaderText();

		/**
		 * Verify ad words paid setting popup header text.
		 *
		 * @return the string
		 */
		public String verifyAdWordsPaidSettingPopupHeaderText();

		/**
		 * Verify adobe paid setting popup header text.
		 *
		 * @return the string
		 */
		public String verifyAdobePaidSettingPopupHeaderText();

		/**
		 * Verify web paid setting popup header text.
		 *
		 * @return the string
		 */
		public String verifyWebPaidSettingPopupHeaderText();

		/**
		 * Enter connection details on FB paid settings.
		 * 
		 */
		public void enterConnectionDetailsOnFBPaidSettings(String destName, String desc, String accountId,
				String appToken, String phone, String email);

		/**
		 * Enter connection details on ad words paid settings.
		 */
		public void enterConnectionDetailsOnAdWordsPaidSettings(String destNameAdWords, String descAdWords,
				String clientidAdWords, String clientsecretAdWords, String devtokenAdWords, String emailAdWords,
				String phoneAdwords, String refreshtokenAdWords, String customeridAdWords);

		/**
		 * Click on Add App ID to enter the App id for device configuration
		 */
		public void clickAppId();

		/**
		 * Enter the App ID to for device configuration
		 */
		public void addAppId(String appId);

		/**
		 * Click on Add Device ID to enter the Device id for device configuration
		 */
		public void clickDeviceId();

		/**
		 * Enter the Device ID to for device configuration
		 */
		public void addDeviceId(String deviceId);

		/**
		 * Enter connection details on adobe paid settings.
		 *
		 */
		public void enterConnectionDetailsOnAdobePaidSettings(String destNameAdobe, String descAdobe, String dPIdAdobe,
				String dataSourceIdAdobe, String apiUserNameAdobe, String apiPasswordAdobe, String apiClientIdAdobe,
				String apiSecretKeyAdobe, String syncIdAdobe, String s3bucketname, String s3AccessKey,
				String s3SecretKey, String s3Region, String s3Folder);

		/**
		 * Enter connection details on web paid settings.
		 *
		 */
		public void enterConnectionDetailsOnWebPaidSettings(String webDestinationName, String webDescription);

	}

	PaidMediaSetting openPaidMedia();

	/**
	 * It opens the TestConnectivityResults window
	 * 
	 * @param connectionName
	 *            - Name of the connection to be tested
	 * @return
	 */
	public TestConnectivityResults testConnection(String connectionName);

	/**
	 * this is to delete the connection
	 * 
	 * @param accountName
	 */
	public void deleteSMSAccount(String accountName);

	public interface TestConnectivityResults extends Window {
		By ACCOUNT_NAME = By.xpath("//div[@id='h1_ViewLabel']");
		By OVERALL_RESULT = By.xpath("(//div[text()='Overall Result']/following-sibling::table[1]//td)[1]");
		By RESULT_DESCRIPTION = By.xpath("(//div[text()='Overall Result']/following-sibling::table[1]//td)[2]");

		/**
		 * It returns the Account Name
		 * 
		 * @return
		 */
		public String getAccountName();

		/**
		 * It returns overall result
		 * 
		 * @return
		 */
		public String getOverallResult();

		/**
		 * It returns the Description of the result
		 * 
		 * @return
		 */
		public String getResultDescription();

		/**
		 * It closes the window
		 */
		public void closeWindow();
	}
}
