package com.prowings.hibernate.association.onetomany.unidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToManyUnidirection {
	
	public static void main(String[] args) {
		
		System.out.println("main method started!!");
		//Create Session Factory object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate_onetomanynii.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Item item1 = new Item();
		item1.setProductName("iPhone");
		item1.setPrice(90000);
		item1.setQuantity(1);

		Item item2 = new Item();
		item2.setProductName("HP Laptop");
		item2.setPrice(100000);
		item2.setQuantity(1);
		
		Item item3 = new Item();
		item3.setProductName("Router");
		item3.setPrice(1000);
		item3.setQuantity(1);
		
		Order order = new Order();
		
		order.setOrderNumber("1111");
		order.addItem(item1);
		order.addItem(item2);
		order.addItem(item3);
		
		session.persist(order);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		System.out.println("main method ended!!");

		
	}

}
