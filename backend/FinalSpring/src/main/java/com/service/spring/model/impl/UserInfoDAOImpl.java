package com.service.spring.model.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.UserInfoVO;
import com.service.spring.model.UserInfoDAO;



@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
	public static final String NS = "UserInfoMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
    public int registerUserInfo(UserInfoVO userInfo) {
        return sqlSession.insert(NS + "registerUserInfo", userInfo);
    }

    @Override
    public int deleteUserInfo(int id) {
        return sqlSession.delete(NS + "deleteUserInfo", id);
    }

    @Override
    public int updateUserInfo(UserInfoVO userInfo) {
        return sqlSession.update(NS + "updateUserInfo", userInfo);
    }

    @Override
    public UserInfoVO getUserInfo(int userId) {
        return sqlSession.selectOne(NS + "getUserInfo", userId);
    }


    @Override
    public String findUserPassword(Map<String, Object> paramMap) {
        return sqlSession.selectOne(NS + "findUserPassword", paramMap);
    }

    @Override
    public UserInfoVO login(UserInfoVO userInfo) {
        return sqlSession.selectOne(NS + "login", userInfo);
    }

	@Override
	public String findUserId(Map<String, Object> paramMap) {
		return sqlSession.selectOne(NS + "findUserId", paramMap);
	}
	
}