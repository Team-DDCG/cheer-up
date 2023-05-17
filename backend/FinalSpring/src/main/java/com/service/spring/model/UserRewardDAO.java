package com.service.spring.model;

import com.service.spring.domain.UserRewardVO;

public interface UserRewardDAO {
	
	int registerUserReward(UserRewardVO vo) throws Exception;
	int updateUserReward(String rewardId) throws Exception;
	int deleteUserReward(UserRewardVO vo) throws Exception;
	
	UserRewardVO getUserReward(String id) throws Exception;

}
