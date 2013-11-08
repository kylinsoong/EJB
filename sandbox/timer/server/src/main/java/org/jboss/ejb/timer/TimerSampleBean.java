package org.jboss.ejb.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;

@Stateless
public class TimerSampleBean implements TimerSample, TimerSampleLocal {
	
	@Resource
	private SessionContext ctx;

	public void createTimer(long milliseconds) {
		ctx.getTimerService().createTimer(milliseconds, "Hello World EJB Timer");
	}
	
	public void createIntervalTimer(long initialDuration, long intervalDuration) {
		ctx.getTimerService().createIntervalTimer(initialDuration, intervalDuration, new TimerConfig("Hello World EJB IntervalTimer", false));
	}

	
	@Timeout
	public void timeoutHandler(Timer timer) {
		System.out.println("---------------------");
		System.out.println("* Received Timer event: " + timer.getInfo());
		System.out.println("---------------------\n");
//		timer.cancel();
	}

	
}
