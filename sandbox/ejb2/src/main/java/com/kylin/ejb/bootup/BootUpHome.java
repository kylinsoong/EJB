package com.kylin.ejb.bootup;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface BootUpHome extends EJBHome {

	public BootUp create() throws CreateException, RemoteException;
}
