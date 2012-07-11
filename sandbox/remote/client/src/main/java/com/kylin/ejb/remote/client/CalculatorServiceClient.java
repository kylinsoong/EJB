package com.kylin.ejb.remote.client;


import com.kylin.ejb.remote.stateless.CalculatorService;

public class CalculatorServiceClient extends ClientBase{

	public void test() throws Exception {
		
		String jndiName = "ejb:/remote-server-1.0/CalculatorSession!" + CalculatorService.class.getName() ;
		
		CalculatorService caculator = (CalculatorService) getContext().lookup(jndiName);
		
		int a = 2 , b = 1 ;
		
		prompt(a + " + " + b +" = " + caculator.add(a, b));
		stop(1000L);
		prompt(a + " - " + b +" = " +caculator.subtract(a, b));
		
	}

	public static void main(String[] args) throws Exception {
		new CalculatorServiceClient().test();
	}
	
}
