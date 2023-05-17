package com.service.spring.model;

import com.service.spring.domain.ResumeVO;

public interface ResumeDAO {
	
	int registerResume(ResumeVO vo) throws Exception;
	int updateResume(ResumeVO vo) throws Exception;
	int deleteResume(int resumeId) throws Exception;

}
