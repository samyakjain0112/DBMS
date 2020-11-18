package com.samyak.secureap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.ClientDao;
import com.samyak.secureap.dao.FacilitiesDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.ProductDao;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.models.Product;
import com.samyak.secureap.models.TreatmentAndFacilities;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;


@Controller
public class FacilitiesController {

	@Autowired
	SecurityService securityService;

    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    FacilitiesDao facilitiesDao;
    
    @Autowired
    ClientDao clientDao;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/client/addfacilities")
	public String AddFacilities(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		return "addFacilities.jsp";
	}

	@RequestMapping("/client/deletefacilities")
	public String DeleteFacilities(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallfacilities",facilitiesDao.getAllFacilities());	
		return "deleteFacilities.jsp";
	}
	
	
	@RequestMapping("/client/addfacilitiescall")
	public String AddProductCall(@ModelAttribute TreatmentAndFacilities facilities, Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		

		int mssg=facilitiesDao.save(facilities);
		if(mssg==1)
		{
		String messg = "Product successfully added";
		m.addAttribute("displayMssg",messg);
		}
		else
		{
			String messg= "Sorry the product already exists!";
			m.addAttribute("displayMssg",messg);
			return "addFacilities.jsp";
		}
		return "redirect:/client";
	}
		
		@RequestMapping("/client/deletefacilitiescall")
		public String DeleteProductCall(@ModelAttribute TreatmentAndFacilities facilities, Model m) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			boolean boolValue = facilitiesDao.check(facilities);
			System.out.println(facilities.getTreatmentId());
			System.out.println("boolValue");
			System.out.println(boolValue);
			if(boolValue==true){
				facilitiesDao.delete(facilities.getTreatmentId());
			String messg = "Product successfully deleted";
			m.addAttribute("displayMssg",messg);
			}
			else
			{
				String messg= "Sorry Facility/Treatment not found!";
				m.addAttribute("displayMssg",messg);
				m.addAttribute("getallfacilities",facilitiesDao.getAllFacilities());	
				return "deleteFacilities.jsp";
			}
			return "redirect:/client";
		}
		
		@RequestMapping("/customer/seefacilities")
		public String ViewFacilitiest(Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			
			m.addAttribute("getallfacilities",facilitiesDao.getAllFacilities());	
			System.out.println(facilitiesDao.getAllFacilities());
		return "seeFacilities.jsp"	;
		}
}
