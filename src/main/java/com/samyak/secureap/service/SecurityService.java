package com.samyak.secureap.service;

public interface SecurityService {
	
	public int findLoggedInUsername();
    public void autoLogin(String username, String password);
    public void autoLogout();
}

