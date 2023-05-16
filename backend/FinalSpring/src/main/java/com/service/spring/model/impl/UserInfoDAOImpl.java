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
	
}