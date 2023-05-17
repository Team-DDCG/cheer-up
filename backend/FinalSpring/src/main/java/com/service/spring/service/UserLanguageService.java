package com.service.spring.service;

import com.service.spring.domain.UserLanguageVO;

public interface UserLanguageService {
	int registerUserLanguage(UserLanguageVO vo) throws Exception;
	int updateUserLanguage(UserLanguageVO vo) throws Exception;
	int deleteUserLanguage(int languageId) throws Exception;
	
	UserLanguageVO getUserLanguage(int id) throws Exception;
}
