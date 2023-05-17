package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Category1VO;

public interface Category1DAO {
	
	/*int registerCategory1(Category1VO vo) throws Exception; //등록
	int upateCategory1(Category1VO vo) throws Exception; //수정
	int deleteCategory1(int category1Id) throws Exception; //삭제 */	
	
	Category1VO read(int category1Id) throws Exception; //조회
	
	List<Category1VO> listAll() throws Exception; //목록
	
}
