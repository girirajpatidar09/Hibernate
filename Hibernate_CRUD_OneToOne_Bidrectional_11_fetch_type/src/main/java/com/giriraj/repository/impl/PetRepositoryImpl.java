
package com.giriraj.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.giriraj.config.HibernateUtil;
import com.giriraj.entity.Pet;
import com.giriraj.repository.PetRepository;


public class PetRepositoryImpl implements PetRepository {
	private SessionFactory sessionFactory =HibernateUtil.getSessionFactory();

	@Override
	public Pet findPet(int petId) {
		try (Session session = sessionFactory.openSession()) {
			return session.find(Pet.class, petId);
		}
	}

}
