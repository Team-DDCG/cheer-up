package com.service.spring.model;

import com.service.spring.domain.UserInfoVO;

public interface UserInfoDAO {
	UserInfoVO login(UserInfoVO vo) throws Exception;


}
