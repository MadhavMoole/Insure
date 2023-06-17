package com.insure.resultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.insure.base.UserPolicy;

public class InsuranceResultSetExtractor implements ResultSetExtractor<ArrayList<UserPolicy>> {

	@Override
	public ArrayList<UserPolicy> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		ArrayList<UserPolicy> User = new ArrayList<>();
		while(rs.next()) {
			UserPolicy Policy = new UserPolicy();
			Policy.setAmount(rs.getInt(5));
			Policy.setMax_no_of_years(rs.getInt(4));
			Policy.setPolicy_name(rs.getString(3));
			Policy.setScheme_number(rs.getInt(2));
			User.add(Policy);
		}
		return User;
	}

}
