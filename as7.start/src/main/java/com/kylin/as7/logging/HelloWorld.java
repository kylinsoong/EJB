package com.kylin.as7.logging;

import org.jboss.logging.Logger;

public class HelloWorld {

	public static void main(String[] args) {

		new HelloWorld().test();
	}
	
	private static final Logger logger = Logger.getLogger(HelloWorld.class);

	private void test() {
		
		logger.fatal("fatal");
		
		logger.error("error");
		
		logger.info("Test");
		
		logger.debug("debug");
		
		logger.trace("trace");
	}

}
