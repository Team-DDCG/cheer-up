package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.Category2VO;

public interface Category2Service {
	Category2VO read(int category2Id) throws Exception; // 조회
	List<Category2VO> listAll() throws Exception; // category2
	List<String> findAllCompanyByName(String keyword) throws Exception;
}
