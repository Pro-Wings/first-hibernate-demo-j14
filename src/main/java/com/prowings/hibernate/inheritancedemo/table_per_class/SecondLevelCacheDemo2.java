package com.prowings.hibernate.inheritancedemo.table_per_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecondLevelCacheDemo2 {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		
		
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee fetchedEmp = session.get(Employee.class, 1);
		
		System.out.println("id : "+fetchedEmp.getId());
		System.out.println("name : "+fetchedEmp.getName());
		System.out.println("Salary : "+fetchedEmp.getSalary());
		
		transaction.commit();
		session.close();
		System.out.println("----------------------------------");
		
		System.out.println("---create session2---");
		
		Session session2 = sessionFactory.openSession();
		Transaction transaction2 = session2.beginTransaction();

		Employee fetchedEmp2 = session2.get(Employee.class, 1);
		
		System.out.println("id : "+fetchedEmp2.getId());
		System.out.println("name : "+fetchedEmp2.getName());
		System.out.println("Salary : "+fetchedEmp2.getSalary());
		
		transaction2.commit();
		session2.close();

		
		sessionFactory.close();
		
		System.out.println("main method ended!!");

		
	}

}
