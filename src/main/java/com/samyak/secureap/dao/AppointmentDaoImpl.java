package com.samyak.secureap.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Appointment;



@Repository
public class AppointmentDaoImpl implements AppointmentDao  {

	public AppointmentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Appointment appointment) {
		
		String sql = "insert into Appointment (clientId,customerId, time, treatmentId,date) values(?, ?, ?,?,?)";
		jdbcTemplate.update(sql, appointment.getClientId(),appointment.getCustomerId(),appointment.getTime(), appointment.getTreatmentId(), appointment.getDate());
	}
	
	@Override
	public boolean check(Appointment appointment){
		//loginAccount.setRole("ROLE_"+ loginAccount.getRole());
		try
	{		
			String sql = "select * from Appointment where time=? and treatmentId=? and date=?";
			Appointment app = (Appointment) jdbcTemplate.queryForObject(sql, new Object[] { appointment.getTime(), appointment.getTreatmentId(), appointment.getDate() },
					new BeanPropertyRowMapper<>(Appointment.class));
			 
	}
		
	catch (EmptyResultDataAccessException e) {
        return true;
    }
		return false;
}
	
    public List<Appointment> getAllAppointment(int customerId){
		long millis=System.currentTimeMillis();  
		Date datetoday=new java.sql.Date(millis);  
        String sql="select * from Appointment where customerId=? and date>?";
        return jdbcTemplate.query(sql,
        new Object[]{customerId,datetoday},
        new BeanPropertyRowMapper<>(Appointment.class));


    }
 
    
    public List<Appointment> getAllAppointmentPast(int customerId){
		long millis=System.currentTimeMillis();  
		Date datetoday=new java.sql.Date(millis);  
        String sql="select * from Appointment where customerId=? and date<?";
        return jdbcTemplate.query(sql,
        new Object[]{customerId,datetoday},
        new BeanPropertyRowMapper<>(Appointment.class));


    }
    
    
    public List<Appointment> getTodayAppointmentClient(Date date){
        String sql="select * from Appointment where date=?";
        return jdbcTemplate.query(sql,
        new Object[]{date},
        new BeanPropertyRowMapper<>(Appointment.class));
    }
    
    public List<Appointment> getAllAppointmentTodaySatffId(int treatmentId){
		long millis=System.currentTimeMillis();  
		Date datetoday=new java.sql.Date(millis);
        String sql="select * from Appointment where date=? and treatmentId=?";
        return jdbcTemplate.query(sql,
        new Object[]{datetoday,treatmentId},
        new BeanPropertyRowMapper<>(Appointment.class));
    }
    
    
    public List<Appointment> getAllAppointmentToday(int staffId){
		long millis=System.currentTimeMillis();  
		Date datetoday=new java.sql.Date(millis);
        String sql="select * from Appointment where date=? and staffId=?";
        return jdbcTemplate.query(sql,
        new Object[]{datetoday,staffId},
        new BeanPropertyRowMapper<>(Appointment.class));
    }
    
}
