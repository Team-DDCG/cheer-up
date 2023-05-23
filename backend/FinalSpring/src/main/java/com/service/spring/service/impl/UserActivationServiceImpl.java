package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserActivationVO;
import com.service.spring.model.UserActivationDAO;
import com.service.spring.service.UserActivationService;

@Service
public class UserActivationServiceImpl implements UserActivationService{
	
	@Autowired
	private UserActivationDAO userActivationDAO;

	@Override
	public int registerUserActivation(UserActivationVO userActivationVO) {
		return userActivationDAO.registerUserActivation(userActivationVO);
	}

	@Override
	public int deleteUserActivation(int activationId) {
		return userActivationDAO.deleteUserActivation(activationId);
	}

	@Override
	public int updateUserActivation(UserActivationVO userActivationVO) {
		return userActivationDAO.updateUserActivation(userActivationVO);
	}

	@Override
	public UserActivationVO getActivationDetail(int activationId) {
		return userActivationDAO.getActivationDetail(activationId);
	}

	@Override
	public List<UserActivationVO> getAllActivationById(int seekerId) {
		return userActivationDAO.getAllActivationById(seekerId); 
	}

}
