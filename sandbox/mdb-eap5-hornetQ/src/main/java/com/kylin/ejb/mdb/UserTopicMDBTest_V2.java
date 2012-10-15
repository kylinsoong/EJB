package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

@MessageDriven(name = "UserTopicMDBTest_V2", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "/topic/bbbb"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class UserTopicMDBTest_V2 extends MDBTestBase implements MessageListener{
	
	private final static Logger logger = Logger.getLogger(UserTopicMDBTest_V2.class);

	public void onMessage(Message msg) {
		log();
		handle(msg);
	}

	public void log() {
		logger.info(UserTopicMDBTest_V2.class.getSimpleName() + " start");
	}

}
