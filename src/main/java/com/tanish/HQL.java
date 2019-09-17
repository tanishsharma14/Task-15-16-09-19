package com.tanish;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Employee.class).addAnnotatedClass(Vehicle.class);
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();

		String hql="from Vehicle";
		Query query=session.createQuery(hql);
		List<Vehicle> list=query.getResultList();

		for(Vehicle v:list)
		{
			System.out.println(v);
		}
		
		System.out.println("----------Order by--------------");
		hql="from Vehicle order by price DESC";
		query=session.createQuery(hql);
		list=query.getResultList();
		
		for(Vehicle v:list)
		{
			System.out.println(v);
		}
		
		System.out.println("----------------Filteration-------------");
		hql="from Vehicle where regno=13";
		query=session.createQuery(hql);
		Vehicle v=(Vehicle)query.getSingleResult();
		System.out.println(v);
		
		System.out.println("-------------------Parametrized named based HQL------------------------");
		hql="from Vehicle where regno=:rid";
		query=session.createQuery(hql);
		query.setParameter("rid",14);
	     v=(Vehicle)query.getSingleResult();
	     System.out.println(v);
	     
	     
	     System.out.println("-------------------Parametrized position based HQL------------------------");
	     hql="from Vehicle where regno=?";
			query=session.createQuery(hql);
			query.setParameter(0,12);
			v=(Vehicle)query.getSingleResult();
			System.out.println(v);
	     
	   
	}

}
