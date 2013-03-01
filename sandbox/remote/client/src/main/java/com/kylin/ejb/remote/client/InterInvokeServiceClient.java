package com.kylin.ejb.remote.client;

import com.kylin.ejb.interInvoke.InterInvokeService;


public class InterInvokeServiceClient extends ClientBase {

	public void test() throws Exception {

		String jndiName = "ejb:/ejb-remote-server/InterInvokeSession!" + InterInvokeService.class.getName() ;
		InterInvokeService interInvokeService = (InterInvokeService) getContext().lookup(jndiName);
		prompt("Invoke Remote Internal Invoke Service");
		interInvokeService.invoke();
		prompt("DONE");
	}

	public static void main(String[] args) throws Exception {
		new InterInvokeServiceClient().test();
	}

}
