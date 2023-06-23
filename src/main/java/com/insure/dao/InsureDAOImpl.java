package com.insure.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.insure.base.Insurance;
import com.insure.base.User;
import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;
import com.insure.resultSet.InsuranceResultSetExtractor;

@Repository
@ComponentScan("com.insure.dao")
public class InsureDAOImpl implements InsureDAO {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public String validate(String username, String password) {
		// TODO Auto-generated method stub
		if (username.equals("admin") && password.equals("adm123")) {
			return "admin";
		}

		String sql = "Select count(*) from user where username = ? AND password = ?;";
		int count = jt.queryForObject(sql, Integer.class, username, password);
		return count == 1 ? "user" : "not-user";
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		String sql = "Insert into user ( email , userName, password ) values ('" + user.getEmail() + "', '"
				+ user.getUserName() + "', '" + user.getPassword() + "');";
		jt.update(sql);
	}

	@Override
	public ArrayList<CustomerPolicy> getData(String username, String password) {
		// TODO Auto-generated method stub
		int user_id = jt.queryForObject("select id from user.user where userName = ? and password = ?;", Integer.class,
				username, password);

		String sql = "SELECT p.id, p.scheme_number, p.policy_name, p.max_no_of_years, p.amount FROM policy p "
				+ "JOIN user_policy up ON p.id = up.policy_id JOIN insurance i ON i.id = up.insurance_id "
				+ "WHERE i.user_id = ?";
		ArrayList<CustomerPolicy> uP =  jt.query(sql, new InsuranceResultSetExtractor(), user_id);
		return uP;
	}

	@Override
	public void savePolicy(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
