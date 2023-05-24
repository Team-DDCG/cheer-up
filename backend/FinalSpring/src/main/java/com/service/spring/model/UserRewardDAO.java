package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.UserRewardVO;

public interface UserRewardDAO {
	
	int registerUserReward(UserRewardVO vo) throws Exception;
	int deleteUserReward(int rewardId) throws Exception;
	int updateUserReward(UserRewardVO vo) throws Exception;
	
	UserRewardVO getUserReward(int id) throws Exception;
	List<UserRewardVO> getAllUserReward(int seekerId) throws Exception;

}
