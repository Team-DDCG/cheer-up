package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.UserLicenseVO;

public interface UserLicenseDAO {
	
	int registerUserLicense(UserLicenseVO vo) throws Exception;
	int deleteUserLicense(int id) throws Exception;
	int updateUserLicense(UserLicenseVO vo) throws Exception;
	
	UserLicenseVO getUserLicense(int id) throws Exception;
	List<UserLicenseVO> getAllUserLicense(int id) throws Exception;
	int getLicenseNumber(int seekerId) throws Exception;

}
