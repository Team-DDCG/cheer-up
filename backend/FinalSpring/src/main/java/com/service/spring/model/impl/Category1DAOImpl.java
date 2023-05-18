package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Category1VO;
import com.service.spring.model.Category1DAO;

@Repository
public class Category1DAOImpl implements Category1DAO {

	public static final String NS = "Category1Mapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public Category1VO read(int category1Id) throws Exception {
		return sqlSession.selectOne(NS + "read", category1Id);
	}

	@Override
	public List<Category1VO> listAll() throws Exception {
		return sqlSession.selectList(NS + "listAll");
	}

}