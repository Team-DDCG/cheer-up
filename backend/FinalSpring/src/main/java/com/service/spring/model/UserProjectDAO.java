package com.service.spring.model;

import com.service.spring.domain.UserProjectVO;

public interface UserProjectDAO {
	
	int registerUserProject(UserProjectVO vo) throws Exception;
	int deleteUserProject(int id) throws Exception;
	int updateUserProject(UserProjectVO vo) throws Exception;
	
	UserProjectVO getUserProject(int id) throws Exception;

}
