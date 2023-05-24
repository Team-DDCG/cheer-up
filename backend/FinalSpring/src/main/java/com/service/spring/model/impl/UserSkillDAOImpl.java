package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserSkillVO;
import com.service.spring.model.UserSkillDAO;

@Repository
public class UserSkillDAOImpl implements UserSkillDAO {
	public static final String NS = "UserSkillMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int registerUserSkill(UserSkillVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserSkill", vo);
	}

	@Override
	public int deleteUserSkill(int id) throws Exception {
		return sqlSession.delete(NS + "deleteUserSkill", id);
	}

	@Override
	public int updateUserSkill(UserSkillVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserSkill", vo);
	}

	@Override
	public UserSkillVO getUserSkill(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserSkill", id);
	}

	@Override
	public List<UserSkillVO> getAllUserSkill(int seekerId) throws Exception {
		return sqlSession.selectList(NS + "getAllUserSkill", seekerId);
	}

}
