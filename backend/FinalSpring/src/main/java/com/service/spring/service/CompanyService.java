package com.service.spring.service;

import java.util.List;

import com.service.spring.DTO.CompanyDataDTO;
import com.service.spring.domain.CompanyVO;

public interface CompanyService {
	int registerCompany(CompanyVO vo) throws Exception;
	int updateCompany(CompanyVO vo) throws Exception;
	int deleteCompany(int companyId) throws Exception;
	
	List<CompanyVO> getCompanyNameByCategory(int category2Id) throws Exception;
	List<CompanyVO> findAllCompanyByName(String keyword) throws Exception;
	
	List<CompanyDataDTO> getCompanyPositionByName(String companyName) throws Exception;
	CompanyVO getCompanyDataByName(String companyName) throws Exception;
}

