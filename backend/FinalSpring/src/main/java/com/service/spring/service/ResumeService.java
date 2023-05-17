package com.service.spring.service;

import com.service.spring.domain.ResumeVO;

public interface ResumeService {
	
	int registerResume(ResumeVO vo) throws Exception;
	int updateResume(ResumeVO vo) throws Exception;
	int deleteResume(int resumeId) throws Exception;


}
