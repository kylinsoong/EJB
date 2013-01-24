package com.kylin.ejb.client;

import java.io.File;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.kylin.ejb.bootup.BootUp;
import com.kylin.ejb.bootup.BootUpHome;
import com.kylin.ejb.helloworld.HelloWorld;
import com.kylin.ejb.helloworld.HelloWorldHome;

public class EJB2Client {
	
	private static String ip = "127.0.0.1" ;
	private static String port = "1099";
	private static boolean isTestDirect = false;
	
	public static void main(String[] args) throws Exception {
		
		parser(args);
		String url = "jnp://" + ip + File.pathSeparator + port ;
		System.out.println("Connect JBoss via " + url);
		
		Properties properties = new Properties();     
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY , "org.jnp.interfaces.NamingContextFactory");  
        properties.setProperty(Context.PROVIDER_URL, url);
        
        Context ctx = new InitialContext(properties);  
        
        if(isTestDirect) {
        	helloworldClient(ctx);
        } else {
        	Object objRef = ctx.lookup("ejb/BootUp"); 
            BootUpHome home = (BootUpHome) PortableRemoteObject.narrow(objRef, BootUpHome.class);
            BootUp boot = home.create();
            boot.boot();
        }
        
        System.out.println("Success");
	}
	
	private static void helloworldClient(Context ctx) throws NamingException, RemoteException, CreateException {

		Object objRef = ctx.lookup("ejb/HelloWorld");    
        
        HelloWorldHome home = (HelloWorldHome)PortableRemoteObject.narrow(objRef, HelloWorldHome.class);  
          
        HelloWorld helloworld = home.create();  
        System.out.println(helloworld.helloWorld());
	}

	private static void parser(String[] args) {
		
		for(int i = 0 ; i < args.length ; i ++) {
			if(args[i].equals("-b")) {
				ip = args[++i] ;
				continue ;
			} else if(args[i].equals("-p")) {
				port = args[++i] ;
				continue ;
			}  else if(args[i].equals("-test")) {
				isTestDirect = true;
				continue ;
			}else {
				help();
			}
		}
	}


	private static void help() {
		System.out.println("Run testjmx parameters format: [-b <IP>] [-p <PORT>] [-test]");
		System.out.println("Default bind ip: 127.0.0.1, default port: 1099");
		System.out.println("[-test] enables HelloWorld EJB2 Demo Only");
		Runtime.getRuntime().exit(0);
	}

}
