package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserLanguageVO;
import com.service.spring.model.UserLanguageDAO;

@Repository
public class UserLanguageDAOImpl implements UserLanguageDAO{
	public static final String NS = "UserLanguageMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerUserLanguage(UserLanguageVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserLanguage", vo);
	}

	@Override
	public int updateUserLanguage(UserLanguageVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserLanguage", vo);
	}

	@Override
	public int deleteUserLanguage(int languageId) throws Exception {
		return sqlSession.delete(NS + "deleteUserLanguage", languageId);
	}

	@Override
	public UserLanguageVO getUserLanguage(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserLanguage", id);
	}

}
