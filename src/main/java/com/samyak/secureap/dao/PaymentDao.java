package com.samyak.secureap.dao;

import java.sql.Date;
import java.util.List;

import com.samyak.secureap.models.Payment;

public interface PaymentDao {

	void save(Payment payment);
	
	List<Payment> getAllPastPayments(int loginId);
	List<Payment> getTodayPurchasesClient(Date date);

}
