package com.insure.service;

import java.util.ArrayList;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;

public interface InsureService {
	String login(String name, String password);
	String register(Customer customer);
	int getID(String name, String password);
	ArrayList<CustomerPolicy> getData(String name, String password);
	String addData(CustomerPolicy customerPol, String name, String password);
}
