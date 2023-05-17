package com.service.spring.model;

import com.service.spring.domain.UserSchoolVO;

public interface UserSchoolDAO {
	
	int registerUserSchool(UserSchoolVO vo) throws Exception;
	int updateUserSchool(String schoolId) throws Exception;
	int deleteUserSchool(UserSchoolVO vo) throws Exception;
	
	UserSchoolVO getUserSchool(String id) throws Exception;

}
