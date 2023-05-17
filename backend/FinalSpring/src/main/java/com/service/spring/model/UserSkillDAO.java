package com.service.spring.model;

import com.service.spring.domain.UserSkillVO;

public interface UserSkillDAO {
	
	int registerUserSkill(UserSkillVO vo) throws Exception;
	int updateUserSkill(String skilllId) throws Exception;
	int deleteUserSkill(UserSkillVO vo) throws Exception;
	
	UserSkillVO getUserSkill(int id) throws Exception;

}
