package com.service.spring.model.impl;

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
    public int deleteUserInfo(String id) {
        return sqlSession.delete(NS + "deleteUserInfo", id);
    }

    @Override
    public int updateUserInfo(UserInfoVO userInfo) {
        return sqlSession.update(NS + "updateUserInfo", userInfo);
    }

    @Override
    public UserInfoVO getUserInfo(String id) {
        return sqlSession.selectOne(NS + "getUserInfo", id);
    }

    @Override
    public String findUserId(String name, String phone) {
        UserInfoVO userInfo = new UserInfoVO();
        userInfo.setUserName(name);
        userInfo.setPhone(phone);
        return sqlSession.selectOne(NS + "findUserId", userInfo);
    }

    @Override
    public UserInfoVO findUserPassword(String name, String id, String email) {
        UserInfoVO userInfo = new UserInfoVO();
        userInfo.setUserName(name);
        userInfo.setId(id);
        userInfo.setEmail(email);
        return sqlSession.selectOne(NS + "findUserPassword", userInfo);
    }

    @Override
    public UserInfoVO login(UserInfoVO userInfo) {
        return sqlSession.selectOne(NS + "login", userInfo);
    }
	
}