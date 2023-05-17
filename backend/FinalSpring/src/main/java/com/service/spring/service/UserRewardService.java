package com.service.spring.service;

import com.service.spring.domain.UserRewardVO;

public interface UserRewardService {
	
	int registerUserReward(UserRewardVO vo) throws Exception;
	int deleteUserReward(int rewardId) throws Exception;
	int updateUserReward(UserRewardVO vo) throws Exception;
	
	UserRewardVO getUserReward(int id) throws Exception;

}
