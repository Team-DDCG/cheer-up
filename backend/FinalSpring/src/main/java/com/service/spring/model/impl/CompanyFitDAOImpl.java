package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.CompanyFitVO;
import com.service.spring.model.CompanyFitDAO;

@Repository
public class CompanyFitDAOImpl implements CompanyFitDAO{
	public static final String NS = "CompanyFitMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registerCompanyFit(CompanyFitVO companyFit) {
		return sqlSession.insert(NS + "registerCompanyFit", companyFit);
	}

	@Override
	public int deleteCompanyFit(int fitId) {
		return sqlSession.delete(NS + "deleteCompanyFit", fitId);
	}

	@Override
	public int updateCompanyFit(CompanyFitVO companyFit) {
		return sqlSession.update(NS + "updateCompanyFit", companyFit);
	}

	@Override
	public CompanyFitVO getCompanyFit(int id) {
		return sqlSession.selectOne(NS + "getCompanyFit", id);
	}
	

}
