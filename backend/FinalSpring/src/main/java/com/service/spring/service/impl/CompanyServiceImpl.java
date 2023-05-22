package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.CompanyVO;
import com.service.spring.model.CompanyDAO;
import com.service.spring.service.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDAO companyDAO;

	@Override
	public int registerCompany(CompanyVO vo) throws Exception {
		return companyDAO.registerCompany(vo);
	}

	@Override
	public int updateCompany(CompanyVO vo) throws Exception {
		return companyDAO.updateCompany(vo);
	}

	@Override
	public int deleteCompany(int companyId) throws Exception {
		return companyDAO.deleteCompany(companyId);
	}

	@Override
	public List<CompanyVO> getCompanyNameByCategory(int category2Id) throws Exception {
		return companyDAO.getCompanyNameByCategory(category2Id);
	}
	

}
