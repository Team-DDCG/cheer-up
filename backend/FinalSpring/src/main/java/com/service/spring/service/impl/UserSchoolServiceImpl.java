package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserSchoolVO;
import com.service.spring.model.UserSchoolDAO;
import com.service.spring.service.UserSchoolService;

@Service
public class UserSchoolServiceImpl implements UserSchoolService{
	@Autowired
	private UserSchoolDAO userSchoolDAO;
	
	@Override
	public int registerUserSchool(UserSchoolVO vo) throws Exception {
		return userSchoolDAO.registerUserSchool(vo);
	}

	@Override
	public int deleteUserSchool(int schoolId) throws Exception {
		return userSchoolDAO.deleteUserSchool(schoolId);
	}

	@Override
	public int updateUserSchool(UserSchoolVO vo) throws Exception {
		return userSchoolDAO.updateUserSchool(vo);
	}

	@Override
	public UserSchoolVO getUserSchool(int id) throws Exception {
		return userSchoolDAO.getUserSchool(id);
	}
	
}
