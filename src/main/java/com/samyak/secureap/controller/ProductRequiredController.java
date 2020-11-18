package com.samyak.secureap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.ClientDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.ProductRequiredDao;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.models.ProductRequired;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class ProductRequiredController {

	@Autowired
	SecurityService securityService;

    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    ProductRequiredDao productRequiredDao;
    
    @Autowired
    ClientDao clientDao;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/client/addproductrequired")
	public String AddProductRequired(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		return "addProductRequired.jsp";
	}

	@RequestMapping("/client/deleteproductrequired")
	public String DeleteProductRequired(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallproducts",productRequiredDao.getAllProducts());	
		return "deleteProductRequired.jsp";
	}
	
	
	@RequestMapping("/client/addproductrequiredcall")
	public String AddProductRequiredCall(@ModelAttribute ProductRequired productrequired, Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		System.out.println("samsjhy");
		System.out.println(productrequired.getProductId());
		System.out.println(productrequired.getQuantity());
		productrequired.setClientId(1);
		int mssg=productRequiredDao.save(productrequired);
		if(mssg==1)
		{
		String messg = "Product successfully added";
		m.addAttribute("displayMssg",messg);
		}
		else
		{
			String messg= "Sorry the product already exists!";
			m.addAttribute("displayMssg",messg);
			return "addProductRequired.jsp";
		}
		return "redirect:/client";
	}	
	
	
		
		@RequestMapping("/client/deleteproductrequiredcall")
		public String DeleteProductRequiredCall(@ModelAttribute ProductRequired productrequired, Model m) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			productrequired.setClientId(1);
			boolean boolValue = productRequiredDao.check(productrequired);
			if(boolValue==true){
				productRequiredDao.delete(productrequired.getProductId());
			String messg = "Product successfully deleted";
			m.addAttribute("displayMssg",messg);
			}
			else
			{
				String messg= "Sorry Product not found!";
				m.addAttribute("displayMssg",messg);
				m.addAttribute("getallproducts",productRequiredDao.getAllProducts());	
				return "deleteProductRequired.jsp";
			}
			return "redirect:/client";
		}	
		
		@RequestMapping("/client/seeproductrequired")
		public String ViewProduct(Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			
			m.addAttribute("getallproducts",productRequiredDao.getAllProducts());	
			System.out.println(productRequiredDao.getAllProducts());
		return "seeProductRequired.jsp"	;
		}
		
		@RequestMapping("/distributer/seeproductrequired")
		public String ViewProductDistributer(Model m ) 
		{
			
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			m.addAttribute("getallproducts",productRequiredDao.getAllProducts());	
			System.out.println(productRequiredDao.getAllProducts());
		return "seeProductRequired.jsp"	;
		}
		
}
