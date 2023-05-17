package com.service.spring.model;

import com.service.spring.domain.UserLicenseVO;

public interface UserLicenseDAO {
	
	int registerUserLicnse(UserLicenseVO vo) throws Exception;
	int deleteUserLicense(int id) throws Exception;
	int updateUserLicense(UserLicenseVO vo) throws Exception;
	
	UserLicenseVO getUserLicense(int id) throws Exception;


}
