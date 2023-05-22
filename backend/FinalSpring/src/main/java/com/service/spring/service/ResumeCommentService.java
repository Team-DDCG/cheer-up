package com.service.spring.service;

import com.service.spring.domain.ResumeCommentVO;

public interface ResumeCommentService {
	int registerResumeComment(ResumeCommentVO vo) throws Exception;
	int updateResumeComment(ResumeCommentVO vo) throws Exception;
	int deleteResumeComment(int commentId) throws Exception;
	
	ResumeCommentVO getResumeComment(int commentId) throws Exception;
}
