package com.kylin.ejb.helloworld;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface HelloWorld extends EJBObject {

	public String helloWorld() throws RemoteException; 
}
