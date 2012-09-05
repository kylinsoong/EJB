package com.kylin.ejb.mdb.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.Context;

public class TopicClient extends ClientBase{

	public static void main(String[] args) {
		
		new TopicClient().test();
	}

	public void test() {

		Message textMsg;
		Connection conn = null;
		Session session = null;
		MessageProducer producer = null;
		
		
		try {
			Context context = getContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("/ConnectionFactory");
			
			Topic topic = (Topic) context.lookup("/topic/testTopic");
			
			Connection connection = factory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			producer = session.createProducer(topic);
			
			textMsg = session.createTextMessage("tttttttttttttttt");
			producer.send(textMsg);
			
			System.out.println(TopicClient.class.getSimpleName() + " DONE");
			
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
