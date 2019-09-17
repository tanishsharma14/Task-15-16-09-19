package com.tanish;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SQLQuery {

	public static void main(String[] args) {
	
		Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Employee.class).addAnnotatedClass(Vehicle.class);
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		String sql="select brand from vehicle";
		org.hibernate.SQLQuery query=session.createSQLQuery(sql);
		//query.addEntity(Vehicle.class);
		
		List list=query.list();
		
		for(Object o:list)
		{
			System.out.println(o);
		}
	}

}
