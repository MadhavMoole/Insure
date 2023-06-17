package com.insure.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class InsureAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		//We need to register the Java Based Dispatcher Servlet Class that we have defined in this web Application Context
		ac.register(InsureDispatcherServlet.class);
		
		DispatcherServlet ds = new DispatcherServlet();
		//you can either use this method or use the DispatcherServlet Class's constructor
		ds.setApplicationContext(ac);
		
		
		ServletRegistration.Dynamic s = servletContext.addServlet("main", ds);
		s.setLoadOnStartup(1);
		s.addMapping("/");
	}

}
