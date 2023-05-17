package com.service.spring.service;

import com.service.spring.domain.UserProjectVO;

public interface UserProjectService {
	
	int registerUserProject(UserProjectVO vo) throws Exception;
	int deleteUserProject(int id) throws Exception;
	int updateUserProject(UserProjectVO vo) throws Exception;
	
	UserProjectVO getUserProject(int id) throws Exception;

}
