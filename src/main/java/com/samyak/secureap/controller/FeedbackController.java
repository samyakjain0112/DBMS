package com.samyak.secureap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.CustomerDao;
import com.samyak.secureap.dao.FeedbackDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.StaffMemberDao;
import com.samyak.secureap.models.Feedback;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.models.Product;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class FeedbackController {

	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserService userService;
	
    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    FeedbackDao feedbackDao;
 
    @Autowired
    StaffMemberDao staffMemberDao;
    
    @Autowired
    CustomerDao customerDao;
    
	@RequestMapping("/customer/feedbackcall")
	public String CustomerFeedback(@ModelAttribute Feedback feedback, Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		int loggedInUsername=securityService.findLoggedInUsername();
		int customerId = customerDao.getcustomer(loggedInUsername);
		feedback.setCustomerId(customerId);
		feedbackDao.save(feedback);
		return "redirect:/customer";
	}	
	@RequestMapping("client/viewfeedback")
	public String ViewFeedback(Model m ) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallfeedbacks",feedbackDao.getAllFeedbacks());	
		System.out.println(feedbackDao.getAllFeedbacks());
	return "seeFeedback.jsp"	;
	}
	
	@RequestMapping("staffmember/viewfeedback")
	public String ViewFeedbackStaffMember(Model m ) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		int loginId = securityService.findLoggedInUsername();
		//int staffId = staffMemberDao.getStaffMemberId(loginId);
		m.addAttribute("getallfeedbacks",feedbackDao.getAllFeedbacks());	
		System.out.println(feedbackDao.getAllFeedbacks());
	return "seeFeeddbacksStaffMember.jsp"	;
	}
	
}
