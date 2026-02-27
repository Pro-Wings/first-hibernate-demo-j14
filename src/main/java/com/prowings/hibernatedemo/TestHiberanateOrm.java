package com.prowings.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHiberanateOrm {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		//java object - persistent? - Yes state=transient
		
	
		//Create Session Factory object
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student student1 = new Student();
		student1.setRollNumber(10);
		student1.setName("Ram");
		student1.setAddress("Pune");
		
		session.persist(student1);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
		
		System.out.println("main method ended!!");
	}

}
