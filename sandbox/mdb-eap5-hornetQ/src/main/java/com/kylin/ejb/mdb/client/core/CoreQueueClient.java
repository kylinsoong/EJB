package com.kylin.ejb.mdb.client.core;

//import org.hornetq.api.core.DiscoveryGroupConfiguration;
//import org.hornetq.api.core.client.ClientMessage;
//import org.hornetq.api.core.client.ClientProducer;
//import org.hornetq.api.core.client.ClientSession;
//import org.hornetq.api.core.client.ClientSessionFactory;
//import org.hornetq.api.core.client.HornetQClient;

public class CoreQueueClient {

	public static void main(String[] args) throws Exception {

//		ClientSessionFactory factory = HornetQClient.createServerLocatorWithoutHA(new TransportConfiguration(InVMConnectorFactory.class.getName())).createSessionFactory();
	
//		DiscoveryGroupConfiguration groupConfiguration = new DiscoveryGroupConfiguration("127.0.0.1",1099);
//		ClientSessionFactory factory = HornetQClient.createServerLocatorWithoutHA(groupConfiguration).createSessionFactory();
//		
//		ClientSession session = factory.createSession();
//		String queueName = "testQueue";
//		ClientProducer producer = session.createProducer(queueName);
//		ClientMessage message = session.createMessage(false);
//        message.getBodyBuffer().writeString("Red Hat Global Support Service");
//        producer.send(message);
        
        System.out.println("Sending the message.");
	}

}
