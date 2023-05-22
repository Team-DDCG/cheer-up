package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.QuestionVO;

public interface QuestionDAO {
	int registerQuestion(QuestionVO vo) throws Exception;
	int updateQuestion(QuestionVO vo) throws Exception;
	int deleteQuestion(int questionId) throws Exception;
	
	List<QuestionVO> getQuestion(int companyId) throws Exception;
}
