package com.giriraj.repository.impl;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.giriraj.config.HibernateUtil;
import com.giriraj.entity.Owner;
import com.giriraj.repository.OwnerRepository;

public class OwnerRepositoryImpl implements OwnerRepository {

	SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	
	  public OwnerRepositoryImpl()
	  {
		  
	  }
	 
	public void saveOwner(Owner owner) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(owner);
			transaction.commit();
		}
	}

	
	public Owner findOwner(UUID ownerId) {
		try(Session session = sessionFactory.openSession()) {
			return session.find(Owner.class, ownerId);
		}
	}
	
	@Override
	public void updatePetDetails(UUID ownerId, String petName) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			var owner = session.find(Owner.class, ownerId);
			owner.setPetName(petName);
			session.merge(owner);
			transaction.commit();
		}
	}

	@Override
	public void deleteOwner(UUID ownerId) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			var owner = session.find(Owner.class, ownerId);
			session.remove(owner);
			transaction.commit();
		}
	}
}
