package com.service.spring.service.impl;

import java.util.HashMap;
import java.util.Map;

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
	public int deleteUserInfo(int id) {
		return userInfoDAO.deleteUserInfo(id);
	}

	@Override
	public int updateUserInfo(UserInfoVO userInfo) {
		return userInfoDAO.updateUserInfo(userInfo);
	}

	@Override
	public UserInfoVO getUserInfo(int userId) {
		return userInfoDAO.getUserInfo(userId);
	}

	@Override
	public String findUserId(String name, String phone) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", name);
        paramMap.put("phone", phone);
		return userInfoDAO.findUserId(paramMap);
	}

	@Override
	public String findUserPassword(String name, String id, String email) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", name);
        paramMap.put("id", id);
        paramMap.put("email", email);
		return userInfoDAO.findUserPassword(paramMap);
	}

	@Override
	public UserInfoVO login(UserInfoVO userInfo) {
		return userInfoDAO.login(userInfo);
	}
	
	

}
