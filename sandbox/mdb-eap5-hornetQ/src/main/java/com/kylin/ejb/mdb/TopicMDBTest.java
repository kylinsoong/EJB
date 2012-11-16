package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;


import org.apache.log4j.Logger;

@MessageDriven(name = "TopicMDBTest", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/testTopic"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class TopicMDBTest extends MDBTestBase implements MessageListener{
	
	public TopicMDBTest () {
		TopicMDBTest.logger.info("TopicMDBTest constructed");
	}

	private final static Logger logger = Logger.getLogger(TopicMDBTest.class);

	public void log() {
		logger.info(TopicMDBTest.class.getSimpleName() + " start");
	}
	
	public void onMessage(Message msg) {
		log();
		handle(msg);
	}
}
