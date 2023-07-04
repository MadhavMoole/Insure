package com.insure.resultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.insure.base.Customer;

public class CustomerResultSetExtractor implements ResultSetExtractor<List<Customer>> {

	@Override
	public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<>();
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setId(rs.getInt(1));
			customer.setName(rs.getString(2));
			customer.setAddress(rs.getString(3));
			customer.setAge(rs.getInt(4));
			customer.setEmail(rs.getString(5));
			customer.setPhone_number(rs.getLong(6));
			customer.setPassword(rs.getString(7)); 
			customerList.add(customer);
		}
		return customerList;
	}

}
