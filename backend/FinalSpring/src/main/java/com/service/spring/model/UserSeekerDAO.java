package com.service.spring.model;

import com.service.spring.domain.UserSeekerVO;

public interface UserSeekerDAO {
	
	int registerUserSeeker(UserSeekerVO vo) throws Exception;
	int updateUserSeeker(String schoolId) throws Exception;
	int deleteUserSeeker(UserSeekerVO vo) throws Exception;
	
	UserSeekerVO getUserSeeker(String id) throws Exception;

}
