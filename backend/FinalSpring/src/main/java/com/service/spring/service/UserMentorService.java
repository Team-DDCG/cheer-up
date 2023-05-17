package com.service.spring.service;

import com.service.spring.domain.UserMentorVO;

public interface UserMentorService {
	
	int registerUserMentor(UserMentorVO vo) throws Exception;
	int deleteUserMentor(int id) throws Exception;
	int updateUserMentor(UserMentorVO vo) throws Exception;
	
	UserMentorVO getUserMentor(int id) throws Exception;

}
