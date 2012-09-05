package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

@MessageDriven(name = "CaseTopicMDBTest", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/testTopic1"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class CaseTopicMDBTest extends MDBTestBase implements MessageListener{

	private final static Logger logger = Logger.getLogger(CaseTopicMDBTest.class);

	public void log() {
		logger.info(CaseTopicMDBTest.class.getSimpleName() + " start");
	}
	
	public void onMessage(Message msg) {
		log();
		handle(msg);
	}
}
