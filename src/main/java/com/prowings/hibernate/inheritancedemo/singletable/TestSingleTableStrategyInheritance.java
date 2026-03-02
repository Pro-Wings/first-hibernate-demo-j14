package com.prowings.hibernate.inheritancedemo.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSingleTableStrategyInheritance {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		
		
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Person p = new Person("Raju");
		
		session.persist(p);
		
		Employee e = new Employee("Ram", 90000);
		
		session.persist(e);

		Student s = new Student("Sham", "Java");
		session.persist(s);

		transaction.commit();
		session.close();
		sessionFactory.close();
		
		System.out.println("main method ended!!");

		
	}

}
