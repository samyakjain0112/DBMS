package com.samyak.secureap.dao;

import java.util.List;

import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.Distributer;


public interface CustomerDao {

	void save(Customer customer);
	int getcustomer(int loginId);
	Customer getAllDetailsCustomer(int loginId);
	void delete(int loginId);
	List<Customer> getAllCustomers();
	List<Customer> getCustomersByName(String name);
	//Customer getCustomer(int customerId);
	
	//List<Customer> getAllCustomer();
}
