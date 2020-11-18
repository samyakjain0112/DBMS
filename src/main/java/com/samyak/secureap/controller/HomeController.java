package com.samyak.secureap.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samyak.secureap.dao.CustomerDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.models.Register;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;



@Controller
public class HomeController {
    @Autowired
    CustomerDao customerDao;

	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserService userService;
    @Autowired
    LoginAccountDao loginAccountDao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		
		int loggedInUsername=securityService.findLoggedInUsername();
		m.addAttribute("loggedInUsername",securityService.findLoggedInUsername());
		if (loggedInUsername!=0) {
			return "redirect:/welcome";
		}
		return "home.jsp";
		
	}
	
	@RequestMapping("/login")
	public String login(Model m) 
	{	
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		int loggedInUsername=securityService.findLoggedInUsername();
		m.addAttribute("loggedInUsername",securityService.findLoggedInUsername());
		if (loggedInUsername!=0) {
			return "redirect:/welcome";
	}
		System.out.println("samyak");
		return "login.jsp";
	}
	
	
	@RequestMapping("/offers")
	public String offers(Model m) 
	{			
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		System.out.println("samyak");
		return "offers.jsp";
	}
	
	@RequestMapping("/gallery")
	public String gallary(Model m) 
	{			
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		System.out.println("samyak");
		return "gallary.jsp";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model m) 
	{	
		
		//returns according to the roles
		//LoginAccount loginAccount = new LoginAccount(acc)
		System.out.println(1);
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		System.out.println(loggedInAccount.getRole());
		//boolean boolValue = loginAccountDao.check(acc);
	    //System.out.println(boolValue);

		//if(boolValue ==true) {
			if(loggedInAccount.getRole().equals("ROLE_CLIENT"))
			{
				return "redirect:/client";
			}
			else if(loggedInAccount.getRole().equals("ROLE_CUSTOMER"))
			{
				return "redirect:/customer";
			}
			else if(loggedInAccount.getRole().equals("ROLE_DISTRIBUTER"))
			{
				return "redirect:/distributer";
			}
			else
			{
				return "redirect:/staffmember";
			}
		//}
	}
	
	@RequestMapping("/checklogin")
	public String checkLogin(@ModelAttribute LoginAccount loginAccount, Model m) {
		System.out.println("cbxkbcx");
		securityService.autoLogin(String.valueOf(loginAccount.getLoginId()), loginAccount.getPassword());
		int loggedInUsername=securityService.findLoggedInUsername();
		System.out.println("dgbfgb");
		System.out.println(loggedInUsername);
		if (loggedInUsername==0) {
			
			return "redirect:/login-error";
		}
		return "redirect:/welcome";
	}
	
	@RequestMapping("/register")
	public String register(Model m) 
	{	int loggedInUsername=securityService.findLoggedInUsername();
	LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
	
	m.addAttribute("acc",loggedInAccount);
		if (loggedInUsername!=0) {
		return "redirect:/welcome";
	}
		return "register.jsp";
	}
	
	@RequestMapping("/addcustomer")
	public String addcustomer(@ModelAttribute Customer customer, @ModelAttribute LoginAccount loginAccount, Model m) 
	
	{   System.out.println("Samyak Jain");
	LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
	
	m.addAttribute("acc",loggedInAccount);
		//Customer customer=new Customer(2,name,contact,id,address,dob);
	
		//LoginAccount loginAccount = new LoginAccount(id,password,"CUSTOMER");
		//loginAccountDao.save(loginAccount);
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
			return "register.jsp";
		}
		
		//enter data into dao
		//call login controller
		//System.out.println(String.valueOf(loginAccount.getLoginId()));
		//System.out.println(loginAccount.getPassword());
		securityService.autoLogin(String.valueOf(loginAccount.getLoginId()), originalPassword);
		//System.out.println(securityService.findLoggedInUsername());
		System.out.println("ishtmeet");
		 
		return "redirect:/welcome";
	}
	@RequestMapping("/login-error")
	public String checkerLogin(@ModelAttribute LoginAccount loginAccount, Model m, RedirectAttributes redirectAttributes) {
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		redirectAttributes.addFlashAttribute("error", "Bad Credentials!");
		System.out.println("Login-error");
		return "redirect:/login";
	}
	
}
