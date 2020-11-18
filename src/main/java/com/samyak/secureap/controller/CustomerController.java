package com.samyak.secureap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samyak.secureap.dao.CustomerDao;
import com.samyak.secureap.dao.FacilitiesDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.Distributer;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;


@Controller
public class CustomerController {

	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserService userService;
	
    @Autowired
    FacilitiesDao facilitiesDao;
    
    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    CustomerDao customerDao;
    
	@RequestMapping("/customer/appointment")
	public String Appointment(Model m) 
	{			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
	
	m.addAttribute("acc",loggedInAccount);
	
		m.addAttribute("getallfacilities",facilitiesDao.getAllFacilities());	
		System.out.println("Make an appointment");
		return "appointment.jsp";
	}
	

	
	@RequestMapping("/customer/profile/{loginId}")
	public String CustomerProfile(@PathVariable int loginId, Model m) 
	{			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
	
	m.addAttribute("acc",loggedInAccount);
	
		LoginAccount loginAccount = userService.findByUsername(loginId);
	System.out.println("Dsfsf");
		m.addAttribute("customerDetails",customerDao.getAllDetailsCustomer(loginId));
		System.out.println(customerDao.getAllDetailsCustomer(loginId));
		System.out.println("sams_j");
		return "customerProfile.jsp";
	}
	
	//@RequestMapping("/customerloginprofile")
	//public String CustomerLoginProfile() 
	//{	
	//	//need to remove after adding security
	//	return "customerloginprofile.jsp";
	//}
	@RequestMapping("/customer")
	public String Customer(Model m) {
		
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		System.out.println(15);
		System.out.println(securityService.findLoggedInUsername());
		m.addAttribute("loggedInUsername",  securityService.findLoggedInUsername());
		return "customer.jsp";
	}
	
	
	@RequestMapping("/customer/treatment")
	public String Treatment(Model m) 
	{		
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		return "treatment.jsp";
	}
	@RequestMapping("/customer/products")
	public String BuyProducts(Model m) 
	{		
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		return "buyproducts.jsp";
	}
	@RequestMapping("/customer/viewpurchases")
	public String ViewPurchases(Model m) 
	{	
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		return "viewpurchases.jsp";
	}	
	
	
	@RequestMapping("/client/addcustomer")
	public String AddCustomer(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		return "addCustomer.jsp";
	}

	@RequestMapping("/client/deletecustomer")
	public String DeleteCustomer(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallcustomers",customerDao.getAllCustomers());	
		
		return "deleteCustomer.jsp";
	}
	
	
	@RequestMapping("/client/addcustomercall")
	public String AddDistributerCall(@ModelAttribute Customer customer, @ModelAttribute LoginAccount loginAccount, Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		loginAccount.setRole("CUSTOMER");
		String originalPassword = loginAccount.getPassword();
		int msg = userService.save(loginAccount);
		
		if(msg==1){
		customerDao.save(customer);
		String messg = "Account successfully created";
		m.addAttribute("displayMssg",messg);
		}
		else
		{
			String messg= "Sorry the loginId already exists!";
			m.addAttribute("displayMssg",messg);
			return "addCustomer.jsp";
		}
		return "redirect:/client";
	}	
	
	
		
		@RequestMapping("/client/deletecustomercall")
		public String DeleteCustomerCall(@ModelAttribute LoginAccount loginAccount, Model m) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			loginAccount.setRole("ROLE_CUSTOMER");
			System.out.println(loginAccount.getLoginId());
			System.out.println(loginAccount.getRole());
			boolean boolValue=  loginAccountDao.check(loginAccount); 
			
			System.out.println(boolValue);
			System.out.println("dfew");
			if(boolValue==true){
				customerDao.delete(loginAccount.getLoginId());	
			loginAccountDao.delete(loginAccount.getLoginId());
			
			String messg = "Account successfully deleted";
			m.addAttribute("displayMssg",messg);
			}
			else
			{
				String messg= "Sorry the loginId does not exists!";
				m.addAttribute("displayMssg",messg);
				m.addAttribute("getallcustomers",customerDao.getAllCustomers());	
				return "deleteCustomer.jsp";
			}
			return "redirect:/client";
		}
		
		@RequestMapping("/customer/feedback")
		public String FeedbackCustomer(Model m) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			return "feedbackCustomer.jsp";
		}
		
		@RequestMapping("/client/viewcustomers")
		public String ViewCustomers(Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			m.addAttribute("getallcustomers",customerDao.getAllCustomers());	
			System.out.println(customerDao.getAllCustomers());
		return "seeCustomer.jsp"	;
		}
		
		
		@RequestMapping("/client/seecustomerbyname")
		public String SearchCustomers(@RequestParam String name, Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			m.addAttribute("loggedInUsername", securityService.findLoggedInUsername());
			m.addAttribute("getallcustomers",customerDao.getAllCustomers());	
			System.out.println(customerDao.getAllCustomers());
			m.addAttribute("getcustomersbyname",customerDao.getCustomersByName(name));
		return "seeCustomer.jsp"	;
		}
}
