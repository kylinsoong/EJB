package com.kylin.ejb.helloworld;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

public class HelloWorldBean implements SessionBean {
	
	private static final Logger logger = Logger.getLogger(HelloWorldBean.class);

	private static final long serialVersionUID = 2563810171295660884L;
	
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
	
	public String helloWorld() throws EJBException, RemoteException{  
        return "Hello World.  Welcome to EJB 2!";  
    } 

}
