package com.tanish;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {

	@Id
	private int code;
	private String brand;
	private int pirce;
	
	@OneToOne(mappedBy="laptop")
	private Employee employee;

	
	
	
	public Laptop() {
		super();
	}

	
	public Laptop(int code, String brand, int pirce) {
		super();
		this.code = code;
		this.brand = brand;
		this.pirce = pirce;
	}


	public Laptop(int code, String brand, int pirce, Employee employee) {
		super();
		this.code = code;
		this.brand = brand;
		this.pirce = pirce;
		this.employee = employee;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPirce() {
		return pirce;
	}

	public void setPirce(int pirce) {
		this.pirce = pirce;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Laptop [code=" + code + ", brand=" + brand + ", pirce=" + pirce
				+ "]";
	}



	
	
	
}
