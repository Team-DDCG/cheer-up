package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserSchoolVO;
import com.service.spring.model.UserSchoolDAO;

@Repository
public class UserSchoolDAOImpl implements UserSchoolDAO {
	public static final String NS = "UserSchoolMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registerUserSchool(UserSchoolVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserSchool", vo);
	}

	@Override
	public int deleteUserSchool(int schoolId) throws Exception {
		return sqlSession.delete(NS + "deleteUserSchool", schoolId);
	}

	@Override
	public int updateUserSchool(UserSchoolVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserSchool", vo);
	}

	@Override
	public UserSchoolVO getUserSchool(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserSchool", id);
	}

	@Override
	public List<UserSchoolVO> getAllUserSchool(int seekerId) throws Exception {
		return sqlSession.selectList(NS + "getAllUserSchool", seekerId);
	}

}
