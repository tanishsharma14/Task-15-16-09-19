package com.tanish;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		
		Configuration config=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Vehicle.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Laptop laptop1=new Laptop(111,"HP",1000);
		Laptop laptop2=new Laptop(112,"DELL",2000);
		Laptop laptop3=new Laptop(113,"LENOVO",3000);
		Laptop laptop4=new Laptop(114,"ASUS",4000);
		Laptop laptop5=new Laptop(115,"MAC",5000);
		
		
		session.save(laptop1);
		session.save(laptop2);
		session.save(laptop3);
		session.save(laptop4);
		session.save(laptop5);
		
		
		Vehicle vehicle1=new Vehicle(11,"Hero","Model1",100000);
		Vehicle vehicle2=new Vehicle(12,"Honda","Model2",200000);
		Vehicle vehicle3=new Vehicle(13,"Maruti","Model3",300000);
		Vehicle vehicle4=new Vehicle(14,"BMW","Model4",400000);
		Vehicle vehicle5=new Vehicle(15,"Merz","Model5",500000);
		
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		session.save(vehicle4);
		session.save(vehicle5);
		
		
		
		
		Employee emp1=new Employee(1,"Tanish",100,vehicle1,laptop1);
		Employee emp2=new Employee(2,"Jay",200,vehicle2,laptop2);
		Employee emp3=new Employee(3,"Vijay",300,vehicle3,laptop3);
		Employee emp4=new Employee(4,"Ajay",400,vehicle4,laptop4);
		Employee emp5=new Employee(5,"Atul",500,vehicle5,laptop5);
		
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		
		tx.commit();
		session.close();

	}

}
