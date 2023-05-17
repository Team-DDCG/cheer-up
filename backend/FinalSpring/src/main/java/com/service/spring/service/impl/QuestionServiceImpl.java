package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.QuestionVO;
import com.service.spring.model.QuestionDAO;
import com.service.spring.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDAO questionDAO;

	@Override
	public int registerQuestion(QuestionVO vo) throws Exception {
		return questionDAO.registerQuestion(vo);
	}

	@Override
	public int updateQuestion(QuestionVO vo) throws Exception {
		return questionDAO.updateQuestion(vo);
	}

	@Override
	public int deleteQuestion(int questionId) throws Exception {
		return questionDAO.deleteQuestion(questionId);
	}
	

}
