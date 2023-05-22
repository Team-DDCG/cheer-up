package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.QuestionVO;
import com.service.spring.model.QuestionDAO;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
	
	public static final String NS = "QuestionMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerQuestion(QuestionVO vo) throws Exception {
		return sqlSession.insert(NS+"registerQuestion", vo);
	}

	@Override
	public int updateQuestion(QuestionVO vo) throws Exception {
		return sqlSession.update(NS+"updateQuestion", vo);
	}

	@Override
	public int deleteQuestion(int questionId) throws Exception {
		return sqlSession.delete(NS+"deleteQuestion", questionId);
	}

	@Override
	public List<QuestionVO> getQuestion(int companyId) throws Exception {
		return sqlSession.selectList(NS + "getQuestion", companyId);
	}

}
