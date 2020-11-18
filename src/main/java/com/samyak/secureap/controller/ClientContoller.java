package com.samyak.secureap.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.AppointmentDao;
import com.samyak.secureap.dao.ClientDao;
import com.samyak.secureap.dao.CustomerDao;
import com.samyak.secureap.dao.DistributerDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.PaymentDao;
import com.samyak.secureap.dao.ProductDao;
import com.samyak.secureap.models.Distributer;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class ClientContoller {

	@Autowired
	SecurityService securityService;

    @Autowired
    AppointmentDao appointmentDao;
    
    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    DistributerDao distributerDao;
    
    @Autowired
    ClientDao clientDao;
	
	@Autowired
	UserService userService;
	
    @Autowired
    PaymentDao paymentDao;
	
    @Autowired
    ProductDao productDao;
    
    @Autowired
    CustomerDao customerDao;
	
	@RequestMapping("/client")
	public String Client(Model m) {
		
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		System.out.println(15);
		System.out.println(securityService.findLoggedInUsername());
		m.addAttribute("loggedInUsername", securityService.findLoggedInUsername());
		return "client.jsp";
	}
	
	@RequestMapping("/client/profile/{loginId}")
	public String ClientProfile(@PathVariable int loginId, Model m) 
	{	
		LoginAccount loginAccount = userService.findByUsername(loginId);
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		m.addAttribute("clientDetails",clientDao.getAllDetailsClient(loginId));
		return "clientProfile.jsp";
	}
	
	
	@RequestMapping("/client/seetodayappointment")
	public String ViewTodayAppointment(Model m ) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		//int loginId=securityService.findLoggedInUsername();
		long millis=System.currentTimeMillis();  
		Date date=new java.sql.Date(millis);  
		//int customerId = customerDao.getcustomer(loginId);
		m.addAttribute("getallappointments",appointmentDao.getTodayAppointmentClient(date));	
		System.out.println("seeappointment");
		System.out.println(appointmentDao.getTodayAppointmentClient(date));
	return "clientSeeAppointment.jsp";
	}
	
	
	@RequestMapping("/client/customeralldetails/{customerId}")
	public String CustomerAllDetails(@PathVariable int customerId, Model m ) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		//int loginId=securityService.findLoggedInUsername();
		m.addAttribute("loggedInUsername", customerId);
		long millis=System.currentTimeMillis();  
		Date date=new java.sql.Date(millis);  
		int loginId = loginAccountDao.getLoginId(customerId);
		m.addAttribute("getallappointmentscustomerpast",appointmentDao.getAllAppointmentPast(customerId));	
		m.addAttribute("getallpastpayments",paymentDao.getAllPastPayments(loginId));
	return "allDetailsCustomer.jsp"	;
	}	
}
