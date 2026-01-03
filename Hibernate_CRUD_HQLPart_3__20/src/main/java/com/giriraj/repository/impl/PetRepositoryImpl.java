
package com.giriraj.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.giriraj.config.HibernateUtil;
import com.giriraj.repository.PetRepository;


public class PetRepositoryImpl implements PetRepository {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Double findAverageAgeOfPet() {
		String hql = "SELECT AVG(YEAR(CURRENT_DATE()) - YEAR(p.birthDate)) FROM Pet p";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Double.class).getSingleResultOrNull();
		}
	}

}
