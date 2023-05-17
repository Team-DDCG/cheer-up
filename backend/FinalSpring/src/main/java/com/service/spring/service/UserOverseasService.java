package com.service.spring.service;

import com.service.spring.domain.UserOverseasVO;

public interface UserOverseasService {
	
	int registerUserOverseas(UserOverseasVO vo) throws Exception;
	int deleteUserOverseas(int overseasId) throws Exception;
	int updateUserOverseas(UserOverseasVO vo) throws Exception;
	
	UserOverseasVO getUserOverseas(int id) throws Exception;


}
