package com.kylin.ejb.mdb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public abstract class ClientBase {

	public Context getContext() {

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		props.setProperty("java.naming.provider.url", "remote://localhost:4447");
		props.setProperty(Context.SECURITY_PRINCIPAL, "admin");
		props.setProperty(Context.SECURITY_CREDENTIALS, "redhat");

		Context ctx = null;

		try {
			ctx = new InitialContext(props);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Create JNDI Local Context Error");
		}

		return ctx;
	}
	
	public abstract void  test();
}
