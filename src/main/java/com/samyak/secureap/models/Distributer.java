package com.samyak.secureap.models;

public class Distributer {
	private int distributerId;
	private String name;
	private String contact;
	private int loginId;
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getDistributerId() {
		return distributerId;
	}
	public void setDistributerId(int distributerId) {
		this.distributerId = distributerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}