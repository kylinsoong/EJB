package com.kylin.ejb;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.apache.log4j.Logger;

import com.kylin.ejb.helloworld.HelloWorld;
import com.kylin.ejb.helloworld.HelloWorldHome;

public class ServiceLocator {
	
	private static final Logger logger = Logger.getLogger(ServiceLocator.class);

	private InitialContext ctx;
    private Map cache;
    private static ServiceLocator me;
    
    private HelloWorld helloWorldFacade ;
    
    public HelloWorld helloWorldFacade() throws ServiceLocatorException, RemoteException, CreateException {
    	
    	if(null == helloWorldFacade) {
    		ServiceLocator locator = ServiceLocator.getInstance();
    		HelloWorldHome home = (HelloWorldHome) locator.getRemoteHome("ejb/HelloWorld", HelloWorldHome.class);
    		helloWorldFacade = home.create();
    	}
    	
    	return helloWorldFacade ;
    }
    
	private ServiceLocator() throws ServiceLocatorException {
		try {
			ctx = new InitialContext();
			cache = Collections.synchronizedMap(new HashMap());
		} catch (NamingException ne) {
			throw new ServiceLocatorException(ne);
		} catch (Exception e) {
			throw new ServiceLocatorException(e);
		}
    }
	
	public static ServiceLocator getInstance() throws ServiceLocatorException {
		if (me == null)
			me = new ServiceLocator();
		return me;
	}
	
	public EJBHome getRemoteHome(String jndiHomeName, Class className) throws ServiceLocatorException {
        
		EJBHome home = null;
        logger.info("try to get jndiHomeName of " + jndiHomeName);
		try {
			if (cache.containsKey(jndiHomeName)) {
				home = (EJBHome) cache.get(jndiHomeName);
				logger.info("got jndiHomeName from catch ");
			} else {
        		logger.info("got jndiHomeName from PortableRemoteObject.narrow ");
                Object objref = ctx.lookup(jndiHomeName);
                Object obj = PortableRemoteObject.narrow(objref, className);
                home = (EJBHome)obj;
                cache.put(jndiHomeName, home);
			}
		} catch (NamingException ne) {
			throw new ServiceLocatorException(ne);
		} catch (Exception e) {
			throw new ServiceLocatorException(e);
		}
		return home;
	}
    
}
