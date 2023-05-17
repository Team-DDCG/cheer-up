package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.spring.domain.CompanyVO;
import com.service.spring.model.CompanyDAO;

public class CompanyDAOImpl implements CompanyDAO{
	
	public static final String NS = "CompanyMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerCompany(CompanyVO vo) throws Exception {
		int result = sqlSession.insert(NS+"registerCompany", vo);
		return result;
	}

	@Override
	public int updateCompany(CompanyVO vo) throws Exception {
		int result = sqlSession.update(NS+"updateCompany", vo);
		return result;
	}

	@Override
	public int deleteCompany(int companyId) throws Exception {
		int result = sqlSession.delete(NS+"deleteCompany", companyId);
		return result;
	}

	

}
