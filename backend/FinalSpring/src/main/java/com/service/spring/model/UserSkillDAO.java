package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.UserSkillVO;

public interface UserSkillDAO {
	
	int registerUserSkill(UserSkillVO vo) throws Exception;
	int deleteUserSkill(int id) throws Exception;
	int updateUserSkill(UserSkillVO vo) throws Exception;
	
	UserSkillVO getUserSkill(int id) throws Exception;
	List<UserSkillVO> getAllUserSkill(int seekerId) throws Exception;
	int getSkillNumber(int seekerId) throws Exception;

}
