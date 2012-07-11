package com.kylin.ejb.ejbinwar.ejb;

import javax.ejb.Stateful;

import org.apache.log4j.Logger;


@Stateful
public class GreeterService {
	
	private static final Logger logger = Logger.getLogger(GreeterService.class);
	
	/**
	 * This method takes a name and returns a personalised greeting.
	 * 
	 * @param name
	 *            the name of the person to be greeted
	 * @return the personalised greeting.
	 */
	public String sayHello(String name) {
		
		logger.info("GreeterService invoke");
		
		return "Hello " + name;
	}
}
