package com.pega.crm.pegamarketing.impl.elmt;

import org.openqa.selenium.*;
import org.testng.Reporter;

import com.pega.crm.pegamarketing.elmt.Connector;
import com.pega.crm.pegamarketing.elmt.OfferShape;
import com.pega.crm.pegamarketing.impl.rules.PegaOffer;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.rules.Offer.Shape;
import com.pega.crm.pegamarketing.rules.Offer.ShapeProperties;
import com.pega.crm.pegamarketing.utils.GlobalRepository;
import com.pega.framework.Mouse;
import com.pega.framework.PegaWebElement;
import com.pega.framework.PegaWebElementImpl;
import com.pega.framework.elmt.DropDown;

public class PegaOfferShape extends PegaWebElementImpl implements OfferShape {

	private static final String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public static final String VERSION = "$Id: FlowShapeImpl.java 208492 2018-09-06 14:58:05Z VenkatasrikarVadlamudi $";

	protected String shapeName;
	protected Offer offer;

	public PegaOfferShape(WebElement elmt) {
		super(elmt);
	}

	public PegaOfferShape(WebElement elmt, Offer offer, String shapeName) {
		super(elmt);
		this.shapeName = shapeName;
		this.offer = offer;
	}

	public PegaOfferShape(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}

	public Connector makeConnection(OfferShape shape, String connectorName) {
		return makeConnection(shape, connectorName, "-1");
	}

	public Connector makeConnection(OfferShape shape, String connectorName, String position) {
		boolean isFirefox = testEnv.getBrowser().isFirefox();
		this.moveMouseToThis(-10, -10);
		String connPointXpath = null;

		if (position.equals("-1")) {
			connPointXpath = "//*[name()='image' and @*[(contains(.,'connector'))]]";
		} else {
			connPointXpath = "(//*[name()='image' and @*[(contains(.,'circle'))]])[" + position + "]";
		}

		Reporter.log("ConnectionPointXPATH::" + connPointXpath, true);
		PegaWebElement connElmt = offer.findElement(By.xpath(connPointXpath));
		if (isFirefox) {
			doClickWithMouse();
			this.moveMouseToThis(-11, -11);
			pegaDriver.handleWaits().sleep(3);
		}
		connElmt.moveMouseToThis();
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(2);
		}
		Mouse mouse = testEnv.getMouse();
		mouse.pressLeftButton();
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(2);
		}
		shape.moveMouseToThis();
		mouse.releaseLeftButton();

		testEnv.getPegaDriver().waitForDocStateReady(3); // An explicit call to wait for doc state ready is needed here
															// as a virtual mouse action is being used instead of using
															// the selenium overloaded click method

		offer.findElement(TOOLBAR_PROPERTIES_BTN);
		offer.findElement(TOOLBAR_PROPERTIES_BTN).click();

		PegaWebElement moName = offer.findElement(By.xpath(Offer.MONAME_XPATH));
		scriptExecutor.sendKeys(moName, connectorName);
		offer.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
		mouse.moveTo(50, 20);
		By byShapeXpath = By.xpath("//*[*[name()='path']]/following-sibling::*[contains(@style,'visible')]//*[text()='"
				+ connectorName + "']");
		// pegaDriver.handleWaits().waitForElementPresence(byShapeXpath);
		offer.findElement(By.xpath(Offer.DIV_PROCESS_FLOW_XPATH)).click();
		WebElement connElem = offer.findElement(byShapeXpath);
		Connector connObj = new PegaConnector(connElem, offer, connectorName);
		connObj._setEnvironment(testEnv, byShapeXpath, offer.getFrameDocument(), this.getFramesSet());
		return connObj;
	}

	public Connector makeConnection(OfferShape startingShape, OfferShape destinationShape, String connectorName) {
		return makeConnection(startingShape,destinationShape, connectorName,"-1");
	}

	public void makeConnection(OfferShape startingShape, OfferShape destinationShape) {
		boolean isFirefox = testEnv.getBrowser().isFirefox();
		String position = "-1";
		String connPointXpath=null;
		String frameid = pegaDriver.getActiveFrameId(true);
		pegaDriver.switchToActiveFrame();
		if(position.equals("-1"))
		{
			connPointXpath = highlightShapeArrowsAroundTheShapeAndReturnXpath(startingShape);
		}
		else
		{
			connPointXpath="(//*[name()='image' and @*[(contains(.,'circle'))]])["+position+"]";
		}

		Reporter.log("ConnectionPointXPATH::"+connPointXpath, true);
		PegaWebElement connElmt = offer.findElement(By.xpath(connPointXpath));
		if(isFirefox){
			doClickWithMouse();
			this.moveMouseToThis(-11, -11);
			pegaDriver.handleWaits().sleep(3);
		}
		if(isFirefox){
			pegaDriver.handleWaits().sleep(2);
		}
		Mouse mouse = testEnv.getMouse();
		testEnv.getDriverActions().clickAndHold(connElmt.getWebElement()).build().perform();
		pegaDriver.handleWaits().sleep(1);
		if(isFirefox){
			pegaDriver.handleWaits().sleep(2);
		}
		testEnv.getDriverActions().moveToElement(destinationShape.getWebElement()).build().perform();
		testEnv.getDriverActions().release().build().perform();
		pegaDriver.handleWaits().sleep(1);
		testEnv.getPegaDriver().waitForDocStateReady(3);
	}
	public Connector makeConnection(OfferShape startingShape, OfferShape destinationShape, String connectorName, String position) {
		{
			boolean isFirefox = testEnv.getBrowser().isFirefox();
			String connPointXpath=null;
			String frameid = pegaDriver.getActiveFrameId(true);
			pegaDriver.switchToActiveFrame();
			if(position.equals("-1"))
			{
				connPointXpath = highlightShapeArrowsAroundTheShapeAndReturnXpath(startingShape);
			}
			else
			{
				connPointXpath="(//*[name()='image' and @*[(contains(.,'circle'))]])["+position+"]";
			}

			Reporter.log("ConnectionPointXPATH::"+connPointXpath, true);
			PegaWebElement connElmt = offer.findElement(By.xpath(connPointXpath));
			if(isFirefox){
				doClickWithMouse();
				this.moveMouseToThis(-11, -11);
				pegaDriver.handleWaits().sleep(3);
			}
			if(isFirefox){
				pegaDriver.handleWaits().sleep(2);
			}
			Mouse mouse = testEnv.getMouse();
			testEnv.getDriverActions().clickAndHold(connElmt.getWebElement()).build().perform();
			pegaDriver.handleWaits().sleep(1);
			if(isFirefox){
				pegaDriver.handleWaits().sleep(2);
			}
			testEnv.getDriverActions().moveToElement(destinationShape.getWebElement()).build().perform();
			testEnv.getDriverActions().release().build().perform();
			pegaDriver.handleWaits().sleep(1);
			testEnv.getPegaDriver().waitForDocStateReady(3);
			findElement(TOOLBAR_PROPERTIES_BTN);
			findElement(TOOLBAR_PROPERTIES_BTN).click();
			testEnv.getPegaDriver().waitForDocStateReady(3);
			PegaWebElement moName = offer.findElement(By.xpath(Offer.MONAME_XPATH));
			scriptExecutor.sendKeys(moName, connectorName);
			testEnv.getPegaDriver().waitForDocStateReady(4);
			if(connectorName.equals("Accepted")) {
				offer.findElement(By.id("DecisionConnector")).sendKeys("Accepted");
				findElement(By.xpath("//*[@data-test-id='2014100215381708848566']")).clear();
				verifyElement(By.xpath("//*[@id='container_close']"));
				for(int i=0;i<=3;i++)
				{
					try{
						findElement(By.xpath("//*[@data-test-id='2014100215381708848566']")).sendKeys("50");

						break;
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				}
			}else if(connectorName.equals("Rejected")) {
				offer.findElement(By.id("DecisionConnector")).sendKeys("Rejected");
				findElement(By.xpath("//*[@data-test-id='2014100215381708848566']")).clear();
				verifyElement(By.xpath("//*[@id='container_close']"));
				for(int i=0;i<=3;i++)
				{
					try{
						findElement(By.xpath("//*[@data-test-id='2014100215381708848566']")).sendKeys("50");
						break;
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				}
			}else if(connectorName.equals("ResponseReceived")) {
				PegaWebElement flowAction = offer.findElement(By.xpath("//*[@id='pyExpression']"));
				scriptExecutor.sendKeys(flowAction, "ResponseReceived");
			}
			pegaDriver.waitForDocStateReady();
			try {
				offer.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
				mouse.moveTo(50, 20);
			} catch (UnhandledAlertException e) {
				testEnv.getPegaDriver().switchTo().alert().accept();
				offer.findElement(By.xpath("//*[@data-test-id='2014100215381708848566']")).clear();
				offer.verifyElement(By.xpath("//*[@id='container_close']"));
				offer.findElement(By.xpath("//*[@data-test-id='2014100215381708848566']")).sendKeys("50");
				offer.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
				mouse.moveTo(50, 20);
			}
			testEnv.getPegaDriver().waitForDocStateReady(2);
			testEnv.getPegaDriver().switchToActiveFrame(offer.getDOMPointer());
			// Connector name is now divided in 2 text tags- first length is max 13 chars , hence taking substring
			if(connectorName.length()>8) {
				connectorName = connectorName.substring(0, 8);
			}
			By byShapeXpath = By.xpath("//*[contains(@id,'Transition')]//*[contains(text(),'"+connectorName+"')]");
			pegaDriver.handleWaits().waitForElementPresence(byShapeXpath);
			offer.findElement(By.xpath(Offer.DIV_PROCESS_FLOW_XPATH)).click();
			WebElement connElem = driver.findElement(byShapeXpath);
			Connector connObj = new PegaConnector(connElem, offer, connectorName);
			connObj._setEnvironment(testEnv, byShapeXpath, offer.getFrameDocument());
			return connObj;
		}
	}

	public String getName() {
		return shapeName;
	}

	public ShapeProperties openProperties() {
		doDoubleClickWithMouse(); // An explicit call to wait for doc state ready is needed here as a virtual
									// mouse action is being used instead of using the selenium overloaded click
									// method
		pegaDriver.waitForDocStateReady(3);
		return ((PegaOffer) offer).getShapeProperties();
	}

	public void setDecisionType(String decisionType) {
		DropDown decision = offer.findSelectBox(By.xpath(Offer.DECISIONTYPE_XPATH));
		decision.selectByVisibleText(decisionType, true);
	}

	public void submit() {
		offer.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click();
	}

	public String getInternalName() {
		return null;
	}

	public void delete() {
		boolean isFirefox = testEnv.getBrowser().isFirefox();
		this.moveMouseToThis(-5, -5);
		if(isFirefox){
			pegaDriver.handleWaits().sleep(3);
		}
		if(this.getName().startsWith("End")||this.getName().startsWith("end")||this.getName().equalsIgnoreCase("start"))
		{
			testEnv.getDriverActions().click(this.getWebElement());
			pegaDriver.waitForDocStateReady(2);
			testEnv.getDriverActions().sendKeys(Keys.DELETE).build().perform();
			pegaDriver.waitForDocStateReady(3);
		}
		else
		{
			String shapeXpath = "//*[@id='shapeLabel'][.//*[contains(text(),'"+this.getName()+"')]]/preceding-sibling::*[@transform]";
			Reporter.log("shapeXpath::"+shapeXpath, true);
			PegaWebElement shapeElmt = offer.findElement(By.xpath(shapeXpath));
			shapeElmt.moveMouseToThis();
			shapeElmt.doClickWithMouse();
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.handleWaits().sleep(1);
			testEnv.getDriverActions().sendKeys(Keys.DELETE).build().perform();
			pegaDriver.waitForDocStateReady(3);
			testEnv.getMouse().moveTo(10, 10);
		}
	}

	public ShapeProperties openProperties(Shape shape) {
		//opening the properties by right clicking
		pegaDriver.waitForDocStateReady();
		rightClick();
		pegaDriver.handleWaits().sleep(5);
		By byPropertiesRef = By.xpath("//span[text()='Properties']");
		pegaDriver.waitForDocStateReady();
		pegaDriver.handleWaits().waitForElementClickable(byPropertiesRef);
		pegaDriver.handleWaits().waitForElementPresence(byPropertiesRef);
		retryingFindClick(byPropertiesRef);
		pegaDriver.waitForDocStateReady(3);
		return ((PegaOffer)offer).getShapeProperties(shape);
	}

	public void retryingFindClick(By by) {
		int attempts = 0;
		while(attempts < 2) {
			try {
				driver.findElement(by).click();
				break;
			} catch(StaleElementReferenceException e) {
			}
			attempts++;
		}

	}


	public void connectupdateandendshape() {
		pegaDriver.findElement(By.xpath("//*[@width='17'][@height='17']")).mouseOver();
		PegaWebElement pointer =  pegaDriver.findElement(By.xpath("//*[@width='17'][@height='17']"));
		PegaWebElement endshape = pegaDriver.findElement(By.xpath("//*[@id='shapeLabel']//*[text()='End']"));
		pointer.dragAndDrop(endshape);

	}

	private String highlightShapeArrowsAroundTheShapeAndReturnXpath(OfferShape shape) {
		String shapeText = shape.getName();
		String xpath_connector_circle_around_shape = "";
		pegaDriver.getActiveFrameId(true);
		PegaWebElement shapeElementOnCanvasToHighlight = null;
		if(shapeText.equals("End")){
			shapeElementOnCanvasToHighlight = offer
					.findElement(By.xpath("//*[@id='End1']//*[text()='End']"));
		} else if (shapeText.equals("Update Status")) {
			shapeElementOnCanvasToHighlight = offer
					.findElement(By.xpath("//*[@id='UpdateStatus1']"));
			xpath_connector_circle_around_shape = "//*[@id='UpdateStatus1_Anchor_3']";

		} else if (shapeText.contains("Schedule Appointment")) {
			shapeElementOnCanvasToHighlight = offer.findElement(By
					.xpath("//*[@id='ScheduleAppointment1']"));
			xpath_connector_circle_around_shape = "//*[@id='ScheduleAppointment1_Anchor_6']";

		} else if (shapeText.contains("Decision")) {
			shapeElementOnCanvasToHighlight = offer
					.findElement(By.xpath("//*[@id='Decision1']"));
			xpath_connector_circle_around_shape = "//*[@id='Decision1_Anchor_2']";
		}
		else if (shapeText.contains("Send Email")) {

			shapeElementOnCanvasToHighlight = offer
					.findElement(By.xpath("//*[@id='OutboundEmailTreatmentWait1']"));
			xpath_connector_circle_around_shape = "//*[@id='OutboundEmailTreatmentWait1_Anchor_3']";

		} else if (shapeText.equals("Start")) {
			shapeElementOnCanvasToHighlight = offer.
					findElement(By.xpath("//*[@id='Start1']"));
			xpath_connector_circle_around_shape = "//*[@id='Start1_Anchor_1']";
		} else if (shapeText.equals("WaitExpired")) {
			shapeElementOnCanvasToHighlight = offer.
					findElement(By.xpath("//*[contains(@id,'UpdateStatus')]//*[contains(text(),'WaitExpired')]"));
			xpath_connector_circle_around_shape = "//*[@id='UpdateStatus1_Anchor_7']";
		} else if (shapeText.equals("Accepted")) {
			shapeElementOnCanvasToHighlight = offer.
					findElement(By.xpath("//*[contains(@id,'UpdateStatus')]//*[contains(text(),'Accepted')]"));
			xpath_connector_circle_around_shape = "//*[@id='UpdateStatus2_Anchor_3']";
		} else if (shapeText.equals("Rejected")) {
			shapeElementOnCanvasToHighlight = offer.
					findElement(By.xpath("//*[contains(@id,'UpdateStatus')]//*[contains(text(),'Rejected')]"));
			xpath_connector_circle_around_shape = "//*[@id='UpdateStatus3_Anchor_6']";
		}

		else {
			shapeElementOnCanvasToHighlight = offer
					.findElement(By.xpath("//*[@id='shapeLabel'][.//*[contains(text(),'" + shape.getName()
							+ "')]]/preceding-sibling::*[@transform]"));
		}
		PegaWebElement pmViewer = this.findElement(By.xpath("//*[@id='processFlow_g']//*[contains(@width,'%')]"));
		pegaDriver.handleWaits().sleep(2);
		testEnv.getDriverActions().clickAndHold(shapeElementOnCanvasToHighlight.getWebElement()).build().perform();
		pegaDriver.handleWaits().sleep(2);
		testEnv.getDriverActions().release().build().perform();
		return xpath_connector_circle_around_shape;
	}

}
