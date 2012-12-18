package com.kylin.ejb;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.kylin.ejb.calculator.CalculatorServiceLocal;
import com.kylin.ejb.counter.CounterServiceLocal;

public class ServiceFacade {
	
	private static ServiceFacade instance = null;
	
	public static ServiceFacade getInstance(){
		
		if(null == instance) {
			instance = new ServiceFacade();
		}
		
		return instance;
	}
	
	private Context ctx = null;
	
	public Context getContext() throws NamingException{
		
		if(null == ctx) {
			ctx = new InitialContext();
		}
		
		return ctx; 
	}
	
	private ServiceFacade() {
		
	}
	
	public CalculatorServiceLocal getLocalCacultorService() throws ServiceFacadeException  {
		try {
			return (CalculatorServiceLocal) getContext().lookup("java:app/ear-service/CalculatorSession!com.kylin.ejb.calculator.CalculatorServiceLocal");
		} catch (Exception e) {
			throw new ServiceFacadeException("JNDI Lookup Error", e);
		}
	}
	
	@EJB(lookup="java:app/ear-service/CounterSession!com.kylin.ejb.counter.CounterServiceLocal")
	private CounterServiceLocal counterService;

	public CounterServiceLocal getLocalCounterService() throws ServiceFacadeException {
		if(counterService == null) {
			throw new ServiceFacadeException("CounterServiceLocal Inject Error, counterService == " + counterService);
		}
		return counterService;
	}
	
}
