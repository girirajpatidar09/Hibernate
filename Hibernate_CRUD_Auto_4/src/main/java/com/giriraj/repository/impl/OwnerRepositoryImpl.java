package com.giriraj.repository.impl;

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
			System.out.println("Before persist :"+owner.getId());
			session.persist(owner);
			System.out.println("After persist :"+owner.getId());

			transaction.commit();
			System.out.println("After commiting :"+owner.getId());

		}
		
	}

	
	public Owner findOwner(int ownerId) {
		try(Session session = sessionFactory.openSession()) {
			return session.find(Owner.class, ownerId);
		}
	}
	
	@Override
	public void updatePetDetails(int ownerId, String petName) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			var owner = session.find(Owner.class, ownerId);
			owner.setPetName(petName);
			session.merge(owner);
			transaction.commit();
		}
	}

	@Override
	public void deleteOwner(int ownerId) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			var owner = session.find(Owner.class, ownerId);
			session.remove(owner);
			transaction.commit();
		}
	}
}
