package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserMentorVO;
import com.service.spring.model.UserMentorDAO;
import com.service.spring.service.UserMentorService;

@Service
public class UserMentorServiceImpl implements UserMentorService{
	@Autowired
	private UserMentorDAO userMentorDAO;
	
	@Override
	public int registerUserMentor(UserMentorVO vo) throws Exception {
		return userMentorDAO.registerUserMentor(vo);
	}

	@Override
	public int deleteUserMentor(int id) throws Exception {
		return userMentorDAO.deleteUserMentor(id);
	}

	@Override
	public int updateUserMentor(UserMentorVO vo) throws Exception {
		return userMentorDAO.updateUserMentor(vo);
	}

	@Override
	public UserMentorVO getUserMentor(int id) throws Exception {
		return userMentorDAO.getUserMentor(id);
	}
	
}
