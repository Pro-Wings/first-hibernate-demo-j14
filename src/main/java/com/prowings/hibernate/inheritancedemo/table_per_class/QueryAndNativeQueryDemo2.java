package com.prowings.hibernate.inheritancedemo.table_per_class;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class QueryAndNativeQueryDemo2 {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query<Student> stdQuery = session.createQuery("from Student where id = :id", Student.class);
		stdQuery.setParameter("id", 1);
		stdQuery.setCacheable(true);
		List<Student> stdList = stdQuery.list();
		for(Student s : stdList)
		{
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getCourse());
			System.out.println("--------------");
		}

		System.out.println("++++++++++++++++++++++++++++++++");
		
		Query<Student> stdQuery1 = session.createQuery("from Student where id = :id", Student.class);
		stdQuery1.setParameter("id", 1);
		stdQuery1.setCacheable(true);
		List<Student> stdList1 = stdQuery1.list();
		for(Student s : stdList1)
		{
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getCourse());
			System.out.println("--------------");
		}

		
		transaction.commit();
		session.close();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		Session session2 = sessionFactory.openSession();
		Transaction transaction2 = session2.beginTransaction();
		
		Query<Student> stdQuery2 = session2.createQuery("from Student where id = :id", Student.class);
		stdQuery2.setParameter("id", 1);
		stdQuery2.setCacheable(true);
		List<Student> stdList2 = stdQuery2.list();
		
		for(Student s : stdList2)
		{
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getCourse());
			System.out.println("--------------");
		}
		
		transaction2.commit();
		session2.close();

		
		sessionFactory.close();
		
		System.out.println("main method ended!!");

		
		
	}

}
