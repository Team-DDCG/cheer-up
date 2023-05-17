package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.ResumeVO;
import com.service.spring.model.ResumeDAO;
import com.service.spring.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService{
	
	@Autowired
	private ResumeDAO resumeDAO;

	@Override
	public int registerResume(ResumeVO vo) throws Exception {
		return resumeDAO.registerResume(vo);
	}

	@Override
	public int updateResume(ResumeVO vo) throws Exception {
		return resumeDAO.updateResume(vo);
	}

	@Override
	public int deleteResume(int resumeId) throws Exception {
		return resumeDAO.deleteResume(resumeId);
	}
	
	

}
