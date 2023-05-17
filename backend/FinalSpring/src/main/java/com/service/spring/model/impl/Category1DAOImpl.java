package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Category1VO;
import com.service.spring.model.Category1DAO;

@Repository
public class Category1DAOImpl implements Category1DAO{
	
	public static final String NS = "Category1Mapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerCategory1(Category1VO vo) throws Exception {
		return sqlSession.insert(NS+"registerCategory1", vo);
		
	}

	@Override
	public int upateCategory1(Category1VO vo) throws Exception {
		return sqlSession.update(NS+"upateCategory1", vo);
	}

	@Override
	public int deleteCategory1(int category1Id) throws Exception {
		return sqlSession.delete(NS+"deleteCategory1", category1Id);
	}

	

}
