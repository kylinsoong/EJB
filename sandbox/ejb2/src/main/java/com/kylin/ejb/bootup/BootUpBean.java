package com.kylin.ejb.bootup;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

import com.kylin.ejb.ServiceLocator;
import com.kylin.ejb.ServiceLocatorException;
import com.kylin.ejb.helloworld.HelloWorld;

public class BootUpBean implements SessionBean {

	private static final long serialVersionUID = -6637182172033586346L;

	private static final Logger logger = Logger.getLogger(BootUpBean.class);
	
	private SessionContext ctx;  
    
    public SessionContext getSessionCtx() {  
        return ctx;  
    } 

	public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {
		this.ctx = ctx ;
	}
	
	public void ejbCreate() throws EJBException, RemoteException{  
		logger.info("EJB Created");  
    }  

	public void ejbRemove() throws EJBException, RemoteException {
		logger.info("EJB Remove");
	}

	public void ejbActivate() throws EJBException, RemoteException {
		logger.info("EJB Activate");
	}

	public void ejbPassivate() throws EJBException, RemoteException {
		logger.info("EJB Passivate");
	}
	
	public void boot() throws EJBException, RemoteException{  
        
		logger.info("BootUpBean Start");
		
		try {
			HelloWorld helloworld = ServiceLocator.getInstance().helloWorldFacade();
			String str = helloworld.helloWorld();
			logger.info("HelloWorld EJB return: " + str);
		} catch (Exception e) {
			throw new RuntimeException("", e);
		}
    } 
}
