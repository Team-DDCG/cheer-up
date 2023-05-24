package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.UserOverseasVO;

public interface UserOverseasService {
	int registerUserOverseas(UserOverseasVO vo) throws Exception;
	int deleteUserOverseas(int overseasId) throws Exception;
	int updateUserOverseas(UserOverseasVO vo) throws Exception;
	
	UserOverseasVO getUserOverseas(int id) throws Exception;
	List<UserOverseasVO> getAllUserOverseas(int seekerId) throws Exception;
}
