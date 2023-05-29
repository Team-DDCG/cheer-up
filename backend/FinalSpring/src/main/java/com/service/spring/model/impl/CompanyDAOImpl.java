package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.DTO.CompanyDataDTO;
import com.service.spring.domain.CompanyVO;
import com.service.spring.domain.UserSeekerVO;
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

	@Override
	public List<CompanyVO> getCompanyNameByCategory(int category2Id) throws Exception {
		return sqlSession.selectList(NS + "getCompanyNameByCategory", category2Id);
	}

	@Override
	public List<CompanyVO> findAllCompanyByName(String keyword) throws Exception {
		return sqlSession.selectList(NS + "findAllCompanyByName", keyword);
	}

	@Override
	public List<CompanyDataDTO> getCompanyPositionByName(String companyName) throws Exception {
		return sqlSession.selectList(NS + "getCompanyPositionByName", companyName);
	}

	@Override
	public CompanyVO getCompanyDataByName(String companyName) throws Exception {
		return sqlSession.selectOne(NS + "getCompanyDataByName", companyName);
	}

	@Override
	public int saveCategories(UserSeekerVO vo) throws Exception {
		return sqlSession.update(NS + "saveCategories", vo);
	}


}