package com.samyak.secureap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.ClientDao;
import com.samyak.secureap.dao.DistributerDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.ProductDao;
import com.samyak.secureap.models.Distributer;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.models.Product;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class ProductController {

	@Autowired
	SecurityService securityService;

    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    ProductDao productDao;
    
    @Autowired
    ClientDao clientDao;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/client/addproduct")
	public String AddProduct(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		return "addProduct.jsp";
	}

	@RequestMapping("/client/deleteproduct")
	public String DeleteProduct(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallproducts",productDao.getAllProducts());	
		return "deleteProduct.jsp";
	}
	
	
	@RequestMapping("/client/addproductcall")
	public String AddProductCall(@ModelAttribute Product product, Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		product.setClientId(1);
		product.setCustomerId(1);
		int mssg=productDao.save(product);
		if(mssg==1)
		{
		String messg = "Product successfully added";
		m.addAttribute("displayMssg",messg);
		}
		else
		{
			String messg= "Sorry the product already exists!";
			m.addAttribute("displayMssg",messg);
			return "addProduct.jsp";
		}
		return "redirect:/client";
	}	
	
	
		
		@RequestMapping("/client/deleteproductcall")
		public String DeleteProductCall(@ModelAttribute Product product, Model m) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			product.setClientId(1);
			boolean boolValue = productDao.check(product);
			if(boolValue==true){
				productDao.delete(product.getProductId());
			String messg = "Product successfully deleted";
			m.addAttribute("displayMssg",messg);
			}
			else
			{
				String messg= "Sorry Product not found!";
				m.addAttribute("displayMssg",messg);
				m.addAttribute("getallproducts",productDao.getAllProducts());	
				return "deleteProduct.jsp";
			}
			return "redirect:/client";
		}	
		
		@RequestMapping("customer/viewproducts")
		public String ViewProduct(Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			
			m.addAttribute("getallproducts",productDao.getAllProducts());	
			System.out.println(productDao.getAllProducts());
		return "seeProducts.jsp"	;
		}
		
}
