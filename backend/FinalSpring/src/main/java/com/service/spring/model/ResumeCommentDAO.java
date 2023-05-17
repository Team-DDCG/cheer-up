package com.service.spring.model;

import com.service.spring.domain.ResumeCommentVO;

public interface ResumeCommentDAO {
	
	int registerResumeComment(ResumeCommentVO vo) throws Exception;
	int updateResumeComment(String commentId) throws Exception;
	int deleteResumeComment(ResumeCommentVO vo) throws Exception;

}
