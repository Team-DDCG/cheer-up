package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.domain.ResumeVO;
import com.service.spring.model.ResumeDAO;

@Repository
public class ResumeDAOImpl implements ResumeDAO{
	
	public static final String NS = "CompanyMapper.";

	@Autowired
	private SqlSession sqlSession;

    @Override
    public void registerResume(ResumeVO resume) {
        sqlSession.insert(NS + "registerResume", resume);
    }

    @Override
    public void deleteResume(int resumeId) {
        sqlSession.delete(NS + "deleteResume", resumeId);
    }

    @Override
    public void updateResume(ResumeVO resume) {
        sqlSession.update(NS + "updateResume", resume);
    }

    @Override
    public ResumeVO getResumeByPostCheck(int resumeId) {
        return sqlSession.selectOne(NS + "getResumeByPostCheck", resumeId);
    }

    @Override
    public List<ResumeVO> getQnAByCompanyId(int companyId) {
        return sqlSession.selectList(NS + "getQnAByCompanyId", companyId);
    }

    @Override
    public List<ResumeCommentVO> getCommentByResume(int resumeId) {
        return sqlSession.selectList(NS + "getCommentByResume", resumeId);
    }
	

	
	

}
