package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.Category1VO;

public interface Category1Service {
	Category1VO read(int category1Id) throws Exception; //조회
	List<Category1VO> listAll() throws Exception; //목록
}
