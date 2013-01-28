package com.kylin.ejb.remote.stateless.classloader;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@Remote(ClassLoaderPrintService.class)
@Local(ClassLoaderPrintServiceLocal.class)
public class ClassLoaderPrintSession implements ClassLoaderPrintServiceLocal {

	public void print() {
		System.out.println("ClassLoaderPrintService Start");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println("Print Class Loader Hierarchy:");
		print(loader);
		
	}
	
	private void print(ClassLoader loader) {
		println("  " + loader);
		if(loader.getParent() != null) {
			print(loader.getParent());
		}
	}
	
	private void println(Object obj) {
		System.out.println(obj);
	}

}
