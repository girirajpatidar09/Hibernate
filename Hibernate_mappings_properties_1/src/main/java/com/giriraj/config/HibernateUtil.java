package com.giriraj.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	 private static SessionFactory sessionFactory;

	    static {
	        try {
	            // Load hibernate.properties automatically from classpath
	            Configuration cfg = new Configuration();

	            // Add all annotated entity classes here
	            cfg.addAnnotatedClass(com.giriraj.entity.Owner.class);
	            // cfg.addAnnotatedClass(com.giriraj.entity.Employee.class);
	            // Add more entity classes if needed

	            sessionFactory = cfg.buildSessionFactory();
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error creating SessionFactory");
	        }
	    }

	    // Getter method for SessionFactory
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	
	

	

}
