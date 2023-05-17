package com.service.spring.model;

import com.service.spring.domain.ResumeVO;

public interface ResumeDAO {
	
	int registerResume(ResumeVO vo) throws Exception;
	int updateResume(String resumeId) throws Exception;
	int deleteResume(ResumeVO vo) throws Exception;

}
