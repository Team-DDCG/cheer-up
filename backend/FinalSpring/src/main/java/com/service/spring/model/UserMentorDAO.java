package com.service.spring.model;

import com.service.spring.domain.UserMentorVO;

public interface UserMentorDAO {
	
	int registerUserMentor(UserMentorVO vo) throws Exception;
	int updateUserMentor(String mentorId) throws Exception;
	int deleteUserMentor(UserMentorVO vo) throws Exception;
	
	UserMentorVO getUserMentor(String id) throws Exception;

}
