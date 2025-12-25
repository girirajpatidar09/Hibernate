package com.giriraj.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.giriraj.config.HibernateUtil;
import com.giriraj.entity.Owner;
import com.giriraj.entity.OwnerPetPrimaryKey;
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

	
	public Owner findOwner(OwnerPetPrimaryKey primaryKey) {
		try(Session session = sessionFactory.openSession()) {
			return session.find(Owner.class, primaryKey);
		}
	}
	
	@Override
	public void updatePetDetails(OwnerPetPrimaryKey primaryKey, String petName) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			var owner = session.find(Owner.class, primaryKey);
			owner.setPetName(petName);
			session.merge(owner);
			transaction.commit();
		}
	}

	@Override
	public void deleteOwner(OwnerPetPrimaryKey primaryKey) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			var owner = session.find(Owner.class, primaryKey);
			session.remove(owner);
			transaction.commit();
		}
	}
}
