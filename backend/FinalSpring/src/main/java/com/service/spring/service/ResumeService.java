package com.service.spring.service;

import java.util.List;

import com.service.spring.DTO.ResumeCommentDTO;
import com.service.spring.DTO.ResumeDTO;
import com.service.spring.DTO.ResumeQnADTO;
import com.service.spring.domain.ResumeVO;

public interface ResumeService {
	int registerResume(ResumeVO resume);
    int deleteResume(int resumeId);
    int updateResume(ResumeVO resume);
    ResumeDTO getResumeWithCompanyInfoById(int resumeId);
    ResumeVO getResume(int resumeId);
    List<ResumeQnADTO> getQnAByCompanyId(int companyId);
    List<ResumeCommentDTO> getCommentByResume(int resumeId);
    List<ResumeDTO> getAllResumeBySeekerId(int seekerId);
    int togglePostCheck(int resumeId);
    List<ResumeVO> getAllQuestionByResumeId(int resumeId);
}
