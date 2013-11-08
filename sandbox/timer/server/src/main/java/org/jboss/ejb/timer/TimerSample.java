package org.jboss.ejb.timer;

import javax.ejb.Remote;

@Remote
public interface TimerSample {
	void createTimer(long milliseconds); 
	void createIntervalTimer(long initialDuration, long intervalDuration);
}
