package com.insure.dao;

import com.insure.base.Insurance;
import com.insure.base.User;

public interface InsureDAO {
	boolean validate(String username, String password);
	void register(User user);
}
