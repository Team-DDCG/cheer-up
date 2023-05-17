package com.service.spring.service;

import com.service.spring.domain.UserLicenseVO;

public interface UserLicenseService {
	
	int registerUserLicnse(UserLicenseVO vo) throws Exception;
	int deleteUserLicense(int id) throws Exception;
	int updateUserLicense(UserLicenseVO vo) throws Exception;
	
	UserLicenseVO getUserLicense(int id) throws Exception;


}
