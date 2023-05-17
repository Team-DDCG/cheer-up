package com.service.spring.model;

import com.service.spring.domain.UserOverseasVO;

public interface UserOverseasDAO {
	
	int registerUserOverseas(UserOverseasVO vo) throws Exception;
	int updateUserOverseas(String overseasId) throws Exception;
	int deleteUserOverseas(UserOverseasVO vo) throws Exception;
	
	UserOverseasVO getUserOverseas(String id) throws Exception;


}
