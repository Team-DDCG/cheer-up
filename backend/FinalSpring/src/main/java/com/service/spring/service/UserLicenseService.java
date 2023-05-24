package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.UserLicenseVO;

public interface UserLicenseService {
	
	int registerUserLicnse(UserLicenseVO vo) throws Exception;
	int deleteUserLicense(int id) throws Exception;
	int updateUserLicense(UserLicenseVO vo) throws Exception;
	
	UserLicenseVO getUserLicense(int id) throws Exception;
	List<UserLicenseVO> getAllUserLicense(int seekerId) throws Exception;
}
