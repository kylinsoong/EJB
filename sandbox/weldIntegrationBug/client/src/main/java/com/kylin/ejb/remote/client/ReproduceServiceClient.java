package com.kylin.ejb.remote.client;

import com.kylin.ejb.remote.stateful.ReproduceService;

public class ReproduceServiceClient extends ClientBase {

	public void test() throws Exception {
		
		String jndiName = "ejb:/ejb-weldIntegrationBug/ReproduceSession!" + ReproduceService.class.getName() /*+ "?stateful"*/;
		
		ReproduceService client = (ReproduceService) getContext().lookup(jndiName);
		
		client.reproduction();
	}

	public static void main(String[] args) throws Exception {

		new ReproduceServiceClient().test();
	}

}
