package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.DTO.PositionDTO;
import com.service.spring.DTO.ResumeCommentDTO;
import com.service.spring.DTO.ResumeDTO;
import com.service.spring.DTO.ResumeQnADTO;
import com.service.spring.domain.ResumeVO;
import com.service.spring.model.ResumeDAO;
import com.service.spring.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService{
	
	@Autowired
	private ResumeDAO resumeDAO;

	@Override
	public int registerResume(ResumeVO resume) {
		return resumeDAO.registerResume(resume);
	}

	@Override
	public int deleteResume(int resumeId) {
		return resumeDAO.deleteResume(resumeId);
	}

	@Override
	public int updateResume(ResumeVO resume) {
		return resumeDAO.updateResume(resume);
	}

	@Override
	public ResumeDTO getResumeWithCompanyInfoById(int resumeId) {
		return resumeDAO.getResumeWithCompanyInfoById(resumeId);
	}

	@Override
	public List<ResumeQnADTO> getQnAByCompanyId(int companyId) {
		return resumeDAO.getQnAByCompanyId(companyId);
	}

	@Override
	public List<ResumeCommentDTO> getCommentByResume(int resumeId) {
		return resumeDAO.getCommentByResume(resumeId);
	}

	@Override
	public ResumeVO getResume(int resumeId) {
		return resumeDAO.getResume(resumeId);
	}

	@Override
	public List<ResumeDTO> getAllResumeBySeekerId(int seekerId) {
		return resumeDAO.getAllResumeBySeekerId(seekerId);
	}

	@Override
	public int togglePostCheck(int resumeId) {
		return resumeDAO.togglePostCheck(resumeId);
	}

	@Override
	public List<ResumeVO> getAllQuestionByResumeId(int resumeId) {
		return resumeDAO.getAllQuestionByResumeId(resumeId);
	}

	@Override
	public List<ResumeVO> getAllResumeByPosition(PositionDTO dto) {
		return resumeDAO.getAllResumeByPosition(dto);
	}


}
