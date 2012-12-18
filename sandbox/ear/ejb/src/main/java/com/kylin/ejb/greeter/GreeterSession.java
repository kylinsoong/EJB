package com.kylin.ejb.greeter;

import javax.ejb.Stateful;

import org.apache.log4j.Logger;

@Stateful
public class GreeterSession {
	
	private static final Logger logger = Logger.getLogger(GreeterSession.class);

	public GreeterSession() {
		logger.info("GreeterSession Service constructed");
	}
	
	public String sayHello(String name) {
		
		logger.info("sayHello() invoked");
		
		return "Hello " + name;
	}
}
