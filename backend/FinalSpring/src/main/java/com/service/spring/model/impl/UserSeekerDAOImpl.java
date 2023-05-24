package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserSeekerVO;
import com.service.spring.model.UserSeekerDAO;

@Repository
public class UserSeekerDAOImpl implements UserSeekerDAO {
	public static final String NS = "UserSeekerMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registerUserSeeker(UserSeekerVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserSeeker", vo);
	}

	@Override
	public int deleteUserSeeker(int id) throws Exception {
		return sqlSession.delete(NS + "deleteUserSeeker", id);
	}

	@Override
	public int updateUserSeeker(UserSeekerVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserSeeker", vo);
	}

	@Override
	public UserSeekerVO getUserSeeker(int userId) throws Exception {
		return sqlSession.selectOne(NS + "getUserSeeker", userId);
	}

}
