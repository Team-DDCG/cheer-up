package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.model.ResumeCommentDAO;

@Repository
public class ResumeCommentDAOImpl implements ResumeCommentDAO{
	
	public static final String NS = "ResumeCommentMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerResumeComment(ResumeCommentVO vo) throws Exception {
		return sqlSession.insert(NS+"registerResumeComment", vo);
	}

	@Override
	public int updateResumeComment(ResumeCommentVO vo) throws Exception {
		return sqlSession.update(NS+"updateResumeComment", vo);
	}

	@Override
	public int deleteResumeComment(int commentId) throws Exception {
		return sqlSession.delete(NS+"deleteResumeComment", commentId);
	}

	@Override
	public List<ResumeCommentVO> getResumeComment(int resumeId) throws Exception {
		return sqlSession.selectList(NS + "getResumeComment", resumeId);
	}
	
	@Override
	public int setRate(int commentId) throws Exception {
		return sqlSession.update(NS + "setRate", commentId);
	}

}
