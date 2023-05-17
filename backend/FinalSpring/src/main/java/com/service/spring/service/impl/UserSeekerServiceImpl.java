package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserSeekerVO;
import com.service.spring.model.UserSeekerDAO;
import com.service.spring.service.UserSeekerService;

@Service
public class UserSeekerServiceImpl implements UserSeekerService {
	@Autowired
	private UserSeekerDAO userSeekerDAO;

	@Override
	public int registerUserSeeker(UserSeekerVO vo) throws Exception {
		return userSeekerDAO.registerUserSeeker(vo);
	}

	@Override
	public int deleteUserSeeker(int id) throws Exception {
		return userSeekerDAO.deleteUserSeeker(id);
	}

	@Override
	public int updateUserSeeker(UserSeekerVO vo) throws Exception {
		return userSeekerDAO.updateUserSeeker(vo);
	}

	@Override
	public UserSeekerVO getUserSeeker(int id) throws Exception {
		return userSeekerDAO.getUserSeeker(id);
	}
	
	
}
