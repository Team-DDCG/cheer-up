package com.service.spring.service;

import com.service.spring.domain.Category1VO;

public interface Category1Service {
	
	int registerCategory1(Category1VO vo) throws Exception;
	int upateCategory1(Category1VO vo) throws Exception;
	int deleteCategory1(int category1Id) throws Exception;

}
