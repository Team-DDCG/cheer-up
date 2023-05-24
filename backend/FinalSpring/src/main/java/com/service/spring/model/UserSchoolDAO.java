package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.UserSchoolVO;

public interface UserSchoolDAO {
	
	int registerUserSchool(UserSchoolVO vo) throws Exception;
	int deleteUserSchool(int schoolId) throws Exception;
	int updateUserSchool(UserSchoolVO vo) throws Exception;
	
	UserSchoolVO getUserSchool(int id) throws Exception;
	List<UserSchoolVO> getAllUserSchool(int seekerId) throws Exception;
}
