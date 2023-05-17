package com.service.spring.model;

import com.service.spring.domain.Category2VO;

public interface Category2DAO {
	int registerCategory2(Category2VO vo) throws Exception;
	int upateCategory2(Category2VO vo) throws Exception;
	int deleteCategory2(Category2VO vo) throws Exception;

}
