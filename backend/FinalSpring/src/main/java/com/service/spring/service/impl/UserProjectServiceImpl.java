package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserProjectVO;
import com.service.spring.model.UserProjectDAO;
import com.service.spring.service.UserProjectService;


@Service
public class UserProjectServiceImpl implements UserProjectService {
	@Autowired
	UserProjectDAO userProjectDAO;

	@Override
	public int registerUserProject(UserProjectVO vo) throws Exception {
		return userProjectDAO.registerUserProject(vo);
	}

	@Override
	public int deleteUserProject(int id) throws Exception {
		return userProjectDAO.deleteUserProject(id);
	}

	@Override
	public int updateUserProject(UserProjectVO vo) throws Exception {
		return userProjectDAO.updateUserProject(vo);
	}

	@Override
	public UserProjectVO getUserProject(int id) throws Exception {
		return userProjectDAO.getUserProject(id);
	}

	@Override
	public List<UserProjectVO> getAllUserProject(int seekerId) throws Exception {
		return userProjectDAO.getAllUserProject(seekerId);
	}
	
}
