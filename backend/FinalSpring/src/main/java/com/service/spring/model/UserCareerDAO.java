package com.service.spring.model;

import com.service.spring.domain.UserCareerVO;

public interface UserCareerDAO {
	
	int registerUserCareer(UserCareerVO vo) throws Exception;
	int updateUserCareer(String careerId) throws Exception;
	int deleteUserCareer(UserCareerVO vo) throws Exception;
	
	UserCareerVO getUserCareer(String id) throws Exception;

}
