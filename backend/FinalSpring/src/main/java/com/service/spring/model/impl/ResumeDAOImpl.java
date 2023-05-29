package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.DTO.ResumeCommentDTO;
import com.service.spring.DTO.ResumeDTO;
import com.service.spring.DTO.ResumeQnADTO;
import com.service.spring.domain.ResumeVO;
import com.service.spring.model.ResumeDAO;

@Repository
public class ResumeDAOImpl implements ResumeDAO{
	
	public static final String NS = "ResumeMapper.";

	@Autowired
	private SqlSession sqlSession;

    @Override
    public int registerResume(ResumeVO vo) {
        return sqlSession.insert(NS + "registerResume", vo);
    }

    @Override
    public int deleteResume(int resumeId) {
        return sqlSession.delete(NS + "deleteResume", resumeId);
    }

    @Override
    public int updateResume(ResumeVO vo) {
        return sqlSession.update(NS + "updateResume", vo);
    }

	@Override
	public ResumeDTO getResumeWithCompanyInfoById(int resumeId) {
		return sqlSession.selectOne(NS + "getResumeWithCompanyInfoById", resumeId);
	}

	@Override
	public List<ResumeQnADTO> getQnAByCompanyId(int companyId) {
		return sqlSession.selectList(NS + "getQnAByCompanyId", companyId);
	}

	@Override
	public List<ResumeCommentDTO> getCommentByResume(int resumeId) {
		return sqlSession.selectList(NS + "getCommentByResume", resumeId);
	}

	@Override
	public ResumeVO getResume(int resumeId) {
		return sqlSession.selectOne(NS + "getResume", resumeId);
	}

	@Override
	public List<ResumeDTO> getAllResumeBySeekerId(int seekerId) {
		return sqlSession.selectList(NS + "getAllResumeBySeekerId", seekerId);
	}

	@Override
	public int togglePostCheck(int resumeId) {
		return sqlSession.update(NS + "togglePostCheck", resumeId);
	}

	@Override
	public List<ResumeVO> getAllQuestionByResumeId(int resumeId) {
		return sqlSession.selectList(NS + "getAllQuestionByResumeId", resumeId);
	}



}
