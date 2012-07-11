package com.kylin.ejb.ejbinwar.controller;

import com.kylin.ejb.ejbinwar.ejb.GreeterService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * A simple managed bean that is used to invoke the GreeterEJB and store the response. The response is obtained by
 * invoking getMessage().
 *
 * @author paul.robinson@redhat.com, 2011-12-21
 */
@Named("greeter")
@SessionScoped
public class Greeter implements Serializable {
	
	private static final Logger logger = Logger.getLogger(Greeter.class);

	private static final long serialVersionUID = 2958377177574669445L;

	/**
	 * Injected GreeterEJB client
	 */
	@EJB
	private GreeterService greeterService;

	/**
	 * Stores the response from the call to greeterEJB.sayHello(...)
	 */
	private String message;

	/**
	 * Invoke greeterEJB.sayHello(...) and store the message
     *
     * @param name The name of the person to be greeted
	 */
	public void setName(String name) {
		
		logger.info("greeter setName: " + name);
		
		message = greeterService.sayHello(name);
	}

    /**
     * Get the greeting message, customized with the name of the person to be greeted.
     *
     * @return message. The greeting message.
     */
	public String getMessage() {
		return message;
	}

}
