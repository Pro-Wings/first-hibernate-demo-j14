package com.prowings.hibernate.association.onetoone.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.hibernate.inheritancedemo.joined.Employee;

public class TestOneToOneAssociationBiDirectional {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		
		
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate_associationotobi.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

//		Profile profile = new Profile();
//		profile.setDescription("Normal user profile");
//		
//		User user = new User();
//		user.setName("Abhinav");
//		user.setProfile(profile);
//		
//		session.persist(user);

		User user = session.get(User.class, 1);
		
		System.out.println("Fetched User : ");
		System.out.println(user.getId());
		System.out.println(user.getName());
		
		System.out.println("Fetched User Profile : ");
		System.out.println(user.getProfile().getId());
		System.out.println(user.getProfile().getDescription());
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		System.out.println("main method ended!!");

		
		
	}

}
