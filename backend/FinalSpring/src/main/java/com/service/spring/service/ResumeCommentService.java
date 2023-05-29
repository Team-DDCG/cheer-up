package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.ResumeCommentVO;

public interface ResumeCommentService {
	int registerResumeComment(ResumeCommentVO vo) throws Exception;
	int updateResumeComment(ResumeCommentVO vo) throws Exception;
	int deleteResumeComment(int commentId) throws Exception;
	
	List<ResumeCommentVO> getResumeComment(int resumeId) throws Exception;
	int setRate(int commentId) throws Exception;
}
