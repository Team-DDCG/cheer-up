package com.service.spring.model;

import java.util.Map;

import com.service.spring.domain.UserInfoVO;

public interface UserInfoDAO {
	int registerUserInfo(UserInfoVO userInfo);
    int deleteUserInfo(int id);
    int updateUserInfo(UserInfoVO userInfo);
    UserInfoVO getUserInfo(int userId);
    String findUserId(Map<String, Object> paramMap);
    String findUserPassword(Map<String, Object> paramMap);
    UserInfoVO login(UserInfoVO userInfo);
}
