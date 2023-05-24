package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserSkillVO;
import com.service.spring.model.UserSkillDAO;
import com.service.spring.service.UserSkillService;

@Service
public class UserSkillServiceImpl implements UserSkillService{
	@Autowired
	private UserSkillDAO userSkillDAO;
	
	@Override
	public int registerUserSkill(UserSkillVO vo) throws Exception {
		return userSkillDAO.registerUserSkill(vo);
	}

	@Override
	public int deleteUserSkill(int id) throws Exception {
		return userSkillDAO.deleteUserSkill(id);
	}

	@Override
	public int updateUserSkill(UserSkillVO vo) throws Exception {
		return userSkillDAO.updateUserSkill(vo);
	}

	@Override
	public UserSkillVO getUserSkill(int id) throws Exception {
		return userSkillDAO.getUserSkill(id);
	}

	@Override
	public List<UserSkillVO> getAllUserSkill(int seekerId) throws Exception {
		return userSkillDAO.getAllUserSkill(seekerId);
	}
	
}
