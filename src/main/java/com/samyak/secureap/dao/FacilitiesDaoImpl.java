package com.samyak.secureap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Product;
import com.samyak.secureap.models.StaffMember;
import com.samyak.secureap.models.TreatmentAndFacilities;

@Repository
public class FacilitiesDaoImpl implements FacilitiesDao {
	public FacilitiesDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(TreatmentAndFacilities facilities) {
		try
	{
			String sql = "select * from TreatmentAndFacilities where treatmentId=?";
			TreatmentAndFacilities fac = (TreatmentAndFacilities) jdbcTemplate.queryForObject(sql, new Object[] { facilities.getTreatmentId()},
					new BeanPropertyRowMapper<>(TreatmentAndFacilities.class));
			 
	}
		
	catch (EmptyResultDataAccessException e) {
		
		String sql = "insert into TreatmentAndFacilities (name, cost, treatmentId, staffId, timeRequired ) values(?, ?, ?, ?,?)";
		jdbcTemplate.update(sql, facilities.getName(), facilities.getCost(), facilities.getTreatmentId(),facilities.getStaffId(), facilities.getTimeRequired());
		
		return 1;
    }
		return 0;
		
	}
	
	@Override
	public boolean check(TreatmentAndFacilities facilities){
		//loginAccount.setRole("ROLE_"+ loginAccount.getRole());
		try
	{
			String sql = "select * from TreatmentAndFacilities where treatmentId=?";
			TreatmentAndFacilities tret = (TreatmentAndFacilities) jdbcTemplate.queryForObject(sql, new Object[] {facilities.getTreatmentId() },
					new BeanPropertyRowMapper<>(TreatmentAndFacilities.class));
			 
	}
		
	catch (EmptyResultDataAccessException e) {
        return false;
    }
		return true;
}
	
	
	@Override
	public int getTreatmentId(int staffId) {
		try
	{
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "select * from TreatmentAndFacilities where staffId=?";
		TreatmentAndFacilities staff = (TreatmentAndFacilities) jdbcTemplate.queryForObject(sql, new Object[] { staffId},
				new BeanPropertyRowMapper<>(TreatmentAndFacilities.class));
		
	}
		catch (EmptyResultDataAccessException e) {
	        return 0;
	    }
		String sql = "select * from TreatmentAndFacilities where staffId=?";
		TreatmentAndFacilities staff = (TreatmentAndFacilities) jdbcTemplate.queryForObject(sql, new Object[] { staffId},
				new BeanPropertyRowMapper<>(TreatmentAndFacilities.class));
		
		return staff.getTreatmentId();
	}
	
	
	@Override
	public void delete(int treatmentId) {
		
		//customer.setRole("ROLE_"+ loginAccount.getRole());
		String sql = "Delete from TreatmentAndFacilities where treatmentId=?";
		jdbcTemplate.update(sql,treatmentId );
	}	
	
	
	@Override
    public List<TreatmentAndFacilities> getAllFacilities(){
        String sql="select * from TreatmentAndFacilities";
        return jdbcTemplate.query(sql,
        new BeanPropertyRowMapper<>(TreatmentAndFacilities.class));
	}

}
