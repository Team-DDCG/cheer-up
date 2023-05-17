package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.spring.domain.QuestionVO;
import com.service.spring.model.QuestionDAO;

public class QuestionDAOImpl implements QuestionDAO{
	
	public static final String NS = "CompanyMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerQuestion(QuestionVO vo) throws Exception {
		int result = sqlSession.insert(NS+"registerQuestion", vo);
		return result;
	}

	@Override
	public int updateQuestion(QuestionVO vo) throws Exception {
		int result = sqlSession.update(NS+"updateQuestion", vo);
		return result;
	}

	@Override
	public int deleteQuestion(int questionId) throws Exception {
		int result = sqlSession.delete(NS+"deleteQuestion", questionId);
		return result;
	}

}
