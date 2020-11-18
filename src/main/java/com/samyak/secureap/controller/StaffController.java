package com.samyak.secureap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samyak.secureap.dao.AppointmentDao;
import com.samyak.secureap.dao.FacilitiesDao;
import com.samyak.secureap.dao.LoginAccountDao;
import com.samyak.secureap.dao.StaffMemberDao;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class StaffController {

	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserService userService;
	
    @Autowired
    LoginAccountDao loginAccountDao;
    
    @Autowired
    AppointmentDao appointmentDao;
    
    @Autowired
    StaffMemberDao staffMemberDao;
    
    @Autowired
    FacilitiesDao facilitiesDao;
	
	@RequestMapping("/staffmember")
	public String StaffMember(Model m) {
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		System.out.println(securityService.findLoggedInUsername());
		m.addAttribute("loggedInUsername", securityService.findLoggedInUsername());
		return "staffmember.jsp";
	}
	
	@RequestMapping("/staffmember/profile/{loginId}")
	public String StaffMemberProfile(@PathVariable int loginId, Model m) 
	{			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
	
	m.addAttribute("acc",loggedInAccount);
	
		LoginAccount loginAccount = userService.findByUsername(loginId);
		System.out.println("staff");
		m.addAttribute("staffMemberDetails",staffMemberDao.getAllDetailsStaffMember(loginId));
		System.out.println("StaffMember");
		return "staffMemberProfile.jsp";
	}
	
	
	@RequestMapping("/client/addstaffmember")
	public String AddStaffMember(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		return "addStaffMember.jsp";
	}

	@RequestMapping("/client/deletestaffmember")
	public String DeleteDistributer(Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		m.addAttribute("getallstaffmembers",staffMemberDao.getAllStaffMembers());
		return "deleteStaffMember.jsp";
	}
	
	
	@RequestMapping("/client/addstaffmembercall")
	public String AddStaffMemberCall(@ModelAttribute com.samyak.secureap.models.StaffMember staffmember, @ModelAttribute LoginAccount loginAccount, Model m) 
	{
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		loginAccount.setRole("STAFF");
		String originalPassword = loginAccount.getPassword();
		int msg = userService.save(loginAccount);
		System.out.println("sdfh");
		System.out.println(msg);
		if(msg==1){
		staffMemberDao.save(staffmember);
		String messg = "Account successfully created";
		m.addAttribute("displayMssg",messg);
		}
		else
		{
			String messg= "Sorry the loginId already exists!";
			m.addAttribute("displayMssg",messg);
			return "addStaffMember.jsp";
		}
		return "redirect:/client";
	}	
	
	
		
		@RequestMapping("/client/deletestaffmembercall")
		public String DeleteStaffMemberCall(@ModelAttribute LoginAccount loginAccount, Model m) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			loginAccount.setRole("ROLE_STAFF");
			System.out.println(loginAccount.getLoginId());
			System.out.println(loginAccount.getRole());
			boolean boolValue=  loginAccountDao.check(loginAccount); 
			
			System.out.println(boolValue);
			System.out.println("sddfe");
			if(boolValue==true){
				
			staffMemberDao.delete(loginAccount.getLoginId());	
			loginAccountDao.delete(loginAccount.getLoginId());
			
			String messg = "Account successfully deleted";
			m.addAttribute("displayMssg",messg);
			}
			else
			{
				String messg= "Sorry the loginId does not exists!";
				m.addAttribute("displayMssg",messg);
				m.addAttribute("getallstaffmembers",staffMemberDao.getAllStaffMembers());
				return "deleteStaffMember.jsp";
			}
			return "redirect:/client";
		}
		
		@RequestMapping("client/viewstaffmembers")
		public String ViewStaffMembers(Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			m.addAttribute("getallstaffmembers",staffMemberDao.getAllStaffMembers());	
			System.out.println(staffMemberDao.getAllStaffMembers());
		return "seeStaffMember.jsp"	;
		}
		
		@RequestMapping("/client/staffmemberalldetails/{staffId}")
		public String StaffMemberAllDetails(@PathVariable int staffId, Model m ) 
		{
			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
			
			m.addAttribute("acc",loggedInAccount);
			
			m.addAttribute("loggedInUsername", staffId);
			int treatmentId = facilitiesDao.getTreatmentId(staffId);
			if(treatmentId==0)
			{
				String messg= "Staff Member has not been assignment any treatment id";
				m.addAttribute("err",messg);
				return "seeStaffMember.jsp";
			}
			
			m.addAttribute("getallappointments",appointmentDao.getAllAppointmentTodaySatffId(treatmentId));	
			System.out.println("vdfjvbdge");
			System.out.println(appointmentDao.getAllAppointmentTodaySatffId(treatmentId));		
		return "allDetailsStaffMember.jsp"	;
		}
}

