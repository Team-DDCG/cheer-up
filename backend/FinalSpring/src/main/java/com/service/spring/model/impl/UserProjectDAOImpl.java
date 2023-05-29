package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserProjectVO;
import com.service.spring.model.UserProjectDAO;

@Repository
public class UserProjectDAOImpl implements UserProjectDAO {
	public static final String NS = "UserProjectMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerUserProject(UserProjectVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserProject", vo);
	}

	@Override
	public int deleteUserProject(int id) throws Exception {
		return sqlSession.delete(NS + "deleteUserProject", id);
	}

	@Override
	public int updateUserProject(UserProjectVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserProject", vo);
	}

	@Override
	public UserProjectVO getUserProject(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserProject", id);
	}

	@Override
	public List<UserProjectVO> getAllUserProject(int seekerId) throws Exception {
		return sqlSession.selectList(NS + "getAllUserProject", seekerId);
	}

	@Override
	public int getProjectNumber(int seekerId) throws Exception {
		return sqlSession.selectOne(NS + "getProjectNumber", seekerId);
	}
	
}
