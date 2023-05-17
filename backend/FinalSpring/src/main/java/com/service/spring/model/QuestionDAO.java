package com.service.spring.model;

import com.service.spring.domain.QuestionVO;

public interface QuestionDAO {
	
	int registerQuestion(QuestionVO vo) throws Exception;
	int updateQuestion(QuestionVO vo) throws Exception;
	int deleteQuestion(String questionId) throws Exception;

}
