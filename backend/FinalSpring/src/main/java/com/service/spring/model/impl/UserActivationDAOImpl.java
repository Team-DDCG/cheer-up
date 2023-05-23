package com.service.spring.model.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserActivationVO;
import com.service.spring.model.UserActivationDAO;

@Repository
public class UserActivationDAOImpl implements UserActivationDAO{
	public static final String NS = "UserActivationMapper.";
	
	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public int registerUserActivation(UserActivationVO userActivationVO) {
		return sqlSession.insert(NS + "registerUserActivation", userActivationVO);
	}

	@Override
	public int deleteUserActivation(int activationId) {
		return sqlSession.delete(NS + "deleteUserActivation", activationId);
	}

	@Override
	public int updateUserActivation(UserActivationVO userActivationVO) {
		return sqlSession.update(NS + "updateUserActivation", userActivationVO);
	}


	@Override
	public UserActivationVO getActivationDetail(int activationId) {
		return sqlSession.selectOne(NS + "getActivationDetail", activationId);
	}

	@Override
	public List<UserActivationVO> getAllActivationById(int seekerId) {
		return sqlSession.selectList(NS + "getAllActivationById", seekerId);
	}

}
