package com.kylin.ejb.mdb.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;

public class CaseQueueClient extends ClientBase {
	
	public static void main(String[] args) {
		new CaseQueueClient().test();
	}

	public void test() {
		
		Message textMsg;
		Connection conn = null;
		Session session = null;
		MessageProducer producer = null;
		
		
		try {
			Context context = getContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("/ConnectionFactory");
			
			Queue queue = (Queue) context.lookup("/queue/testQueue11");
			
			Connection connection = factory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			producer = session.createProducer(queue);
			
			textMsg = session.createTextMessage("Red Hat Global Support Service");
			producer.send(textMsg);
			
			System.out.println(CaseQueueClient.class.getSimpleName() + " DONE");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (producer != null) {
				try {
					producer.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			if (session != null) {
				try {
					session.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
