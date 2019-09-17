package com.tanish;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	private int eid;
	private String ename;
	private int sal;
	
	@OneToOne
	private Vehicle vehicle;

	@OneToOne
	private Laptop laptop;
	
	public Employee() {
		super();
	}

	public Employee(int eid, String ename, int sal, Vehicle vehicle,
			Laptop laptop) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.vehicle = vehicle;
		this.laptop = laptop;
	}





	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal
				+ ", vehicle=" + vehicle + ", laptop=" + laptop + "]";
	}



	
	
}
