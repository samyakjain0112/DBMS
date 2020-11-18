package com.samyak.secureap.dao;

import java.util.List;

import com.samyak.secureap.models.StaffMember;

public interface StaffMemberDao {
	StaffMember getAllDetailsStaffMember(int loginId);
	void save(StaffMember staffMember);
	void delete(int loginId);
	List<StaffMember> getAllStaffMembers();
	int getStaffMemberId(int loginId);
	
	
}
