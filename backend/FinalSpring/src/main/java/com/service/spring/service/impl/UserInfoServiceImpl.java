package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserInfoVO;
import com.service.spring.model.UserInfoDAO;
import com.service.spring.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public int registerUserInfo(UserInfoVO userInfo) {
		return userInfoDAO.registerUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String id) {
		return userInfoDAO.deleteUserInfo(id);
	}

	@Override
	public int updateUserInfo(UserInfoVO userInfo) {
		return userInfoDAO.updateUserInfo(userInfo);
	}

	@Override
	public UserInfoVO getUserInfo(String id) {
		return userInfoDAO.getUserInfo(id);
	}

	@Override
	public String findUserId(String name, String phone) {
		return userInfoDAO.findUserId(name, phone);
	}

	@Override
	public UserInfoVO findUserPassword(String name, String id, String email) {
		return userInfoDAO.findUserPassword(name, id, email);
	}

	@Override
	public UserInfoVO login(UserInfoVO userInfo) {
		return userInfoDAO.login(userInfo);
	}
	
	

}
