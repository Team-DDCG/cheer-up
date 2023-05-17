package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.model.ResumeCommentDAO;

public class ResumeCommentDAOImpl implements ResumeCommentDAO{
	
	public static final String NS = "CompanyMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerResumeComment(ResumeCommentVO vo) throws Exception {
		int result = sqlSession.insert(NS+"registerResumeComment", vo);
		return result;
	}

	@Override
	public int updateResumeComment(ResumeCommentVO vo) throws Exception {
		int result = sqlSession.update(NS+"updateResumeComment", vo);
		return result;
	}

	@Override
	public int deleteResumeComment(int commentId) throws Exception {
		int result = sqlSession.delete(NS+"deleteResumeComment", commentId);
		return result;
	}

}
