package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.CompanyVO;

public interface CompanyDAO {
	
	int registerCompany(CompanyVO vo) throws Exception;
	int updateCompany(CompanyVO vo) throws Exception;
	int deleteCompany(int companyId) throws Exception;
	
	List<CompanyVO> getCompanyNameByCategory(int category2Id) throws Exception;

}