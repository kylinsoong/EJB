package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;


@MessageDriven(name = "CaseQueueMDBTest", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/testQueue1"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class CaseQueueMDBTest implements MessageListener {

	private final static Logger logger = Logger.getLogger(CaseQueueMDBTest.class);

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message rcvMessage) {
		
		logger.info("on message start...");
		
		TextMessage msg = null;
		try {
			if (rcvMessage instanceof TextMessage) {
				msg = (TextMessage) rcvMessage;
				logger.info("Received Message: " + msg.getText());
			} else {
				logger.warn("Message of wrong type: " + rcvMessage.getClass().getName());
			}
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
