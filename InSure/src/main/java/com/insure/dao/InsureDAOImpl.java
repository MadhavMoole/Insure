package com.insure.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insure.base.Insurance;
import com.insure.base.User;

@Repository
public class InsureDAOImpl implements InsureDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "Select count(*) from userLogin where username = ? AND password = ?;";
		int count = jt.queryForObject(sql, Integer.class, username, password);
		return count == 1;
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		String sql = "Insert into userLogin values ("+ user.getUserName() +", "+ user.getEmail() +", "+ user.getPassword() +")";
		jt.update(sql);
	}

}
