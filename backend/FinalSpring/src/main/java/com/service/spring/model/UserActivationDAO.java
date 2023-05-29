package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.UserActivationVO;

public interface UserActivationDAO {
	int registerUserActivation(UserActivationVO userActivationVO);
    
    int deleteUserActivation(int activationId);
    
    int updateUserActivation(UserActivationVO userActivationVO);
    
    UserActivationVO getActivationDetail(int activationId);
    List<UserActivationVO> getAllActivationById(int seekerId);
    int getActivationNumber(int seekerId);
}
