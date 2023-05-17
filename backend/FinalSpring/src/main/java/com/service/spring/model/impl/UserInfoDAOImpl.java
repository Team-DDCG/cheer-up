package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserInfoVO;
import com.service.spring.model.UserInfoDAO;



@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
	public static final String NS = "UserInfoMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public UserInfoVO login(UserInfoVO vo) throws Exception {
		return sqlSession.selectOne(NS + "login", vo);
	}


	@Override
	public int registerUserInfo(UserInfoVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserInfo", vo);
	}


	@Override
	public int deleteUserUserInfo(int id) throws Exception {
		return sqlSession.delete(NS + "deleteUserInfo", id);
	}


	@Override
	public int updateUserInfo(UserInfoVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserInfo", vo);
	}


	@Override
	public UserInfoVO getUserInfo(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserInfo", id);
	}
	
}