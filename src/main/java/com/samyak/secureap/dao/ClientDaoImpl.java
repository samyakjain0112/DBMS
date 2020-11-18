package com.samyak.secureap.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	public ClientDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Client getAllDetailsClient(int loginId ) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "select * from Client where loginId=?";
		Client client = (Client) jdbcTemplate.queryForObject(sql, new Object[] { loginId},
				new BeanPropertyRowMapper<>(Client.class));
		return client;
	}
	
}
