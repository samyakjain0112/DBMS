package com.samyak.secureap.dao;

import java.util.List;

import com.samyak.secureap.models.LoginAccount;


public interface LoginAccountDao {

	int save(LoginAccount loginAccount);
	
	void delete(int loginId);
	
	boolean check(LoginAccount loginAccount);
	
	LoginAccount findByUsername(int loginId);
	
	int  getLoginId(int customerId);
}
