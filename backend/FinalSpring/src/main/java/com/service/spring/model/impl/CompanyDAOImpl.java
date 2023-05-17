package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.CompanyVO;
import com.service.spring.model.CompanyDAO;

@Repository
public class CompanyDAOImpl implements CompanyDAO{
	
	public static final String NS = "CompanyMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerCompany(CompanyVO vo) throws Exception {
		return sqlSession.insert(NS+"registerCompany", vo);
	}

	@Override
	public int updateCompany(CompanyVO vo) throws Exception {
		return sqlSession.update(NS+"updateCompany", vo);
	}

	@Override
	public int deleteCompany(int companyId) throws Exception {
		return sqlSession.delete(NS+"deleteCompany", companyId);
	}

	

}
