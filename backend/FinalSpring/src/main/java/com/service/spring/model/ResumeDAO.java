package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.domain.ResumeVO;

public interface ResumeDAO {
	int registerResume(ResumeVO resume);
    int deleteResume(int resumeId);
    int updateResume(ResumeVO resume);
    ResumeVO getResumeByPostCheck(int resumeId);
    List<ResumeVO> getQnAByCompanyId(int companyId);
    List<ResumeCommentVO> getCommentByResume(int resumeId);
}