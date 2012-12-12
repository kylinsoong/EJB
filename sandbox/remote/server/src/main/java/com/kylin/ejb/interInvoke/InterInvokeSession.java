package com.kylin.ejb.interInvoke;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.kylin.ejb.remote.stateful.CounterServiceLocal;
import com.kylin.ejb.remote.stateless.CalculatorServiceLocal;



@Stateless
@Remote(InterInvokeService.class)
@Local(InterInvokeServiceLocal.class)
public class InterInvokeSession implements InterInvokeServiceLocal {
	
	private static final Logger logger = Logger.getLogger(InterInvokeSession.class);
	
	@EJB(lookup="java:app/remote-server-1.0/CounterSession!com.kylin.ejb.remote.stateful.CounterServiceLocal")
	private CounterServiceLocal counterService;

	/**
	 * invoke internal stateless session bean
	 */
	public void invoke() {
		
		logger.info("Internal Invoke Stateless Local Service");
		
		try {
			Context ctx = new InitialContext();
			CalculatorServiceLocal caculator = (CalculatorServiceLocal) ctx.lookup("java:app/remote-server-1.0/CalculatorSession!com.kylin.ejb.remote.stateless.CalculatorServiceLocal");
			logger.info("10 + 20 = " + caculator.add(10, 20));
			
			if(counterService != null) {
				logger.info("count = " + counterService.getCount());
			}
			
			InterInvokeTargetSession interInvokeTargetSession = (InterInvokeTargetSession) ctx.lookup("java:app/remote-server-1.0/InterInvokeTargetSession!com.kylin.ejb.interInvoke.InterInvokeTargetSession");
			interInvokeTargetSession.prompt();
			logger.info("interInvokeTargetSession prompt() method invoked");
			
		} catch (NamingException e) {
			throw new RuntimeException("Invoke process error", e);
		}
	}

}
