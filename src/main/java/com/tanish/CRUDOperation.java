package com.tanish;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CRUDOperation {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Vehicle.class)
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		//getting employee object
		Employee obj = session.get(Employee.class,1);
		System.out.println(obj);
		
		
		//updating a employee 	ID
		obj.setEname("TanishSharma");
		session.save(obj);
		
		
		//Removing a employee
		 Employee obj2=session.get(Employee.class,5);
		 session.remove(obj2);
		
		tx.commit();
		session.close();
		
		
	}

}
