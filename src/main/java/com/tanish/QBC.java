package com.tanish;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class QBC {

	public static void main(String[] args) {
		
		Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Employee.class).addAnnotatedClass(Vehicle.class);
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		Criteria crt=session.createCriteria(Laptop.class);
		List list=crt.list();
		
		for(Object l:list)
		{
			System.out.println(l);
		}

		
		System.out.println("------------------Ordering-------------------------");
		
		Order order=Order.desc("pirce");
		crt.addOrder(order);
		
		list=crt.list();
		
		for(Object l:list)
		{
			System.out.println(l);
		}
		
		System.out.println("---------------Filteration---------------------------");
		crt.add(Restrictions.gt("pirce", 2500));
		crt.add(Restrictions.between("pirce",0,10000));
		
		list=crt.list();
		
		for(Object l:list)
		{
			System.out.println(l);
		}
		
		
		System.out.println("-----------Projection--------------------------");
		Criteria crt2=session.createCriteria(Laptop.class);
		ProjectionList plist=Projections.projectionList();
		Projection p1=Projections.property("code");
		Projection p2=Projections.property("brand");
		
		plist.add(p1);
		plist.add(p2);
		
		crt2.setProjection(plist);
		
		List<Object[]> laps=crt2.list();
		
		for(Object ob[]:laps)
		{
			for(Object o:ob)
			{
				System.out.print(o+"  ");
				
			}
			System.out.println();
		}
		
		
	}

}
