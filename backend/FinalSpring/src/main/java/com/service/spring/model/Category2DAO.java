package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Category2VO;

public interface Category2DAO {
	
	//List<Category1VO> selectCategory1() throws Exception; 
	
	/*int registerCategory2(Category2VO vo) throws Exception; //등록
	int updateCategory2(Category2VO vo) throws Exception; //수정
	int deleteCategory2(int category2Id) throws Exception; //삭제 */	
	
	Category2VO read(int category2Id) throws Exception; // 조회
	
	List<Category2VO> listAll() throws Exception; // category2
	

}
