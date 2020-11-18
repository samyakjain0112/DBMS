package com.samyak.secureap.models;

public class StaffMember {
private int staffId;
private String name;
private int salary;
private String address;
private int workingHours;
private int loginId;
private String contact;
public int getStaffId() {
	return staffId;
}
public void setStaffId(int staffId) {
	this.staffId = staffId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getWorkingHours() {
	return workingHours;
}
public void setWorkingHours(int workingHours) {
	this.workingHours = workingHours;
}
public int getLoginId() {
	return loginId;
}
public void setLoginId(int loginId) {
	this.loginId = loginId;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

}