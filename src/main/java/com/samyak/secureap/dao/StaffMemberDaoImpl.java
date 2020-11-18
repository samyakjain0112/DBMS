package com.samyak.secureap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samyak.secureap.models.Customer;
import com.samyak.secureap.models.Distributer;
import com.samyak.secureap.models.Feedback;
import com.samyak.secureap.models.StaffMember;
import com.samyak.secureap.models.TreatmentAndFacilities;

	@Repository
	public class StaffMemberDaoImpl implements StaffMemberDao {

		public StaffMemberDaoImpl() {
			// TODO Auto-generated constructor stub
		}
		@Autowired
		JdbcTemplate jdbcTemplate;
		@Override
		public StaffMember getAllDetailsStaffMember(int loginId ) {
			
			//customer.setRole("ROLE_"+ loginAccount.getRole());
			String sql = "select * from StaffMember where loginId=?";
			StaffMember staffMember = (StaffMember) jdbcTemplate.queryForObject(sql, new Object[] { loginId},
					new BeanPropertyRowMapper<>(StaffMember.class));
			return staffMember;
		}
		
		
		@Override
		public void save(StaffMember staffMember) {
			
			//customer.setRole("ROLE_"+ loginAccount.getRole());
			String sql = "insert into StaffMember (name,contact,loginId,salary,address,workingHours) values( ?,?,?,?,?,?)";
			jdbcTemplate.update(sql,staffMember.getName(),
					staffMember.getContact(),staffMember.getLoginId(), staffMember.getSalary(), staffMember.getAddress(), staffMember.getWorkingHours() );
		}
		
		@Override
		public void delete(int loginId) {
			
			//customer.setRole("ROLE_"+ loginAccount.getRole());
			String sql = "Delete from StaffMember where loginId=?";
			jdbcTemplate.update(sql,loginId );
		}	
		
		@Override
		public int getStaffMemberId(int loginId) {
			
			//customer.setRole("ROLE_"+ loginAccount.getRole());
			String sql = "select * from StaffMember where loginId=?";
			StaffMember staff = (StaffMember) jdbcTemplate.queryForObject(sql, new Object[] { loginId},
					new BeanPropertyRowMapper<>(StaffMember.class));
			return staff.getStaffId();
		}
		
		
		@Override
	    public List<StaffMember> getAllStaffMembers(){
	        String sql="select * from StaffMember";
	        return jdbcTemplate.query(sql,
	        new BeanPropertyRowMapper<>(StaffMember.class));
	    }
}
