package com.service.spring.model;

import com.service.spring.domain.UserProjectVO;

public interface UserProjectDAO {
	
	int registerUserProject(UserProjectVO vo) throws Exception;
	int updateUserProject(String projectId) throws Exception;
	int deleteUserProject(UserProjectVO vo) throws Exception;
	
	UserProjectVO getUserProject(String id) throws Exception;

}
