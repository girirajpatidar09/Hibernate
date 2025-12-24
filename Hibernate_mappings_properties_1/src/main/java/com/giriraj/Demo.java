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
        
    }
}
