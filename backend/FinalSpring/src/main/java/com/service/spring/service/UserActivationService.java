package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.UserActivationVO;

public interface UserActivationService {
	int registerUserActivation(UserActivationVO userActivationVO);
    
    int deleteUserActivation(int activationId);
    
    int updateUserActivation(UserActivationVO userActivationVO);
    
    UserActivationVO getActivationDetail(int activationId);
    List<UserActivationVO> getAllActivationById(int seekerId);
}
