package com.service.spring.service;

import com.service.spring.domain.UserCareerVO;

public interface UserCareerService {
	int registerUserCareer(UserCareerVO vo) throws Exception;
	int updateUserCareer(UserCareerVO vo) throws Exception;
	int deleteUserCareer(int careerId) throws Exception;
	
	UserCareerVO getUserCareer(int id) throws Exception;
}
