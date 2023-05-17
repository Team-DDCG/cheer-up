package com.service.spring.service;

import com.service.spring.domain.UserSkillVO;

public interface UserSkillService {
	
	int registerUserSkill(UserSkillVO vo) throws Exception;
	int deleteUserSkill(int id) throws Exception;
	int updateUserSkill(UserSkillVO vo) throws Exception;
	
	UserSkillVO getUserSkill(int id) throws Exception;

}