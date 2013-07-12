package com.kylin.ejb.invocation.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote (Greeter.class)
public class GreeterBean implements Greeter {

	public String greet(String user) {
		System.out.println("GreeterBean invoked");
		try {
			Thread.currentThread().sleep(5 * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return "Hello " + user + ", have a pleasant day!";
	}

}
