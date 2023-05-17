package com.service.spring.service;

import com.service.spring.domain.CompanyVO;

public interface CompanyService {
	
	int registerCompany(CompanyVO vo) throws Exception;
	int updateCompany(CompanyVO vo) throws Exception;
	int deleteCompany(int companyId) throws Exception;

}
