package com.kylin.ejb.remote.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.kylin.ejb.remote.stateless.CalculatorService;

public class EJBCLient {

	public static void main(String[] args) throws NamingException {
		
		final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

		final CalculatorService caculator = 
				(CalculatorService) context.lookup("ejb:/jboss-as-ejb-remote-app/CalculatorBean!" + CalculatorService.class.getName());
		
		System.out.println(caculator.add(100, 100));
	}

}
