package com.insure.service;

import java.util.ArrayList;
import java.util.List;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;

public interface InsureService {
	String login(String name, String password);
	String register(Customer customer);
	Integer getID(String name, String password);
	ArrayList<CustomerPolicy> getData(String name, String password);
	String addData(CustomerPolicy customerPol, String name, String password);
	List<Customer> getCustomerList();
	List<CustomerPolicy> getPolicyList(Integer id);
	Customer getCustomer(Integer id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Integer id);
	void updateCustomerPolicy(CustomerPolicy policy, Integer id);
	void deleteCustomerPolicy(CustomerPolicy policy, Integer id);
}
