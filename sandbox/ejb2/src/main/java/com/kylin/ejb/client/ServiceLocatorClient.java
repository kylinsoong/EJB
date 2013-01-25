package com.kylin.ejb.client;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

import com.kylin.ejb.ServiceLocator;
import com.kylin.ejb.ServiceLocatorException;
import com.kylin.ejb.helloworld.HelloWorld;


public class ServiceLocatorClient {

	public static void main(String[] args) throws RemoteException, ServiceLocatorException, CreateException {
		
		HelloWorld service = ServiceLocator.getInstance().helloWorldFacade();
		System.out.println(service.helloWorld());
	}

}
