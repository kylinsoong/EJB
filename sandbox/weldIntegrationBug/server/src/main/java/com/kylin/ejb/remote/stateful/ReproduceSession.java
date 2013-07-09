package com.kylin.ejb.remote.stateful;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

@Stateless
@Remote(ReproduceService.class)
@Local(ReproduceServiceLocal.class)
public class ReproduceSession implements ReproduceServiceLocal {


	@Inject
	private Logger log;
	
	@Override
	public void reproduction() {
		log.info("Reproduce Stateful SessionBean");
	}
}
