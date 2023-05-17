package com.service.spring.model;

import com.service.spring.domain.UserActivationVO;

public interface UserActivationDAO {
	
	int registerUserActivation(UserActivationVO vo) throws Exception;
	int updateUserActivation(String activationId) throws Exception;
	int deleteUserActivation(UserActivationVO vo) throws Exception;
	
	UserActivationVO getUserActivation(String id) throws Exception;

}
