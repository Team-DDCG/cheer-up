package com.service.spring.model;

import com.service.spring.domain.UserOverseasVO;

public interface UserOverseasDAO {
	
	int registerUserOverseas(UserOverseasVO vo) throws Exception;
	int deleteUserOverseas(int overseasId) throws Exception;
	int updateUserOverseas(UserOverseasVO vo) throws Exception;
	
	UserOverseasVO getUserOverseas(int id) throws Exception;


}
