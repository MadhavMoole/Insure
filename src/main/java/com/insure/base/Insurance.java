package com.insure.base;

import java.util.ArrayList;

public class Insurance {
	private int id;
	private String name, address;
	private int age;
	private ArrayList<UserPolicy> customerPolicy;
	
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
	
	public double getTotalAmount() {
		double total = 0;
		for(UserPolicy p : customerPolicy) {
			total += p.getAmount();
		}
		return total;
	}

	public ArrayList<UserPolicy> getCustomerPolicy() {
		return customerPolicy;
	}

	public void setCustomerPolicy(UserPolicy policy) {
		if(customerPolicy == null) {
			customerPolicy = new ArrayList<>();
		}
		customerPolicy.add(policy);
	}

	public void setCustomerPolicy(ArrayList<UserPolicy> customerPolicy) {
		this.customerPolicy = customerPolicy;
	}
}
