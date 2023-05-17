package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserRewardVO;
import com.service.spring.model.UserRewardDAO;
import com.service.spring.service.UserRewardService;

@Service
public class UserRewardServiceImpl implements UserRewardService{
	@Autowired
	private UserRewardDAO userRewardDAO;

	@Override
	public int registerUserReward(UserRewardVO vo) throws Exception {
		return userRewardDAO.registerUserReward(vo);
	}

	@Override
	public int deleteUserReward(int rewardId) throws Exception {
		return userRewardDAO.deleteUserReward(rewardId);
	}

	@Override
	public int updateUserReward(UserRewardVO vo) throws Exception {
		return userRewardDAO.updateUserReward(vo);
	}

	@Override
	public UserRewardVO getUserReward(int id) throws Exception {
		return userRewardDAO.getUserReward(id);
	}

}
