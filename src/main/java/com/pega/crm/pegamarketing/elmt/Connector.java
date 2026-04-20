package com.pega.crm.pegamarketing.elmt;

import com.pega.framework.PegaWebElement;

public interface Connector extends PegaWebElement {

	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: Connector.java 185921 2018-04-06 11:26:55Z ShakkariSakethkumar $";

	/**
	 * To get the name of the connector
	 * 
	 * @return the name of connector
	 */
	String getName();

	/**
	 * this method deletes the present connector
	 */
	void delete();

	interface ConnectorProperties {

	}

	/**
	 * Used to reconnect an existing connector to the specified Shape
	 * 
	 * @param label
	 *            of the connector to be reconnected
	 * @param pointer
	 *            end 1 or 2, with 1 by default, regarding which end of the pointer
	 *            to be moved
	 * @param flowShapeName
	 *            to which the connector has to be moved to
	 * @author Bala Kappeta
	 */
	void reConnect(int pointerEnd, OfferShape offerShape);

	/**
	 * this method is called on a connector to get the Connector properties
	 * 
	 * @return reference to an object of type ConnectorProperties
	 */
	ConnectorProperties getConnectorProperties();

	/**
	 * this method is called on a connector to get the Connector properties. The
	 * place where to click on the connector can be adjusted with the xEnd Param
	 * 
	 * @param xEnd
	 *            move away from the centre of the connector and click some other
	 *            place on connector. -ve value moves the mouse to left and +ve
	 *            value moves the mouse to right
	 * @return
	 */
	ConnectorProperties getConnectorProperties(int xEnd);

}
