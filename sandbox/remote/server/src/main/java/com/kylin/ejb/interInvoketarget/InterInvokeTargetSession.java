package com.kylin.ejb.interInvoketarget;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
@LocalBean
public class InterInvokeTargetSession  {
	
	private static final Logger logger = Logger.getLogger(InterInvokeTargetSession.class);

	public void prompt() {
		logger.info("Internal Invoke Stateless Local Service prompt() method invoked");
	}
}
