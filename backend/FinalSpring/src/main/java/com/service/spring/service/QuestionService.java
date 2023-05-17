package com.service.spring.service;

import com.service.spring.domain.QuestionVO;

public interface QuestionService {
	
	int registerQuestion(QuestionVO vo) throws Exception;
	int updateQuestion(QuestionVO vo) throws Exception;
	int deleteQuestion(int questionId) throws Exception;

}
