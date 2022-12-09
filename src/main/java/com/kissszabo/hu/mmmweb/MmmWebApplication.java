package com.kissszabo.hu.mmmweb;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;


@SpringBootApplication
public class MmmWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmmWebApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(MmmWebApplication.class);


	@Bean
	ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {

		//spring boot only works if this is set
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

		//registration
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList("*.xhtml"));
		srb.setLoadOnStartup(1);
		return srb;
	}
}
