package com.jumia.model;

public class User {
	private int id;
	private String name;
	private String phone;
	private String country;
	private boolean isValid;
	
	public User(int id,String name, String phone, String country, boolean isValid){
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.country = country;
		this.isValid = isValid;
	}
	
	public User() {
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
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setValidity(boolean isValid) {
		this.isValid = isValid;
	}
	
	public boolean getValidity() {
		return isValid;
	}
}
