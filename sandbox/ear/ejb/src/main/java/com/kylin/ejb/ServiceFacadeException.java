package com.kylin.ejb;

public class ServiceFacadeException extends Exception {

	private static final long serialVersionUID = 1781139558746698519L;
	
	public ServiceFacadeException(String msg, Throwable t) {
		super(msg, t);
	}

	public ServiceFacadeException(String msg) {
		super(msg);
	}

}
