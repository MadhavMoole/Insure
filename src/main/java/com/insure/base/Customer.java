package com.insure.base;

import java.util.ArrayList;

public class Customer {
	private int id;
	private String name, address, email;
	private int age;
	private long phone_number;
	private String password;
	private ArrayList<CustomerPolicy> customerPolicy;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getTotalAmount() {
		double total = 0;
		for(CustomerPolicy p : customerPolicy) {
			total += p.getAmount();
		}
		return total;
	}

	public ArrayList<CustomerPolicy> getCustomerPolicy() {
		return customerPolicy;
	}

	public void setCustomerPolicy(CustomerPolicy policy) {
		if(customerPolicy == null) {
			customerPolicy = new ArrayList<>();
		}
		customerPolicy.add(policy);
	}

	public void setCustomerPolicy(ArrayList<CustomerPolicy> customerPolicy) {
		this.customerPolicy = customerPolicy;
	}

	
}
