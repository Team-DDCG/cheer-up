package com.service.spring.model;

import com.service.spring.domain.UserLanguageVO;

public interface UserLanguageDAO {
	
	int registerUserLanguage(UserLanguageVO vo) throws Exception;
	int updateUserLanguage(UserLanguageVO vo) throws Exception;
	int deleteUserLanguage(int languageId) throws Exception;
	
	UserLanguageVO getUserLanguage(int id) throws Exception;

}
