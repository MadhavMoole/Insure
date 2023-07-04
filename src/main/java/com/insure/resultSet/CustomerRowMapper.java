package com.insure.resultSet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insure.base.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getInt(4), rs.getLong(6), rs.getString(7), null);
		return customer;
	}

}
