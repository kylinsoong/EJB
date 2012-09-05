package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

@MessageDriven(name = "UserQueueMDBTest", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "ddd"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class UserQueueMDBTest extends MDBTestBase implements MessageListener{

	private final static Logger logger = Logger.getLogger(UserQueueMDBTest.class);

	public void log() {
		logger.info(UserQueueMDBTest.class.getSimpleName() + " start");
	}
	
	public void onMessage(Message msg) {
		log();
		handle(msg);
	}

}
