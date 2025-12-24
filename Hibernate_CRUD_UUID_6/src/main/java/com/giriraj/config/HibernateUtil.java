package com.giriraj.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

    // Method to build and return SessionFactory
	
    public static SessionFactory getSessionFactory() 
    {
    	
        if (sessionFactory == null)
        {
            try {
                // Load hibernate.cfg.xml from resources folder
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml"); // default lookup

                sessionFactory = cfg.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error creating SessionFactory");
            }
        }
        
        return sessionFactory;
    }

	

}
