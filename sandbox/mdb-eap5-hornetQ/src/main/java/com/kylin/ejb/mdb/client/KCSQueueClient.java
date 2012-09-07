package com.kylin.ejb.mdb.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class KCSQueueClient {

	public static void main(String[] ar) throws Exception{
		
		Context context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("/ConnectionFactory");
		Queue queue = (Queue) context.lookup("/queue/testQueue");
		Connection connection = factory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(queue);
		Message textMsg = session.createTextMessage("Red Hat Global Support Service");
		producer.send(textMsg);
	}
}
