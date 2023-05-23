package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserCareerVO;
import com.service.spring.model.UserCareerDAO;

@Repository
public class UserCareerDAOImpl implements UserCareerDAO {
	public static final String NS = "UserCareerMapper.";
	
	@Autowired
	private SqlSession sqlSession; 

	@Override
	public int registerUserCareer(UserCareerVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserCareer", vo);
	}

	@Override
	public int updateUserCareer(UserCareerVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserCareer", vo);
	}

	@Override
	public int deleteUserCareer(int carrerId) throws Exception {
		return sqlSession.delete(NS + "deleteUserCareer", carrerId);
	}

	@Override
	public UserCareerVO getUserCareer(int seekerId) throws Exception {
		return sqlSession.selectOne(NS + "getUserCareer", seekerId);
	}

	@Override
	public List<UserCareerVO> getAllUserCareer(int seekerId) throws Exception {
		return sqlSession.selectList(NS + "getAllUserCareer", seekerId);
	}

}
