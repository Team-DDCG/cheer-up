package com.service.spring.model;

import com.service.spring.domain.UserInfoVO;

public interface UserInfoDAO {
	UserInfoVO login(UserInfoVO vo) throws Exception;
	
	int registerUserInfo(UserInfoVO vo) throws Exception;
	int deleteUserUserInfo(String id) throws Exception;
	int updateUserInfo(UserInfoVO vo) throws Exception;
	
	UserInfoVO getUserInfo(String id) throws Exception;


}
