package com.service.spring.service;

import com.service.spring.domain.UserSeekerVO;

public interface UserSeekerService {
	
	int registerUserSeeker(UserSeekerVO vo) throws Exception;
	int deleteUserSeeker(int id) throws Exception;
	int updateUserSeeker(UserSeekerVO vo) throws Exception;
	
	UserSeekerVO getUserSeeker(int userId) throws Exception;

}
