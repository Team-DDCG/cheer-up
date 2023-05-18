package com.service.spring.model;

import com.service.spring.domain.UserInfoVO;

public interface UserInfoDAO {
	int registerUserInfo(UserInfoVO userInfo);
    int deleteUserInfo(String id);
    int updateUserInfo(UserInfoVO userInfo);
    UserInfoVO getUserInfo(String id);
    String findUserId(String name, String phone);
    UserInfoVO findUserPassword(String name, String id, String email);
    UserInfoVO login(UserInfoVO userInfo);
}
