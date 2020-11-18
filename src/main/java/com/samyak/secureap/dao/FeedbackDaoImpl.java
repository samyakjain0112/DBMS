package com.samyak.secureap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Feedback;
import com.samyak.secureap.models.Product;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {
	public FeedbackDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Feedback feedback) {

		
		String sql = "insert into Feedback (customerId,feedback ) values(?, ?)";
		jdbcTemplate.update(sql, feedback.getCustomerId(), feedback.getFeedback());
		
	}
	
	@Override
    public List<Feedback> getAllFeedbacks(){
        String sql="select * from Feedback";
        return jdbcTemplate.query(sql,
        new BeanPropertyRowMapper<>(Feedback.class));


    }
	
	
}
