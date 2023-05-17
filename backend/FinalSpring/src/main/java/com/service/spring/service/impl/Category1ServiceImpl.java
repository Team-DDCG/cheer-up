package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Category1VO;
import com.service.spring.model.Category1DAO;
import com.service.spring.service.Category1Service;

@Service
public class Category1ServiceImpl implements Category1Service{
	
	@Autowired
	private Category1DAO category1DAO;

	@Override
	public int registerCategory1(Category1VO vo) throws Exception {
		return category1DAO.registerCategory1(vo);
	}

	@Override
	public int upateCategory1(Category1VO vo) throws Exception {
		return category1DAO.upateCategory1(vo);
	}

	@Override
	public int deleteCategory1(int category1Id) throws Exception {
		return category1DAO.deleteCategory1(category1Id);
	}
	

}
