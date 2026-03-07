package com.prowings.hibernate.inheritancedemo.table_per_class;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class QueryAndNativeQueryDemo {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//		Query<Student> stdQuery = session.createQuery("from Student", Student.class);

		//This is HQL
//		Query<Student> stdQuery = session.createQuery("from Student where course = :c", Student.class);

		//This is SQL
		Query<Student> stdQuery = session.createNativeQuery("Select * from Student where course = :c", Student.class);

		stdQuery.setParameter("c", "Java");
//		stdQuery.setCacheable(true);
		
		List<Student> stdList = stdQuery.list();
		
		for(Student s : stdList)
		{
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getCourse());
			System.out.println("--------------");
		}
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		System.out.println("main method ended!!");

		
		
	}

}
