package com.giriraj;

import org.hibernate.SessionFactory;

import com.giriraj.config.HibernateUtil;

public class Demo
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Construction........" );
      SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
         System.out.println(sessionFactory);
         
      // session =sessionFactory.openSession();
          //Owner o1 = new Owner();
          //o1.setName("ram");
          
//          Owner o2 = new Owner();
//          o2.setName("sita");
          
//          Owner o3 = new Owner();
//          o3.setName("gita");
//          
//          
//             Transaction tx=session.beginTransaction();
//             session.persist(o3);
//             tx.commit();
//             session.close();
          
          
        
    }
}
