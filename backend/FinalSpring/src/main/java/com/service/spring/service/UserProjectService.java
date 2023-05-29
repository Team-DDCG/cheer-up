package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.UserProjectVO;

public interface UserProjectService {
	
	int registerUserProject(UserProjectVO vo) throws Exception;
	int deleteUserProject(int id) throws Exception;
	int updateUserProject(UserProjectVO vo) throws Exception;
	
	UserProjectVO getUserProject(int id) throws Exception;
	List<UserProjectVO> getAllUserProject(int seekerId) throws Exception;
	int getProjectNumber(int seekerId) throws Exception;
}
