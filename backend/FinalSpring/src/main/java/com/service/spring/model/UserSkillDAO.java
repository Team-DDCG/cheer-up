package com.service.spring.model;

import com.service.spring.domain.UserSkillVO;

public interface UserSkillDAO {
	
	int registerUserSkill(UserSkillVO vo) throws Exception;
	int deleteUserSkill(int id) throws Exception;
	int updateUserSkill(UserSkillVO vo) throws Exception;
	
	UserSkillVO getUserSkill(int id) throws Exception;

}
