package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.model.ResumeCommentDAO;
import com.service.spring.service.ResumeCommentService;

@Service
public class ResumeCommentServiceImpl implements ResumeCommentService{
	
	@Autowired
	private ResumeCommentDAO resumeCommentDAO;

	@Override
	public int registerResumeComment(ResumeCommentVO vo) throws Exception {
		return resumeCommentDAO.registerResumeComment(vo);
	}

	@Override
	public int updateResumeComment(ResumeCommentVO vo) throws Exception {
		return resumeCommentDAO.updateResumeComment(vo);
	}

	@Override
	public int deleteResumeComment(int commentId) throws Exception {
		return resumeCommentDAO.deleteResumeComment(commentId);
	}
	
	

}
