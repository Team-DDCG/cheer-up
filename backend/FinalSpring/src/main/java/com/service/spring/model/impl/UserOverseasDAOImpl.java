package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserOverseasVO;
import com.service.spring.model.UserOverseasDAO;

@Repository
public class UserOverseasDAOImpl implements UserOverseasDAO {
	public static final String NS = "UserOverseasMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerUserOverseas(UserOverseasVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserOverseas", vo);
	}

	@Override
	public int deleteUserOverseas(int overseasId) throws Exception {
		return sqlSession.delete(NS + "deleteUserOverseas", overseasId);
	}

	@Override
	public int updateUserOverseas(UserOverseasVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserOverseas", vo);
	}

	@Override
	public UserOverseasVO getUserOverseas(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserOverseas", id);
	}

	@Override
	public List<UserOverseasVO> getAllUserOverseas(int seekerId) throws Exception {
		return sqlSession.selectList(NS + "getAllUserOverseas", seekerId);
	}
}
