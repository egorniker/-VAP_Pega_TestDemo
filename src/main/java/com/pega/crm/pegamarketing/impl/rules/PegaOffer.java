package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ImageCatalogDialog;
import com.pega.crm.pegamarketing.elmt.Connector;
import com.pega.crm.pegamarketing.elmt.OfferShape;
import com.pega.crm.pegamarketing.impl.dialog.PegaImageCatalogDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.impl.elmt.PegaConnector;
import com.pega.crm.pegamarketing.impl.elmt.PegaOfferShape;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.utils.GlobalRepository;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaOffer extends PegaRuleInstance implements Offer {

	public static final By START_CONNECTOR = By.xpath("//*[@id='Transition1']//*[@marker-end]");

	public PegaOffer(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	protected String shapeName1;
	protected String shapeName2;

	public OfferShape dragShape(Shape shape) {
		return dragShape(shape, null, 0, 0);
	}

	public OfferShape dragShape(Shape shape, int xEnd, int yEnd) {
		return dragShape(shape, null, xEnd, yEnd);
	}

	public OfferShape dragShape(Shape shape, String shapeName) {
		return dragShape(shape, shapeName, 0, 0);
	}

	public void switchTab(String tabName) {
		String elmtXpath = "//*[contains(@aria-label,'" + tabName + "')]//*[contains(text(),'" + tabName + "')]";
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(elmtXpath));
		findElement(By.xpath(elmtXpath)).scrollIntoView();
		pegaDriver.handleWaits().sleep(2);
		findElement(By.xpath(elmtXpath)).click();
	}

	public OfferShape dragShape(Shape shape, String shapeName, int xEnd, int yEnd) {
		String shapeText = shape.getName();
		Reporter.log("Shape you are dragging: " + shapeText, true);
		pegaDriver.waitForDocStateReady(3);
		testEnv.getMouse().moveTo(1000, 800);
		this.findElement(By.xpath("//*[@title='Action Flow Shapes']")).click();
		String tempStrToStoreUpdateStatusValue = shapeText;
		if(shapeText.contains("Second Update") || shapeText.contains("Third Update")){
			shapeText = "Update Status";
		}
		shapeText = handleSmartAndAdvancedShapes(shapeText);
		PegaWebElement shapeElement = this
				.findElement(By.xpath("//span[@class='menu-item-title' and text()='" + shapeText + "']"));
		// pmViewer is white board of canvas where shapes are present.
		PegaWebElement pmViewer = this.findElement(By.xpath("//*[@id='processFlow_g']//*[contains(@width,'%')]"));
		shapeText = tempStrToStoreUpdateStatusValue;
		String OperatingSystemForTestRun = System.getProperty("os.name");
		// Use below code when you are running tests on windows platform
		if(OperatingSystemForTestRun.contains("Window")) {
			shapeElement.click();
			PegaWebElement shapeElementOnCanvas;
			shapeElementOnCanvas = getShapeElementOnCanvas(shape, shapeText);
			testEnv.getDriverActions().clickAndHold(shapeElementOnCanvas.getWebElement()).build().perform();
			pegaDriver.handleWaits().sleep(4);

			testEnv.getDriverActions().moveToElement(pmViewer.getWebElement(), xEnd, yEnd).build().perform();
			pegaDriver.handleWaits().sleep(2);
			testEnv.getDriverActions().release().build().perform();
		} else {
			shapeElement.dragAndDrop(pmViewer, xEnd, yEnd);
		}
		By byShapeXpath = null;

		if (shapeName != null) {
			String draggedShapeLocator = null;
			String defaultShapeName = shapeText;
			String renamedshapeElementLocator = null;
			String renamedShapeName = shapeName;

			if (shapeText.equals("End")) {
				draggedShapeLocator = "//*[@id='End1']//*[text()='End']";
			}
			if (null == draggedShapeLocator) {
				draggedShapeLocator = "//*[@id='shapeLabel'][.//*[contains(text(),'" + defaultShapeName
						+ "')]]/preceding-sibling::*[@transform]";
			}

			if (null == renamedshapeElementLocator) {
				renamedshapeElementLocator = "//*[@id='shapeLabel'][.//*[contains(text(),'" + renamedShapeName
						+ "')]]/preceding-sibling::*[@transform]";
			}
			PegaWebElement shapeTextElmt = null;

			shapeTextElmt = this.findElement(By.xpath(draggedShapeLocator));
			pegaDriver.waitForDocStateReady(3);
			pegaDriver.waitForDocStateReady(1);
			this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
			byShapeXpath = By.xpath(renamedshapeElementLocator);
		} else if (shapeText.contains("Update Status")) {
			String getUpdateStatusXpath = getUpdateShapeXpath(shapeText);
			byShapeXpath = By.xpath(getUpdateStatusXpath);

		} else if (shapeText.equals("End")) {
			byShapeXpath = By.xpath("//*[@id='End1']//*[text()='End']");
		} else if (shapeText.contains("Schedule Appointment")) {
			byShapeXpath = By
					.xpath("//*[@id='ScheduleAppointment1']");
		} else if (shapeText.contains("Decision")) {
			byShapeXpath = By
					.xpath("//*[@id='Decision1']");
		}
		else if (shapeText.contains("Send Email")) {
			byShapeXpath = By
					.xpath("//*[@id='OutboundEmailTreatmentWait1']");
		}
		else if (shapeText.contains("Send SMS")) {
			byShapeXpath = By
					.xpath("//*[@id='OutboundSMSTreatmentWait1']");
		}

		else {
			byShapeXpath = By.xpath("//*[@id='shapeLabel'][.//*[contains(text(),'" + shape.getName()
					+ "')]]/preceding-sibling::*[@transform]");
		}
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
		return flowShapeObj;
	}

	public String getUpdateShapeXpath(String updateShapeName){
		String idNumber;
		if(updateShapeName.contains("Second")){
			idNumber = "2";
		} else if(updateShapeName.contains("Third")){
			idNumber = "3";
		} else {
			idNumber = "1";
		}
		updateShapeName = "//*[@id='UpdateStatus" + idNumber + "']";
		return updateShapeName;
	}

	private PegaWebElement getShapeElementOnCanvas(Shape shape, String shapeText) {
		PegaWebElement shapeElementOnCanvas;
		if(shapeText.equals("End")){
			shapeElementOnCanvas = this
					.findElement(By.xpath("//*[@id='End1']//*[text()='End']"));
		} else if (shapeText.contains("Update Status")) {
			String updateShapeXpath = getUpdateShapeXpath(shapeText);
			shapeElementOnCanvas = this
					.findElement(By.xpath(updateShapeXpath));

		} else if (shapeText.contains("Schedule Appointment")) {
			shapeElementOnCanvas = this.findElement(By
					.xpath("//*[@id='ScheduleAppointment1']"));
		} else if (shapeText.contains("Decision")) {
			shapeElementOnCanvas = this
					.findElement(By.xpath("//*[@id='Decision1']"));
		}
		else if (shapeText.contains("Send Email")) {
			shapeElementOnCanvas = this
					.findElement(By.xpath("//*[@id='OutboundEmailTreatmentWait1']"));
		}
		else if (shapeText.contains("Send SMS")) {
			shapeElementOnCanvas = this
					.findElement(By.xpath("//*[@id='OutboundSMSTreatmentWait1']"));
		}

		else {
			shapeElementOnCanvas = this
					.findElement(By.xpath("//*[@id='shapeLabel'][.//*[contains(text(),'" + shape.getName()
							+ "')]]/preceding-sibling::*[@transform]"));
		}
		return shapeElementOnCanvas;
	}

	public String getPalleteID() {
		return "pmviewer_graph";
	}

	protected String handleSmartAndAdvancedShapes(String shapeText) {
		if (shapeText.startsWith("Smart Shapes:")) {
			PegaWebElement smartShapes = this
					.findElement(By.xpath("//*[@class='menu-item-title' and contains(text(),'Smart Shapes')]"));
			scriptExecutor.mouseOver(smartShapes);
			pegaDriver.handleWaits().sleep(1);
		} else if (shapeText.startsWith("Advanced:")) {
			PegaWebElement advancedShapes = this
					.findElement(By.xpath("//*[@class='menu-item-title' and contains(text(),'Advanced Shapes')]"));
			scriptExecutor.mouseOver(advancedShapes);
		} else {
			PegaWebElement smartShapes = this.findElement(
					By.xpath("//*[@class='menu-item-title' and contains(text(),'" + shapeText.split(":")[0] + "')]"));
			scriptExecutor.mouseOver(smartShapes);
		}
		shapeText = shapeText.substring(shapeText.indexOf(":") + 1);
		return shapeText;
	}

	public OfferShape findShape(String shapeName) {
		By byShapeXpath = null;

		if (shapeName.equalsIgnoreCase("Send Email")) {
			byShapeXpath = By.xpath("//*[@id='OutboundEmailTreatmentWait1']");

			testEnv.getPegaDriver().waitForDocStateReady(2);
			WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
			OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
			flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
			return flowShapeObj;
		} else if (shapeName.equalsIgnoreCase("Decision")) {
			byShapeXpath = By.xpath("//*[@id='Decision1']");
			testEnv.getPegaDriver().waitForDocStateReady(2);
			WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
			OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
			flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
			return flowShapeObj;
		} else if (shapeName.equalsIgnoreCase("Send SMS")) {
			byShapeXpath = By.xpath("//*[@id='OutboundSMSTreatmentWait1']");

			testEnv.getPegaDriver().waitForDocStateReady(2);
			WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
			OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
			flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
			return flowShapeObj;
		} else if (shapeName.contains("Schedule Appointment")) {
			byShapeXpath = By.xpath("//*[@id='ScheduleAppointment1']");

			testEnv.getPegaDriver().waitForDocStateReady(2);
			WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
			OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
			flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
			return flowShapeObj;
		} else if (shapeName.contains("Start")) {
			byShapeXpath = By.xpath("//*[@id='Start1']");

			testEnv.getPegaDriver().waitForDocStateReady(2);
			WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
			OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
			flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
			return flowShapeObj;
		} else if (shapeName.contains("End")) {
			byShapeXpath = By.xpath("//*[@id='End1']");

			testEnv.getPegaDriver().waitForDocStateReady(2);
			WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
			OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
			flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
			return flowShapeObj;
		}


		else {
			byShapeXpath = By.xpath(
					"//*[@id='shapeLabel'][.//*[contains(text(),'" + shapeName + "')]]/preceding-sibling::*[@style]");

			testEnv.getPegaDriver().waitForDocStateReady(2);
			WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
			OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
			flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument());
			return flowShapeObj;
		}
	}

	public OfferShape findStartShape() {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='Start']");
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, "Start");
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public OfferShape findEndShape() {
		By byShapeXpath = By.xpath("//*[@id='End1']//*[text()='End']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, "End");
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public OfferShape findEndShape(String label) {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='" + label + "']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, "End");
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public void setEndShapeName(String shapeName) {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='End']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		PegaWebElement shapeElmt = findElement(byShapeXpath);
		shapeElmt.doDoubleClickWithMouse();
		PegaWebElement moName = this.findElement(By.xpath(MONAME_XPATH));
		scriptExecutor.sendKeys(moName, shapeName);
		this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
	}

	public void renameEndShape(String oldName, String newName) {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='" + oldName + "']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		PegaWebElement shapeElmt = findElement(byShapeXpath);
		shapeElmt.doDoubleClickWithMouse();
		PegaWebElement moName = this.findElement(By.xpath(MONAME_XPATH));
		scriptExecutor.sendKeys(moName, newName);
		this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);

	}

	public void setConnectorName(By by, String connectorName) {
		testEnv.getPegaDriver().waitForDocStateReady(4);
		PegaWebElement connectorElmt = this.findElement(by);
		connectorElmt.doDoubleClickWithMouse();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement moName = this.findElement(By.xpath(Offer.MONAME_XPATH));
		scriptExecutor.clear(moName);
		moName.sendKeys(connectorName);
		this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
		pegaDriver.handleWaits().waitForNoThrobber();
	}

	public void setStartConnName(String startConnName) {
		setConnectorName(By.xpath("//*[contains(@style,'visible')]/*[@d][2]"), startConnName);
		if (testEnv.getBrowser().isFirefox()) {
			save();
		}
	}

	public Connector findConnector(String connName) {
		By byShapeXpath = By
				.xpath("//*[name()='path']/../following-sibling::*[name()='g']//*[text()='" + connName + "']");
		WebElement connElem = findElement(byShapeXpath).getWebElement();
		Connector connObj = new PegaConnector(connElem, this, connName);
		connObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return connObj;
	}

	public Connector findConnector(By byShapeXpath) {
		WebElement connElem = findElement(byShapeXpath).getWebElement();
		pegaDriver.handleWaits().sleep(5);
		Connector connObj = new PegaConnector(connElem, this);
		connObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return connObj;
	}

	protected class PegaShapeProperties extends PegaModalDialog implements ShapeProperties {
		public PegaShapeProperties(Frame frame) {
			super(frame);
		}


		public void specifyTreatment() {
			findElement(SPECIFY_TREATMENT_RADIO).check();
			pegaDriver.handleWaits().sleep(10);
		}


		public void setTreatmentName(String treatmentName) {
			findElement(SPECIFY_TREATMENT_OPTION).click();
			pegaDriver.waitForDocStateReady();
			PegaWebElement treatmentNameElmt = findElement(SendEmailShapeProperties.TREATMENT_NAME);
			treatmentNameElmt.clear();
			treatmentNameElmt.sendKeys(treatmentName + Keys.TAB);
		}

		public void setShapeName(String shapeName) {
			PegaWebElement moName = findElement(By.xpath(MONAME_XPATH));
			scriptExecutor.sendKeys(moName, shapeName);
			pegaDriver.waitForDocStateReady(1);
		}
	}


		public class PegaSendEmailShapeProperties extends PegaShapeProperties implements SendEmailShapeProperties {
			public PegaSendEmailShapeProperties(Frame frame) {
				super(frame);
			}

			public void setEmailAccount(String emailAccount) {
				if (verifyElement(ICON_EXPAND_EMAIL_ACCOUNT)) {
					findElement(ICON_EXPAND_EMAIL_ACCOUNT).click();
				}
				PegaWebElement specifyEmailAccountElmt = findElement(SendEmailShapeProperties.SPECIFY_EMAIL_ACCOUNT_RD_BTN);
				specifyEmailAccountElmt.click();

				PegaWebElement emailAccountElmt = findElement(SendEmailShapeProperties.EMAIL_ACCOUNT_INPUT);
				emailAccountElmt.clear();
				emailAccountElmt.sendKeys(emailAccount + Keys.TAB);
			}
		}

		public class PegaSendSMSShapeProperties extends PegaShapeProperties implements SendSMSShapeProperties {
			public PegaSendSMSShapeProperties(Frame frame) {
				super(frame);
			}

			@Override
			public void setSMSAccount(String smsAccount) {
				if (verifyElement(ICON_EXPAND_SMS_ACCOUNT)) {
					findElement(ICON_EXPAND_SMS_ACCOUNT).click();
				}
				PegaWebElement specifyEmailAccountElmt = findElement(SendSMSShapeProperties.SPECIFY_SMS_ACCOUNT_RD_BTN);
				specifyEmailAccountElmt.click();

				PegaWebElement smsAccountElmt = findElement(SendSMSShapeProperties.SMS_ACCOUNT_INPUT);
				smsAccountElmt.clear();
				smsAccountElmt.sendKeys(smsAccount + Keys.TAB);
			}
		}

		public ShapeProperties getShapeProperties() {
			ShapeProperties props = new PegaShapeProperties(this);
			return props;

		}

		public ShapeProperties getShapeProperties(Shape shape) {
			ShapeProperties props = null;
			switch (shape) {
				case SEND_EMAIL:
					props = new PegaSendEmailShapeProperties(this);
					break;
				case SEND_SMS:
					props = new PegaSendSMSShapeProperties(this);
					break;
				default:
					props = new PegaShapeProperties(this);
					break;
			}
			return props;
		}


		public void setSeedList(String seedlist) {
			findElement(SEED_LIST).clear();
			findElement(SEED_LIST).sendKeys(seedlist);
		}


		public void selectStartingPoint(String startingPoint) {
			findSelectBox(STARTING_POINT).selectByVisibleText(startingPoint);
		}


		public void selectChannel(String channel) {
			findSelectBox(CHANNEL).selectByVisibleText(channel);
		}


		public void setDirection(String direction) {
			if (direction.trim().equalsIgnoreCase("outbound")) {
				findElement(DIRECTION_OUTBOUND).click();
			} else if (direction.trim().equalsIgnoreCase("inbound")) {
				findElement(DIRECTION_INBOUND).click();
			}

		}


		public void refreshTrackResults() {
			findElement(REFRESH_TRACK_RESULTS).click();
		}


		public void testOffer() {
			findElement(TEST_OFFER).click();
		}


		public void clickDetails() {
			findElement(DETAILS_TAB).click();
			// pegaDriver.waitForDocStateReady();

		}


		public ImageCatalogDialog clickImageURLCog() {
			findElement(IMAGE_URL_COG).click();
			ImageCatalogDialog imageCatalogDialog = new PegaImageCatalogDialog(this, testEnv);
			return imageCatalogDialog;

		}


		public void DeleteMenuClick() {
			findElement(DELETE_MENU).click();

		}


}
