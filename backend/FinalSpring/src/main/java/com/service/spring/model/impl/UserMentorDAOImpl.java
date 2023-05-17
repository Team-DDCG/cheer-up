package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserMentorVO;
import com.service.spring.model.UserMentorDAO;

@Repository
public class UserMentorDAOImpl implements UserMentorDAO {
	public static final String NS = "UserMentorMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerUserMentor(UserMentorVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserMentor", vo);
	}

	@Override
	public int deleteUserMentor(int id) throws Exception {
		return sqlSession.delete(NS + "deleteUserMentor", id);
	}

	@Override
	public int updateUserMentor(UserMentorVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserMentor", vo);
	}

	@Override
	public UserMentorVO getUserMentor(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserMentor", id);
	}
	
	
}
