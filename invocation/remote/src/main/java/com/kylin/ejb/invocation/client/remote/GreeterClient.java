package com.kylin.ejb.invocation.client.remote;

import com.kylin.ejb.invocation.service.Greeter;

public class GreeterClient extends ClientBase {

	public void test() throws Exception {
		String jndiName = "ejb:/ejb-invocation-service/GreeterBean!" + Greeter.class.getName() ;
		Greeter greeter = (com.kylin.ejb.invocation.service.Greeter) getContext().lookup(jndiName);
		System.out.println(greeter.greet("Tester"));
	}

	public static void main(String[] args) throws Exception {
		new GreeterClient().test();
	}

}
