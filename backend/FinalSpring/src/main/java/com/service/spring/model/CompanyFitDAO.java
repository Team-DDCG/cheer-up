package com.service.spring.model;

import com.service.spring.domain.CompanyFitVO;

public interface CompanyFitDAO {
	int registerCompanyFit(CompanyFitVO companyFit);
    int deleteCompanyFit(int fitId);
    int updateCompanyFit(CompanyFitVO companyFit);
    CompanyFitVO getCompanyFit(int id);
}
