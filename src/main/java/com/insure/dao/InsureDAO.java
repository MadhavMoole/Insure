package com.insure.dao;

import java.util.ArrayList;
import java.util.List;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;

public interface InsureDAO {
	Integer login(String name, String password);
	Integer register(Customer customer);
	ArrayList<CustomerPolicy> getData(Integer id);
	Integer getID(String name, String password);
	Integer savePolicy(CustomerPolicy customerPol, String name, String password);
	List<Customer> getCustomerList();
	Customer getCustomer(Integer id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Integer id);
	void updateCustomerPolicy(CustomerPolicy policy, Integer id);
	void deleteCustomerPolicy(CustomerPolicy policy, Integer id);
	Integer getID(CustomerPolicy policy, Integer id);
}
