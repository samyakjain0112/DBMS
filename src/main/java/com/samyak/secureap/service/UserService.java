package com.samyak.secureap.service;

import com.samyak.secureap.models.LoginAccount;

public interface UserService {
	int save(LoginAccount loginAccount);
	LoginAccount findByUsername(int loginId);

}
