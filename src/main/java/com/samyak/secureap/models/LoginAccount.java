package com.samyak.secureap.models;

public class LoginAccount {
private int loginId;
private String password;
private String role;
public String getRole() {
	return role;
}

public LoginAccount(int loginId, String password, String role) {
	super();
	this.loginId = loginId;
	this.password = password;
	this.role = role;
}


public LoginAccount() {
	super();
}

public void setRole(String role) {
	this.role = role;
}
public int getLoginId() {
	return loginId;
}
public void setLoginId(int loginId) {
	this.loginId = loginId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}