package com.pega.crm.pegamarketing.impl.elmt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pega.crm.pegamarketing.elmt.Connector;
import com.pega.crm.pegamarketing.elmt.OfferShape;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.framework.Mouse;
import com.pega.framework.PegaWebElement;
import com.pega.framework.PegaWebElementImpl;

public class PegaConnector extends PegaWebElementImpl implements Connector {

	@SuppressWarnings("unused")
	private static final String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public static final String VERSION = "$Id: ConnectorImpl.java 193570 2018-05-19 06:40:26Z PavanBeri $";

	private String connName;
	private PegaConnectorProperties connProp;
	private Offer offer;

	public PegaConnector(WebElement elmt) {
		super(elmt);
	}

	public PegaConnector(WebElement elmt, Offer offer, String connName) {
		super(elmt);
		this.connName = connName;
		this.offer = offer;
	}

	public PegaConnector(WebElement elmt, Offer flow) {
		super(elmt);
		this.offer = flow;
	}

	public PegaConnector(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}

	public String getName() {
		return connName;
	}

	public void delete() {
		pegaDriver.waitForDocStateReady();
		System.out.println("Height of the element is : "+this.getRect().getDimension().getHeight());
		System.out.println("Width of the element is : "+this.getRect().getDimension().getWidth());
		testEnv.getDriverActions().click(this.getWebElement());
		testEnv.getDriverActions().sendKeys(Keys.DELETE).build().perform();
	}

	private class PegaConnectorProperties implements ConnectorProperties {

	}

	public void reConnect(int pointerEnd, OfferShape offerShape) {
		boolean isFirefox = testEnv.getBrowser().isFirefox();
		new Actions((testEnv.getPegaDriver().getDriver())).click(this.getWebElement()).build().perform();
		this.moveMouseToThis();
		this.click();
		// this.doClickWithMouse();
		pointerEnd = ((pointerEnd == 1) || (pointerEnd == 2)) ? pointerEnd : 1;

		PegaWebElement connectorPointer = offer.findElement(By.xpath(
				"(//*[name()='g' and contains(@style,'cursor: pointer')]/*[@pointer-events])[" + pointerEnd + "]"));
		String a = connectorPointer.getAttribute("class");
		System.out.println("Value of calss is : " + a);
		connectorPointer.moveMouseToThis();
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(2);
		}
		Mouse mouse = testEnv.getMouse();
		mouse.pressLeftButton();
		pegaDriver.handleWaits().sleep(2);
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(3);
		}
		offerShape.moveMouseToThis();
		pegaDriver.handleWaits().sleep(2);
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(3);
		}
		mouse.releaseLeftButton();
		mouse.moveTo(50, 20);
		testEnv.getPegaDriver().handleWaits().sleep(1);
		testEnv.getPegaDriver().waitForDocStateReady();
	}

	public ConnectorProperties getConnectorProperties() {
		doubleClick();
		connProp = new PegaConnectorProperties();
		return connProp;
	}

	public ConnectorProperties getConnectorProperties(int xEnd) {

		this.moveMouseToThis(xEnd, 0);

		testEnv.getMouse().doubleClick();
		connProp = new PegaConnectorProperties();

		return connProp;
	}
}
