package com.service.spring.impl;

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
	public UserInfoVO login(UserInfoVO vo) throws Exception {
		return userInfoDAO.login(vo);
	}

}
