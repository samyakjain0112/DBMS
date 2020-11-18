package com.samyak.secureap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.models.LoginAccount;



@Service
public class UserServiceImpl implements UserService {

	//public UserServiceImpl() {
	//	// TODO Auto-generated constructor stub
	//}
	
	@Autowired
	private LoginAccountDao loginAccountDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public int save(LoginAccount loginAccount) {
		loginAccount.setPassword(bCryptPasswordEncoder.encode(loginAccount.getPassword()));
		int str = loginAccountDao.save(loginAccount);
		return str;
	}

	@Override
	public LoginAccount findByUsername(int loginId) {
		return loginAccountDao.findByUsername(loginId);
	}


}
