package com.service.spring.model;

import com.service.spring.domain.ResumeCommentVO;

public interface ResumeCommentDAO {
	
	int registerResumeComment(ResumeCommentVO vo) throws Exception;
	int updateResumeComment(ResumeCommentVO vo) throws Exception;
	int deleteResumeComment(int commentId) throws Exception;

}
