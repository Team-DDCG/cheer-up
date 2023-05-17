package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.ResumeVO;
import com.service.spring.model.ResumeDAO;

@Repository
public class ResumeDAOImpl implements ResumeDAO{
	
	public static final String NS = "CompanyMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerResume(ResumeVO vo) throws Exception {
		return sqlSession.insert(NS+"registerResume", vo);
	}

	@Override
	public int updateResume(ResumeVO vo) throws Exception {
		return sqlSession.update(NS+"updateResume", vo);
	}

	@Override
	public int deleteResume(int resumeId) throws Exception {
		return sqlSession.delete(NS+"deleteResume", resumeId);
	}
	
	

}
