package com.service.spring.service;

import com.service.spring.domain.UserInfoVO;

public interface UserInfoService {
	UserInfoVO login(UserInfoVO vo) throws Exception;
}
