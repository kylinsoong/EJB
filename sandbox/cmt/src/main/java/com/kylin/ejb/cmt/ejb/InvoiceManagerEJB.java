package com.kylin.ejb.cmt.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class InvoiceManagerEJB {

    @Resource(mappedName = "java:/JmsXA")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/queue/CMTQueue")
    private Queue queue;

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void createInvoice(String name) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(queue);
        connection.start();
        TextMessage message = session.createTextMessage();
        message.setText("Created invoice for customer named: " + name);
        messageProducer.send(message);
        connection.close();

    }
}
