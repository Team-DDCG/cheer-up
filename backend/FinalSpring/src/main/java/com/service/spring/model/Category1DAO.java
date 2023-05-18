package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Category1VO;

public interface Category1DAO {
	Category1VO read(int category1Id) throws Exception; //조회
	List<Category1VO> listAll() throws Exception; //목록
}