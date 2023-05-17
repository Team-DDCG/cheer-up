package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserRewardVO;
import com.service.spring.model.UserRewardDAO;

@Repository
public class UserRewardDAOImpl implements UserRewardDAO{
	public static final String NS = "UserRewardMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerUserReward(UserRewardVO vo) throws Exception {
		return sqlSession.insert(NS + "registerUserReward", vo);
	}

	@Override
	public int deleteUserReward(int rewardId) throws Exception {
		return sqlSession.delete(NS + "deleteUserReward", rewardId);
	}

	@Override
	public int updateUserReward(UserRewardVO vo) throws Exception {
		return sqlSession.update(NS + "updateUserReward", vo);
	}

	@Override
	public UserRewardVO getUserReward(int id) throws Exception {
		return sqlSession.selectOne(NS + "getUserReward", id);
	}

}
