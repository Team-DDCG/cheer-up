package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.QuestionVO;

public interface QuestionService {
	int registerQuestion(QuestionVO vo) throws Exception;
	int updateQuestion(QuestionVO vo) throws Exception;
	int deleteQuestion(int questionId) throws Exception;
	
	List<QuestionVO> getQuestion(int companyId) throws Exception;
	List<QuestionVO> getQuestionByPosition(int companyId, String position) throws Exception;

}
