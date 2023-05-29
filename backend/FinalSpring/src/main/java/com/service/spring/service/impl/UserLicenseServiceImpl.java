package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserLicenseVO;
import com.service.spring.model.UserLicenseDAO;
import com.service.spring.service.UserLicenseService;

@Service
public class UserLicenseServiceImpl implements UserLicenseService {
	@Autowired
	private UserLicenseDAO userLicenseDAO;
	
	@Override
	public int deleteUserLicense(int id) throws Exception {
		return userLicenseDAO.deleteUserLicense(id);
	}

	@Override
	public int updateUserLicense(UserLicenseVO vo) throws Exception {
		return userLicenseDAO.updateUserLicense(vo);
	}

	@Override
	public UserLicenseVO getUserLicense(int id) throws Exception {
		return userLicenseDAO.getUserLicense(id);
	}

	@Override
	public int registerUserLicnse(UserLicenseVO vo) throws Exception {
		return userLicenseDAO.registerUserLicense(vo);
	}

	@Override
	public List<UserLicenseVO> getAllUserLicense(int seekerId) throws Exception {
		return userLicenseDAO.getAllUserLicense(seekerId);
	}

	@Override
	public int getLicenseNumber(int seekerId) throws Exception {
		return userLicenseDAO.getLicenseNumber(seekerId);
	}

}
