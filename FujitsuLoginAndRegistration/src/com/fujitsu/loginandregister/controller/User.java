package com.fujitsu.loginandregister.controller;

public class User {
	int id;
	String username;
	int phone;
	String address;
	public User(int id, String username, int phone, String address) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.address = address;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", phone=" + phone + ", address=" + address + "]";
	}


}
