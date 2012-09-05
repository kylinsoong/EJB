package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;


@MessageDriven(name = "QueueMDBTest", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/testQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class QueueMDBTest extends MDBTestBase implements MessageListener{

	private final static Logger logger = Logger.getLogger(QueueMDBTest.class);

	public void log() {
		logger.info(QueueMDBTest.class.getSimpleName() + " start");
	}
	
	public void onMessage(Message msg) {
		log();
		handle(msg);
	}
}
