package com.insure.resultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.insure.base.CustomerPolicy;

public class InsuranceResultSetExtractor implements ResultSetExtractor<ArrayList<CustomerPolicy>> {

	@Override
	public ArrayList<CustomerPolicy> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		ArrayList<CustomerPolicy> User = new ArrayList<>();
		while(rs.next()) {
			CustomerPolicy Policy = new CustomerPolicy();
			Policy.setAmount(rs.getDouble(4));
			Policy.setMax_no_of_years(rs.getInt(3));
			Policy.setPolicy_name(rs.getString(2));
			Policy.setScheme_number(rs.getInt(1));
			User.add(Policy);
		}
		return User;
	}

}
