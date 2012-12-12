package com.kylin.ejb.remote.client;

import com.kylin.ejb.remote.stateful.CounterService;

public class CounterServiceClient extends ClientBase {

	public void test() throws Exception {
		
		String jndiName =  "ejb:/remote-server-1.0/CounterSession!" + CounterService.class.getName()+"?stateful";
		
		CounterService counter = (CounterService) getContext().lookup(jndiName);
		
		prompt("Original, count = " + counter.getCount());
		stop(1000L);
		
		counter.increment();
		prompt("Increase, count = " + counter.getCount());
		stop(1000L);
		
		counter.increment();
		prompt("Increase, count = " + counter.getCount());
		stop(1000L);
		
		counter.increment();
		prompt("Increase, count = " + counter.getCount());
		stop(1000L);
		
		counter.decrement();
		prompt("Decrease, count = " + counter.getCount());
		stop(1000L);
		
		counter.decrement();
		prompt("Decrease, count = " + counter.getCount());
		stop(1000L);
		
		prompt("Final, count = " + counter.getCount());
	}

	public static void main(String[] args) throws Exception {

		new CounterServiceClient().test();
	}

}
