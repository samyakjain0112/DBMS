package com.samyak.secureap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.Distributer;
import com.samyak.secureap.models.LoginAccount;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void save(Customer customer) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "insert into customer (name,contact,loginId,address,dob) values( ?,?,?,?,?)";
		jdbcTemplate.update(sql,customer.getName(),
				customer.getContact(),customer.getLoginId(),customer.getAddress(),customer.getDob() );
	}
	
	
	@Override
	public int getcustomer(int loginId) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "select * from Customer where loginId=?";
		Customer cust = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { loginId},
				new BeanPropertyRowMapper<>(Customer.class));
		return cust.getCustomerId();
	}
	
	@Override
	public Customer getAllDetailsCustomer(int loginId ) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "select * from Customer where loginId=?";
		Customer cust = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { loginId},
				new BeanPropertyRowMapper<>(Customer.class));
		return cust;
	}
	
	@Override
	public void delete(int loginId) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "Delete from Customer where loginId=?";
		jdbcTemplate.update(sql,loginId );
	}	
	
	@Override
    public List<Customer> getAllCustomers(){
        String sql="select * from Customer";
        return jdbcTemplate.query(sql,
        new BeanPropertyRowMapper<>(Customer.class));
    }	
	
	@Override
	public List<Customer> getCustomersByName(String name) {
		String sql="select * from Customer where name like ?";
		String temp='%'+name+'%';
		return jdbcTemplate.query(sql, new Object[] {temp}, new BeanPropertyRowMapper<>(Customer.class));
	}
}
