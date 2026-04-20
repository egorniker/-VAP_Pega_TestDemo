package com.pega;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.pega.config.test.TestBase;
import com.pega.util.GlobalConstants;
import com.pega.util.HTTPUtil;
import com.pega.util.PRPCSessionUtil;
import com.pega.util.RecorderUtil;
//import com.vimalselvam.cucumber.listener.Reporter;


import io.cucumber.java.Scenario;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;


/**
 * 
 * @author Sachin Vellanki
 * @since 29-Dec-2015
 *
 */
@ScenarioScoped
public class CRMTestEnvironment extends TestBase {

	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: MyTestEnvironment.java 187193 2018-04-13 01:45:11Z SachinVellanki $";

	private static final Logger LOGGER = LoggerFactory.getLogger(CRMTestEnvironment.class.getName());
	Browser browser;
	TestEnvironmentImpl testsdd;
	private static int passed = 0;
	private static int failed = 0;
	private static int total = 0;
	private String videoFilePath = null;
	private boolean isBrowserInitiailized = false;
	private boolean alwaysSaveVideo = false;
	private boolean isDebugMode = false;

	@Override
	@Inject
	public Browser getBrowser() {
		if (browser == null) {
			browser = new CRMBrowser(this);
		}
		return browser;
	}

	@Before
	public void setUp(Scenario scenario) {
		setUp(scenario, null);
		CRMObjectsBean.getObjectsMap().clear();
	}

	protected void setUp(Scenario scenario, String browserName) {
		// initializeStatus();
		startRecording(scenario);
		configureBrowser();
	}

	@After
	public void tearDown(Scenario scenario) {
		tearDown(scenario, false, alwaysSaveVideo);
	}

	protected void tearDown(Scenario scenario, boolean performLogout) {
		tearDown(scenario, performLogout, alwaysSaveVideo);
	}

	protected void tearDown(Scenario scenario, boolean performLogout, boolean saveVideoForPassedScenario) {
		try {
			isDebugMode = getConfiguration().getSUTConfig().isDebugMode();
			captureScreenshot(scenario);

			if (!isDebugMode) {
				if (performLogout && !scenario.isFailed()) {
					browser.switchToWindow(1);
					logout();
				}
				terminateSession();
			}
			killDrivers();
			captureVideo(scenario, saveVideoForPassedScenario);
		} finally {
			/*
			 * updateWithCurrentStatus("['" + total + "', " + passed + ", " + failed + ", "
			 * + (total - passed - failed) + "]");
			 */
		}
	}

	protected void initializeStatus() {
		if (passed + failed == 0) {
			Properties p = new Properties();
			File f = new File("execution.properties");
			try {
				p.load(new FileInputStream(f));
				total = Integer.parseInt(p.getProperty("tests.total"));
			} catch (Exception e) {
				LOGGER.debug("Unable to read execution.properties file", true);
			}
			updateWithCurrentStatus("['" + total + "', " + passed + ", " + failed + ", " + total + "]");
		}
	}

	protected void startRecording(Scenario scenario) {
		if (System.getenv("JENKINS_URL") != null) {
			String reportsDir = System.getProperty("testReportsDir");
			try {
				String videoFileName = System.getenv("tags");
				videoFilePath = reportsDir + System.getProperty("file.separator") + videoFileName
						+ GlobalConstants.VIDEO_FILE_FORMAT;
				RecorderUtil.startRecording(reportsDir, videoFileName);
				LOGGER.debug("Video recording started...", true);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.debug("Recording could not be started", true);
			}
		}
	}

	/*
	 * private void configureBrowser() { browser = getBrowser(); browser.open();
	 * configuration = getConfiguration(); isBrowserInitiailized = true;
	 * alwaysSaveVideo = configuration.isSaveVideoAlways(); }
	 */
	protected void stopRecording() throws Exception {
		if (System.getenv("JENKINS_URL") != null) {
			RecorderUtil.stopRecording();
		}
	}

	private void deleteVideoFile() {
		if (System.getenv("JENKINS_URL") != null) {
			try {
				File f = new File(videoFilePath);
				if (f.exists()) {
					f.delete();
				}
			} catch (Exception e) {
				LOGGER.debug("Unable to delete video file: " + videoFilePath, mx4j.log.Logger.ERROR, true);
			}
		}
	}

	private void updateWithCurrentStatus(String result) {

		String filePath = "Data/BuildWatcher/TestRunExecutionStatus.html";
		String template = "";
		try {
			Scanner sc = new Scanner(new File(filePath));
			while (sc.hasNextLine()) {
				String currLine = sc.nextLine();
				template = template + currLine + "\r\n";
			}
			sc.close();

			template = template.replaceFirst("\\['\\d+',[\\d,\\s]*\\]", result);
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
			writer.write(template);
			writer.close();
		} catch (IOException e) {
			LOGGER.debug("Error updating status", true);
			e.printStackTrace();
		}
	}

	/*
	 * private void captureScreenshot(Scenario scenario) { if
	 * (System.getenv("JENKINS_URL") != null) { if (scenario.isFailed()) { try {
	 * final byte[] screenshot =
	 * ((TakesScreenshot)getPegaDriver().getDriver()).getScreenshotAs(OutputType.
	 * BYTES); scenario.embed(screenshot, "image/png"); } catch (Exception e) {
	 * scenario.write("Unable to take screenshot<br/>"); } } } }
	 */

	private void captureScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				final byte[] screenshot = ((TakesScreenshot) getPegaDriver().getDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png","screenshot");
				File temp = ((TakesScreenshot) getPegaDriver().getDriver()).getScreenshotAs(OutputType.FILE);
				File dest = new File("target/" + scenario.getName() + ".png");
				FileUtils.copyFile(temp, dest);
				//Reporter.addScreenCaptureFromPath(dest.getAbsolutePath());
			} catch (Exception e) {
				scenario.log("Unable to take screenshot<br/>");
			}
		}
	}

	private void terminateSession() {
		try {
			if (!isDebugMode) {
				terminate();
				LOGGER.debug("Browser terminated...", true);
			}
		} catch (Exception e) {
			LOGGER.debug("BROWSER_TERMINATE_FAILED::" + e.getMessage(), true);
		}
	}

	private void killDrivers() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			getPegaDriver().handleWaits().sleep(5);
			LOGGER.debug("Driver processes killed...", true);
		} catch (IOException e) {
			LOGGER.debug("TASK_KILL_FAILED::" + e.getMessage(), true);
		}
	}

	/*
	 * private void captureVideo(Scenario scenario, boolean
	 * saveVideoForPassedScenario){ try{ stopRecording();
	 * if(System.getenv("JENKINS_URL") != null){ if (scenario.isFailed()) { try{
	 * String url = null; String tags =
	 * getTCIDTag(scenario.getSourceTagNames().toString()); if(tags != null){ tags =
	 * tags.trim(); } if(tags != null && tags.endsWith("-")){ tags =
	 * tags.substring(0, tags.lastIndexOf('-')); } if(tags != null &&
	 * tags.endsWith(",")){ tags = tags.substring(0, tags.lastIndexOf(',')); }
	 * if(System.getenv("job.name") != null){ String buildId =
	 * System.getenv("workspace.path"); buildId =
	 * buildId.substring(buildId.lastIndexOf('-')+1); url =
	 * System.getenv("JENKINS_URL") + "job/" + System.getenv("job.name") + "/ws/" +
	 * GlobalConstants.ARCHIVED_REPORTS_FOLDER_NAME + "/%23" + buildId + "- " +
	 * System.getenv("team.name") + "/" + tags + "/" + tags +
	 * GlobalConstants.VIDEO_FILE_FORMAT; }else{ url = System.getenv("JOB_URL")
	 * +"ws/" + GlobalConstants.ARCHIVED_REPORTS_FOLDER_NAME + "/%23" +
	 * System.getenv("BUILD_ID") + "- " + System.getenv("team.name") + "/" + tags +
	 * "/" + tags + GlobalConstants.VIDEO_FILE_FORMAT; } url.replace(" ", "%20");
	 * scenario.write("<a target='_blank' href='"
	 * +url+"'>Execution Video</a> (This video will be available for 3 days only)");
	 * }catch(Exception e){ scenario.write("ERROR: Unable to add video link"); }
	 * failed++; }else{ passed++; if(!saveVideoForPassedScenario &&
	 * System.getenv("save.all.videos")==null){ deleteVideoFile(); } } }
	 * }catch(Exception e){ e.printStackTrace();
	 * Reporter.log("ERROR: Unable to capture video: "+e.getMessage(), true);
	 * scenario.write("ERROR: Unable to capture video"); } }
	 */

	private String getTCIDTag(String tags) {
		int i = tags.indexOf("@TC");
		int j = tags.lastIndexOf("@TC");
		Pattern p;
		Matcher m;
		if (i != j) {
			p = Pattern.compile("@TC-\\d+-.*?(\\s)|@TC-\\d+-.*");
		} else {
			p = Pattern.compile("@TC-\\d+");
		}
		m = p.matcher(tags);
		if (m.find()) {
			return m.group();
		} else {
			return null;
		}
	}

	private void logout() {
		try {
			if (isBrowserInitiailized) {
				browser.logout();
				browser.close();
				LOGGER.debug("Log out successful...", true);
			}
		} catch (Exception e) {
			LOGGER.debug("LOGOUT_FAILED::" + e.getMessage(), true);
		}
	}

	private void importUIKits(Collection<String> collection) {

		String applications = getConfiguration().getApplicationsForTag(collection);
		if (applications != null) {
			String[] allApps = applications.split(",");
			for (String application : allApps) {
				String appName = application.split(":")[0];
				String appVersion = application.split(":")[1];
				PRPCSessionUtil.addUIKitToApplication(this, appName, appVersion);
			}
		}
	}

}
