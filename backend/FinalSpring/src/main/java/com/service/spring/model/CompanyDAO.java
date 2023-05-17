package com.service.spring.model;

import com.service.spring.domain.CompanyVO;

public interface CompanyDAO {
	
	int registerCompany(CompanyVO vo) throws Exception;
	int updateCompany(CompanyVO vo) throws Exception;
	int deleteCompany(String companyId) throws Exception;

}
