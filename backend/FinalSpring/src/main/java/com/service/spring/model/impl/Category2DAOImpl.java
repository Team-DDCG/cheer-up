package com.service.spring.model.impl;

import java.util.List;

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
	public Category2VO read(int category2Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category2VO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
