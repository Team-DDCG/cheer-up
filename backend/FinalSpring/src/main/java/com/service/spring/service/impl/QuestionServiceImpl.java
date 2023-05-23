package com.service.spring.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<QuestionVO> getQuestion(int companyId) throws Exception {
		return questionDAO.getQuestion(companyId);
	}


	@Override
	public List<QuestionVO> getQuestionByCompanyIdAndPosition(int companyId, String position) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyId", companyId);
        paramMap.put("position", position);
		return questionDAO.getQuestionByPosition(paramMap);
	}
	

}
