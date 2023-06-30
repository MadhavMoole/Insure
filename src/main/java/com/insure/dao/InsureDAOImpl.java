package com.insure.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;
import com.insure.resultSet.InsuranceResultSetExtractor;

@Repository
@ComponentScan("com.insure.dao")
public class InsureDAOImpl implements InsureDAO {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public int login(String name, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM customer WHERE name = ? and password = ?";
		Object[] args = {name, password};
		return jt.queryForObject(sql, Integer.class, args);
	}

	@Override
	public int register(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO customer (name, email, address, age, phone_number, password) SELECT (?, ?, ?, ?, ?, ?) WHERE NOT EXISTS ( SELECT 1 FROM customer WHERE email = '"+ customer.getEmail() +"')";
		Object[] args = {customer.getName(), customer.getEmail(), customer.getAddress(), customer.getAge(), customer.getPhone_number(), customer.getPassword()};
		return jt.update(sql, args);
	}

	@Override
	public ArrayList<CustomerPolicy> getData(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT p.scheme_number, p.policy_name, p.max_no_of_years, p.amount FROM policy p JOIN customer c ON c.id = p.customer_id WHERE c.id = "+ id +";";
		return jt.query(sql, new InsuranceResultSetExtractor());
	}

	@Override
	public int savePolicy(CustomerPolicy customerPol, String name, String password) {
		// TODO Auto-generated method stub
		int id = getID(name, password);
		
		return 0;
	}

	@Override
	public int getID(String name, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT id FROM customer WHERE name = "+ name +" AND password = "+ password +";";
		return jt.queryForObject(sql, Integer.class);
	}


}
