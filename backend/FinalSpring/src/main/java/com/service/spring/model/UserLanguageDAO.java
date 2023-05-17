package com.service.spring.model;

import com.service.spring.domain.UserCareerVO;
import com.service.spring.domain.UserLanguageVO;

public interface UserLanguageDAO {
	
	int registerUserLanguage(UserLanguageVO vo) throws Exception;
	int updateUserLanguage(String languageId) throws Exception;
	int deleteUserLanguage(UserLanguageVO vo) throws Exception;
	
	UserCareerVO getUserCareer(String id) throws Exception;

}
