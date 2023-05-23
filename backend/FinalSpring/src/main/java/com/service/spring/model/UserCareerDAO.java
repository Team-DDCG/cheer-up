package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.UserCareerVO;

public interface UserCareerDAO {
	int registerUserCareer(UserCareerVO vo) throws Exception;
    int updateUserCareer(UserCareerVO vo) throws Exception;
    int deleteUserCareer(int carrerId) throws Exception;

    UserCareerVO getUserCareer(int carrerId) throws Exception;
    List<UserCareerVO> getAllUserCareer(int seekerId) throws Exception;
}