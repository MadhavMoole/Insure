package com.insure.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;
import com.insure.dao.InsureDAOImpl;


//@Service is used along with a service class to store the business logic of the application
@Service
@ComponentScan("com.insure.dao")
public class InsureServiceImpl implements InsureService{
	
	@Autowired
	private InsureDAOImpl impl;
	
	@Override
	public String login(String name, String password) {
		if(impl.login(name, password) == 1) {
			return "redirect:/main-page";
		}
		return "Login";
	}

	@Override
	public String register(Customer customer) {
		// TODO Auto-generated method stub
		if(impl.register(customer) == 1) {
			return "redirect:/main-page";
		}
		return "Register";
	}

	@Override
	public int getID(String name, String password) {
		// TODO Auto-generated method stub
		return impl.getID(name, password);
	}

	@Override
	public ArrayList<CustomerPolicy> getData(String name, String password) {
		// TODO Auto-generated method stub
		int id = getID(name, password);
		return impl.getData(id);
	}

	@Override
	public String addData(CustomerPolicy customerPol, String name, String password) {
		// TODO Auto-generated method stub
		if (customerPol.getPolicy_name().equals("Life Insurance")) {
	        customerPol.setScheme_number(1);
	    } else if (customerPol.getPolicy_name().equals("Driver's Insurance")) {
	        customerPol.setScheme_number(2);
	    } else {
	        customerPol.setScheme_number(3);
	    } 
		if(impl.savePolicy(customerPol, name, password) == 1) {
			return "redirect:/main-page";
		}
		return "policy-apply";
	}

}
