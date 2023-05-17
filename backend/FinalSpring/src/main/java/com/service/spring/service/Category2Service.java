package com.service.spring.service;

import com.service.spring.domain.Category2VO;

public interface Category2Service {
	int registerCategory2(Category2VO vo) throws Exception;
	int updateCategory2(Category2VO vo) throws Exception;
	int deleteCategory2(int category2Id) throws Exception;

}
