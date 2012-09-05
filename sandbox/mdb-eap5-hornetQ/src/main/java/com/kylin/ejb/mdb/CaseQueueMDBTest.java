package com.kylin.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;


@MessageDriven(name = "CaseQueueMDBTest", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/testQueue1"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class CaseQueueMDBTest extends MDBTestBase implements MessageListener {

	private final static Logger logger = Logger.getLogger(CaseQueueMDBTest.class);

	public void log() {
		logger.info(CaseQueueMDBTest.class.getSimpleName() + " start");
	}

	public void onMessage(Message msg) {
		log();
		handle(msg);
	}
}
