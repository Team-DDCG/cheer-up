package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.UserLanguageVO;
import com.service.spring.model.UserLanguageDAO;
import com.service.spring.service.UserLanguageService;

@Service
public class UserLanguageServiceImpl implements UserLanguageService{
	@Autowired
	private UserLanguageDAO userLanguageDAO;
	
	@Override
	public int registerUserLanguage(UserLanguageVO vo) throws Exception {
		return userLanguageDAO.registerUserLanguage(vo);
	}

	@Override
	public int updateUserLanguage(UserLanguageVO vo) throws Exception {
		return userLanguageDAO.updateUserLanguage(vo);
	}

	@Override
	public int deleteUserLanguage(int languageId) throws Exception {
		return userLanguageDAO.deleteUserLanguage(languageId);
	}

	@Override
	public UserLanguageVO getUserLanguage(int id) throws Exception {
		return userLanguageDAO.getUserLanguage(id);
	}

	@Override
	public List<UserLanguageVO> getAllUserLanguage(int seekerId) throws Exception {
		return userLanguageDAO.getAllUserLanguage(seekerId);
	}

}
