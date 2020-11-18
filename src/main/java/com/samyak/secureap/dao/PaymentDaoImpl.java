package com.samyak.secureap.dao;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Appointment;
import com.samyak.secureap.models.Payment;
@Repository
public class PaymentDaoImpl implements PaymentDao {
	public PaymentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Payment payment) {

		String sql = "insert into Payment (transactionId, amount, productId, date,loginId,clientId) values(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, payment.getTransactionId(), payment.getAmount(), payment.getProductId(), payment.getDate(),payment.getLoginId(), payment.getClientId());
	}
	
	
	
    public List<Payment> getAllPastPayments(int loginId){
		long millis=System.currentTimeMillis();  
		Date datetoday=new java.sql.Date(millis);  
        String sql="select * from Payment where loginId=? and date<=?";
        return jdbcTemplate.query(sql,
        new Object[]{loginId,datetoday},
        new BeanPropertyRowMapper<>(Payment.class));


    }
    
    public List<Payment> getTodayPurchasesClient(Date date){
        String sql="select * from Payment where date=?";
        return jdbcTemplate.query(sql,
        new Object[]{date},
        new BeanPropertyRowMapper<>(Payment.class));
    }
    
}
