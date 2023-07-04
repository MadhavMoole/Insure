package com.insure.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;
import com.insure.resultSet.CustomerResultSetExtractor;
import com.insure.resultSet.CustomerRowMapper;
import com.insure.resultSet.InsuranceResultSetExtractor;

@Repository
@ComponentScan("com.insure.dao")
public class InsureDAOImpl implements InsureDAO {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public Integer login(String name, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM customer WHERE name = ? and password = ?";
		Object[] args = {name, password};
		return jt.queryForObject(sql, Integer.class, args);
	}

	@Override
	public Integer register(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO customer (name, email, address, age, phone_number, password) SELECT ?, ?, ?, ?, ?, ? WHERE NOT EXISTS ( SELECT 1 FROM customer WHERE email = '"+ customer.getEmail() +"')";
		Object[] args = {customer.getName(), customer.getEmail(), customer.getAddress(), customer.getAge(), customer.getPhone_number(), customer.getPassword()};
		return jt.update(sql, args);
	}

	@Override
	public ArrayList<CustomerPolicy> getData(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT p.scheme_number, p.policy_name, p.max_no_of_years, p.amount FROM policy p JOIN customer c ON c.id = p.customer_id WHERE c.id = "+ id +";";
		return jt.query(sql, new InsuranceResultSetExtractor());
	}

	@Override
	public Integer savePolicy(CustomerPolicy customerPol, String name, String password) {
		// TODO Auto-generated method stub
		int id = getID(name, password);
		String sql = "INSERT INTO policy (scheme_number, policy_name, max_no_of_years, amount, customer_id) SELECT " + customerPol.getScheme_number() + ", '"+ customerPol.getPolicy_name() +"', "+ customerPol.getMax_no_of_years() +","+ customerPol.getAmount() +", id FROM customer WHERE id = "+ id +";";
		return jt.update(sql);
	}

	@Override
	public Integer getID(String name, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT id FROM customer WHERE name = '"+ name +"' AND password = '"+ password +"';";
		return jt.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customer;";
		return jt.query(sql, new CustomerResultSetExtractor());
	}

	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customer WHERE id = "+ id +";";
		return jt.queryForObject(sql, new CustomerRowMapper());
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "UPDATE customer SET name = '"+ customer.getName() +"', address = '"+ customer.getAddress() +"', age = "+ customer.getAge() +", email = '"+ customer.getEmail() +"', phone_number = '"+ customer.getPhone_number() +"' WHERE id = "+ customer.getId() +";";
		jt.update(sql);
	}

	@Override
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM customer WHERE id = "+ id +"";
		jt.update(sql);
	}

	@Override
	public void updateCustomerPolicy(CustomerPolicy policy, Integer id) {
		// TODO Auto-generated method stub
		Integer policyID = getID(policy, id);
		String sql = "UPDATE policy p SET p.scheme_number = " + policy.getScheme_number() + ", p.policy_name = '"+ policy.getPolicy_name() +"', p.max_no_of_years = "+ policy.getMax_no_of_years() +", p.amount = "+ policy.getAmount() +" WHERE p.customer_id = (SELECT c.id FROM customer c WHERE c.id = "+ id +") AND p.id = "+ policyID +";";
		jt.update(sql);
	}

	@Override
	public Integer getID(CustomerPolicy policy, Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT p.id FROM policy p where p.scheme_number = "+ policy.getScheme_number() +" AND p.customer_id = (SELECT c.id FROM customer c WHERE c.id = "+ id +")";
		return jt.queryForObject(sql, Integer.class);
	}

	@Override
	public void deleteCustomerPolicy(CustomerPolicy policy, Integer id) {
		// TODO Auto-generated method stub
		Integer policyID = getID(policy, id);
		String sql = "DELETE FROM Policy p WHERE p.id = "+ policyID +" AND p.scheme_number = "+ policy.getScheme_number() +" AND p.customer_id = (SELECT id FROM customer WHERE id = "+ id +");"; 
		jt.update(sql);
	}
}
