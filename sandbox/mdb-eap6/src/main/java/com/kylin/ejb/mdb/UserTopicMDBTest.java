package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

@MessageDriven(name = "UserTopicMDBTest", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "bbb"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class UserTopicMDBTest extends MDBTestBase implements MessageListener{

	private final static Logger logger = Logger.getLogger(UserTopicMDBTest.class);

	public void log() {
		logger.info(UserTopicMDBTest.class.getSimpleName() + " start");
	}
	
	public void onMessage(Message msg) {
		log();
		handle(msg);
	}
}
