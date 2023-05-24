package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserOverseasVO;
import com.service.spring.model.UserOverseasDAO;
import com.service.spring.service.UserOverseasService;

@Service
public class UserOverseasServiceImpl implements UserOverseasService {
	@Autowired
	private UserOverseasDAO userOverseasDAO;

	@Override
	public int registerUserOverseas(UserOverseasVO vo) throws Exception {
		return userOverseasDAO.registerUserOverseas(vo);
	}

	@Override
	public int deleteUserOverseas(int overseasId) throws Exception {
		return userOverseasDAO.deleteUserOverseas(overseasId);
	}

	@Override
	public int updateUserOverseas(UserOverseasVO vo) throws Exception {
		return userOverseasDAO.updateUserOverseas(vo);
	}

	@Override
	public UserOverseasVO getUserOverseas(int id) throws Exception {
		return userOverseasDAO.getUserOverseas(id);
	}

	@Override
	public List<UserOverseasVO> getAllUserOverseas(int seekerId) throws Exception {
		return userOverseasDAO.getAllUserOverseas(seekerId);
	}
	
	

}
