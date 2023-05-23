package com.service.spring.service;

import com.service.spring.domain.UserInfoVO;

public interface UserInfoService {
	int registerUserInfo(UserInfoVO userInfo);
    int deleteUserInfo(int userId);
    int updateUserInfo(UserInfoVO userInfo);
    UserInfoVO getUserInfo(int userId);
    String findUserId(String name, String phone);
    String findUserPassword(String name, String id, String email);
    UserInfoVO login(UserInfoVO userInfo);
}
