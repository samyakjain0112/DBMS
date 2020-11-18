package com.samyak.secureap.dao;

import java.util.List;

import com.samyak.secureap.models.Feedback;

public interface FeedbackDao {

	void save(Feedback feedback);
	List<Feedback> getAllFeedbacks();
	//List<Feedback> getAllFeedbacksStaffMember();
}
