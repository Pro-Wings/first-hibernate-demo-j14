package com.prowings.hibernate.inheritancedemo.table_per_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerClassStrategyInheritance {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		
		
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();


//		Student s = new Student("Ram", "Python");
//		session.persist(s);

		
		Student fetchedStd = session.get(Student.class, 1);
		
		System.out.println("Std id : "+fetchedStd.getId());
		System.out.println("Std name : "+fetchedStd.getName());
		System.out.println("Std course : "+fetchedStd.getCourse());
		
		transaction.commit();
		session.close();
		System.out.println("----------------------------------");
		
		System.out.println("---create session2---");
		
		Session session2 = sessionFactory.openSession();
		Transaction transaction2 = session2.beginTransaction();

		Student fetchedStd3 = session2.get(Student.class, 1);
		
		System.out.println("3Std id : "+fetchedStd3.getId());
		System.out.println("3Std name : "+fetchedStd3.getName());
		System.out.println("3Std course : "+fetchedStd3.getCourse());

		
		transaction2.commit();
		session2.close();

		
		sessionFactory.close();
		
		System.out.println("main method ended!!");

		
	}

}
