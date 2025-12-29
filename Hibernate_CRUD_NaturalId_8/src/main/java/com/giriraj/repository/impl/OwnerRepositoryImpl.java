
package com.giriraj.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.giriraj.config.HibernateUtil;
import com.giriraj.entity.Owner;
import com.giriraj.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void saveOwner(Owner owner) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(owner);
			transaction.commit();
		}
	}

	@Override
	public Owner findOwner(int ownerId) {
		try (Session session = sessionFactory.openSession()) {
			return session.find(Owner.class, ownerId);
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Owner owner = session.find(Owner.class, ownerId);
			owner.setPetName(petName);
			session.merge(owner);
			transaction.commit();
		}
	}

	@Override
	public void deleteOwner(int ownerId) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Owner owner = session.find(Owner.class, ownerId);
			session.remove(owner);
			transaction.commit();
		}
	}

	@Override
	public Owner findOwner(String emailId) {
		try (Session session = sessionFactory.openSession()) {
			return session.byNaturalId(Owner.class).using("emailId", emailId).load();
		}
	}
}
