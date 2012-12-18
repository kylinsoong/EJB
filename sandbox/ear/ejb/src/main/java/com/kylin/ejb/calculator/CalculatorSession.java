package com.kylin.ejb.calculator;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
@Remote(CalculatorService.class)
@Local(CalculatorServiceLocal.class)
public class CalculatorSession implements CalculatorServiceLocal {
	
	private static final Logger logger = Logger.getLogger(CalculatorSession.class);

	public CalculatorSession() {
		logger.info("CalculatorSession Service constructed");
	}
	
	public int add(int a, int b) {
    	
    	logger.info("add method invoked");
    	
    	if(logger.isDebugEnabled()) {
    		logger.debug("a = " + a + ", b = " + b);
    	}
    	
        return a + b;
    }

    public int subtract(int a, int b) {
    	
    	logger.info("subtract method invoked");
    	
    	if(logger.isDebugEnabled()) {
    		logger.debug("a = " + a + ", b = " + b);
    	}
    	
        return a - b;
    }
}
