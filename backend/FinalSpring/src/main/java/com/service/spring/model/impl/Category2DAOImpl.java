package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Category2VO;
import com.service.spring.model.Category2DAO;

@Repository
public class Category2DAOImpl implements Category2DAO{
	
public static final String NS = "Category2Mapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerCategory2(Category2VO vo) throws Exception {
		int result = sqlSession.insert(NS+"registerCompany", vo);
		return result;
	}

	@Override
	public int updateCategory2(Category2VO vo) throws Exception {
		int result = sqlSession.update(NS+"updateCategory2", vo);
		return result;
	}

	@Override
	public int deleteCategory2(int category2Id) throws Exception {
		int result = sqlSession.delete(NS+"deleteCategory2", category2Id);
		return result;
	}

	

}
