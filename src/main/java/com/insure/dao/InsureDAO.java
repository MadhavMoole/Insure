package com.insure.dao;

import java.util.ArrayList;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;

public interface InsureDAO {
	int login(String name, String password);
	int register(Customer customer);
	ArrayList<CustomerPolicy> getData(int id);
	int getID(String name, String password);
	int savePolicy(CustomerPolicy customerPol, String name, String password);
}
