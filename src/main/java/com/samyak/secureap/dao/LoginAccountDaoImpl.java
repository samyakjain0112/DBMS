package com.samyak.secureap.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.LoginAccount;

@Repository
public class LoginAccountDaoImpl implements LoginAccountDao {
	public LoginAccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(LoginAccount loginAccount) {
		try
	{
			String sql = "select * from LoginAccount where loginId=?";
			LoginAccount login = (LoginAccount) jdbcTemplate.queryForObject(sql, new Object[] { loginAccount.getLoginId()},
					new BeanPropertyRowMapper<>(LoginAccount.class));
			 
	}
		
	catch (EmptyResultDataAccessException e) {
		loginAccount.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "insert into LoginAccount (loginId, password, role) values(?, ?, ?)";
		jdbcTemplate.update(sql, loginAccount.getLoginId(), loginAccount.getPassword(), loginAccount.getRole());
		
		return 1;
    }
		return 0;
		
	}
	@Override
	public boolean check(LoginAccount loginAccount){
		//loginAccount.setRole("ROLE_"+ loginAccount.getRole());
		try
	{
			String sql = "select * from LoginAccount where loginId=? and role=?";
			LoginAccount login = (LoginAccount) jdbcTemplate.queryForObject(sql, new Object[] { loginAccount.getLoginId(), loginAccount.getRole() },
					new BeanPropertyRowMapper<>(LoginAccount.class));
			 
	}
		
	catch (EmptyResultDataAccessException e) {
        return false;
    }
		return true;
}
	
	
	@Override
	public void delete(int loginId) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "Delete from LoginAccount where loginId=?";
		jdbcTemplate.update(sql,loginId );
	}	

	
	
	@Override
	public LoginAccount findByUsername(int loginId) {
		try {
            String sql = "SELECT * FROM LoginAccount WHERE loginId = ?";
            return (LoginAccount) jdbcTemplate.queryForObject(sql, new Object[] { loginId },
                    new BeanPropertyRowMapper<>(LoginAccount.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	
	@Override
	public int getLoginId(int customerId) {
		
            String sql = "SELECT * FROM Customer WHERE customerId = ?";
            Customer cust = (Customer)jdbcTemplate.queryForObject(sql, new Object[] { customerId },
                    new BeanPropertyRowMapper<>(Customer.class));
            return cust.getLoginId();
	}
}
