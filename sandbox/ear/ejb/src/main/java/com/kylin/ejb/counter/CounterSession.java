package com.kylin.ejb.counter;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.apache.log4j.Logger;


@Stateful
@Remote(CounterService.class)
@Local(CounterServiceLocal.class)
public class CounterSession implements CounterServiceLocal {
	
	private static final Logger logger = Logger.getLogger(CounterSession.class);
	
	public CounterSession() {
		logger.info("CounterSession Service constructed");
	}

    private int count = 100;

    public void increment() {
    	
    	count++;
    	
    	logger.info("count increased, count = " + count);
    }

    public void decrement() {
        
    	count--;
    	
    	logger.info("count decreased, count = " + count);
    }

    public int getCount() {
        return this.count;
    }
}
