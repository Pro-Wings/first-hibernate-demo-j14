package com.prowings.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHiberanateOrm_update_demo {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		
	
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student s1 = session.get(Student.class, 1);
		System.out.println("Fetched Student : "+s1);
		
		transaction.commit();
		session.close();

		//-----------------do some changes in detached s1---------------------
		s1.setName("aaaa");
		
		//-----------------start another session---------------------
		Session session1 = sessionFactory.openSession();
		Transaction transaction1 = session1.beginTransaction();
		
		Student s1existing = session1.get(Student.class, 1);

		
		//---now s1 came back to persistent state - reattach
//		session1.update(s1);
		session1.merge(s1);

		transaction1.commit();
		session1.close();
		
		
		sessionFactory.close();
		
		System.out.println("main method ended!!");
	}

}
