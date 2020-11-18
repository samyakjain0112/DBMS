package com.samyak.secureap.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.CustomerDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.PaymentDao;
import com.samyak.secureap.dao.ProductDao;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.models.Payment;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class PaymentController {

	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserService userService;
	
    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    PaymentDao paymentDao;
	
    @Autowired
    ProductDao productDao;
	
	@RequestMapping("/customer/payment")
	public String MakePaymemt(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallproducts",productDao.getAllProducts());	
		System.out.println("dsff");
		System.out.println(productDao.getAllProducts());
		return "makePayment.jsp";
	}
	
	@RequestMapping("/customer/paymentcall")
	public String MakePaymemtCall(@ModelAttribute Payment payment,Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallproducts",productDao.getAllProducts());	
		payment.setClientId(1);
		int loggedInUsername=securityService.findLoggedInUsername();
		payment.setLoginId(loggedInUsername);
		paymentDao.save(payment);
		
		return "redirect:/customer";
	}
	
	@RequestMapping("/customer/viewpastpurchases")
	public String ViewPastPurchases(Model m ) 
	{	
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallproducts",productDao.getAllProducts());	
		int loginId=securityService.findLoggedInUsername();
		m.addAttribute("getallpastpayments",paymentDao.getAllPastPayments(loginId));	
		System.out.println(paymentDao.getAllPastPayments(loginId));
	return "pastPayments.jsp"	;
	}
	
	
	@RequestMapping("/client/seetodaypurchases")
	public String ViewTodayPurchases(Model m ) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallproducts",productDao.getAllProducts());	
		//int loginId=securityService.findLoggedInUsername();
		long millis=System.currentTimeMillis();  
		Date date=new java.sql.Date(millis);  
		//int customerId = customerDao.getcustomer(loginId);
		m.addAttribute("getalltodaypayments",paymentDao.getTodayPurchasesClient(date));	
		System.out.println(paymentDao.getTodayPurchasesClient(date));
	return "todayPayments.jsp"	;
	}
	
}
