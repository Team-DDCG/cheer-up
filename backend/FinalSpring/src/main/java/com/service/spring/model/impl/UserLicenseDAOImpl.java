package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserLicenseVO;
import com.service.spring.model.UserLicenseDAO;

@Repository
public class UserLicenseDAOImpl implements UserLicenseDAO {
	public static final String NS = "UserLicenseMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registerUserLicnse(UserLicenseVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserLicense", vo);
	}

	@Override
	public int deleteUserLicense(int id) throws Exception {
		return sqlSession.delete(NS + "deleteUserLicense", id);
	}

	@Override
	public int updateUserLicense(UserLicenseVO vo) throws Exception {
		return sqlSession.update(NS + "update UserLicense", vo);
	}

	@Override
	public UserLicenseVO getUserLicense(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserLicense", id);
	}

}