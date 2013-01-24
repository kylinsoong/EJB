package com.kylin.ejb.bootup;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface BootUp extends EJBObject {

	public void boot() throws RemoteException;
}
