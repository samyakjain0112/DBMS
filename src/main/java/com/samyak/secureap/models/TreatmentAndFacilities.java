package com.samyak.secureap.models;

import java.sql.Time;

public class TreatmentAndFacilities {

	private String name;
	private int cost;
	private int treatmentId;
	private int staffId;
	private int timeRequired;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getTimeRequired() {
		return timeRequired;
	}
	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
	}
	
}