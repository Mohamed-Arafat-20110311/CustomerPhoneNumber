package com.jumia.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int id;
	private String name;
	private String phone;
	
	public Customer() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
}
