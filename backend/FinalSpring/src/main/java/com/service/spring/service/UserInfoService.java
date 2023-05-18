package com.service.spring.service;

import com.service.spring.domain.UserInfoVO;

public interface UserInfoService {
	int registerUserInfo(UserInfoVO userInfo);
    int deleteUserInfo(String id);
    int updateUserInfo(UserInfoVO userInfo);
    UserInfoVO getUserInfo(String id);
    String findUserId(String name, String phone);
    UserInfoVO findUserPassword(String name, String id, String email);
    UserInfoVO login(UserInfoVO userInfo);
}
