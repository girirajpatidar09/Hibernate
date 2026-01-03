
package com.giriraj.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.giriraj.entity.DomesticPet;
import com.giriraj.entity.Owner;
import com.giriraj.entity.Pet;
import com.giriraj.entity.WildPet;


public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private HibernateUtil() {

	}

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration()
					 .addAnnotatedClass(Owner.class)
					 .addAnnotatedClass(Pet.class)
					 .addAnnotatedClass(DomesticPet.class)
					 .addAnnotatedClass(WildPet.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
