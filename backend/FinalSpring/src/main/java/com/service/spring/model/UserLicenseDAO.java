package com.service.spring.model;

import com.service.spring.domain.UserCareerVO;
import com.service.spring.domain.UserLicenseVO;

public interface UserLicenseDAO {
	
	int registerUserLicnse(UserLicenseVO vo) throws Exception;
	int updateUserLicense(String licenseId) throws Exception;
	int deleteUserLicense(UserLicenseVO vo) throws Exception;
	
	UserCareerVO getUserLicense(String id) throws Exception;


}
