package com.samyak.secureap.dao;

import java.sql.Date;
import java.util.List;

import com.samyak.secureap.models.Appointment;
import com.samyak.secureap.models.StaffMember;

public interface AppointmentDao {
	void save(Appointment appointment);
	List<Appointment> getAllAppointment(int customerId);
	List<Appointment> getTodayAppointmentClient(Date date);
	boolean check(Appointment appointment);
	List<Appointment> getAllAppointmentTodaySatffId(int treatmentId);
	List<Appointment> getAllAppointmentPast(int customerId);
	List<Appointment> getAllAppointmentToday(int staffId);
 }
