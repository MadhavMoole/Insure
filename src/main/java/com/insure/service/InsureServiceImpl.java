package com.insure.service;

import java.util.ArrayList;
import java.util.List;

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
	public Integer getID(String name, String password) {
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

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return impl.getCustomerList();
	}

	@Override
	public List<CustomerPolicy> getPolicyList(Integer id) {
		// TODO Auto-generated method stub
		return impl.getData(id);
	}

	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		Customer customer = impl.getCustomer(id);
		customer.setId(id);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		impl.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		impl.deleteCustomer(id);
	}

	@Override
	public void updateCustomerPolicy(CustomerPolicy policy, Integer id) {
		// TODO Auto-generated method stub
		if (policy.getPolicy_name().equals("Life Insurance")) {
	        policy.setScheme_number(1);
	    } else if (policy.getPolicy_name().equals("Driver's Insurance")) {
	        policy.setScheme_number(2);
	    } else {
	        policy.setScheme_number(3);
	    } 
		impl.updateCustomerPolicy(policy, id);
	}

	@Override
	public void deleteCustomerPolicy(CustomerPolicy policy, Integer id) {
		// TODO Auto-generated method stub
		if (policy.getPolicy_name().equals("Life Insurance")) {
	        policy.setScheme_number(1);
	    } else if (policy.getPolicy_name().equals("Driver's Insurance")) {
	        policy.setScheme_number(2);
	    } else {
	        policy.setScheme_number(3);
	    } 
		impl.deleteCustomerPolicy(policy, id);
	}

}
