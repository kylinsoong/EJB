package com.kylin.ejb.invocation.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote (Greeter.class)
public class GreeterBean implements Greeter {

	public String greet(String user) {
		return "Hello " + user + ", have a pleasant day!";
	}

}
