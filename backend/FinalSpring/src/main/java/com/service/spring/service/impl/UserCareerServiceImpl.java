package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserCareerVO;
import com.service.spring.model.UserCareerDAO;
import com.service.spring.service.UserCareerService;

@Service
public class UserCareerServiceImpl implements UserCareerService {
	@Autowired
	private UserCareerDAO userCareerDAO;
	
	@Override
	public int registerUserCareer(UserCareerVO vo) throws Exception {
		return userCareerDAO.registerUserCareer(vo);
	}

	@Override
	public int updateUserCareer(UserCareerVO vo) throws Exception {
		return userCareerDAO.updateUserCareer(vo);
	}

	@Override
	public int deleteUserCareer(int carrerId) throws Exception {
		return userCareerDAO.deleteUserCareer(carrerId);
	}

	@Override
	public UserCareerVO getUserCareer(int carrerId) throws Exception {
		return userCareerDAO.getUserCareer(carrerId);
	}

	@Override
	public List<UserCareerVO> getAllUserCareer(int seekerId) throws Exception {
		return userCareerDAO.getAllUserCareer(seekerId);
	}
	
}
