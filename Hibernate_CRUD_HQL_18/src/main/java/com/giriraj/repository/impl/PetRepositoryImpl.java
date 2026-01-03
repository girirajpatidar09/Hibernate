
package com.giriraj.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.giriraj.config.HibernateUtil;
import com.giriraj.entity.Pet;
import com.giriraj.repository.PetRepository;


public class PetRepositoryImpl implements PetRepository {
	private SessionFactory sessionFactory =HibernateUtil.getSessionFactory();

	@Override
	public Pet findPet(int petId) {
		String hql = "SELECT p FROM Pet p WHERE p.id = :petId";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Pet.class).setParameter("petId", petId).getSingleResultOrNull();
		}
	}

	@Override
	public List<Pet> findAllPets() {
		String hql = "SELECT p FROM Pet p";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Pet.class).getResultList();
		}
	}

}
