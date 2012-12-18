package com.kylin.ejb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kylin.ejb.ServiceFacade;
import com.kylin.ejb.ServiceFacadeException;


@WebServlet("/FacadeService")
public class ServiceServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(ServiceServlet.class);

	private static final long serialVersionUID = 8182131264740127488L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("ServiceServlet doGet()");
		
		try {
			logger.info("10 + 20 = " + ServiceFacade.getInstance().getLocalCacultorService().add(10, 20));
	
			logger.info("count = " + ServiceFacade.getInstance().getLocalCounterService().getCount());
			
		}  catch (ServiceFacadeException e) {
			logger.error("Service Invoke Error", e);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
