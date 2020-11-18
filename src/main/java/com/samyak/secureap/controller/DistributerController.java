package com.samyak.secureap.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.ClientDao;
import com.samyak.secureap.dao.DistributerDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.ProductDao;
import com.samyak.secureap.models.Distributer;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class DistributerController {
	@Autowired
	SecurityService securityService;
	
    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    DistributerDao distributerDao;
    
    @Autowired
    ProductDao productDao;

    @Autowired
    ClientDao clientDao;
	@Autowired
	UserService userService;
	
	@RequestMapping("/distributer")
	public String Distributer(Model m) {
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		System.out.println(15);
		System.out.println(securityService.findLoggedInUsername());
		m.addAttribute("loggedInUsername", securityService.findLoggedInUsername());
		return "distributer.jsp";
	}
	
	@RequestMapping("/distributer/profile/{loginId}")
	public String DistributerProfile(@PathVariable int loginId, Model m) 
	{			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
	
	m.addAttribute("acc",loggedInAccount);
	
		LoginAccount loginAccount = userService.findByUsername(loginId);
		
		System.out.println("distribute");
		m.addAttribute("distributerDetails",distributerDao.getAllDetailsDistributer(loginId));
		System.out.println("Distributer");
		return "distributerProfile.jsp";
	}
	
	
	@RequestMapping("/client/adddistributer")
	public String AddDistributer(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		return "addDistributer.jsp";
	}

	@RequestMapping("/client/deletedistributer")
	public String DeleteDistributer(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getalldistributers",distributerDao.getAllDistributers());	
		return "deleteDistributer.jsp";
	}
	
	
	@RequestMapping("/client/adddistributercall")
	public String AddDistributerCall(@ModelAttribute Distributer distributer, @ModelAttribute LoginAccount loginAccount, Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		loginAccount.setRole("DISTRIBUTER");
		String originalPassword = loginAccount.getPassword();
		int msg = userService.save(loginAccount);
		
		if(msg==1){
		distributerDao.save(distributer);
		String messg = "Account successfully created";
		m.addAttribute("displayMssg",messg);
		}
		else
		{
			String messg= "Sorry the loginId already exists!";
			m.addAttribute("displayMssg",messg);
			return "addDistributer.jsp";
		}
		return "redirect:/client";
	}
	@RequestMapping("client/viewdistributers")
	public String ViewDistributers(Model m ) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getalldistributers",distributerDao.getAllDistributers());	
		System.out.println(distributerDao.getAllDistributers());
	return "seeDistributer.jsp"	;
	}
	
	
		
		@RequestMapping("/client/deletedistributercall")
		public String DeleteDistributerCall(@ModelAttribute LoginAccount loginAccount, Model m) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			loginAccount.setRole("ROLE_DISTRIBUTER");
			System.out.println(loginAccount.getLoginId());
			System.out.println(loginAccount.getRole());
			boolean boolValue=  loginAccountDao.check(loginAccount); 
			
			System.out.println(boolValue);
			System.out.println("sddfe");
			if(boolValue==true){
				
			loginAccountDao.delete(loginAccount.getLoginId());
			distributerDao.delete(loginAccount.getLoginId());
			String messg = "Account successfully deleted";
			m.addAttribute("displayMssg",messg);
			}
			else
			{
				String messg= "Sorry the loginId does not exists!";
				m.addAttribute("displayMssg",messg);
				m.addAttribute("getalldistributers",distributerDao.getAllDistributers());	
				return "deleteDistributer.jsp";
			}
			return "redirect:/client";
		}
		
		
		@RequestMapping("/client/distributeralldetails/{distributerId}")
		public String CustomerAllDetails(@PathVariable int distributerId, Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			m.addAttribute("loggedInUsername", distributerId);
			//int loginId=securityService.findLoggedInUsername();
			m.addAttribute("getallproductsdistributer",productDao.getAllProductsByDistributerId(distributerId));	
		return "allDetailsDistributer.jsp"	;
		}
}
