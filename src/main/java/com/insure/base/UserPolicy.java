package com.insure.base;

public class UserPolicy {
	private int scheme_number;
	private String policy_name;
	private int max_no_of_years;
	private double amount;
	
	public int getScheme_number() {
		return scheme_number;
	}
	public void setScheme_number(int scheme_number) {
		this.scheme_number = scheme_number;
	}
	public String getPolicy_name() {
		return policy_name;
	}
	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}
	public int getMax_no_of_years() {
		return max_no_of_years;
	}
	public void setMax_no_of_years(int max_no_of_years) {
		this.max_no_of_years = max_no_of_years;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
