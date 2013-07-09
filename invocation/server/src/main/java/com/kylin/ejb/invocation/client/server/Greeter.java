package com.kylin.ejb.invocation.client.server;

import java.io.Serializable;
import java.util.Hashtable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;


@Named("greeter")
@SessionScoped
public class Greeter implements Serializable {

	private static final long serialVersionUID = 3330810482989501410L;
	
	private String message;

	public void setName(String name) {
		
		try {
			final Hashtable props = new Hashtable();
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new javax.naming.InitialContext(props);
			String jndiName = "ejb:/ejb-invocation-service/GreeterBean!" + com.kylin.ejb.invocation.service.Greeter.class.getName() ;
			com.kylin.ejb.invocation.service.Greeter greeter = (com.kylin.ejb.invocation.service.Greeter) context.lookup(jndiName);
			message = greeter.greet(name);
		} catch (Exception e) {
			message = e.getMessage();
		}
		
	}

	public String getMessage() {
		return message;
	}

}
