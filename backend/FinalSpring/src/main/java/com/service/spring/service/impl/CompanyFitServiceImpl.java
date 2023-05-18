package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.CompanyFitVO;
import com.service.spring.model.CompanyFitDAO;
import com.service.spring.service.CompanyFitService;

@Service
public class CompanyFitServiceImpl implements CompanyFitService{
	
	@Autowired
	private CompanyFitDAO companyFitDAO;

	@Override
	public int registerCompanyFit(CompanyFitVO companyFit) {
		return companyFitDAO.registerCompanyFit(companyFit);
	}

	@Override
	public int deleteCompanyFit(int fitId) {
		return companyFitDAO.deleteCompanyFit(fitId);
	}

	@Override
	public int updateCompanyFit(CompanyFitVO companyFit) {
		return companyFitDAO.updateCompanyFit(companyFit);
	}

	@Override
	public CompanyFitVO getCompanyFit(int id) {
		return companyFitDAO.getCompanyFit(id);
	}

	

}
