package com.service.spring.service;

import com.service.spring.domain.CompanyFitVO;

public interface CompanyFitService {
	int registerCompanyFit(CompanyFitVO companyFit);
    int deleteCompanyFit(int fitId);
    int updateCompanyFit(CompanyFitVO companyFit);
    CompanyFitVO getCompanyFit(int id);
}
