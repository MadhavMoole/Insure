package com.insure.dao;

import java.util.ArrayList;

//import com.insure.base.Insurance;
import com.insure.base.User;
import com.insure.base.UserPolicy;

public interface InsureDAO {
	String validate(String username, String password);
	void register(User user);
	ArrayList<UserPolicy> getData(String username, String password);
}
