package com.samyak.secureap.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samyak.secureap.dao.AppointmentDao;
import com.samyak.secureap.dao.CustomerDao;
import com.samyak.secureap.dao.FacilitiesDao;
import com.samyak.secureap.dao.StaffMemberDao;
import com.samyak.secureap.models.Appointment;
import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.LoginAccount;
import com.samyak.secureap.service.SecurityService;
import com.samyak.secureap.service.UserService;

@Controller
public class AppointmentController {
    @Autowired
    CustomerDao customerDao;

    @Autowired
    AppointmentDao appointmentDao;
    
	@Autowired
	SecurityService securityService;
	
    
    @Autowired
    FacilitiesDao facilitiesDao;
    
    @Autowired
    StaffMemberDao staffMemberDao;
	
	@Autowired
	UserService userService; 
	@RequestMapping("/customer/makeappointment")
	public String MakeAppointment(@ModelAttribute Customer customer ,@ModelAttribute Appointment appointment, Model m ) 
	{			LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
	
	m.addAttribute("acc",loggedInAccount);
		appointment.setClientId(1);
		int loginId=securityService.findLoggedInUsername();
		int customerId = customerDao.getcustomer(loginId);
		appointment.setCustomerId(customerId);
		System.out.println(customerId);

		boolean boolValue = appointmentDao.check(appointment);
		if(boolValue==true) {
		appointmentDao.save(appointment);
		String succesfullAppointment="Appointment made successfully!";
		m.addAttribute("appoinment", succesfullAppointment);
		return "customer.jsp";
		}
		else {
			String unsuccesfullAppointment="Sorry slot is already full appointment cannot be made!";
			m.addAttribute("appoinment", unsuccesfullAppointment);
			return "appointment.jsp";
		}
		
	}
	@RequestMapping("/customer/viewappointment")
	public String ViewAppointment(Model m ) 
	{		 
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		int loginId=securityService.findLoggedInUsername();
		int customerId = customerDao.getcustomer(loginId);
		m.addAttribute("getallappointments",appointmentDao.getAllAppointment(customerId));	
		System.out.println("seeappointment");
		System.out.println(appointmentDao.getAllAppointment(customerId));
	return "seeappointment.jsp"	;
	}
	
	
	@RequestMapping("/staffmember/viewappointment")
	public String ViewAppointmentStaffMember(Model m ) 
	{	
		LoginAccount loggedInAccount=userService.findByUsername(securityService.findLoggedInUsername());
		
		m.addAttribute("acc",loggedInAccount);
		
		int loginId=securityService.findLoggedInUsername();
		System.out.println("Cdcdffer3ewed");
		int staffId = staffMemberDao.getStaffMemberId(loginId);
		System.out.println(staffId);
		
		int treatmentId = facilitiesDao.getTreatmentId(staffId);
		System.out.println(treatmentId);
		m.addAttribute("getallappointments",appointmentDao.getAllAppointmentTodaySatffId(treatmentId));	
		System.out.println("seeappointment");
		System.out.println(appointmentDao.getAllAppointmentTodaySatffId(treatmentId));
	return "seeStaffMemberAppointments.jsp"	;
	}
}
