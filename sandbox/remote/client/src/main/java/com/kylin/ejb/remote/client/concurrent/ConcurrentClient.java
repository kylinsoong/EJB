package com.kylin.ejb.remote.client.concurrent;

import com.kylin.ejb.remote.client.CalculatorServiceClient;
import com.kylin.ejb.remote.client.CounterServiceClient;
import com.kylin.ejb.remote.client.InterInvokeServiceClient;

public class ConcurrentClient {
	
	private void startThreads(int num) {
		
		for(int i = 0 ; i < num ; i ++) {
			
			new Thread(new Runnable() {

				public void run() {
					
					while(true) {
						try {
							new CounterServiceClient().test();
							Thread.currentThread().sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
			
			new Thread(new Runnable() {

				public void run() {
					
					while(true) {
						
						try {
							new CalculatorServiceClient().test();
							Thread.currentThread().sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
			
			new Thread(new Runnable() {

				public void run() {
					
					while(true) {
						
						try {
							new InterInvokeServiceClient().test();
							Thread.currentThread().sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
		}
	}

	public static void main(String[] args) {
		new ConcurrentClient().startThreads(10);
	}

}
