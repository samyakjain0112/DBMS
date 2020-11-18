package com.samyak.secureap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.Distributer;
import com.samyak.secureap.models.StaffMember;


@Repository
public class DistributerDaoImpl implements DistributerDao {

	public DistributerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Distributer getAllDetailsDistributer(int loginId ) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "select * from Distributer where loginId=?";
		Distributer distributer = (Distributer) jdbcTemplate.queryForObject(sql, new Object[] { loginId},
				new BeanPropertyRowMapper<>(Distributer.class));
		return distributer;
	}
	
	@Override
	public void save(Distributer distributer) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "insert into Distributer (name,contact,loginId) values( ?,?,?)";
		jdbcTemplate.update(sql,distributer.getName(),
				distributer.getContact(),distributer.getLoginId() );
	}
	
	@Override
	public void delete(int loginId) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "Delete from Distributer where loginId=?";
		jdbcTemplate.update(sql,loginId );
	}	
	
	
	@Override
    public List<Distributer> getAllDistributers(){
        String sql="select * from Distributer";
        return jdbcTemplate.query(sql,
        new BeanPropertyRowMapper<>(Distributer.class));
    }
	
}
