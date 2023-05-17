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
		int result = sqlSession.insert(NS+"registerResume", vo);
		return result;
	}

	@Override
	public int updateResume(ResumeVO vo) throws Exception {
		int result = sqlSession.update(NS+"updateResume", vo);
		return result;
	}

	@Override
	public int deleteResume(int resumeId) throws Exception {
		int result = sqlSession.delete(NS+"deleteResume", resumeId);
		return result;
	}
	
	

}
