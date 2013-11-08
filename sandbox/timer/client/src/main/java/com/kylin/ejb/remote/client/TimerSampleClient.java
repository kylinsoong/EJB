package com.kylin.ejb.remote.client;

import org.jboss.ejb.timer.TimerSample;

public class TimerSampleClient extends ClientBase {

	public void test() throws Exception {
						
		TimerSample timer =  (TimerSample) getContext().lookup("ejb:/ejb-timer-server/TimerSampleBean!" + TimerSample.class.getName());
		timer.createTimer(2000);
		
		TimerSample timer1 =  (TimerSample) getContext().lookup("ejb:/ejb-timer-server/TimerSampleBean1!" + TimerSample.class.getName());
		timer1.createTimer(2000);
		
		TimerSample timer2 =  (TimerSample) getContext().lookup("ejb:/ejb-timer-server/TimerSampleBean2!" + TimerSample.class.getName());
		timer2.createTimer(2000);
		
		System.out.println("DONE");
	}

	public static void main(String[] args) throws Exception {

		new TimerSampleClient().test();
	}

}
